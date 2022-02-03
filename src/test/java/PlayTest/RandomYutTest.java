package PlayTest;

import MYProject.Yut.Play.Yut;
import MYProject.Yut.Play.Yut_Grade;
import org.junit.jupiter.api.Test;

public class RandomYutTest {

    @Test
    public void randomYutTest() {
        Yut yut = new Yut();
        for(int i=0; i<5; i++) {
            Yut_Grade yutValue = yut.getYutValue();
            System.out.println("yutValue = " + yutValue);
        }
    }
}
