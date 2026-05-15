package ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    public MainFrame() {

        setTitle("Campus Lite");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,10,10));

        JButton btnStudents = new JButton("Students");
        JButton btnCourses = new JButton("Courses");
        JButton btnEvaluations = new JButton("Evaluations");
        JButton btnReports = new JButton("Reports");

        panel.add(btnStudents);
        panel.add(btnCourses);
        panel.add(btnEvaluations);
        panel.add(btnReports);

        add(panel);

        btnStudents.addActionListener(e -> {
            new StudentForm();
        });

        btnCourses.addActionListener(e -> {
            new CourseForm();
        });


        setVisible(true);
    }
}