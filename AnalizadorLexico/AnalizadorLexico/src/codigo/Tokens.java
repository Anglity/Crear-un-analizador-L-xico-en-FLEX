package codigo;

/**
 * Enum representing the various types of tokens used by the lexer.
 * Each token represents a specific type of lexical unit in the input source code.
 * Author: Charly Ponce
 */
public enum Tokens {
    // Palabras reservadas
    RESERVADA,

    // Operadores
    IGUAL,
    IGUAL_IGUAL,
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    MODULO,
    INCREMENTO,
    DECREMENTO,
    AND,
    OR,
    NOT,
    DIFERENTE,
    MENOR_QUE,
    MAYOR_QUE,
    MENOR_IGUAL,
    MAYOR_IGUAL,

    // Delimitadores
    PUNTO_Y_COMA,
    COMA,
    PUNTO,
    DOS_PUNTOS,
    PARENTESIS_IZQUIERDO,
    PARENTESIS_DERECHO,
    CORCHETE_IZQUIERDO,
    CORCHETE_DERECHO,
    LLAVE_IZQUIERDA,
    LLAVE_DERECHA,
    COMILLAS_DOBLES,
    COMILLAS_SIMPLES,
    SIGNO_INTERROGACION,
    SIGNO_INTERROGACION_INVERTIDO,
    SIGNO_EXCLAMACION,
    SIGNO_EXCLAMACION_INVERTIDO,
    BARRA_INVERTIDA,
    BARRA_VERTICAL,
    AMPERSAND,
    ARROBA,
    NUMERAL,
    DOLAR,
    CIRCUNFLEJO,
    GUIÓN_BAJO,
    ACENTO_GRAVE,
    TILDE,

    // Identificadores
    PALABRA,

    // Literales
    NUMERO,

    // Manejo de errores
    ERROR
}
