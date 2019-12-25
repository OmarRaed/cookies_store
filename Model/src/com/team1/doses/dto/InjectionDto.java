package com.team1.doses.dto;

public class InjectionDto {
    private int dosePerKg = 0;
    private int doseNumber = 0;
    private String name;
    
    public InjectionDto () {
       }

    public InjectionDto (int dosePerKg, int doseNumber, String name) {
        this.dosePerKg = dosePerKg;
        this.doseNumber = doseNumber;
        this.name = name;
    }

    public int getDosePerKg() {
        return dosePerKg;
    }

    public int getDoseNumber() {
        return doseNumber;
    }


    public String getName() {
        return name;
    }


    public void setDosePerKg(int dosePerKg) {
        this.dosePerKg = dosePerKg;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public void setName(String name) {
        this.name = name;
    }


}
