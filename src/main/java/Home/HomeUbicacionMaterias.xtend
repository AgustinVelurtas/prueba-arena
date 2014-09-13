package Home
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.utils.Observable
import domain.UbicacionMateria
import java.util.List
import org.apache.commons.collections15.Predicate;

@Observable
class HomeUbicacionMaterias extends CollectionBasedHome<UbicacionMateria>{
	
	new(){
		this.init
	}
	
	def init(){

		this.create("1er Cuatrimestre", "1er Nivel")
		this.create("2d Cuatrimestre", "1er Nivel")
		this.create("Anual", "1er Nivel")
		this.create("1er Cuatrimestre", "2do Nivel")
		this.create("2d Cuatrimestre", "2do Nivel")
		this.create("Anual", "2do Nivel")
		this.create("1er Cuatrimestre", "3er Nivel")
		this.create("2d Cuatrimestre", "3er Nivel")
		this.create("Anual", "3er Nivel")
	}
	
	def void create(String modali, String nive) {
		var ubicacionMateria = new UbicacionMateria
		ubicacionMateria.modalidad = modali
		ubicacionMateria.nivel = nive
		this.create(ubicacionMateria)
	}
	
	def List<UbicacionMateria> getUbicaciones() {
		allInstances	
	}
	
 	def UbicacionMateria get(String modalidad, String nivel) {
		ubicaciones.findFirst [ ubi | ubi.modalidad.equals(modalidad) && ubi.nivel.equals(nivel)]
	}

	override def Class<UbicacionMateria> getEntityType() {
		typeof(UbicacionMateria)
	}

	override def createExample() {
		new UbicacionMateria()
	}

	override def Predicate<UbicacionMateria> getCriterio(UbicacionMateria example) {
		null
	}

	
}