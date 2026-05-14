package model;

import java.util.ArrayList;

public class Enrollment {

	private Student student;
	private Course course;
	private ArrayList<Double> grades;

	public Enrollment(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
		this.grades = new ArrayList<>();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public ArrayList<Double> getGrades() {
		return grades;
	}

	public void addGrade(double grade) {
		grades.add(grade);

	}

	@Override
	public String toString() {
		return """
				Enrollment
				-------------------------
				Student : %s %s
				Course  : %s
				""".formatted(student.getFirstName(), student.getLastName(), course.getCourseName());
	}

}
