package com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;
    @Column
    private String nombre;
    @OneToOne
    private Perfil perfil;
    private String rol;
    private String password;
    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;
    @OneToMany
    private List<MovimientoDinero> movimiento;



    public Empleado(String email, String nombre, Perfil perfil, Empresa empresa,
    List<MovimientoDinero> movimiento, String rol, String password) {

        this.email = email;
        this.nombre = nombre;
        this.perfil = perfil;
        this.empresa = empresa;
        this.movimiento = movimiento;
        this.rol = rol;
        this.password = password;
    }


    public Empleado() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<MovimientoDinero> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(List<MovimientoDinero> movimiento) {
        this.movimiento = movimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
