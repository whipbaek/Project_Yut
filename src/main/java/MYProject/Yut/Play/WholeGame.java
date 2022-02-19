package MYProject.Yut.Play;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WholeGame {
    private ArrayList<Player> players = new ArrayList<>();
    private Yut yut;
    int numofplayer;
    int numofmal;

    public WholeGame(int numofplayer, int numofmal) { //게임을 만든다
        this.numofplayer = numofplayer;
        this.numofmal = numofmal;
        MakeGame();
    }

    private void MakeGame() { //플레이어와 윷을 생성한다.
        for (int i = 0; i < numofplayer; i++) {
            players.add(i, new Player(numofmal));
        }
        yut = new Yut(); //윷을 생성한다.
    }

    public void StartGame(Scanner sc) { //Game processing

        int winner = -1;

        System.out.println("***게임을 시작합니다***");
        System.out.println("참가인원 : " + numofplayer);
        System.out.println("말의 개수 : " + numofmal);
        System.out.println("윷을 던질 순서를 정하겠습니다.");

        Random random = new Random();
        int nowplayeridx = random.nextInt(numofplayer); //첫빠따 순서결정

        Yut_Grade yut_grade;
        System.out.println("첫번째 선수는 " + nowplayeridx + "Player 입니다.");

        while (winner < 0) {

            boolean getmal = false;

            System.out.println(nowplayeridx + " 가 윷을 던집니다. ");
            yut_grade = yut.rollingYut(); //윷 던지기
            System.out.println("결과 : " + yut_grade);

            Player nowplayer = players.get(nowplayeridx); //현재 플레이어
            ArrayList<Mal> mals = nowplayer.getMals(); // 플레이어의 말 셋을 가져온다.
            nowplayer.ShowAllMalsInfo(); //플레이어의 말 정보를 출력한다.

            while (true) {
                try {
                    if (nowplayer.getNumOfFieldMals() == 0 && yut_grade == Yut_Grade.백도) {
                        System.out.println("필드에 존재하는 말이 없습니다. 턴을 넘깁니다.");
                        break;
                    }

                    System.out.println("어떤 말을 옮기시겠습니까? ");
                    int movingmal = sc.nextInt();
                    Mal movemal = mals.get(movingmal);

                    if (movemal.isArrive()) {
                        System.out.println("해당말은 도착한 말입니다. 다른 말을 골라주세요");
                        continue;
                    } else {

                        getmal = nowplayer.PlayerChangeMal(movemal, yut_grade, players); //말을 이동함

                        if (movemal.isArrive()) {
                            nowplayer.setNumofmal(nowplayer.getNumofmal() - nowplayer.numOfSameGroup(movemal)); //도착했으면 해당 플레이어의 말 수를 제외함
                            System.out.println("도착해서 말수를 제외");
                        }
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("존재하는 말을 선택해주세요");
                    continue;
                }
            }

            //모든 말이 들어왔는지 체크
            if (nowplayer.getNumofmal() == 0) winner = nowplayeridx;

            if (getmal && yut_grade != Yut_Grade.윷 && yut_grade != Yut_Grade.모) {
                System.out.println("말을 잡았으므로 한 번 더 던집니다.");
                continue;
            }

            if (yut_grade == Yut_Grade.윷) {
                System.out.println("윷을 던졌으므로 한 번 더 던집니다.");
                continue;
            }

            if (yut_grade == Yut_Grade.모) {
                System.out.println("모를 던졌으므로 한 번 더 던집니다.");
                continue;
            }


            //플레이어 순서 변환
            nowplayeridx = GetNextPlayer(nowplayeridx);
        }
        System.out.println("우승자는 " + winner + " 입니다");
    }


    public int GetNextPlayer(int nowplayeridx) {
        if (nowplayeridx == numofplayer - 1) return 0;
        return ++nowplayeridx;
    }


    public void StartGame_Manual(Scanner sc) { //Game processing

        int winner = -1;

        System.out.println("***게임을 시작합니다***");
        System.out.println("참가인원 : " + numofplayer);
        System.out.println("말의 개수 : " + numofmal);
        System.out.println("윷을 던질 순서를 정하겠습니다.");

        Random random = new Random();
        int nowplayeridx = random.nextInt(numofplayer); //첫 순서결정

        Yut_Grade yut_grade;
        System.out.println("첫번째 선수는 " + nowplayeridx + "Player 입니다.");

        while (winner < 0) {

            boolean getmal = false;

            System.out.println(nowplayeridx + " 가 윷을 던집니다. ");
            System.out.print("윷의 값을 선택해주세요.");
            System.out.println(" [ 1 : 도, 2 : 개, 3 : 걸, 4 : 윷, 5 : 모, 6 : 백도 ]");
            System.out.print("Input : ");
            int yut_val = sc.nextInt();

            switch (yut_val) {
                case 1:
                    yut_grade = Yut_Grade.도;
                    break;
                case 2:
                    yut_grade = Yut_Grade.개;
                    break;
                case 3:
                    yut_grade = Yut_Grade.걸;
                    break;
                case 4:
                    yut_grade = Yut_Grade.윷;
                    break;
                case 5:
                    yut_grade = Yut_Grade.모;
                    break;
                case 6:
                    yut_grade = Yut_Grade.백도;
                    break;
                default:
                    yut_grade = Yut_Grade.도;
                    break;
            }

            System.out.println("결과 : " + yut_grade);


            Player nowplayer = players.get(nowplayeridx); //현재 플레이어
            ArrayList<Mal> mals = nowplayer.getMals(); // 플레이어의 말 셋을 가져온다.
            nowplayer.ShowAllMalsInfo(); //플레이어의 말 정보를 출력한다.

            while (true) {
                try {
                    if (nowplayer.getNumOfFieldMals() == 0 && yut_grade == Yut_Grade.백도) {
                        System.out.println("필드에 존재하는 말이 없습니다. 턴을 넘깁니다.");
                        break;
                    }

                    System.out.println("어떤 말을 옮기시겠습니까? ");
                    int movingmal = sc.nextInt();
                    Mal movemal = mals.get(movingmal);

                    if (movemal.isArrive()) {
                        System.out.println("해당말은 도착한 말입니다. 다른 말을 골라주세요");
                        continue;
                    } else {

                        getmal = nowplayer.PlayerChangeMal(movemal, yut_grade, players); //말을 이동함
                        nowplayer.ShowAllMalLocation();

                        if (movemal.isArrive()) {
                            nowplayer.setNumofmal(nowplayer.getNumofmal() - nowplayer.numOfSameGroup(movemal)); //도착했으면 해당 플레이어의 말 수를 제외함
                            System.out.println("도착해서 말수를 제외");
                        }
                        break;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("존재하는 말을 선택해주세요");
                    continue;
                }
            }

            //모든 말이 들어왔는지 체크
            if (nowplayer.getNumofmal() == 0) winner = nowplayeridx;

            if(winner<0) {
                if (getmal && yut_grade != Yut_Grade.윷 && yut_grade != Yut_Grade.모) {
                    System.out.println("말을 잡았으므로 한 번 더 던집니다.");
                    continue;
                }

                if (yut_grade == Yut_Grade.윷) {
                    System.out.println("윷을 던졌으므로 한 번 더 던집니다.");
                    continue;
                }

                if (yut_grade == Yut_Grade.모) {
                    System.out.println("모를 던졌으므로 한 번 더 던집니다.");
                    continue;
                }
            }

            //플레이어 순서 변환
            nowplayeridx = GetNextPlayer(nowplayeridx);
        }
        System.out.println("우승자는 " + winner + " 입니다");
    }
}