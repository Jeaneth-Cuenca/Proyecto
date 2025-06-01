package com.proyecto.proyecto.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "clente")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    private String nombre;
    private String gmail;
    private String celular;

    /**    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<persona> books;
     **/
    public Cliente() {
    }

    public Cliente(Long id, String nombre, String gmail, String celular) {
        this.id = id;
        this.nombre = nombre;
        this.gmail = gmail;
        this.celular= celular;
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

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}

