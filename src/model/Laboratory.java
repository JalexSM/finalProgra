package model;

public class Laboratory extends Evaluation {

	private double gradePractict;
	private double gradeReport;

	public Laboratory(String name, double weighing, double notaPractica, double notaReporte) {
		super(name, weighing);
		this.gradePractict = notaPractica;
		this.gradeReport = notaReporte;
	}

	@Override
	public double obtainScore() {

		double gradeFinalLab = (gradePractict * 0.70) + (gradeReport * 0.30);

		return (gradeFinalLab * weighing) / 100;
	}

}
