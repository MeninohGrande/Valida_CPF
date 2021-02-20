package entidade;

public class CPF {
		private String nCPF;						//Variavel para armazenar CPF
		private int X[] = new int[11];				//9 digitos
		private int Xt[] = new int [2];				//digitos verificadores
	
		
		public CPF () {
			
		}
	
		public String getnCPF() {
			return nCPF;
		}

		public void setnCPF(String nCPF) {
			this.nCPF = nCPF;
		}

		private void quebrar() {
			char[] charArray = nCPF.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				X[i] = Integer.valueOf(String.valueOf(charArray[i]));
				
				System.out.println("Quebra posição " + i + " = " + X[i]);
			}	
		
		}

		public void validar(String numCPF) {
			this.nCPF = numCPF;
			int ti = 0;
			int tj = 0;
			quebrar();
			
			for (int i=0; i < 9; i++)			
				ti += X[i] * (10-i);
			
					if ((ti%11) < 9 )
						Xt[0] = 0;
					else
						Xt[0] = 11 - (ti%11);
			
			for (int j=10; j < 11; j++)
				tj += X[j] * (11-j);
			
					if ((tj%11) > 9 )
						Xt[1] = 0;
					else
						Xt[1] = 11 - (tj%11);
			
					
			if ( (X[9] == Xt[0]) && (X[10] == Xt[1]))
				System.out.println("CPF válido");
			else
				System.out.println("CPF falso");
			
		imprimir(X);
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
