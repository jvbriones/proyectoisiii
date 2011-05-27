/*
 * Paciente.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Pacientes
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */
public class Paciente extends Usuario {

    public Paciente() {
    }
  


    public Paciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, "Paciente");
    }

    /* Este constructor no tiene sentido, ya que siempre que se cree un objeto paciente su tipo deberá ser Paciente, aun así se deja implementado para poder llamar al constructor con todos los parámetros, incluyendo el tipo*/
    public Paciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, Tipo);
    }

    public void actualizar(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto){
        try {
            super.setDNI(Dni);
        } catch (SQLException ex) {
            Logger.getLogger(Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.setNombre(Nombre);
        super.setApellidos(Apellidos);
        super.setDireccion(Direccion);
        super.setEmail(Email);
        super.setContrasenia(Contrasenia);
        super.setTelefono(Telefono);
        super.setFecNac(FecNac);
        super.setLugarNac(LugarNac);
        super.setFoto(Foto);

    }

}
