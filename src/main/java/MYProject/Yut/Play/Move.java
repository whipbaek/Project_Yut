package MYProject.Yut.Play;

public class Move extends Mal { //말의 이동에 대하여 책임을 지는 객체

    public enum direction {
        위, 아래, 좌, 우, 왼대, 우대, 뒤
    }

    //직선(좌,우,상,하)은 6씩 이동
    public Location StraightMove(direction direction, Location location) {
        Location location1 = new Location(location.getX(), location.getY());

        int x = location1.getX();
        int y = location.getY();

        if (direction == Move.direction.위) {
            location1.setX(x - 6);
        } else if (direction == Move.direction.좌) {
            location1.setY(y - 6);
        } else if (direction == Move.direction.아래) {
            location1.setX(x + 6);
        } else if (direction == Move.direction.우) {
            location1.setY(y + 6);
        }

        return location1;
    }


    //대각선일때는 5씩 이동
    public Location DiagonalMove(direction direction, Location location) {
        Location location1 = new Location(location.getX(), location.getY());
        int x = location1.getX();
        int y = location.getY();

        if (direction == Move.direction.왼대) {
            location1.setX(x + 5);
            location1.setY(y - 5);
        } else if (direction == Move.direction.우대) {
            location1.setX(x + 5);
            location1.setY(y + 5);
        }

        return location1;
    }

    public Mal ChangeMal(Mal mal, Yut_Grade grade) {

        Location t_location = mal.getLocation();

        int count = grade.getValue(); //윷 값에 따른 이동 횟수

        int x = t_location.getX();
        int y = t_location.getY();

        if(grade == Yut_Grade.백도){ //예외 1 백도 처리
            System.out.println("백도로 진입");
            if(mal.getBeforelocatoin() != null){ //첫 시작이 아니라면
                mal.setLocation(mal.getBeforelocatoin());
                return mal;
            }
            return mal; //첫 시작이라면
        }


        if ( (x == y) && (x!=30 && y!=30) ) { //오른 대각선 이동

            for(int i=count; i>0; i--) {
                {
                    if(isMalArrive(mal,count)){
                            System.out.println("도착!");
                            mal.setArrive(true);
                            mal.setLocation(t_location);
                            return mal;
                        }
                    }

                    mal.setBeforelocatoin(t_location);
                    System.out.println("우 대각선으로 이동");
                    t_location = DiagonalMove(direction.우대, t_location);
                }
            }
        else {
            for (int i = count; i > 0; i--) {

                x = t_location.getX();
                y = t_location.getY();

                if(mal.getBeforelocatoin()!=null){ //직선으로 도착했을때
                    if(x==30 && y == 30 && count > 0){
                        System.out.println("도착!");
                        mal.setArrive(true);
                        mal.setLocation(t_location);
                        return mal;
                    }
                }

                mal.setBeforelocatoin(t_location);

                if (mal.isStraight()) { //직선이동을 해야한다면
                    if (y == 30 && x != 0) { //위쪽으로 이동
                        System.out.println("위로 이동");
                        t_location = StraightMove(direction.위, t_location);
                    } else if (x == 0 && y != 0) { //좌 우동
                        System.out.println("좌로 이동");
                        t_location = StraightMove(direction.좌, t_location);
                    } else if (y == 0 && x != 30) { //아래 이동
                        System.out.println("아래로 이동");
                        t_location = StraightMove(direction.아래, t_location);
                    } else if (x == 30 && y != 30) {//우 우동
                        System.out.println("우로 이동");
                        t_location = StraightMove(direction.우, t_location);
                    }
                } else { //대각선이라면
                    if (t_location.getX() == 30 && t_location.getY() == 0) {
                        System.out.println("대각선을 해제하고 직선으로 이동합니다");
                        System.out.println("우로 이동");
                        t_location = StraightMove(direction.우, t_location);
                        mal.setStraight(true);
                    }
                    else if ((x != y) || (x==15 && y==15)) { //왼 대각선 이동
                        System.out.println("왼 대각선으로 이동");
                        t_location = DiagonalMove(direction.왼대, t_location);
                    }
                }
            }
        }

         x = t_location.getX();
         y = t_location.getY();


        if ((x == 0 && y == 30) || (x == 0 && y == 0) || (x == 15 && y == 15)) {
            System.out.println("대각선으로 이동해야합니다. 좌표[" + x + "," + y + "]");
            mal.setStraight(false);
        }

        mal.setLocation(t_location);

        return mal;
    }

}
