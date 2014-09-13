package domain

import org.uqbar.commons.utils.Observable
import org.uqbar.commons.model.Entity

@Observable
class UbicacionMateria extends Entity {
	@Property
	String nivel
	@Property
	String modalidad
	
	def getDescripcion(){
		modalidad.concat(" - ").concat(nivel)
	}
	
	override def toString(){
		descripcion
	}
}