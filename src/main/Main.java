package main;

import model.Course;
import model.Enrollment;
import model.Evaluation;
import model.Laboratory;
import model.ProjectWork;
import model.Student;
import model.WrittenExam;
import ui.MainFrame;
public class Main {
	public static void main(String[] args) {
		new MainFrame();
		

		// Create main objects
		Student student = createStudent();
		Course course = createCourse();
		Enrollment enrollment = createEnrollment(student, course);

		// Create evaluations
		Evaluation exam = createExam();
		Evaluation laboratory = createLaboratory();
		Evaluation project = createProject();

		// Show information
		showStudent(student);
		showCourse(course);
		showEnrollment(enrollment);

		// Show evaluations
		showEvaluations(exam, laboratory, project);

		// Calculate final result
		calculateFinalResult(exam, laboratory, project);
	}

	// =========================
	// CREATION METHODS
	// =========================

	public static Student createStudent() {

		return new Student("2025001", "Alexander", "Monroy", "alexander@gmail.com");
	}

	public static Course createCourse() {

		return new Course("IPC101", "Introduction to Programming", 5, 30);
	}

	public static Enrollment createEnrollment(Student student, Course course) {

		return new Enrollment(student, course);
	}

	public static Evaluation createExam() {

		return new WrittenExam("Midterm Exam", 40, 85);
	}

	public static Evaluation createLaboratory() {

		return new Laboratory("Laboratory 1", 20, 90, 80);
	}

	public static Evaluation createProject() {

		return new ProjectWork("Final Project", 40, 95, true);
	}

	// =========================
	// DISPLAY METHODS
	// =========================

	public static void showStudent(Student student) {

		System.out.println("===== STUDENT =====");
		System.out.println(student);
	}

	public static void showCourse(Course course) {

		System.out.println("\n===== COURSE =====");
		System.out.println(course);
	}

	public static void showEnrollment(Enrollment enrollment) {

		System.out.println("\n===== ENROLLMENT =====");
		System.out.println(enrollment);
	}

	public static void showEvaluations(Evaluation exam, Evaluation laboratory, Evaluation project) {

		System.out.println("\n===== EVALUATIONS =====");

		System.out.println(exam.getName() + " -> Contribution: " + exam.obtainScore());

		System.out.println(laboratory.getName() + " -> Contribution: " + laboratory.obtainScore());

		System.out.println(project.getName() + " -> Contribution: " + project.obtainScore());
	}

	// =========================
	// FINAL RESULT METHOD
	// =========================

	public static void calculateFinalResult(Evaluation exam, Evaluation laboratory, Evaluation project) {

		double finalGrade = exam.obtainScore() + laboratory.obtainScore() + project.obtainScore();

		System.out.println("\n===== FINAL RESULT =====");
		System.out.println("Final course grade: " + finalGrade);

		if (finalGrade >= 61) {
			System.out.println("Status: PASSED");
		} else {
			System.out.println("Status: FAILED");
		}

	}

}
