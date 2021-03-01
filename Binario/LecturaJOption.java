/*
    Clase para la lectura de datos, tanto enteros como reales y ahora confirmaciones de lectura
*/

import javax.swing.JOptionPane;

public class LecturaJOption {

    private int inputE;
    private double inputD;
    private char inputC;
    private boolean error;
    private String inputCad;


    //lectura de datos enteros
    public int DatosE(String entrada, String mensaje) {
        do {
            try {
                error = false;
                inputE = Integer.parseInt(entrada);
                if(inputE <= 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
                    entrada = JOptionPane.showInputDialog(null, mensaje);
                    error = true;
                }
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(null, "Conversion erronea de datos, pruebe con valores numericos entero", "ERROR", JOptionPane.ERROR_MESSAGE);
                entrada = JOptionPane.showInputDialog(null, mensaje);
                error = true;
            }
        } while (error);

        return inputE;
    }

    //Lectura de Datos double
    public double DatosD(String entrada, String mensaje) {
        do {
            try {
                error = false;
                inputD = Double.parseDouble(entrada);
                if(inputD <= 0) {
                    JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
                    entrada = JOptionPane.showInputDialog(null, mensaje);
                    error = true;
                }

            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
                entrada = JOptionPane.showInputDialog(null, mensaje);
                error = true;
            }
        } while (error);

        return inputD;
    }

    //Metodo modificable para el momento de lectura de Opciones
    public int Opcion(String entrada, String mensaje) {
        do {
            try {
                error = false;
                inputE = Integer.parseInt(entrada);
                if((inputE <= 0) || (inputE > 3)) {
                    JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
                    entrada = JOptionPane.showInputDialog(null, mensaje);
                    error = true;
                }
            } catch (NumberFormatException er) {
                JOptionPane.showMessageDialog(null, "Conversion erronea de datos, pruebe con valores numericos entero", "ERROR", JOptionPane.ERROR_MESSAGE);
                entrada = JOptionPane.showInputDialog(null, "Introduzca un dato correcto");
                error = true;
            }
        } while (error);

        return inputE;
    }

    //Lectura de datos cadena
    public String DatosCad(String entrada, String mensaje) {
        do {
            error = false;
            inputCad = entrada;
            for (int i = 0; i < inputCad.length(); i++) {
                if (Character.isDigit(inputCad.toCharArray()[i])) {
                    JOptionPane.showMessageDialog(null, "No puede ingresar numeros en este campo", "ERROR", JOptionPane.ERROR_MESSAGE);
                    entrada = JOptionPane.showInputDialog(null, mensaje);
                    error = true;
                }
            }
        } while (error);
        return inputCad;
    }
}