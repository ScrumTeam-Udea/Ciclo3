package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {



    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> getEmpleado(){
        return empleadoRepositorio.findAll();
    }

    public Empleado save(Empleado empleado){
        return empleadoRepositorio.save(empleado);
    }

}
