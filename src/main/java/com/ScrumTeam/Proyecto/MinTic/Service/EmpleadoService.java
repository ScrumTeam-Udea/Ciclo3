package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;


    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleList = new ArrayList<>();
        empleadoRepositorio.findAll().forEach(empleado -> empleList.add(empleado));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return empleList;
    }


    public Empleado getEmpleadoById(Long id){
        return empleadoRepositorio.findById(id).get();

    }





    public boolean saveOrUpdateEmpleado(Empleado empleado){
        Empleado empl=empleadoRepositorio.save(empleado);
        if (empleadoRepositorio.findById(empl.getId())!=null){
            return true;
        }
        return false;
    }



    public boolean deleteEmpleado(Long id){
        empleadoRepositorio.deleteById(id);
        if (getEmpleadoById(id) != null){
            return false;
        }
        return true;
    }



}
