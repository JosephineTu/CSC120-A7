/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building implements LibraryRequirements{
  // attributes
  private Hashtable<String, Boolean> collection;
  /**
 * constructor
 * @param String name, String address, int nFloors
 * @return none
 */
  public Library(String name,String address,int nFloors) {
    super(name,address,nFloors);
    this.collection=new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  /**
   * addTitle(String title)
   * @ param String title
   */
  public void addTitle(String title){
    this.collection.put(title,true);
  }
  
  /*
   * removeTitle(String title)
   * @param String title
   * @return title
   */
  public String removeTitle(String title){
    if(this.collection.containsKey(title)){
      this.collection.remove(title);
      return title;
    } else{
      // check if the hashtable contains the title
      throw new RuntimeException("Error: title not found.");
    }
  }
  /* checkOut(String title)
   * @param String title
   */
  public void checkOut(String title){
    if(this.collection.containsKey(title)){
      // only checkout if title is in hashtable and value equals to true
      if(this.collection.get(title)==true){
        this.collection.put(title,false);
      } else{
        throw new RuntimeException("Title not in stock. Come back later?");
      }
    } else{
      throw new RuntimeException("Error: title not found.");
    }
  }
  /**
   * returnBook (String title)
   * @param String title
   */
  public void returnBook(String title){
    if(this.collection.containsKey(title)){
      // only return if title is in hashtable and value equals to false
      if(this.collection.get(title)==false){
        this.collection.put(title,true);
      }else {
        throw new RuntimeException("Error: Title already in stock.");
      }
    } else {
      throw new RuntimeException("Error: You returned a book with invalid title.");
    } 
  }
  /**
   * containsTitle(String title)
   * @param String title
   * @return boolean value
   */
  public boolean containsTitle(String title){
    
    return this.collection.containsKey(title);
  }
  public boolean isAvailable(String title){
    //confirm that the hashtable contains the value
    if(this.containsTitle(title)){
      return this.collection.get(title);
    } else{
      throw new RuntimeException("Error: title not in collection.");
    }
  }
  /**
   * printCollection()
   * @param none
   * @return boolean value (default true)
   */
  public void printCollection(){
    // iterate through the hashtable
    for (String key:collection.keySet()){
      //convert the pairs to a String 
      System.out.println(key+": "+collection.get(key));
    }
  }
  public static void main(String[] args) {
    Library neilson=new Library("Neilson","1 Neilson Drive",4);
    neilson.addTitle("A");
    neilson.addTitle("B");
    neilson.addTitle("C");
    neilson.checkOut("B");
    neilson.printCollection();
    neilson.returnBook("B");
    neilson.removeTitle("C");
    neilson.printCollection();
  }
}