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
import java.util.*;

public class PersonalMedico extends Usuario{
    private Turno Turno=null;

    public PersonalMedico() {
    }

    public PersonalMedico (String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, Tipo);
        this.Turno=null;
    }

    public PersonalMedico (String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto, String Tipo, Turno T1){

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, Tipo);
        this.Turno = T1;
    }

    //Método Get
    public Turno getTurno(){
        return Turno;
    };

    //Método Set
    public void setTurno( Turno T1){
        this.Turno = T1;
    };

    public String getTipo(){
         return super.getTipo();
    }
    public void actualizar(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, String Foto,String Tipo){
        setDNI(Dni);
        setNombre(Nombre);
        setApellidos(Apellidos);
        setDireccion(Direccion);
        setEmail(Email);
        setContrasenia(Contrasenia);
        setTelefono(Telefono);
        setFecNac(FecNac);
        setLugarNac(LugarNac);
        setFoto(Foto);
    
    }
}
