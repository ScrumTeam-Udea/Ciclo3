package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GestorEmpleadoList {

    private ArrayList<Empleado> empleados;
    Perfil perfil1 = new Perfil( "sjadfghalsd", "37214696");
    Empresa empresa1 = new Empresa ("Cosmeticos Yisel", "Circasia","68971263",
            "12983764");

    public GestorEmpleadoList() {
        this.empleados = new ArrayList<>();

        this.empleados.add (new Empleado("Andres", "aaaa@hotmail.com",perfil1, empresa1, "Admin"));
        this.empleados.add(new Empleado("Camila", "12@gmail.com", perfil1, empresa1, "Admin"));
    }


                //Verificación de existencia Empleado
    public Empleado getEmpleado (String nombre) throws Exception {
        for (Empleado empleado: this.empleados){
            if (empleado.getNombre().equals(nombre)){
                return empleado;
            }
        }
        throw new Exception("Empleado No existe.");
    }


                //Creacion y Verificación de existencia de Empleado.
    public String setEmpleado (Empleado empleado_parametro) throws Exception {
        try {
            getEmpleado(empleado_parametro.getNombre());

        }catch (Exception e){

            this.empleados.add(empleado_parametro);
            return "Nuevo Empleado Creado Con Exito.";
        }
        throw new Exception("Empleado Ya existe.");
    }



                //Metodo para usar el PATCH y actualizar solo una o mas variables.
    public Empleado updateEmpleado(Empleado empleado_update, long id) throws Exception {

        try{
            Empleado empleado_bd = getEmpleado(String.valueOf(id));
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
            throw new Exception("Empleado NO existe, falló la actualizacion de datos.");
        }
    }

                    //Metodo para usar el PUT y actualizar el objeto completo.
    public Empleado updateEmpleadoAll(Empleado empleado_update, long id) throws Exception {
        try {
            Empleado empleado_bd = getEmpleado(String.valueOf(id));
            empleado_bd.setNombre(empleado_update.getNombre());
            empleado_bd.setCorreo(empleado_update.getCorreo());
            empleado_bd.setRol(empleado_update.getRol());

            return empleado_bd;
        } catch (Exception e) {
            throw new Exception("Empleado No Existe, falló actualizacion de datos.");
        }
    }


                //DELETE metodo para borrar objetos.
    public String deleteEmpleado (long id) throws Exception {
        try {
            Empleado empleado = getEmpleado(String.valueOf(id));
            this.empleados.remove(empleado);
            return "Empleado eliminado exitosamente.";
        } catch (Exception e) {
            throw new Exception("Empleado NO existe, No se pudo eliminar.");
        }
    }


                //Getters & Setters.

    public ArrayList<Empleado> getEmpleado() {
        return empleados;
    }

    public void setEmpleado(ArrayList<Empleado> empleado) {
        this.empleados = empleado;
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

