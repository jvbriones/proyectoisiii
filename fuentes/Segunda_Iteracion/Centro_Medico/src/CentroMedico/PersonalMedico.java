/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package CentroMedico;
import java.util.*;


/**
 *
 * @author pope
 */
public class PersonalMedico extends Usuario{

    private Turno Turn=null;

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

}
