package com.ScrumTeam.Proyecto.MinTic.Business;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpresaInterface;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GestorEmpresa implements EmpresaInterface {

    @Autowired
    private EmpresaRepositorio empRepositorio;

    @Override
    public List<Empresa> getEmpresa() {
        return empRepositorio.findAll();
    }

    @Override
    public Empresa getEmpleado(String id) throws Exception {
        Optional<Empresa> empresabd = empRepositorio.findById(id);
        if (empresabd.isPresent()){
            return empresabd.get();
        }
        throw new Exception("Empresa no Existe.");    }

    @Override
    public String setEmpresa(Empresa empresa_parametro) {
        empRepositorio.save(empresa_parametro);
        return "Empresa Creada Con Exito.";    }

    @Override
    public Empresa updateEmpresaAll(Empresa empresa_update, String id) {
        return null;
    }

    @Override
    public Empresa updateEmpresa(Empresa empresa_update, String id) {
        return null;
    }

    @Override
    public String deleteEmpresa(String id) {
        empRepositorio.deleteById(id);
        return "Empresa Eliminada Con Exito.";    }
}
