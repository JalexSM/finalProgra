package service;

import model.Student;
import repository.Database;

public class StudentService {

    public String saveStudent(Student student) {
        // 1. Validate baseline existence and ID (essential for duplicate check)
        if (student == null || student.getId() == null || student.getId().isEmpty()) {
            return "Error: Student ID is required.";
        }

        // 2. Validate duplicate ID in Database.students
        for (Student s : Database.students) {
            if (s.getId().equals(student.getId())) {
                return "Error: Student ID " + student.getId() + " already exists.";
            }
        }

        // 3. Validate mandatory fields (Now executed after duplicate validation)
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            return "Error: First name is required.";
        }

        // 4. Save in memory
        Database.students.add(student);
        
        return "Success: Student " + student.getFirstName() + " saved correctly.";
    }
}