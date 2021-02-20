package programa;

import java.util.Scanner;

import entidade.CPF;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CPF c = new CPF("06665175332");
		
		if ( c.validar() ) {
			System.out.println("CPF valido");
			
			for (int i = 0; i < c.dividir().length; i++) {
				System.out.print(c.dividir()[i]);
			}
			
			System.out.println(" Pertece a região de " + c.estado());
		}else {
			System.out.println("CPF falso");
		}
		
		sc.close();
	}

}
