package domain;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class Nota implements Cloneable {
  private String _fecha;
  
  public String getFecha() {
    return this._fecha;
  }
  
  public void setFecha(final String fecha) {
    this._fecha = fecha;
  }
  
  private String _descripcion;
  
  public String getDescripcion() {
    return this._descripcion;
  }
  
  public void setDescripcion(final String descripcion) {
    this._descripcion = descripcion;
  }
  
  private Boolean _aprobado;
  
  public Boolean getAprobado() {
    return this._aprobado;
  }
  
  public void setAprobado(final Boolean aprobado) {
    this._aprobado = aprobado;
  }
  
  public void agregarFecha(final String date) {
    this.setFecha(date);
  }
  
  public void agregarDescripcion(final String description) {
    this.setDescripcion(description);
  }
  
  public void agregarAprobacion(final Boolean aprobacion) {
    this.setAprobado(aprobacion);
  }
  
  public Nota crear(final String string, final String string2, final boolean b) {
    this.setFecha(string);
    this.setDescripcion(string2);
    this.setAprobado(Boolean.valueOf(b));
    return this;
  }
  
  public Object clone() {
    try {
      return super.clone();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
