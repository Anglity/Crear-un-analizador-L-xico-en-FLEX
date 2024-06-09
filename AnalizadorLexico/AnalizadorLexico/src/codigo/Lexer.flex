package codigo;

import static codigo.Tokens.*;

%%
%class Lexer
%type Tokens
%unicode
%{
    public String lexeme;
%}

// Expresiones regulares
L=[a-zA-Z_]
D=[0-9]
espacio=[ \t\r\n]+

%%
<YYINITIAL> {
    // Palabras reservadas
    "int" { lexeme = yytext(); return RESERVADA; }
    "if" { lexeme = yytext(); return RESERVADA; }
    "else" { lexeme = yytext(); return RESERVADA; }
    "while" { lexeme = yytext(); return RESERVADA; }

    // Operadores
    "==" { return IGUAL_IGUAL; }
    "=" { return IGUAL; }
    "+" { return SUMA; }
    "-" { return RESTA; }
    "*" { return MULTIPLICACION; }
    "/" { return DIVISION; }
    "%" { return MODULO; }
    "++" { return INCREMENTO; }
    "--" { return DECREMENTO; }
    "&&" { return AND; }
    "||" { return OR; }
    "!" { return NOT; }
    "!=" { return DIFERENTE; }
    "<" { return MENOR_QUE; }
    ">" { return MAYOR_QUE; }
    "<=" { return MENOR_IGUAL; }
    ">=" { return MAYOR_IGUAL; }

    // Delimitadores
    ";" { return PUNTO_Y_COMA; }
    "," { return COMA; }
    "\\." { return PUNTO; }
    ":" { return DOS_PUNTOS; }
    "\\(" { return PARENTESIS_IZQUIERDO; }
    "\\)" { return PARENTESIS_DERECHO; }
    "\\[" { return CORCHETE_IZQUIERDO; }
    "\\]" { return CORCHETE_DERECHO; }
    "\\{" { return LLAVE_IZQUIERDA; }
    "\\}" { return LLAVE_DERECHA; }
    "\"" { return COMILLAS_DOBLES; }
    "'" { return COMILLAS_SIMPLES; }
    "?" { return SIGNO_INTERROGACION; }
    "¿" { return SIGNO_INTERROGACION_INVERTIDO; }
    "!" { return SIGNO_EXCLAMACION; }
    "¡" { return SIGNO_EXCLAMACION_INVERTIDO; }
    "\\" { return BARRA_INVERTIDA; }
    "|" { return BARRA_VERTICAL; }
    "&" { return AMPERSAND; }
    "@" { return ARROBA; }
    "#" { return NUMERAL; }
    "$" { return DOLAR; }
    "^" { return CIRCUNFLEJO; }
    "_" { return GUIÓN_BAJO; }
    "`" { return ACENTO_GRAVE; }
    "~" { return TILDE; }

    // Identificadores y números separados
    {L}+ { lexeme = yytext(); return PALABRA; }
    {D}+ { lexeme = yytext(); return NUMERO; }

    // Números
    ("(-"{D}+")")|{D}+ { lexeme = yytext(); return NUMERO; }

    // Espacios en blanco y comentarios (ignorados)
    {espacio} { /* Ignorar espacios en blanco */ }
    "//".* { /* Ignorar comentarios */ }
    "/*"([^*]|[*][^/])*"*/" { /* Ignorar comentarios múltiples */ }

    // Cualquier otro carácter
    . { return ERROR; }
}
