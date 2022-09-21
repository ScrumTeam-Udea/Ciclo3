package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GestorEmpleado implements GestorEmpleadoInterface {

    @Autowired
    private EmpleadoRepositorio repositorio;

    @Override
    public List<Empleado> getEmpleados() {
        return repositorio.findAll();
    }

    @Override
    public Empleado getEmpleado(long id) throws Exception {
        Optional<Empleado> empleadoBd = repositorio.findAllById(id);
        if (empleadoBd.isPresent()) {
            return empleadoBd.get();
        }
        throw new Exception("Empleado no Existe.");
    }

    @Override
    public String setEmpleado(Empleado empleado_parametro) {
        repositorio.save(empleado_parametro);
        return "Empleado creado exitosamente";
    }

    @Transactional
    @Override
    public Empleado updateEmpleadoAll(Empleado empleado_update, long id) throws Exception {
        repositorio.update(empleado_update.getNombre(), empleado_update.getCorreo(), empleado_update.getPerfil(), empleado_update.getEmpresa(), empleado_update.getRol(), id);
        return getEmpleado(id);
    }

    @Override
    public Empleado updateEmpleado(Empleado empleado_update, long id) throws Exception {
        Empleado empleado_bd = getEmpleado(id);

        if (empleado_update.getNombre() != null && !empleado_bd.getNombre().equals("")) {
            empleado_bd.setNombre(empleado_update.getNombre());
        }
        if (empleado_update.getCorreo() != null && !empleado_bd.getCorreo().equals("")) {
            empleado_bd.setCorreo(empleado_update.getCorreo());
        }
        /* if (empleado_update.getPerfil() != null || !empleado_bd.getPerfil().equals("")) {
            empleado_bd.setPerfil(empleado_update.getPerfil());
        }
        if (empleado_update.getEmpresa() != null || !empleado_bd.getEmpresa().equals("")) {
            empleado_bd.setEmpresa(empleado_update.getEmpresa());
        }
        if (empleado_update.getRol() != null || !empleado_bd.getRol().equals("")) {
            empleado_bd.setRol(empleado_update.getRol());

         */
            return repositorio.save(empleado_bd);
        }

        @Override
        public String deleteEmpleado (long id){
            repositorio.deleteById(String.valueOf(id));
            return "Empleado eliminado exitosamente";
        }
    }

