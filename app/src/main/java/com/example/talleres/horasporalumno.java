package com.example.talleres;

public class horasporalumno {
    String taller;
    String profesor;
    String horas;

    public horasporalumno(String taller, String profesor, String horas) {
        this.taller = taller;
        this.profesor = profesor;
        this.horas = horas;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getEncargado() {
        return profesor;
    }

    public void setEncargado(String profesor) {
        this.profesor = profesor;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
