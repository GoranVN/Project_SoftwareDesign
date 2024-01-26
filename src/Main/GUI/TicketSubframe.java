package GUI;

import Person.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TicketSubframe extends JFrame{
    private Controller controller;
    private JCheckBox evenlySplit;
    private JComboBox<String> menu;
    private JComboBox<String> namesMenu;
    private JTextField totalPrice;
    private JLabel label;
    private JTable table;
    private DefaultTableModel tableModel;

    public TicketSubframe(Controller controller) {
        super("New Ticket");
        this.controller = controller;

        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(null);

        label = new JLabel("Detailed list: ");
        label.setBounds(45, 100, 80, 30);
        ticketPanel.add(label);

        totalPrice = new JTextField();
        totalPrice.setBounds( 125, 100, 150, 30);
        ticketPanel.add(totalPrice);
        totalPrice.setVisible(false);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Price");
        table = new JTable(tableModel);
        table.getTableHeader().setReorderingAllowed(false);
        for (String person : controller.getPersonDB()) {
            tableModel.addRow(new Object[]{person, 0.0});
        }
        JScrollPane scrollPane = new JScrollPane(table);
        ticketPanel.add(scrollPane);
        scrollPane.setBounds( 125, 100, 150, 30+controller.getPersonDB().size()*15);

        evenlySplit = new JCheckBox("Ticket evenly split?");
        evenlySplit.setBounds(125, 100+scrollPane.getHeight(), 200, 30);
        ticketPanel.add(evenlySplit);

        JLabel typeOfTicket = new JLabel("Ticket: ");
        typeOfTicket.setBounds(65, 30, 60, 30);
        typeOfTicket.setBackground(null);
        ticketPanel.add(typeOfTicket);

        String[] tickets = {"Airplane Ticket", "Restaurant Ticket", "Taxi Ticket", "Concert Ticket"};
        menu = new JComboBox<>(tickets);
        menu.setBounds( 125, 25, 150, 30);
        ticketPanel.add(menu);

        JLabel whoPaid = new JLabel("Who paid?");
        whoPaid.setBounds(60, 65, 60, 30);
        whoPaid.setBackground(null);
        ticketPanel.add(whoPaid);

        namesMenu = new JComboBox<>(controller.getPersonDB());
        namesMenu.setBounds( 125, 60, 150, 30);
        ticketPanel.add(namesMenu);

        JButton ok = new JButton("Ok");
        ok.setBounds(75, 150+scrollPane.getHeight(), 100, 30);
        ticketPanel.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(200, 150+scrollPane.getHeight(), 100, 30);
        ticketPanel.add(cancel);

        this.add(ticketPanel);
        ticketPanel.setPreferredSize(new Dimension(400, 230+scrollPane.getHeight()));
        this.pack();
        this.setLocation(450, 300);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        evenlySplit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getEvenlySplit()){
                    evenlySplit.setBounds(125, 130, 200, 30);
                    cancel.setBounds(200, 180, 100, 30);
                    ok.setBounds(75, 180, 100, 30);
                    ticketPanel.setPreferredSize(new Dimension(400, 260));
                    totalPrice.setVisible(true);
                    label.setText("Total price: ");
                    scrollPane.setVisible(false);
                }
                else {
                    cancel.setBounds(200, 150+scrollPane.getHeight(), 100, 30);
                    ok.setBounds(75, 150+scrollPane.getHeight(), 100, 30);
                    evenlySplit.setBounds(125, 100+scrollPane.getHeight(), 200, 30);
                    ticketPanel.setPreferredSize(new Dimension(400, 230+scrollPane.getHeight()));
                    totalPrice.setVisible(false);
                    label.setText("Detailed list: ");
                    scrollPane.setVisible(true);
                }
                pack();
            }
        });
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
    public double getTotalprice(){
        return Double.parseDouble(totalPrice.getText());
    }

    public Map<String, Double> getDetailedList() {
        Map<String, Double> map = new LinkedHashMap<>();
        if(table.isEditing()){
            table.getCellEditor().stopCellEditing();
        }
        int rowCount = tableModel.getRowCount();
        for (int row = 0; row < rowCount; row++) {
            String name = tableModel.getValueAt(row, 0).toString();
            Double price = Double.parseDouble(tableModel.getValueAt(row, 1).toString());
            map.put(name, price);
        }
        return map;
    }
}
