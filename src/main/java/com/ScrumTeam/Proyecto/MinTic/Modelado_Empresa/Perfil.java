package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Perfil {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String image;
    private String telefono;


    public Perfil(String image, String telefono) {

        this.image = image;
        this.telefono = telefono;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
