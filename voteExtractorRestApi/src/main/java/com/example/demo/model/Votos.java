package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="representantes_votos")
public class Votos implements Serializable {

    @Id
    @Column(name = "id_participante")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false, length = 50, unique = true)
    private String nombre;
    @Column(name = "votos", nullable = false, length = 2)
    private int votos;
    @Column(name = "partido", nullable = false, length = 2)
    private int partido;
   

    public Votos() {
    }

    public Votos(int id, String nombre, int votos,int partido) {
        this.id = id;
        this.nombre = nombre;
        this.votos = votos;
        this.partido = partido;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    
    public int getPartido() {
        return partido;
    }

    public void setPartido(int partido) {
        this.partido = partido;
    }

   

    @Override
    public String toString() {
        return String.format(
                "Representante[id=%d,nombre='%s',votos=%d,partido=%d,",id,nombre,votos,partido);
    }
}
