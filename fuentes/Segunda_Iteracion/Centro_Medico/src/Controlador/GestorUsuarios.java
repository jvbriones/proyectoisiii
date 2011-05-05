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
import BaseDatos.usuarioBD;
import java.sql.SQLException;
import java.util.*;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */

public class GestorUsuarios {

    private Usuario user = null; 

    
    public boolean validacionUsuario(String Dni, String Pass) throws SQLException, Exception {
        boolean acceso=false;
        usuarioBD usuario_bd = new usuarioBD();

        acceso=usuario_bd.existeUsuario(Dni);

        if(!acceso) {
            throw new Exception("Usuario o contraseña erroneos ");
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
            String Contrasena, String Telefono, Date FecNac, String LugarNac, String Fotografia) throws SQLException{

       usuarioBD usuario_bd = new usuarioBD();
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

    public ArrayList consultarDatosPersonalesAdmin(String DNI) throws SQLException{

        usuarioBD usuario_bd = new usuarioBD();
        boolean Existe=usuario_bd.existeUsuario(DNI);
        ArrayList salida = new ArrayList();

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
            String foto=userAux.getFoto();
            String tipo=userAux.getTipo();


            salida.add(dni);
            salida.add(nombre);
            salida.add(apellidos);
            salida.add(direccion);
            salida.add(contrasena);
            salida.add(telefono);
            salida.add(fecNac);
            salida.add(lugarNac);
            salida.add(foto);
            salida.add(tipo);
            salida.add(email);



            return salida;

        }else{
            salida.add("No existe ningun Usuario con ese Dni");
            return salida;
        }

    }

 
    public String consultarTipoUsuario( )throws SQLException{

     return user.getTipo();
    }



    public ArrayList consultarDatosPersonales() throws SQLException{

        ArrayList salida = new ArrayList();

        String dni=user.getDNI();
        String nombre=user.getNombre();
        String apellidos=user.getApellidos();
        String direccion=user.getDireccion();
        String email=user.getEmail();
        String contrasena=user.getContrasenia();
        String telefono=user.getTelefono();
        Date fecNac=user.getFecNac();
        String lugarNac=user.getLugarNac();
        String foto=user.getFoto();
        String tipo=user.getTipo();

        salida.add(nombre);
        salida.add(dni);
        salida.add(contrasena);

        return salida;


    }






}
