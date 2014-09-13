package Home;

import domain.UbicacionMateria;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeUbicacionMaterias extends CollectionBasedHome<UbicacionMateria> {
  public HomeUbicacionMaterias() {
    this.init();
  }
  
  public void init() {
    this.create("1er Cuatrimestre", "1er Nivel");
    this.create("2d Cuatrimestre", "1er Nivel");
    this.create("Anual", "1er Nivel");
    this.create("1er Cuatrimestre", "2do Nivel");
    this.create("2d Cuatrimestre", "2do Nivel");
    this.create("Anual", "2do Nivel");
    this.create("1er Cuatrimestre", "3er Nivel");
    this.create("2d Cuatrimestre", "3er Nivel");
    this.create("Anual", "3er Nivel");
  }
  
  public void create(final String modali, final String nive) {
    UbicacionMateria ubicacionMateria = new UbicacionMateria();
    ubicacionMateria.setModalidad(modali);
    ubicacionMateria.setNivel(nive);
    this.create(ubicacionMateria);
  }
  
  public List<UbicacionMateria> getUbicaciones() {
    return this.allInstances();
  }
  
  public UbicacionMateria get(final String modalidad, final String nivel) {
    List<UbicacionMateria> _ubicaciones = this.getUbicaciones();
    final Function1<UbicacionMateria, Boolean> _function = new Function1<UbicacionMateria, Boolean>() {
      public Boolean apply(final UbicacionMateria ubi) {
        boolean _and = false;
        String _modalidad = ubi.getModalidad();
        boolean _equals = _modalidad.equals(modalidad);
        if (!_equals) {
          _and = false;
        } else {
          String _nivel = ubi.getNivel();
          boolean _equals_1 = _nivel.equals(nivel);
          _and = _equals_1;
        }
        return Boolean.valueOf(_and);
      }
    };
    return IterableExtensions.<UbicacionMateria>findFirst(_ubicaciones, _function);
  }
  
  public Class<UbicacionMateria> getEntityType() {
    return UbicacionMateria.class;
  }
  
  public UbicacionMateria createExample() {
    return new UbicacionMateria();
  }
  
  public Predicate<UbicacionMateria> getCriterio(final UbicacionMateria example) {
    return null;
  }
}
