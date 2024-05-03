import java.util.Scanner;
import java.util.Arrays;

public class Utilidades {
	
	
	public int generarAleatorios(int modulo) {
		
		int rango = (modulo - 0 )+1;
		int numero = ((int) (Math.random()*rango ));
		
		return numero%modulo;
	}
	
	public int[][] generarMatriz(){
				

        String matrizString = "	[63, 57, 3, 29, 46, 35],\r\n"
        		+ "        		[30, 52, 21, 80, 44, 12],\r\n"
        		+ "        		[37, 23, 53, 60, 16, 56],\r\n"
        		+ "       		[77, 11, 82, 74, 46, 53],\r\n"
        		+ "        		[33, 56, 81, 72, 37, 37],\r\n"
        		+ "        		[12, 11, 68, 55, 22, 19]";
        

        String[] filas = matrizString.split("\r\n");

        int[][] matrizNumerica = new int[filas.length][];

        for (int i = 0; i < filas.length; i++) {

            String filaSinEspacios = filas[i].replaceAll("\\s|\\[|\\]", "");

            String[] elementos = filaSinEspacios.split(",");

            matrizNumerica[i] = new int[elementos.length];

            for (int j = 0; j < elementos.length; j++) {
            	
                matrizNumerica[i][j] = Integer.parseInt(elementos[j]);
            }
        }
		
		return matrizNumerica;
	}
	
	public int[][] generarInversa(){
		
        String matrizInversa = "	[21, 83, 34, 78, 20, 65],\r\n"
        		+ "        		[67, 74, 45, 78, 64, 27],\r\n"
        		+ "        		[66, 67, 40, 28, 24, 62],\r\n"
        		+ "       		[81, 55, 76, 31, 20, 6],\r\n"
        		+ "        		[31, 33, 29, 41, 59, 45],\r\n"
        		+ "        		[78, 29, 73, 13, 30, 72]";
        
        String[] filas = matrizInversa.split("\r\n");

        int[][] matrizNumerica = new int[filas.length][];

        for (int i = 0; i < filas.length; i++) {

            String filaSinEspacios = filas[i].replaceAll("\\s|\\[|\\]", "");

            String[] elementos = filaSinEspacios.split(",");

            matrizNumerica[i] = new int[elementos.length];

            for (int j = 0; j < elementos.length; j++) {
            	
                matrizNumerica[i][j] = Integer.parseInt(elementos[j]);
            }
        }
		
		return matrizNumerica;
	}

	public int asignarNumerosAlf(String alfabeto, char letra) {
		
		return alfabeto.indexOf(letra);
		
	}

}
