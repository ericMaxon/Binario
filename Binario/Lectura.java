/*
    Clase para la lectura de datos, tanto enteros como reales y ahora confirmaciones de lectura
*/

import java.io.*;

public class Lectura {

    private int inputE;
    private double inputD;
    private char inputC;
    private boolean error;
    private String inputCad;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //lectura de datos enteros
    public int DatosE(String mensaje) {
        do {
            try {
                error = false;
                inputE = Integer.parseInt(br.readLine());
                /*if (inputE <= 0) {
                    System.out.println("Vuelva a introducir un dato valido");
                    System.out.println(mensaje);
                    error = true;
                }*/
            } catch (IOException e) {
                System.out.println(e);
                error = true;
            } catch (NumberFormatException er) {
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
                System.out.println(mensaje);
                error = true;
            }
        } while (error);

        return inputE;
    }
    //Lectura de Datos double
    public double DatosD(String mensaje) {
        do {
            try {
                error = false;
                inputD = Double.parseDouble(br.readLine());
                if (inputD <= 0) {
                    System.out.println("Introduzca un dato valido");
                    System.out.println(mensaje);
                    error = true;
                }
            } catch (IOException e) {
                System.out.println(e);
                error = true;
            } catch (NumberFormatException er) {
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
                System.out.println(mensaje);
                error = true;
            }
        } while (error);
        return inputD;
    }

    //Metodo modificable para el momento de lectura de Opciones
    public int Opcion(String mensaje) {
        do {
            try {
                error = false;
                inputE = Integer.parseInt(br.readLine());
                if ((inputE <= 0) || (inputE > 5)) {
                    System.out.println("Introduzca un dato valido");
                    System.out.println(mensaje);
                    error = true;
                }
            } catch (IOException e) {
                System.out.println(e);
                error = true;
            } catch (NumberFormatException er) {
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
                System.out.println(mensaje);
                error = true;
            }
        } while (error);

        return inputE;
    }

    public char DatosConfir(String mensaje){
        do{
            try{
                System.out.println("Conversion erronea de datos, pruebe con valores numericos entero");
                error = false;
                inputC = (char) br.read();
                br.skip(1);
                //Validacion de caracteres esperados.
               if((inputC !='s' && inputC !='S')&&(inputC !='n' && inputC !='N')){
                    System.out.println("Dato erroneo, vuelva a introducir\n"+mensaje);
                    error = true;
                }//Comprobar para valores numericos.
                if(Character.isDigit(inputC)){
                  System.out.println("No puede ingresar un numero, vuelva a introducir\n"+mensaje);
                  error = true;
                }
            }  catch(IOException e){
                System.out.println(e);
                error = true;
            }
        }while (error);
        return inputC;
    }
    //Lectura de datos cadena
    public String DatosCad(String mensaje) {
        do {
            error = false;
            try{
                inputCad = br.readLine();
                /*for (int i = 0; i < inputCad.length(); i++) {
                    if (!Character.isDigit(inputCad.toCharArray()[i])) {
                        System.out.println("No puede ingresar letras en este campo");
                        System.out.println(mensaje);
                        error = true;
                    }
                }*/
            }catch(IOException e){
                System.out.println(e);
                error = true;
            }
        } while (error);
        return inputCad;
    }
}