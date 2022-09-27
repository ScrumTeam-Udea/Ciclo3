package com.ScrumTeam.Proyecto.MinTic.Repositorio;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovimientoRepositorio extends JpaRepository<MovimientoDinero, Long> {
}
