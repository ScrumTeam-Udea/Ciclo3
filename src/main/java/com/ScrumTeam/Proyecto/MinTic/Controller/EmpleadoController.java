package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/usuarios")
    public ResponseEntity <List<Empleado>> getEmpleados(){
        return new ResponseEntity<>(empleadoService.getEmpleado(), HttpStatus.OK);

    }


    @PostMapping("/usuarios")
    public ResponseEntity<Empleado> setEmpleado(@RequestBody Empleado empleado){
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.OK);

    }


}
