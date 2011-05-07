/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.AtributoOrinaBD;
import BaseDatos.AtributoSangreBD;
import BaseDatos.PacBD;
import CentroMedico.AtributoOrina;
import CentroMedico.AtributoSangre;
import CentroMedico.Imagen;
import CentroMedico.Paciente;
import CentroMedico.PruebaOrina;
import CentroMedico.PruebaSangre;
import CentroMedico.Radiografia;
import CentroMedico.Resonancia;
import CentroMedico.ResultadoSangre;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author pantic
 */
public class GestorPruebas {


    public boolean agregarAtributoSangre(String Nombre){

        boolean exito;
        AtributoSangre atributo = new AtributoSangre();
        AtributoSangreBD atribSBD = null;

        atributo = atribSBD.obtener(Nombre);

        if(atributo!=null){
            exito = false;
        }

        else{
            AtributoSangre At = new AtributoSangre(Nombre);
            atribSBD.almacenar(At);
            exito = true;
        }

        return exito;


    }

    public boolean agregarAtributoOrina(String Nombre){
        boolean exito;
        AtributoOrina atributo = new AtributoOrina();
        AtributoOrinaBD atribOBD = null;

        atributo = atribOBD.obtener(Nombre);

        if(atributo!=null){
            exito = false;
        }

        else{
            AtributoOrina At = new AtributoOrina(Nombre);
            atribOBD.almacenar(At);
           
            exito = true;
        }

        return exito;

    }

    public boolean eliminarAtributoSangre(String Nombre){

        boolean exito;
        AtributoSangreBD atribSBD = null;

        //No existe la función borrar y la que existe eliminar ni devuelve bool ni tiene un string como parametro



        return exito;


    }

    public boolean eliminarAtributoOrina(String Nombre){

        boolean exito;
        AtributoOrinaBD atribOBD = null;

        //No existe la función borrar y la que existe eliminar ni devuelve bool ni tiene un string como parametro



        return exito;
    }

    public boolean almacenarResultadosAnalisis(String Dni, String Comentario, String TipoAnalisis) throws SQLException{

        Paciente paciente = null;
        PacBD pBD = new PacBD();
        AtributoSangre atributo = null;
        AtributoOrina atributoO = null;
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();
        AtributoSangreBD atribSBD = new AtributoSangreBD();

        paciente = pBD.obtenerPaciente(Dni);

        if(TipoAnalisis == "sangre"){
            PruebaSangre pruebaS = new PruebaSangre(Comentario);

            //¿Como voy a hacer un bucle si solo devuelve un objeto?
            atributo = atribSBD.obtener(Dni);
            ResultadoSangre res = new ResultadoSangre(atributo, Resultado);
            pruebaS.añadirResultadoSangre(res);
            //fin bucle teorico

            paciente.almacenarPruebaSangre(pruebaS);

            //como actualizo el paciente
        }

        if(TipoAnalisis == "orina"){
            PruebaOrina pruebaO = new PruebaOrina(Comentario);

            //¿Como voy a hacer un bucle si solo devuelve un objeto?
            atributoO = atribOBD.obtener(Dni);
            ResultadoOrina res = new ResultadoOrina(atributo, Resultado);
            pruebaO.añadirResultadoOrina(res);
            //fin bucle teórico

            paciente.añadirAnalisisOrina(prueba);

            //como actualizo el paciente

        }
    }

    public boolean almacenarResultadoRadiologia(String Dni, ArrayList<Imagen> imag, String Comentario, String TipoRadiologia) throws SQLException{

        //No concuerda el diagrama de secuencia con el de clases
        PacBD pBD = new PacBD();
        Paciente paciente = null;
        Imagen aux;

        paciente = pBD.obtenerPaciente(Dni);

        if(paciente == null){
            System.out.println("No existe el paciente con ese DNI");
            return false;
        }

        if(TipoRadiologia == "radiografia"){
            Radiografia prueba = new Radiografia(Comentario);

            for( Iterator it = imag.iterator(); it.hasNext();) {
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }

            paciente.añadirPruebaRadiografia(prueba);

            //actualizar paciente
        }

        if(TipoRadiologia == "resonancia"){
            Resonancia prueba = new Resonancia(Comentario);
            for( Iterator it = imag.iterator(); it.hasNext();) {
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }
            paciente.añadirPruebaResonancia(prueba);

        }

    }
}
