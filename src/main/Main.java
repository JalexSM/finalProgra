package main;

import model.Course;
import model.Evaluation;
import model.Laboratory;
import model.ProjectWork;
import model.Student;
import model.WrittenExam;
import repository.Database;
import service.CourseService;
import service.EnrollmentService;
import service.GradeService;
import service.StudentService;
import ui.MainFrame;

public class Main {

	public static void main(String[] args) {

		// =========================
		// START UI
		// =========================
		new MainFrame();

		// =========================
		// CREATE SERVICES
		// =========================
		StudentService studentService = new StudentService();

		EnrollmentService enrollmentService = new EnrollmentService();

		GradeService gradeService = new GradeService();
		
		CourseService courseservice = new CourseService();

		// =========================
		// CREATE STUDENTS
		// =========================
		Student student1 = new Student("2025001", "Alexander", "Monroy", "alexander@gmail.com");

		Student student2 = new Student("2025002", "Gesler", "Duque", "gesler@gmail.com");

		// =========================
		// SAVE STUDENTS
		// =========================
		studentService.saveStudent(student1);

		studentService.saveStudent(student2);

		// Duplicate test
		studentService.saveStudent(student1);

		// =========================
		// CREATE COURSE
		// =========================
		Course course1 = new Course("IPC101", "Introduction to Programming", 5, 2);
		Course course2 = new Course("DEI102", "Derecho informatico", 4, 4);
		Course course3 = new Course("MAT101", "Mathematics", 5, 3);

		// =========================
		// SAVE COURSE
		// =========================
		courseservice.saveCourse(course1);
		courseservice.saveCourse(course2);
		courseservice.saveCourse(course3);

		// =========================
		// TEST ENROLLMENTS
		// =========================
		System.out.println(enrollmentService.enrollStudent(student1, course2));

		System.out.println(enrollmentService.enrollStudent(student2, course1));

		// Duplicate enrollment test
		System.out.println(enrollmentService.enrollStudent(student1, course1));

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

		for (Course course : Database.courses) {
			System.out.println(course);
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
		double finalGrade = gradeService.calculateFinalGrade(course1);

		// =========================
		// FINAL RESULT
		// =========================
		System.out.println("\n===== FINAL RESULT =====");

		System.out.println("Final course grade: " + finalGrade);

		System.out.println("Status: " + gradeService.getStatus(finalGrade));
	}
}