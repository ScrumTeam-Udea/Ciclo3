package com.ScrumTeam.Proyecto.MinTic.Business;

import com.ScrumTeam.Proyecto.MinTic.Modelado_Empresa.MovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class GestorMovimientoDinero {


    private ArrayList<MovimientoDinero> movimientoDinero;

    public GestorMovimientoDinero() {
        this.movimientoDinero = new ArrayList<>();
    }


        //Get - Metodo para ver el movimiento

        public MovimientoDinero getMovimientoDinero (String id) throws Exception {

            for (MovimientoDinero movimientoDinero : this.movimientoDinero) {
                if (movimientoDinero.getId()) {
                    return movimientoDinero;
                }
            }
            throw new Exception("Movimiento No existe.");
        }


        //POST - Creación y verificación de la existencia del movimiento

        public String setMovimientoDinero (MovimientoDinero movimientoDinero) throws Exception {
            try {
                getMovimientoDinero(movimientoDinero.getId());

            } catch (Exception e) {

                this.movimientoDinero.add(movimientoDinero);
                return "Nuevo movimiento creado con éxito.";
            }
            throw new Exception("Movimiento ya existe.");
        }


        //PATCH - Metodo para actualizar información

        public MovimientoDinero updateMovimientoDinero (MovimientoDinero movimientoDinero_update, String id) throws
        Exception {
            try {
                MovimientoDinero movimientoDinero_bd = getMovimientoDinero(id);

                if (movimientoDinero_update.getConcepto() != null) {
                    movimientoDinero_bd.setConcepto(movimientoDinero_update.getConcepto());
                }
                if (movimientoDinero_update.getMonto() != 0.0) {
                    movimientoDinero_bd.setMonto(movimientoDinero_update.getMonto());
                }

                return movimientoDinero_bd;

            } catch (Exception e) {
                throw new Exception("Falló actualización de datos.");
            }
        }


        // PUT - Metodo actualizar

        public MovimientoDinero updateMovimientoDineroAll (MovimientoDinero movimientoDinero_update, String id) throws
        Exception {

            try {
                MovimientoDinero movimientoDinero_bd = getMovimientoDinero(id);
                movimientoDinero_bd.setConcepto(movimientoDinero_update.getConcepto());
                movimientoDinero_bd.setMonto(movimientoDinero_update.getMonto());

                return movimientoDinero_bd;

            } catch (Exception e) {
                throw new Exception("Falló actualización de datos.");
            }
        }


        //DELETE - metodo para eliminar

        public String deleteMovimientoDinero (String id) throws Exception {

            try {
                MovimientoDinero movimientoDinero = getMovimientoDinero(id);
                this.movimientoDinero.remove(movimientoDinero);

                return "Movimiento eliminado existosamente.";

            } catch (Exception e) {
                throw new Exception("Empresa NO Existe para Eliminar.");
            }
        }

*/

}