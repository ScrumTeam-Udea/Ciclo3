package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import com.ScrumTeam.Proyecto.MinTic.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/profiles")
    public ResponseEntity <List<Perfil>> getPerfiles(){
        return new ResponseEntity<>(perfilService.getPerfil(), HttpStatus.OK);

    }


    @PostMapping("/profiles")
    public ResponseEntity<Perfil> setPerfil(@RequestBody Perfil perfil){
        return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.OK);

    }


}
