package GUI;

import Databases.PersonDatabase;
import Databases.TicketDatabase;
import Person.Person;
import Tickets.TicketFactory;

import javax.annotation.processing.SupportedSourceVersion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;

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
        switch (e.getActionCommand()){
            case "New Ticket" :
                ticketSubframe = new TicketSubframe(this);
                view.setEnabled(false);
                break;
            case "Add Person":
                personSubframe = new PersonSubframe(this);
                view.setEnabled(false);
                break;
            case "Cancel":
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
                break;
            case "Ok":
                if(personSubframe != null){
                    String name = personSubframe.getTextAreaValue();
                    personDB.addEntry(new Person(name, 0.0));
                    view.setEnabled(true);
                    view.addPersonToTable(new String[]{name});
                    personSubframe.dispose();
                    personSubframe = null;
                }
                else if(ticketSubframe != null){
                    Boolean evenlySplit = ticketSubframe.getEvenlySplit();
                    String typeOfTicket = ticketSubframe.getTypeOfTicket();
                    String personWhoPaid = ticketSubframe.getPersonWhoPaid();
                    if(evenlySplit){
                        factory.createEvenlySplitTicket(typeOfTicket, 50, personDB.getPerson(personWhoPaid), personDB.getEntries());
                        view.setEnabled(true);
                        view.addTicketToTable(typeOfTicket);
                        ticketSubframe.dispose();
                        ticketSubframe = null;
                    }
                    else{

                    }

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
