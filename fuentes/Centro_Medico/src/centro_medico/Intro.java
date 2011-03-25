/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Intro.java
 *
 * Created on 19-mar-2011, 18:22:02
 */

package centro_medico;

import java.awt.Toolkit;

/**
 *
 * @author fran_gestion
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
        setLocation(new java.awt.Point(400, 200));
        setMinimumSize(new java.awt.Dimension(470, 430));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 277));

        jLabelContrasenia.setText("Contraseña:");

        jLabelUsuario1.setText("Usuario:");

        jTextFieldUsuario.setColumns(10);

        jLabelCentroMedico.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        jLabelCentroMedico.setText("Centro Médico");

        jButtonEntrar.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(255, 153, 0));
        jButtonEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesIntro/Entrar.png"))); // NOI18N
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
        jLabelError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesIntro/Error.png"))); // NOI18N
        jLabelError.setText("Usuario o contraseña erróneos");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(87, 87, 87)
                        .add(jLabelUsuario1)
                        .add(44, 44, 44))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabelContrasenia)
                        .add(30, 30, 30)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextFieldUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .add(jLabelCentroMedico)
                .add(166, 166, 166))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .add(jButtonEntrar)
                .add(134, 134, 134))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .add(jLabelError)
                .add(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jLabelCentroMedico)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelUsuario1)
                    .add(jTextFieldUsuario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelContrasenia)
                    .add(jPasswordField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelError)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                .add(jButtonEntrar)
                .add(9, 9, 9))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 470, 240));

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesIntro/Logo-Centro-Medico.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 20, -1, 163));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        // TODO add your handling code here:
        ComprobarAcceso();
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== java.awt.event.KeyEvent.VK_ENTER){
                ComprobarAcceso();
        }
    }//GEN-LAST:event_jPasswordField1KeyPressed


    private void ComprobarAcceso(){
        String nombre = jTextFieldUsuario.getText();
        String contrasenia = new String(jPasswordField1.getPassword());
        if(nombre.equals("Admin") && contrasenia.equals("Admin") ){
            UI_Administrador a = new UI_Administrador(nombre,"Administrador");
            a.setVisible(true);
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
