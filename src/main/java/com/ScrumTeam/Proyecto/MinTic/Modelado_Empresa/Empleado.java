package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)private Long id;
    private String nombre;
    @Column(nullable = false)
    private String correo;
    @OneToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name= "empresa")
    private Empresa empresa;
    private String rol;

    //private List<MovimientoDinero> transacciones = new ArrayList<>();
    
    public enum NombreRol {
        administrador, operativo
        }
    
    //constructor
    public Empleado(Long id, String nombre, String correo, Perfil perfil, Empresa empresa, String rol) {

        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.empresa = empresa;
        this.rol = rol;
    }

    /*public void addMovimientoDinero(MovimientoDinero transaccion) {
      transacciones.add(transaccion);
    }*/
    
    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
