package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.*;

@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)private Long id;
    private String image;
    private String telefono;
  /*  @OneToOne
    @JoinColumn(name = "usuario")
    private Empleado usuario;*/

    public Perfil(Long id, String image, String telefono/*Empleado usuario*/) {
        this.id = id;
        this.image = image;
        this.telefono = telefono;
        /*this.usuario = usuario;*/
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

   /* public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }*/
}
