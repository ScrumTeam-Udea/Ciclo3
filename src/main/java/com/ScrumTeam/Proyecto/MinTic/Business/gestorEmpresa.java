package com.ScrumTeam.Proyecto.MinTic.Business;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;

import java.util.ArrayList;

public class gestorEmpresa {

    private ArrayList<Empresa> empresa;

    public gestorEmpresa (){
        this.empresa = new ArrayList<>();

        this.empresa.add (new Empresa(01, "Yisel y asociados.", "Circasia", "3113129873",
                "9287364208-1"));
    }

    public Empresa getEmpresa (String nombre) throws Exception{
        for (Empresa empresa: this.empresa){
            if (empresa.getNombre().equals(nombre) ){
                return empresa;
            }
        }
        throw new Exception("Empresa No Existe.");
    }




}
