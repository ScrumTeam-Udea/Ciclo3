package com.ScrumTeam.Proyecto.MinTic.Repositorio;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, String> {

    @Modifying
@Query ("UPDATE empleado u SET u.nombre= :nombre, u.correo= :correo, u.perfil= :perfil, u.empresa= :empresa, u.rol= :rol WHERE u.nombreEmpleado= :id")
public int update (String nombre, String correo, Perfil perfil, Empresa empresa, String rol, long id);
}
