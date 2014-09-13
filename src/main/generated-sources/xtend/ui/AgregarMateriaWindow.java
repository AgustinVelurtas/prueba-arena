package ui;

import Home.HomeMaterias;
import domain.Materia;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class AgregarMateriaWindow extends Dialog<Materia> {
  public AgregarMateriaWindow(final WindowOwner owner) {
    super(owner, new Materia());
  }
  
  public void executeTask() {
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    Materia _modelObject = this.getModelObject();
    _homeMaterias.create(_modelObject);
    Materia _modelObject_1 = this.getModelObject();
    _modelObject_1.crear(Boolean.valueOf(false), Integer.valueOf(0000), "Sin profesor", "", "");
    super.executeTask();
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Nueva Materia");
    Label _label = new Label(mainPanel);
    _label.setText("Nombre:");
    final TextBox text = new TextBox(mainPanel);
    text.<ControlBuilder>bindValueToProperty("nombre");
    text.setWidth(200);
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            AgregarMateriaWindow.this.accept();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(Materia.class);
    return ((HomeMaterias) _singleton);
  }
}
