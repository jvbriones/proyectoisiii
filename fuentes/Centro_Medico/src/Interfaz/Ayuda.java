/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ayuda.java
 *
 * Created on 20-mar-2011, 20:57:27
 */

package Interfaz;

/**
 *
 * @author fran_gestion
 */
public class Ayuda extends javax.swing.JFrame {

    /** Creates new form Ayuda */
    public Ayuda() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setLocation(new java.awt.Point(320, 200));
        setPreferredSize(new java.awt.Dimension(650, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 300));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        jLabel1.setText("v. 0.4");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(260, 86, 66, 39);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24));
        jLabel2.setText("Centro de Salud");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(202, 39, 196, 39);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Logo-Centro-Medico.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 20, 139, 173);

        jLabel4.setText("Licencia:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 180, 60, 16);

        jLabel5.setText("Este es un software libre, por lo que tiene licencia");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 200, 320, 16);

        jLabel6.setText("GNU GPL v3.0");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(210, 220, 110, 16);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ayuda().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
