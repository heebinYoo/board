package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListView extends JFrame {

    ArrayList<JPanel> jPanelArrayList = new ArrayList<>();

    public ListView() throws HeadlessException {
        super("ListView");
        this.setLayout(new FlowLayout());

        this.setSize(new Dimension(100,200));
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class ListActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}