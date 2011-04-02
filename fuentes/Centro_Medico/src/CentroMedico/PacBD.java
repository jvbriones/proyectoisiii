/*
 * PacBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los pacientes.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package CentroMedico;

import BaseDatos.*;
import java.sql.*;


/**
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */
public class PacBD {


    //TENEMOS QUE MIRAR COMO HACEMOS LAS CONEXIONES A LA BASE DE DATOS
    //Si hacemos una por cada consulta o usamos lo del pool de conexiones.
    //El profesor me dijo que es el pool es lo suyo
    //De momento conectamos y desconectamos por cada consulta.


        //prueba...
    void almacenaPaciente(Paciente Paci) {

        String dnei=Paci.getDni();
        String nom=Paci.getNombre();

        Jdbc conexion = new Jdbc();
        conexion.doConnection("IpDelServidor", "NombreDB", "user","pass");
        String Consulta = "INSERT INTO Pacientes (dni,nombre) VALUES ('"+dnei+"','"+nom+"' )";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();
    }

   





}
