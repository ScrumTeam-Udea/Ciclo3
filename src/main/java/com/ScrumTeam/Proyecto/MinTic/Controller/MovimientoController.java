package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import com.ScrumTeam.Proyecto.MinTic.Service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping("/enterprises/movements")
    public ResponseEntity <List<MovimientoDinero>> getMovimientos(){
        return new ResponseEntity<>(movimientoService.getMovimiento(), HttpStatus.OK);

    }


    @PostMapping("/enterprises/movements")
    public ResponseEntity<MovimientoDinero> setMovimiento(@RequestBody MovimientoDinero movimiento){
        return new ResponseEntity<>(movimientoService.save(movimiento), HttpStatus.OK);

    }


}
