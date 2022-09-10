package com.ScrumTeam.Proyecto.MinTic.Controller;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Business.gestorEmpresa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class empresaControlador {


    @GetMapping("/empresa/{id}/edit")
    public ResponseEntity<String> getEmpresaPath(@PathVariable String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }






}
