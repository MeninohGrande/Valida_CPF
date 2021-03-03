package entidade;

import java.util.InputMismatchException;
import java.util.Random;

public class CPF {
		private Integer X[] = new Integer[11];				
		char[] CPFArray;

		public CPF (String cpf){
			setCPF(cpf);		
		}
		public void setCPF(String cpf) throws InputMismatchException, NumberFormatException{
			if (cpf == null)
				throw new InputMismatchException("CPF não pode ser null");
			
			cpf = formatCPF(cpf);
			
			if (!cpf.matches("[0-9]+")) {
				
				if (!(cpf == "")) {
					throw new NumberFormatException("CPF não pode conter letras");
				}
			}
			
			if(cpf.length() > 11)
				throw new InputMismatchException("CPF informado maior que 11 digitos");
			
			CPFArray = cpf.toCharArray();
			
			if (check(CPFArray)) 
				throw new InputMismatchException("CPF contem sequencia de digitos invalida");
			
			for (int i = 0; i < CPFArray.length; i++)
				X[i] = Integer.valueOf(String.valueOf(CPFArray[i]));
		}
	
		public String getCPF() throws IllegalArgumentException {
			
			if (CPFArray.length > 0) {
				String cpf =  String.valueOf(CPFArray);
				return cpf;
			}else {
				throw new IllegalArgumentException("Nenhum CPF informado");
			}
		}

		public Boolean validar() {
			int soma = 0;
			
			if (check(CPFArray) || CPFArray.length != 11)
				return false;
			
			for (int i = 0; i < 9; i++) 
				X[i] = Integer.valueOf(String.valueOf(CPFArray[i]));
			
			for (int i=0; i < 9; i++)			
				soma += X[i] * (10-i);
			
				if (11 - (soma%11) > 9 ) {
					X[9] = 0;
				}
				else {
					X[9] = 11 - (soma%11);
				}
					
			soma = 0;
				
			for (int j=0; j < 10; j++)
				soma += X[j] * (11-j);
		
				if ( 11 - (soma%11) > 9 )
					X[10] = 0;
				else
					X[10] = 11 - (soma%11);
						
			soma = 0;
			
			int dig1 = Integer.parseInt(String.valueOf(CPFArray[9]));
			int dig2 = Integer.parseInt(String.valueOf(CPFArray[10]));
		
			if ( (X[9] == dig1) && (X[10] == dig2) ) {
				return true;
			}else {
				CPFArray[9] = String.valueOf(X[9]).charAt(0);
				CPFArray[10] = String.valueOf(X[10]).charAt(0);
				return false;
			}
		}
		
		public String digitoVerificador() {
			
			if (X[9] != null && X[10] != null) {
				String 	dig = String.valueOf(X[9]) + String.valueOf(X[10]);
			return dig;
			}
			else {
				return null;
			}
			
		}
		
		public String regiao() throws IllegalArgumentException {
			if(X[8] == null )
				throw new IllegalArgumentException("CPF incompleto ou não informado");
				
			String regiao;
			
			switch (X[8]) {
				case 0:
					regiao =  "Rio Grande do Sul";
				break;
				
				case 1:
					regiao =  "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
				break;
				
				case 2:
					regiao = "Amazonas, Pará, Roraima, Amapá, Acre e Rondônia";
				break;
				
				case 3:
					regiao = "Ceará, Maranhão e Piauí";
				break;
				
				case 4:
					regiao = "Paraíba, Pernambuco, Alagoas e Rio Grande do Norte";
				break;
				
				case 5:
					regiao = "Bahia e Sergipe";
				break;
				
				case 6:
					regiao = "Minas Gerais";
				break;
				
				case 7:
					regiao = "Rio de Janeiro e Espírito Santo";
				break;
				
				case 8:
					regiao = "São Paulo";
				break;
				
				case 9:
					regiao = "Paraná e Santa Catarina";
				break;
				
				default: 
					regiao = "Inválido";
				break;
				}
			return regiao;
		}
		
		
		public void autoComplete(Integer regiao) throws InputMismatchException {
		
			Random random = new Random();
			char[] tempCPFArray;
			int cont = 0;
			do {
				if (cont > 9) {
					throw new InputMismatchException("Sequencia de digitos invalida");
				}
				
				char[] tempCPF = new char[11];
				
				for (int temp = 0; temp < CPFArray.length; temp++) {
					tempCPF[temp] = CPFArray[temp];
				}
	
				for (int c = 0; c < 11; c++) {
					if (tempCPF[c] == '\u0000') {
						tempCPF[c] = String.valueOf(random.nextInt(10)).charAt(0);
					}
				}
				
				tempCPFArray = String.valueOf(tempCPF).toCharArray();
				if (regiao != null)
					tempCPFArray[8] = String.valueOf(regiao).charAt(0);
				cont++;
			}while(check(tempCPFArray));
			
			setCPF(String.valueOf(tempCPFArray));
			validar();
		}
		
		public int soma() {
			int soma = 0;
				for (int i = 0; i < X.length; i++) {
					if (X[i] != null)					
						soma += X[i];
				}			
			return soma;
		}
		
		private String formatCPF (String cpf) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");
			return cpf;
		}
		private boolean check(char[] cpf) {
			String nCPF = String.valueOf(cpf);
	
			if (CPFArray.length > 11 || nCPF.contains("123456789") || nCPF.contains("000") ||
				nCPF.contains("111111") || nCPF.contains("222222") || nCPF.contains("333333") ||
				nCPF.contains("444444") || nCPF.contains("555555") || nCPF.contains("666666") ||
				nCPF.contains("777777") || nCPF.contains("888888") || nCPF.contains("999999")) 
			{
				return true;
			} 
			else {
				return false;
			}
		
		}	
}