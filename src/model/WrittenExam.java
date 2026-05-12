package model;

public class WrittenExam extends Evaluation{
	
	
	private double examScore;

	public WrittenExam(String name, double weighing, double examScore) {
		super(name, weighing);
		this.examScore = examScore;
	}
	
    @Override
    public double obtainScore() {
        return (examScore * weighing) / 100;
    }

	public double getExamScore() {
		return examScore;
	}

	public void setExamScore(double examScore) {
		this.examScore = examScore;
	}
		
    
    
    
    
}
