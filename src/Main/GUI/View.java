package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class View extends JFrame{
    private Controller controller;
    private DefaultTableModel model;
    public View(Controller controller) {
        super("Money Tracker");
        this.controller = controller;
        JButton ticketButton = new JButton("New Ticket");
        JButton addPersonButton = new JButton("Add Person");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(ticketButton);
        ticketButton.setBounds(125, 500, 100, 30);
        panel.add(addPersonButton);
        addPersonButton.setBounds(275, 500, 100, 30);

        String[] header = {"Persons"};
        String[][] data = {};
        model = new DefaultTableModel(data, header);
        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 300, 300);
        panel.add(scrollPane);
        panel.setPreferredSize(new Dimension(500, 600));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocation(400, 100);
        this.setVisible(true);

        ticketButton.addActionListener(controller);
        addPersonButton.addActionListener(controller);
    }

    public void addPersonToTable(String[] name){
        model.addRow(name);
    }

    public void addTicketToTable(String ticketName, Vector<Double> balances){
        model.addColumn(ticketName, balances);
    }
}
