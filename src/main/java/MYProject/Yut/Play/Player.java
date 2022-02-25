package MYProject.Yut.Play;

import java.util.ArrayList;

public class Player extends Mal {
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

    public void ShowMalsIhave() {
        System.out.print("현재 지니고 있는 말 : ");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (!mal.isArrive()) { //도착하지 않았다면
                System.out.print(i + " ");
            }
        }
    }

    public void ShowMalsInField() {
        System.out.print("필드에 존재하는 말 : ");
        for (int i = 0; i < numofmal; i++) {
            if (mals.get(i).isExistMalInField()) { //필드에 존재하는 말
                System.out.print(i + " ");
            }
        }
    }

    public boolean isExsitanymalsinfield(){
        for(Mal mal : mals){
            if(mal.isExistMalInField()) return true;
        }
        return false;
    }

    public void ShowMalsArrived() {
        System.out.print("도착한 말 : ");
        for (int i = 0; i < numofmal; i++) {
            Mal mal = mals.get(i);
            if (mal.isArrive()) { //필드에 존재하는 말
                System.out.print(i + " ");
            }
        }
    }

    public void ShowAllMalsInfo() {
        ShowMalsIhave();
        System.out.println();
        ShowMalsInField();
        System.out.println();
        ShowMalsArrived();
        System.out.println();
    }

    public void ShowAllMalLocation() {
        for (int i = 0; i < numofmal; i++) {
            System.out.println(i + "번째 말의 위치 : [" + mals.get(i).getLocation().getX() +
                    "," + mals.get(i).getLocation().getY() + "]");
        }

    }


    public int getNumOfFieldMals() { //필드에 존재하는 말들의 개수를 반환한다.
        int num = 0;

        for (int i = 0; i < numofmal; i++) {
            if (mals.get(i).isExistMalInField()) num++;
        }
        return num;
    }

    public int numOfSameGroup(Mal mal) { //말중 같은 그룹이 몇개있는지 반환한다.
        int initial_num = 1;

        for (int i = 0; i < numofmal; i++) {
            if (mal.getGroup() > 0 && mal != mals.get(i)) { //그룹에 속해있으며, 그룹이 없을때는 1을 반환하기위해 본인은 제외함
                if (mal.isSameGroup(mals.get(i))) {
                    initial_num++;
                }
            }
        }
        return initial_num;
    }


    public boolean PlayerChangeMal(Mal mal, Yut_Grade yut_grade, ArrayList<Player> players) {
        for (int i = 0; i < numofmal; i++) {
            if (mal.getGroup() > 0) {//그룹이 존재한다면
                if (mal.getGroup() == mals.get(i).getGroup()) {//그룹이 같은 말들 모두 이동시킨다.
                    move.ChangeMal(mals.get(i), yut_grade);
                }
            } else { //그룹이 존재하지 안는다면
                move.ChangeMal(mal, yut_grade);
                break;
            }
        }

        PiggyBack(mal); //이동한 후에 그위치에 같은 말이 있는지 검사한다. (업기 기능)
        System.out.println("말 beforelocation : " + mal.getBeforelocatoin().getX() + ", " + mal.getBeforelocatoin().getY());
        return GetTargetMal(mal, players);

    }

    private void PiggyBack(Mal mal) {
        for (int i = 0; i < mals.size(); i++) {
            if (mal.getBeforelocatoin() != null && isSameLocation(mal, mals.get(i))) {
//                System.out.println("말을 업습니다.");
                MakeGroup(mals.get(i));
            }
        }
        group_num++;
    }

    public void MakeGroup(Mal mal) {
        mal.setGroup(group_num);
    }

    public boolean GetTargetMal(Mal mal, ArrayList<Player> players) {
        boolean getmal = false;

        for (Player player : players) {
            if (player == this) continue;

            for (Mal targetmal : player.getMals()) {
                if (isSameLocation(mal, targetmal) && targetmal.isExistMalInField()) {
                    initializeMal(targetmal);
                    System.out.println(player + "P의 " + targetmal + " 말을 잡았습니다.");
                    getmal = true;
                }
            }
        }
        return getmal;
    }

    public boolean havesamegroup(Mal mal) {
        for (int i = 0; i < numofmal; i++) {
            if (mal != mals.get(i)) {
                if (mal.getGroup() == mals.get(i).getGroup()) return true;
            }
        }

        return false;
    }

}
