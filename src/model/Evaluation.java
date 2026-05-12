package model;

public abstract class Evaluation {
	
	protected String name; 
	protected double weighing;
	public Evaluation(String name, double weighing) {
		super();
		this.name = name;
		this.weighing = weighing;
	}
	
	public abstract double obtainScore() ;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeighing() {
		return weighing;
	}

	public void setWeighing(double weighing) {
		this.weighing = weighing;
	}
		
	
	
	
	
	
	

}
