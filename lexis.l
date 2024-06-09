%{
#include <stdio.h>
#include <ctype.h>
%}

%%
[a-zA-Z]+    { pig_latin(yytext); }
[ \t\n]+     { ECHO; }   /* Echo any whitespace */

%%

int yywrap() {
    return 1;
}

int main() {
    yylex();
    return 0;
}

void pig_latin(char *word) {
    int firstVowelIdx = -1;
    int len = 0;
    while (word[len] != '\0') {
        if (firstVowelIdx == -1 && is_vowel(word[len])) {
            firstVowelIdx = len;
        }
        len++;
    }

    if (firstVowelIdx > 0) {  /* Consonant at the beginning */
        for (int i = firstVowelIdx; i < len; i++) {
            putchar(word[i]);
        }
        for (int i = 0; i < firstVowelIdx; i++) {
            putchar(word[i]);
        }
        printf("ay");
    } else if (firstVowelIdx == 0) {  /* Vowel at the beginning */
        printf("%say", word);
    } else {  /* No vowels found, rare but could handle differently */
        printf("%s", word); /* No transformation */
    }
}

int is_vowel(char c) {
    c = tolower(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
