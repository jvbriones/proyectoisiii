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
 * @author Nicolas_Sanchez
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
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelIcono = new javax.swing.JLabel();
        jLabelCentroMedico1 = new javax.swing.JLabel();
        jLabelIconoAyuda = new javax.swing.JLabel();
        jLabelIconoSalir = new javax.swing.JLabel();
        jLabelAyuda = new javax.swing.JLabel();
        jLabelSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Centro Salud");
        setBackground(new java.awt.Color(255, 204, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(931, 715));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 277));

        jLabelContrasenia.setText("Contraseña:");

        jLabelUsuario1.setText("Usuario:");

        jTextFieldUsuario.setColumns(10);

        jPasswordField1.setColumns(10);
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jLabelError.setForeground(new java.awt.Color(255, 0, 51));
        jLabelError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Error.png"))); // NOI18N
        jLabelError.setText("Usuario o contraseña erróneos");

        jButton1.setText("Entrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelUsuario1)
                            .add(jLabelContrasenia))
                        .add(7, 7, 7)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPasswordField1, 0, 0, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jTextFieldUsuario, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(42, 42, 42)
                        .add(jLabelError))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(121, 121, 121)
                        .add(jButton1)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelUsuario1)
                    .add(jTextFieldUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabelContrasenia)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabelError)
                .add(18, 18, 18)
                .add(jButton1)
                .add(46, 46, 46))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 320, 180));

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Logo-Centro-Medico.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 150));

        jLabelCentroMedico1.setText("Centro Médico");
        getContentPane().add(jLabelCentroMedico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 68, -1, -1));

        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Desactivado.png"))); // NOI18N
        jLabelIconoAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseExited(evt);
            }
        });
        getContentPane().add(jLabelIconoAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, -1, -1));

        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Desactivado.png"))); // NOI18N
        jLabelIconoSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseExited(evt);
            }
        });
        getContentPane().add(jLabelIconoSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        jLabelAyuda.setText("Ayuda");
        getContentPane().add(jLabelAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, -1, -1));

        jLabelSalir.setText("Salir");
        getContentPane().add(jLabelSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 998, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 498, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1000, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabelIconoAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseClicked
        // TODO add your handling code here:
        new Ayuda().setVisible(true);
}//GEN-LAST:event_jLabelIconoAyudaMouseClicked

    private void jLabelIconoAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseEntered
        // TODO add your handling code here:
        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Activado.png"))); // NOI18N
}//GEN-LAST:event_jLabelIconoAyudaMouseEntered

    private void jLabelIconoAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseExited
        // TODO add your handling code here:
        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Desactivado.png"))); // NOI18N
}//GEN-LAST:event_jLabelIconoAyudaMouseExited

    private void jLabelIconoSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_jLabelIconoSalirMouseClicked

    private void jLabelIconoSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseExited
        // TODO add your handling code here:
        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Desactivado.png"))); // NOI18N
}//GEN-LAST:event_jLabelIconoSalirMouseExited

    private void jLabelIconoSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseEntered
        // TODO add your handling code here:
        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Activado.png"))); // NOI18N
}//GEN-LAST:event_jLabelIconoSalirMouseEntered

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
         try {

         ComprobarAcceso();

        } catch (SQLException ex) {
            Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseReleased

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

           
            String nombreUsu = gesUsu.consultarDatosPersonales().get(0).toString();
            String tipoUsu = gesUsu.consultarTipoUsuario();

            
            if( tipoUsu.equals("Paciente")){
                UI_Paciente p = new UI_Paciente(nombre,"Paciente");
                p.setVisible(true);
                this.setVisible(false);

            }
            else if(tipoUsu.equals("Radiologo")){
                UI_Radiologo ra = new UI_Radiologo(nombre,"Radiologo");
                ra.setVisible(true);
             
                this.setVisible(false);
            }
            else{
                UI_Administrador uiAdmin = new UI_Administrador(nombreUsu,"Administrador");
                 uiAdmin.setVisible(true);
                this.setVisible(false);
            }
        }
        //MODIFICADO POR POPE PARA PRUEBAS DESDE AKI
        else if(nombre.equals("Admin") && contrasenia.equals("Admin")){
            UI_Administrador p = new UI_Administrador(nombre,"Admin");
            p.setVisible(true);
            this.setVisible(false);
        }
        //HASTA AQUI MODIFICADO POR POPE PARA PRUEBAS
        else if(nombre.equals("Paci") && contrasenia.equals("Paci")){
            UI_Paciente p = new UI_Paciente(nombre,"Paciente");
            p.setVisible(true);
            this.setVisible(false);
        }
        else if(nombre.equals("Person") && contrasenia.equals("Person")){
            UI_Radiologo p = new UI_Radiologo(nombre,"Personal");
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelAyuda;
    private javax.swing.JLabel jLabelCentroMedico1;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelIconoAyuda;
    private javax.swing.JLabel jLabelIconoSalir;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables

}
