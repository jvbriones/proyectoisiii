/**
 *  @author Juan Carlos Bermúdez
 *  Clase para el almacenamiento, actualización, borrado, y obtención de objetos de la clase MedicamentoRecetado en la base de datos.
 */
package BaseDatos;

import org.hibernate.Session;
import CentroMedico.MedicamentoRecetado;

public class MedicamentoRecetadoBD {


    public void almacenar(MedicamentoRecetado Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.save(Med);
        session.getTransaction().commit();
    }

    public MedicamentoRecetado obtener (String Nombre){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        MedicamentoRecetado Med = (MedicamentoRecetado) session.get(MedicamentoRecetado.class, Nombre);

        return Med;
    }

    public void actualizar (MedicamentoRecetado Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.update(Med);
        session.getTransaction().commit();
    }

    public void eliminar (MedicamentoRecetado Med){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction ();
        session.delete(Med);
        session.getTransaction().commit();
    }

}
