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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    @GetMapping("/enterprises")
    public String viewAllEmpresas(Model model ){
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
            model.addAttribute("emplist",listaEmpresas);
            return "VerEmpresas";
        }


    @GetMapping("/agregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp = new Empresa();
        model.addAttribute("emp",emp);
        return "AgregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/enterprises";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpresa";
    }



    @DeleteMapping("/enterpises/{id}")
    public ResponseEntity<Boolean> deleteEmpresa(@PathVariable Long id){
        return new  ResponseEntity<>(empresaService.deleteEmpresa(id), HttpStatus.OK) ;
    }


}
