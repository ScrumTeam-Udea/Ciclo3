package com.ScrumTeam.Proyecto.MinTic.Business;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GestorEmpleado implements EmpleadoInterface {

    @Autowired
    private EmpleadoRepositorio repositorio;



    @Override
    public List<Empleado> getEmpleado() {
        return repositorio.findAll();
    }

    @Override
    public Empleado getEmpleado(String id) throws Exception {
        Optional<Empleado> empleadobd = repositorio.findById(id);
        if (empleadobd.isPresent()){
            return empleadobd.get();
        }
        throw new Exception("Empleado no Existe.");
    }

    @Override
    public String setEmpleado(Empleado empleado_parametro) {
        repositorio.save(empleado_parametro);
        return "Empleado Creado Con Exito.";
    }

    @Override
    public Empleado updateEmpleadoAll(Empleado empleado_update, String id) {
        return null;
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado_update, String id) {
        return null;
    }

    @Override
    public String deleteEmpleado(String id) {
        repositorio.deleteById(id);
        return "Empleado Eliminado Con Exito.";
    }
}
