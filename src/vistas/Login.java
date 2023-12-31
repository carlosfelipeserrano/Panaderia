/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import clases.Consulta;
import clases.Hash;
import clases.Usuarios;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public static String dato;
    int xMouse, yMouse;
    int intentos;

    public Login() {
        intentos = 0;
        initComponents();

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        loginBtn = new javax.swing.JButton();
        header1 = new javax.swing.JPanel();
        exitbtn2 = new javax.swing.JPanel();
        exitTxt2 = new javax.swing.JLabel();
        exitbtn3 = new javax.swing.JPanel();
        exitTxt3 = new javax.swing.JLabel();
        Ver = new javax.swing.JLabel();
        Ocultar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtusu = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtpass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logotipo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 110));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Inicie Sesión");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ingrese Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ingrese Usuario");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jPanel2.setBackground(new java.awt.Color(226, 173, 97));
        jPanel2.setPreferredSize(new java.awt.Dimension(120, 40));

        loginBtn.setBackground(new java.awt.Color(226, 173, 97));
        loginBtn.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(0, 0, 0));
        loginBtn.setText("Acceder");
        loginBtn.setBorder(null);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 100, -1));

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
                .addContainerGap(736, Short.MAX_VALUE)
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

        jPanel1.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 30));

        Ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ver_32px.png"))); // NOI18N
        Ver.setToolTipText("");
        Ver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VerMouseClicked(evt);
            }
        });
        jPanel1.add(Ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 30, 40));

        Ocultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ocultar_32px.png"))); // NOI18N
        Ocultar.setToolTipText("");
        Ocultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OcultarMouseClicked(evt);
            }
        });
        jPanel1.add(Ocultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, 30, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondologo.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 320, 380));

        txtusu.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        txtusu.setBorder(null);
        jPanel1.add(txtusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 350, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 350, 10));

        txtpass.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        txtpass.setBorder(null);
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 350, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 350, 10));

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

        Usuarios mod = new Usuarios();
        Consulta con = new Consulta();

        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String pass = new String(txtpass.getPassword());

        if (!txtusu.getText().isEmpty() && !pass.isEmpty()) {
            mod.setUsuario(txtusu.getText());
            String contraseña = Hash.md5(pass);
            mod.setContrasena(contraseña);

            mod.setUltima_sesion(fechaHora.format(date));

            if (con.login(mod)) {
                this.dispose();
                switch (mod.getIdtipo()) {
                    case 1: {
                        try {
                            dato = txtusu.getText();
                            MenuDueño f1 = new MenuDueño();
                            f1.setVisible(true);
                            break;
                        } catch (SQLException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    case 2: {
                        dato = txtusu.getText();

                        Menu f1 = new Menu();
                        f1.setVisible(true);
                        break;
                    }

                    case 3: {
                        DatosCliente f1 = new DatosCliente();
                        f1.setVisible(true);
                        break;
                    }

                    default: {
                        // En caso de que el tipo de usuario no coincida con ninguno de los valores esperados
                        JOptionPane.showMessageDialog(this, "Tipo de usuario inválido", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            } else {
                intentos++;
                if (intentos == 5) {
                    JOptionPane.showMessageDialog(null, "Has excedido el número de intentos para el ingreso al sistema. Contáctese con el Administrador/a", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Estimado Usuario ingrese correctamente sus credenciales, intenta nuevamente \n Quedan " + (5 - intentos) + " Intentos. Contáctese con el Administrador/a ", "Accediendo al sistema", JOptionPane.ERROR_MESSAGE);
                    txtusu.setText("");
                    txtpass.setText("");
                    txtusu.requestFocus();
                }
            }
        }


    }//GEN-LAST:event_loginBtnActionPerformed

    private void OcultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OcultarMouseClicked
        // TODO add your handling code here:
        Ver.setVisible(true);
        Ocultar.setVisible(false);
        txtpass.setEchoChar('*');
    }//GEN-LAST:event_OcultarMouseClicked

    private void VerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VerMouseClicked
        // TODO add your handling code here:
        Ver.setVisible(false);
        Ocultar.setVisible(true);
        txtpass.setEchoChar((char) 0);
    }//GEN-LAST:event_VerMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Ocultar;
    private javax.swing.JLabel Ver;
    private javax.swing.JLabel exitTxt2;
    private javax.swing.JLabel exitTxt3;
    private javax.swing.JPanel exitbtn2;
    private javax.swing.JPanel exitbtn3;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables
}
