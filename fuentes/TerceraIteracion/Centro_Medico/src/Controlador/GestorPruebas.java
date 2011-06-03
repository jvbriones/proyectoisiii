/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import BaseDatos.*;
import CentroMedico.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @author pantic
 * @author Juan Cabrera
 */
public class GestorPruebas {


    public boolean agregarAtributoSangre(String Nombre,float LimSup, float LimInf,String Unidad){

        boolean exito;
        AtributoSangre atributo = new AtributoSangre();
        AtributoSangreBD atribSBD = new AtributoSangreBD();

        atributo = atribSBD.obtener(Nombre);

        if(atributo!=null){
            exito = false;
        }

        else{
            AtributoSangre At = new AtributoSangre(Nombre, Unidad, LimSup, LimInf);
            atribSBD.almacenar(At);
            exito = true;
        }

        return exito;


    }

    public boolean agregarAtributoOrina(String Nombre,float LimSup, float LimInf, String Unidad){
        boolean exito;
        AtributoOrina atributo = new AtributoOrina();
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();

        atributo = atribOBD.obtener(Nombre);

        if(atributo!=null){
            exito = false;
        }

        else{
            AtributoOrina At = new AtributoOrina(Nombre,LimSup,LimInf,Unidad);
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

    public boolean almacenarResultadosAnalisis(String DniPaciente, ArrayList<String> listaAtributos, ArrayList<String> listaResultados, String Comentario, String TipoAnalisis, String DniAnalista) throws SQLException{

        Paciente paciente = null;
        GestorPacientes gP = new GestorPacientes();
        
        AtributoSangre atributoS = null;
        AtributoOrina atributoO = null;
        AtributoOrinaBD atribOBD = new AtributoOrinaBD();
        AtributoSangreBD atribSBD = new AtributoSangreBD();
        Analista analista = null;
        AnalistaBD aBD = new AnalistaBD();
        String aux;
        String aux2;
        PruebaSangreBD pSBD = new PruebaSangreBD();
        PruebaOrinaBD pOBD = new PruebaOrinaBD();

        paciente = gP.obtenerPaciente(DniPaciente);

        if(paciente == null){
            System.out.println("No existe el paciente con ese DNI");
            return false;
        }

        analista = aBD.obtener(DniAnalista);

        if(TipoAnalisis.equals("sangre")){

            PruebaSangre pruebaS = new PruebaSangre(Comentario,paciente, analista);

            Iterator itRes = listaResultados.iterator();
            for( Iterator it = listaAtributos.iterator(); it.hasNext();) {
                aux = (String)it.next();
                aux2 = (String) itRes.next();
                atributoS = atribSBD.obtener(aux);
                ResultadoSangre res = new ResultadoSangre(atributoS, aux2);
                pruebaS.añadirResultadoSangre(res);
            }

            pSBD.almacenar(pruebaS);


        }

        if(TipoAnalisis.equals("orina")){
            PruebaOrina pruebaO = new PruebaOrina(Comentario, paciente, analista);

            Iterator itRes = listaResultados.iterator();
            for( Iterator it = listaAtributos.iterator(); it.hasNext();) {
                aux = (String)it.next();
                aux2 = (String) itRes.next();
                atributoO = atribOBD.obtener(aux);
                ResultadoOrina res = new ResultadoOrina(atributoO, aux2);
                pruebaO.añadirResultadoOrina(res);
            }

            pOBD.almacenar(pruebaO);


        }

        return true;
    }
   
    public boolean almacenarResultadoRadiologia(String DNIPaciente, ArrayList<Imagen> imag, String Comentario, String TipoPrueba, String DNIRadiologo) throws SQLException{

        //No concuerda el diagrama de secuencia con el de clases
        PacienteBD pBD = new PacienteBD();
        RadiologoBD radiologoBD = new RadiologoBD();

        Paciente paciente = null;
        Radiologo radiologo = null;
        Imagen aux;
        System.out.println(TipoPrueba);

        paciente = pBD.obtener(DNIPaciente);
        radiologo = radiologoBD.obtener(DNIRadiologo);
        if(paciente == null){
            System.out.println("No existe el paciente con ese DNI");
            return false;
        }

        if(TipoPrueba == "Radiografia"){

            Radiografia prueba = new Radiografia(Comentario, paciente, radiologo);
            RadiografiaBD rBD = new RadiografiaBD();


            for( Iterator it = imag.iterator(); it.hasNext();) {
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }
            rBD.almacenar(prueba);

        }

        if(TipoPrueba.equals("Resonancia")){
            Resonancia prueba = new Resonancia(Comentario,paciente, radiologo);
            ResonanciaBD rBD = new ResonanciaBD();

            for( Iterator it = imag.iterator(); it.hasNext();) {
                aux = (Imagen)it.next();
                Imagen img = new Imagen(aux);
                prueba.añadirImagen(img);
            }
            rBD.almacenar(prueba);

        }
        return true;


     }

    public ArrayList<String > ConsultarPruebaAnalisis(int idPrueba, String tipo){

        ArrayList<String> Resultados = new ArrayList<String>();
        PruebaSangreBD psBD = new PruebaSangreBD();

        Resultados.add(psBD.obtener(idPrueba).getComentario());
        Resultados.add(psBD.obtener(idPrueba).getAnalista().getNombre() + " " + psBD.obtener(idPrueba).getAnalista().getApellidos());

      /*  if(psBD.obtener(idPrueba).getTipo().equals("Sangre")){ //No EXISTE EL ATRIBUTO TIPO
            PruebaSangre ps = psBD.obtener(idPrueba);
            Set<ResultadoSangre> resulSangre = ps.getResultadosSangre();
            for(Iterator<ResultadoSangre> it = resulSangre.iterator(); it.hasNext();){
                ResultadoSangre res = it.next();
                String resultado = res.getResultado();
                Resultados.add(resultado);
            }
        }else
            if(psBD.obtener(idPrueba).getTipo().equals("Orina")){
                PruebaOrinaBD poBD = new PruebaOrinaBD();
                PruebaOrina o = poBD.obtener(idPrueba);
                Set<ResultadoOrina> resulOri = o.getResultadosOrina();
                for(Iterator<ResultadoOrina> it = resulOri.iterator(); it.hasNext(); ){
                    ResultadoOrina ori = it.next();
                    String resultado = ori.getResultado();
                    Resultados.add(resultado);
                }
            }*/

        return Resultados;
    }

    public ArrayList<String > ConsultarPruebaRadiologia(int idPrueba, String tipo){

        ArrayList<String> Resultados = new ArrayList<String>();
        PruebaRadiologiaBD prBD = new PruebaRadiologiaBD();
        PruebaRadiologia pru = prBD.obtener(idPrueba);

        Resultados.add(pru.getComentario());
        Resultados.add(pru.getPaciente().getNombre());
        Resultados.add(pru.getPaciente().getApellidos());

        /*if(pru.getTipo().equals("Resonancia")){ //No EXISTE EL ATRIBUTO TIPO
            ResonanciaBD resoBD = new ResonanciaBD();
            Resonancia res = resoBD.obtener(idPrueba);
            Set<Imagen> im = res.getResonancias();

            for(Iterator<Imagen> it = im.iterator(); it.hasNext();){
                Imagen imag = it.next();
                String ruta = imag.getRuta();
                Resultados.add(ruta);
            }
        }else
            if(pru.getTipo().equals("Radiografia")){
                RadiografiaBD radioBD = new RadiografiaBD();
                Radiografia rad = radioBD.obtener(idPrueba);
                Set<Imagen> im = rad.getRadiografias();

                for(Iterator<Imagen> it = im.iterator(); it.hasNext(); ){
                    Imagen imag = it.next();
                    String ruta = imag.getRuta();
                    Resultados.add(ruta);
                }
            }*/

        return Resultados;
    }

}
