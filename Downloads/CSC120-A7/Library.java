/* This is a stub for the Library class */
import java.util.Hashtable;
public class Library extends Building implements LibraryRequirements{
  private Hashtable<String, Boolean> collection;
  public Library(String name,String address,int nFloors) {
    super(name,address,nFloors);
    this.collection=new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  public void addTitle(String title){
    this.collection.put(title,true);
  }
  public String removeTitle(String title){
    if(this.collection.containsKey(title)){
      this.collection.remove(title);
      return title;
    } else{
      throw new RuntimeException("Error: title not found.");
    }
  }
  public void checkOut(String title){
    if(this.collection.containsKey(title)){
      if(this.collection.get(title)==true){
        this.collection.put(title,false);
      } else{
        throw new RuntimeException("Title not in stock. Come back later?");
      }
    } else{
      throw new RuntimeException("Error: title not found.");
    }
  }
  public void returnBook(String title){
    if(this.collection.containsKey(title)){
      if(this.collection.get(title)==false){
        this.collection.put(title,true);
      }else {
        throw new RuntimeException("Error: Title already in stock.");
      }
    } else {
      throw new RuntimeException("Error: You returned a book with invalid title.");
    } 
  }
  public boolean containsTitle(String title){
    
    return this.collection.containsKey(title);
  }
  public boolean isAvailable(String title){
    if(this.containsTitle(title)){
      return this.collection.get(title);
    } else{
      throw new RuntimeException("Error: title not in collection.");
    }
  }
  public boolean printCollection(){
    for (String key:collection.keySet()){
      System.out.println(key+": "+collection.get(key));
    }
    return true;
  }
  public static void main(String[] args) {
    Library neilson=new Library("Neilson","1 Neilson Drive",4);
  }
}