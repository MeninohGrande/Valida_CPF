package programa;

import java.util.Scanner;

import entidade.CPF;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Entre com o CPF a ser verificado: ");
		
		
	CPF cpf = new CPF();
	
	cpf.validar("06665175332");

		
		sc.close();
	}

}
