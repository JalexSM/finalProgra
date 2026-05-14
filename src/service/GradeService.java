
package service;
import model.Enrollment;
import model.Evaluation;

public class GradeService {
    
    public double calcularNotaAutomatica(Enrollment inscripcion, Evaluation evaluacion) {
        double notaFinal = evaluacion.getNotaCualitativa(); 
        return notaFinal;
    }

    public String obtenerEstado(double notaFinal) {
        return (notaFinal >= 61) ? "APROBADO" : "REPROBADO";
    }
}