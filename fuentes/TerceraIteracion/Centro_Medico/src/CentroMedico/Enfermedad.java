/*
 * Enfermedad.java
 *
 * Clase encargada de modelizar las enfermedades de los pacientes.
 *
 * Proyecto ISIII UGR 10/11
 * Grupo M 1.2
 * 
 */

package CentroMedico;

import java.util.*;
import java.io.Serializable;

/**
 * @version 1.0	29/05/2011
 * @author	Juan Miguel Cabrera
 */

public class Enfermedad implements Serializable{

	/** Atributos **/
	private	int	Id;
        private String  Nombre;
	private	String	Tipo;
	private	Date	FechaDet;
	private	String	Descripcion;
	private	String	Volante;
        private Set<Enfermedad> Enfermedades = new HashSet<Enfermedad>(0);

	/** Constructores **/
	
	public Enfermedad(){}

        public Enfermedad(String Nombre, String tipo, Date fecha, String descripcion, String volante){
              this.Nombre = Nombre;
              this.Tipo = tipo;
              this.FechaDet = fecha;
              this.Descripcion = descripcion;
              this.Volante = volante;
      }

	/** Metodos GET **/

        public int getId() {
        return Id;
    }

        public String getTipo() {
        return Tipo;
    }

	public String getNombre(){

		return this.Nombre;
	}

	public String getDescripcion(){

		return this.Descripcion;
	}

	public String getVolante(){

		return this.Volante;
	}

        public Date getFechaDet() {
        return FechaDet;
    }


	/** Metodos SET **/
	
	public void setNombre(String nombre){

		this.Nombre = nombre;
	}

	public void setDescripcion(String descrip){

		this.Descripcion = descrip;
	}

	public void setFechaDet(Date fecha){

		this.FechaDet = fecha;
	}

	public void setVolante(String volante){

		this.Volante = volante;
	}

        public void setTipo(String tipo){
            this.Tipo=tipo;
        }

        public void anadirEnfermedad(Enfermedad enfermedad){
            Enfermedades.add(enfermedad);
        }

        public Set<Enfermedad> getEnfermedades() {
            return Enfermedades;
        }

        public void setEnfermedades(Set<Enfermedad> Enfermedades) {
            this.Enfermedades = Enfermedades;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

}











