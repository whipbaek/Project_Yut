package MYProject.Yut.Play;

public class Move extends Mal { //말의 이동에 대하여 책임을 지는 객체

    public enum direction {
        위, 아래, 좌, 우, 왼대, 우대, 뒤
    }

    //직선(좌,우,상,하)은 6씩 이동
    public Location StraightMove(direction direction, Location location) {
        Location location1 = new Location(location.getX(), location.getY());

        int x = location.getX();
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
        Location location1 = new Location();
        int x = location.getX();
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

        int count = grade.getValue(); //윷 값에 따른 이동 횟수
        int x = mal.getLocation().getX();
        int y = mal.getLocation().getY();


        if (grade == Yut_Grade.백도) { //백도 처리 ->필드에 말이 없다면
            if (!mal.getS().empty()) { //첫 시작이 아니라면

                mal.setLocation(mal.GetStacktop());
                mal.setStraight(isStraightMove(mal.getLocation().getX(), mal.getLocation().getY(), mal)); //대각선으로 움직여야 하는가?

                return mal;
            }
            return mal; //첫 시작이라면 아무 처리도 하지않음.
        }

        mal.setStart(true);

        if ((x == y) && (x != 30 && y != 30)) { //오른 대각선 이동

            for (int i = count; i > 0; i--) {
                if (mal.isMalArrive(count)) return mal; //도착검사

                /**
                 * 비포로케이션 셋팅
                 */
                mal.getS().push(mal.getLocation());
                mal.setLocation(DiagonalMove(direction.우대, mal.getLocation()));

            }
        } else { //오른 대각선을 제외한 이동

            for (int i = count; i > 0; i--) {

                x = mal.getLocation().getX();
                y = mal.getLocation().getY();

                if (mal.isMalArrive(count)) return mal; //도착검사

                /**
                 * 비포로케이션 셋팅
                 */
                mal.getS().push(mal.getLocation());

                if (mal.isStraight()) { //직선이동을 해야한다면
                    if (y == 30 && x != 0) {
                        mal.setLocation(StraightMove(direction.위, mal.getLocation()));
                    } else if (x == 0 && y != 0) {
                        mal.setLocation(StraightMove(direction.좌, mal.getLocation()));
                    } else if (y == 0 && x != 30) {
                        mal.setLocation(StraightMove(direction.아래, mal.getLocation()));
                    } else if (x == 30 && y != 30) {
                        mal.setLocation(StraightMove(direction.우, mal.getLocation()));
                    }
                } else { //대각선이라면

                    if (x == 30 && y == 0) { //대각선 해제검사
                        mal.setLocation(StraightMove(direction.우, mal.getLocation()));
                        mal.setStraight(true);
                    } else if ((x != y) || (x == 15 && y == 15)) { //왼 대각선
                        mal.setLocation(DiagonalMove(direction.왼대, mal.getLocation()));
                    }
                }
            }
        }

        x = mal.getLocation().getX();
        y = mal.getLocation().getY();
        mal.setStraight(isStraightMove(x, y, mal)); //대각선으로 움직여야 하는가?
        mal.setStart2(true);

        return mal;
    }

    private boolean isStraightMove(int x, int y, Mal mal) { // 대각선으로 움직여야하는지 판단

        if ((x == 0 && y == 30) || (x == 0 && y == 0) || (x == 15 && y == 15) ||
            (x == 5 && y == 25) || (x == 10 && y == 20) || (x == 20 && y == 10) || (x == 25 && y == 5) ||
            (x == 5 && y == 5) || (x == 10 && y == 10) || (x == 20 && y == 20) || (x == 25 && y == 25)) {
            return false;
        }
        return true;
    }


}
