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
        ticketDB = TicketDatabase.getInstance();
        personDB = PersonDatabase.getInstance();
        view = new View(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "New Ticket" :
                view.createTicketFrame();
                if(Objects.equals(e.getActionCommand(), "Ok")){

                }
                break;
            case "Add Person":
                view.createAddPersonFrame();
                break;
        }

    }
}
