package programa;

import java.util.InputMismatchException;
import java.util.Scanner;
import entidade.CPF;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CPF c = null;
		
		try {
			c = new CPF("");
			c.autoComplete(null);
			valida(c);
		}
		catch (InputMismatchException e) {
			System.out.println("Erro na entrada de paramentros: " + e.getMessage());
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			System.out.println("Argunmento invalido: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			sc.close();
		}	
	}
	
	private static void valida(CPF c){
		
			if ( c.validar() ) {
				System.out.println("CPF: " + c.getCPF() + " valido");
				System.out.println("Pertece a região de " + c.regiao());
				System.out.println("Dig verificador: " + c.digitoVerificador() + "; Soma: " + c.soma());
			}else {
				System.out.println("CPF: " + c.getCPF() + " falso");
				System.out.print("Esperado encontrar no Dig Ver: "+ c.digitoVerificador() + "; Soma: " + c.soma());
			}
	
	
	}
}
