package GUI;

import javax.swing.*;
import java.awt.*;

public class TicketSubframe extends JFrame{
    private Controller controller;
    private JCheckBox evenlySplit;
    private JComboBox<String> menu;
    private JComboBox<String> namesMenu;
    public TicketSubframe(Controller controller) {
        super("New Ticket");
        this.controller = controller;

        JPanel ticketPanel = new JPanel();
        ticketPanel.setPreferredSize(new Dimension(400, 300));
        ticketPanel.setLayout(null);
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        evenlySplit = new JCheckBox("Ticket evenly split?");
        evenlySplit.setBounds(125, 150, 200, 30);

        JTextArea typeOfTicket = new JTextArea("Ticket: ");
        typeOfTicket.setBounds(65, 30, 60, 30);
        typeOfTicket.setBackground(null);
        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket", "Concert Ticket"};
        menu = new JComboBox<>(tickets);
        menu.setBounds( 125, 25, 150, 30);

        JTextArea whoPaid = new JTextArea("Who paid?");
        whoPaid.setBounds(60, 65, 60, 30);
        whoPaid.setBackground(null);
        namesMenu = new JComboBox<>(controller.getPersonDB());
        namesMenu.setBounds( 125, 60, 150, 30);

        ok.setBounds(75, 200, 100, 30);
        cancel.setBounds(200, 200, 100, 30);
        ticketPanel.add(typeOfTicket);
        ticketPanel.add(menu);
        ticketPanel.add(whoPaid);
        ticketPanel.add(namesMenu);
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
    public String getPersonWhoPaid(){
        return namesMenu.getSelectedItem().toString();
    }
}
