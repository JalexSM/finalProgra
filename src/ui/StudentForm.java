package ui;

import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {

    private static final long serialVersionUID = 1L;

    public StudentForm() {

        setTitle("Student Registration");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblId = new JLabel("Student ID:");
        JLabel lblFirstName = new JLabel("First Name:");
        JLabel lblLastName = new JLabel("Last Name:");
        JLabel lblEmail = new JLabel("Email:");

        JTextField txtId = new JTextField();
        JTextField txtFirstName = new JTextField();
        JTextField txtLastName = new JTextField();
        JTextField txtEmail = new JTextField();

        JButton btnSave = new JButton("Save");

        panel.add(lblId);
        panel.add(txtId);

        panel.add(lblFirstName);
        panel.add(txtFirstName);

        panel.add(lblLastName);
        panel.add(txtLastName);

        panel.add(lblEmail);
        panel.add(txtEmail);

        panel.add(new JLabel());
        panel.add(btnSave);

        add(panel);

        btnSave.addActionListener(e -> {

            String id = txtId.getText();
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();
            String email = txtEmail.getText();

            if (id.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                JOptionPane.showMessageDialog(null, "Student saved successfully");
            }

        });

        setVisible(true);
    }
}