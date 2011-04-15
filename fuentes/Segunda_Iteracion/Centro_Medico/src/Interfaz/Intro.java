/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Intro.java
 *
 * Created on 19-mar-2011, 18:22:02
 */

package Interfaz;

import java.awt.Toolkit;
import Controlador.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolás_Sánchez
 */
public class Intro extends javax.swing.JFrame {

    /** Creates new form Intro */
    public Intro() {
        initComponents();
        jLabelError.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelContrasenia = new javax.swing.JLabel();
        jLabelUsuario1 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelCentroMedico = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelError = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Centro Salud");
        setBackground(new java.awt.Color(255, 204, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(470, 430));
        setPreferredSize(new java.awt.Dimension(460, 410));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 277));

        jLabelContrasenia.setText("Contraseña:");

        jLabelUsuario1.setText("Usuario:");

        jTextFieldUsuario.setColumns(10);
        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });

        jLabelCentroMedico.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        jLabelCentroMedico.setText("Centro Médico");

        jButtonEntrar.setFont(new java.awt.Font("Lucida Grande", 1, 18));
        jButtonEntrar.setForeground(new java.awt.Color(255, 153, 0));
        jButtonEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Entrar.png"))); // NOI18N
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jPasswordField1.setColumns(10);
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jLabelError.setForeground(new java.awt.Color(255, 0, 51));
        jLabelError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Error.png"))); // NOI18N
        jLabelError.setText("Usuario o contraseña erróneos");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(63, 63, 63)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(9, 9, 9)
                                .add(jLabelUsuario1)
                                .add(44, 44, 44))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(jLabelContrasenia)
                                .add(30, 30, 30)))
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextFieldUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(56, 56, 56)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(21, 21, 21)
                                .add(jButtonEntrar))
                            .add(jLabelError))
                        .add(79, 79, 79)))
                .addContainerGap(30, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .add(jLabelCentroMedico)
                .add(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelCentroMedico)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelUsuario1)
                    .add(jTextFieldUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelContrasenia)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(jLabelError)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButtonEntrar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 450, 230));

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Logo-Centro-Medico.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 140, 163));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        try {
            // TODO add your handling code here:
           ComprobarAcceso();

        } catch (SQLException ex) {
            Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER){
            try {
                ComprobarAcceso();
            } catch (SQLException ex) {
                Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuarioActionPerformed

    /**
     * Comprueba que los datos de acceso correspondan a algún usuario
     */
    private void ComprobarAcceso() throws SQLException{
        
        String nombre = jTextFieldUsuario.getText();
        String contrasenia = new String(jPasswordField1.getPassword());
        boolean tieneAcceso = false;
        GestorUsuarios gesUsu = new GestorUsuarios();

        try {
            tieneAcceso = gesUsu.validacionUsuario(nombre, contrasenia);
        } catch (Exception ex) {
            Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
        }


        if(tieneAcceso){
//
            String nombreUsu = gesUsu.consultarDatosPersonales();
            String tipoUsu = gesUsu.consultarTipoUsuario();

            System.out.println(tipoUsu);
            if( tipoUsu.equals("Paciente")){
                UI_Paciente p = new UI_Paciente(nombre,"Paciente");
                p.setVisible(true);
                this.setVisible(false);

            }
            else{
            UI_Administrador uiAdmin = new UI_Administrador(nombreUsu,"Administrador");
            uiAdmin.setVisible(true);
            this.setVisible(false);
            }
        }

        
        else if(nombre.equals("Paci") && contrasenia.equals("Paci")){
            UI_Paciente p = new UI_Paciente(nombre,"Paciente");
            p.setVisible(true);
            this.setVisible(false);
        }
        else if(nombre.equals("Perso") && contrasenia.equals("Perso")){
            UI_Personal p = new UI_Personal(nombre,"Personal");
            p.setVisible(true);
            this.setVisible(false);
        }
        else{
            Toolkit.getDefaultToolkit().beep();
            jLabelError.setVisible(true);
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Intro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JLabel jLabelCentroMedico;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
