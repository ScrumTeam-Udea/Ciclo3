package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

public class Perfil {

    private long id;
    private String image;
    private String telefono;


    public Perfil(long id, String image, String telefono) {
        this.id = id;
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
