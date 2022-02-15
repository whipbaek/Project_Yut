package GUI_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayWindow extends JFrame implements ActionListener {

    PlayWindow() {
        super("Playing_Project_Yut");

        Label l1 = new Label("New Window for Play Game");

        add(l1);

        l1.setBounds(200,200,300,200);
        setSize(900, 600);
        setLayout(null);
        setVisible(true);
        setLocation(500, 170);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
