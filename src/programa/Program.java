package programa;

import java.util.Scanner;

import entidade.CPF;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CPF c = new CPF("");
		
		c.autoComplete();
		
		valida(c);
		
	sc.close();
	}
	
	private static void valida(CPF c) {
		if ( c.validar() ) {
			System.out.println("CPF valido");
			System.out.println("Pertece a região de " + c.estado());
			System.out.println("Dig ver: " + c.digVer());
		}else {
			System.out.println("CPF falso");
			System.out.println(c.getCPF());
			
			System.out.print("Esperado encontrar no Dig Ver: "+ c.digVer());
		}
	}

}
