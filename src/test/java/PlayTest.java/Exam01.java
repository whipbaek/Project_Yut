package PlayTest.java;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
class Exam01_Sub extends Frame {
    private Button btn1 = new Button("확인");
    private Button btn2 = new Button("취소");
    public Exam01_Sub() {
        super();
        this.init();
        this.start();
        this.setSize(500, 500);
        this.setVisible(true);
    }
    void init() {
        this.setLayout(new BorderLayout());
        Panel p = new Panel(new FlowLayout());
        p.add(btn1);
        p.add(btn2);
        this.add("North", p);
    }
    void start() {
    }
    public void paint(Graphics g){
        int x,y,w,h;

        //랜덤값 받아내기
        for(int i=0; i<100; i++){

            Dimension dm = this.getSize();
            int red = (int)(Math.random()*256);
            int green = (int)(Math.random()*256);
            int blue = (int)(Math.random() * 256);
            g.setColor(new Color(red,green,blue));

            x = (int)(Math.random() * dm.getWidth()); //너비와 높이값 제한하기
            y = (int)(Math.random() * dm.getHeight());
            w = (int)(Math.random() * 50) + 50;
            h = (int)(Math.random() * 50) + 50;

            int dist = (int)(Math.random() * 4); //최대값이 4미만의 수가 나오도록함. 3이 최대값 (0~3까지의 수)

            if(dist == 0)
                g.drawRect(x, y, w, h);  //속빈 사각형
            else if(dist == 1)
                g.fillRect(x, y, w, h);  //속찬 사각형
            else if(dist == 2)
                g.drawOval(x, y, w, h);  //속빈 원형
            else
                g.fillOval(x, y, w, h); //원의 시작지점(x,y) 너비와 높이 (w,h)

            try{
                Thread.sleep(500);
            }catch(Exception ee){

            }

        }

    }
}
public class Exam01 {
    public static void main(String args[]) {
        Exam01_Sub ex = new Exam01_Sub();
    }
} 