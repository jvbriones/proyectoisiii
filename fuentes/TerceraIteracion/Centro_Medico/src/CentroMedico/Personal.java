/*
 * Personal.java
 *
 * Informacion:
 * Clase encargada de modelizar al personal del Centro Medico
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.util.*;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class Personal extends Usuario{

    private String TipoPersonal;

    public Personal() {
    }
   

    public Personal(String Dni, String Nombre, String Apellidos, String Direccion, String Email, String Contrasena,
            String Telefono, Date FecNac, String LugarNac, String Foto, String TipoPersonal) {

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, "Personal");
        this.TipoPersonal=TipoPersonal;
    }    
    

    public String getTipoPersonal(){
        return  this.TipoPersonal;
     }

    public void setTipoPersonal(String TipoPer){
        this.TipoPersonal=TipoPer;
     }
   

}
