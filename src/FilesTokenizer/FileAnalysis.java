/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FilesTokenizer;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;


/**
 *
 * @author jfunez
 */
public class FileAnalysis {     
      // Declaramos la var donde transformamos el flujo del buffer a formato String
      static String linea;
      
      // Declaramos el reader
      static Reader flujoTransformado;
      
      // Declaramos el Tokenizador de flujo
      static StreamTokenizer st;
      
      // Declaramos los contadores palabras y numeros
      static int cntNumeros;
      static int cntPalabras;

    public static void main(String[] args) throws IOException
    {
        
                    // Reader genera el flujo y FileReader procesa el fichero.
                    flujoTransformado = new FileReader(new File("src/FilesTokenizer/file.txt"));
                    
                    // Pasamos el flujo reader para que sea analizado por el tokenizador
                    st = new StreamTokenizer(flujoTransformado);
                   
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
                    System.out.println("Resultado. ");
                    System.out.println("Cantidad de palabras: \b "+ cntPalabras);
                    System.out.println("Cantidad de numeros enteros: \b "+ cntNumeros);
                    System.out.println("\n");
                    
                    cntPalabras = 0;
                    cntNumeros  = 0;
                 
            }
    }

    
    

