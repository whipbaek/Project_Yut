package PlayTest;


import MYProject.Yut.Play.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class PlayTest {

    ArrayList<Player> players;
    Yut yut;
    Move move;

    Player player1;
    Player player2;

    Mal p1_mal0;
    Mal p1_mal1;
    Mal p2_mal0;
    Mal p2_mal1;

    @BeforeEach
    public void initial() {
        players = new ArrayList<>();
        players.add(0, new Player(2));
        players.add(1, new Player(2));

        yut = new Yut();
        move = new Move();

        player1 = players.get(0);
        player2 = players.get(1);

        p1_mal0 = player1.getMals().get(0);
        p1_mal1 = player1.getMals().get(1);

        p2_mal0 = player2.getMals().get(0);
        p2_mal1 = player2.getMals().get(1);
    }

    public void sameLocationAssertionTest(Mal mal1, Mal mal2) {
        assertThat(mal1.getLocation().getX()).isEqualTo(mal2.getLocation().getX());
        assertThat(mal1.getLocation().getY()).isEqualTo(mal2.getLocation().getY());
    }

    public boolean isThisPlayerWinner(Player player){
        for(int i=0; i<2; i++) {
            if (!player.getMals().get(i).isArrive()) return false;
        }
        return true;
    }

    @Test
    public void playTest1() {
        System.out.println("Start Test1");
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.윷,players);
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.모,players);
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.도,players);
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.윷,players);
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.걸,players);
        player1.ShowAllMalsInfo();
        player1.ShowAllMalLocation();
    }

    @Test
    public void playTest2() {

        System.out.println("Start Test2");
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.도,players);
        player1.PlayerChangeMal(p1_mal1,Yut_Grade.도,players); //업음
        player1.PlayerChangeMal(p1_mal0,Yut_Grade.개,players); //업은채로 이동

        sameLocationAssertionTest(p1_mal1,p1_mal0);

        player2.PlayerChangeMal(p2_mal0,Yut_Grade.걸,players); //업힌 말을 잡음
        player2.PlayerChangeMal(p2_mal1,Yut_Grade.걸,players); //말 업음
        System.out.println("중간점검");
        player2.ShowAllMalLocation();


        player2.PlayerChangeMal(p2_mal1,Yut_Grade.개,players);
        System.out.println("중간점검2");
        player2.ShowAllMalLocation();

        player2.PlayerChangeMal(p2_mal1,Yut_Grade.걸,players);
        System.out.println("중간점검3");
        player2.ShowAllMalLocation();

        player2.PlayerChangeMal(p2_mal1,Yut_Grade.윷,players);

        player2.ShowAllMalLocation();
        player2.ShowAllMalsInfo();
    }

    @Test
    public void playTest3() {

    }
}