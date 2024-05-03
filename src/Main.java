import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Elige una opcion:\n\t1 Cifrado de Hill.\n\t2 Descifrado de Hill.\n\t3 Cifrado Afín.\n\t4 Descifrado Afín.");
		
		Scanner teclado = new Scanner(System.in);
		int eleccion = teclado.nextInt();
		Hill hill = new Hill();
		Afin afin = new Afin();
		
		//declaro el alfabeto que voy a usar
		String alfabeto = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:;-()¿?";
		
		if(eleccion == 1) {
			
			hill.cifrar(alfabeto);
			
		}else if (eleccion == 2) {
			
			hill.descifrar(alfabeto);
			
		}else if(eleccion == 3) {
			
			afin.cifrar(alfabeto);
			
		}else if(eleccion == 4) {
			
			afin.descifrar(alfabeto);

						
		}else {
			
			System.out.println("Eleccion incorrecta.");

		}
		
	}
}
