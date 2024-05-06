import java.util.Scanner;
import java.util.Arrays;

public class Utilidades {
	
	
	public int generarAleatorios(int modulo) {
		
		int rango = (modulo - 0 )+1;
		int numero = ((int) (Math.random()*rango ));
		
		return numero%modulo;
	}
	
	public int[][] generarMatriz(){
		/*	
		String matrizString = "	[35, 53, 12],\r\n"
        		+ "        		[12, 21, 5],\r\n"
        		+ "        		[2, 4, 1]";
        */
		
		//DATOS MARTES
		/*
		//HILL
        String matrizString = "	[63, 57, 3, 29, 46, 35],\r\n"
        		+ "        		[30, 52, 21, 80, 44, 12],\r\n"
        		+ "        		[37, 23, 53, 60, 16, 56],\r\n"
        		+ "       		[77, 11, 82, 74, 46, 53],\r\n"
        		+ "        		[33, 56, 81, 72, 37, 37],\r\n"
        		+ "        		[12, 11, 68, 55, 22, 19]";
        */
		//AFIN
		
		String matrizString = "[50,    25, 0,  81, 4],\r\n"
				+ "        	   [10,    39, 19, 67, 51],\r\n"
				+ "        	   [34,    49, 63, 9,  56],\r\n"
				+ "            [31,    21, 33, 55, 6],\r\n"
				+ "            [82,    69, 34, 48, 1]";
		
		//DATOS LUNES
		/*
		//HILL
		String matrizString = "	[50,	25,	0,	81,	4],\r\n"
        		+ "        		[10,	39,	19,	67,	51],\r\n"
        		+ "        		[34,	49,	63,	9,	56],\r\n"
        		+ "       		[31,	21,	33,	55,	6],\r\n"
        		+ "        		[82,	69,	34,	48,	1]";
		*/
		//AFIN
		/*
		String matrizString = "[63,    57, 3,  29, 46, 35],\r\n"
				+ "            [30,    52, 21, 80, 44, 12],\r\n"
				+ "        	   [37,    23, 53, 60, 16, 56],\r\n"
				+ "            [77,    11, 82, 74, 46, 53],\r\n"
				+ "            [33,    56, 81, 72, 37, 37],\r\n"
				+ "            [12,    11, 68, 55, 22, 19]";
		*/
		
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
		/*
		String matrizInversa = "[1, 22, 13],\r\n"
        		+ "        		[25, 11, 23],\r\n"
        		+ "        		[6, 20, 18]";
		*/
		
		//DATOS MARTES
		/*
		//HILL
        String matrizInversa = "[21, 83, 34, 78, 20, 65],\r\n"
        		+ "        		[67, 74, 45, 78, 64, 27],\r\n"
        		+ "        		[66, 67, 40, 28, 24, 62],\r\n"
        		+ "       		[81, 55, 76, 31, 20, 6],\r\n"
        		+ "        		[31, 33, 29, 41, 59, 45],\r\n"
        		+ "        		[78, 29, 73, 13, 30, 72]";
        */
		//AFIN
		
		String matrizInversa = "[80,	76,	37,	53,	50],\r\n"
				+ "				[44,	45,	23,	54,	33],\r\n"
				+ "				[81,	76,	27,	68,	12],\r\n"
				+ "				[61,	59,	47,	44,	67],\r\n"
				+ "				[10,	31,	17,	20,	80]";
		
		//DATOS LUNES
		/*
		//HILL
		String matrizInversa = "[80,	76,	37,	53,	50],\r\n"
        		+ "        		[44,	45,	23,	54,	33],\r\n"
        		+ "        		[81,	76,	27,	68,	12],\r\n"
        		+ "       		[61,	59,	47,	44,	67],\r\n"
        		+ "        		[10,	31,	17,	20,	80]";
		*/
		//AFIN
		/*
		String matrizInversa = "[21,	83,	34,	78,	20,	65],\r\n"
				+ "				[67,	74,	45,	78,	64,	27],\r\n"
				+ "				[66,	67,	40,	28,	24,	62],\r\n"
				+ "				[81,	55,	76,	31,	20,	6],\r\n"
				+ "				[31,	33,	29,	41,	59,	45],\r\n"
				+ "				[78,	29,	73,	13,	30,	72]";
		*/
				
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
	
	public int[] generarVectorX() {
		//String x = "[24, 11,  34, 70, 78]\r\n";
		
		String x = "[24,    11, 1,  34, 70, 78]\r\n";
		
		String filaSinEspacios = x.replaceAll("\\s|\\[|\\]|\\\r\n", "");

        String[] elementos = filaSinEspacios.split(",");
        
        int[] vectorX = new int[elementos.length];
       
        for (int j = 0; j < elementos.length; j++) {
            	
            vectorX[j] = Integer.parseInt(elementos[j]);
        }
		
		return vectorX;
	}

}
