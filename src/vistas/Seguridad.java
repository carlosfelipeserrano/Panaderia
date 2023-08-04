/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import clases.Consulta;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Seguridad extends javax.swing.JFrame {

    static Object frmLog;

    /**
     * Creates new form Seguridad
     */
    int xMouse, yMouse;
    int intentos;

    public Seguridad() {
        initComponents();
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        header1 = new javax.swing.JPanel();
        exitbtn2 = new javax.swing.JPanel();
        exitTxt2 = new javax.swing.JLabel();
        exitbtn3 = new javax.swing.JPanel();
        exitTxt3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtpassword = new javax.swing.JPasswordField();
        jspassword = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 120));

        header1.setBackground(new java.awt.Color(0, 0, 0));
        header1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header1MouseDragged(evt);
            }
        });
        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                header1MouseReleased(evt);
            }
        });

        exitbtn2.setBackground(new java.awt.Color(0, 0, 0));
        exitbtn2.setForeground(new java.awt.Color(0, 0, 0));

        exitTxt2.setBackground(new java.awt.Color(255, 255, 255));
        exitTxt2.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt2.setForeground(new java.awt.Color(255, 255, 255));
        exitTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt2.setText("X");
        exitTxt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt2.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxt2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxt2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxt2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitbtn2Layout = new javax.swing.GroupLayout(exitbtn2);
        exitbtn2.setLayout(exitbtn2Layout);
        exitbtn2Layout.setHorizontalGroup(
            exitbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(exitbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitbtn2Layout.createSequentialGroup()
                    .addComponent(exitTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        exitbtn2Layout.setVerticalGroup(
            exitbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(exitbtn2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(exitbtn2Layout.createSequentialGroup()
                    .addComponent(exitTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );

        exitbtn3.setBackground(new java.awt.Color(0, 0, 0));

        exitTxt3.setBackground(new java.awt.Color(255, 255, 255));
        exitTxt3.setFont(new java.awt.Font("Roboto Light", 0, 48)); // NOI18N
        exitTxt3.setForeground(new java.awt.Color(255, 255, 255));
        exitTxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt3.setText("-");
        exitTxt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitTxt3.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxt3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxt3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxt3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitbtn3Layout = new javax.swing.GroupLayout(exitbtn3);
        exitbtn3.setLayout(exitbtn3Layout);
        exitbtn3Layout.setHorizontalGroup(
            exitbtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );
        exitbtn3Layout.setVerticalGroup(
            exitbtn3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addContainerGap(516, Short.MAX_VALUE)
                .addComponent(exitbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exitbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGroup(header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitbtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "*Ingrese Contraseña*", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtpassword.setBackground(new java.awt.Color(0, 0, 0));
        txtpassword.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txtpassword.setForeground(new java.awt.Color(0, 0, 0));
        txtpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpassword.setBorder(null);

        jPanel3.setBackground(new java.awt.Color(226, 173, 97));
        jPanel3.setPreferredSize(new java.awt.Dimension(120, 40));

        loginBtn.setBackground(new java.awt.Color(226, 173, 97));
        loginBtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(0, 0, 0));
        loginBtn.setText("Acceder");
        loginBtn.setBorder(null);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnMouseExited(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jspassword)
                    .addComponent(txtpassword, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspassword, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 260, 120));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contáctese  con el Dueño para Acceder");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 230, 20));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seguridad.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt2MouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.YES_NO_OPTION;
        int resultado = JOptionPane.showConfirmDialog(this, "¿DESEA CERRAR EL PROGRAMA?", "CERRAR PROGRAMAR", a);
        if (resultado == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitTxt2MouseClicked

    private void exitTxt2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt2MouseEntered
        // TODO add your handling code here:
        exitbtn2.setBackground(Color.red);
        exitTxt2.setForeground(Color.black);
    }//GEN-LAST:event_exitTxt2MouseEntered

    private void exitTxt2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt2MouseExited
        // TODO add your handling code here:
        exitbtn2.setBackground(Color.black);
        exitTxt2.setForeground(Color.white);
    }//GEN-LAST:event_exitTxt2MouseExited

    private void exitTxt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt3MouseClicked
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_exitTxt3MouseClicked

    private void exitTxt3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt3MouseEntered
        // TODO add your handling code here:

        exitbtn3.setBackground(Color.gray);
        exitTxt3.setForeground(Color.black);
    }//GEN-LAST:event_exitTxt3MouseEntered

    private void exitTxt3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxt3MouseExited
        // TODO add your handling code here:
        exitbtn3.setBackground(Color.black);
        exitTxt3.setForeground(Color.white);
    }//GEN-LAST:event_exitTxt3MouseExited

    private void header1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_header1MouseDragged

    private void header1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MousePressed
        // TODO add your handling code here:
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_header1MousePressed

    private void header1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_header1MouseReleased

    private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_loginBtnMouseEntered

    private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnMouseExited

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        Consulta con = new Consulta();
        if (txtpassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Contraseña");
        } else {
            try {
                if (con.seguridad(txtpassword.getText())) {
                    this.setVisible(false);
                    Login f1 = new Login();
                    f1.setVisible(true);
                    dispose();
                } else {
                    intentos++;
                    if (intentos == 5) {
                        JOptionPane.showMessageDialog(null, "Has excedido el número de intentos para el ingreso al sistema. Contáctese con el Dueño para Acceder", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intenta nuevamente \n Quedan " + (5 - intentos) + " Intentos. Contáctese con el Dueño para Acceder ", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);
                        txtpassword.setText("");
                        txtpassword.requestFocus();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_loginBtnActionPerformed

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        // TODO add your handling code here:

        /*if (txtpassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese Contraseña");
        } else {
            Consulta con = new Consulta();
            con.seguridad(txtpassword.getText());
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Panadería Donde Carlitos", "Mensaje de Bienvenida", JOptionPane.INFORMATION_MESSAGE);

            Login f1 = new Login();
            f1.setVisible(true);

        }*/

 /*if (c.equals("Alaz123++")) {
            dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de Panadería Donde Carlitos", "Mensaje de Bienvenida", JOptionPane.INFORMATION_MESSAGE);
            Login f1 = new Login();
            f1.setVisible(true);
        } else if (intentos == 3) {
            JOptionPane.showMessageDialog(null, "Has excedido el número de intentos para el ingreso al sistema. Contactese con el Dueño para Acceder", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta, intenta nuevamente \n Quedan " + (3 - intentos) + " Intentos. Contactese con el Dueño para Acceder ", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);

            txtpassword.setText("");
            txtpassword.requestFocus();
            intentos = intentos + 1;
        }*/

    }//GEN-LAST:event_loginBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seguridad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seguridad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exitTxt2;
    private javax.swing.JLabel exitTxt3;
    private javax.swing.JPanel exitbtn2;
    private javax.swing.JPanel exitbtn3;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jspassword;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
