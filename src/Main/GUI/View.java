package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class View extends JFrame{
    private Controller controller;
    public View(Controller controller) {
        this.controller = controller;
        JButton ticketButton = new JButton("New Ticket");
        JButton addPersonButton = new JButton("Add Person");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(ticketButton);
        ticketButton.setBounds(125, 500, 100, 30);
        panel.add(addPersonButton);
        addPersonButton.setBounds(275, 500, 100, 30);
        panel.setPreferredSize(new Dimension(500, 600));

        this.setName("Money Tracker");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocation(400, 100);
        this.setVisible(true);

        ticketButton.addActionListener(controller);
        addPersonButton.addActionListener(controller);

    }
}
