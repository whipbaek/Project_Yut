package MYProject.Yut.Play.GUI;

import MYProject.Yut.Play.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class WholeGameGUI_Playing extends JFrame {

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Mal> FieldMals = new ArrayList<>();

    private int numofplayer;
    private int numofmal;
    private Yut yut;
    private Yut_Grade yut_grade;

    private JLabel l1, l2, l3, l4, state;
    private JButton m1, m2, m3, m4;

    private int nowplayeridx;

    public WholeGameGUI_Playing(int numofmplayer, int numofmal) throws HeadlessException {
        this.numofplayer = numofmplayer;
        this.numofmal = numofmal;
        InitializePlayers();

        setTitle("Project Yut Playing1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Mypanel());

        l1 = new JLabel("1P");
        l2 = new JLabel("2P");
        l3 = new JLabel("3P");
        l4 = new JLabel("4P");

        m1 = new JButton("1");
        m2 = new JButton("2");
        m3 = new JButton("3");
        m4 = new JButton("4");

        Random random = new Random();
        nowplayeridx = random.nextInt(numofplayer); //첫 순서결정

        state = new JLabel("첫번째 선수는 " + nowplayeridx + "Player 입니다. 윷을 던지세요.");
        add(state);

        l1.setBounds(550, 70, 25, 25);
        l2.setBounds(550, 110, 25, 25);
        l3.setBounds(550, 150, 25, 25);
        l4.setBounds(550, 190, 25, 25);
        state.setBounds(550, 250, 300, 200);

        l1.setFont(l1.getFont().deriveFont(20.0f));
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l3.setFont(l3.getFont().deriveFont(20.0f));
        l4.setFont(l4.getFont().deriveFont(20.0f));

        add(l1);
        add(l2);
        if (this.numofplayer > 2) add(l3);
        if (this.numofplayer > 3) add(l4);

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

        JButton rolling = new JButton("Rolling");
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

        boolean isRolling = false;

        int winner = -1;


    }

    private class action_rolling implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                state.setText("결과는 백도 입니다. 움직이실 말을 선택해주세요");
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

    private class action_malclick implements ActionListener {
        Player nowplayer = players.get(nowplayeridx);
        ArrayList<Mal> mals = nowplayer.getMals();
        Mal movingmal;

        @Override
        public void actionPerformed(ActionEvent e) {
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

            nowplayer.PlayerChangeMal(movingmal, yut_grade, players);

            //말을 모두 그려준다.(필드에 있는말들을 모두 확인한다.)
            //그릴때는 그룹이 같은지도 확인해야한다.
            //좌표를 매칭해야한다.
            repaint();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            state.setText("~의 차례입니다.");

        }
    }

/*
    class DrawingMals extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Location location = mappingLocation(24, 30);
            g.fillOval(location.getX(), location.getY(), 25, 25);

            Player nowplayer = players.get(nowplayeridx);
            ArrayList<Mal> mals = nowplayer.getMals();
            Mal movingmal;
            Location location;
            for (int i = 0; i < numofplayer; i++) {
                nowplayer = players.get(i);
                mals = nowplayer.getMals();
                for (int j = 0; j < numofmal; j++) {
                    movingmal = mals.get(j);
                    if (i == 0) { //1p의 말
                        g.setColor(Color.MAGENTA);

                    } else if (i == 1) { //2p의 말
                        g.setColor(Color.ORANGE);

                    } else if (i == 2) { //3p의 말
                        g.setColor(Color.PINK);

                    } else if (i == 3) { //4p의 말
                        g.setColor(Color.CYAN);

                    }

                    location = movingmal.getLocation();
                    g.fillOval(location.getX(), location.getY(), 25, 25);

                }
            }

        }
    }
*/
    class Mypanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(50, 50, 450, 450);

            g.setColor(Color.MAGENTA);
            g.fillOval(600, 70, 25, 25);

            g.setColor(Color.ORANGE);
            g.fillOval(600, 110, 25, 25);

            if (numofplayer > 2) {
                g.setColor(Color.PINK);
                g.fillOval(600, 150, 25, 25);
            }

            if (numofplayer > 3) {
                g.setColor(Color.CYAN);
                g.fillOval(600, 190, 25, 25);
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


            // **** 이동 버튼으로 인한 repaint 구문
            if (m1.isSelected() || m2.isSelected() || m3.isSelected() || m4.isSelected()) {
                /*
                Location location = null;
                for (int i = 0; i < numofplayer; i++) {
                    for (int j = 0; j < numofmal; j++) {
                        Mal movemal = players.get(i).getMals().get(j);
                        location = mappingLocation(movemal.getLocation().getX(), movemal.getLocation().getY());
                    }

                    if (i == 0) { //1p의 말
                        g.setColor(Color.MAGENTA);

                    } else if (i == 1) { //2p의 말
                        g.setColor(Color.ORANGE);

                    } else if (i == 2) { //3p의 말
                        g.setColor(Color.PINK);

                    } else if (i == 3) { //4p의 말
                        g.setColor(Color.CYAN);

                    }


                }
*/
                g.fillOval(24, 30, 25, 25);

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

        if (x == 30 && y == 30) location = new Location(395, 380);
        else if (x == 24 && y == 30) location = new Location(410, 330);
        else if (x == 18 && y == 30) location = new Location(410, 275);
        else if (x == 12 && y == 30) location = new Location(410, 220);
        else if (x == 6 && y == 30) location = new Location(410, 165);
        else if (x == 0 && y == 30) location = new Location(395, 75);
        else if (x == 0 && y == 24) location = new Location(330, 100);
        else if (x == 0 && y == 18) location = new Location(275, 100);
        else if (x == 0 && y == 12) location = new Location(220, 100);
        else if (x == 0 && y == 6) location = new Location(165, 100);
        else if (x == 0 && y == 0) location = new Location(75, 75);
        else if (x == 6 && y == 0) location = new Location(100, 165);
        else if (x == 12 && y == 0) location = new Location(100, 220);
        else if (x == 18 && y == 0) location = new Location(100, 275);
        else if (x == 24 && y == 0) location = new Location(100, 330);
        else if (x == 30 && y == 0) location = new Location(75, 380);
        else if (x == 30 && y == 6) location = new Location(165, 410);
        else if (x == 30 && y == 12) location = new Location(220, 410);
        else if (x == 30 && y == 18) location = new Location(275, 410);
        else if (x == 30 && y == 24) location = new Location(330, 410);
        else if (x == 5 && y == 25) location = new Location(355, 155);
        else if (x == 10 && y == 20) location = new Location(315, 190);
        else if (x == 15 && y == 15) location = new Location(235, 225);
        else if (x == 20 && y == 10) location = new Location(195, 315);
        else if (x == 25 && y == 5) location = new Location(155, 355);
        else if (x == 5 && y == 5) location = new Location(155, 155);
        else if (x == 10 && y == 10) location = new Location(195, 195);
        else if (x == 20 && y == 20) location = new Location(315, 315);
        else if (x == 25 && y == 25) location = new Location(355, 355);

        return location;
    }

}
