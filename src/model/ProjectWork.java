package model;

public class ProjectWork extends Evaluation{
	
	private double projectScore;
	private boolean submitWork;
	public ProjectWork(String name, double weighing, double projectScore, boolean submitWork) {
		super(name, weighing);
		this.projectScore = projectScore;
		this.submitWork = submitWork;
	}
	@Override
	public double obtainScore() {
		
		if(!submitWork) {
			return 0;
			
		}
		
		return (projectScore * weighing)/100;
	}	

	
	
	
}
