# StreamTokenizer 
Con StreamTokenizer clasificamos el input entre palabra y numero bien desde el teclado o desde un fichero.
Esta clase recibe un flujo de entrada, lo analiza y divide en tokens, permitiendo su clasificacion.

## Sobre este proyecto

### 1º Parte: InputAnalysis
##### Introduccion:

>Pasamos texto por teclado para su posterior analisis con el tokenizador

1. Recogemos el flujo a traves del input de teclado.
2. Construimos un buffer para almacenar y procesar el flujo.
3. Transformamos el flujo a string.
4. Leemos el string y lo analizamos con el tokenizador

##### Diagrama de flujo
```mermaid 
graph TD;
    Input_Teclado-->InputStreamReader-->BufferedReader-->Output_Teclado_string;
    StringReader-->Output_Teclado_string;
    StreamTokenizer-.Analizamos la cadena..->StringReader;
   
````

##### Resultado
<img width="1440" alt="Screenshot 2022-04-22 at 10 25 42" src="https://user-images.githubusercontent.com/59641925/164910796-51af808b-e9f2-466f-9ff6-645d28df8504.png">


### 2º Parte: FileAnalysis
##### Introduccion:

>Inicializamos un fichero para su posterior analisis con el tokenizador


1. Declaramos el fichero file.txt.
2. Recogemos el flujo a con un lector de fichero.
3. Analizamos el flujo con el tokenizador
##### Resultado

<img width="1440" alt="Screenshot 2022-04-23 at 17 27 19" src="https://user-images.githubusercontent.com/59641925/164912634-33f22041-6274-41d7-961c-f4de933fc521.png">


### 3º Parte: InputFileAnalysis

##### Introduccion:

> Escribimos sobre un fichero para su posterior analisis con el tokenizador


1. Recogemos el flujo a traves del input de teclado
3. Construimos un buffer para almacenar y procesar el flujo de input.
4. Declaramos el fichero `file.txt`.
5. Construimos un buffer para escribir el texto sobre el fichero.
6. Leemos el texto del `fichero` y lo analizamos con el tokenizador


##### Diagrama de flujo

```mermaid 
graph TD;
    Input_Teclado-.Escribimos por teclado..->InputStreamReader-.->BufferedReader-.->Output_Teclado_string;
    Output_Teclado_string-.Devolvemos la cadena..->Output_File;
    Input_File-. Inicializamos el fichero...->FileWriter-.->BufferedWriter-.Devolvemos el fichero..->Output_File[\Output_File/];
    Output_File-->FileReader
    FileReader-.Analizamos el fichero.->StreamTokenizer;
   
````
##### Resultado

<img width="1440" alt="Screenshot 2022-04-23 at 16 47 54" src="https://user-images.githubusercontent.com/59641925/164911026-2297ff51-a0bf-49c2-b424-1d9abe3580ec.png">

