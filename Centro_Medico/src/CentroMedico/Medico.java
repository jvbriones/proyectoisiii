/*
 * Medico.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Medicos
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.util.*;

/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */
public class Medico extends PersonalMedico{
    private Set<Cita> Citas = new HashSet<Cita>(0);

    public Set<Cita> getCitas() {
        return Citas;
    }

    public void setCitas(Set<Cita> Citas) {
        this.Citas = Citas;
    }

    public Medico() {
    }

    public Medico(String Dni, String Nombre, String Apellidos, String Direccion, String Email, String Contrasena,
            String Telefono, Date FecNac, String LugarNac, byte[] Foto) {

        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasena, Telefono, FecNac, LugarNac, Foto, "Medico");

    }

}
