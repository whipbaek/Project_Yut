package PlayTest;


import MYProject.Yut.Play.Mal;
import MYProject.Yut.Play.Player;
import MYProject.Yut.Play.Yut_Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class PiggyBackTest {

    @Test
    public void piggyBackTest() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(0,new Player(3));
        Player player1 = players.get(0);

        Mal mal1 = player1.getMals().get(0);
        Mal mal2 = player1.getMals().get(1);
        Mal mal3 = player1.getMals().get(2);

        System.out.println("첫번째 말이 이동합니다, 개");
        player1.PlayerChangeMal(mal1, Yut_Grade.개,players);

        System.out.println("두번째 말이 이동합니다, 개");
        player1.PlayerChangeMal(mal2, Yut_Grade.개,players);

        System.out.println("mal1. X, Y= " + mal1.getLocation().getX() + ", " + mal1.getLocation().getY());
        System.out.println("mal2. X, Y= " + mal2.getLocation().getX() + ", " + mal2.getLocation().getY());



        System.out.println("두번째 말이 이동합니다, 개");
        player1.PlayerChangeMal(mal2, Yut_Grade.개,players);
        System.out.println("After");

        System.out.println("mal1. X, Y= " + mal1.getLocation().getX() + ", " + mal1.getLocation().getY());
        System.out.println("mal2. X, Y= " + mal2.getLocation().getX() + ", " + mal2.getLocation().getY());

        for(int i=0; i<2; i++){
            System.out.println(i + "번째 말의 그룹 : " + player1.getMals().get(i).getGroup());
        }
        System.out.println();

        assertThat(mal1.getGroup()).isEqualTo(mal2.getGroup());
        assertThat(mal1.getLocation().getX()).isEqualTo(mal2.getLocation().getX());
        assertThat(mal1.getLocation().getY()).isEqualTo(mal2.getLocation().getY());

        System.out.println("세번째 말이 이동합니다, 윷");
        player1.PlayerChangeMal(mal3, Yut_Grade.윷,players);

        for(int i=0; i<3; i++){
            System.out.println(i + "번째 말의 그룹 : " + player1.getMals().get(i).getGroup());
        }

        System.out.println("mal1. X, Y= " + mal1.getLocation().getX() + ", " + mal1.getLocation().getY());
        System.out.println("mal2. X, Y= " + mal2.getLocation().getX() + ", " + mal2.getLocation().getY());
        System.out.println("mal3. X, Y= " + mal1.getLocation().getX() + ", " + mal3.getLocation().getY());

        assertThat(mal1.getGroup()).isEqualTo(mal2.getGroup());
        assertThat(mal2.getGroup()).isEqualTo(mal3.getGroup());
        assertThat(mal1.getGroup()).isEqualTo(mal3.getGroup());

        for(int i=0; i<3; i++){
            System.out.println(i + "번째 말의 그룹 : " + player1.getMals().get(i).getGroup());
        }
    }

    @Test
    public void multiPlayerPiggyBackTest () {

        ArrayList<Player> players = new ArrayList<>();
        players.add(0,new Player(3));
        players.add(1,new Player(3));
        Player player1 = players.get(0);
        Player player2 = players.get(1);

        Mal p1_mal1 = player1.getMals().get(0);
        Mal p1_mal2 = player1.getMals().get(1);

        Mal p2_mal1 = player2.getMals().get(0);
        Mal p2_mal2 = player2.getMals().get(1);

        player1.PlayerChangeMal(p1_mal1, Yut_Grade.개, players);
        player1.PlayerChangeMal(p1_mal2, Yut_Grade.개, players);

        System.out.println("Player 1");
        for(int i=0; i<2; i++){
            System.out.println(i + "번째 말의 그룹 : " + player1.getMals().get(i).getGroup());
        }
        System.out.println();

        player2.PlayerChangeMal(p2_mal1, Yut_Grade.개, players);
        player2.PlayerChangeMal(p2_mal2, Yut_Grade.개, players);

        System.out.println("Player 2");
        for(int i=0; i<2; i++){
            System.out.println(i + "번째 말의 그룹 : " + player2.getMals().get(i).getGroup());
        }
        System.out.println();

        assertThat(p1_mal1.getGroup()).isEqualTo(p1_mal2.getGroup());
        assertThat(p2_mal1.getGroup()).isEqualTo(p2_mal2.getGroup());

        assertThat(p1_mal1.getGroup()).isNotEqualTo(p2_mal1.getGroup());

    }
}
