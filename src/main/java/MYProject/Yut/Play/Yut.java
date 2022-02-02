package MYProject.Yut.Play;

import java.util.Random;

public class Yut {

    public Yut_Grade getYutValue(){
        return Yut_Grade.values()[new Random().nextInt(Yut_Grade.values().length)];
    }
}
