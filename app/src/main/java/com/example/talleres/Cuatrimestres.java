package com.example.talleres;

public class Cuatrimestres {
    Integer id_cuatrimestre;
    String cuatrimestre;

    public Cuatrimestres(Integer id_cuatrimestre, String cuatrimestre) {
        this.id_cuatrimestre = id_cuatrimestre;
        this.cuatrimestre = cuatrimestre;
    }

    public Integer getId_cuatrimestre() {
        return id_cuatrimestre;
    }

    public void setId_cuatrimestre(Integer id_cuatrimestre) {
        this.id_cuatrimestre = id_cuatrimestre;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
