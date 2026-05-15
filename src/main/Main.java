package main;

import model.Course;
import model.Evaluation;
import model.Laboratory;
import model.ProjectWork;
import model.Student;
import model.WrittenExam;
import repository.Database;
import service.GradeService;
import ui.MainFrame;
import service.EnrollmentSService;

public class Main {
	public static void main(String[] args) {
		new MainFrame();
		// =========================
		// CREATE STUDENTS
		// =========================

		Student student1 = new Student("2025001", "Alexander", "Monroy", "alexander@gmail.com");

		Student student2 = new Student("2025002", "Gesler", "Duque", "gesler@gmail.com");

		// =========================
		// CREATE COURSE
		// =========================

		Course course1 = new Course("IPC101", "Introduction to Programming", 5, 2); // capacity

		// =========================
		// SAVE IN DATABASE
		// =========================

		Database.students.add(student1);
		Database.students.add(student2);

		Database.courses.add(course1);

		// =========================
		// CREATE ENROLLMENT SERVICE
		// =========================

		EnrollmentSService enrollmentService = new EnrollmentSService();

		// =========================
		// TEST ENROLLMENTS
		// =========================

		enrollmentService.enrollStudent(student1, course1);

		enrollmentService.enrollStudent(student2, course1);

		enrollmentService.enrollStudent(student1, course1);

		// =========================
		// CREATE EVALUATIONS
		// =========================

		Evaluation exam = new WrittenExam("Midterm Exam", 40, 85);

		Evaluation laboratory = new Laboratory("Laboratory 1", 20, 90, 80);

		Evaluation project = new ProjectWork("Final Project", 40, 95, true);

		// =========================
		// ADD EVALUATIONS TO COURSE
		// =========================

		course1.addEvaluation(exam);
		course1.addEvaluation(laboratory);
		course1.addEvaluation(project);

		// =========================
		// SHOW STUDENTS
		// =========================

		System.out.println("\n===== STUDENTS =====");

		for (Student student : Database.students) {
			System.out.println(student);
		}

		// =========================
		// SHOW COURSES
		// =========================

		System.out.println("\n===== COURSES =====");

		for (Course c : Database.courses) {
			System.out.println(c);
		}

		// =========================
		// SHOW ENROLLMENTS
		// =========================

		System.out.println("\n===== ENROLLMENTS =====");

		Database.enrollments.forEach(System.out::println);

		// =========================
		// SHOW EVALUATIONS
		// =========================

		System.out.println("\n===== EVALUATIONS =====");

		for (Evaluation evaluation : course1.getEvaluations()) {

			System.out.println(evaluation.getName() + " -> Contribution: " + evaluation.obtainScore());
		}

		// =========================
		// FINAL GRADE
		// =========================

		GradeService gradeService = new GradeService();

		double finalGrade = gradeService.calculateFinalGrade(course1);

		System.out.println("\n===== FINAL RESULT =====");

		System.out.println("Final course grade: " + finalGrade);

		System.out.println("Status: " + gradeService.getStatus(finalGrade));
	}

}
