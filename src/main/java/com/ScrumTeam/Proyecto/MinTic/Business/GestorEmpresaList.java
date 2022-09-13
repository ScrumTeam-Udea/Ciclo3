package com.ScrumTeam.Proyecto.MinTic.Business;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GestorEmpresaList {

    private ArrayList<Empresa> empresa;

    public GestorEmpresaList(){
        this.empresa = new ArrayList<>();

        this.empresa.add (new Empresa("Yisel y Asociados","Circasia", "3113129873",
                "92873642-0"));
    }
                //Verificación de existencia de empresa....
    public Empresa getEmpresa (String nombre) throws Exception{
        for (Empresa empresa: this.empresa){
            if (empresa.getNombre().equals(nombre) ){
                return empresa;
            }
        }
        throw new Exception("Empresa No Existe.");
    }

                //Creación y verificación de existencia de Empresa

    public String setEmpresa (Empresa empresa) throws Exception{
        try {
            getEmpresa (empresa.getNombre());

        }catch (Exception e){

            this.empresa.add(empresa);
            return "Nueva Empresa Creada Con Éxito.";
        }
        throw new Exception("Empresa Ya Existe.");
    }

    //Metodo para usar el PATCH y actualizar solo una o mas variables
    public Empresa updateEmpresa(Empresa empresa_update, String id) throws Exception {
        try {
            Empresa empresa_bd = getEmpresa(id);
            if (empresa_update.getNombre() != null) {
                empresa_bd.setNombre(empresa_update.getNombre());
            }
            if (empresa_update.getNombre() != null) {
                empresa_bd.setNombre(empresa_update.getNombre());
            }
            if (empresa_update.getNit() != null) {
                empresa_bd.setNit(empresa_update.getNit());
            }
            return empresa_bd;
        } catch (Exception e) {
            throw new Exception("Usuario NO existe, falló actualización de datos.");
        }

    }


    /* Metodo para usar el PUT, Y actualizar el objeto completo*/
    public Empresa updateEmpresaAll(Empresa empresa_update, String id) throws Exception {

        try {
            Empresa empresa_bd = getEmpresa(id);
            empresa_bd.setNombre(empresa_update.getNombre());
            empresa_bd.setDireccion(empresa_update.getDireccion());
            empresa_bd.setNit(empresa_update.getNit());

            return empresa_bd;
        } catch (Exception e) {
            throw new Exception("Empresa NO existe, falló actualización de datos.");
        }
    }



    //DELETE metodo para usar el DELETE en el controlador

    public String deleteEmpresa (String id) throws Exception {
        try {
            Empresa empresa = getEmpresa(id);
            this.empresa.remove(empresa);
            return "Empresa Eliminada Existosamente.";
        }catch (Exception e) {
            throw new Exception("Empresa NO Existe para Eliminar.");
        }
    }



            //Getters & Setters
    public ArrayList<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<Empresa> empresa) {
        this.empresa = empresa;
    }
}
