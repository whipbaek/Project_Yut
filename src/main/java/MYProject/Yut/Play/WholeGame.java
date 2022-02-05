package MYProject.Yut.Play;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WholeGame {
    private ArrayList<Player> players = new ArrayList<>();
    private Yut yut;
    int numofplayer;
    int numofmal;
    Board board;

    public WholeGame(int numofplayer, int numofmal) {
        this.numofplayer = numofplayer;
        this.numofmal = numofmal;
        MakeGame();
    }

    private void MakeGame() { //말을 생성한다.
        for (int i = 0; i < numofplayer; i++) {
            players.add(i, new Player(numofmal));
        }
        yut = new Yut(); //윷을 생성한다.
        board = new Board();
    }

    public void StartGame(Scanner sc) { //Game processing
        int winner = -1;

        System.out.println("***게임을 시작합니다***");
        System.out.println("참가인원 : " + numofplayer);
        System.out.println("말의 개수 : " + numofmal);
        System.out.println("윷을 던질 순서를 정하겠습니다.");

        Random random = new Random();
        int nowplayeridx = random.nextInt(numofplayer);
        Yut_Grade yut_grade;
        System.out.println("첫번째 선수는 " + nowplayeridx + "Player 입니다.");

        while (winner < 0) {

            System.out.println(nowplayeridx + " 가 윷을 던집니다. ");
            yut_grade = yut.rollingYut();
            System.out.println("결과 : " + yut_grade);

            Player nowplayer = players.get(nowplayeridx);
            ArrayList<Mal> mals = nowplayer.getMals(); // 플레이어의 말 셋을 가져온다.
            nowplayer.ShowMalsInfo(); //플레이어의 말 정보를 출력한다.

            while (true) {
                System.out.println("어떤 말을 옮기시겠습니까?");
                int movingmal = sc.nextInt();

                if (mals.get(movingmal) == null) {
                    System.out.println("필드에 존재하는 말을 선택해주세요");
                    continue;
                }

            Mal movemal = mals.get(movingmal);

            if (movemal.isArrive()) {
                System.out.println("해당말은 도착한 말입니다. 다른 말을 골라주세요");
                continue;
            } else {
                board.ChangeMal(movemal, yut_grade);
                if (movemal.isArrive()) {
                    nowplayer.setNumofmal(nowplayer.getNumofmal() - 1); //도착했으면 해당 플레이어의 말 수를 제외함
                }
                break;
            }
        }

        if (nowplayer.getNumofmal() == 0) {
            winner = nowplayeridx;
        }

        //플레이어 순서 변환
        if (nowplayeridx == numofplayer - 1) nowplayeridx = 0;
        else nowplayeridx++;

    }

        System.out.println("우승자는 "+winner +" 입니다");
}
}
