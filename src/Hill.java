import java.util.ArrayList;
import java.util.Scanner;
public class Hill {

	//declaro metodos globales con utilidades varias para poder usar
	Utilidades utilidades = new Utilidades();
	private int k;
	
	public void cifrar(String alfabeto) {
		
		System.out.println("Cifrado Hill");
		System.out.println("La longitud del alfabeto es: " + alfabeto.length());
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dime la frase a encriptar");
		String frase = entrada.nextLine();
		
		int[][] matrizC = utilidades.generarMatriz();
		
        for (int i = 0; i < matrizC.length; i++) {
            for (int j = 0; j < matrizC[i].length; j++) {
            	
                System.out.print(matrizC[i][j] + " ");
                
            }
            System.out.println();
        }
		
        k = matrizC.length;
        
		ArrayList<Integer> bloques = new ArrayList<>();
		for(int i = 0; i < frase.length() ; i++) {
			
			bloques.add(utilidades.asignarNumerosAlf(alfabeto, frase.charAt(i)));
		}
		
		for(int i = 0; i < bloques.size(); i++) {
			System.out.print(bloques.get(i) + " ");
		}
		
		
		int paddingTotal = (k-(bloques.size() % matrizC[0].length));
		
		//solo le hago paddin si hay algun bloque suelto, no tengo que rellenar uno vacio
		if(paddingTotal < k) {
			
			System.out.println("El Padding es: " +  paddingTotal);
			
			for(int aux = 0 ; aux < paddingTotal; aux++) {
				
				bloques.add(utilidades.generarAleatorios(alfabeto.length()));	
			}
		}
		
		//añadimos un último bloque con la longitud del mensaje y relleno de 0´s
		
		//imprimo la codificación numérica, con el padding y tal
		System.out.println();
		for(int i = 0 ; i < bloques.size() ; i++) {
			
			System.out.print(bloques.get(i) + " ");
		}
		
		
		//convertimos el mensaje cifrado a una matriz de longitud K
		int resto = frase.length()%alfabeto.length();
		int cociente= frase.length()/alfabeto.length();
		System.out.println("\nCociente es: " +  cociente + " Y resto es: " + resto);
		
		String coci = Integer.toString(cociente);
		//asigno los valores a la array, en funcion del tamaño de los cocientes
		int[] arrayCocientes = new int[k];
		int acumulador = 1;
		for(int i = k-2 ; i > 0 ; i--) {
			
			if(acumulador <= coci.length()) {
				
				int cosa = coci.charAt(coci.length()-acumulador);
				System.out.println("Cosa es: " + Character.getNumericValue(cosa));
				arrayCocientes[i] = Character.getNumericValue(cosa);
			}else {
				arrayCocientes[i] = 0;
			}
			acumulador+=1;
		}
		
		arrayCocientes[k-1] = resto;
		
		
		System.out.println("El array de cocientes y tal es: ");
		for(int i = 0 ; i < arrayCocientes.length ; i++) {
			
			System.out.print( arrayCocientes[i] + "|");
			bloques.add(arrayCocientes[i]);
		}
		
		System.out.println("\nEl array final es: ");
		for(int i = 0 ; i < bloques.size(); i++) {
			
			System.out.print(bloques.get(i) +  " ");
		}
		
		int numRows = bloques.size() / k;
		int[][] matrizBloques = new int[numRows][k];

		// Rellenar la matriz con valores de 'bloques'
		for (int i = 0; i < bloques.size(); i++) {
		    int row = i / k;
		    int col = i % k;
		    matrizBloques[row][col] = bloques.get(i);
		}
		
		//cifro el array enterinni
		int[][] resultado = new int[numRows][k];
		for (int i = 0; i < numRows; i++) {
		    for (int j = 0; j < k; j++) {
		        int sum = 0;
		        for (int m = 0; m < k; m++) {
		            sum += matrizBloques[i][m] * matrizC[m][j];
		        }
		        resultado[i][j] = sum % alfabeto.length(); // Aplicar modulo por el tamaño del alfabeto
		    }
		}

/*		System.out.println("\nEL RESULTADO DE LA MULTIPLICACIÓN ES = ");
		for(int i = 0; i < resultado.length; i++) {
			for(int j = 0; j < resultado[0].length; j++) {
				System.out.print(resultado[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		//Cojo cada columna de la matriz resultado y lo convierto en vector
		ArrayList<Integer> posicionesFinales = new ArrayList<Integer>();
		
		for(int i = 0; i < resultado.length; i++) {
			for(int j = 0; j < resultado[0].length; j++) {
				posicionesFinales.add(resultado[i][j]);
			}
		}
	
		System.out.println("LAS POSICIONES FINALES SON = ");
		for(int i = 0; i < posicionesFinales.size(); i++) {
			System.out.print(posicionesFinales.get(i) + " ");
		}
		/*
		System.out.print("\nEl vector final con modulo " + alfabeto.length() +" es: [ ");
		for(int x = 0 ; x < posicionesFinales.size(); x++) {
			
			System.out.print(posicionesFinales.get(x) + " ");
		}
		
		System.out.println(" ]");
		*/
		
		//PASAMOS EL CIFRADO A LETRAS DEL ALFABETO PARA DEJAR EL MENSAJE CIFRADO
		StringBuilder mensaje = new StringBuilder();
		for(int i = 0; i < posicionesFinales.size(); i++) {
			for(int j = 0; j < alfabeto.length(); j++) {
				if(posicionesFinales.get(i) == j) {
					mensaje.append(alfabeto.charAt(j));
				}
			}
		}
		
		System.out.println("Finalmente el mensaje cifrado es: " + mensaje);
		
	}
		
	
	public void descifrar(String alfabeto) {
		
		System.out.println("Descifrado Hill");
		Scanner teclado = new Scanner(System.in);
		System.out.println("Mensaje para descifrar plis: ");
		String texto = teclado.nextLine();
		
		System.out.println(alfabeto.length());
		
		ArrayList<Integer> mensaje = new ArrayList<Integer>();
		//int[]mensaje = new int[texto.length()];
		
		for(int i = 0 ; i < texto.length() ; i++) {
			mensaje.add(utilidades.asignarNumerosAlf(alfabeto, texto.charAt(i)));
		}
		
		int[][] matrizCInv= utilidades.generarInversa();
		
		
		k = matrizCInv.length;
		
		//Como vamos a tener un bloque extra lo quitamos
		ArrayList<Integer> bloques = new ArrayList<Integer>();
		
		for(int i = 0; i < mensaje.size()-k; i++) {
			bloques.add(mensaje.get(i));
		}
		
		System.out.println("LAS POSICIONES DEL MENSAJE CODIFICADO SON = ");
		for(int i = 0; i < bloques.size(); i++) {
			System.out.print(bloques.get(i) + " ");
		}
		
		
		int numRows = bloques.size() / k;
		int[][] matrizBloques = new int[numRows][k];

		// Rellenar la matriz con valores de 'bloques'
		for (int i = 0; i < bloques.size(); i++) {
		    int row = i / k;
		    int col = i % k;
		    matrizBloques[row][col] = bloques.get(i);
		}
		
		System.out.println("LA MATRIZ QUE SE VA A MULTIPLICAR POR C");
		for(int i = 0; i < matrizBloques.length; i++) {
			for(int j= 0; j < matrizBloques[0].length; j++) {
				System.out.print(matrizBloques[i][j] + " ");
			}
			System.out.println();
		}
		
		//cifro el array enterinni
		int[][] resultado = new int[numRows][k];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < k; j++) {
				int sum = 0;
				for (int m = 0; m < k; m++) {
					sum += matrizBloques[i][m] * matrizCInv[m][j];
				}
				    resultado[i][j] = Math.floorMod(sum, alfabeto.length()); // Aplicar modulo por el tamaño del alfabeto
			}
		}
		
		//Cojo cada columna de la matriz resultado y lo convierto en vector
		ArrayList<Integer> posicionesFinales = new ArrayList<Integer>();
				
		for(int i = 0; i < resultado.length; i++) {
			for(int j = 0; j < resultado[0].length; j++) {
				posicionesFinales.add(resultado[i][j]);
			}
		}

		
		System.out.print("\nEl vector final con modulo " + alfabeto.length() +" es: [ ");
		for(int x = 0 ; x < posicionesFinales.size(); x++) {
			
			System.out.print(posicionesFinales.get(x) + " ");
		}
		
		System.out.println(" ]");
		
		
		//PASAMOS EL CIFRADO A LETRAS DEL ALFABETO PARA DEJAR EL MENSAJE CIFRADO
		StringBuilder mensajeFinal = new StringBuilder();
		for(int i = 0; i < posicionesFinales.size(); i++) {
			for(int j = 0; j < alfabeto.length(); j++) {
				if(posicionesFinales.get(i) == j) {
					mensajeFinal.append(alfabeto.charAt(j));
				}
			}
		}
		
		System.out.println("Finalmente el mensaje cifrado es: " + mensajeFinal);


		
	}
}
