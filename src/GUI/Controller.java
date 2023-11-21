package GUI;

import Databases.PersonDatabase;
import Databases.TicketDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Controller implements ActionListener {
    private TicketDatabase ticketDB;
    private PersonDatabase personDB;
    private View view;
    public Controller(){
        ticketDB = new TicketDatabase();
        personDB = new PersonDatabase();
        view = new View(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getActionCommand(), "New Ticket")){
            view.createTicketFrame();
        }
        if(Objects.equals(e.getActionCommand(), "Airplane Ticket")){

        }
    }
}
