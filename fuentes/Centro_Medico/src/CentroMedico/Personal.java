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

/**
 * @version     1.0 02/04/2011
 * @author      Sub_Equipo1
 */
public abstract class Personal extends Usuario{

    //private String DNI;  //No es necesario, se obtiene de Usuario
    private String Tipo;
   

    Personal(String Dni,String Nombre,String Apellidos,String Direccion,String Email,String Contraseña,
            String Telefono,Date FecNac,String LugarNac,String Foto,String TipoUsuario,String TipoPersonal) {

        super(Dni,Nombre,Apellidos,Direccion,Email,Contraseña,Telefono,FecNac,LugarNac,Foto);
        Tipo=TipoPersonal;
    }    

    String getDni(){
        return super.DNI;
    }

    String getNombre(){
        return  super.Nombre;
     }
    String getApellidos(){
        return super.Apellidos;
    }

    String getDireccion(){
        return  super.Direccion;
     }
    String getEmail(){
        return super.Email;
    }

    String getTelefono(){
        return  super.Telefono;
     }
    String getFechaNacimiento(){
        return super.FecNac;
    }

    String getLugarNacimiento(){
        return  super.LugarNac;
     }  

    String getFotografia(){
        return  super.Foto;
     }
     String getTipoUsuario(){
        return super.Tipo;
    }    
    String getContraseña(){
        return  super.Contraseña;
     }
    
    //Funcion Optimizada
     String getTipoPersonal(){
        return  Tipo;
     }


    /*          Código Optimizado.
     *
     * Funciones para Establecer los atributos.
     *
     */

    void setDni(String Dni){
        super.DNI=Dni;
    }

    void  setNombre(String Nombre){
       super.Nombre=Nombre;
     }
    void  setApellidos(String Apellidos){
        super.Apellidos=Apellidos;
    }

    void  setDireccion(String Direccion){
        super.Direccion=Direccion;
     }
    void  setEmail(String Email){
       super.Email=Email;
    }

    void  setTelefono(String Telefono){
        super.Telefono=Telefono;
     }
    void  setFechaNacimiento(Date FecNac){
        super.FecNac=FecNac;
    }

    void  setLugarNacimiento(String LugarNac){
        super.LugarNac=LugarNac;
     }

    void  setFotografia(String Foto){
       super.Fotografia=Foto;
     }

    void  setTipoUsuario(String TipoUsuario){
       super.Tipo=TipoUsuario;
    }

    void  setContraseña(String Contraseña){
       super.Contraseña=Contraseña;
     }

    void  setTipoUsuario(String TipoPersonal){
        Tipo=TipoPersonal;
    }


}
