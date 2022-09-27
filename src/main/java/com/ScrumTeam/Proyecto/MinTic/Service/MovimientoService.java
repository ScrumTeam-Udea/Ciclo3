package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.MovimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    public List<MovimientoDinero> getMovimiento(){
        return movimientoRepositorio.findAll();
    }

    public MovimientoDinero save(MovimientoDinero movimiento){
        return movimientoRepositorio.save(movimiento);
    }

}
