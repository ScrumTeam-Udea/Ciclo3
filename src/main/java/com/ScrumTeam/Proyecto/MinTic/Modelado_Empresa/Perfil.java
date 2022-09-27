package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;




@Entity
@Table(name ="perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String image;
    @Column
    private String phone;
    @JsonIgnore
    @OneToOne(mappedBy = "perfil")
    private Empleado empleado;


    public Perfil(String id, String image, String phone, Empleado empleado) {
        this.id = id;
        this.image = image;
        this.phone = phone;
        this.empleado = empleado;
    }


    public Perfil() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
