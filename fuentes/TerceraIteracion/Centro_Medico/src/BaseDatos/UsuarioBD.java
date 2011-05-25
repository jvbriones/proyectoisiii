package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase Usuario en la base de datos.
 *  Se han mantenido las funciones implementadas en la iteración 1 para mantener el funcionamiento del código implementado entonces. Aunque en las iteraciones 2 y 3 se usarán las funciones nuevas (obtener, almacenar, actualizar y eliminar) que hacen uso de hibernate.
 *  Lo ideal sería que al final de la iteración 3 todo el proyecto fuese integrado con las nuevas funciones, permitiendo el borrado de las antiguas.
 */
public class UsuarioBD {
    String IpDelServidor="localhost";
    String NombreDB="CentroMedico";
    String user="generico";
    String pass="generico";

    public boolean validacion(String Dni, String Pass) throws SQLException {

        boolean acceso=false;

       // Connection con=null;//obtener una conexión a base de dato

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor,NombreDB, user,pass);

        String Consulta = "SELECT DNI_USUARIO , Contrasenia FROM Usuario WHERE DNI_USUARIO='"+Dni+"' and Contrasenia='"+Pass+"'";
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
        String Consulta = "SELECT * FROM Usuario WHERE DNI_USUARIO='"+Dni+"'";


        ResultSet rs = conexion.consultaSelect(Consulta);


        if(rs.next()) {

            String dni=rs.getString("DNI_USUARIO");
            String nombre=rs.getString("Nombre");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasenia");
            String telefono=rs.getString("Telefono"); //Estos campos han de coincidir exactamente con los de la tabla Usuarios en la BD
            Date fecNac=rs.getDate("FecNac");//Si el Telefono es un Entero en la BD, aqui tendria que ser getInt("Telefono")
            String lugarNac=rs.getString("LugarNac");
            String foto=rs.getString("Foto");
            String tipo=rs.getString("Tipo");

            usu = new Usuario(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto, tipo);


        }



        conexion.closeConnection();

        return usu;

    }


        public Usuario obtenerUsuarioNombre(String nombre) throws SQLException {

        Usuario user;


        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, this.user,pass);
        String Consulta = "SELECT * FROM Usuario WHERE Nombre='"+nombre+"'";
        ResultSet rs = conexion.consultaSelect(Consulta);
        if(rs.next()) {
            String dni=rs.getString("Dni");
            String apellidos=rs.getString("Apellidos");
            String direccion=rs.getString("Direccion");
            String email=rs.getString("Email");
            String contrasena=rs.getString("Contrasenia");
            String telefono=rs.getString("Telefono"); //Estos campos han de coincidir exactamente con los de la tabla Usuarios en la BD
            Date fecNac=rs.getDate("FecNac");//Si el Telefono es un Entero en la BD, aqui tendria que ser getInt("Telefono")
            String lugarNac=rs.getString("LugarNac");
            String foto=rs.getString("Foto");
            String tipo=rs.getString("Tipo");

            user = new Usuario(dni, nombre, apellidos, direccion, email, contrasena, telefono, fecNac, lugarNac, foto, tipo);
        }
        else{
            user= null;
        }
        conexion.closeConnection();


        return user;


    }





    public void almacenarUsuario(Usuario user) {
        String dni=user.getDNI();
        String nombre=user.getNombre();
        String apellidos=user.getApellidos();
        String direccion=user.getDireccion();
        String email=user.getEmail();
        String contrasena=user.getContrasenia();
        String telefono=user.getTelefono();
        Date fecNac=(Date) user.getFecNac();
        String lugarNac=user.getLugarNac();
        String foto=user.getFoto();
        String tipo=user.getTipo();

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, this.user,pass);
        String Consulta = "UPDATE Usuario SET DNI='"+dni+"',Nombre='"+nombre+"',Apellidos='"+apellidos+"',Direccion='"+direccion+"',Email='"+email+"',Contrasenia='"+contrasena+"',Telefono='"+telefono+"',FecNac="+fecNac+",LugarNac='"+lugarNac+"',Foto='"+foto+"',Tipo='"+tipo+"' WHERE DNI='"+dni+"'";
        conexion.consultaUpdate(Consulta);
        conexion.closeConnection();

    }

    public boolean existeUsuario(String Dni) throws SQLException {
        boolean existe;

        Jdbc conexion = new Jdbc();
        conexion.doConnection(IpDelServidor, NombreDB, user,pass);
        String Consulta = "SELECT DNI FROM Usuario WHERE DNI='"+Dni+"'";
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
        session.getTransaction().commit();
    }

    public void actualizar (Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update (User);
        session.getTransaction().commit();
    }

    public void eliminar(Usuario User){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete (User);
        session.getTransaction().commit();

    }
}
