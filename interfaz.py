import ply.lex as lex
import tkinter as tk
from tkinter import scrolledtext

# Definición de los tokens
tokens = (
    'NUMERO',
    'MAS',
    'MENOS',
    'MULTIPLICACION',
    'DIVISION',
    'PARENTESIS_IZQUIERDO',
    'PARENTESIS_DERECHO',
    'LETRA',
    'ESPECIAL',
    'COMA',
    'PUNTO',
)

# Expresiones regulares para los tokens
t_MAS = r'\+'
t_MENOS = r'-'
t_MULTIPLICACION = r'\*'
t_DIVISION = r'/'
t_PARENTESIS_IZQUIERDO = r'\('
t_PARENTESIS_DERECHO = r'\)'
t_COMA = r','
t_PUNTO = r'\.'

# Reconocer letras
def t_LETRA(t):
    r'[a-zA-Z]'
    return t

# Reconocer números y convertir a float o int
def t_NUMERO(t):
    r'\d+(\.\d+)?'
    t.value = float(t.value) if '.' in t.value else int(t.value)
    return t

# Reconocer caracteres especiales
def t_ESPECIAL(t):
    r'[!@#$%^&*_~`|:;<=>?[\]{}\\]'
    return t

# Ignorar espacios y tabulaciones
t_ignore = ' \t'

# Manejo de errores
def t_error(t):
    resultado.append(f"Carácter ilegal '{t.value[0]}' en la posición {t.lexpos}")
    t.lexer.skip(1)

# Construir el lexer
lexer = lex.lex()

# Analizar el texto de entrada
def analizar_entrada(data):
    global resultado
    resultado = []
    lexer.input(data)
    while True:
        tok = lexer.token()
        if not tok:
            break
        resultado.append(f"Token: {tok.type}, Valor: {tok.value}, Posición: {tok.lexpos}")
    return resultado

# Crear la ventana principal
root = tk.Tk()
root.title("Analizador Léxico")

# Crear y posicionar los elementos de la interfaz
frame = tk.Frame(root, padx=10, pady=10)
frame.pack(padx=10, pady=10)

input_label = tk.Label(frame, text="Ingrese el texto para analizar:")
input_label.pack(anchor='w')

input_text = tk.Text(frame, height=10, width=50, wrap=tk.WORD)
input_text.pack()

output_label = tk.Label(frame, text="Tokens encontrados:")
output_label.pack(anchor='w')

output_text = scrolledtext.ScrolledText(frame, height=10, width=50, wrap=tk.WORD)
output_text.pack()

# Función para analizar el texto de entrada y mostrar los tokens
def analizar():
    data = input_text.get("1.0", tk.END).strip()
    tokens = analizar_entrada(data)
    output_text.delete("1.0", tk.END)
    for token in tokens:
        output_text.insert(tk.END, f"{token}\n")

# Botón para iniciar el análisis
analyze_button = tk.Button(frame, text="Analizar", command=analizar)
analyze_button.pack(pady=10)

# Iniciar el bucle de la interfaz
root.mainloop()
