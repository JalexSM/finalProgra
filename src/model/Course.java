package model;

import java.util.ArrayList;

public class Course {

    private String code;
    private String courseName;
    private int credits;
    private int capacity;

    private ArrayList<Evaluation> evaluations;

    public Course(String code,
                  String courseName,
                  int credits,
                  int capacity) {

        this.code = code;
        this.courseName = courseName;
        this.credits = credits;
        this.capacity = capacity;

        this.evaluations = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(evaluation);
    }

    @Override
    public String toString() {
        return """
               Course
               -------------------------
               Code      : %s
               Name      : %s
               Credits   : %d
               Capacity  : %d
               """.formatted(code, courseName, credits, capacity);
    }
}