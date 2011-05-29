package BaseDatos;

import CentroMedico.Enfermedad;
imoprt java.sql.*;
import org.hibernate.Session;

public class EnfermedadBD{

	String	IpDelServidor = "localhost";
	String	NombreDB = "CentroMedico";
	String user = "generico";
	String pass = "generico";

	public void Almacenar(Enfermedad enfmd){}

	public Enfermedad Obtener(Integer id){}

	public void Actualizar(Enfermedad enfmd){}

	public void Eliminar(Enfermedad enfmd){}

	public Collection ObtenerEnfermedades(String dni){}

}
