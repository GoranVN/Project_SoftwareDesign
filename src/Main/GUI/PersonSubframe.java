package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PersonSubframe extends JFrame {
    private Controller controller;
    private JTextArea personName;
    public PersonSubframe(Controller controller) {
        super("New Person");
        this.controller = controller;

        JPanel personPanel = new JPanel();
        personPanel.setLayout(null);
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton("Cancel");
        personName = new JTextArea();

        personName.setBounds(100, 60, 100, 20);
        personName.setBorder(new LineBorder(new Color(0, 0, 0)));
        personPanel.add(personName);
        ok.setBounds(40, 100, 100, 30);
        personPanel.add(ok);
        cancel.setBounds(160, 100, 100, 30);
        personPanel.add(cancel);
        personPanel.setPreferredSize(new Dimension(300, 150));

        this.setName("Add person");
        this.add(personPanel);
        this.pack();
        this.setLocation(450, 300);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        ok.addActionListener(controller);
        cancel.addActionListener(controller);
        this.addWindowListener(controller);
    }
    public String getTextAreaValue(){
        return personName.getText();
    }
}
