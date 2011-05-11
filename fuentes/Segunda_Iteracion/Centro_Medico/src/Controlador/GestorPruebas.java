/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.AtributoOrinaBD;
import BaseDatos.AtributoSangreBD;
import BaseDatos.PacBD;
import BaseDatos.RadiografiaBD;
import BaseDatos.ResonanciaBD;
import CentroMedico.AtributoOrina;
import CentroMedico.AtributoSangre;
import CentroMedico.Imagen;
import CentroMedico.Paciente;
import CentroMedico.PruebaOrina;
import CentroMedico.PruebaSangre;
import CentroMedico.Radiografia;
import CentroMedico.Resonancia;
import CentroMedico.ResultadoOrina;
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
        AtributoSangreBD atribSBD = new AtributoSangreBD();

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
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();

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
        AtributoSangreBD atribSBD = new AtributoSangreBD();
        AtributoSangre atrib = null;
        
        atrib = atribSBD.obtener(Nombre);

        if(atrib == null){

            return false;
        }


        else{

        atribSBD.eliminar(atrib);

        return true;
        }



//        return exito; comentado por Nicolás


    }

    public boolean eliminarAtributoOrina(String Nombre){

        boolean exito;
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();
        AtributoOrina atrib = new AtributoOrina();


        atrib = atribOBD.obtener(Nombre);


        if(atrib == null){

            return false;
        }


        else{

        atribOBD.eliminar(atrib);

        return true;
        }




    }
/* comentado por Nicolás
    public boolean almacenarResultadosAnalisis(String Dni, String DatosAnalisis, String Comentario, String TipoAnalisis) throws SQLException{

        Paciente paciente = null;
        PacBD pBD = new PacBD();
        
        AtributoSangre atributoS = null;
        AtributoOrina atributoO = null;
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();
        AtributoSangreBD atribSBD = new AtributoSangreBD();

        paciente = pBD.obtenerPaciente(Dni);

        if(TipoAnalisis == "sangre"){
            PruebaSangre pruebaS = new PruebaSangre(Comentario);

            //¿Como voy a hacer un bucle si solo devuelve un objeto?
            atributoS = atribSBD.obtener(Dni);
            ResultadoSangre res = new ResultadoSangre(atributoS, Resultado);//¿De donde sale resultado?
            pruebaS.añadirResultadoSangre(res);
            //fin bucle teorico

            paciente.almacenarPruebaSangre(pruebaS);//Este metodo no existe en la clase Paciente

            //En pacienteBD no hay ningún metodo que sea actualizarPaciente
        }

        if(TipoAnalisis == "orina"){
            PruebaOrina pruebaO = new PruebaOrina(Comentario);

            //¿Como voy a hacer un bucle si solo devuelve un objeto?
            atributoO = atribOBD.obtener(Dni);
            ResultadoOrina res = new ResultadoOrina(atributoO, Resultado);//¿De donde sale resultado?
            pruebaO.añadirResultadoOrina(res);
            //fin bucle teórico

            paciente.añadirAnalisisOrina(prueba);//Este metodo no existe en la clase Paciente

           //En pacienteBD no hay ningún metodo que sea actualizarPaciente

            // ¿RETURN?

        }
    }
*/
    
    public boolean almacenarResultadoRadiologia(String Dni, ArrayList<Imagen> imag, String Comentario, String TipoRadiologia) throws SQLException{

        //No concuerda el diagrama de secuencia con el de clases
        System.out.println("Dentro de almacenar");
        PacBD pBD = new PacBD();
        Paciente paciente = null;
        Imagen aux;
        System.out.println(TipoRadiologia);

        paciente = pBD.obtener(Dni);

        if(paciente == null){
            System.out.println("No existe el paciente con ese DNI");
            return false;
        }

        if(TipoRadiologia == "radiologia"){

            Radiografia prueba = new Radiografia(Comentario);
            RadiografiaBD rBD = new RadiografiaBD();

            System.out.println("Antes del loop de radiografia");
            for( Iterator it = imag.iterator(); it.hasNext();) {
                System.out.println("en el bucle radiografía");
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }
            System.out.println("Fuera del bucle");
            rBD.almacenar(prueba);
            return true;

        }

        if(TipoRadiologia == "resonancia"){
            Resonancia prueba = new Resonancia(Comentario);
            ResonanciaBD rBD = new ResonanciaBD();

            for( Iterator it = imag.iterator(); it.hasNext();) {
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }
            System.out.println("antes de almacenar resonancia");
            rBD.almacenar(prueba);
            System.out.println("resonancia almacenada");
            return true;

        }
        return true;


     }
     

}
