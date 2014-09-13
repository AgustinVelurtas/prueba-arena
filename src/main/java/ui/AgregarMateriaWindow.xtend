package ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.commons.utils.ApplicationContext
import domain.Materia
import Home.HomeMaterias

class AgregarMateriaWindow extends Dialog<Materia>{
		
	new(WindowOwner owner) {
		super(owner,new Materia)
	}
	
	override executeTask(){
		getHomeMaterias.create(modelObject)
		modelObject.crear(false, 0000,"Sin profesor","","")
		super.executeTask()
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Nueva Materia")
		new Label(mainPanel).setText("Nombre:")
		val text = new TextBox(mainPanel)
		text.bindValueToProperty("nombre")
		text.setWidth(200)
	}
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) => [
			caption = "Aceptar"
			onClick([| this.accept])
		]
	
	}
	def getHomeMaterias() {
		ApplicationContext.instance.getSingleton(typeof(Materia)) as HomeMaterias
	}
	
}