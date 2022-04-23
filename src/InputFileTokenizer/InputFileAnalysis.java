/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InputFileTokenizer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;


/**
 *
 * @author jfunez
 */
public class InputFileAnalysis {
      // Declaramos el fichero
      static File ficheroParaProcesar = new File("src/InputFileTokenizer/file.txt");
      
      // Declaramos la var donde transformamos el flujo del buffer a formato String
      static String parrafo;
      static String linea;
      
      // Declaramos el Tokenizador de flujo
      static StreamTokenizer st;
      
      // Declaramos los contadores palabras y numeros
      static int cntNumeros;
      static int cntPalabras;

    public static void main(String[] args) throws IOException
    {
    
                while(true)
                {
                        System.out.println("Intruduzca texto: [`q` para salir]");

                        System.out.print(" - ");
                    
                        // Creamos un buffer para leer lo que escribimos por teclado   
                        BufferedReader datos  = new BufferedReader(new InputStreamReader(System.in));

                    //

                          BufferedWriter ficheroEscritura = new BufferedWriter(new FileWriter(ficheroParaProcesar));
                
                        //
                        
                     
                   
                        // Tomamos la linea de texto
                        linea = datos.readLine();
                        
                        System.out.println("");
                    
                        // Para cerrar ejecucion
                        if("q".equals(linea))
                        {
                             //ficheroEscritura.flush();
                            break;
                        }
                    
                        // Concatenamos la linea al parrafo
                        if(parrafo != null)
                        {
                            parrafo += linea + "\n";
                        }
                        else
                        {
                            parrafo = linea + "\n";
                        }
                        
                        
                        
                        
                        
                        
                        
                        
                        // Escribimos el parrafo
                      
                        ficheroEscritura.write(parrafo);
                        ficheroEscritura.close();
                       
                    
            
                        // Creamos un buffer para leer el texto del fichero
                        BufferedReader ficheroLectura = new BufferedReader(new FileReader(ficheroParaProcesar));
                     
                        // Creamos el lector del fichero para pasarlo al tokenizador 
                        Reader FicheroParaTokenizar = new FileReader(ficheroParaProcesar);
                    
                        // Pasamos el reader para que sea analizado por el tokenizador
                        st = new StreamTokenizer(FicheroParaTokenizar);
                   
                        while(st.nextToken() !=  StreamTokenizer.TT_EOF)
                        {    
                            switch(st.ttype) // Dependiendo del tipo de token que encuentres incrementa el contador
                            {
                                 case StreamTokenizer.TT_WORD: // Si es palabra
                                     cntPalabras++;
                                     break;

                                 case StreamTokenizer.TT_NUMBER: // Si es numero
                                     cntNumeros++;
                                     break;

                             }
                       }

                    System.out.println("Resultado: ");
                    System.out.print("\n");
                            
                    for (String line = ficheroLectura.readLine(); line != null; line = ficheroLectura.readLine()) {
                       System.out.println(line);
                    }
                    
                    System.out.print("\n");
                    System.out.println("Cantidad de palabras: \b "+ cntPalabras);
                    System.out.println("Cantidad de numeros enteros: \b "+ cntNumeros);
                    System.out.println("\n");
                    
                    cntPalabras = 0;
                    cntNumeros  = 0;
                } 
                
    }
}
