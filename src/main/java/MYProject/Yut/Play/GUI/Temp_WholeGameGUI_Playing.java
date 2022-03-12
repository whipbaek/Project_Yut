package MYProject.Yut.Play.GUI;

import MYProject.Yut.Play.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Temp_WholeGameGUI_Playing extends JFrame {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Mal> FieldMals = new ArrayList<>();

    private int numofplayer;
    private int numofmal;
    private Yut yut;
    private Yut_Grade yut_grade;

    private JLabel l1, l2, l3, l4, state, whoisplaying;
    private JLabel p1m, p2m, p3m, p4m;
    private JLabel n1m, n2m, n3m, n4m;
    private JButton m1, m2, m3, m4;
    private JButton bbackdo, bdoe, bgae, bgirl, byut, bmoe, rolling;
    private JButton restart;

    private int nowplayeridx;

    public Temp_WholeGameGUI_Playing(int numofmplayer, int numofmal) throws HeadlessException {
        this.numofplayer = numofmplayer;
        this.numofmal = numofmal;
        InitializePlayers();

        setTitle("Project Yut Playing1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("1P");
        l2 = new JLabel("2P");
        l3 = new JLabel("3P");
        l4 = new JLabel("4P");

        p1m = new JLabel("(" + numofmal + "개)");
        p2m = new JLabel("(" + numofmal + "개)");
        p3m = new JLabel("(" + numofmal + "개)");
        p4m = new JLabel("(" + numofmal + "개)");

        n1m = new JLabel();
        n2m = new JLabel();
        n3m = new JLabel();
        n4m = new JLabel();

        m1 = new JButton("1");
        m2 = new JButton("2");
        m3 = new JButton("3");
        m4 = new JButton("4");
/*
임의로 윷 값을 넣고싶을때 추가하는 로직
        bbackdo = new JButton("백도");
        bdoe = new JButton("도");
        bgae = new JButton("개");
        bgirl = new JButton("걸");
        byut = new JButton("윷");
        bmoe = new JButton("모");

        bbackdo.setBounds(800, 80, 70, 60);
        bdoe.setBounds(800, 160, 50, 60);
        bgae.setBounds(800, 240, 50, 60);
        bgirl.setBounds(800, 320, 50, 60);
        byut.setBounds(800, 400, 50, 60);
        bmoe.setBounds(800, 480, 50, 60);
*/
        restart = new JButton("다시하기");
        restart.setBounds(600, 480, 170, 60);
        restart.addActionListener(new action_restart());

/*
임의로 윷 값을 넣고싶을때 추가하는 로직
        add(bbackdo);
        add(bdoe);
        add(bgae);
        add(bgirl);
        add(byut);
        add(bmoe);

        bbackdo.addActionListener(new custom_malclick());
        bdoe.addActionListener(new custom_malclick());
        bgae.addActionListener(new custom_malclick());
        bgirl.addActionListener(new custom_malclick());
        byut.addActionListener(new custom_malclick());
        bmoe.addActionListener(new custom_malclick());
*/

        Random random = new Random();
        nowplayeridx = random.nextInt(numofplayer); //첫 순서결정
  //      System.out.println("nowplayeridx : " + (nowplayeridx));
        whoisplaying = new JLabel();
        state = new JLabel("첫번째 선수는 " + (nowplayeridx + 1) + "Player 입니다. 윷을 던지세요.");
        add(state);
        add(whoisplaying);

        l1.setBounds(550, 70, 25, 25);
        l2.setBounds(550, 110, 25, 25);
        l3.setBounds(550, 150, 25, 25);
        l4.setBounds(550, 190, 25, 25);
        state.setBounds(550, 265, 300, 200);
        whoisplaying.setBounds(550, 240, 300, 200);

        l1.setFont(l1.getFont().deriveFont(20.0f));
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l3.setFont(l3.getFont().deriveFont(20.0f));
        l4.setFont(l4.getFont().deriveFont(20.0f));

        p1m.setBounds(630, 60, 40, 40);
        p2m.setBounds(630, 100, 40, 40);
        p3m.setBounds(630, 140, 40, 40);
        p4m.setBounds(630, 180, 40, 40);

        add(l1);
        add(l2);
        add(p1m);
        add(p2m);

        if (this.numofplayer > 2) {
            add(l3);
            add(p3m);
        }
        if (this.numofplayer > 3) {
            add(l4);
            add(p4m);
        }
        m1.setBounds(550, 400, 40, 60);
        m2.setBounds(610, 400, 40, 60);
        m3.setBounds(670, 400, 40, 60);
        m4.setBounds(730, 400, 40, 60);

        m1.setFont(m1.getFont().deriveFont(10.0f));
        m2.setFont(m2.getFont().deriveFont(10.0f));
        m3.setFont(m3.getFont().deriveFont(10.0f));
        m4.setFont(m4.getFont().deriveFont(10.0f));


        add(m1);
        add(m2);
        if (this.numofmal > 2) add(m3);
        if (this.numofmal > 3) add(m4);

        rolling = new JButton("Rolling");
        rolling.setBounds(570, 250, 200, 70);
        rolling.setFont(rolling.getFont().deriveFont(30.0f));
        rolling.addActionListener(new action_rolling());
        add(rolling);

        m1.addActionListener(new action_malclick());
        m2.addActionListener(new action_malclick());
        m3.addActionListener(new action_malclick());
        m4.addActionListener(new action_malclick());


        setLayout(null);
        setLocation(450, 200);
        setSize(900, 600);
        setVisible(true);

    }


    private class custom_malclick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bbackdo) {
                yut_grade = Yut_Grade.백도;
                if (players.get(nowplayeridx).getNumOfFieldMals() == 0) {
                    nowplayeridx = GetNextPlayer(nowplayeridx);
                    whoisplaying.setText("현재 플레이어 : " + (nowplayeridx + 1) + "Player");
                    state.setText("<HTML>결과는 백도 입니다. 움직일 말이 없습니다.<br>"
                            + (nowplayeridx + 1) + "Player의 차례입니다. 윷을 던져주세요. </HTML>");
                } else {
                    state.setText("결과는 백도 입니다. 움직이실 말을 선택해주세요");
                }
            } else if (e.getSource() == bdoe) {
                yut_grade = Yut_Grade.도;
                state.setText("결과는 도 입니다. 움직이실 말을 선택해주세요");

            } else if (e.getSource() == bgae) {
                yut_grade = Yut_Grade.개;
                state.setText("결과는 개 입니다. 움직이실 말을 선택해주세요");

            } else if (e.getSource() == bgirl) {
                yut_grade = Yut_Grade.걸;
                state.setText("결과는 걸 입니다. 움직이실 말을 선택해주세요");

            } else if (e.getSource() == byut) {
                yut_grade = Yut_Grade.윷;
                state.setText("결과는 윷 입니다. 움직이실 말을 선택해주세요");

            } else if (e.getSource() == bmoe) {
                yut_grade = Yut_Grade.모;
                state.setText("결과는 모 입니다. 움직이실 말을 선택해주세요");

            }


        }
    }

    private class action_rolling implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            whoisplaying.setText("현재 플레이어 : " + (nowplayeridx+1) + "Player");

            yut_grade = yut.rollingYut();
            if (yut_grade == Yut_Grade.도) {
                state.setText("결과는 도 입니다. 움직이실 말을 선택해주세요");
            } else if (yut_grade == Yut_Grade.개) {
                state.setText("결과는 개 입니다. 움직이실 말을 선택해주세요");
            } else if (yut_grade == Yut_Grade.걸) {
                state.setText("결과는 걸 입니다. 움직이실 말을 선택해주세요");
            } else if (yut_grade == Yut_Grade.윷) {
                state.setText("결과는 윷 입니다. 움직이실 말을 선택해주세요");
            } else if (yut_grade == Yut_Grade.모) {
                state.setText("결과는 모 입니다. 움직이실 말을 선택해주세요");
            } else if (yut_grade == Yut_Grade.백도) {
                if (players.get(nowplayeridx).getNumOfFieldMals() == 0) {
                    nowplayeridx = GetNextPlayer(nowplayeridx);
                    whoisplaying.setText("현재 플레이어 : " + (nowplayeridx+1) + "Player");
                    state.setText("<HTML>결과는 백도 입니다. 움직일 말이 없습니다.<br>"
                            + (nowplayeridx+1) + "Player의 차례입니다. 윷을 던져주세요. </HTML>");
                } else {
                    state.setText("결과는 백도 입니다. 움직이실 말을 선택해주세요");
                }
            }
        }
    }

    //버튼을 누르면 해당 플레이어의 말이 이동한다.
    //말이 이동한다 -> 말을 필드에 새로 그린다.
    //필드에 그리는것은 로직 좌표와 프론트 좌표를 매칭시켜서, 프론트에 그린다.
    //프론트에 그릴때는 그룹내의 말 개수, 말의 번호도 같이 출력해준다.
    //말을 어떻게 지우는가?
    //필드위에 존재하는 말의 위치정보를 기억한다.
    //버튼을 누를때마다 말 그림을 새로 그린다. -> 매칭시켜서


    public int GetNextPlayer(int nowplayeridx) {
        if (nowplayeridx == numofplayer - 1) return 0;
        return ++nowplayeridx;
    }

    private class action_restart implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new WholeGameGUI_FirstPage();
        }
    }

    private class action_malclick implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            Player nowplayer = players.get(nowplayeridx);
            ArrayList<Mal> mals = nowplayer.getMals();
            Mal movingmal = null;


            if (yut_grade == Yut_Grade.백도) { //백도인데 말을 이동할때
                if (!nowplayer.isExistanymalsinfield()) { //필드에 아무것도 없을때
                    return;
                } else { //필드에 말이 있을때, 이때는 필드에 존재한것만 선택하게 해야한다.

                    if (e.getSource() == m1) movingmal = mals.get(0);
                    else if (e.getSource() == m2) movingmal = mals.get(1);
                    else if (e.getSource() == m3) movingmal = mals.get(2);
                    else if (e.getSource() == m4) movingmal = mals.get(3);

                    if (!movingmal.isExistMalInField()) {
                        state.setText("<HTML>해당말은 필드에 존재하지 않습니다.<br> 다른 말을 골라주세요.</HTML>");
                        return;
                    }
                }
            }


            if (e.getSource() == m1) {
                movingmal = mals.get(0);
                state.setText("1번째 말을 선택하셨습니다.");
            } else if (e.getSource() == m2) {
                movingmal = mals.get(1);
                state.setText("2번째 말을 선택하셨습니다.");
            } else if (e.getSource() == m3) {
                movingmal = mals.get(2);
                state.setText("3번째 말을 선택하셨습니다.");
            } else if (e.getSource() == m4) {
                movingmal = mals.get(3);
                state.setText("4번째 말을 선택하셨습니다.");
            }


            if (movingmal.isArrive()) {
                state.setText("<HTML>해당말은 도착한 말입니다.<br> 다른 말을 골라주세요.</HTML>");
                return;
            }

