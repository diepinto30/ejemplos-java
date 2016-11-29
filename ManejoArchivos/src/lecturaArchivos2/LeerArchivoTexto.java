package lecturaArchivos2;

// Ejemplo tomado del libro 
// D EITEL , P AUL J. Y H ARVEY M. D EITEL
// CÓMO PROGRAMAR EN J AVA . Séptima edición
// fines educativos
// Prueba de la clase ArchivoTexto.
// Este programa lee un archivo de texto y muestra cada registro.
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo() {
        try {
            entrada = new Scanner(new File("datoscalificaciones.txt"));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método abrirArchivo

    // lee registro del archivo
    public void leer_informacion() {

        try // lee registros del archivo, usando el objeto Scanner
        {
            double suma = 0;
            double suma2 = 0;
            double pro = 0;
            double mejor_pro = 0;

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //System.out.println(linea);
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";")));
                System.out.println(linea_partes);
                double valor1 = 0;
                double valor2 = 0;
                valor1 = valor1 + Double.parseDouble(linea_partes.get(2));
                valor2 = valor2 + Double.parseDouble(linea_partes.get(3));
                pro = (valor1 + valor2)/2;
                
                if (pro >= mejor_pro) {
                    mejor_pro = pro;
                }
                System.out.printf("El promedio de %s es: % .2f\n",linea_partes.get(0), pro);
            } // fin de while
            System.out.printf("El mejor priomedio es: %.2f", mejor_pro);
            
        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del metodo leerRegistros
    // cierra el archivo y termina la aplicación

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del metodo cerrarArchivo
} // fin de la clase LeerArchivoTexto

