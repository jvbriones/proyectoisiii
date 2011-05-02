/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.AtributoOrina;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class AtributoOrinaBD {
    void almacenar(AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Atr );
    }


    void actualizar (AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Atr );
    }

    void eliminar (AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete( Atr );
    }

    AtributoOrina obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();

        AtributoOrina atr = (AtributoOrina) session.get(AtributoOrina.class, Nombre);

        return atr;
    }


}
