package domain;

import com.google.common.base.Objects;
import domain.Nota;
import domain.UbicacionMateria;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Materia extends Entity implements Cloneable {
  private String _nombre;
  
  public String getNombre() {
    return this._nombre;
  }
  
  public void setNombre(final String nombre) {
    this._nombre = nombre;
  }
  
  private Boolean _finalAprobado;
  
  public Boolean getFinalAprobado() {
    return this._finalAprobado;
  }
  
  public void setFinalAprobado(final Boolean finalAprobado) {
    this._finalAprobado = finalAprobado;
  }
  
  private Integer _anioCursada;
  
  public Integer getAnioCursada() {
    return this._anioCursada;
  }
  
  public void setAnioCursada(final Integer anioCursada) {
    this._anioCursada = anioCursada;
  }
  
  private String _profesor;
  
  public String getProfesor() {
    return this._profesor;
  }
  
  public void setProfesor(final String profesor) {
    this._profesor = profesor;
  }
  
  private ArrayList<Nota> _notas;
  
  public ArrayList<Nota> getNotas() {
    return this._notas;
  }
  
  public void setNotas(final ArrayList<Nota> notas) {
    this._notas = notas;
  }
  
  private UbicacionMateria _ubicacion;
  
  public UbicacionMateria getUbicacion() {
    return this._ubicacion;
  }
  
  public void setUbicacion(final UbicacionMateria ubicacion) {
    this._ubicacion = ubicacion;
  }
  
  public Materia() {
    ArrayList<Nota> _arrayList = new ArrayList<Nota>();
    this.setNotas(_arrayList);
  }
  
  public void crear(final Boolean aprobado, final Integer anio, final String prof, final String modalidad, final String nivel) {
    this.setFinalAprobado(aprobado);
    this.setAnioCursada(anio);
    this.setProfesor(prof);
    UbicacionMateria _ubicacion = this.getUbicacion();
    _ubicacion.setModalidad(modalidad);
    UbicacionMateria _ubicacion_1 = this.getUbicacion();
    _ubicacion_1.setNivel(nivel);
  }
  
  public boolean agregarNota(final Nota nota) {
    ArrayList<Nota> _notas = this.getNotas();
    return _notas.add(nota);
  }
  
  public boolean borrarNota(final Nota nota) {
    boolean _xblockexpression = false;
    {
      Nota notita = new Nota();
      ArrayList<Nota> _notas = this.getNotas();
      final Function1<Nota, Boolean> _function = new Function1<Nota, Boolean>() {
        public Boolean apply(final Nota notaAux) {
          String _descripcion = notaAux.getDescripcion();
          String _descripcion_1 = nota.getDescripcion();
          return Boolean.valueOf(Objects.equal(_descripcion, _descripcion_1));
        }
      };
      Nota _findFirst = IterableExtensions.<Nota>findFirst(_notas, _function);
      notita = _findFirst;
      ArrayList<Nota> _notas_1 = this.getNotas();
      _xblockexpression = _notas_1.remove(notita);
    }
    return _xblockexpression;
  }
}
