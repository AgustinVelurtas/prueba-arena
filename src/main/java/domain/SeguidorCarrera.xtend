package domain

import java.util.ArrayList
import org.uqbar.commons.utils.Observable
import org.uqbar.commons.utils.ApplicationContext
import Home.HomeMaterias
import java.util.List

@Observable
class SeguidorCarrera {
	@Property
	List <Materia> materias
	@Property
	String nombre
	@Property
	Materia materiaSeleccionada
	@Property
	Nota notaSeleccionada
	
	public def getMaterias(){
		return this._materias
	}
	
	def agregarMateria(Materia materia){
		materias.add(materia)
	}
	
	def agregar(){
		var materia = new Materia
		agregarMateria(materia)
	}
	
	def show() {
		materias = new ArrayList<Materia>
		materias = getHomeMaterias().show()
	}
	
	def HomeMaterias getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia))
	}
	
		
}