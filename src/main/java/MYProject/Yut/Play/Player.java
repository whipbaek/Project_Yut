package MYProject.Yut.Play;

import java.util.ArrayList;

public class Player {
    private int numofmal;
    private ArrayList<Mal> mals = new ArrayList<>();

    public Player(int numofmal) { //말을 셋팅한다.
        this.numofmal = numofmal;
        MakeMal();
    }

    private void MakeMal() { //말을 생성한다.
        for (int i = 0; i < numofmal; i++) {
            mals.add(i, new Mal());
        }
    }

    public int getNumofmal() {
        return numofmal;
    }

    public void setNumofmal(int numofmal) {
        this.numofmal = numofmal;
    }

    public ArrayList<Mal> getMals() {
        return mals;
    }

    public void setMals(ArrayList<Mal> mals) {
        this.mals = mals;
    }

    public void ShowMalsInfo() {
        System.out.print("현재 지니고 있는 말 :");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (!mal.isArrive()) { //도착하지 않았다면
                System.out.print(i + " ");
            }
        }
        System.out.println();


        System.out.print("필드에 존재하는 말 :");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.getBeforelocatoin() != null) { //필드에 존재하는 말
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.print("도착한 말 :");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.isArrive()) { //필드에 존재하는 말
                System.out.print(i + " ");
            }
        }
        System.out.println();


    }
}
