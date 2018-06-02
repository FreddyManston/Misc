import java.util.*;
import java.io.*;

public class HuffmanEncoding {
  public static void main(String[] args) {
    try {
      File text_file = new File("ulysses.text");
      FileInputStream text_input = new FileInputStream(text_file);
      byte [] text_data = new byte[(int) text_file.length()];
      text_input.read(text_data);
      text_input.close();
      String book = new String(text_data, "UTF-8");
        
      int[] counts = getCharacterFrequency(book); // Count frequency

      Tree tree = getHuffmanTree(counts); // Create a Huffman tree
      String[] codes = getCode(tree.root); // Get codes
      
      printTable(counts, codes);  // Print the table of frequencies and codes etc.
      String code_file_name = "UlyssesHuffCode.text";
      String sub_book = book.substring(0, 10000);
      String decoded_noisey_book = "";
      double ratio = 0.0;
      double ratio_sum = 0.0;
      double mean = 0.0;
      double std_ratio_sum = 0.0;
      double std_mean = 0.0;
      double std = 0.0;
      ArrayList <Double> ratio_list = new ArrayList <Double> ();

      // Doing the comparisons and working out the mean:
      for (int i = 0; i < 30; i ++) {
        System.out.print(i + ": ");
        printToFile(sub_book, codes, code_file_name);
        decoded_noisey_book = readFromFile(code_file_name, tree);     
        ratio = getRatio(sub_book, decoded_noisey_book);
        ratio_sum += ratio;
        ratio_list.add(ratio);
      } mean = ratio_sum / 30;

      // Working out the standard deviation:
      for (int i = 0; i < 30; i ++) {
        ratio_list.set(i, Math.pow(ratio_list.get(i) - mean, 2));
        std_ratio_sum += ratio_list.get(i);
      } std = Math.pow((std_ratio_sum / 30), 0.5);

      System.out.println("Mean: " + mean + "\nStandard Deviation: " + std);
    }
    catch (Exception e) { e.printStackTrace(); }
  }

  /** Read the coded text into readable text, from a file */
  public static String readFromFile (String file_name, Tree tree) {
    try {
      File text_file = new File(file_name);
      FileInputStream text_input = new FileInputStream(text_file);
      byte [] text_data = new byte[(int) text_file.length()];
      text_input.read(text_data);
      text_input.close();
      String huff_code = new String(text_data, "UTF-8");
      String text = decode(huff_code, tree);
      return text;
    }
    catch (IOException e) { e.printStackTrace(); return "";}
  }

  /** Print the coded text, upto a certain character, to a file */
  public static void printToFile(String text, String[] codes, String file_name) {
    String code_text = getCodeRecursively(text, codes);
    code_text = applyNoiseToCode(code_text);

    BufferedWriter output = null;
    try {
      File file = new File(file_name);
      output = new BufferedWriter(new FileWriter(file));
      output.write(code_text);
      output.close();
      System.out.println("\nCode written to the file: '" + file_name + "'.");
    } 
    catch ( IOException e ) { e.printStackTrace(); }
  }

  /** Add noise into the coded text */
  public static String applyNoiseToCode(String code) {
    int switch_index = 0;

    for (int i = 1; i < code.length()/1000; i ++) {
      for (int j = 0; j < 8; j ++) {
        //System.out.println(i);
        switch_index = (i % 1000) * ((int) (Math.random() * 1000));

        if (code.charAt(switch_index) == '0') {
          code = code.substring(0,switch_index) + '1' + code.substring(switch_index + 1);
        }
        else {
          code = code.substring(0,switch_index) + '0' + code.substring(switch_index + 1);
        }
      }
    }
    return code;
  }
  
  /** Get the ratio of recovered code:destroyed code */
  public static double getRatio(String clean_text, String dirty_text) {
    int clean_len = clean_text.length();
    int dirty_len = dirty_text.length();
    int i = 0;
    double recovd = 0.0;
    double destr = 0.0;
  
    if (clean_len <= dirty_len) {
      while (i < clean_len) {
        if (clean_text.charAt(i) != dirty_text.charAt(i)) { destr ++; }
        else if (clean_text.charAt(i) == dirty_text.charAt(i)) { recovd ++; }
        else { System.out.println("Error in getRatio() method."); }
        i ++;
      }
      return (recovd / (destr + (dirty_len - i)));
    }
    else {
      while (i < dirty_len) {
        if (clean_text.charAt(i) != dirty_text.charAt(i)) { destr ++; }
        else if (clean_text.charAt(i) == dirty_text.charAt(i)) { recovd ++; }
        else { System.out.println("Error in getRatio() method."); }
        i ++;
      }
      return (recovd / (destr + (clean_len - i))); 
    }
  }
  
