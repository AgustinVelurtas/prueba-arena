package test;

import domain.Materia;
import domain.Nota;
import domain.SeguidorCarrera;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TestNotas {
  @Test
  public void agregarMateriaTest() {
    SeguidorCarrera seguidor = new SeguidorCarrera();
    Materia materia = new Materia();
    materia.setNombre("disenio");
    seguidor.agregarMateria(materia);
    List<Materia> _materias = seguidor.getMaterias();
    int _size = _materias.size();
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void agregarNotaTest() {
    Materia materia = new Materia();
    materia.setNombre("disenio");
    Nota nota = new Nota();
    nota.setFecha("17/8/2014");
    nota.setDescripcion("Primer Parcial");
    nota.setAprobado(Boolean.valueOf(true));
    materia.agregarNota(nota);
    ArrayList<Nota> _notas = materia.getNotas();
    int _size = _notas.size();
    Assert.assertEquals(1, _size);
  }
}
