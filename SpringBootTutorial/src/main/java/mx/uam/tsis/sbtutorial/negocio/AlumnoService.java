package mx.uam.tsis.sbtutorial.negocio;

import java.util.Collection;

import mx.uam.tsis.sbtutorial.datos.AlumnoRepository;

import mx.uam.tsis.sbtutorial.datos.AlumnoDAO;
import mx.uam.tsis.sbtutorial.negocio.dominio.Alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * En este servicio se lleva a cabo toda la logica de negocio
 * relacionada con los alumnos
 * 
 *
 */
@Service
public class AlumnoService {
	
	@Autowired
	private AlumnoRepository repository;
	
	/**
	 * Recupera un alumno a partir de la matricula
	 * 
	 * @param matricula
	 * @return el alumno o null
	 */
	public Alumno getAlumno(int matricula) {
		// reglas de negocio se aplican aqui
		return repository.findByMatricula(matricula);
	}
	
	/**
	 * Recupera todos los alumnos
	 * 
	 * @return coleccion de alumnos
	 */
	public Collection<Alumno> getAlumnos() {
		// reglas de negocio se aplican aqui
		return repository.findAll();
	}
	
	/**
	 * Agrega un alumno
	 * 
	 * @param alumno El alumno a agregar
	 * @return true si se agrego exitosamente, false sino
	 */
	public boolean addAlumno(Alumno alumno) {
		
            // Agregar al alumno al mecanismo de persistencia tomando en 
            // cuenta la siguiente regla de negocio: No se puede 
            // agregar un alumno con la misma matricula más de una vez
		if(repository.findByMatricula(alumno.getMatricula())== null){
			repository.save(alumno);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Borra un alumno
	 * 
	 * @param alumno El alumno a agregar
	 * @return true si se agrego exitosamente, false sino
	 */
	public boolean deleteAlumno(int matricula) {
		
            // Borrar al alumno al mecanismo de persistencia 
		if(repository.findByMatricula(matricula)!= null){
			Alumno alumno = getAlumno(matricula);
			repository.delete(alumno);
			return true;
		}
		else
			return false;
	}
	

}
