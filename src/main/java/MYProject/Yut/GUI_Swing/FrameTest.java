package MYProject.Yut.GUI_Swing;

import javax.swing.*;
import java.awt.event.*;


public class FrameTest {

    public static void main(String[] args) {
        new JCheckBoxTest();
    }
}


class JCheckBoxTest extends JFrame implements ActionListener {
    JLabel l1, l2;
    JRadioButton cb1, cb2, cb3, cb4, cb5, cb6;
    JButton b;

    JCheckBoxTest() {
        super("Project_Yut");
        ButtonGroup group1 = new ButtonGroup();
        ButtonGroup group2 = new ButtonGroup();
        l1 = new JLabel(" ※몇명이서 플레이 하시겠습니까?");
        l1.setBounds(20, 20, 300, 20);
        cb1 = new JRadioButton("2인");
        cb1.setBounds(30, 60, 50, 20);
        cb2 = new JRadioButton("3인");
        cb2.setBounds(100, 60, 50, 20);
        cb3 = new JRadioButton("4인");
        cb3.setBounds(170, 60, 50, 20);

        l2 = new JLabel(" ※몇개의 말로 플레이 하시겠습니까?");
        l2.setBounds(20, 100, 300, 20);
        cb4 = new JRadioButton("2개");
        cb4.setBounds(30, 140, 50, 20);
        cb5 = new JRadioButton("3개");
        cb5.setBounds(100, 140, 50, 20);
        cb6 = new JRadioButton("4개");
        cb6.setBounds(170, 140, 50, 20);


        b = new JButton("시작");
        b.setBounds(85, 180, 80, 30);
        b.addActionListener(this);

        group1.add(cb1);
        group1.add(cb2);
        group1.add(cb3);

        group2.add(cb4);
        group2.add(cb5);
        group2.add(cb6);

        add(l1);
        add(cb1);
        add(cb2);
        add(cb3);
        add(l2);
        add(cb4);
        add(cb5);
        add(cb6);
        add(b);

        setSize(260, 280);
        setLayout(null);
        setVisible(true);
        setLocation(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numofplayer;
        int numofmal;
        String msg = "";
        if (cb1.isSelected()) {
            numofplayer = 2;
        }
        if (cb2.isSelected()) {
            numofplayer = 3;
        }
        if (cb3.isSelected()) {
            numofplayer = 4;
        }

        if (cb4.isSelected()) {
            numofmal = 2;
        }

        if (cb5.isSelected()) {
            numofmal = 3;
        }

        if (cb6.isSelected()) {
            numofmal = 4;
        }
        //new PlayWindow();
        new DrawingFigure();
        setVisible(false);
    }
}

