/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BaseDatos;
import CentroMedico.*;
import org.hibernate.Session;

/**
 *
 * @author pope
 */
public class LoteMedicamentoBD {
    
    public void almacenar(LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save(Lote);
    }

    public LoteMedicamento obtener (String CodBarras){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        LoteMedicamento Lote = (LoteMedicamento) session.get(LoteMedicamento.class, CodBarras);
        return Lote;
    }

    public void actualizar (LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update(Lote);
    }

    public void eliminar (LoteMedicamento Lote){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Lote);
    }

    public void eliminarLote (String CodBarras){
        LoteMedicamento Lote = new LoteMedicamento();
        Lote = obtener (CodBarras);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Lote);
    }
}