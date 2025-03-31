/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  public boolean hasDiningRoom; 
  public int nResidents; 
  public ArrayList<Student> students;
  public House(String name,String address,int nFloors) {
    super(name,address,nFloors);
    this.hasDiningRoom=true;
    this.students=new ArrayList<>();
    this.nResidents=0;
    System.out.println("You have built a house: 🏠");
  }
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  public int nResidents(){
    return this.nResidents;
  }
  public void moveIn(Student s){
    this.students.add(s);
    this.nResidents+=1;
  }
  public Student moveOut(Student s){
    if(this.students.contains(s)){
      this.students.remove(s);
      return s;
    } else{
      throw new RuntimeException("Error: student not found.");
    }
  }
  public boolean isResident(Student s){
    if(this.students.contains(s)){
      return true;
    } else{
      return false;
    }
  }
  public static void main(String[] args) {

    new House("Hubbard","3 Green Street",4);
  }

}