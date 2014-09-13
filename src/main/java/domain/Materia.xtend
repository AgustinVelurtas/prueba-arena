package domain

import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class Materia extends Entity implements Cloneable{
	@Property 
	String nombre
	@Property
	Boolean finalAprobado
	@Property
	Integer anioCursada
	@Property
	String profesor
	@Property
	ArrayList<Nota> notas
	@Property
	UbicacionMateria ubicacion
	
	new(){
		notas = new ArrayList
	}
	
	def crear(Boolean aprobado, Integer anio, String prof, String modalidad, String nivel){
		finalAprobado = aprobado
		anioCursada = anio
		profesor = prof
		ubicacion.setModalidad(modalidad)
		ubicacion.setNivel(nivel)
	}
		
	def agregarNota(Nota nota){
		notas.add(nota)
	}
	
	def borrarNota(Nota nota){
		var Nota notita = new Nota
		notita = notas.findFirst[notaAux | notaAux.descripcion == nota.descripcion]
		notas.remove(notita)

	}
	
	
}