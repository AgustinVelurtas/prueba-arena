package ui;

import Home.HomeUbicacionMaterias;
import com.google.common.base.Objects;
import com.uqbar.commons.collections.Transformer;
import domain.Materia;
import domain.Nota;
import domain.SeguidorCarrera;
import domain.UbicacionMateria;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.SkinnableControl;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import ui.AgregarMateriaWindow;
import ui.EditarMateriaWindow;

@SuppressWarnings("all")
public class MateriaWindow extends SimpleWindow<SeguidorCarrera> {
  public MateriaWindow(final WindowOwner parent) {
    super(parent, new SeguidorCarrera());
    SeguidorCarrera _modelObject = this.getModelObject();
    _modelObject.show();
  }
  
  /**
   * TEMPLATE
   */
  public void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Seguidor de carrera");
    Panel _panel = new Panel(mainPanel);
    Label _label = new Label(_panel);
    Label _setText = _label.setText("Seguidor de carrera");
    _setText.setFontSize(30);
    final Panel form = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    form.setLayout(_horizontalLayout);
    this.crearListaMaterias(form);
    this.crearDetallesMateria(form);
  }
  
  /**
   * LISTA DE MATERIAS
   */
  public Button crearListaMaterias(final Panel panel) {
    Button _xblockexpression = null;
    {
      final Panel panelListaMaterias = new Panel(panel);
      Label _label = new Label(panelListaMaterias);
      _label.setText("Materias");
      this.crearLista(panelListaMaterias);
      Button _button = new Button(panelListaMaterias);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nueva Materia");
          MessageSend _messageSend = new MessageSend(MateriaWindow.this, "agregarMateria");
          it.onClick(_messageSend);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    }
    return _xblockexpression;
  }
  
  public Column<Materia> crearLista(final Panel panel) {
    Column<Materia> _xblockexpression = null;
    {
      Table<Materia> tabla = new Table<Materia>(panel, Materia.class);
      tabla.setWidth(150);
      tabla.setHeigth(350);
      tabla.bindItemsToProperty("materias");
      tabla.<ControlBuilder>bindValueToProperty("materiaSeleccionada");
      Column<Materia> columnaNombre = new Column<Materia>(tabla);
      _xblockexpression = columnaNombre.bindContentsToProperty("nombre");
    }
    return _xblockexpression;
  }
  
  /**
   * TEMPLATE
   */
  public void crearDetallesMateria(final Panel panel) {
    final Panel panelDetalleMateria = new Panel(panel);
    Label _label = new Label(panelDetalleMateria);
    Label _setText = _label.setText("Materia Seleccionada");
    SkinnableControl _setFontSize = _setText.setFontSize(20);
    _setFontSize.<ControlBuilder>bindValueToProperty("materiaSeleccionada.nombre");
    this.panelAnioYFinal(panelDetalleMateria);
    this.panelProfesor(panelDetalleMateria);
    this.panelUbicacion(panelDetalleMateria);
    Label _label_1 = new Label(panelDetalleMateria);
    _label_1.setText("Notas de cursada");
    this.crearTablaNotas(panelDetalleMateria);
    this.addActions(panelDetalleMateria);
  }
  
  /**
   * TABLA DE NOTAS
   */
  public Column<Nota> crearTablaNotas(final Panel panel) {
    Column<Nota> _xblockexpression = null;
    {
      Table<Nota> tabla = new Table<Nota>(panel, Nota.class);
      tabla.setHeigth(150);
      tabla.bindItemsToProperty("materiaSeleccionada.notas");
      tabla.<ControlBuilder>bindSelectionToProperty("notaSeleccionada");
      Column<Nota> columnaFecha = new Column<Nota>(tabla);
      columnaFecha.setTitle("Fecha");
      columnaFecha.setFixedSize(100);
      columnaFecha.bindContentsToProperty("fecha");
      Column<Nota> columnaDescripcion = new Column<Nota>(tabla);
      columnaDescripcion.setTitle("Descripcion");
      columnaDescripcion.setFixedSize(100);
      columnaDescripcion.bindContentsToProperty("descripcion");
      Column<Nota> columnaAprobado = new Column<Nota>(tabla);
      columnaAprobado.setTitle("Aprobado");
      columnaAprobado.setFixedSize(100);
      final Transformer<Nota, String> _function = new Transformer<Nota, String>() {
        public String transform(final Nota nota) {
          String _xifexpression = null;
          Boolean _aprobado = nota.getAprobado();
          if ((_aprobado).booleanValue()) {
            _xifexpression = "Si";
          } else {
            _xifexpression = "No";
          }
          return _xifexpression;
        }
      };
      _xblockexpression = columnaAprobado.<String>bindContentsToTransformer(_function);
    }
    return _xblockexpression;
  }
  
  public boolean agregarNota() {
    boolean _xblockexpression = false;
    {
      Nota nota = new Nota();
      nota.crear("Sin fecha", "Sin descripcion", false);
      SeguidorCarrera _modelObject = this.getModelObject();
      List<Materia> _materias = _modelObject.getMaterias();
      final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
        public Boolean apply(final Materia materia) {
          String _nombre = materia.getNombre();
          SeguidorCarrera _modelObject = MateriaWindow.this.getModelObject();
          Materia _materiaSeleccionada = _modelObject.getMateriaSeleccionada();
          String _nombre_1 = _materiaSeleccionada.getNombre();
          return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
        }
      };
      Materia _findFirst = IterableExtensions.<Materia>findFirst(_materias, _function);
      _xblockexpression = _findFirst.agregarNota(nota);
    }
    return _xblockexpression;
  }
  
  public boolean borrarNota() {
    SeguidorCarrera _modelObject = this.getModelObject();
    List<Materia> _materias = _modelObject.getMaterias();
    final Function1<Materia, Boolean> _function = new Function1<Materia, Boolean>() {
      public Boolean apply(final Materia materia) {
        String _nombre = materia.getNombre();
        SeguidorCarrera _modelObject = MateriaWindow.this.getModelObject();
        Materia _materiaSeleccionada = _modelObject.getMateriaSeleccionada();
        String _nombre_1 = _materiaSeleccionada.getNombre();
        return Boolean.valueOf(Objects.equal(_nombre, _nombre_1));
      }
    };
    Materia _findFirst = IterableExtensions.<Materia>findFirst(_materias, _function);
    SeguidorCarrera _modelObject_1 = this.getModelObject();
    Nota _notaSeleccionada = _modelObject_1.getNotaSeleccionada();
    return _findFirst.borrarNota(_notaSeleccionada);
  }
  
  /**
   * PANELES
   */
  public Binding<ListBuilder<UbicacionMateria>> panelUbicacion(final Panel panel) {
    Binding<ListBuilder<UbicacionMateria>> _xblockexpression = null;
    {
      Panel panelUbicacion = this.crearPanelHorizontal(panel);
      Label _label = new Label(panelUbicacion);
      _label.setText("Ubicacion de materia ");
      final Selector<UbicacionMateria> selectorUbicacion = new Selector<UbicacionMateria>(panel);
      selectorUbicacion.allowNull(false);
      selectorUbicacion.<ControlBuilder>bindValueToProperty("materiaSeleccionada.ubicacion");
      HomeUbicacionMaterias _homeUbicacionMaterias = this.getHomeUbicacionMaterias();
      ObservableProperty _observableProperty = new ObservableProperty(_homeUbicacionMaterias, "ubicaciones");
      Binding<ListBuilder<UbicacionMateria>> propiedadUbicacion = selectorUbicacion.bindItems(_observableProperty);
      PropertyAdapter _propertyAdapter = new PropertyAdapter(UbicacionMateria.class, "descripcion");
      _xblockexpression = propiedadUbicacion.setAdapter(_propertyAdapter);
    }
    return _xblockexpression;
  }
  
  public Binding<ControlBuilder> panelProfesor(final Panel panel) {
    Binding<ControlBuilder> _xblockexpression = null;
    {
      Panel panelProfesor = this.crearPanelHorizontal(panel);
      Label _label = new Label(panelProfesor);
      _label.setText("Profesor de cursada");
      TextBox _textBox = new TextBox(panelProfesor);
      _xblockexpression = _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.profesor");
    }
    return _xblockexpression;
  }
  
  public Label panelAnioYFinal(final Panel panel) {
    Label _xblockexpression = null;
    {
      Panel panelAnioYFinal = this.crearPanelHorizontal(panel);
      Label _label = new Label(panelAnioYFinal);
      _label.setText("Año cursada: ");
      TextBox _textBox = new TextBox(panelAnioYFinal);
      _textBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.anioCursada");
      CheckBox _checkBox = new CheckBox(panelAnioYFinal);
      _checkBox.<ControlBuilder>bindValueToProperty("materiaSeleccionada.finalAprobado");
      Label _label_1 = new Label(panelAnioYFinal);
      _xblockexpression = _label_1.setText(" Final Aprobado");
    }
    return _xblockexpression;
  }
  
  /**
   * AUXILIARES
   */
  public void agregarMateria() {
    AgregarMateriaWindow _agregarMateriaWindow = new AgregarMateriaWindow(this);
    this.openDialog(_agregarMateriaWindow);
    SeguidorCarrera _modelObject = this.getModelObject();
    _modelObject.show();
  }
  
  public void editarMateria() {
    SeguidorCarrera _modelObject = this.getModelObject();
    Nota _notaSeleccionada = _modelObject.getNotaSeleccionada();
    EditarMateriaWindow _editarMateriaWindow = new EditarMateriaWindow(this, _notaSeleccionada);
    this.openDialog(_editarMateriaWindow);
  }
  
  public void openDialog(final Dialog<?> window) {
    window.open();
  }
  
  public HomeUbicacionMaterias getHomeUbicacionMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(UbicacionMateria.class);
    return ((HomeUbicacionMaterias) _singleton);
  }
  
  protected void addActions(final Panel actionsPanel) {
    final Panel panelBotonesMateria = this.crearPanelHorizontal(actionsPanel);
    Button _button = new Button(panelBotonesMateria);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Editar");
        MessageSend _messageSend = new MessageSend(MateriaWindow.this, "editarMateria");
        it.onClick(_messageSend);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(panelBotonesMateria);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("+");
        MessageSend _messageSend = new MessageSend(MateriaWindow.this, "agregarNota");
        it.onClick(_messageSend);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
    Button _button_2 = new Button(panelBotonesMateria);
    final Procedure1<Button> _function_2 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("-");
        MessageSend _messageSend = new MessageSend(MateriaWindow.this, "borrarNota");
        it.onClick(_messageSend);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
  }
  
  public Panel crearPanelHorizontal(final Panel panel) {
    Panel panelNuevo = new Panel(panel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panelNuevo.setLayout(_horizontalLayout);
    return panelNuevo;
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
}
