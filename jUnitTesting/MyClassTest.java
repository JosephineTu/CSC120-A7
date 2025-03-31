import org.junit.*;
import static org.junit.Assert.*;


public class MyClassTest{
    @Test
    public void testToCaps(){
        MyClass myClass=new MyClass();
        String s="josephine";
        assertEquals(s.toUpperCase(),myClass.toCaps(s));
    }
    
public static void main(String args[]){
    MyClassTest test=new MyClassTest();
    test.testToCaps();
}
}
