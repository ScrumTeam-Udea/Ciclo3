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
            model.addAttribute("emplist", listaEmpresas);
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





    //EDITAR EMPRESA
    @GetMapping("/EditarEmpresa/{id}")
    public String editarEmpresa(Model model, @PathVariable Long id){
        Empresa emp = empresaService.getEmpresaById(id);
        model.addAttribute("emp", emp);
        return "EditarEmpresa";
    }

    @PostMapping("/ActualizarEmpresa")
    public String updateEmpresa(Empresa emp){
        if(empresaService.saveOrUpdateEmpresa(emp)==true){
            return "redirect:/enterprises";
        }
        return "redirect:/AgregarEmpresa";

    }





    //BORRAR EMPRESA

    @GetMapping("/EliminarEmpresa/{id}")
    public String eliminarEmpresa(@PathVariable Long id){

        if(empresaService.deleteEmpresa(id)){
            return "redirect:/enterprises";
        }
        return "redirect:/enterprises";
    }


}
