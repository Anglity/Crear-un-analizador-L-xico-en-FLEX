%{
#include <stdio.h>
%}

%%
[ \t\n]+    { printf(" "); }  /* Encuentra una o más repeticiones de espacios, tabulaciones o saltos de línea y las imprime como un solo espacio */
.           { putchar(yytext[0]); }  /* Cualquier otro carácter se imprime tal como está */
%%

int yywrap() {
    return 1;  /* Indica el fin de la entrada */
}

int main() {
    yylex();  /* Inicia el análisis */
    return 0;
}
