package GUI;

import Databases.PersonDatabase;
import Databases.TicketDatabase;
import Person.Person;
import Tickets.TicketFactory;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.*;

public class Controller extends WindowController implements ActionListener{
    private TicketDatabase ticketDB;
    private PersonDatabase personDB;
    private View view;
    private TicketSubframe ticketSubframe;
    private PersonSubframe personSubframe;
    private TicketFactory factory;
    public Controller(){
        personDB = PersonDatabase.getInstance();
        ticketDB = TicketDatabase.getInstance(personDB);
        view = new View(this);
        factory = new TicketFactory();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New Ticket":
                ticketSubframe = new TicketSubframe(this);
                view.setEnabled(false);
                break;
            case "Add Person":
                personSubframe = new PersonSubframe(this);
                view.setEnabled(false);
                break;
            case "Cancel":
                if (ticketSubframe != null) {
                    view.setEnabled(true);
                    ticketSubframe.dispose();
                    ticketSubframe = null;
                } else if (personSubframe != null) {
                    view.setEnabled(true);
                    personSubframe.dispose();
                    personSubframe = null;
                }
                break;
            case "Ok":
                if (personSubframe != null) {
                    String name = personSubframe.getTextAreaValue();
                    personDB.addEntry(new Person(name, 0.0));
                    view.setEnabled(true);
                    view.addPersonToTable(new String[]{name});
                    personSubframe.dispose();
                    personSubframe = null;
                } else if (ticketSubframe != null) {
                    Boolean evenlySplit = ticketSubframe.getEvenlySplit();
                    String typeOfTicket = ticketSubframe.getTypeOfTicket();
                    String personWhoPaid = ticketSubframe.getPersonWhoPaid();
                    Vector<String> balances = new Vector<>();
                    if (evenlySplit) {
                        double totalPrice = ticketSubframe.getTotalprice();
                        ticketDB.newEvenlySplitTicket(typeOfTicket, totalPrice, personDB.getPerson(personWhoPaid), personDB.getEntries());
                        DecimalFormat format = new DecimalFormat("#.##");
                        for(int i=0; i<getPersonDB().size(); i++){
                            Vector<String> person = getPersonDB();
                            if(!Objects.equals(person.get(i), personWhoPaid)){
                                String value = format.format(totalPrice/getPersonDB().size());
                                balances.add(i, value);
                            }
                            else{
                                balances.add(i, "Paid");
                            }
                        }
                    } else {
                        Map<String, Double> list = ticketSubframe.getDetailedList();
                        Map<Person, Double> detailedList = new HashMap<>();
                        for (Map.Entry<String, Double> entry : list.entrySet()) {
                            Person person = personDB.getPerson(entry.getKey());
                            double value = entry.getValue();
                            detailedList.put(person, value);
                            if(!Objects.equals(entry.getKey(), personWhoPaid)){
                                balances.add(Double.toString(value));
                            }
                            else{
                                balances.add("Paid");
                            }
                        }
                        ticketDB.newNotEvenlySplitTicket(typeOfTicket, personDB.getPerson(personWhoPaid), detailedList);
                    }
                    view.setEnabled(true);
                    view.addTicketToTable(typeOfTicket, balances);
                    ticketSubframe.dispose();
                    ticketSubframe = null;
                }
                break;
            case "Calculate Total":
                Vector<String> totalBalances = new Vector<>();
                DecimalFormat format = new DecimalFormat("#.##");
                JTable table = view.getTable();
                TableColumnModel columnModel = table.getColumnModel();
                for (int i = 0; i < getPersonDB().size(); i++) {
                    totalBalances.add(i, format.format(personDB.getEntries().get(i).getBalance()));
                }
                int columnIndex = columnModel.getColumnIndex("Total");
                if (columnIndex != -1) {
                    columnModel.removeColumn(columnModel.getColumn(columnIndex));
                }
        }
    }
    @Override
    public void windowClosing(WindowEvent e) {
        if(ticketSubframe != null) {
            view.setEnabled(true);
            ticketSubframe.dispose();
            ticketSubframe = null;
        }
        else if(personSubframe != null) {
            view.setEnabled(true);
            personSubframe.dispose();
            personSubframe = null;
        }
    }
    public Vector<String> getPersonDB(){
        Vector<String> namesList = new Vector<>();
        for (Person person : personDB.getEntries())
            namesList.add(person.getName());
        return namesList;
    }
}
