package model;

public class Laboratory extends Evaluation{

    private double notaPractica;
    private double notaReporte;
	public Laboratory(String name, double weighing, double notaPractica, double notaReporte) {
		super(name, weighing);
		this.notaPractica = notaPractica;
		this.notaReporte = notaReporte;
	}
	@Override
	public double obtainScore() {
		
		
        double notaFinalLab = (notaPractica * 0.70) + (notaReporte * 0.30);

        return (notaFinalLab * weighing) / 100;
	}
    
    
	
	
	
}
