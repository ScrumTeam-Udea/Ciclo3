package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.GenerationType;
import java.util.*;



public class Empresa {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;
    
    private List<Empleado> empleados = new ArrayList<>();

    private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    //constructor
    public Empresa(String nombre, String direccion, String telefono, String nit) {
       
        super();
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;

    }
    
    public void addEmpleado (Empleado empleado) {
        empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado1) {
        empleados.remove(empleado1);
    }

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
