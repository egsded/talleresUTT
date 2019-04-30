package com.example.talleres;

public class alumnosdeprofesores {
    String matricula;
    String nombre;
    String cuatrimestre;
    String horas;

    public alumnosdeprofesores(String matricula, String nombre, String cuatrimestre, String horas) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
        this.horas = horas;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
