package com.ScrumTeam.Proyecto.MinTic.Controller;

import com.ScrumTeam.Proyecto.MinTic.Business.GestorEmpleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class empleadoControlador {

    private GestorEmpleado gestorEmpleado = new GestorEmpleado();


    @GetMapping("/empleado")
    public ResponseEntity<ArrayList<Empleado>> getEmpleado() {
        return new ResponseEntity<>(gestorEmpleado.getEmpleado(), HttpStatus.OK);
    }


    @GetMapping("/empleado/{id}")
    public ResponseEntity<String> getEmpleadoPath (@PathVariable String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



                //Metodo POST con Verificacion de Usuario.
    @PostMapping("/empleado")
    public ResponseEntity<String> postEmpresa(@RequestBody Empleado empleado){
        try {
            String mensaje = gestorEmpleado.setEmpleado(empleado);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



                        //PUT Sirve para actualizar el objeto completo.
    @PutMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Empleado empleado_update, @PathVariable String id){

        try {
            Empleado empleado_bd = gestorEmpleado.updateEmpleadoAll(empleado_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa.", empleado_bd), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



                    //PATCH Sirve solo cuando se necesita actualizar una parte del objeto.
    @PatchMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpleado(@RequestBody Empleado empleado_update, @PathVariable String id){

        try{
            Empleado empleado_bd = gestorEmpleado.updateEmpleado(empleado_update,id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa.", empleado_bd), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




                        //DELETE Sirve para borrar objetos.

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable String id){
        try {
            String mensaje = gestorEmpleado.deleteEmpleado(id);
            return new ResponseEntity<>(new ObjetoRespuesta("Eliminado Exitosamente", null), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

