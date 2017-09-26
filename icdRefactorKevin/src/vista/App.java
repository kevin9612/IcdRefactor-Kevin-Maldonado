package vista;


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Controlador.Controlador;

public class App {
	
	private static Controlador ctrl = new Controlador();
	private static String espacio, entrada;
	private static Scanner lector;
	private static ArrayList<String> entradas = new ArrayList<>();
	private static final String CADENA_FINAL = "0,0";
	private static int space;
	
	public App(Controlador ctrl) {
		
		entrada="";
		this.ctrl=ctrl;
		entradas = new ArrayList<>();
	}
	
	public static void main(String[] args) {
			
		iniciar();
	}
	
	public static void iniciar(){
		
		lector = new Scanner(System.in);
		System.out.print("Espacio entre Digitos (0 a 5): ");
		espacio = lector.next();
       
        ctrl.verificarEspacios(espacio);
        space = Integer.parseInt(espacio);
        
        while (!entrada.equals(CADENA_FINAL)) {
        	
        	System.out.print("Entradas: ");
    		entrada = lector.next();    		
    		if (!entrada.equals(CADENA_FINAL)) {
    			entradas.add(entrada);
			}    		
		}        	
        	ctrl.procesarInformación(entradas);
        	ctrl.generarMatriz(space, entradas);
		
	}
	
	/**
	 * Metodo que se encarga de actualizar los errores que se presenten y mostrarlos en pantalla, ademas de permitir reinicar la aplicación
	 * @param error
	 */
	public static void actualizarError(String error){
		
		int response=JOptionPane.showConfirmDialog(null, error+", desea volver a ejecutar el programa");
		if (response == JOptionPane.YES_OPTION) {
			entrada="";
			entradas.clear();
			iniciar();
		}else{
			System.exit(0);
		}
		System.exit(0);
	}
	/**
	 * Este metodo recibe como parametros la matriz con los números que debe imprimor
	 * @param matriz
	 */
	public static void actualizarMatriz(String[][] matriz){
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
