package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import java.lang.*;

public class Empleado {
    private int id;
    private String nombre;
    private String correo;
    private Perfil perfil;
    private Empresa empresa;
    private String rol;

    private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    //constructor
    public Empleado(int id, String nombre, String correo, Empresa empresa, String rol) {
        
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public void addMovimientoDinero(MovimientoDinero transaccion) {
      transacciones.add(transaccion);
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
