/**
 * PersonalMedico.java
 *
 * Informacion:
 * Clase encargada de modelizar a un miembro del personal médico
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 * @author Juan Carlos Bermúdez Sánchez
 */

package CentroMedico;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalMedico extends Usuario{

    private Turno Turn=null;
    public PersonalMedico() {
    }

    

    public PersonalMedico (String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, Tipo);
    }

    public PersonalMedico (String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo, Turno T1){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, Tipo);
        this.Turn = T1;
    }

    //Método Get
    public Turno getTurn(){
        return Turn;
    };

    //Método Set
    public void setTurn( Turno T1){
        this.Turn = T1;
    };
   
    public String getTipoPersonal() {
        return this.getTipo();
    }
      public void actualizar(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto,String Tipo){
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
        super.setTipo(Tipo);

    }

}
