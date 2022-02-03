package PlayTest;


import MYProject.Yut.Play.*;
import org.junit.jupiter.api.Test;

public class PlayTest {

    @Test
    public void playTest() {
        Yut yut = new Yut();
        Board board = new Board();
        Player player1 = new Player(new Mal(new Location(30,30))); //player1을 생성하면서 말을 주었음, 말의 초기위치는 30,30이다.
        Mal mal = player1.getMal(); //초기화 되어있는 말의 정보가 전해진다.[30,30]
        Location location = mal.getLocation();
        System.out.println("초기 값 : ["+ location.getX() + "," + location.getY() + "]");

        Yut_Grade value;

//        for(int i=0; i<5; i++){
//            value = yut.getYutValue(); //윷을 던진다.
//            System.out.println("윷 결과 : " + value + " (" + value.getValue() + ")");
//
//            mal = (board.ChangeMal(mal, value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
//
//            System.out.println("변경 값 : ["+ mal.getLocation().getX() + "," + mal.getLocation().getY() + "]");
//            System.out.println();
//        }

        value = Yut_Grade.모;
        System.out.println("윷 결과 : " + value + " (" + value.getValue() + ")");
        mal = (board.ChangeMal(mal, value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.

        System.out.println("변경 값 : ["+ mal.getLocation().getX() + "," + mal.getLocation().getY() + "]");
        System.out.println();

        value = Yut_Grade.윷;
        System.out.println("윷 결과 : " + value + " (" + value.getValue() + ")");
        mal = (board.ChangeMal(mal, value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.

        System.out.println("변경 값 : ["+ mal.getLocation().getX() + "," + mal.getLocation().getY() + "]");
        System.out.println();

        value = Yut_Grade.걸;
        System.out.println("윷 결과 : " + value + " (" + value.getValue() + ")");
        mal = (board.ChangeMal(mal, value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.

        System.out.println("변경 값 : ["+ mal.getLocation().getX() + "," + mal.getLocation().getY() + "]");
        System.out.println();

        System.out.println(Yut_Grade.values()[1]);
    }
}


