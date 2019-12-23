package com.team1.doses.dto;


public class AntipyreticDto {
    private int dosePerKg = 0;
    private double concentration = 0;
    private int doseNumber = 0;
    private String name;

    public AntipyreticDto(int dosePerKg, double concentration, int doseNumber, String name) {
        this.dosePerKg = dosePerKg;
        this.concentration = concentration;
        this.doseNumber = doseNumber;
        this.name = name;
    }

    public int getDosePerKg() {
        return dosePerKg;
    }

    public double getConcentration() {
        return concentration;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