  /** Return the text in coded form */
  public static String getStringCode(String str, int numChars, String[] codes) {
    String coded_text = "";
    for (int i = 0; i < numChars; i ++) {
      coded_text = coded_text + codes [(int) str.charAt(i)]; 
    }
    return coded_text;
  }
  
  /** Return the text in coded form */
  public static String getCodeRecursively(String str, String[] codes) {
    if (str.length() == 1){
      return codes[(int)str.charAt(0)];
    }
    int mid = str.length()/2;
    String left = str.substring(0,mid);
    String right = str.substring(mid,str.length());
    return getCodeRecursively(left,codes) + getCodeRecursively(right,codes);
  }
  
  /** Return a coded text in readable form */
  public static String decode(String huff_code, Tree tree) {
    String text = "";
    int i = 0;
    char route = 'b';
    Tree.Node root = tree.root;
    
    while (i < huff_code.length()) {
      route = huff_code.charAt(i);
      
      if (route == '0' && root.left != null) { root = root.left; }
      else if (route == '1' && root.right != null) { root = root.right; }
      else {        
        text = text + root.element;
        root = tree.root;
        i --;
      } 
      i ++;
    }
    return text;
  }

  /** Get Huffman codes for the characters 
   * This method is called once after a Huffman tree is built
   */
  public static String[] getCode(Tree.Node root) {
    if (root == null) return null;    
    String[] codes = new String[256];
    assignCode(root, codes);
    return codes;
  }
  
  /* Recursively get codes to the leaf node */
  private static void assignCode(Tree.Node root, String[] codes) {
    if (root.left != null) {
      root.left.code = root.code + "0";
      assignCode(root.left, codes);
      
      root.right.code = root.code + "1";
      assignCode(root.right, codes);
    }
    else {
      codes[(int)root.element] = root.code;
    }
  }
  
  /** Get a Huffman tree from the codes */  
  public static Tree getHuffmanTree(int[] counts) {
    // Create a heap to hold trees
    Heap<Tree> heap = new Heap<Tree>(); // Defined in Listing 24.10
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > 0)
        heap.add(new Tree(counts[i], (char)i)); // A leaf node tree
    }
    
    while (heap.getSize() > 1) { 
      Tree t1 = heap.remove(); // Remove the smallest weight tree
      Tree t2 = heap.remove(); // Remove the next smallest weight 
      heap.add(new Tree(t1, t2)); // Combine two trees
    }

    return heap.remove(); // The final tree
  }
  
  /** Get the frequency of the characters */
  public static int[] getCharacterFrequency(String text) {
    int[] counts = new int[256]; // 256 ASCII characters
    
    for (int i = 0; i < text.length(); i++)
      counts[(int)text.charAt(i)]++; // Count the character in text
    
    return counts;
  }
  /** Print the table of ASCII, Character, Frequency, Code */
  public static void printTable(int[] counts, String[] codes) {
    System.out.printf("\n%-15s%-15s%-15s%-15s\n\n", 
      "ASCII Code", "Character", "Frequency", "Code");

    for (int i = 0; i < codes.length; i++)
      if (counts[i] != 0) // (char)i is not in text if counts[i] is 0
        if (i == 10) {
          System.out.printf("%-15d%-15s%-15d%-15s\n", 
            i, "newline", counts[i], codes[i]);
        }
        else if (i == 32){
          System.out.printf("%-15d%-15s%-15d%-15s\n", 
            i, "space", counts[i], codes[i]);
        }
        else {
          System.out.printf("%-15d%-15s%-15d%-15s\n", 
            i, (char)i + "", counts[i], codes[i]);
        }
  }
  
  /** Define a Huffman coding tree */
  public static class Tree implements Comparable<Tree> {
    Node root; // The root of the tree

    /** Create a tree with two subtrees */
    public Tree(Tree t1, Tree t2) {
      root = new Node();
      root.left = t1.root;
      root.right = t2.root;
      root.weight = t1.root.weight + t2.root.weight;
    }
    
    /** Create a tree containing a leaf node */
    public Tree(int weight, char element) {
      root = new Node(weight, element);
    }
    
    @Override /** Compare trees based on their weights */
    public int compareTo(Tree t) {
      if (root.weight < t.root.weight) // Purposely reverse the order
        return 1;
      else if (root.weight == t.root.weight)
        return 0;
      else
        return -1;
    }

    public class Node {
      char element; // Stores the character for a leaf node
      int weight; // weight of the subtree rooted at this node
      Node left; // Reference to the left subtree
      Node right; // Reference to the right subtree
      String code = ""; // The code of this node from the root

      /** Create an empty node */
      public Node() {
      }
      
      /** Create a node with the specified weight and character */
      public Node(int weight, char element) {
        this.weight = weight;
        this.element = element;
      }
    }
  }  
}

