/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.AtributoSangre;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class AtributoSangreBD {
    void almacenar(AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Atr );
    }


    void actualizar (AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Atr );
    }

    void eliminar (AtributoSangre Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Atr );
    }

    AtributoSangre obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        AtributoSangre atr = (AtributoSangre) session.get(AtributoSangre.class, Nombre);

        return atr;
    }


}
