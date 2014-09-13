package ui

import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.layout.VerticalLayout
import domain.Nota

class EditarMateriaWindow extends Dialog<Nota>{
	
	Nota original
	
	new(WindowOwner owner, Nota nota) {
		super(owner, nota)
		original = modelObject.clone() as Nota
	}
	
	override executeTask(){
		super.executeTask()
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.setTitle("Editar Nota")
		mainPanel.layout = new VerticalLayout
		
		var panel1 = new Panel(mainPanel)
		panel1.layout = new HorizontalLayout
		new Label(panel1).setText("Fecha:")
		new TextBox(panel1).bindValueToProperty("fecha")
		
		var panel2 = new Panel(mainPanel)
		panel2.layout = new HorizontalLayout
		new Label(panel2).setText("Descripción:")
		new TextBox(panel2).bindValueToProperty("descripcion")
		
		var panel3 = new Panel(mainPanel)
		panel3.layout = new HorizontalLayout
		new CheckBox(panel3).bindValueToProperty("aprobado")
		new Label(panel3).setText(" Aprobado")
		
		
	}
	override protected addActions(Panel actionsPanel) {
		new Button(actionsPanel) => [
			caption = "Aceptar"
			onClick([| this.accept])
			setAsDefault.disableOnError]
	
	}
	
	
}