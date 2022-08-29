package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;


import java.lang.*;


public class Empresa {
    private long id;
    private String nombre;
    private String nit;
    private String telefono;
    private String direccion;
    
    private List<Empleado> empleados = new ArrayList<>();

    private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    //constructor
    public Empresa(long id, String nombre, String direccion, String telefono, String nit) {
       
        super();
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleado = empleado;
    }
    
    public void addEmpleado (Empleado empleado) {
        empleados.add(empleado);
    }

    public void removeEmpleado(Empleado empleado1) {
        empleados.remove(empleado1)
    }

    //getters y setters
    
    public int getId() {
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
