public class Binario{
	private int num_a_evaluar;
	
		Binario(int num_a_evaluar){
			this.num_a_evaluar = num_a_evaluar;
	}
	
	public void AsignarNumero(int num_a_evaluar){
			this.num_a_evaluar = num_a_evaluar;
	}
	
	public int ObtenerBits(int bits){
		if(num_a_evaluar<(int)Math.pow(2.0,bits))
		    return bits;
		else
		   return ObtenerBits(bits*2);
	}
	private static double CorrerComa(double mantisa, int exponente){
		while(exponente < 0){
			mantisa = mantisa / 10;
			exponente ++;
		}
		while(exponente>0){
			mantisa *= 10;
			exponente--;
		}
		
		return mantisa;//Cuando el exponente es cero
	}
	
	public static int Valor(int[] conv_binaria){
		int acum=0;
		for(int i= conv_binaria.length - 1; i>=0 ; i--)//Se recorre como una pila
    			if(conv_binaria[i] == 1)
    				acum += (int)Math.pow(2.0, i);

		return acum;
	}
	
	public int[] ConvertirABin(int bits){
		int[]conv_binaria = new int[bits];
		int valor = num_a_evaluar;
		
		if(valor<0){
			int i=1;
				conv_binaria[0]=1;
				valor = Math.abs(valor);
				for(;valor!=0;valor/=2)
					conv_binaria[i++]=valor%2;//Los datos son almacenados en cola y son evaluados o mostrados en pila
				//Al tener a i dentro del indice del arreglo, este se incrementa despues de la ejecucion de esa linea de codigo
		}else{
			int i=0;
				valor = Math.abs(valor);
				for(;valor!=0;valor/=2)
					conv_binaria[i++]=valor%2;
			
		}
			return conv_binaria;
	}
	public static int ConvertirADec(String binario){//Si se desea ingresar una cadena
		int acum=0, p=0;

		//Para obtener el valor del binario convertido
		for(int i= binario.toCharArray().length-1; i>=0; p++)//p es el valor de la potencia
			if(binario.toCharArray()[i--]=='1')//Los datos son extraidos en pila y calculados con p que actua como una potencia.
				acum+=(int)Math.pow(2.0, p);
				
		return acum;
	}
	public static double ConvertirAFloat(String binario){
		double acum=0, p=-1;//p quiere decir potencia

		//Para obtener el valor del binario convertido
		for(int i = 0; i < binario.toCharArray().length; p--){//p es el valor de la potencia
			if(binario.toCharArray()[i++]=='.'){
				p++;
				continue;
			}
			if(binario.toCharArray()[i++]=='1')//Los datos son pila y calculados con p que actua como una potencia.
				acum+=Math.pow(2.0, p);
		}
		return acum;
	}
	
	public static double PuntoFlotante(String binarioFlotante){
		String[] partesFlotantes = binarioFlotante.split("\\ ");//En este punto separo las partes primordiales de las estructura de punto flotante
		
		int signo = Integer.parseInt(partesFlotantes[0]);
		String expBin = partesFlotantes[1];//Exponente en binario
		double mantBin = Double.parseDouble("1."+partesFlotantes[2]);//Mantisa inicial
		
		int exponente = ConvertirADec(expBin) - 127;//Calculo del exponente
		
		mantBin  = CorrerComa(mantBin, exponente);
		int mantisaEntero = (int) mantBin;//Obtener la parte entera
		double mantisaDecimal = mantBin%1;//Obtener la parte dceimal
		mantisaDecimal *= 10;//Correr el punto el decimal una vez mas
		System.out.println("Mantisa entero:" + mantisaEntero);
		System.out.println("Mantisa Decimal:" + mantisaDecimal);
		
		return Math.pow(-1, signo) * (double)((ConvertirADec(String.valueOf(mantisaEntero)) + ConvertirAFloat(String.valueOf(mantisaDecimal))));
	}
}