import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Elige una opcion \n 1 Cifrado de Hill.\n 2 Cifrado afín.");
		
		Scanner teclado = new Scanner(System.in);
		int eleccion = teclado.nextInt();
		
		
		if(eleccion == 1) {
			
			Hill hill = new Hill();
			hill.main();
			
		}else if (eleccion == 2) {
			
			Afin afin = new Afin();
			afin.main();
			
		}else {
			
			System.out.println("Eleccion incorrecta.");
		}
		
	}
}
