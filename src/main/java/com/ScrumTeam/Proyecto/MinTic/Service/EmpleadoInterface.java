package com.ScrumTeam.Proyecto.MinTic.Service;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;

import java.util.List;


public interface EmpleadoInterface {


    public List<Empleado> getEmpleado();

    public Empleado getEmpleado (String id) throws Exception;

    public String setUsuario(Empleado empleado_parametro);

    public Empleado updateUsuarioAll (Empleado empleado_update, String id);

    public Empleado updateUsuario (Empleado empleado_update, String id);

    public String deleteUsuario(String id);




}
