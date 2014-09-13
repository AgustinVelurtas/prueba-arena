package Runnable;

import Home.HomeMaterias;
import Home.HomeUbicacionMaterias;
import domain.Materia;
import domain.UbicacionMateria;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.utils.ApplicationContext;
import ui.MateriaWindow;

@SuppressWarnings("all")
public class App extends Application {
  protected Window<?> createMainWindow() {
    ApplicationContext _instance = ApplicationContext.getInstance();
    HomeUbicacionMaterias _homeUbicacionMaterias = new HomeUbicacionMaterias();
    _instance.<HomeUbicacionMaterias>configureSingleton(UbicacionMateria.class, _homeUbicacionMaterias);
    ApplicationContext _instance_1 = ApplicationContext.getInstance();
    HomeMaterias _homeMaterias = new HomeMaterias();
    _instance_1.<HomeMaterias>configureSingleton(Materia.class, _homeMaterias);
    return new MateriaWindow(this);
  }
  
  public static void main(final String[] args) {
    App _app = new App();
    _app.start();
  }
}
