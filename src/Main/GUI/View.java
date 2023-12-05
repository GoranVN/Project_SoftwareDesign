package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class View {
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

        JFrame frame = new JFrame("Money Tracker");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocation(400, 100);
        frame.setVisible(true);

        ticketButton.addActionListener(controller);
        addPersonButton.addActionListener(controller);
    }
    public void createTicketFrame(){
        JPanel ticketPanel = new JPanel();
        ticketPanel.setPreferredSize(new Dimension(400, 300));
        ticketPanel.setLayout(null);
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        JCheckBox evenlySplit = new JCheckBox("Ticket evenly split?");
        evenlySplit.setBounds(125, 150, 200, 30);
        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket", "Concert Ticket"};
        JComboBox<String> menu = new JComboBox<>(tickets);
        menu.setBounds( 125, 100, 150, 30);
        ok.setBounds(75, 200, 100, 30);
        cancel.setBounds(200, 200, 100, 30);
        ticketPanel.add(menu);
        ticketPanel.add(evenlySplit);
        ticketPanel.add(ok);
        ticketPanel.add(cancel);

        JFrame ticketFrame = new JFrame("New Ticket");
        ticketFrame.add(ticketPanel);
        ticketFrame.pack();
        ticketFrame.setLocation(450, 300);
        ticketFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ticketFrame.setVisible(true);

        evenlySplit.addActionListener(controller);
        ok.addActionListener(controller);
        cancel.addActionListener(controller);
    }

    public void createAddPersonFrame(){
        JPanel personPanel = new JPanel();
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        JTextArea personName = new JTextArea();

        Dimension size = personName.getPreferredSize();
        personName.setBounds(200, 100, 50, 100);
        personName.setBorder(new LineBorder(new Color(0, 0, 0)));
        personPanel.add(personName);
        personPanel.setSize(300, 200);

        JFrame personFrame = new JFrame("Add person");
        personFrame.add(personPanel);
        personFrame.pack();
        personFrame.setLocation(450, 300);
        personFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        personFrame.setVisible(true);
    }
}
