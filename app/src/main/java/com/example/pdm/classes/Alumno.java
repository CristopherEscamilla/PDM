package com.example.pdm.classes;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private Integer noCuenta;
    private ArrayList<Integer> calificaciones;

    public Alumno(String nombre, Integer noCuenta, ArrayList<Integer> calificaciones) {
        this.nombre = nombre;
        this.noCuenta = noCuenta;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(Integer noCuenta) {
        this.noCuenta = noCuenta;
    }

    public ArrayList<Integer> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Integer> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", noCuenta=" + noCuenta +
                ", calificaciones=" + calificaciones +
                '}';
    }
}
