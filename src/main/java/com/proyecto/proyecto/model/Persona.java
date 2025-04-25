package com.proyecto.proyecto.model;
public class Persona {
    private Long id;
    private String nombre;
    private String gmail;
    public Persona() {
    }
    public Persona(Long id, String nombre, String gmail) {
        this.id = id;
        this.nombre = nombre;
        this.gmail = gmail;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getGmail() {
        return gmail;
    }
    public void setGmail(String Gmail) {
        this.gmail = gmail;
    }
}

