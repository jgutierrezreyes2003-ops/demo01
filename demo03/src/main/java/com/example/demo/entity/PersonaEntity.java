package com.example.demo.entity;

public class PersonaEntity {
    
    private Long id;
    private String nombre;


    public PersonaEntity() {
    }

    public PersonaEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}