package Runnable

import org.uqbar.arena.Application
import org.uqbar.commons.utils.ApplicationContext
import Home.HomeMaterias
import ui.MateriaWindow
import domain.Materia
import domain.UbicacionMateria
import Home.HomeUbicacionMaterias

class App extends Application {
	
	override protected createMainWindow() {
		ApplicationContext.instance.configureSingleton(typeof(UbicacionMateria), new HomeUbicacionMaterias())
		ApplicationContext.instance.configureSingleton(typeof(Materia), new HomeMaterias())
		return new MateriaWindow(this)
	}
	
	def static main(String[] args){
		new App().start
	}
	
	
}