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

package CentroMedico;

import java.sql.SQLException;
import java.util.*;

/**
 * @version     1.0    02/04/2011
 * @author      Sub_Equipo1
 */

public class GestorUsuarios {

    private Usuario user = null;

    
    public Boolean validacionUsuario(String Dni, String Pass) throws SQLException, Exception {
        Boolean acceso;
        usuarioBD usuario_bd = new usuarioBD();

        acceso=usuario_bd.validacion(Dni, Pass);

        if(!acceso) {
            throw new Exception("Usuario o contraseña erroneos");
        }
        else {
            user=usuario_bd.obtenerUsuario(Dni);
        }

        return acceso;

    }

   public String modificarDatosPersonalesAdmin(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Fotografia) throws SQLException{

       usuarioBD usuario_bd = new usuarioBD();
       Usuario userAux =usuario_bd.obtenerUsuario(Dni);

       userAux.setDni(Dni);
       userAux.setNombre(Nombre);
       userAux.setApellidos( Apellidos);
       userAux.setDireccion( Direccion);
       userAux.setEmail( Email);
       userAux.setContrasena( Contrasena);
       userAux.setTelefono( Telefono);
       userAux.setFechaNacimiento( FecNac);
       userAux.setLugarNacimiento( LugarNac);
       userAux.setFotografia( Fotografia);

       usuario_bd.almacenarUsuario(userAux);

       return "Operacion Realizada con Exito";
    }

      public String modificarDatosPersonales(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Fotografia) throws SQLException{

       usuarioBD usuario_bd = new usuarioBD();
       String dni=user.getDni();

       if(dni.equalsIgnoreCase(Dni)){
          return "No puede modificarle los datos a otro Usuario.";
       }

       user.setDni(Dni);
       user.setNombre(Nombre);
       user.setApellidos( Apellidos);
       user.setDireccion( Direccion);
       user.setEmail( Email);
       user.setContrasena( Contrasena);
       user.setTelefono( Telefono);
       user.setFechaNacimiento( FecNac);
       user.setLugarNacimiento( LugarNac);
       user.setFotografia( Fotografia);

       usuario_bd.almacenarUsuario(user);

       return "Operacion Realizada con Exito";
    }

    public String consultarDatosPersonalesAdmin(String DNI) throws SQLException{

        usuarioBD usuario_bd = new usuarioBD();
        boolean Existe=usuario_bd.existeUsuario(DNI);

        if(Existe){
            Usuario userAux =usuario_bd.obtenerUsuario(DNI);

            String dni=userAux.getDni();
            String nombre=userAux.getNombre();
            String apellidos=userAux.getApellidos();
            String direccion=userAux.getDireccion();
            String email=userAux.getEmail();
            String contrasena=userAux.getContrasena();
            String telefono=userAux.getTelefono();
            Date fecNac=userAux.getFechaNacimiento();
            String lugarNac=userAux.getLugarNacimiento();
            String foto=userAux.getFotografia();
            String tipo=userAux.getTipo();

            String salida=dni + nombre;//hay que integrarlo con la interfaz
            return salida;
            
        }else{
            
            return"No existe ningun Usuario con ese Dni";
        }

    }

    public String consultarDatosPersonales() throws SQLException{        

        String dni=user.getDni();
        String nombre=user.getNombre();
        String apellidos=user.getApellidos();
        String direccion=user.getDireccion();
        String email=user.getEmail();
        String contrasena=user.getContrasena();
        String telefono=user.getTelefono();
        Date fecNac=user.getFechaNacimiento();
        String lugarNac=user.getLugarNacimiento();
        String foto=user.getFotografia();
        String tipo=user.getTipo();

        String salida=dni + nombre;//hay que integrarlo con la interfaz
        return salida;
        
    }



}
