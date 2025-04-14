/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  // attributes
  private boolean hasDiningRoom; 
  private ArrayList<Student> students;
  /**
   * constructor
   * @param String name, String address, int nFloors
   */
  public House(String name,String address,int nFloors,boolean hasDiningRoom) {
    super(name,address,nFloors);
    this.hasDiningRoom=hasDiningRoom;
    this.students=new ArrayList<>();
    System.out.println("You have built a house: 🏠");
  }
  /**
   * hasDiningRoom()
   * @param none
   * @return boolean value
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  /**
   * nResidents()
   * @return int nResidents
   */
  public int nResidents(){
    return this.students.size();
  }
  /**
   * moveIn(Student s)
   * @param Student s
   */
  public void moveIn(Student s){
    // add new student to the ArrayList
    this.students.add(s);
    // modify residents number
  }
  /**
   * moveOut(Student s)
   * @param Student s
   * @return Student s
   */
  public Student moveOut(Student s){
    // only works if student already in house
    if(this.students.contains(s)){
      this.students.remove(s);
      // modify residents number
      return s;
    } else{
      throw new RuntimeException("Error: student not found.");
    }
  }
  /**
   * isResident(Student s)
   * @param Student s
   * @return boolean value
   */
  public boolean isResident(Student s){
    if(this.students.contains(s)){
      return true;
    } else{
      return false;
    }
  }
  public static void main(String[] args) {

    House hubbard=new House("Hubbard","3 Green Street",4,false);
    Student josephine=new Student("Josephine","991479716",2028);
    hubbard.moveIn(josephine);
    System.out.println(hubbard.isResident(josephine));
    hubbard.moveOut(josephine);
    System.out.println(hubbard.isResident(josephine));
  }

}