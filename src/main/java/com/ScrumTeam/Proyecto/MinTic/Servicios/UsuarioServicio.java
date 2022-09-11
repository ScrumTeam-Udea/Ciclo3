package com.ScrumTeam.Proyecto.MinTic.Servicios;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    private  UsuarioRepositorio repositorio;
    public UsuarioServicio(UsuarioRepositorio repositorio){this.repositorio=repositorio;}

    public void crearUsuario(Empleado usuario){
        repositorio.save(usuario);
    }

}


