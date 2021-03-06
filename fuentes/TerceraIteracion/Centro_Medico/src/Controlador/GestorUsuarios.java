/*
 * GestorUsuarios.java
 *
 * Informacion:
 * Clase encargada de operar con los usuarios
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package Controlador;

import CentroMedico.Usuario;
import java.sql.SQLException;
import java.util.*;
import BaseDatos.UsuarioBD;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version     2.0    05/05/2011
 * @author      Sub_Equipo2
 */

public class GestorUsuarios {

    private Usuario user = null;

    public GestorUsuarios(){}

    public Usuario obtenerUsuario(String dni) throws SQLException {
        UsuarioBD usuBD=new UsuarioBD();
        Usuario usu=null;
        usu= usuBD.obtener(dni);
       
        return usu;
    }

/*
    Esta función ya no se usa.
 */

/*    public boolean validacionUsuario(String Dni, String Pass) throws SQLException, Exception {
        boolean acceso=false;
        usuarioBD usuario_bd = new usuarioBD();

        acceso=usuario_bd.validacion(Dni, Pass);

        if(!acceso) {
            throw new Exception("Usuario o contraseña erroneos ");
        }
        else {
            user=usuario_bd.obtenerUsuario(Dni);
        }

        return acceso;

    }
*/
   public String modificarDatosPersonalesAdmin(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, byte[] Fotografia) throws SQLException{

       UsuarioBD usuario_bd = new UsuarioBD();
       Usuario userAux =usuario_bd.obtener(Dni);

       userAux.setDNI(Dni);
       userAux.setNombre(Nombre);
       userAux.setApellidos( Apellidos);
       userAux.setDireccion( Direccion);
       userAux.setEmail( Email);
       userAux.setContrasenia( Contrasena);
       userAux.setTelefono( Telefono);
       userAux.setFecNac( FecNac);
       userAux.setLugarNac( LugarNac);
       userAux.setFoto( Fotografia);

       usuario_bd.almacenar(userAux);

       return "Operacion Realizada con Exito";
    }

   public String modificarDatosPersonales(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, byte[] Fotografia) throws SQLException{

       UsuarioBD usuario_bd = new UsuarioBD();
       String dni=user.getDNI();

       if(dni.equalsIgnoreCase(Dni)){
          return "No puede modificarle los datos a otro Usuario.";
       }

       user.setDNI(Dni);
       user.setNombre(Nombre);
       user.setApellidos( Apellidos);
       user.setDireccion( Direccion);
       user.setEmail( Email);
       user.setContrasenia( Contrasena);
       user.setTelefono( Telefono);
       user.setFecNac( FecNac);
       user.setLugarNac( LugarNac);
       user.setFoto( Fotografia);

       usuario_bd.almacenar(user);

       return "Operacion Realizada con Exito";
    }

   public String consultarDatosPersonalesAdmin(String DNI) throws SQLException{

        UsuarioBD usuario_bd = new UsuarioBD();
        boolean Existe=usuario_bd.existeUsuario(DNI);

        if(Existe){
            Usuario userAux =usuario_bd.obtener(DNI);

            String dni=userAux.getDNI();
            String nombre=userAux.getNombre();
            String apellidos=userAux.getApellidos();
            String direccion=userAux.getDireccion();
            String email=userAux.getEmail();
            String contrasena=userAux.getContrasenia();
            String telefono=userAux.getTelefono();
            Date fecNac=userAux.getFecNac();
            String lugarNac=userAux.getLugarNac();
            byte[] foto=userAux.getFoto();
            String tipo=userAux.getTipo();

            String salida=dni + nombre;//hay que integrarlo con la interfaz
            return salida;

        }else{

            return"No existe ningun Usuario con ese Dni";
        }

    }

   public String consultarDatosPersonales() throws SQLException{

        String dni=user.getDNI();
        String nombre=user.getNombre();
        String apellidos=user.getApellidos();
        String direccion=user.getDireccion();
        String email=user.getEmail();
        String contrasena=user.getContrasenia();
        String telefono=user.getTelefono();
        Date fecNac=user.getFecNac();
        String lugarNac=user.getLugarNac();
        byte[] foto=user.getFoto();
        String tipo=user.getTipo();

        String salida= nombre;//hay que integrarlo con la interfaz
        return salida;

    }

   public Usuario consultarDatos(String Dni) throws SQLException{
        UsuarioBD usuario_bd = new UsuarioBD();
        boolean Existe=usuario_bd.existeUsuario(Dni);
         Usuario userAux=null;
        if(Existe){
             userAux =usuario_bd.obtener(Dni);
    }
        return userAux;
    }

}
