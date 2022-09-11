package com.ScrumTeam.Proyecto.MinTic.Controller;

import com.ScrumTeam.Proyecto.MinTic.Business.GestorMovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.ObjetoRespuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



 @RestController
 public class movimientoDineroControlador {
   
  @Autowired 
    private GestorMovimientoDinero gestorMovimientoDinero;


  @GetMapping("/enterprises/[id]/movements")
    public ResponseEntity<String> getMovimientoDinero (@PathVariable String id){
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



  @PostMapping("/enterprises/[id]/movements")
    public ResponseEntity<String> postMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){

        try {
            String mensaje = gestorDinero.setMovimientoDinero(movimientoDinero);

            return new ResponseEntity<>(mensaje, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



   @PutMapping("/enterprises/[id]/movements")
     public ResponseEntity<ObjetoRespuesta> putMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero_update, @PathVariable String id){

        try {
            MovimientoDinero movimientoDinero_bd = gestorMovimientoDinero.updateMovimientoDineroAll(movimientoDinero_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa",movimientoDinero_bd), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



   @PatchMapping("/enterprises/[id]/movements")
     public ResponseEntity<ObjetoRespuesta> patchMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero_update, @PathVariable String id){
        try {
            MovimientoDinero movimientoDinero_bd= gestorMovimientoDinero.updateMovimientoDinero(movimientoDinero_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualizacion Exitosa", movimientoDinero_bd), HttpStatus.OK );

        } catch (Exception e){
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }



   @DeleteMapping("/enterprices/{id}/movements")
     public ResponseEntity<ObjetoRespuesta> deleteMovimientoDinero(@PathVariable String id){
        try {
            String mensaje = gestorMovimientoDinero.deleteMovimientoDinero(id);

            return new ResponseEntity<>(new ObjetoRespuesta("Eliminado Exitosamente", null), HttpStatus.OK );

        } catch (Exception e) {

            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR );

        }
    }



}
