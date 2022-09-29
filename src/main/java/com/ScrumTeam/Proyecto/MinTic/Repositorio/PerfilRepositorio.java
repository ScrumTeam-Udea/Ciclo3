package com.ScrumTeam.Proyecto.MinTic.Repositorio;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, String> {
}
