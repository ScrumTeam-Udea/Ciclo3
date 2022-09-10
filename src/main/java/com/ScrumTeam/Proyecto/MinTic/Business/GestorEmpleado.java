package com.ScrumTeam.Proyecto.MinTic.Business;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;

import java.util.ArrayList;

public class GestorEmpleado {

    private ArrayList<Empleado> empleado;
    Perfil perfil1 = new Perfil(001, "sjadfghalsd", "37214696");
    Empresa empresa1 = new Empresa (001,"Cosmeticos Yisel", "Circasia","68971263",
            "12983764");

    public GestorEmpleado() {
        this.empleado = new ArrayList<>();

        this.empleado.add (new Empleado(001, "Laura Yisel", "Yisel69@gmail.com", perfil1,
                empresa1, "Admin"));
    }

                //Verificación de existencia Empleado
    public Empleado getEmpleado (String nombre) throws Exception {
        for (Empleado empleado: this.empleado){
            if (empleado.getNombre().equals(nombre)){
                return empleado;
            }

        }
        throw new Exception("Empleado no Existe.");
    }


                //Creacion y Verificación de existencia de Empleado.
    public String setEmpleado (Empleado empleado) throws Exception {
        try {
            getEmpleado(empleado.getNombre());

        }catch (Exception e){

            this.empleado.add(empleado);
            return "Nuevo Empleado Creado Con Exito.";
        }
        throw new Exception("Empleado Ya Existe.");
    }



                //Metodo para usar el PATCH y actualizar solo una o mas variables.
    public Empleado updateEmpleado(Empleado empleado_update, String id) throws Exception {

        try{
            Empleado empleado_bd = getEmpleado(id);
            if (empleado_update.getNombre() != null) {
                empleado_bd.setNombre(empleado_update.getNombre());
            }
            if (empleado_update.getCorreo() != null){
                empleado_bd.setCorreo(empleado_update.getCorreo());
            }
            if (empleado_update.getRol() != null){
                empleado_bd.setRol(empleado_update.getRol());


            }
            return empleado_bd;
        }catch (Exception e){
            throw new Exception("Empleado NO Existe, Falló la Actualizacion de datos.");
        }
    }

                    //Metodo para usar el PUT y actualizar el objeto completo.
    public Empleado updateEmpleadoAll(Empleado empleado_update, String id) throws Exception {
        try {
            Empleado empleado_bd = getEmpleado(id);
            empleado_bd.setNombre(empleado_update.getNombre());
            empleado_bd.setCorreo(empleado_update.getCorreo());
            empleado_bd.setRol(empleado_update.getRol());

            return empleado_bd;
        } catch (Exception e) {
            throw new Exception("Empleado NO Existe, Falló Actualizacion de Datos.");
        }

    }


                //DELETE metodo para borrar objetos.
    public String deleteEmpleado (String id) throws Exception {
        try {
            Empleado empleado = getEmpleado(id);
            this.empleado.remove(empleado);
            return "Empleado eliminado exitosamente.";
        } catch (Exception e) {
            throw new Exception("Empleado NO existe, No se pudo eliminar.");
        }

    }


                //Getters & Setters.


    public ArrayList<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleado = empleado;
    }

    public Perfil getPerfil1() {
        return perfil1;
    }

    public void setPerfil1(Perfil perfil1) {
        this.perfil1 = perfil1;
    }

    public Empresa getEmpresa1() {
        return empresa1;
    }

    public void setEmpresa1(Empresa empresa1) {
        this.empresa1 = empresa1;
    }
}

