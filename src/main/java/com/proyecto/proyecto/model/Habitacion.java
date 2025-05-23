package com.proyecto.proyecto.model;

public class Habitacion {
    private Long id;
    private String numero;
    private String tipo;
    private int capacidad;

    public Habitacion(){

    }

    public Habitacion(Long id, String numero, String tipo, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
