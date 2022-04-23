package WordsTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jfunez
 */
public class InputAnalysis {
    
      // Construimos el buffer de datos que almacena la informacion que tecleamos 
      static BufferedReader datos  = new BufferedReader(new InputStreamReader(System.in));
      
      
      // Declaramos la var donde transformamos el flujo del buffer a formato String
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
                    
                    // Convertimos desde el buffer el flujo a String
                    linea = datos.readLine();
                    
                    // Para cerrar ejecucion
                    if("q".equals(linea))
                    {
                    break;
                    }
                    
            
                    
                    // Con Reader creamos el flujo  y con StringReader procesamos el String.
                    StringReader datosTransformados = new StringReader(linea);
                    
                    // Pasamos el flujo reader para que sea analizado por el tokenizador
                    st = new StreamTokenizer(datosTransformados);
                   
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
                    System.out.println("\n");
                    System.out.println("Resultado. ");
                    System.out.println("Cantidad de palabras: \b "+ cntPalabras);
                    System.out.println("Cantidad de numeros enteros: \b "+ cntNumeros);
                    System.out.println("\n");
                    
                    cntPalabras = 0;
                    cntNumeros  = 0;
                } 
    }
}
