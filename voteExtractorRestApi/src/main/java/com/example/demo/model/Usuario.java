package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name="usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user", nullable = false, length = 50, unique = true)
    private String user;
    @Column(name = "psw", nullable = false, length = 50)
    private String psw;
    @Column(name = "cpsw", nullable = false, length = 50)
    private String cpsw;
    @Column(name = "rol", nullable = false, length = 2)
    private int rol;

   

    public Usuario() {
    }

    public Usuario(int id, String user, String psw, String cpsw,int rol) {
        this.id = id;
        this.user = user;
        this.psw = psw;
        this.cpsw = cpsw;
        this.rol = rol;

    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpsw() {
        return cpsw;
    }

    public void setCpsw(String cpsw) {
        this.cpsw = cpsw;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return String.format(
                "Usuario[id=%d,user='%s'psw='%s',cpsw='%s',rol=%d,",id,user,psw,cpsw,rol);
    }
}
