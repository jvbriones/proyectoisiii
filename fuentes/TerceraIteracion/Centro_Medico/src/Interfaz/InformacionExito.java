/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InformacionExito.java
 *
 * Created on 03-abr-2011, 23:16:43
 */

package Interfaz;


/**
 * @version     1.1     16/04/2011
 * @author      Sub_Equipo2
 */
public class InformacionExito extends javax.swing.JFrame {

    /** Creates new form InformacionExito */
    public InformacionExito() {
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

        jPanel2 = new javax.swing.JPanel();
        jButtonAceptarInformacion1 = new javax.swing.JButton();
        jLabelInformacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setMaximumSize(new java.awt.Dimension(519, 303));

        jButtonAceptarInformacion1.setText("Aceptar");
        jButtonAceptarInformacion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceptarInformacion1MouseClicked(evt);
            }
        });

        jLabelInformacion.setFont(new java.awt.Font("Lucida Grande", 1, 24));
        jLabelInformacion.setForeground(new java.awt.Color(0, 153, 0));
        jLabelInformacion.setText("Su operación se ha realizado con éxito");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelInformacion)
                .addContainerGap(28, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .add(jButtonAceptarInformacion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(196, 196, 196))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelInformacion)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                .add(jButtonAceptarInformacion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(47, 47, 47))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarInformacion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarInformacion1MouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
}//GEN-LAST:event_jButtonAceptarInformacion1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarInformacion1;
    private javax.swing.JLabel jLabelInformacion;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
