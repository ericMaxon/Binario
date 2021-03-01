class Main {
  public static void main(String[] args){
    Lectura leer = new Lectura();
    
    int num;//Numero a convertir
    
    int seleccion;
    String mensaje = " ";
    String binario_a_evaluar = " ";
    
    do{
        mensaje = "\nDigite \n\t1. Para ir de Decimal a Binario\n\t2. Para Binario a Decimal\n\t3. Para convertir a flotante\n\t4. Para flotante completo desde binario\n\t5.Salir\n\t";
        System.out.println(mensaje);
        seleccion = leer.Opcion(mensaje);
        switch(seleccion){
            case 1:
                mensaje = "Introduzca el valor a convertir a binario";
                System.out.println(mensaje);
                num = leer.DatosE(mensaje);
                
            	Binario bin = new Binario(num);
            	int []binary = bin.ConvertirABin(bin.ObtenerBits(4));//Tomo 4 como la cantidad minima de bits que tendre.
            	// En esta parte se muestran los datos desde el final al inicio debido a que aplique el metodo por division.
            	
            	if(Binario.Valor(binary)==num)
            	    for(int index = binary.length - 1; index>=0; index--)
        		            System.out.print(binary[index]);
                else
                    System.out.println("Error en el codigo, contactar con el programador");
    	    break;
    	    case 2:
            	mensaje = "Introduzca el binario a evaluar para calcular parte Entera";
                System.out.println(mensaje);
                binario_a_evaluar = leer.DatosCad(mensaje);
            	System.out.println(Binario.ConvertirADec(binario_a_evaluar)+"\n");
    	    break;
    	    case 3:
    	    	mensaje = "Ingrese la parte decimal a evaluar";
                System.out.println(mensaje);
                binario_a_evaluar = leer.DatosCad(mensaje);
            	System.out.println(Binario.ConvertirAFloat(binario_a_evaluar)+"\n");
    	    break;
    	    case 4:
    	    	mensaje = "Ingrese el punto flotante a evaluar";
                System.out.println(mensaje);
                binario_a_evaluar = leer.DatosCad(mensaje);
            	
                /*String[] sep = binario_a_evaluar.split("\\.");//Separando el punto decimal
                double valor = (double) Binario.ConvertirADec(sep[0])+Binario.ConvertirAFloat(sep[1]);*/
                
            	System.out.println(Binario.PuntoFlotante(binario_a_evaluar)+"\n");
    	    break;
    	    
        }
    }while(seleccion != 5);
    System.out.println("Espero y le haya sido util");
  }
}