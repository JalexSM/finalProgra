
package service;

public class GradeService {
    public boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    public String obtenerEstado(double notaFinal) {
        if (notaFinal >= 61) {
            return "APROBADO";
        } else {
            return "REPROBADO";
        }
    }
}