package com.ScrumTeam.Proyecto.MinTic.Repositorio;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, String> {


}
