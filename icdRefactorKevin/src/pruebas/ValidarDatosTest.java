package pruebas;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.ValidarDatos;

public class ValidarDatosTest {	
	
	private static ValidarDatos validarDatos;
	
	public ValidarDatosTest() {
		validarDatos = new ValidarDatos();
	}
	
	@Test
	public void testValidarNumero(){			
		assertTrue(validarDatos.isNumeric("1"));		
	}
	
	@Test
	public void testValidarNumeroFail(){				
		assertTrue(validarDatos.isNumeric("a") == false);		
	}
	
	@Test
	public void testValidarEspacio(){			
		assertTrue(validarDatos.validarEspacio(4));
	}
	
	@Test
	public void testValidarEspacioFail(){			
		assertTrue(validarDatos.validarEspacio(8)==false);		
	}
	
	@Test
	public void testProcesarOk(){
			
		assertTrue(validarDatos.procesar("1,2345", 1).equals("OK"));		
	}
	
	@Test
	public void testProcesarErrorComa(){
		
		assertTrue(validarDatos.procesar("12345", 0).equals("La entrada 1 no posee coma"));	
	}
	
	@Test
	public void testProcesarErrorNumero(){		
		assertTrue(validarDatos.procesar("a,12345", 0).equals("El caracter a del parametro numero 1 no es un numero"));	
	}
	
	@Test
	public void testProcesarErrorNumero2(){
		
		assertTrue(validarDatos.procesar("7,12a45", 0).equals("El caracter 12a45 del parametro numero 1 no es un numero"));	
	}
	
	@Test
	public void testProcesarErrorRango(){
		
		assertTrue(validarDatos.procesar("11,12345", 0).equals("El caracter 11 de parametro numero 1 no esta entre 1 y 10"));	
	}
	
	
}


