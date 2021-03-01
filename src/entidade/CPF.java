package entidade;

import java.util.Random;

public class CPF {
		private Integer X[] = new Integer[11];				//CPF in int array
		char[] CPFArray;

		public CPF (String cpf) {
			
			CPFArray = formatCPF(cpf).toCharArray();		
		}
	public void setCPF(String cpf) {
			
				CPFArray = formatCPF(cpf).toCharArray();
				splitCPF();
		}
	
		public String getCPF() {
			
			if (CPFArray.length > 0) {
				String cpf =  String.valueOf(CPFArray);
				return cpf;
			}else {
				return "CPF NULL";
			}
		}

	

		public Boolean validar() {
			int soma = 0;
			
			quebrar();
			
			if (check())
				return false;
		
			
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
		
		public String digVer() {
			
			if (X[9] != null && X[10] != null) {
				String 	dig = String.valueOf(X[9]);
						dig += String.valueOf(X[10]);
			return dig;
			}
			else {
				return "VOID";
			}
			
		}
		
		public Integer[] splitCPF() {
			if(X == null) {
			for (int i = 0; i < CPFArray.length; i++) {
				X[i] = Integer.valueOf(String.valueOf(CPFArray[i]));
			}
		return X;
		}
			else {
				return X;
			}
		}
		
		public String estado() {
		String estado;
		
		switch (X[8]) {
			case 0:
				estado =  "Rio Grande do Sul";
			break;
			
			case 1:
				estado =  "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
			break;
			
			case 2:
				estado = "Amazonas, Pará, Roraima, Amapá, Acre e Rondônia";
			break;
			
			case 3:
				estado = "Ceará, Maranhão e Piauí";
			break;
			
			case 4:
				estado = "Paraíba, Pernambuco, Alagoas e Rio Grande do Norte";
			break;
			
			case 5:
				estado = "Bahia e Sergipe";
			break;
			
			case 6:
				estado = "Minas Gerais";
			break;
			
			case 7:
				estado = "Rio de Janeiro e Espírito Santo";
			break;
			
			case 8:
				estado = "São Paulo";
			break;
			
			case 9:
				estado = "Paraná e Santa Catarina";
			break;
			
			default: 
				estado = "Inválido";
			break;
			}
		return estado;
		}
		
		
		public void autoComplete() {
		Random random = new Random();
				if (!check()) {
			
					char[] tempCPF = new char[11];
					
					for (int temp = 0; temp < CPFArray.length; temp++) {
						tempCPF[temp] = CPFArray[temp];
					}
	
					for (int c = 0; c < 11; c++) {
						if (tempCPF[c] == '\u0000') {
							tempCPF[c] = String.valueOf(random.nextInt(10)).charAt(0);
						}
					}
					
					CPFArray = String.valueOf(tempCPF).toCharArray();
					
					validar();		
				}else
					System.out.println("Entrada de CPF invalida");
		}
		
		private void quebrar() {
			
			for (int i = 0; i < 9; i++) {
				X[i] = Integer.valueOf(String.valueOf(CPFArray[i]));
			}
		}
		
		private String formatCPF (String cpf) {
			cpf = cpf.replace(".", "");
			cpf = cpf.replace("-", "");
			return cpf;
		}
		private boolean check() {
			String nCPF = String.valueOf(CPFArray);
	
			if (CPFArray.length > 11 || nCPF == null || nCPF.contains("01234567890") || nCPF.contains("000000") ||
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