package MYProject.Yut.Play;

import java.util.Random;

public class Yut {

//    public Yut_Grade getYutValue(){
//        return Yut_Grade.values()[new Random().nextInt(Yut_Grade.values().length)];
//    }

    public Yut_Grade getYutValue(){
        return rollingYut();
    }

    private Yut_Grade rollingYut(){ //4개의 윷을 던진다. 앞,뒤 각각 50프로 확률
        int count=0;
        boolean back=false;
        for(int i=0;i<4;i++){
            double temp =  Math.random();
            System.out.println("temp = " + temp);
            if(temp > 0.5){
                count++;
                if(i==3) back=true; //4번째 말에 x표시 되어있음(백도 유무)
            }
        }

        Yut_Grade val = Yut_Grade.도;

        if(count ==1){
            if(back) val = Yut_Grade.백도;
            else val = Yut_Grade.도;
        }

        else if(count == 2) val = Yut_Grade.개;
        else if(count == 3) val = Yut_Grade.걸;
        else if(count == 4) val = Yut_Grade.윷;
        else if(count == 0) val = Yut_Grade.모;

        return val;
    }

}


