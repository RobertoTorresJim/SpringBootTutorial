package mx.uam.tsis.sbtutorial.negocio.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * Entidad del modelo de dominio
 * 
 */
@Entity

public class Alumno {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String nombre;
	
	private int matricula;
	
	/**
	 * Constructor por default
	 */
	public Alumno() {}

	
	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
	}
	
	/**
	 * Cambia el nombre
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre){
		this.nombre=nombre;
}
	
	/**
	 * Recupera nombre
	 * 
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna la matricula
	 * 
	 * @param matricula
	 */
	public void setMatricula(Integer matricula){
		this.matricula=matricula;
	}

	/**
	 * Recupera la matricula
	 * 
	 * @return matricula
	 */
	public int getMatricula() {
		return matricula;
	}


}
