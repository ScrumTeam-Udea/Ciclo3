package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepositorio perfilRepositorio;

    public List<Perfil> getPerfil(){
        return perfilRepositorio.findAll();
    }

    public Perfil save(Perfil perfil){
        return perfilRepositorio.save(perfil);
    }

}
