package com.ScrumTeam.Proyecto.MinTic.Servicios;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Repositorios.EmpresaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class EmpresaServicio {

    private EmpresaRepositorio repositorio;
    public EmpresaServicio(EmpresaRepositorio repositorio){this.repositorio=repositorio;}

    public void crearEmpresa(Empresa empresa){
        repositorio.save(empresa);
    }

}



