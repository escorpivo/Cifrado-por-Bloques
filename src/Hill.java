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
		
		ArrayList<Integer> codNumérica = new ArrayList<>();
		for(int i = 0; i < frase.length() ; i++) {
			
			codNumérica.add(utilidades.asignarNumerosAlf(alfabeto, frase.charAt(i)));
		}
		
		
		int paddingTotal = (6-(codNumérica.size() % matrizC[0].length));
		
		//solo le hago paddin si hay algun bloque suelto, no tengo que rellenar uno vacio
		if(paddingTotal < 6) {
			
			System.out.println("El Padding es: " +  paddingTotal);
			
			for(int aux = 0 ; aux < paddingTotal; aux++) {
				
				codNumérica.add(utilidades.generarAleatorios(alfabeto.length()));	
			}
		}
		
		//añadimos un último bloque con la longitud del mensaje y relleno de 0´s
		
		//imprimo la codificación numérica, con el padding y tal
		for(int i = 0 ; i < codNumérica.size() ; i++) {
			
			System.out.print(codNumérica.get(i) + " ");
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
			codNumérica.add(arrayCocientes[i]);
		}
		
		System.out.println("\nEl array final es: ");
		for(int i = 0 ; i < codNumérica.size(); i++) {
			
			System.out.print(codNumérica.get(i) +  " ");
		}

	}
		
	
	public void descifrar(String alfabeto) {
		
		System.out.println("Descifrado Hill");

		
	}
}
