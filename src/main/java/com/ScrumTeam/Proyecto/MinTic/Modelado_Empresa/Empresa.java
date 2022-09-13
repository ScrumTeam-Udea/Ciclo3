package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import jdk.jfr.Enabled;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    private long id;
    @Column
    private String nombre;
    @Column
    private String nit;
    @Column
    private String telefono;
    @Column
    private String direccion;


    //private ArrayList<Empleado> empleados = new ArrayList<>();

    //private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    //constructor

    public Empresa (){

    }
    public Empresa(String nombre, String direccion, String telefono, String nit) {
       
        super();
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;

    }
    
    /* public void addEmpleado (Empleado empleado) {
        empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado1) {
        empleados.remove(empleado1);
    } */

    //getters y setters
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
