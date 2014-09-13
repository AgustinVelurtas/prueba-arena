package ui

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.widgets.tables.Table
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import domain.SeguidorCarrera
import domain.Materia
import domain.Nota
import domain.UbicacionMateria
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter
import Home.HomeUbicacionMaterias
import org.uqbar.commons.utils.ApplicationContext

class MateriaWindow extends SimpleWindow<SeguidorCarrera>{

	new(WindowOwner parent) {
		super(parent, new SeguidorCarrera)
		modelObject.show()
	}
	
/****************************** TEMPLATE ********************************************************/
	override createMainTemplate(Panel mainPanel) {
		this.setTitle("Seguidor de carrera")
		new Label(new Panel(mainPanel)).setText("Seguidor de carrera").setFontSize(30)
		
		val form = new Panel(mainPanel) 
		form.layout = new HorizontalLayout
		
		crearListaMaterias(form)
		crearDetallesMateria(form)
		
	}
	

/****************************** LISTA DE MATERIAS ***********************************************/
	def crearListaMaterias(Panel panel){
		val panelListaMaterias = new Panel(panel)
		new Label(panelListaMaterias).setText("Materias")
				
		crearLista(panelListaMaterias)
		
		new Button(panelListaMaterias) => [
			caption = "Nueva Materia"
			onClick(new MessageSend(this,"agregarMateria"))
		]
		
	}
	
	def crearLista(Panel panel) {
		var Table<Materia> tabla = new Table<Materia>(panel, Materia)
		tabla.setWidth(150)
		tabla.setHeigth(350)
		
	 	tabla.bindItemsToProperty("materias")
	 	tabla.bindValueToProperty("materiaSeleccionada")
	 	
		var Column<Materia> columnaNombre = new Column<Materia>(tabla)
		columnaNombre.bindContentsToProperty("nombre")
		}
	
/****************************** DETALLES DE MATERIA **********************************************/
/*****************TEMPLATE*******************/
	def crearDetallesMateria(Panel panel){
		val panelDetalleMateria = new Panel(panel)
		new Label(panelDetalleMateria).setText("Materia Seleccionada").setFontSize(20)
		.bindValueToProperty("materiaSeleccionada.nombre")
		
		
		
		panelAnioYFinal(panelDetalleMateria)
		
		panelProfesor(panelDetalleMateria)
		
		panelUbicacion(panelDetalleMateria)
		
		new Label(panelDetalleMateria).setText("Notas de cursada")
		
		crearTablaNotas(panelDetalleMateria)
		
		addActions(panelDetalleMateria)
		
	}

	
/************TABLA DE NOTAS*******************/
	def crearTablaNotas(Panel panel) {
		var Table<Nota> tabla = new Table<Nota>(panel, Nota)
		tabla.setHeigth(150)
		tabla.bindItemsToProperty("materiaSeleccionada.notas")
		tabla.bindSelectionToProperty("notaSeleccionada")
		
		var Column<Nota> columnaFecha = new Column<Nota>(tabla)
		columnaFecha.setTitle("Fecha")
		columnaFecha.setFixedSize(100)
		columnaFecha.bindContentsToProperty("fecha")		
		
		var Column<Nota> columnaDescripcion = new Column<Nota>(tabla)
		columnaDescripcion.setTitle("Descripcion")
		columnaDescripcion.setFixedSize(100)
		columnaDescripcion.bindContentsToProperty("descripcion")
		
		var Column<Nota> columnaAprobado = new Column<Nota>(tabla)
		columnaAprobado.setTitle("Aprobado")
		columnaAprobado.setFixedSize(100)
		columnaAprobado.bindContentsToTransformer([nota | if (nota.aprobado) "Si" else "No"])

	}
	
	def agregarNota(){
		var Nota nota = new Nota
		nota.crear("Sin fecha", "Sin descripcion", false)
		modelObject.getMaterias().findFirst[materia | materia.nombre == modelObject.materiaSeleccionada.nombre].agregarNota(nota)
	}
	
	def borrarNota(){
		modelObject.getMaterias().findFirst[materia | materia.nombre == modelObject.materiaSeleccionada.nombre].borrarNota(modelObject.notaSeleccionada)	

	}

	
/******************PANELES*******************/	
	def panelUbicacion(Panel panel) {
		var panelUbicacion = crearPanelHorizontal(panel)
		new Label(panelUbicacion).setText("Ubicacion de materia ")
		
		//aca viene el cosito para elegir entre las opciones de ubicacion es la materia
		val selectorUbicacion = new Selector<UbicacionMateria>(panel)
		selectorUbicacion.allowNull(false)
		selectorUbicacion.bindValueToProperty("materiaSeleccionada.ubicacion")
		var propiedadUbicacion = selectorUbicacion.bindItems(new ObservableProperty(homeUbicacionMaterias, "ubicaciones"))
		propiedadUbicacion.adapter = new PropertyAdapter(typeof(UbicacionMateria), "descripcion")

	}
	
	def panelProfesor(Panel panel) {
		var panelProfesor = crearPanelHorizontal(panel)
		new Label(panelProfesor).setText("Profesor de cursada")
		new TextBox(panelProfesor).bindValueToProperty("materiaSeleccionada.profesor")
	}
	
	def panelAnioYFinal(Panel panel) {
		var panelAnioYFinal = crearPanelHorizontal(panel)
		new Label(panelAnioYFinal).setText("Año cursada: ")
		new TextBox(panelAnioYFinal).bindValueToProperty("materiaSeleccionada.anioCursada")
		new CheckBox(panelAnioYFinal).bindValueToProperty("materiaSeleccionada.finalAprobado")
		new Label(panelAnioYFinal).setText(" Final Aprobado")
	}


/************************ AUXILIARES ************************************************************/
	def agregarMateria(){
		this.openDialog(new AgregarMateriaWindow(this))
		modelObject.show()
	}
	
	def editarMateria(){
		this.openDialog(new EditarMateriaWindow(this, modelObject.notaSeleccionada))
	}
	
	def openDialog(Dialog<?> window) {
			window.open()
		}
		
		
	def getHomeUbicacionMaterias() {
		ApplicationContext::instance.getSingleton(typeof(UbicacionMateria)) as HomeUbicacionMaterias
	}
	
	override protected addActions(Panel actionsPanel) {
		val panelBotonesMateria = crearPanelHorizontal(actionsPanel)
		new Button(panelBotonesMateria) => [
			caption = "Editar"
			onClick(new MessageSend(this,"editarMateria"))
		]
		new Button(panelBotonesMateria) => [
			caption = "+"
			onClick(new MessageSend(this, "agregarNota"))
		]
		new Button(panelBotonesMateria) => [
			caption = "-"
			onClick(new MessageSend(this, "borrarNota"))
		]
			
		//FIXME: Falta Actualizar la lista de notas eo eo eo		
	}

	def Panel crearPanelHorizontal(Panel panel ){
		var panelNuevo = new Panel(panel)
		panelNuevo.layout = new HorizontalLayout
		return panelNuevo
		}

	override protected createFormPanel(Panel mainPanel) {
		
	}
	
	}
