package Controlador;

import java.util.ArrayList;

import Modelo.GenerarMatriz;
import Modelo.ValidarDatos;
import vista.App;

public class Controlador {

	private ValidarDatos validarDatos;
	private GenerarMatriz generarMatriz;
	private final String VALIDAR_OK="OK";
	private App app;
	private String[][] matriz;
	private String[] parametro;
	
	public Controlador() {
		
		validarDatos = new ValidarDatos();
		generarMatriz = new GenerarMatriz();
		app = new App(this);		
	}
	
	/**
	 * Recibe como parametro el espacio que se debe usar, valida si este es un valor numerico y si se encuentra en el rango adecuado
	 * de no ser asi mostrara un mensaje de error
	 * @param cadena
	 */
	public void verificarEspacios(String cadena){
		if (!validarDatos.isNumeric(cadena)) {
			actualizarError("El espacio digitado no es un valor numerico");
		}else if (!validarDatos.validarEspacio(Integer.parseInt(cadena))) {
			actualizarError("El espacio digitado no se encuentra en el rango de 1 a 5");
		}		
	}
	/**
	 * Recibe como parametro los valores que se quieren imprimir y hace su respectiva validación, de estar incorrecta nos mostrara un error 
	 * @param cadena
	 */
	public void procesarInformación(ArrayList<String> cadena){		
		for (int i = 0; i < cadena.size(); i++) {
			String error = validarDatos.procesar(cadena.get(i), i);
			if (!error.equals(VALIDAR_OK)) {
				actualizarError(error);
			}			
		}
	}
	
	/**
	 * Este metodo recibe como parametro el espacio, valores numericos y tamaño, con estos valores se creara y se generara la matriz.
	 * @param espacio
	 * @param parametros
	 */
	public void generarMatriz(int espacio, ArrayList<String> parametros){		
		for (int i = 0; i < parametros.size(); i++) {
			parametro = parametros.get(i).split(",");
			generarMatriz.crearMatriz(Integer.parseInt(parametro[0]), parametro[1], espacio);
			matriz = generarMatriz.generarMatrizNumeros(parametro[1], espacio);
			actualizarMatrizConsola(matriz);
		}
	}
	/**
	 * Recibe como parametro la matriz con los números, los envia a la vista para ser impresos
	 * @param matriz
	 */
	public void actualizarMatrizConsola(String[][] matriz){
		app.actualizarMatriz(matriz);
	}
		/**
		 * Recibe como parametro un error el cual sera enviado a la vista e impreso respectivamente
		 * @param mensaje
		 */
	public void actualizarError(String mensaje){		
		app.actualizarError(mensaje);
	}
	
}
