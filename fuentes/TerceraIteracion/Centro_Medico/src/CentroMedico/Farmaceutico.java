/*
 * Farmaceutico.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Farmaceuticos
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
 * modificado por Juan Carlos
 */
public class Farmaceutico extends Usuario{

    public Farmaceutico() {
    }

    public Farmaceutico(String Dni, String Nombre, String Apellidos, String Direccion, String Email, String Contrasena,
            String Telefono, Date FecNac, String LugarNac, byte[] Foto) {
        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, "Farmaceutico");
    }
    public void actualizar(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, byte[] Foto,String Tipo){
        super.setDNI(Dni);
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
