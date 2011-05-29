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

import java.sql.SQLException;
import java util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 1.0	29/05/2011
 * @author	Juan Miguel Cabrera
 */

public class Enfermedad implements Serializable{

	/** Atributos **/
	private	String	ID;
	private	String	Tipo;
	private	Date	FechaDet;
	private	String	Descripcion;
	private	String	Volante;

	/** Constructores **/
	
	public Enfermedad(){}

	public Enfermedad(String id, String tipo, Date fecha, String descripcion, String volante){
	  this.ID = id;
	  this.Tipo = tipo;
	  this.FechaDet = fecha;
	  this.Descripcion = descripcion;
	  this.Volante = volante;
  }


	/** Metodos GET **/

	public String getNombre(){

		return this.ID
	}

	public String getDescripcion(){

		return this.Descripcion;
	}

	public String getFechaDet(){

		return this.FechaDet;
	}

	public String getVolante(){

		return this.Volante;
	}

	/** Metodos SET **/
	
	public void setNombre(String nombre){

		this.ID = nombre;
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
	
  }











