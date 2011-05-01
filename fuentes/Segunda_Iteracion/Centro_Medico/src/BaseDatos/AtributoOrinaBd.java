/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;

import CentroMedico.AtributoOrina;

/**
 *
 * @author pope
 */
public class AtributoOrinaBd {
    void almacenar(AtributoOrina Atr){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save ( Atr );
    }


    AtributoOrina obtener (String Nombre){
    }

    void actualizar (AtributoOrina Atr){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update( Atr );
    }

    void eliminar (AtributoOrina Atr){}
}
