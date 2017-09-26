package Modelo;

public class ValidarDatos {

	private String[] parametros;
	private char[] digitos;

	  /**
    *
    * Metodo encargado de procesar la entrada que contiene el size del segmento
    * de los digitos y los digitos a imprimir
    *
    * @param comando Entrada que contiene el size del segmento de los digito
    * y el numero a imprimir
    * @param espacioDig Espacio Entre digitos
    */  
	 
	
   public String procesar(String comando, int iteracion) {
      
	   if (!comando.contains(",")) {		
		return "La entrada "+(iteracion+1)+" no posee coma";
	   }
	   
	   parametros=comando.split(",");
	   
	   if (parametros.length>2 || parametros.length<2) {
		   return "La entrada "+(iteracion+1)+" no posee la cantidad de valores correctos";
	   }	   
	   if (!isNumeric(parametros[0])) {
		   return "El caracter "+parametros[0]+" del parametro numero "+(iteracion+1)+" no es un numero";
	   }
	   if (!isNumeric(parametros[1])) {
		   return "El caracter "+parametros[1]+" del parametro numero "+(iteracion+1)+" no es un numero";
	   }  
	   if (Integer.parseInt(parametros[0])<1 || Integer.parseInt(parametros[0])>10) {
		   return "El caracter "+parametros[0]+" de parametro numero "+(iteracion+1)+" no esta entre 1 y 10";
	   }
	 	  	 
	   return "OK";	
   }

   /**
    *
    * Metodo encargado de validar si una cadena es numerica
    *
    * @param cadena Cadena
    */  
   public boolean isNumeric(String cadena) {
       try {
           Integer.parseInt(cadena);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
   
   /**
    * Metodo diseñado para verificar si el espacio se encuentra en el rango adecuado
    * @param espacio
    * @return
    */
   public boolean validarEspacio(int espacio){	   
	   if (espacio>0 && espacio<5) {
		return true;
	   }
	   return false;	   
   }
      
}
