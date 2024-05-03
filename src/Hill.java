import java.util.ArrayList;
import java.util.Scanner;
public class Hill {

	//declaro metodos globales con utilidades varias para poder usar
	Utilidades utilidades = new Utilidades();

	public void cifrar(String alfabeto) {
		
		System.out.println("Cifrado Hill");
		System.out.println("La longitud del alfabeto es: " + alfabeto.length());
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dime la frase a encriptar");
		String frase = entrada.nextLine();
		
		int[][] matrizC = utilidades.generarMatriz();
		
       /* for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[i].length; j++) {
            	
                System.out.print(matrizC[i][j] + " ");
                
            }
            System.out.println();
        }*/
		
		ArrayList<Integer> codNumerica = new ArrayList<>();
		for(int i = 0; i < frase.length() ; i++) {
			
			codNumerica.add(utilidades.asignarNumerosAlf(alfabeto, frase.charAt(i)));
		}
		
		
		int paddingTotal = (6-(codNumerica.size() % matrizC[0].length));
		
		//solo le hago paddin si hay algun bloque suelto, no tengo que rellenar uno vacio
		if(paddingTotal < 6) {
			
			System.out.println("El Padding es: " +  paddingTotal);
			
			for(int aux = 0 ; aux < paddingTotal; aux++) {
				
				codNumerica.add(utilidades.generarAleatorios(alfabeto.length()));	
			}
		}
		
		//añadimos un último bloque con la longitud del mensaje y relleno de 0´s
		
		//imprimo la codificación numérica, con el padding y tal
		for(int i = 0 ; i < codNumerica.size() ; i++) {
			
			System.out.print(codNumerica.get(i) + " ");
		}
		
		
		//convertimos el mensaje cifrado a una matriz de longitud K
		int resto = frase.length()%alfabeto.length();
		int cociente= frase.length()/alfabeto.length();
		System.out.println("\nCociente es: " +  cociente + " Y resto es: " + resto);
		
		//asigno los valores a la array, en funcion del tamaño de los cocientes
		int[] arrayCocientes = new int[6];
		
		if(cociente > 10000) {
			
			arrayCocientes[0] = (cociente / 10000);
			cociente = cociente - (arrayCocientes[0] * 10000);
			
		}else {
			
			arrayCocientes[0] = 0;
		}
				
		if(cociente > 1000) {
			
			arrayCocientes[1] = (cociente / 1000);
			cociente = cociente - (arrayCocientes[1] * 1000);
			
		}else {
			
			arrayCocientes[1] = 0;
		}
	
		if(cociente > 100) {
			
			arrayCocientes[2] = (cociente / 100);
			cociente = cociente - (arrayCocientes[2] * 100);
			
		}else {
			
			arrayCocientes[2] = 0;
		}
				
		if(cociente > 10) {
			
			arrayCocientes[3] = (cociente / 10);
			cociente = cociente - (arrayCocientes[3] * 10);
			
		}else {
			
			arrayCocientes[3] = 0;
		}
				
		if(cociente > 0) {
			
			arrayCocientes[4] = (cociente);
			cociente -= cociente;
		}else {
			
			arrayCocientes[4] = 0;
		}
		
		arrayCocientes[5] = resto;
		
		
		System.out.println("El array de cocientes y tal es: ");
		for(int i = 0 ; i < arrayCocientes.length ; i++) {
			
			System.out.print( arrayCocientes[i]);
			codNumerica.add(arrayCocientes[i]);
		}
		
		System.out.println("\nEl array final es: ");
		for(int i = 0 ; i < codNumerica.size(); i++) {
			
			System.out.print(codNumerica.get(i) +  " ");
		}
		
		//cifro el array enterinni
		ArrayList<Integer> resultado = new ArrayList<>();
		//con este tercer bucle, lo que hago es que se vaya de 6 en 6 para hacer las multiplicaciones pertinenetes
		for(int x = 0 ; x < codNumerica.size() ; x += matrizC[0].length) {	
			
			for(int i = 0 ; i < matrizC[0].length; i++) {
				int suma = 0;
				for(int j = 0 ; j <  matrizC.length ; j++) {
						//con el x lo que hago es ir en cada iteracion al bloque k de cada array
					suma += matrizC[i][j] * codNumerica.get((x+i));
				}
				
				resultado.add(suma%alfabeto.length());
			}
		}

		
		System.out.print("\nEl vector final con modulo " + alfabeto.length() +" es: [ ");
		for(int x = 0 ; x < resultado.size(); x++) {
			
			System.out.print(resultado.get(x) + " ");
		}
		
		System.out.println(" ]");
		
		
		//PASAMOS EL CIFRADO A LETRAS DEL ALFABETO PARA DEJAR EL MENSAJE CIFRADO
		StringBuilder mensaje = new StringBuilder();
		for(int i = 0 ; i < resultado.size() ; i++) {
			mensaje.append(alfabeto.charAt(resultado.get(i)));
		}
		
		System.out.println("Finalmente el mensaje cifrado es: " + mensaje);
	}
		
	
	public void descifrar(String alfabeto) {
		
		System.out.println("Descifrado Hill");

		
	}
}
