package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {



    @Autowired
    private EmpresaRepositorio empresaRepositorio;


    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> empresaList.add(empresa));  //Recorremos el iterable que regresa el metodo findAll del Jpa y lo guardamos en la lista creada
        return empresaList;
    }


    public Empresa getEmpresaById(Long id){
        return empresaRepositorio.findById(id).get();

    }





    public boolean saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp=empresaRepositorio.save(empresa);
        if (empresaRepositorio.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }



    public boolean deleteEmpresa(Long id){
        empresaRepositorio.deleteById(id);
        if (getEmpresaById(id) != null){
            return false;
        }
        return true;
    }

}
