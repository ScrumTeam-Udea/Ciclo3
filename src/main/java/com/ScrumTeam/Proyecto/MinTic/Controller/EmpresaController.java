package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/enterprises")
    public String viewAllEmpresas(Model model ){
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
            model.addAttribute("emplist",listaEmpresas);
            return "verEmpresas";
        }


    @GetMapping("/addEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp = new Empresa();
        model.addAttribute("emp",emp);
        return "agregarEmpresa";
    }

    @PostMapping("/enterprises")
    public ResponseEntity<Boolean> setEmpresa(@RequestBody Empresa empresa){
        return new ResponseEntity<>(empresaService.saveOrUpdateEmpresa(empresa), HttpStatus.OK);

    }



    @DeleteMapping("/enterpises/{id}")
    public ResponseEntity<Boolean> deleteEmpresa(@PathVariable Long id){
        return new  ResponseEntity<>(empresaService.deleteEmpresa(id), HttpStatus.OK) ;
    }


}
