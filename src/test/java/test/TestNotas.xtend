package test

import org.junit.Before
import org.junit.Test
import org.junit.Assert
import domain.SeguidorCarrera
import domain.Materia
import domain.Nota

class TestNotas {

	//@Before 
	//Alumno alumno = new Alumno()
	//Materia materia = new Materia("Disenio")

	@Test
	def void agregarMateriaTest(){
		var SeguidorCarrera seguidor = new SeguidorCarrera()
		var Materia materia = new Materia()
		materia.nombre = "disenio"
		seguidor.agregarMateria(materia)
		Assert.assertEquals(1,seguidor.materias.size)
	}
	
	@Test
	def void agregarNotaTest(){
		var Materia materia = new Materia()
		materia.nombre = "disenio"
		var Nota nota = new Nota()
		nota.fecha="17/8/2014"
		nota.descripcion = "Primer Parcial"
		nota.aprobado = true
		materia.agregarNota(nota)
		Assert.assertEquals(1, materia.notas.size)
		
	}
}