package com.example.talleres;

public class Talleres {
    Integer id_taller;
    Integer tipos_taller;
    String encargado;
    String taller;
    String descripcion;
    String horarios;
    String icono;

    public Talleres(Integer id_taller, Integer tipos_taller, String encargado, String taller, String descripcion, String horarios, String icono) {
        this.id_taller = id_taller;
        this.tipos_taller = tipos_taller;
        this.encargado = encargado;
        this.taller = taller;
        this.descripcion = descripcion;
        this.horarios = horarios;
        this.icono = icono;
    }

    public Integer getId_taller() {
        return id_taller;
    }

    public void setId_taller(Integer id_taller) {
        this.id_taller = id_taller;
    }

    public Integer getTipos_taller() {
        return tipos_taller;
    }

    public void setTipos_taller(Integer tipos_taller) {
        this.tipos_taller = tipos_taller;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getNombre() {
        return taller;
    }

    public void setNombre(String nombre) {
        this.taller = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
