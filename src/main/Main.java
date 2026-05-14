package main;

import model.Course;
import model.Enrollment;
import model.Evaluation;
import model.Laboratory;
import model.ProjectWork;
import model.Student;
import model.WrittenExam;
import repository.Database;
import service.GradeService;
import ui.MainFrame;

public class Main {
	public static void main(String[] args) {
		new MainFrame();

		Student student = createStudent();

		Course course = createCourse();

		Enrollment enrollment = createEnrollment(student, course);

		// =========================
		// CREATE EVALUATIONS
		// =========================

		Evaluation exam = createExam();

		Evaluation laboratory = createLaboratory();

		Evaluation project = createProject();

		// =========================
		// ADD EVALUATIONS TO COURSE
		// =========================

		course.addEvaluation(exam);

		course.addEvaluation(laboratory);

		course.addEvaluation(project);

		// =========================
		// SAVE IN DATABASE
		// =========================

		Database.students.add(student);

		Database.courses.add(course);

		Database.enrollments.add(enrollment);

		// =========================
		// DISPLAY INFORMATION
		// =========================

		showStudent(student);

		showCourse(course);

		showEnrollment(enrollment);

		showEvaluations(course);

		// =========================
		// FINAL RESULT
		// =========================

		GradeService gradeService = new GradeService();

		double finalGrade = gradeService.calculateFinalGrade(course);

		System.out.println("\n===== FINAL RESULT =====");

		System.out.println("Final course grade: " + finalGrade);

		System.out.println("Status: " + gradeService.getStatus(finalGrade));
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

		System.out.println("\n===== STUDENT =====");

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

	public static void showEvaluations(Course course) {

		System.out.println("\n===== EVALUATIONS =====");

		for (Evaluation evaluation : course.getEvaluations()) {

			System.out.println(evaluation.getName() + " -> Contribution: " + evaluation.obtainScore());
		}

	}

}
