package com.example.talleres;

public class Solicitudes {
    Integer id_solicitudes;
    Integer talleres_id_taller;
    String nombre;
    String matricula;
    Integer carreras_id_carrera;
    Integer cuatrimestre_id_cuatrimestre;
    String seccion;
    String fecha_envio;

    public Solicitudes(Integer id_solicitudes, Integer talleres_id_taller, String nombre, String matricula, Integer carreras_id_carrera, Integer cuatrimestre_id_cuatrimestre, String seccion, String fecha_envio) {
        this.id_solicitudes = id_solicitudes;
        this.talleres_id_taller = talleres_id_taller;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carreras_id_carrera = carreras_id_carrera;
        this.cuatrimestre_id_cuatrimestre = cuatrimestre_id_cuatrimestre;
        this.seccion = seccion;
        this.fecha_envio = fecha_envio;
    }

    public Integer getId_solicitudes() {
        return id_solicitudes;
    }

    public void setId_solicitudes(Integer id_solicitudes) {
        this.id_solicitudes = id_solicitudes;
    }

    public Integer getTalleres_id_taller() {
        return talleres_id_taller;
    }

    public void setTalleres_id_taller(Integer talleres_id_taller) {
        this.talleres_id_taller = talleres_id_taller;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getCarreras_id_carrera() {
        return carreras_id_carrera;
    }

    public void setCarreras_id_carrera(Integer carreras_id_carrera) {
        this.carreras_id_carrera = carreras_id_carrera;
    }

    public Integer getCuatrimestre_id_cuatrimestre() {
        return cuatrimestre_id_cuatrimestre;
    }

    public void setCuatrimestre_id_cuatrimestre(Integer cuatrimestre_id_cuatrimestre) {
        this.cuatrimestre_id_cuatrimestre = cuatrimestre_id_cuatrimestre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }
}
