package domain;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class UbicacionMateria extends Entity {
  private String _nivel;
  
  public String getNivel() {
    return this._nivel;
  }
  
  public void setNivel(final String nivel) {
    this._nivel = nivel;
  }
  
  private String _modalidad;
  
  public String getModalidad() {
    return this._modalidad;
  }
  
  public void setModalidad(final String modalidad) {
    this._modalidad = modalidad;
  }
  
  public String getDescripcion() {
    String _modalidad = this.getModalidad();
    String _concat = _modalidad.concat(" - ");
    String _nivel = this.getNivel();
    return _concat.concat(_nivel);
  }
  
  public String toString() {
    return this.getDescripcion();
  }
}
