package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;

import java.util.List;

public interface EmpresaInterface {


    public List<Empresa> getEmpresa();

    public Empresa getEmpleado (String id) throws Exception;

    public String setEmpresa(Empresa empresa_parametro);

    public Empresa updateEmpresaAll (Empresa empresa_update, String id);

    public Empresa updateEmpresa (Empresa empresa_update, String id);

    public String deleteEmpresa(String id);

}
