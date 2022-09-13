package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="empleado")
public class Empleado {
    @Id
    private long id;
    @Column
    private String nombre;
    @Column
    private String correo;

    @Column
    private String rol;

    public Empleado() {

    }

    //private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    enum NombreRol {
        administrador, operario 
        }
    
    //constructor
    public Empleado(String nombre, String correo, Perfil perfil, Empresa empresa, String rol) {
        
        super();
        this.nombre = nombre;
        this.correo = correo;
        //this.perfil = perfil;
        //this.empresa = empresa;
        this.rol = rol;
    }

    /*public void addMovimientoDinero(MovimientoDinero transaccion) {
      transacciones.add(transaccion);
    }
    */
    //getters y setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
/*
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
*/
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
