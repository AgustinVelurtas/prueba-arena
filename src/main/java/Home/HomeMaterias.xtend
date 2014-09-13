package Home
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import java.util.ArrayList
import org.apache.commons.collections15.Predicate;
import domain.Materia
import domain.Nota
import org.uqbar.commons.utils.ApplicationContext
import domain.UbicacionMateria

@Observable
class HomeMaterias extends CollectionBasedHome<Materia> {
			
	new(){
		this.init
	}
	
	def init(){
		var ArrayList<Nota> notas = new ArrayList
		var ArrayList<Nota> notas2 = new ArrayList
		var ArrayList<Nota> notas3 = new ArrayList
		
		notas.add((new Nota).crear("12/05/2014","Parcial 1", true))
		notas.add((new Nota).crear("13/07/2014","Parcial 2", false))
		
		this.create("Ingenieria y Sociedad", 2012, "No me acuerdo", true, notas, getUbicacion("1er Cuatrimestre", "1er Nivel"))
		
		notas2.add((new Nota).crear("09/04/2014","tp", true))
		notas2.add((new Nota).crear("13/05/2014","Parcial 1", false))
		
		this.create("Analisis I", 2012, "Esther Milan", false, notas2, getUbicacion("1er Cuatrimestre", "3er Nivel"))
		
		notas3.add((new Nota).crear("20/04/2014","tp", true))
		notas3.add((new Nota).crear("07/08/2014","Parcial 2", false))
		
		this.create("Algoritmos", 2012, "Patricia Mayor", true, notas3, getUbicacion("Anual", "1er Nivel"))
		this.create("Analisis de Sistemas", 2013, "Ines Casanovas", true, notas, getUbicacion("Anual", "2do Nivel"))
		this.create("Sistemas Operativos", 2014, "Scarfiello", false, notas, getUbicacion("2do Cuatrimestre", "3er Nivel"))
	}
	
	def void create(String pnombre, Integer anio, String nombreProfesor, Boolean pfinal, ArrayList<Nota> notasss, UbicacionMateria ubicacion) {
		var materia = new Materia
		materia.nombre = pnombre
		materia.finalAprobado = pfinal
		materia.anioCursada = anio
		materia.profesor = nombreProfesor
		materia.notas = notasss
		materia.ubicacion = ubicacion
		this.create(materia)
	}
	
	def getUbicacion(String modalidad, String nivel) {
		(ApplicationContext.instance.getSingleton(typeof(UbicacionMateria)) as HomeUbicacionMaterias).get(modalidad, nivel)
	}
	
		
	override def Predicate<Materia> getCriterio(Materia example) {
		null
	}
	override def getEntityType() {
		typeof(Materia)
	}

	override def createExample() {
		new Materia()
	}
	
	def show(){
		return allInstances
	}
}