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
 * @version     1.0     02/04/2011
 * @author      Sub_Equipo1
 */

public class Personal extends Usuario{

    private String TipoPersonal;
   

    public Personal(String Dni,String Nombre,String Apellidos,String Direccion,String Email,String Contrasena,
            String Telefono,Date FecNac,String LugarNac,String Foto,String TipoUsuario,String TipoPersonal) {

        super(Dni,Nombre,Apellidos,Direccion,Email,Contrasena,Telefono,FecNac,LugarNac,Foto,TipoUsuario);
        this.TipoPersonal=TipoPersonal;
    }

    String getTipoPersonal(){
        return  this.TipoPersonal;
     }

    void setTipoPersonal(String TipoPer){
        this.TipoPersonal=TipoPer;
     }

   

}
