package PlayTest;


import MYProject.Yut.Play.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    Yut yut;
    Board board;
    Player player;
    Location location;
    Yut_Grade value; //윷의 값

    @BeforeEach
    void clearTest(){
        yut = new Yut();
        board = new Board();
        player = new Player(new Mal(new Location(30,30))); //player1을 생성하면서 말을 주었음, 말의 초기위치는 30,30이다.
        location = new Location();
        System.out.println();
    }
    @Test
    public void playTest1() {
        System.out.println("Test1");

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(6); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(0); location.setY(12);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(12); location.setY(0);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.모;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(12);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

    }

    @Test
    public void playTest2(){ //모 윷 모 개
        System.out.println("Test2");

        value = Yut_Grade.모;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(0); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(20); location.setY(10);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.모;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(18);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.개;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

    }

    @Test
    public void playTest3(){

        System.out.println("Test3");

        value = Yut_Grade.모;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(0); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.걸;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(15); location.setY(15);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.걸;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());
    }


    @Test
    public void playTest4(){

        System.out.println("Test4");

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(6); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.모;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(0); location.setY(6);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.도;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(0); location.setY(0);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.윷;
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(20); location.setY(20);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

        value = Yut_Grade.개; //임시로 걸, 윷으로 바꿀 예정
        player.setMal(board.ChangeMal(player.getMal(), value)); //말과, 윷의 값, 그리고 대각선인지를 확인후 이동한다.
        location.setX(30); location.setY(30);
        assertThat(player.getMal().getLocation().getX()).isEqualTo(location.getX());
        assertThat(player.getMal().getLocation().getY()).isEqualTo(location.getY());

    }

}


