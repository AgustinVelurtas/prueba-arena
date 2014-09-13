package ui;

import domain.Nota;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.CheckBox;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class EditarMateriaWindow extends Dialog<Nota> {
  private Nota original;
  
  public EditarMateriaWindow(final WindowOwner owner, final Nota nota) {
    super(owner, nota);
    Nota _modelObject = this.getModelObject();
    Object _clone = _modelObject.clone();
    this.original = ((Nota) _clone);
  }
  
  public void executeTask() {
    super.executeTask();
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Editar Nota");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Panel panel1 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    panel1.setLayout(_horizontalLayout);
    Label _label = new Label(panel1);
    _label.setText("Fecha:");
    TextBox _textBox = new TextBox(panel1);
    _textBox.<ControlBuilder>bindValueToProperty("fecha");
    Panel panel2 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_1 = new HorizontalLayout();
    panel2.setLayout(_horizontalLayout_1);
    Label _label_1 = new Label(panel2);
    _label_1.setText("Descripción:");
    TextBox _textBox_1 = new TextBox(panel2);
    _textBox_1.<ControlBuilder>bindValueToProperty("descripcion");
    Panel panel3 = new Panel(mainPanel);
    HorizontalLayout _horizontalLayout_2 = new HorizontalLayout();
    panel3.setLayout(_horizontalLayout_2);
    CheckBox _checkBox = new CheckBox(panel3);
    _checkBox.<ControlBuilder>bindValueToProperty("aprobado");
    Label _label_2 = new Label(panel3);
    _label_2.setText(" Aprobado");
  }
  
  protected void addActions(final Panel actionsPanel) {
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            EditarMateriaWindow.this.accept();
          }
        };
        it.onClick(_function);
        Button _setAsDefault = it.setAsDefault();
        _setAsDefault.disableOnError();
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
  }
}
