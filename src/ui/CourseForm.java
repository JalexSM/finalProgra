package ui;

import javax.swing.*;
import java.awt.*;

public class CourseForm extends JFrame {

    private static final long serialVersionUID = 1L;

    public CourseForm() {

        setTitle("Course Registration");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblCode = new JLabel("Course Code:");
        JLabel lblName = new JLabel("Course Name:");
        JLabel lblCredits = new JLabel("Credits:");
        JLabel lblCapacity = new JLabel("Capacity:");

        JTextField txtCode = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtCredits = new JTextField();
        JTextField txtCapacity = new JTextField();

        JButton btnSave = new JButton("Save");

        panel.add(lblCode);
        panel.add(txtCode);

        panel.add(lblName);
        panel.add(txtName);

        panel.add(lblCredits);
        panel.add(txtCredits);

        panel.add(lblCapacity);
        panel.add(txtCapacity);

        panel.add(new JLabel());
        panel.add(btnSave);

        add(panel);

        btnSave.addActionListener(e -> {

            if (txtCode.getText().isEmpty() || txtName.getText().isEmpty()
                    || txtCredits.getText().isEmpty() || txtCapacity.getText().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill in all fields");

            } else {

                JOptionPane.showMessageDialog(null, "Course saved successfully");

            }
        });

        setVisible(true);
    }
}