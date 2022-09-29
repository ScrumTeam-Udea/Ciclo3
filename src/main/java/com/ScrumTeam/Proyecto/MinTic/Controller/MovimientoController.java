package com.ScrumTeam.Proyecto.MinTic.Controller;


import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Service.EmpleadoService;
import com.ScrumTeam.Proyecto.MinTic.Service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;
    @Autowired
    EmpleadoService empleadoService;


    @GetMapping("/VerMovimientos")
    public String verMovimientos(Model model, @ModelAttribute("mensaje") String mensaje){
        List<MovimientoDinero> listaMovimientos = movimientoService.getAllMovimientos();
        model.addAttribute("movlist", listaMovimientos);
        model.addAttribute("mensaje", mensaje);
        return "VerMovimientos";
    }


    @GetMapping("/AgregarMovimiento") //Controlador que nos lleva al template donde podremos crear un nuevo movimiento
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje) {
        MovimientoDinero movimiento = new MovimientoDinero();
        model.addAttribute("mov", movimiento);
        model.addAttribute("mensaje", mensaje);
        List<Empleado> listaEmpleados = empleadoService.getAllEmpleados();
        model.addAttribute("emplelist", listaEmpleados);

        return "AgregarMovimiento"; //Llamar HTML
    }


/*
    @GetMapping("/AgregarMovimiento")
    public String nuevoMovimiento(Model model){
        MovimientoDinero mov = new MovimientoDinero();
        model.addAttribute("mov",mov);
        return "AgregarMovimiento";
    }
        */
    @PostMapping("/GuardarMovimiento")
    public String guardarMovimiento(MovimientoDinero mov, RedirectAttributes redirectAttributes){
        if(movimientoService.saveOrUpdateMovimiento(mov)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientos";
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimiento";
    }





    //EDITAR EMPRESA
    @GetMapping("/EditarMovimiento/{id}")
    public String editarMovimiento(Model model, @PathVariable Long id){
        MovimientoDinero mov = movimientoService.getMovimientoById(id);
        model.addAttribute("mov", mov);
        return "EditarMovimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(MovimientoDinero mov){
        if(movimientoService.saveOrUpdateMovimiento(mov)==true){
            return "redirect:/VerMovimientos";
        }
        return "redirect:/AgregarMovimiento";

    }





    //BORRAR EMPRESA

    @GetMapping("/EliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable Long id){

        if(movimientoService.deleteMovimiento(id)){
            return "redirect:/VerMovimientos";
        }
        return "redirect:/VerMovimientos";
    }





}
