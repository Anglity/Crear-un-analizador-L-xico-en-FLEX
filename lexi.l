%{
#include <stdio.h>
%}

%%

\bfloat\b     { printf("double"); }  /* Reconoce 'float' como palabra completa y la reemplaza por 'double' */
.|\n          { ECHO; }  /* Imprime cualquier otro carácter tal cual, incluyendo saltos de línea */

%%

int yywrap() {
    return 1;  /* Termina el análisis cuando no haya más entrada */
}

int main() {
    yylex();  /* Inicia el escáner */
    return 0;
}
