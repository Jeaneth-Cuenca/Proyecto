package com.proyecto.proyecto.model;

public class Cliente extends Persona {

    private String nacionalidad;
    private String metodoPago;

    public Cliente() {}

    public Cliente(String nombre, String apellido, String dni, String telefono, String email,
                   String nacionalidad, String metodoPago) {
        super(nombre, apellido, dni, telefono, email);
        this.nacionalidad = nacionalidad;
        this.metodoPago = metodoPago;
    }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}