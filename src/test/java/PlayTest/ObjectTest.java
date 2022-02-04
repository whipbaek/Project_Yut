package PlayTest;

import MYProject.Yut.Play.Location;
import MYProject.Yut.Play.Mal;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ObjectTest {

    @Test
    public void objectTest() {
        A a = new A(4);

    }
}

 class A{
    int numofB;
    public ArrayList<B> mals = new ArrayList<>();

     public A(int numofB) {
         this.numofB = numofB;
         MakeB();
     }

     private void MakeB(){
         for(int i=0; i<numofB; i++){
            mals.add(i,new B());
             System.out.println(i + " 번째 말 생성");
         }
     }

     public int getNumofB() {
         return numofB;
     }

     public void setNumofB(int numofB) {
         this.numofB = numofB;
     }

     public ArrayList<B> getMals() {
         return mals;
     }

     public void setMals(ArrayList<B> mals) {
         this.mals = mals;
     }
 }

 
 
 class B{
    Location location;

     public B(Location location) {
         this.location = location;
     }

     public B(){
         this.location = new Location(30,30);
     }

     public void setLocation(Location location) {
         this.location = location;
     }

     public Location getLocation() {
         return location;
     }
 }
