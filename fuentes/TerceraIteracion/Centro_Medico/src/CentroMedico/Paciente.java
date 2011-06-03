/*
 * Paciente.java
 *
 * Informacion:
 * Clase encargada de modelizar a los Pacientes
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M_1.2
 *
 */

package CentroMedico;

import java.sql.SQLException;
import java.util.*;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 * modificado por Juan Carlos
 */
public class Paciente extends Usuario {
    private Cita Cita;
    private Set<Enfermedad> Enfermedades =  new HashSet<Enfermedad>(0);


    public Cita getCita() {
        return Cita;
    }

    public void setCita(Cita Cita) {
        this.Cita = Cita;
    }

    public Set<Enfermedad> getEnfermedades() {
        return Enfermedades;
    }

    public void setEnfermedades(Set<Enfermedad> Enfermedades) {
        this.Enfermedades = Enfermedades;
    }

    public Paciente() {
    }
  
    public Paciente(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, byte[] Foto){
        super(Dni, Nombre, Apellidos, Direccion, Email, Contrasenia, Telefono, FecNac, LugarNac, Foto, "Paciente");
    }
    public void actualizar(String Dni, String Nombre, String Apellidos, String Direccion,String Email,
            String Contrasenia, String Telefono, Date FecNac, String LugarNac, byte[] Foto){
          setDNI(Dni);
        setNombre(Nombre);
        setApellidos(Apellidos);
        setDireccion(Direccion);
        setEmail(Email);
        setContrasenia(Contrasenia);
        setTelefono(Telefono);
        setFecNac(FecNac);
        setLugarNac(LugarNac);
        setFoto(Foto);

    
    }
    public void anadirEnfermedad(Enfermedad enfermedad){
        Enfermedades.add(enfermedad);
    }
}
