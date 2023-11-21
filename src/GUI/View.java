package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    public void createTicketFrame(){
        JFrame nameFrame = new JFrame("New Ticket");
        JPanel namePanel = new JPanel();
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        JCheckBox evenlySplit = new JCheckBox("Ticket evenly split?");
        evenlySplit.setBounds(100, 150, evenlySplit.getPreferredSize().width+5, evenlySplit.getPreferredSize().height);
        namePanel.add(evenlySplit);
        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket", "Concert Ticket"};
        JComboBox<String> menu = new JComboBox<>(tickets);
        menu.setBounds( 100, 100, menu.getPreferredSize().width, menu.getPreferredSize().height);
        namePanel.setLayout(null);
        namePanel.add(menu);
        nameFrame.add(namePanel);
        nameFrame.setSize(400, 300);
        nameFrame.setLocation(450, 300);
        nameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        nameFrame.setVisible(true);
    }
}
