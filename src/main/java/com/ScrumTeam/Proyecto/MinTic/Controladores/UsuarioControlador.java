package com.ScrumTeam.Proyecto.MinTic.Controladores;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioControlador {

    private UsuarioServicio servicio;
    public UsuarioControlador(UsuarioServicio servicio){this.servicio=servicio;}

    @PostMapping("/users")
    public void crearUsuario(@RequestBody Empleado usuario){
        servicio.crearUsuario(usuario);
    }
}
