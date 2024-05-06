import java.util.ArrayList;
import java.util.Scanner;

public class Afin {
	Utilidades utilidades = new Utilidades();
	private int k;
	
	public void cifrar(String alfabeto) {
		
		System.out.println("Afin");
		
		System.out.println("EL VECTOR X ES = ");
		int[] x = utilidades.generarVectorX();
		for(int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		
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
		
		
		//cada k posiciones del vector bloques restamos por el vectorX y lo almaceno en el array bloques2
		ArrayList<Integer> bloques2 = new ArrayList<Integer>();
		int[] vectorX = utilidades.generarVectorX();
		for(int i = 0; i < bloques.size(); ) {
			for(int j = 0; j < vectorX.length; j++) {
				bloques2.add(Math.floorMod(bloques.get(i) - vectorX[j], alfabeto.length()));
				i += 1;
			}
		}
		
		System.out.println("LOS BLOQUES RESULTANTES DE LA RESTA SON = ");
		for(int i = 0; i < bloques2.size(); i++) {
			System.out.print(bloques2.get(i) + " ");
		}
		
		int numRows = bloques2.size() / k;
		int[][] matrizBloques = new int[numRows][k];

		// Rellenar la matriz con valores de 'bloques'
		for (int i = 0; i < bloques2.size(); i++) {
		    int row = i / k;
		    int col = i % k;
		    matrizBloques[row][col] = bloques2.get(i);
		}
		
		System.out.println("\nLA MATRIZ QUE SE VA A MULTIPLICAR POR C");
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
