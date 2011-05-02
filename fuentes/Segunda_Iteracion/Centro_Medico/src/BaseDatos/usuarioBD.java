/*
 * UsuarioBD.java
 *
 * Informacion:
 * Clase encargada de comunicarse con la Capa de la BD para
 * realizar operaciones relacionadas con los usuarios.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */
package BaseDatos;

import CentroMedico.Usuario;
import java.sql.*;
import org.hibernate.Session;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */
public class usuarioBD {
    //public boolean validacion(String Dni, String Pass) throws SQLException{}

    public Usuario obtener(String Dni) throws SQLException{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Usuario User = (Usuario) session.get(Usuario.class, Dni);
        return User;
    }
    //public Usuario obtenerUsuarioNombre(String nombre) throws SQLException {}
    
    public void almacenar(Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save (User);
    }
    
    public boolean existeUsuario(String Dni) throws SQLException{
        boolean existe=false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        Usuario User = (Usuario) session.get(Usuario.class, Dni);
        if (User != null)
            existe = true;

        return existe;
    }

    public void actualizar (Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (User);
    }

    public void eliminar(Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (User);

    }
}

/*SE HA PUESTO EN COMENTARIO TODO EL CÓDIGO ANTIGUO DE LA CLASE USUARIOBD, para mantenerlo por si hace falta */
/*    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="personal";
    String pass="personal";

    public boolean validacion(String Dni, String Pass) throws SQLException {

        boolean acceso=false;

       // Connection con=null;//obtener una conexión a base de dato

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor,NombreDB, user,pass);

        String Consulta = "SELECT Dni , Contrasena FROM Usuarios WHERE Dni='"+Dni+"' and Contrasena='"+Pass+"'";
       //PreparedStatement ps = con.prepareStatement(Consulta);
      // ps.setString(1,Dni); // toma los datos como
       //ps.setString(2,Pass);
        ResultSet rs = conexion.consultaSelect(Consulta);
        //ResultSet rs = ps.executeQuery();
       if(rs.next()) {
            acceso=true;
        }
        else {
            acceso=false;
        }
        //con.close();
        //ps.close();
        conexion.closeConnection();
        return acceso;
    }

    public Usuario obtenerUsuario(String Dni) throws SQLException {

        Usuario usu=null;

       
        Jdbc conexion = new Jdbc();


        conexion.doConnection(IpDelServidor, NombreDB,this.user,pass);

        //System.out.println(this.user);
        String Consulta = "SELECT * FROM Usuarios WHERE Dni='"+Dni+"'";
       

        ResultSet rs = conexion.consultaSelect(Consulta);

      
        if(rs.next()) {
            
            String dni=rs.getString("Dni");
            String nombre=rs.getString("Nombre");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasena");
            String telefono=rs.getString("Telefono"); //Estos campos han de coincidir exactamente con los de la tabla Usuarios en la BD
            Date fecNac=rs.getDate("FechaNacimiento");//Si el Telefono es un Entero en la BD, aqui tendria que ser getInt("Telefono")
            String lugarNac=rs.getString("LugarNacimiento");
            String foto=rs.getString("Fotografia");
            String tipo=rs.getString("TipoUsuario");
 
            usu = new Usuario(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto, tipo);

           
        }
      
          
         
        conexion.closeConnection();
         
        return usu;

    }


        public Usuario obtenerUsuarioNombre(String nombre) throws SQLException {

        Usuario user;
        

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, this.user,pass);
        String Consulta = "SELECT * FROM Usuarios WHERE Nombre='"+nombre+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasena");
            String telefono=rs.getString("Telefono"); //Estos campos han de coincidir exactamente con los de la tabla Usuarios en la BD
            Date fecNac=rs.getDate("FechaNacimiento");//Si el Telefono es un Entero en la BD, aqui tendria que ser getInt("Telefono")
            String lugarNac=rs.getString("LugarNacimiento");
            String foto=rs.getString("Fotografia");
            String tipo=rs.getString("TipoUsuario");

            user = new Usuario(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto, tipo);
        }
        else{
            user= null;
        }
        conexion.closeConnection();
         

        return user;


    }





    public void almacenarUsuario(Usuario user) {
        String dni=user.getDni();
        String nombre=user.getNombre();
        String apellidos=user.getApellidos();
        String direccion=user.getDireccion();
        String email=user.getEmail();
        String contrasena=user.getContrasena();
        String telefono=user.getTelefono();
        Date fecNac=(Date) user.getFechaNacimiento();
        String lugarNac=user.getLugarNacimiento();
        String foto=user.getFotografia();
        String tipo=user.getTipo();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, this.user,pass);
        String Consulta = "UPDATE Usuarios SET Dni='"+dni+"',Nombre='"+nombre+"',Apellidos='"+apellidos+"',Direccion='"+direccion+"',Email='"+email+"',Contrasena='"+contrasena+"',Telefono='"+telefono+"',FechaNacimiento="+fecNac+",LugarNacimiento='"+lugarNac+"',Fotografia='"+foto+"',TipoUsuario='"+tipo+"' WHERE Dni='"+dni+"'";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public boolean existeUsuario(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT Dni FROM Usuarios WHERE Dni='"+Dni+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            existe=true;
        }
        else {
            existe=false;
        }
        conexion.closeConnection();
        return existe;
    }




}
*/