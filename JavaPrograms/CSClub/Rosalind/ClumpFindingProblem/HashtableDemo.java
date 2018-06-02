/*
Hashtable implements a key value pair kind of collection
*/
import java.util.*;
public class HashtableDemo {
  static String newLine = System.getProperty("line.separator");
  public static void main(String[] args) {
  
    System.out.println(newLine + "Hashtable in Java" + newLine);
    System.out.println("-----------------------" + newLine);
    System.out.println("Adding items to the Hashtable" + newLine);
    //Creating Hashtable object
    //dictionary can be created using HashTable object
    //as dictionary is an abstract class
    Hashtable ht = new Hashtable();
    
    //you add elements to Hashtable using put method
    //put(key, value)
    ht.put("Java", 1);
    ht.put(".NET", 2);
    ht.put("Javascript", 3 );
    ht.put("HTML", 4);
    
    //You will see that the items will be arranged as per the hash function
    System.out.println(newLine + "Items in the Hashtable..." + ht + newLine);
    System.out.println("-----------------------" + newLine);
    
    //looping through all the elements in hashtable
    String str;
    //you can retrieve all the keys in hashtable using .keys() method
    Enumeration names = ht.keys();
      while(names.hasMoreElements()) {
          //next element retrieves the next element in the dictionary
         str = (String) names.nextElement();
         //.get(key) returns the value of the key stored in the hashtable
         System.out.println(str + ": " + ht.get(str) + newLine);
      }
  }
}
