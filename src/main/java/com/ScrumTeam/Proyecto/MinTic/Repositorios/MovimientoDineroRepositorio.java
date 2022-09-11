package com.ScrumTeam.Proyecto.MinTic.Repositorios;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepositorio extends JpaRepository<MovimientoDinero, Long> {
}
