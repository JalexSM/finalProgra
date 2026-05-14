package service;

import model.Course;
import model.Evaluation;

public class GradeService {

	public double calculateFinalGrade(Course course) {

		double finalGrade = 0;

		for (Evaluation evaluation : course.getEvaluations()) {

			finalGrade += evaluation.obtainScore();
		}

		return finalGrade;
	}

	public String getStatus(double finalGrade) {	

		if (finalGrade >= 61) {
			return "PASSED";
		}

		return "FAILED";
	}
}
