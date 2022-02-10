package MYProject.Yut.Play;

public class Yut {

    public Yut_Grade rollingYut(){ //4개의 윷을 던진다. 앞,뒤 각각 50프로 확률
        int count=0;
        boolean back=false;

        for(int i=0;i<4;i++){
            count = pluscount(count);
            if(i==3) back=true; //4번째 말에 x표시 되어있음(백도 유무)
            }

        return valbycount(count,back);
    }

    private int pluscount(int count){ //count를 증가한다.
        if(Math.random()>0.5) return count+=1;
        return count;
    }

    private Yut_Grade valbycount (int count, boolean back){ //Yut_Grade를 반환한다.
        if(count == 1){
            if(back) return Yut_Grade.백도;
            return Yut_Grade.도;
        }

        if(count == 2) return Yut_Grade.개;
        if(count == 3) return Yut_Grade.걸;
        if(count == 4) return Yut_Grade.윷;
        if(count == 5) return Yut_Grade.모;

        return null;
    }

}


