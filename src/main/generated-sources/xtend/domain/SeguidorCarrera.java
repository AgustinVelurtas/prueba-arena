package domain;

import Home.HomeMaterias;
import domain.Materia;
import domain.Nota;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class SeguidorCarrera {
  private List<Materia> _materias;
  
  public void setMaterias(final List<Materia> materias) {
    this._materias = materias;
  }
  
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Materia _materiaSeleccionada;
  
  public Materia getMateriaSeleccionada() {
    return this._materiaSeleccionada;
  }
  
  public void setMateriaSeleccionada(final Materia materiaSeleccionada) {
    this._materiaSeleccionada = materiaSeleccionada;
  }
  
  private Nota _notaSeleccionada;
  
  public Nota getNotaSeleccionada() {
    return this._notaSeleccionada;
  }
  
  public void setNotaSeleccionada(final Nota notaSeleccionada) {
    this._notaSeleccionada = notaSeleccionada;
  }
  
  public List<Materia> getMaterias() {
    return this._materias;
  }
  
  public boolean agregarMateria(final Materia materia) {
    List<Materia> _materias = this.getMaterias();
    return _materias.add(materia);
  }
  
  public boolean agregar() {
    boolean _xblockexpression = false;
    {
      Materia materia = new Materia();
      _xblockexpression = this.agregarMateria(materia);
    }
    return _xblockexpression;
  }
  
  public void show() {
    ArrayList<Materia> _arrayList = new ArrayList<Materia>();
    this.setMaterias(_arrayList);
    HomeMaterias _homeMaterias = this.getHomeMaterias();
    List<Materia> _show = _homeMaterias.show();
    this.setMaterias(_show);
  }
  
  public HomeMaterias getHomeMaterias() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    return _instance.<HomeMaterias>getSingleton(Materia.class);
  }
}
