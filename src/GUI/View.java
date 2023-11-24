package GUI;

import javax.swing.*;
import java.awt.*;

public class View {
    private Controller controller;
    public View(Controller controller) {
        this.controller = controller;
        JFrame frame = new JFrame("Money Tracker");
        JPanel panel = new JPanel();
        frame.getContentPane();

        JButton ticketButton = new JButton("New Ticket");
        Dimension size = ticketButton.getPreferredSize();
        ticketButton.setBounds( 200, 500, size.width, size.height);
        panel.setLayout(null);
        panel.add(ticketButton);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 600);
        frame.setLocation(400, 100);
        frame.setVisible(true);

        ticketButton.addActionListener(controller);
    }
    public void createSubFrame(){
        JFrame nameFrame = new JFrame("New Ticket");
        JPanel namePanel = new JPanel();
        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket"};
        JComboBox<String> menu = new JComboBox<>(tickets);
        Dimension size = menu.getPreferredSize();
        menu.setBounds( 100, 100, size.width, size.height);
        namePanel.setLayout(null);
        namePanel.add(menu);
        nameFrame.add(namePanel);
        nameFrame.setSize(400, 300);
        nameFrame.setLocation(450, 300);
        nameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        nameFrame.setVisible(true);
    }
}
