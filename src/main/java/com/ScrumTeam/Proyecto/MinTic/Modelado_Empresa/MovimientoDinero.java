package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;

import javax.persistence.*;

@Entity
@Table(name = "MovimientoDinero")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)private Long id;
    private float monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Empleado usuario;
    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    //constructor
    public MovimientoDinero(Long id, int monto, String concepto, Empleado usuario, Empresa empresa) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

   /* public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }
    
    /* public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }*/
}
