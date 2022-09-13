package com.ScrumTeam.Proyecto.MinTic.Service;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;

import java.util.List;


public interface EmpleadoInterface {


    public List<Empleado> getEmpleado();

    public Empleado getEmpleado (String id) throws Exception;

    public String setEmpleado(Empleado empleado_parametro);

    public Empleado updateEmpleadoAll (Empleado empleado_update, String id);

    public Empleado updateEmpleado (Empleado empleado_update, String id);

    public String deleteEmpleado(String id);

}
