package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String nombre;
    @Column(unique = true)
    private String nit;
    @Column
    private String telefono;
    @Column
    private String direccion;

    @OneToMany
    @JoinColumn
    private List<Empleado> empleados;
    @OneToMany(mappedBy = "empresa")
    private List<MovimientoDinero> movimiento;


    public Empresa(String nombre, String nit, String telefono,
                   String direccion, List<Empleado> empleados, List<MovimientoDinero> movimiento) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleados = empleados;
        this.movimiento = movimiento;
    }

    public Empresa() {
    }


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

    public List<Empleado> getEmpleado() {
        return empleados;
    }

    public void setEmpleado(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<MovimientoDinero> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(List<MovimientoDinero> movimiento) {
        this.movimiento = movimiento;
    }
}
