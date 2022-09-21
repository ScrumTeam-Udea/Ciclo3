package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class MovimientoDinero {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float monto;
    private String concepto;
    private Empleado usuario;
    private Empresa empresa;

    //constructor
    public MovimientoDinero(int monto, String concepto, Empleado usuario, Empresa empresa) {
        super();
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    //getters y setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public float getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }
    
     public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
