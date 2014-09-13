package Home;

import Home.HomeUbicacionMaterias;
import domain.Materia;
import domain.Nota;
import domain.UbicacionMateria;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
import org.uqbar.commons.utils.ApplicationContext;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class HomeMaterias extends CollectionBasedHome<Materia> {
  public HomeMaterias() {
    this.init();
  }
  
  public void init() {
    ArrayList<Nota> notas = new ArrayList<Nota>();
    ArrayList<Nota> notas2 = new ArrayList<Nota>();
    ArrayList<Nota> notas3 = new ArrayList<Nota>();
    Nota _nota = new Nota();
    Nota _crear = _nota.crear("12/05/2014", "Parcial 1", true);
    notas.add(_crear);
    Nota _nota_1 = new Nota();
    Nota _crear_1 = _nota_1.crear("13/07/2014", "Parcial 2", false);
    notas.add(_crear_1);
    UbicacionMateria _ubicacion = this.getUbicacion("1er Cuatrimestre", "1er Nivel");
    this.create("Ingenieria y Sociedad", Integer.valueOf(2012), "No me acuerdo", Boolean.valueOf(true), notas, _ubicacion);
    Nota _nota_2 = new Nota();
    Nota _crear_2 = _nota_2.crear("09/04/2014", "tp", true);
    notas2.add(_crear_2);
    Nota _nota_3 = new Nota();
    Nota _crear_3 = _nota_3.crear("13/05/2014", "Parcial 1", false);
    notas2.add(_crear_3);
    UbicacionMateria _ubicacion_1 = this.getUbicacion("1er Cuatrimestre", "3er Nivel");
    this.create("Analisis I", Integer.valueOf(2012), "Esther Milan", Boolean.valueOf(false), notas2, _ubicacion_1);
    Nota _nota_4 = new Nota();
    Nota _crear_4 = _nota_4.crear("20/04/2014", "tp", true);
    notas3.add(_crear_4);
    Nota _nota_5 = new Nota();
    Nota _crear_5 = _nota_5.crear("07/08/2014", "Parcial 2", false);
    notas3.add(_crear_5);
    UbicacionMateria _ubicacion_2 = this.getUbicacion("Anual", "1er Nivel");
    this.create("Algoritmos", Integer.valueOf(2012), "Patricia Mayor", Boolean.valueOf(true), notas3, _ubicacion_2);
    UbicacionMateria _ubicacion_3 = this.getUbicacion("Anual", "2do Nivel");
    this.create("Analisis de Sistemas", Integer.valueOf(2013), "Ines Casanovas", Boolean.valueOf(true), notas, _ubicacion_3);
    UbicacionMateria _ubicacion_4 = this.getUbicacion("2do Cuatrimestre", "3er Nivel");
    this.create("Sistemas Operativos", Integer.valueOf(2014), "Scarfiello", Boolean.valueOf(false), notas, _ubicacion_4);
  }
  
  public void create(final String pnombre, final Integer anio, final String nombreProfesor, final Boolean pfinal, final ArrayList<Nota> notasss, final UbicacionMateria ubicacion) {
    Materia materia = new Materia();
    materia.setNombre(pnombre);
    materia.setFinalAprobado(pfinal);
    materia.setAnioCursada(anio);
    materia.setProfesor(nombreProfesor);
    materia.setNotas(notasss);
    materia.setUbicacion(ubicacion);
    this.create(materia);
  }
  
  public UbicacionMateria getUbicacion(final String modalidad, final String nivel) {
    ApplicationContext _instance = ApplicationContext.getInstance();
    Object _singleton = _instance.<Object>getSingleton(UbicacionMateria.class);
    return ((HomeUbicacionMaterias) _singleton).get(modalidad, nivel);
  }
  
  public Predicate<Materia> getCriterio(final Materia example) {
    return null;
  }
  
  public Class<Materia> getEntityType() {
    return Materia.class;
  }
  
  public Materia createExample() {
    return new Materia();
  }
  
  public List<Materia> show() {
    return this.allInstances();
  }
}
