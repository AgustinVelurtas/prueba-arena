package domain

import org.uqbar.commons.utils.Observable

@Observable
class Nota implements Cloneable {
	@Property
	String fecha
	@Property 
	String descripcion
	@Property 
	Boolean aprobado
	
	def agregarFecha(String date){
		fecha = date
	}
	
	def agregarDescripcion(String description) {
		descripcion = description
	}
	
	def agregarAprobacion(Boolean aprobacion) {
		aprobado = aprobacion
	}
	

def crear(String string, String string2, boolean b) {
		fecha = string
		descripcion = string2
		aprobado = b
		
		return this
	}
	
	override clone() {
		super.clone()
	}

}