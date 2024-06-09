/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FrmPrincipal extends javax.swing.JFrame {

    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEntrada = new javax.swing.JTextField();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtEntrada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btnAnalizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizar.setText("TOKENS");
        btnAnalizar.setToolTipText("");
        btnAnalizar.setActionCommand("TOKENS");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEntrada)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnalizar)
                        .addGap(166, 166, 166))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
   // Crea un objeto File para representar un archivo llamado "archivo.txt".
File archivo = new File("archivo.txt");
PrintWriter escribir;

try {
    // Inicializa PrintWriter para escribir en el archivo especificado.
    escribir = new PrintWriter(archivo);
    // Toma el texto ingresado en el campo txtEntrada de la GUI y lo escribe en el archivo.
    escribir.print(txtEntrada.getText());
    // Cierra PrintWriter, asegurando que todos los datos se hayan escrito en el archivo y liberando recursos.
    escribir.close();
} catch (FileNotFoundException ex) {
    // Registra un error severo en el log si el archivo no puede ser creado o encontrado.
    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
}

try {
    // Crea un Reader para leer el archivo "archivo.txt". Se usa BufferedReader para optimizar la lectura.
    Reader lector = new BufferedReader(new FileReader("archivo.txt"));
    // Crea una instancia de Lexer pasando el lector, preparándolo para analizar el archivo.
    Lexer lexer = new Lexer(lector);
    // Inicializa una cadena para acumular los resultados del análisis.
    String resultado = "";
    
    // Bucle infinito para leer y analizar tokens hasta que no haya más (hasta que tokens sea null).
    while (true) {
        // Llama a yylex() del Lexer para obtener el siguiente token del texto.
        Tokens tokens = lexer.yylex();
        // Si no hay más tokens (tokens es null), añade "FIN" al resultado y muestra el resultado en txtResultado.
        if (tokens == null) {
            resultado += "FIN";
            txtResultado.setText(resultado);
            return; // Sale del método.
        }
        
        // Evalúa el tipo de token obtenido y forma una cadena descriptiva correspondiente.
        switch (tokens) {
            case ERROR:
                // Si el token es de tipo ERROR, añade una cadena indicando que hay un símbolo no definido.
                resultado += "Símbolo no definido\n";
                break;
            case PALABRA:
            case NUMERO:
            case RESERVADA:
                // Si el token es una PALABRA, NUMERO o RESERVADA, añade el lexema y su tipo al resultado.
                resultado += lexer.lexeme + ": Es una " + tokens + "\n";
                break;
            default:
                // Para cualquier otro tipo de token, simplemente añade el tipo de token al resultado.
                resultado += "Token: " + tokens + "\n";
                break;
        }
    }
} catch (FileNotFoundException ex) {
    // Maneja la excepción si el archivo "archivo.txt" no se encuentra.
    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    // Maneja excepciones de I/O que puedan ocurrir durante la lectura del archivo.
    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
