package com.ScrumTeam.Proyecto.MinTic.Controller;

import com.ScrumTeam.Proyecto.MinTic.Service.GestorEmpleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empleado;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.ObjetoRespuesta;
import com.ScrumTeam.Proyecto.MinTic.Service.GestorEmpleadoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class empleadoControlador {

    @Autowired
   private GestorEmpleadoInterface gestorEmpleado;

    @GetMapping("/empleado/empleados")
    public ResponseEntity<List<Empleado>> getEmpleados() {
        return new ResponseEntity<>(gestorEmpleado.getEmpleados(), HttpStatus.OK);
    }

    @GetMapping("/empleado")
    public ResponseEntity<Object> getEmpleado (@RequestParam long id){
        try{
            Empleado empleado = gestorEmpleado.getEmpleado(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empleado/{id}")
    public ResponseEntity<Long> getEmpleadoPath (@PathVariable long id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



                //Metodo POST con Verificacion de Usuario.
    @PostMapping("/empleado")
    public ResponseEntity<String> postEmpleado (@RequestBody Empleado empleado_parametro){
        try {
            String mensaje = gestorEmpleado.setEmpleado(empleado_parametro);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


                        //PUT Sirve para actualizar el objeto completo.
    @PutMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpleado(@RequestBody Empleado empleado_update, @PathVariable long id){

        try {
            Empleado empleado_bd = gestorEmpleado.updateEmpleadoAll(empleado_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa.",empleado_bd),HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


                    //PATCH Sirve solo cuando se necesita actualizar una parte del objeto.
    @PatchMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpleado(@RequestBody Empleado empleado_update, @PathVariable long id){

        try{
            Empleado empleado_bd = gestorEmpleado.updateEmpleado(empleado_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa.", empleado_bd), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


                        //DELETE Sirve para borrar objetos.

    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpleado(@PathVariable long id){
        try {
            String mensaje = gestorEmpleado.deleteEmpleado(id);
            return new ResponseEntity<>(new ObjetoRespuesta("Eliminado Exitosamente",null),HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}

