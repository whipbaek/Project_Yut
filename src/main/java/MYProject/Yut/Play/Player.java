package MYProject.Yut.Play;

import java.util.ArrayList;

import static MYProject.Yut.Play.Mal.group_num;

public class Player {
    private int numofmal;
    private ArrayList<Mal> mals = new ArrayList<>();
    private Move move;

    public Player(int numofmal) { //말을 셋팅한다.
        this.numofmal = numofmal;
        MakeMal();
        move = new Move();
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
        System.out.print("현재 지니고 있는 말 : ");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (!mal.isArrive()) { //도착하지 않았다면
                System.out.print(i + " ");
            }
        }
        System.out.println();


        System.out.print("필드에 존재하는 말 : ");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.getBeforelocatoin() != null) { //필드에 존재하는 말
                if(!mal.isArrive()) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();

        System.out.print("도착한 말 : ");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.isArrive()) { //필드에 존재하는 말
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public int getNumOfFieldMals(){
        int num = numofmal;
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.getBeforelocatoin() == null) { //필드에 존재하지 않으면
                if(!mal.isArrive()) {
                    num--;
                }
            }
        }
        return num;
    }

    public int numOfSameGroup(Mal mal){
        int initial_num = 1; //
        for(int i=0; i<numofmal; i++){
            if(mal.getGroup() > 0 && mal != mals.get(i)) { //그룹에 속해있으며, 그룹이 없을때는 1을 반환하기위해 본인은 제외함
                if (mal.getGroup() == mals.get(i).getGroup()) {
                    initial_num++;
                }
            }
        }
        return initial_num;
    }

    public void PlayerChangeMal(Mal mal, Yut_Grade yut_grade){
        for(int i=0; i<numofmal; i++) {
            if (mal.getGroup() > 0) {//그룹이 존재한다면
                if (mal.getGroup() == mals.get(i).getGroup()){//그룹이 같은 말들 모두 이동시킨다.
                    move.ChangeMal(mals.get(i),yut_grade);
                }
            }
            else{ //그룹이 존재하지 안는다면
                move.ChangeMal(mal,yut_grade);
                break;
            }
        }

        PiggyBack(mal); //이동한 후에 그위치에 같은 말이 있는지 검사한다. (업기 기능)
    }

    private void PiggyBack(Mal mal) {
        for(int i=0; i<mals.size(); i++) {
            if (mal == mals.get(i)) continue;

            if (mal.getBeforelocatoin() != null) {
                if (mal.getLocation().getX() == mals.get(i).getLocation().getX() &&
                        mal.getLocation().getY() == mals.get(i).getLocation().getY()) {
                    System.out.println("말을 업습니다.");
                    mal.setGroup(group_num);
                    mals.get(i).setGroup(group_num);
                }
            }
        }
        group_num++;
    }
}
