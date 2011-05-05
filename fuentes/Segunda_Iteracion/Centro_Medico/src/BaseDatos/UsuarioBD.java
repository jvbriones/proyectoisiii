/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;
import java.sql.*;

/**
 *
 * @author pope
 */
public class UsuarioBD {
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
