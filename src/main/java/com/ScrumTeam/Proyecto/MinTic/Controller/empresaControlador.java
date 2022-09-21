package com.ScrumTeam.Proyecto.MinTic.Controller;

import com.ScrumTeam.Proyecto.MinTic.Service.GestorEmpresa;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.ObjetoRespuesta;
import java.util.ArrayList;


@RestController
public class empresaControlador {



    /*AUTOWIRED - Hace paarte del patrón SINGLETON - Busca omitir la creación de objetos
     - Se usa con @SERVICE y @COMPONENT
     */
   @Autowired
    private GestorEmpresa gestorEmpresa;

    @GetMapping("/empresa")
    public ResponseEntity<ArrayList<Empresa>> getEmpresa() {
        return new ResponseEntity<>(gestorEmpresa.getEmpresa(), HttpStatus.OK);
    }
    @GetMapping("/empresa/{id}")
    public ResponseEntity<String> getEmpresaPath(@PathVariable String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    //Metodo POST con verificación de usuario
    @PostMapping("/empresa")
    public ResponseEntity<String> postEmpresa(@RequestBody Empresa empresa){

        try {
            String mensaje = gestorEmpresa.setEmpresa(empresa);

            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //PUT sirve para actualizar el objeto completo
    @PutMapping("/empresa/{id}")
    public ResponseEntity<ObjetoRespuesta> putEmpresa(@RequestBody Empresa empresa_update, @PathVariable String id){
        try {
            Empresa empresa_bd = gestorEmpresa.updateEmpresaAll(empresa_update, Long.parseLong(id));
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa",empresa_bd), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //PATCH sirve para cuando solo se necesita actualizar una parte del objeto

    @PatchMapping("/empresa/{id}")
    public ResponseEntity<ObjetoRespuesta> patchEmpresa(@RequestBody Empresa empresa_update, @PathVariable String id){
        try {
            Empresa empresa_bd= gestorEmpresa.updateEmpresa(empresa_update, Long.parseLong(id));
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa", empresa_bd), HttpStatus.OK );

        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    //DELETE Borrar cualquier usuario de la base de datos

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmpresa(@PathVariable String id){
        try {
            String mensaje = gestorEmpresa.deleteEmpresa(Long.parseLong(id));

            return new ResponseEntity<>(new ObjetoRespuesta("Eliminado Exitosamente", null), HttpStatus.OK );

        } catch (Exception e) {

            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }



}
