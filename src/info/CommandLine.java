package info;

import java.awt.Event;
import java.awt.event.KeyEvent;

public class CommandLine extends javax.swing.JFrame {
    String archivo;
    String cuerda;
    AFD comandos=new AFD();
    int cont=0;
    
    public CommandLine() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Command Line");
        setBackground(java.awt.Color.black);

        textField1.setBackground(java.awt.Color.black);
        textField1.setFont(new java.awt.Font("Gulim", 0, 14)); // NOI18N
        textField1.setForeground(java.awt.Color.white);
        textField1.setText("Ingrese nombre del archivo de configuracion...");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });
        textField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textField1KeyPressed(evt);
            }
        });

        jTextArea1.setBackground(java.awt.Color.black);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Gulim", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void textField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textField1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cont==0) {
                archivo = textField1.getText();
                comandos.readAdd(archivo);
                cont++;
                jTextArea1.append("ARCHIVO " + archivo + " CARGADO CORRECTAMENTE\n");
                jTextArea1.append("INGRESE SUS CUERDAS\n");
                textField1.selectAll();
            }
            else if (cont>0) {
                cuerda = textField1.getText();
                if (comandos.pasoOne(cuerda)) {
                    if (comandos.pasoTwo(cuerda)) {
                        jTextArea1.append("CUERDA: " + cuerda + ": ACEPTADA\n");
                        textField1.selectAll();
                    }
                    else {
                        jTextArea1.append("CUERDA: " + cuerda + ": NO ACEPTADA\n");
                        textField1.selectAll();
                    }
                } else {
                    jTextArea1.append("CUERDA: " + cuerda + ": NO ACEPTADA\n");
                    textField1.selectAll();
                }
            }
        }    
    }//GEN-LAST:event_textField1KeyPressed
    
    /*public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (e.getSource()==textField1) {
            if (key==KeyEvent.VK_ENTER) {
                if (cont==0) {
                    archivo = textField1.getText();
                    comandos.readAdd(archivo);
                    cont++;
                    jTextArea1.append(cuerda + "\n");
                    textField1.selectAll();
                }
                else if (cont>0) {
                    cuerda = textField1.getText();
                    if (comandos.pasoOne(cuerda)) {
                        if (comandos.pasoTwo(cuerda))
                            jTextArea1.append(cuerda + ": ACEPTADA\n");
                        else
                            jTextArea1.append(cuerda + ": no ACEPTADA\n");
                    }
                }
            }    
        }
    }*/
    
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
            java.util.logging.Logger.getLogger(CommandLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CommandLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CommandLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CommandLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CommandLine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
