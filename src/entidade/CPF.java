package entidade;

public class CPF {
		private String nCPF;						//Variavel para armazenar CPF
		private int X[] = new int[11];				//CPF in int array
		private int Xt[] = new int [2];				//digitos verificadores temp
		char[] CPFArray;

		public CPF (String cpf) {
			this.nCPF = cpf;
			CPFArray = nCPF.toCharArray();
		}
	
		public CPF (Integer cpf) {
			this.nCPF = Integer.toString(cpf);
			CPFArray = nCPF.toCharArray();			
		}
		
		public String getnCPF() {
			return nCPF;
		}

		public void setnCPF(String cpf) {
			this.nCPF = cpf;
			CPFArray = nCPF.toCharArray();
		}

		public Boolean validar() {
			int soma = 0;
			quebrar();
			
			if (! check())
				return false;
		
			
			for (int i=0; i < 9; i++)			
				soma += X[i] * (10-i);
			
					if ((soma%11) == 0 || (soma%11) == 1 ) {
						Xt[0] = 0;
					}
					else {
						Xt[0] = 11 - (soma%11);
					}
					
			soma = 0;
				
			for (int j=0; j < 10; j++)
				soma += X[j] * (11-j);
			
					if ((soma%11) == 0 || (soma%11) == 1 )
						Xt[1] = 0;
					else
						Xt[1] = 11 - (soma%11);
						
			soma = 0;
					
			if ( (X[9] == Xt[0]) && (X[10] == Xt[1]))
				return true;
			else {
				return false;
			}
		}
		
		public int[] dividir() {
			quebrar();
		return X;
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
				estado = "Invalido";
			break;
			}
		return estado;
		}
		
		private void quebrar() {
			
			for (int i = 0; i < CPFArray.length; i++) {
				X[i] = Integer.valueOf(String.valueOf(CPFArray[i]));
			}
		}
		
		private boolean check() {
			if (nCPF.length() != 11 || nCPF == null || nCPF.contains("01234567890") || nCPF.contains("00000000000") ||
				nCPF.contains("11111111111") || nCPF.contains("22222222222") || nCPF.contains("33333333333") ||
				nCPF.contains("44444444444") || nCPF.contains("55555555555") || nCPF.contains("66666666666") ||
				nCPF.contains("77777777777") || nCPF.contains("88888888888") || nCPF.contains("99999999999")) 
			{
				return false;
			} 
			else {
				return true;
			}
		}
		
		private void imprimir (int X[]) {
			for(int i = 0; i < X.length; i++) {
				System.out.print("  ");
				System.out.print(X[i]);
				}
			
			System.out.println();
			
			for(int c=0 ; c < Xt.length ; c ++)
				System.out.println("Digito verificador  = "+ Xt[c]);
		}
}