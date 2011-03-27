/*
 * BD_Paciente.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los pacientes.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package centro_medico;

import centro_medico.BaseDatos.*;
import java.sql.*;


/**
 * @version     datos de la versión (numero y fecha)
 * @author      Sub_Equipo1
 */
public class BD_Paciente {


    //TENEMOS QUE MIRAR COMO HACEMOS LAS CONEXIONES A LA BASE DE DATOS
    //Si hacemos una por cada consulta o usamos lo del pool de conexiones.
    //El profesor me dijo que es el pool es lo suyo


    //Sentencia Modificadora
    void almacenaPaciente(Paciente paci) {

        String dnei=paci.getDni();
        String nom=paci.getNombre();

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Pacientes (dni,nombre) VALUES ('"+dnei+"','"+nom+"' )";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();
    }

    //Sentencia Consultora-->Hay que procesar el ResultSet

    /*public Paciente buscarPaciente(String dnei) throws SQLException{

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "SELECT * FROM Pacientes WHERE DNI =" + dnei;
        ResultSet rs = conexion.consultaSelect(Consulta);

        rs.next(); //Avanza al primer elemento devuelto.
        rs.getString(i)

                //Mañana lo termino..

        
        conexion.closeConnection();
        return respuesta;
    }*/





}
