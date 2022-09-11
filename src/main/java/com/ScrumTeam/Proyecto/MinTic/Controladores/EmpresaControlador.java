package com.ScrumTeam.Proyecto.MinTic.Controladores;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Servicios.EmpresaServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaControlador{

    private EmpresaServicio servicio;
    public EmpresaControlador(EmpresaServicio servcio){this.servicio=servcio;}

    @PostMapping("/enterprises")
    public void crearEmpresa(@RequestBody Empresa empresa){
        servicio.crearEmpresa(empresa);
    }

}