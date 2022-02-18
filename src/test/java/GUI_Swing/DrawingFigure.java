package GUI_Swing;

import javax.swing.*;
import java.awt.*;

public class DrawingFigure extends JFrame {
    public DrawingFigure() throws HeadlessException {
        setTitle("Project Yut Playing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Mypanel());

        JLabel l1 = new JLabel("1P");
        JLabel l2 = new JLabel("2P");
        JLabel l3 = new JLabel("3P");
        JLabel l4 = new JLabel("4P");
        JLabel state = new JLabel("※이것은 상태창입니다");

        add(l1); add(l2); add(l3); add(l4); add(state);
        l1.setBounds(550,70,25,25);
        l2.setBounds(550,110,25,25);
        l3.setBounds(550,150,25,25);
        l4.setBounds(550,190,25,25);
        state.setBounds(550,250,200,200);

        l1.setFont(l1.getFont().deriveFont(20.0f));
        l2.setFont(l2.getFont().deriveFont(20.0f));
        l3.setFont(l3.getFont().deriveFont(20.0f));
        l4.setFont(l4.getFont().deriveFont(20.0f));

        JButton b = new JButton("Rolling");
        b.setBounds(570,250,200,70);
        b.setFont(b.getFont().deriveFont(30.0f));
        add(b);

        setLayout(null);
        setSize(900, 600);
        setVisible(true);
    }

    class Mypanel extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(50, 50, 450, 450);

            g.setColor(Color.MAGENTA);
            g.fillOval(600,70,25,25);

            g.setColor(Color.ORANGE);
            g.fillOval(600,110,25,25);

            g.setColor(Color.PINK);
            g.fillOval(600,150,25,25);

            g.setColor(Color.CYAN);
            g.fillOval(600,190,25,25);

            g.setColor(Color.black);
            g.drawOval(75, 75, 80, 80); //왼위
            g.drawOval(395,75,80,80); // 오위

            g.drawOval(75, 380, 80, 80); //왼아래
            g.drawOval(395,380,80,80); //오아래

            g.drawOval(235,225,80,80);

            //왼쪽 기둥
            g.drawOval(100,165,35,35);
            g.drawOval(100,220,35,35);
            g.drawOval(100,275,35,35);
            g.drawOval(100,330,35,35);

            //위쪽 기둥
            g.drawOval(165,100,35,35);
            g.drawOval(220,100,35,35);
            g.drawOval(275,100,35,35);
            g.drawOval(330,100,35,35);

            //왼아래 대각선
            g.drawOval(155,155,35,35);
            g.drawOval(195,195,35,35);

            g.drawOval(355,355,35,35);
            g.drawOval(315,315,35,35);

            //오른쪽편 대각
            g.drawOval(155,355,35,35);
            g.drawOval(195,315,35,35);

            g.drawOval(355,155,35,35);
            g.drawOval(315,195,35,35);

            //오른쪽 기둥
            g.drawOval(410,165,35,35);
            g.drawOval(410,220,35,35);
            g.drawOval(410,275,35,35);
            g.drawOval(410,330,35,35);

            //아래쪽 기둥
            g.drawOval(165,410,35,35);
            g.drawOval(220,410,35,35);
            g.drawOval(275,410,35,35);
            g.drawOval(330,410,35,35);
        }
    }

    public static void main(String []args){
        new DrawingFigure();
    }

}
