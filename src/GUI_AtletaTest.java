import static org.junit.Assert.*;

import org.junit.Test;

public class GUI_AtletaTest {

	@Test
	public void testAptitud1() {
		String resultado = GUI_Atleta.calificarAptitud("Masculino", 20, 1.80, 60);
		String esperado = "apto"; // Valor correcto apto
		assertEquals(esperado, resultado, "apto");
	}
	
	@Test
	public void testAptitud2() {
		String resultado = GUI_Atleta.calificarAptitud("Femenino", 18, 1.75, 55);
		String esperado = "apto"; // Valor correcto apto
		assertEquals(esperado, resultado, "apto");
	}
	
	@Test
	public void testAptitud3() {
		String resultado = GUI_Atleta.calificarAptitud("Masculino", 15, 1.50, 100);
		String esperado = "apto"; // Valor correcto no apto
		assertEquals(esperado, resultado, "apto");
	}
	
	@Test
	public void testAptitud4() {
		String resultado = GUI_Atleta.calificarAptitud("Femenino", 15, 1.50, 100);
		String esperado = "apto"; // Valor correcto no apto
		assertEquals(esperado, resultado, "apto");
	}

}
