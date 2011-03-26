/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package centro_medico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pyrus
 */

public class Paciente {

    List IdContacto = new ArrayList();

    Defensa(List Contactos){
        IdContacto = Contactos;
    }
    public String obtenerId(int i){
        return (String)IdContacto.get(i);
    }
    public int obtenerNumeroContactos(){
        return IdContacto.size();
    }
    public String obtenerNombre(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Nombre FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
    public String obtenerPrecio(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Precio FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
    public String obtenerDefensa(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Defensa FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
   public String obtenerEquilibrio(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Equilibrio FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
   public String obtenerRespuesta(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Respuesta FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
   public String obtenerSalto(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Salto FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }
   public String obtenerTrab_Equipo(String id) throws SQLException{
        ConnectionDB nueva = new ConnectionDB();
        nueva.doConnection();
        String Consulta = "SELECT Trabajo_en_Equipo FROM Jugadores WHERE Id =" + id;
        String respuesta = nueva.EjecutarConsulta(Consulta);
        nueva.CloseConnectionDB();
        return respuesta;
    }


}

