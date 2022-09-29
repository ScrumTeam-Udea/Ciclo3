package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;


import javax.persistence.*;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String concepto;
    @Column
    private float monto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    @ManyToOne
    private Empresa empresa;


    public MovimientoDinero(String concepto, float monto, Empleado empleado, Empresa empresa) {
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
    }


    public MovimientoDinero() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
