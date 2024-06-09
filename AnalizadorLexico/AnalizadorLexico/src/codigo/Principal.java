// Define el paquete al que pertenece la clase, en este caso 'codigo'.
package codigo;

// Importa la clase File de la librería java.io, necesaria para manejar archivos.
import java.io.File;


public class Principal {
    // Método principal de la clase que se ejecuta cuando se inicia el programa.
    public static void main(String[] args) {
        // Define la ruta completa del archivo Lexer.flex que contiene la definición del lexer.
        String ruta = "C:\\Users\\ang12\\analizador-lexico\\AnalizadorLexico\\AnalizadorLexico\\src\\codigo\\Lexer.flex";
        // Llama al método generarLexer pasando la ruta del archivo como argumento.
        generarLexer(ruta);
    }

    /**
     * Método que toma una ruta de archivo para un archivo .flex y utiliza JFlex para generar un analizador léxico.
     * @param ruta Ruta del archivo .flex que define el lexer.
     */
    public static void generarLexer(String ruta){
        // Crea un objeto File con la ruta especificada, que representa al archivo .flex.
        File archivo = new File(ruta);
        // Utiliza el método generate de JFlex para generar el analizador léxico basado en el archivo .flex.
        JFlex.Main.generate(archivo);
    }
}
