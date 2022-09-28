package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.MovimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientoList = new ArrayList<>();
        movimientoRepositorio.findAll().forEach(movimientos -> movimientoList.add(movimientos));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return movimientoList;
    }


    public MovimientoDinero getMovimientoById(Long id){
        return movimientoRepositorio.findById(id).get();

    }





    public boolean saveOrUpdateMovimiento(MovimientoDinero movimientos){
        MovimientoDinero mov=movimientoRepositorio.save(movimientos);
        if (movimientoRepositorio.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }



    public boolean deleteMovimiento(Long id){
        movimientoRepositorio.deleteById(id);
        if (movimientoRepositorio.findById(id) != null){

            return true;
        }
        return false;
    }

}
