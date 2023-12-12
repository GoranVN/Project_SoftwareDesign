package GUI;

import javax.swing.*;
import java.awt.*;

public class TicketSubframe extends JFrame{
    private Controller controller;
    private JCheckBox evenlySplit;
    private JComboBox<String> menu;
    public TicketSubframe(Controller controller) {
        this.controller = controller;

        JPanel ticketPanel = new JPanel();
        ticketPanel.setPreferredSize(new Dimension(400, 300));
        ticketPanel.setLayout(null);
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        evenlySplit = new JCheckBox("Ticket evenly split?");
        evenlySplit.setBounds(125, 150, 200, 30);
        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket", "Concert Ticket"};
        menu = new JComboBox<>(tickets);
        menu.setBounds( 125, 100, 150, 30);
        ok.setBounds(75, 200, 100, 30);
        cancel.setBounds(200, 200, 100, 30);
        ticketPanel.add(menu);
        ticketPanel.add(evenlySplit);
        ticketPanel.add(ok);
        ticketPanel.add(cancel);

        this.setName("New Ticket");
        this.add(ticketPanel);
        this.pack();
        this.setLocation(450, 300);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        evenlySplit.addActionListener(controller);
        ok.addActionListener(controller);
        cancel.addActionListener(controller);
        this.addWindowListener(controller);
    }

    public Boolean getEvenlySplit(){
        return evenlySplit.isSelected();
    }
    public String getTypeOfTicket(){
        return menu.getSelectedItem().toString();
    }
}
