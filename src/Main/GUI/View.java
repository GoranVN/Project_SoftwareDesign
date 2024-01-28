package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class View extends JFrame{
    private Controller controller;
    private JTable table;
    private DefaultTableModel model;
    public View(Controller controller) {
        super("Money Tracker");
        this.controller = controller;
        JButton ticketButton = new JButton("New Ticket");
        JButton addPersonButton = new JButton("Add Person");
        JButton updateTotal = new JButton("Update Total");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(ticketButton);
        ticketButton.setBounds(125, 450, 100, 30);
        panel.add(addPersonButton);
        addPersonButton.setBounds(275, 450, 100, 30);
        panel.add(updateTotal);
        updateTotal.setBounds(175, 500, 150, 30);

        String[] header = {"Participants", "Total"};
        String[][] data = {};
        model = new DefaultTableModel(data, header);
        table = new JTable(model);

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
        updateTotal.addActionListener(controller);
    }

    public void addPersonToTable(String[] nameAndTotal){
        model.addRow(nameAndTotal);
    }

    public void addTicketToTable(String ticketName, Vector<String> balances){
        model.addColumn(ticketName, balances);
    }

    public void updateTotal(Vector<String> totalBalances){
        for(int i=0; i<model.getRowCount(); i++){
            model.setValueAt(totalBalances.get(i), i, 1 );
        }
    }
}
