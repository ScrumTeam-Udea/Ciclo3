package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EmpresaService empresaService;



    @GetMapping("/VerEmpleados")
    public String viewAllEmpleados(Model model ){
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleados();
        model.addAttribute("empleadoslist",listaEmpleados);
        return "VerEmpleados";
    }


    @GetMapping("/AgregarEmpleado")
    public String nuevoEmpleado(Model model){
        Empleado empl = new Empleado();
        model.addAttribute("empl",empl);
        List<Empresa> listaEmpresas = empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "AgregarEmpleado";
    }

    @PostMapping("/GuardarEmpleado")
    public String guardarEmpleado(Empleado empl, RedirectAttributes redirectAttributes){
        if(empleadoService.saveOrUpdateEmpleado(empl)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerEmpleados";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarEmpleado";
    }





    //EDITAR EMPLEADO
    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id){
        Empleado empl = empleadoService.getEmpleadoById(id);
        model.addAttribute("empl", empl);
        List<Empresa> listaEmpresas= empresaService.getAllEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "EditarEmpleado";
    }

    @PostMapping("/ActualizarEmpleado")
    public String updateEmpleado(Empleado empl){
        if(empleadoService.saveOrUpdateEmpleado(empl)==true){
            return "redirect:/VerEmpleados";
        }
        return "redirect:/AgregarEmpleado";

    }





    //BORRAR EMPLEADO

    @GetMapping("/EliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id){

        if(empleadoService.deleteEmpleado(id)){
            return "redirect:/VerEmpleados";
        }
        return "redirect:/VerEmpleados";
    }



}
