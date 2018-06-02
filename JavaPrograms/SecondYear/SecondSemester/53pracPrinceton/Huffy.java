import java.util.Scanner;
import java.io.*;

public class Huffy {
  public static void main(String[] args) {
    try {	
	    File text_file = new File("thecatlonger.text");
	    FileInputStream text_input = new FileInputStream(text_file);
	    byte [] text_data = new byte[(int) text_file.length()];
	    text_input.read(text_data);
	    text_input.close();
	    String book = new String(text_data, "UTF-8");
	    System.out.println(book);
	    int[] counts = getCharacterFrequency(book); // Count frequency
      Tree tree = getHuffmanTree(counts); // Create a Huffman tree
      String[] codes = getCode(tree.root); // Get codes
       
      String huffed_text = getStringCode(book, codes);
      System.out.println(huffed_text);
      System.out.println(codes [(int) 'a']);
      String text = decode(huffed_text, tree);
      System.out.println(text);
    }
	  catch (Exception e) { e.printStackTrace(); }
  }

  public static String getStringCode(String str, String[] codes) {
  	String coded_text = "";
  	for (int i = 0; i < str.length(); i ++) { coded_text = coded_text + codes [(int) str.charAt(i)]; }
  	return coded_text;
  }
  
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

