/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InformacionExito.java
 *
 * Created on 03-abr-2011, 12:54:04
 */

package Interfaz;

/**
 *
 * @author fran_gestion
 */
public class InformacionExito extends javax.swing.JPanel {

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

        jButtonAceptarInformacion = new javax.swing.JButton();
        jLabelInformacion = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 102));
        setMaximumSize(new java.awt.Dimension(519, 303));
        setSize(new java.awt.Dimension(519, 303));

        jButtonAceptarInformacion.setText("Aceptar");

        jLabelInformacion.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabelInformacion.setForeground(new java.awt.Color(0, 153, 0));
        jLabelInformacion.setText("Su operación se ha realizado con éxito");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabelInformacion))
                    .add(layout.createSequentialGroup()
                        .add(186, 186, 186)
                        .add(jButtonAceptarInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelInformacion)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                .add(jButtonAceptarInformacion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptarInformacion;
    private javax.swing.JLabel jLabelInformacion;
    // End of variables declaration//GEN-END:variables

}
