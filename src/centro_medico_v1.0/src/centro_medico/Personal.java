/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package centro_medico;

import java.util.*;
import java.awt.*;

/**
 *
 * @author José Peso Buendía
 */
public abstract class Personal {

    private String nombre;
    private String apellidos;
    private String dni;
    private String contrasena;
    private String domicilio;
    private int telefono;
    private String email;
    private Date fecha_nac;
    private String lugar_nac;
    private Image foto;
    private String puesto;

    private Turno turno;
}
