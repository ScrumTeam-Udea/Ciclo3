package com.ScrumTeam.Proyecto.MinTic.Service;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;

import java.util.List;

public interface GestorEmpleadoInterface {

    public List<Empleado> getEmpleados();

    public Empleado getEmpleado (long id) throws Exception;

    public String setEmpleado (Empleado empleado_parametro);

    public Empleado updateEmpleadoAll(Empleado empleado_update, long id) throws Exception;

    public Empleado updateEmpleado(Empleado empleado_update, long id) throws Exception;

    public String deleteEmpleado (long id);
}
