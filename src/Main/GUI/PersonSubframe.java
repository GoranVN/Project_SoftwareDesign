package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PersonSubframe extends JFrame {
    private Controller controller;
    private JTextField personName;
    private JLabel label;
    public PersonSubframe(Controller controller) {
        super("New Participant");
        this.controller = controller;

        JPanel personPanel = new JPanel();
        personPanel.setPreferredSize(new Dimension(300, 150));
        personPanel.setLayout(null);

        JButton ok = new JButton("Ok");
        ok.setBounds(40, 100, 100, 30);
        personPanel.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(160, 100, 100, 30);
        personPanel.add(cancel);

        label = new JLabel("Name: ");
        label.setBounds(50, 55, 100, 30);
        personPanel.add(label);

        personName = new JTextField();
        personName.setBounds(100, 60, 100, 20);
        personName.setBorder(new LineBorder(new Color(0, 0, 0)));
        personPanel.add(personName);

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
