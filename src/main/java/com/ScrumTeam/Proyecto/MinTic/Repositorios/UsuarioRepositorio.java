package com.ScrumTeam.Proyecto.MinTic.Repositorios;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Empleado, Long> {
}