//이것저것 검사하고 말 위치를 바꾸는 로직 실행
            boolean targetmal = false;

            System.out.println();
            System.out.println();
            targetmal = nowplayer.PlayerChangeMal(movingmal, yut_grade, players);
            if (targetmal) System.out.println("말을 잡았습니다.");
            repaint();

            System.out.println("movingmal = " + mals.indexOf(movingmal));
            System.out.println("nowplayeridx = " + nowplayeridx);
            nowplayer.ShowAllmalsGroup();
            nowplayer.ShowAllMalsInfo();
            nowplayer.ShowAllMalLocation();

            if (movingmal.isArrive()) {
                nowplayer.setV_numofmal(nowplayer.getV_numofmal() - nowplayer.numOfSameGroup(movingmal)); //도착했으면 해당 플레이어의 말 수를 제외함
            }

            if (!targetmal && (yut_grade != Yut_Grade.모) && (yut_grade != Yut_Grade.윷) && nowplayer.getV_numofmal() != 0) {
                if (nowplayeridx == numofplayer - 1) {
                    nowplayeridx = 0;
                    state.setText((nowplayeridx + 1) + "Player의 차례입니다. 윷을 던지세요");
                } else {
                    nowplayeridx++;
                    state.setText((nowplayeridx + 1) + "Player의 차례입니다. 윷을 던지세요");
                }
            } else if (targetmal) {
                state.setText("말을 잡았습니다. 윷을 한 번 더 던지세요");
            } else if (yut_grade == Yut_Grade.윷) {
                state.setText("윷을 던졌으므로 한 번 더 던지세요");
            } else if (yut_grade == Yut_Grade.모) {
                state.setText("모를 던졌으므로 한 번 더 던지세요");
            }


            p1m.setText("(" + players.get(0).getV_numofmal() + "개)");
            p2m.setText("(" + players.get(1).getV_numofmal() + "개)");
            if (numofplayer > 2)
                p3m.setText("(" + players.get(2).getV_numofmal() + "개)");
            if (numofplayer > 3)
                p4m.setText("(" + players.get(3).getV_numofmal() + "개)");


            System.out.println("말 남은 개수 : " + nowplayer.getV_numofmal());
            if (nowplayer.getV_numofmal() == 0) {
                state.setText("<HTML>우승자는 " + (nowplayeridx+1) + "Player 입니다! " +
                        "<br> 게임이 끝났습니다. </HTML>");
                rolling.setEnabled(false);
                add(restart);
                return;
            }


            whoisplaying.setText("현재 플레이어 : " + (nowplayeridx+1) + "Player");

        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(50, 50, 450, 450);

        g.setColor(Color.MAGENTA);
        g.fillOval(600, 100, 25, 25);

        g.setColor(Color.ORANGE);
        g.fillOval(600, 140, 25, 25);

        if (numofplayer > 2) {
            g.setColor(Color.PINK);
            g.fillOval(600, 180, 25, 25);
        }

        if (numofplayer > 3) {
            g.setColor(Color.BLACK);
            g.fillOval(600, 220, 25, 25);
        }

        g.setColor(Color.black);
        g.drawOval(75, 75, 80, 80); //왼위
        g.drawOval(395, 75, 80, 80); // 오위

        g.drawOval(75, 380, 80, 80); //왼아래
        g.drawOval(395, 380, 80, 80); //오아래

        g.drawOval(235, 225, 80, 80);

        //왼쪽 기둥
        g.drawOval(100, 165, 35, 35);
        g.drawOval(100, 220, 35, 35);
        g.drawOval(100, 275, 35, 35);
        g.drawOval(100, 330, 35, 35);

        //위쪽 기둥
        g.drawOval(165, 100, 35, 35);
        g.drawOval(220, 100, 35, 35);
        g.drawOval(275, 100, 35, 35);
        g.drawOval(330, 100, 35, 35);

        //왼아래 대각선
        g.drawOval(155, 155, 35, 35);
        g.drawOval(195, 195, 35, 35);

        g.drawOval(315, 315, 35, 35);
        g.drawOval(355, 355, 35, 35);

        //오른쪽편 대각
        g.drawOval(155, 355, 35, 35);
        g.drawOval(195, 315, 35, 35);

        g.drawOval(355, 155, 35, 35);
        g.drawOval(315, 195, 35, 35);

        //오른쪽 기둥
        g.drawOval(410, 165, 35, 35);
        g.drawOval(410, 220, 35, 35);
        g.drawOval(410, 275, 35, 35);
        g.drawOval(410, 330, 35, 35);

        //아래쪽 기둥
        g.drawOval(165, 410, 35, 35);
        g.drawOval(220, 410, 35, 35);
        g.drawOval(275, 410, 35, 35);
        g.drawOval(330, 410, 35, 35);

        char[] nums = {'1', '2', '3', '4'};


        for (int i = 0; i < numofplayer; i++) {
            int xwidth = 20;

            int yheight = 60;
            int xwidth2 = 670;

            if (i == 0) g.setColor(Color.MAGENTA);
            else if (i == 1) g.setColor(Color.ORANGE);
            else if (i == 2) g.setColor(Color.PINK);
            else g.setColor(Color.black);

            for (int j = 0; j < numofmal; j++) {
                Mal Movingmal = players.get(i).getMals().get(j);
                if (Movingmal.isExistMalInField()) {
                    Location location = mappingLocation(Movingmal.getLocation().getX(), Movingmal.getLocation().getY());
                    g.fillOval(location.getX(), location.getY(), 25, 25);

                    if (players.get(i).havesamegroup(players.get(i).getMals().get(j))) xwidth += 5;

                    g.drawChars(nums, j, 1, location.getX() + xwidth, location.getY());
                }

                if(!Movingmal.isArrive()){
                    if(i==0) yheight = 115;
                    if(i==1) yheight = 155;
                    if(i==2) yheight = 195;
                    if(i==3) yheight = 235;
                    g.drawChars(nums,j,1,xwidth2,yheight);
                    xwidth2 += 15;

                }
            }
        }

    }


    private void InitializePlayers() { //플레이어와 윷을 생성한다.
        for (int i = 0; i < numofplayer; i++) {
            players.add(i, new Player(numofmal));
        }
        yut = new Yut(); //윷을 생성한다.
    }

    public Location mappingLocation(int x, int y) {
        Location location = null;

        if (x == 30 && y == 30) location = new Location(415, 415);
        else if (x == 24 && y == 30) location = new Location(415, 335);
        else if (x == 18 && y == 30) location = new Location(415, 280);
        else if (x == 12 && y == 30) location = new Location(415, 225);
        else if (x == 6 && y == 30) location = new Location(415, 170);
        else if (x == 0 && y == 30) location = new Location(415, 105);

        else if (x == 0 && y == 24) location = new Location(335, 105);
        else if (x == 0 && y == 18) location = new Location(280, 105);
        else if (x == 0 && y == 12) location = new Location(225, 105);
        else if (x == 0 && y == 6) location = new Location(170, 105);
        else if (x == 0 && y == 0) location = new Location(105, 105);

        else if (x == 6 && y == 0) location = new Location(105, 170);
        else if (x == 12 && y == 0) location = new Location(105, 225);
        else if (x == 18 && y == 0) location = new Location(105, 280);
        else if (x == 24 && y == 0) location = new Location(105, 335);
        else if (x == 30 && y == 0) location = new Location(105, 415);

        else if (x == 30 && y == 6) location = new Location(170, 415);
        else if (x == 30 && y == 12) location = new Location(225, 415);
        else if (x == 30 && y == 18) location = new Location(280, 415);
        else if (x == 30 && y == 24) location = new Location(335, 415);

        else if (x == 5 && y == 25) location = new Location(360, 160);
        else if (x == 10 && y == 20) location = new Location(320, 200);
        else if (x == 15 && y == 15) location = new Location(260, 255);
        else if (x == 20 && y == 10) location = new Location(200, 320);
        else if (x == 25 && y == 5) location = new Location(160, 360);

        else if (x == 5 && y == 5) location = new Location(160, 160);
        else if (x == 10 && y == 10) location = new Location(200, 200);
        else if (x == 20 && y == 20) location = new Location(320, 320);
        else if (x == 25 && y == 25) location = new Location(360, 360);

        return location;
    }

}
