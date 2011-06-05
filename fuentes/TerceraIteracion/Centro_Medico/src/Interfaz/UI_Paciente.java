/*
 * Principal_Administrador.java
 *
 * Created on 16-mar-2011, 18:27:18
 */

package Interfaz;

import java.awt.Image;
import javax.swing.*;
import Controlador.*;
import CentroMedico.*;
import BaseDatos.*;
import java.awt.Color;
import java.util.Calendar.*;
import java.util.Calendar;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * @author Nicolas_Sanchez
 * @author Juan_Cabrera
 */
public class UI_Paciente extends javax.swing.JFrame {

    private Usuario user;
    private GestorPacientes gstPac;
    private GestorPruebas gstPru;
    private GestorCitas gstCit;
    private GestorUsuarios gstUsu;
    private DefaultListModel modelo = new DefaultListModel();

    /** Creates new form Principal_Administrador */
    public UI_Paciente() {
        initComponents();
        pasoAtras = false;
        gstPac = new GestorPacientes();
        gstPru = new GestorPruebas();
        gstCit = new GestorCitas();
        gstUsu = new GestorUsuarios();
    }

    public UI_Paciente(Usuario usu, String tipoUsuario) throws SQLException,Exception{
        initComponents();

        //Iniciar el objeto usuario y gestores
        user = usu;
        gstPac = new GestorPacientes();
        gstPru = new GestorPruebas();
        gstCit = new GestorCitas();
        gstUsu = new GestorUsuarios();
        pasoAtras=false;

        /**Ponemos las etiquetas del usuario que ha entrado*/
        jLabelNombreUsuario.setText(usu.getNombre());
        jLabelTipoUsuario.setText(tipoUsuario);

        /**Mostramos el panel Principal*/
        mostrarPanel("Principal");
        mostrarDatosPaciente(usu);

        /** Conectamos con la BD y tomamos los datos del paciente*/

        /**Ponemos icono de paciente logueado*/
        jLabelTipoUsuarioIdentificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Tipo-Usuario-Paciente.png"))); // NOI18N
    }

    private void mostrarDatosPaciente(Usuario usu) throws SQLException,Exception{

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(usu.getFecNac());
        int dia = calendar.get(Calendar.DAY_OF_MONTH);   //dia del mes
        int mes = calendar.get(Calendar.MONTH);
        mes=mes+1;//mes, de 0 a 11
        int anio = calendar.get(Calendar.YEAR);  //año

        String num_dia= String.valueOf(dia);
        String num_mes= String.valueOf(mes);
        String num_anio= String.valueOf(anio);

        sfotografia=usu.getFoto();
        //Codigo para cargar la imagen del usuario en el formulario
        try{
            
            ImageIcon icono = new ImageIcon(usu.getFoto());
            Image imagen = icono.getImage();
            ImageIcon aescala = new ImageIcon(imagen.getScaledInstance(150,150,Image.SCALE_SMOOTH));
             jLabelFotoPaciente.setIcon(aescala); // NOI18N
        }
        catch(Exception ex){
            System.err.print("Error al leer el archivo");
        }
        System.out.println("Esto entra y poque fala..");
        
        
        //jTextFieldFechaNacimientoAnioPaciente.setText(num_anio);
        //jTextFieldFechaNacimientoDiaPaciente.setText(num_dia);
        //jTextFieldFechaNacimientoMesPaciente.setText(num_mes);
        jTextFieldNombrePaciente.setText(usu.getNombre());
        jTextFieldContraseniaPaciente.setText(AES.decrypt(usu.getContrasenia()));
        jTextFieldDNIPaciente.setText(usu.getDNI());
        jTextFieldApellidosPaciente.setText(usu.getApellidos());
        jTextFieldTelefonoPaciente.setText(usu.getTelefono());
        jTextFieldDireccionPaciente.setText(usu.getDireccion());
        jTextFieldEmailPaciente.setText(usu.getEmail());
        jTextFieldLugarNacimientoPaciente.setText(usu.getLugarNac());
        jTextFieldDNIPaciente.setEditable(false);
    }

    private void cargarDatosCitaPaciente( Usuario usu )throws SQLException{

       /* CitaBD cita_bd=new CitaBD();
        Cita nueva_cita = null;
        boolean existe;

        Paciente pac = (Paciente) usu;
        existe=cita_bd.ExisteCita(pac);

        if(existe){
            nueva_cita = cita_bd.ObtenerCita(pac);

            Date fecha = null;
            int dia = fecha.getDay();
            int mes = fecha.getMonth();
            ++mes;
            int anio = fecha.getYear();  //año

            String num_dia= String.valueOf(dia);
            String num_mes= String.valueOf(mes);
            String num_anio= String.valueOf(anio);

          //  jTextFieldDNIMedico.setText(nueva_cita.getPersonalMedico().getDNI());
          //  jTextFieldDNIPacienteCita.setText(nueva_cita.getPaciente().getDNI());
            jTextFieldAnioCita.setText(num_anio);
            jTextFieldDiaCita.setText(num_dia);
            jTextFieldMesCita.setText(num_mes);


             //la hora de la cita no está implementada


        }
           


*/
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCentroMedico = new javax.swing.JLabel();
        jLabelIconoInicio = new javax.swing.JLabel();
        jLabelInicio = new javax.swing.JLabel();
        jLabelIconoAyuda = new javax.swing.JLabel();
        jLabelIconoSalir = new javax.swing.JLabel();
        jLabelAyuda = new javax.swing.JLabel();
        jLabelSalir = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();
        ZonaTrabajo = new javax.swing.JLayeredPane();
        jPanelPrincipal = new javax.swing.JPanel();
        jButtonGestionarPaciente = new javax.swing.JButton();
        jLabelGestionarPaciente3 = new javax.swing.JLabel();
        jLabelGestionarCita1 = new javax.swing.JLabel();
        jButtonGestionarCita = new javax.swing.JButton();
        jButtonConsultarRecetas = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonGestionarHistorial = new javax.swing.JButton();
        jButtonConsultarPruebas = new javax.swing.JButton();
        jButtonGestionarCitass = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jPanelConsultarHistorial = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButtonConsPrueba = new javax.swing.JButton();
        jButtonConsReceta = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jPanelVerPruebas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jButtonVerPrueba = new javax.swing.JButton();
        jPanelGestionarCitaOnline = new javax.swing.JPanel();
        jLabelGestionarPaciente5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaInfo1 = new javax.swing.JTextArea();
        jPanelAltaCita = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonAceptarCita = new javax.swing.JButton();
        jPanelBotones = new javax.swing.JPanel();
        jButtonConsultarCita1 = new javax.swing.JButton();
        jButtonPedirAltaCita = new javax.swing.JButton();
        jPanelConsultarCitaOnline = new javax.swing.JPanel();
        jTextFieldMesCita = new javax.swing.JTextField();
        jButtonMenosAnioPersonal = new javax.swing.JButton();
        jButtonMasAnioFecha = new javax.swing.JButton();
        jTextFieldAnioCita = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldDiaCita = new javax.swing.JTextField();
        jButtonMasMesFecha = new javax.swing.JButton();
        jButtonMasDiaFecha = new javax.swing.JButton();
        jButtonModificarCitaOnline = new javax.swing.JButton();
        jButtonMenosDiaFecha = new javax.swing.JButton();
        jButtonMenosMesFecha = new javax.swing.JButton();
        jLabelGestionarPaciente2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jButtonMasHora = new javax.swing.JButton();
        jButtonMasMinuto = new javax.swing.JButton();
        jTextFieldHoraCita = new javax.swing.JTextField();
        jTextFieldMinutoCita = new javax.swing.JTextField();
        jButtonMenosHora = new javax.swing.JButton();
        jButtonMenosMinuto = new javax.swing.JButton();
        jLabelHoraCita = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInfo = new javax.swing.JTextArea();
        jButtonCancelar = new javax.swing.JButton();
        jLabelFecha1 = new javax.swing.JLabel();
        jLabelFecha2 = new javax.swing.JLabel();
        jTextFieldDNIMedico = new javax.swing.JTextField();
        jTextFieldDNIPacienteCita = new javax.swing.JTextField();
        jPanelGestionarPaciente = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabelGestionarPaciente4 = new javax.swing.JLabel();
        jTextFieldNombrePaciente = new javax.swing.JTextField();
        jLabelFotoPaciente = new javax.swing.JLabel();
        jTextFieldTelefonoPaciente = new javax.swing.JTextField();
        jLabelContraseniaPaciente = new javax.swing.JLabel();
        jTextFieldDNIPaciente = new javax.swing.JTextField();
        jLabelNombrePaciente = new javax.swing.JLabel();
        jLabelFotografiaPaciente = new javax.swing.JLabel();
        jLabelDNIPaciente = new javax.swing.JLabel();
        jTextFieldLugarNacimientoPaciente = new javax.swing.JTextField();
        jLabelTelefonoPaciente = new javax.swing.JLabel();
        jLabelLugarNacimientoPaciente = new javax.swing.JLabel();
        jLabelDireccionPaciente = new javax.swing.JLabel();
        jLabelApellidosPaciente = new javax.swing.JLabel();
        jTextFieldApellidosPaciente = new javax.swing.JTextField();
        jLabelEmailPaciente = new javax.swing.JLabel();
        jTextFieldDireccionPaciente = new javax.swing.JTextField();
        jTextFieldEmailPaciente = new javax.swing.JTextField();
        jTextFieldContraseniaPaciente = new javax.swing.JTextField();
        jLabelFechaNacimientoPaciente = new javax.swing.JLabel();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jButtonModificarPaciente = new javax.swing.JButton();
        jPanelVerRecetas = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabelGestionarPaciente7 = new javax.swing.JLabel();
        jLabelListaRecetas = new javax.swing.JLabel();
        jLabelMedico = new javax.swing.JLabel();
        jLabelFechaReceta = new javax.swing.JLabel();
        jButtonConsultarReceta = new javax.swing.JButton();
        jLabelMedico1 = new javax.swing.JLabel();
        jPanelConsultarReceta = new javax.swing.JPanel();
        jLabelInformacionDetalladaReceta = new javax.swing.JLabel();
        jLabelInstruccionReceta = new javax.swing.JLabel();
        jButtonVolverReceta = new javax.swing.JButton();
        jLabelJuicioReceta = new javax.swing.JLabel();
        jLabelMedicoReceta = new javax.swing.JLabel();
        jLabelDNIMedicoReceta = new javax.swing.JLabel();
        jLabelNombreMedicoReceta = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelEmailMedicoReceta = new javax.swing.JLabel();
        jLabel18FechaReceta = new javax.swing.JLabel();
        jTextFieldDNIMedicoReceta = new javax.swing.JTextField();
        jTextFieldNombreMedicoReceta = new javax.swing.JTextField();
        jTextFieldTelefonoMedicoReceta = new javax.swing.JTextField();
        jTextFieldEmailMedicoReceta = new javax.swing.JTextField();
        jTextFieldFechaReceta = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList();
        jLabel46 = new javax.swing.JLabel();
        jPanelPruebaRadiologia = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jLabel39 = new javax.swing.JLabel();
        jPanelPruebaAnalista = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList();
        jLabel32 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jPanelVerCita = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList();
        jButtonConsCita = new javax.swing.JButton();
        jPanelDetalleCita = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelTipoUsuario = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelTipoUsuarioIdentificado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));
        setMinimumSize(new java.awt.Dimension(931, 715));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabelCentroMedico.setText("Centro Médico");
        getContentPane().add(jLabelCentroMedico);
        jLabelCentroMedico.setBounds(177, 68, 110, 14);

        jLabelIconoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Inicio-Desactivado.png"))); // NOI18N
        jLabelIconoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconoInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconoInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconoInicioMouseExited(evt);
            }
        });
        getContentPane().add(jLabelIconoInicio);
        jLabelIconoInicio.setBounds(420, 70, 44, 47);

        jLabelInicio.setText("Inicio");
        getContentPane().add(jLabelInicio);
        jLabelInicio.setBounds(420, 120, 44, 14);

        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Desactivado.png"))); // NOI18N
        jLabelIconoAyuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconoAyudaMouseEntered(evt);
            }
        });
        getContentPane().add(jLabelIconoAyuda);
        jLabelIconoAyuda.setBounds(500, 70, 44, 47);

        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Desactivado.png"))); // NOI18N
        jLabelIconoSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelIconoSalirMouseEntered(evt);
            }
        });
        getContentPane().add(jLabelIconoSalir);
        jLabelIconoSalir.setBounds(580, 70, 43, 47);

        jLabelAyuda.setText("Ayuda");
        getContentPane().add(jLabelAyuda);
        jLabelAyuda.setBounds(500, 120, 44, 14);

        jLabelSalir.setText("Salir");
        getContentPane().add(jLabelSalir);
        jLabelSalir.setBounds(590, 120, 40, 14);

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Intro/Logo-Centro-Medico.png"))); // NOI18N
        getContentPane().add(jLabelIcono);
        jLabelIcono.setBounds(20, 17, 140, 150);

        ZonaTrabajo.setMinimumSize(new java.awt.Dimension(902, 520));
        ZonaTrabajo.setPreferredSize(new java.awt.Dimension(912, 530));

        jPanelPrincipal.setAlignmentX(1.0F);
        jPanelPrincipal.setAlignmentY(0.0F);
        jPanelPrincipal.setMinimumSize(new java.awt.Dimension(900, 530));
        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(901, 531));

        jButtonGestionarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Paciente.png"))); // NOI18N
        jButtonGestionarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGestionarPacienteMouseClicked(evt);
            }
        });
        jButtonGestionarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarPacienteActionPerformed(evt);
            }
        });

        jLabelGestionarPaciente3.setText("Consultar Datos Personales");

        jLabelGestionarCita1.setText("Gestionar Cita Online");

        jButtonGestionarCita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Cita.png"))); // NOI18N
        jButtonGestionarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGestionarCitaMouseClicked(evt);
            }
        });
        jButtonGestionarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarCitaActionPerformed(evt);
            }
        });

        jButtonConsultarRecetas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/RealizarReceta.png"))); // NOI18N
        jButtonConsultarRecetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsultarRecetasMouseClicked(evt);
            }
        });
        jButtonConsultarRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarRecetasActionPerformed(evt);
            }
        });

        jLabel9.setText("Ver Recetas");

        jLabel11.setText("Ver Pruebas");

        jLabel12.setText("Consultar Información Clínica");

        jButtonGestionarHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/carpeta.png"))); // NOI18N
        jButtonGestionarHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGestionarHistorialMouseClicked(evt);
            }
        });
        jButtonGestionarHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarHistorialActionPerformed(evt);
            }
        });

        jButtonConsultarPruebas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/prueba.png"))); // NOI18N
        jButtonConsultarPruebas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsultarPruebasMouseClicked(evt);
            }
        });
        jButtonConsultarPruebas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPruebasActionPerformed(evt);
            }
        });

        jButtonGestionarCitass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Citas.png"))); // NOI18N
        jButtonGestionarCitass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGestionarCitassMouseClicked(evt);
            }
        });
        jButtonGestionarCitass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionarCitassActionPerformed(evt);
            }
        });

        jLabel45.setText("Ver Citas");

        org.jdesktop.layout.GroupLayout jPanelPrincipalLayout = new org.jdesktop.layout.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelPrincipalLayout.createSequentialGroup()
                .add(87, 87, 87)
                .add(jLabel11)
                .addContainerGap(756, Short.MAX_VALUE))
            .add(jPanelPrincipalLayout.createSequentialGroup()
                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(39, 39, 39)
                        .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jButtonGestionarPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jButtonConsultarPruebas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(59, 59, 59)
                        .add(jLabelGestionarPaciente3)))
                .add(137, 137, 137)
                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(jLabelGestionarCita1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 249, Short.MAX_VALUE)
                        .add(jLabel9)
                        .add(87, 87, 87))
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jButtonGestionarCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jButtonGestionarHistorial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelPrincipalLayout.createSequentialGroup()
                                .add(17, 17, 17)
                                .add(jLabel12)))
                        .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelPrincipalLayout.createSequentialGroup()
                                .add(121, 121, 121)
                                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jButtonConsultarRecetas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(jButtonGestionarCitass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel45)
                                .add(92, 92, 92))))))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelPrincipalLayout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jButtonConsultarRecetas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButtonGestionarCita, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButtonGestionarPaciente, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(18, 18, 18)
                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelGestionarPaciente3)
                    .add(jLabelGestionarCita1)
                    .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(69, 69, 69)
                .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(jButtonGestionarCitass)
                        .add(18, 18, 18)
                        .add(jLabel45))
                    .add(jPanelPrincipalLayout.createSequentialGroup()
                        .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButtonConsultarPruebas)
                            .add(jButtonGestionarHistorial))
                        .add(18, 18, 18)
                        .add(jPanelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel11))))
                .add(104, 104, 104))
        );

        jPanelPrincipal.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelConsultarHistorial.setMinimumSize(new java.awt.Dimension(900, 530));
        jPanelConsultarHistorial.setPreferredSize(new java.awt.Dimension(900, 530));

        jLabel23.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel23.setText("Fecha detección");

        jLabel24.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel24.setText("Consultar Información Clínica");

        jLabel25.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel25.setText("Nombre");

        jLabel26.setFont(new java.awt.Font("Ubuntu", 0, 22));
        jLabel26.setText("Lista de enfermedades");

        jButtonConsPrueba.setText("Consultar Prueba");
        jButtonConsPrueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsPruebaMouseClicked(evt);
            }
        });
        jButtonConsPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsPruebaActionPerformed(evt);
            }
        });

        jButtonConsReceta.setText("Consultar Receta");
        jButtonConsReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsRecetaMouseClicked(evt);
            }
        });

        jList5.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane10.setViewportView(jList5);

        org.jdesktop.layout.GroupLayout jPanelConsultarHistorialLayout = new org.jdesktop.layout.GroupLayout(jPanelConsultarHistorial);
        jPanelConsultarHistorial.setLayout(jPanelConsultarHistorialLayout);
        jPanelConsultarHistorialLayout.setHorizontalGroup(
            jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                .add(jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                        .add(167, 167, 167)
                        .add(jLabel24))
                    .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                        .add(344, 344, 344)
                        .add(jLabel25)
                        .add(42, 42, 42)
                        .add(jLabel23))
                    .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                        .add(227, 227, 227)
                        .add(jButtonConsPrueba)
                        .add(39, 39, 39)
                        .add(jButtonConsReceta))
                    .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                        .add(331, 331, 331)
                        .add(jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 201, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel26))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelConsultarHistorialLayout.setVerticalGroup(
            jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelConsultarHistorialLayout.createSequentialGroup()
                .add(53, 53, 53)
                .add(jLabel24)
                .add(31, 31, 31)
                .add(jLabel26)
                .add(18, 18, 18)
                .add(jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel25)
                    .add(jLabel23))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 33, Short.MAX_VALUE)
                .add(jPanelConsultarHistorialLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonConsReceta)
                    .add(jButtonConsPrueba))
                .add(55, 55, 55))
        );

        jPanelConsultarHistorial.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelConsultarHistorial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelVerPruebas.setMinimumSize(new java.awt.Dimension(900, 530));
        jPanelVerPruebas.setPreferredSize(new java.awt.Dimension(900, 530));

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel19.setText("Ver Pruebas");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 22));
        jLabel20.setText("Lista de pruebas");

        jLabel21.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel21.setText("Tipo Prueba");

        jLabel22.setFont(new java.awt.Font("Ubuntu", 0, 12));
        jLabel22.setText("id Prueba");

        jList4.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane9.setViewportView(jList4);

        jButtonVerPrueba.setText("Consultar Prueba");
        jButtonVerPrueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVerPruebaMouseClicked(evt);
            }
        });
        jButtonVerPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerPruebaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelVerPruebasLayout = new org.jdesktop.layout.GroupLayout(jPanelVerPruebas);
        jPanelVerPruebas.setLayout(jPanelVerPruebasLayout);
        jPanelVerPruebasLayout.setHorizontalGroup(
            jPanelVerPruebasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelVerPruebasLayout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .add(jLabel19)
                .add(294, 294, 294))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelVerPruebasLayout.createSequentialGroup()
                .addContainerGap(411, Short.MAX_VALUE)
                .add(jButtonVerPrueba)
                .add(374, 374, 374))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelVerPruebasLayout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .add(jLabel20)
                .add(353, 353, 353))
            .add(jPanelVerPruebasLayout.createSequentialGroup()
                .add(345, 345, 345)
                .add(jPanelVerPruebasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelVerPruebasLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jLabel22)
                        .add(80, 80, 80)
                        .add(jLabel21)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelVerPruebasLayout.createSequentialGroup()
                        .add(jScrollPane9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                        .add(332, 332, 332))
                    .add(jPanelVerPruebasLayout.createSequentialGroup()
                        .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(555, Short.MAX_VALUE))))
        );
        jPanelVerPruebasLayout.setVerticalGroup(
            jPanelVerPruebasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelVerPruebasLayout.createSequentialGroup()
                .add(13, 13, 13)
                .add(jLabel19)
                .add(18, 18, 18)
                .add(jSeparator2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(11, 11, 11)
                .add(jLabel20)
                .add(18, 18, 18)
                .add(jPanelVerPruebasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel22)
                    .add(jLabel21))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(jButtonVerPrueba)
                .add(50, 50, 50))
        );

        jPanelVerPruebas.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelVerPruebas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelGestionarCitaOnline.setMinimumSize(new java.awt.Dimension(901, 510));
        jPanelGestionarCitaOnline.setPreferredSize(new java.awt.Dimension(901, 531));
        jPanelGestionarCitaOnline.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelGestionarPaciente5.setFont(new java.awt.Font("Lucida Grande", 1, 48));
        jLabelGestionarPaciente5.setText("Gestionar Cita Online");
        jPanelGestionarCitaOnline.add(jLabelGestionarPaciente5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jLabel4.setText("_____________________________________________________________________________");
        jPanelGestionarCitaOnline.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jTextAreaInfo1.setBackground(new java.awt.Color(255, 204, 102));
        jTextAreaInfo1.setColumns(17);
        jTextAreaInfo1.setEditable(false);
        jTextAreaInfo1.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jTextAreaInfo1.setRows(3);
        jTextAreaInfo1.setText("Tiene 2 opciones para realizar con la cita online: \nPara solicitar una cita, pulsar \"Alta\". \nPara consultar una cita, pulsar \"Consultar\".");
        jScrollPane2.setViewportView(jTextAreaInfo1);

        jPanelGestionarCitaOnline.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 780, 90));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        jLabel1.setText("Fecha");

        jLabel5.setText("Hora");

        jLabel6.setText("DNI Médico");

        jLabel7.setText("DNI Paciente");

        jButtonAceptarCita.setText("Aceptar");
        jButtonAceptarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAceptarCitaMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelAltaCitaLayout = new org.jdesktop.layout.GroupLayout(jPanelAltaCita);
        jPanelAltaCita.setLayout(jPanelAltaCitaLayout);
        jPanelAltaCitaLayout.setHorizontalGroup(
            jPanelAltaCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelAltaCitaLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelAltaCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelAltaCitaLayout.createSequentialGroup()
                        .add(jPanelAltaCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .add(jPanelAltaCitaLayout.createSequentialGroup()
                                .add(jLabel1)
                                .add(81, 81, 81)
                                .add(jLabel5)
                                .add(94, 94, 94)
                                .add(jLabel6)
                                .add(78, 78, 78)
                                .add(jLabel7)))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelAltaCitaLayout.createSequentialGroup()
                        .add(jButtonAceptarCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(222, 222, 222))))
        );
        jPanelAltaCitaLayout.setVerticalGroup(
            jPanelAltaCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelAltaCitaLayout.createSequentialGroup()
                .add(jPanelAltaCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel6)
                    .add(jLabel5)
                    .add(jLabel7))
                .add(4, 4, 4)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButtonAceptarCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGestionarCitaOnline.add(jPanelAltaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 540, 200));

        jButtonConsultarCita1.setText("Consultar");
        jButtonConsultarCita1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsultarCita1MouseClicked(evt);
            }
        });

        jButtonPedirAltaCita.setText("Alta");
        jButtonPedirAltaCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPedirAltaCitaMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelBotonesLayout = new org.jdesktop.layout.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .add(127, 127, 127)
                .add(jButtonPedirAltaCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 171, Short.MAX_VALUE)
                .add(jButtonConsultarCita1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(96, 96, 96))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanelBotonesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButtonConsultarCita1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonPedirAltaCita, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelGestionarCitaOnline.add(jPanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 580, 60));

        jPanelGestionarCitaOnline.setBounds(0, 0, -1, -1);
        ZonaTrabajo.add(jPanelGestionarCitaOnline, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelConsultarCitaOnline.setMinimumSize(new java.awt.Dimension(901, 510));
        jPanelConsultarCitaOnline.setPreferredSize(new java.awt.Dimension(901, 531));
        jPanelConsultarCitaOnline.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldMesCita.setEditable(false);
        jTextFieldMesCita.setText("1");
        jTextFieldMesCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesCitaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jTextFieldMesCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 33, -1));

        jButtonMenosAnioPersonal.setText("-");
        jButtonMenosAnioPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMenosAnioPersonalMouseClicked(evt);
            }
        });
        jButtonMenosAnioPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosAnioPersonalActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMenosAnioPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 50, 40));

        jButtonMasAnioFecha.setText("+");
        jButtonMasAnioFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMasAnioFechaMouseClicked(evt);
            }
        });
        jButtonMasAnioFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasAnioFechaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMasAnioFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 50, 40));

        jTextFieldAnioCita.setText("1950");
        jTextFieldAnioCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnioCitaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jTextFieldAnioCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 50, -1));

        jLabelFecha.setText("Fecha cita");
        jPanelConsultarCitaOnline.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, -1, -1));

        jTextFieldDiaCita.setEditable(false);
        jTextFieldDiaCita.setText("1");
        jPanelConsultarCitaOnline.add(jTextFieldDiaCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 33, -1));

        jButtonMasMesFecha.setText("+");
        jButtonMasMesFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMasMesFechaMouseClicked(evt);
            }
        });
        jButtonMasMesFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasMesFechaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMasMesFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 50, 40));

        jButtonMasDiaFecha.setText("+");
        jButtonMasDiaFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMasDiaFechaMouseClicked(evt);
            }
        });
        jButtonMasDiaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasDiaFechaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMasDiaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 50, 40));

        jButtonModificarCitaOnline.setText("Modificar");
        jPanelConsultarCitaOnline.add(jButtonModificarCitaOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 460, 93, 39));

        jButtonMenosDiaFecha.setText("-");
        jButtonMenosDiaFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMenosDiaFechaMouseClicked(evt);
            }
        });
        jButtonMenosDiaFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosDiaFechaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMenosDiaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 50, 40));

        jButtonMenosMesFecha.setText("-");
        jButtonMenosMesFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMenosMesFechaMouseClicked(evt);
            }
        });
        jButtonMenosMesFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosMesFechaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMenosMesFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 50, 40));

        jLabelGestionarPaciente2.setFont(new java.awt.Font("Lucida Grande", 1, 48));
        jLabelGestionarPaciente2.setText("Consultar Cita Online");
        jPanelConsultarCitaOnline.add(jLabelGestionarPaciente2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel2.setText("_____________________________________________________________________________");
        jPanelConsultarCitaOnline.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jButtonVolver.setText("Volver");
        jButtonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVolverMouseClicked(evt);
            }
        });
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, 39));

        jButtonMasHora.setText("+");
        jButtonMasHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMasHoraMouseClicked(evt);
            }
        });
        jButtonMasHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasHoraActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMasHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 50, 40));

        jButtonMasMinuto.setText("+");
        jButtonMasMinuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMasMinutoMouseClicked(evt);
            }
        });
        jButtonMasMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMasMinutoActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMasMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 50, 40));

        jTextFieldHoraCita.setEditable(false);
        jTextFieldHoraCita.setText("1");
        jPanelConsultarCitaOnline.add(jTextFieldHoraCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 33, -1));

        jTextFieldMinutoCita.setEditable(false);
        jTextFieldMinutoCita.setText("1");
        jTextFieldMinutoCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMinutoCitaActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jTextFieldMinutoCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 33, -1));

        jButtonMenosHora.setText("-");
        jButtonMenosHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMenosHoraMouseClicked(evt);
            }
        });
        jButtonMenosHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosHoraActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMenosHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 50, 40));

        jButtonMenosMinuto.setText("-");
        jButtonMenosMinuto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonMenosMinutoMouseClicked(evt);
            }
        });
        jButtonMenosMinuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMenosMinutoActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonMenosMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 390, 50, 40));

        jLabelHoraCita.setText("Hora cita");
        jPanelConsultarCitaOnline.add(jLabelHoraCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 300, -1, -1));

        jTextAreaInfo.setBackground(new java.awt.Color(255, 204, 102));
        jTextAreaInfo.setColumns(17);
        jTextAreaInfo.setEditable(false);
        jTextAreaInfo.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        jTextAreaInfo.setRows(3);
        jTextAreaInfo.setText("Estás consultando una cita online, si modificas algún campo dale a \"Guardar\" \nSi deseas cancelar dicha cita dale a \"Cancelar\"");
        jScrollPane1.setViewportView(jTextAreaInfo);

        jPanelConsultarCitaOnline.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 780, 120));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, -1, 39));

        jLabelFecha1.setText("DNI Paciente");
        jPanelConsultarCitaOnline.add(jLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jLabelFecha2.setText("DNI Médico");
        jPanelConsultarCitaOnline.add(jLabelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        jTextFieldDNIMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIMedicoKeyTyped(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jTextFieldDNIMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 90, -1));

        jTextFieldDNIPacienteCita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIPacienteCitaKeyTyped(evt);
            }
        });
        jPanelConsultarCitaOnline.add(jTextFieldDNIPacienteCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 90, -1));

        jPanelConsultarCitaOnline.setBounds(0, 0, -1, -1);
        ZonaTrabajo.add(jPanelConsultarCitaOnline, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelGestionarPaciente.setPreferredSize(new java.awt.Dimension(901, 531));

        jLabel15.setText("______________________________________________________________________________________________");

        jLabelGestionarPaciente4.setFont(new java.awt.Font("Lucida Grande", 1, 48));
        jLabelGestionarPaciente4.setText("Consulta Datos Paciente");

        jTextFieldNombrePaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombrePacienteKeyTyped(evt);
            }
        });

        jLabelFotoPaciente.setBackground(new java.awt.Color(255, 255, 255));
        jLabelFotoPaciente.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldTelefonoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoPacienteKeyTyped(evt);
            }
        });

        jLabelContraseniaPaciente.setText("Contraseña");

        jTextFieldDNIPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDNIPacienteKeyTyped(evt);
            }
        });

        jLabelNombrePaciente.setText("Nombre");

        jLabelFotografiaPaciente.setText("Fotografía");

        jLabelDNIPaciente.setText("DNI");

        jTextFieldLugarNacimientoPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLugarNacimientoPacienteKeyTyped(evt);
            }
        });

        jLabelTelefonoPaciente.setText("Teléfono");

        jLabelLugarNacimientoPaciente.setText("Lugar nacimiento");

        jLabelDireccionPaciente.setText("Dirección");

        jLabelApellidosPaciente.setText("Apellidos");

        jTextFieldApellidosPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidosPacienteKeyTyped(evt);
            }
        });

        jLabelEmailPaciente.setText("Email");

        jTextFieldDireccionPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldDireccionPacienteKeyTyped(evt);
            }
        });

        jTextFieldEmailPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmailPacienteKeyTyped(evt);
            }
        });

        jTextFieldContraseniaPaciente.setColumns(8);

        jLabelFechaNacimientoPaciente.setText("Fecha nacimiento");

        jButtonModificarPaciente.setText("Modificar");
        jButtonModificarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonModificarPacienteMouseClicked(evt);
            }
        });
        jButtonModificarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarPacienteActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelGestionarPacienteLayout = new org.jdesktop.layout.GroupLayout(jPanelGestionarPaciente);
        jPanelGestionarPaciente.setLayout(jPanelGestionarPacienteLayout);
        jPanelGestionarPacienteLayout.setHorizontalGroup(
            jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelGestionarPacienteLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(dateChooserCombo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelGestionarPacienteLayout.createSequentialGroup()
                            .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(jLabelFechaNacimientoPaciente)
                                    .add(215, 215, 215)
                                    .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabelFotografiaPaciente)
                                        .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                            .add(161, 161, 161)
                                            .add(jLabelFotoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(jTextFieldDireccionPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(40, 40, 40)
                                    .add(jTextFieldEmailPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 289, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(jLabelDireccionPaciente)
                                    .add(350, 350, 350)
                                    .add(jLabelEmailPaciente))
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(jLabelNombrePaciente)
                                    .add(200, 200, 200)
                                    .add(jLabelApellidosPaciente)
                                    .add(291, 291, 291)
                                    .add(jLabelDNIPaciente))
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(jTextFieldNombrePaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(40, 40, 40)
                                    .add(jTextFieldApellidosPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(60, 60, 60)
                                    .add(jTextFieldDNIPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                    .add(100, 100, 100)
                                    .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 578, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabelGestionarPaciente4))))
                            .add(90, 90, 90))
                        .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                            .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabelTelefonoPaciente)
                                .add(jTextFieldTelefonoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(63, 63, 63)
                            .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabelLugarNacimientoPaciente)
                                .add(jTextFieldLugarNacimientoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jButtonModificarPaciente))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jTextFieldContraseniaPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabelContraseniaPaciente))
                            .add(107, 107, 107))))
                .add(90, 90, 90))
        );
        jPanelGestionarPacienteLayout.setVerticalGroup(
            jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                        .add(jLabelGestionarPaciente4)
                        .add(18, 18, 18)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelNombrePaciente)
                            .add(jLabelApellidosPaciente)
                            .add(jLabelDNIPaciente))
                        .add(14, 14, 14)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextFieldNombrePaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldApellidosPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldDNIPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelDireccionPaciente)
                            .add(jLabelEmailPaciente))
                        .add(4, 4, 4)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jTextFieldDireccionPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldEmailPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(30, 30, 30)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                .add(jLabelTelefonoPaciente)
                                .add(4, 4, 4)
                                .add(jTextFieldTelefonoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(jLabelLugarNacimientoPaciente)
                                    .add(jLabelContraseniaPaciente))
                                .add(4, 4, 4)
                                .add(jTextFieldLugarNacimientoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jTextFieldContraseniaPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                        .add(39, 39, 39)
                        .add(jLabel15)))
                .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                .add(19, 19, 19)
                                .add(jLabelFechaNacimientoPaciente)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dateChooserCombo2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                .add(30, 30, 30)
                                .add(jPanelGestionarPacienteLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabelFotografiaPaciente)
                                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                                        .add(110, 110, 110)
                                        .add(jLabelFotoPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(jPanelGestionarPacienteLayout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(jButtonModificarPaciente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelGestionarPaciente.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelGestionarPaciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelVerRecetas.setPreferredSize(new java.awt.Dimension(901, 531));

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Receta 1      Doctor 1", "Receta 2        Doctor 2", "Receta 3        Doctor 3", "Receta 4        Doctor 4", "Receta 5\t\t\t        Doctor 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(jList3);

        jLabelGestionarPaciente7.setFont(new java.awt.Font("Lucida Grande", 1, 48));
        jLabelGestionarPaciente7.setText("Ver Recetas");

        jLabelListaRecetas.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabelListaRecetas.setText("Lista Recetas");

        jLabelMedico.setText("Medico");

        jLabelFechaReceta.setText("Fecha");

        jButtonConsultarReceta.setText("Consultar");
        jButtonConsultarReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsultarRecetaMouseClicked(evt);
            }
        });
        jButtonConsultarReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarRecetaActionPerformed(evt);
            }
        });

        jLabelMedico1.setText("Id");

        org.jdesktop.layout.GroupLayout jPanelVerRecetasLayout = new org.jdesktop.layout.GroupLayout(jPanelVerRecetas);
        jPanelVerRecetas.setLayout(jPanelVerRecetasLayout);
        jPanelVerRecetasLayout.setHorizontalGroup(
            jPanelVerRecetasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelVerRecetasLayout.createSequentialGroup()
                .add(jPanelVerRecetasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelVerRecetasLayout.createSequentialGroup()
                        .add(282, 282, 282)
                        .add(jPanelVerRecetasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanelVerRecetasLayout.createSequentialGroup()
                                .add(20, 20, 20)
                                .add(jLabelFechaReceta)
                                .add(86, 86, 86)
                                .add(jLabelMedico)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabelMedico1)
                                .add(43, 43, 43))
                            .add(jPanelVerRecetasLayout.createSequentialGroup()
                                .add(110, 110, 110)
                                .add(jButtonConsultarReceta))
                            .add(jPanelVerRecetasLayout.createSequentialGroup()
                                .add(31, 31, 31)
                                .add(jLabelGestionarPaciente7))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 327, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanelVerRecetasLayout.createSequentialGroup()
                        .add(391, 391, 391)
                        .add(jLabelListaRecetas)))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanelVerRecetasLayout.setVerticalGroup(
            jPanelVerRecetasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelVerRecetasLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelGestionarPaciente7)
                .add(50, 50, 50)
                .add(jLabelListaRecetas)
                .add(26, 26, 26)
                .add(jPanelVerRecetasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelMedico)
                    .add(jLabelMedico1)
                    .add(jLabelFechaReceta))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 174, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(38, 38, 38)
                .add(jButtonConsultarReceta)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        jPanelVerRecetas.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelVerRecetas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelConsultarReceta.setPreferredSize(new java.awt.Dimension(901, 531));

        jLabelInformacionDetalladaReceta.setFont(new java.awt.Font("Lucida Grande", 1, 48));
        jLabelInformacionDetalladaReceta.setText("Información detallada de la receta");

        jLabelInstruccionReceta.setText("Instrucciones");

        jButtonVolverReceta.setText("Ver Recetas");
        jButtonVolverReceta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVolverRecetaMouseClicked(evt);
            }
        });

        jLabelJuicioReceta.setText("Juicio Diagnóstico");

        jLabelMedicoReceta.setText("Médico");

        jLabelDNIMedicoReceta.setText("DNI");

        jLabelNombreMedicoReceta.setText("Nombre");

        jLabel18.setText("Teléfono");

        jLabelEmailMedicoReceta.setText("Email");

        jLabel18FechaReceta.setText("Fecha");

        jTextFieldDNIMedicoReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNIMedicoRecetaActionPerformed(evt);
            }
        });

        jTextFieldEmailMedicoReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailMedicoRecetaActionPerformed(evt);
            }
        });

        jScrollPane7.setViewportView(jTextPane1);

        jScrollPane8.setViewportView(jTextPane2);

        jList8.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane20.setViewportView(jList8);

        jLabel46.setText("Medicamentos recetados");

        org.jdesktop.layout.GroupLayout jPanelConsultarRecetaLayout = new org.jdesktop.layout.GroupLayout(jPanelConsultarReceta);
        jPanelConsultarReceta.setLayout(jPanelConsultarRecetaLayout);
        jPanelConsultarRecetaLayout.setHorizontalGroup(
            jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(28, 28, 28)
                                .add(jLabelMedicoReceta)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldDNIMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 94, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldNombreMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 187, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldTelefonoMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(123, 123, 123)
                                .add(jLabelInstruccionReceta)
                                .add(142, 142, 142)
                                .add(jLabelJuicioReceta))
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(116, 116, 116)
                                .add(jLabelDNIMedicoReceta)
                                .add(122, 122, 122)
                                .add(jLabelNombreMedicoReceta)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jLabel18)
                                .add(23, 23, 23)))
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextFieldEmailMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(47, 47, 47)
                                .add(jLabelEmailMedicoReceta))
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(79, 79, 79)
                                .add(jLabel18FechaReceta))))
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(57, 57, 57)
                                .add(jTextFieldFechaReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 202, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(27, 27, 27)
                                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanelConsultarRecetaLayout.createSequentialGroup()
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jButtonVolverReceta)
                                .add(72, 72, 72)))
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                                .add(102, 102, 102)
                                .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jScrollPane20)
                                    .add(jLabel46, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabelInformacionDetalladaReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 839, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelConsultarRecetaLayout.setVerticalGroup(
            jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabelInformacionDetalladaReceta)
                .add(31, 31, 31)
                .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelInstruccionReceta)
                    .add(jLabelJuicioReceta)
                    .add(jLabel18FechaReceta))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 70, Short.MAX_VALUE)
                        .add(jLabel46))
                    .add(jTextFieldFechaReceta, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .add(33, 33, 33)
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabelEmailMedicoReceta)
                            .add(jLabelDNIMedicoReceta)
                            .add(jLabelNombreMedicoReceta)
                            .add(jLabel18))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanelConsultarRecetaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabelMedicoReceta)
                            .add(jTextFieldDNIMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldNombreMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldTelefonoMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jTextFieldEmailMedicoReceta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(72, 72, 72)
                        .add(jButtonVolverReceta))
                    .add(jPanelConsultarRecetaLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(114, 114, 114))
        );

        jPanelConsultarReceta.setBounds(1, 0, 800, 530);
        ZonaTrabajo.add(jPanelConsultarReceta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelPruebaRadiologia.setMinimumSize(new java.awt.Dimension(900, 530));

        jLabel27.setFont(new java.awt.Font("Ubuntu", 0, 22));
        jLabel27.setText("Lista de pruebas");
        jPanelPruebaRadiologia.add(jLabel27);
        jPanelPruebaRadiologia.add(jSeparator3);

        jLabel28.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel28.setText("Consultar Prueba del Radiólogo");
        jPanelPruebaRadiologia.add(jLabel28);

        jLabel29.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel29.setText("Tipo de prueba");
        jPanelPruebaRadiologia.add(jLabel29);

        jLabel30.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel30.setText("Imagen");
        jPanelPruebaRadiologia.add(jLabel30);

        jList6.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane11.setViewportView(jList6);

        jPanelPruebaRadiologia.add(jScrollPane11);

        jLabel39.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel39.setText("Analista");
        jPanelPruebaRadiologia.add(jLabel39);

        jPanelPruebaRadiologia.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelPruebaRadiologia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelPruebaAnalista.setMinimumSize(new java.awt.Dimension(900, 530));
        jPanelPruebaAnalista.setPreferredSize(new java.awt.Dimension(949, 530));
        jPanelPruebaAnalista.add(jSeparator4);

        jLabel31.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel31.setText("Consultar Prueba del Analista");
        jPanelPruebaAnalista.add(jLabel31);

        jList7.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane12.setViewportView(jList7);

        jPanelPruebaAnalista.add(jScrollPane12);

        jLabel32.setText("Tipo de Prueba");
        jPanelPruebaAnalista.add(jLabel32);
        jPanelPruebaAnalista.add(jTextField1);

        jLabel40.setText("Analista");
        jPanelPruebaAnalista.add(jLabel40);
        jPanelPruebaAnalista.add(jTextField2);

        jLabel33.setText("Id Prueba");
        jPanelPruebaAnalista.add(jLabel33);
        jPanelPruebaAnalista.add(jTextField3);

        jLabel34.setText("Imágenes");
        jPanelPruebaAnalista.add(jLabel34);

        jPanelPruebaAnalista.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelPruebaAnalista, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelVerCita.setMinimumSize(new java.awt.Dimension(900, 530));

        jLabel35.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel35.setText("Ver Citas");

        jLabel36.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel36.setText("Hora");

        jLabel37.setFont(new java.awt.Font("Ubuntu", 1, 15));
        jLabel37.setText("Fecha");

        jList9.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane13.setViewportView(jList9);

        jButtonConsCita.setText("Consultar");
        jButtonConsCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsCitaMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelVerCitaLayout = new org.jdesktop.layout.GroupLayout(jPanelVerCita);
        jPanelVerCita.setLayout(jPanelVerCitaLayout);
        jPanelVerCitaLayout.setHorizontalGroup(
            jPanelVerCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelVerCitaLayout.createSequentialGroup()
                .add(324, 324, 324)
                .add(jPanelVerCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelVerCitaLayout.createSequentialGroup()
                        .add(jLabel35)
                        .add(5, 5, 5)
                        .add(jSeparator5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanelVerCitaLayout.createSequentialGroup()
                        .add(55, 55, 55)
                        .add(jButtonConsCita))
                    .add(jPanelVerCitaLayout.createSequentialGroup()
                        .add(jLabel37)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 184, Short.MAX_VALUE)
                        .add(jLabel36))
                    .add(jScrollPane13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 261, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(315, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanelVerCitaLayout.setVerticalGroup(
            jPanelVerCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelVerCitaLayout.createSequentialGroup()
                .add(jPanelVerCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelVerCitaLayout.createSequentialGroup()
                        .add(69, 69, 69)
                        .add(jSeparator5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(126, 126, 126))
                    .add(jPanelVerCitaLayout.createSequentialGroup()
                        .add(53, 53, 53)
                        .add(jLabel35)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 62, Short.MAX_VALUE)
                        .add(jPanelVerCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel36)
                            .add(jLabel37))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(jButtonConsCita)
                .add(84, 84, 84))
        );

        jPanelVerCita.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelVerCita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelDetalleCita.setMinimumSize(new java.awt.Dimension(900, 530));

        jLabel38.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel38.setText("Fecha");

        jLabel41.setFont(new java.awt.Font("Ubuntu", 1, 48));
        jLabel41.setText("Información Detallada de la Cita");

        jScrollPane14.setViewportView(jTextPane3);

        jLabel42.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel42.setText("Hora");

        jLabel43.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel43.setText("Tipo de Cita");

        jLabel44.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel44.setText("Estado");

        jScrollPane15.setViewportView(jTextPane4);

        jScrollPane16.setViewportView(jTextPane5);

        jScrollPane17.setViewportView(jTextPane6);

        jLabel47.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel47.setText("Paciente");

        jLabel48.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel48.setText("DNI");

        jLabel49.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel49.setText("Nombre");

        jLabel50.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel50.setText("Email");

        jLabel51.setFont(new java.awt.Font("Ubuntu", 1, 18));
        jLabel51.setText("Teléfono");

        jScrollPane18.setViewportView(jTextPane7);

        jScrollPane19.setViewportView(jTextPane8);

        jScrollPane21.setViewportView(jTextPane9);

        jScrollPane22.setViewportView(jTextPane10);

        jButton1.setText("Ver citas");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanelDetalleCitaLayout = new org.jdesktop.layout.GroupLayout(jPanelDetalleCita);
        jPanelDetalleCita.setLayout(jPanelDetalleCitaLayout);
        jPanelDetalleCitaLayout.setHorizontalGroup(
            jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(63, 63, 63)
                        .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                .add(jSeparator6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5)
                                .add(jLabel41))
                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                .add(jLabel47)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                        .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                                .add(23, 23, 23)
                                                .add(jLabel38))
                                            .add(jScrollPane14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(18, 18, 18)
                                        .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jScrollPane15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                                .add(23, 23, 23)
                                                .add(jLabel42)))
                                        .add(18, 18, 18)
                                        .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jScrollPane16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(jLabel43))
                                        .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                                .add(18, 18, 18)
                                                .add(jScrollPane17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                                .add(31, 31, 31)
                                                .add(jLabel44))))
                                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                                        .add(jScrollPane18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 103, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jScrollPane19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jScrollPane21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jScrollPane22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(179, 179, 179)
                        .add(jLabel48)
                        .add(89, 89, 89)
                        .add(jLabel49)
                        .add(83, 83, 83)
                        .add(jLabel51)
                        .add(49, 49, 49)
                        .add(jLabel50))
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(354, 354, 354)
                        .add(jButton1)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanelDetalleCitaLayout.setVerticalGroup(
            jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelDetalleCitaLayout.createSequentialGroup()
                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jSeparator6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(jLabel41)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelDetalleCitaLayout.createSequentialGroup()
                            .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel38)
                                .add(jLabel43))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jScrollPane14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jScrollPane16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelDetalleCitaLayout.createSequentialGroup()
                            .add(jLabel42)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jScrollPane15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanelDetalleCitaLayout.createSequentialGroup()
                        .add(jLabel44)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane17, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(46, 46, 46)
                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel48)
                    .add(jLabel49)
                    .add(jLabel51)
                    .add(jLabel50))
                .add(11, 11, 11)
                .add(jPanelDetalleCitaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel47)
                    .add(jScrollPane18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(117, 117, 117)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        jPanelDetalleCita.setBounds(1, 0, 900, 530);
        ZonaTrabajo.add(jPanelDetalleCita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(ZonaTrabajo);
        ZonaTrabajo.setBounds(13, 185, 920, 550);

        jPanelUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanelUsuario.setLayout(null);

        jLabelUsuario.setText("Usuario:");
        jPanelUsuario.add(jLabelUsuario);
        jLabelUsuario.setBounds(80, 10, 80, 14);

        jLabelTipoUsuario.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jLabelTipoUsuario.setText("Tipo Usuario");
        jPanelUsuario.add(jLabelTipoUsuario);
        jLabelTipoUsuario.setBounds(90, 40, 120, 18);

        jLabelNombreUsuario.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jLabelNombreUsuario.setText("Nombre");
        jPanelUsuario.add(jLabelNombreUsuario);
        jLabelNombreUsuario.setBounds(90, 60, 120, 18);
        jPanelUsuario.add(jLabelTipoUsuarioIdentificado);
        jLabelTipoUsuarioIdentificado.setBounds(10, 10, 70, 70);

        getContentPane().add(jPanelUsuario);
        jPanelUsuario.setBounds(665, 47, 220, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLabelIconoInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoInicioMouseEntered
        // TODO add your handling code here:
        jLabelIconoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Inicio-Activado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoInicioMouseEntered

    private void jLabelIconoInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoInicioMouseExited
        // TODO add your handling code here:
        jLabelIconoInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Inicio-Desactivado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoInicioMouseExited

    private void jLabelIconoAyudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseExited
        // TODO add your handling code here:
        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Desactivado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoAyudaMouseExited

    private void jLabelIconoAyudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseEntered
        // TODO add your handling code here:
        jLabelIconoAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Ayuda-Activado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoAyudaMouseEntered

    private void jLabelIconoSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseExited
        // TODO add your handling code here:
        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Desactivado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoSalirMouseExited

    private void jLabelIconoSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseEntered
        // TODO add your handling code here:
        jLabelIconoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Salir-Activado.png"))); // NOI18N
    }//GEN-LAST:event_jLabelIconoSalirMouseEntered

    private void jLabelIconoSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoSalirMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelIconoSalirMouseClicked

    private void jLabelIconoAyudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoAyudaMouseClicked
        // TODO add your handling code here:
        new Ayuda().setVisible(true);
    }//GEN-LAST:event_jLabelIconoAyudaMouseClicked

    private void jButtonGestionarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGestionarPacienteMouseClicked
        // TODO add your handling code here:
        mostrarPanel("GestionarPaciente");
    }//GEN-LAST:event_jButtonGestionarPacienteMouseClicked

    private void jButtonGestionarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGestionarPacienteActionPerformed

    private void jLabelIconoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconoInicioMouseClicked
        // TODO add your handling code here:
        mostrarPanel("Principal");
    }//GEN-LAST:event_jLabelIconoInicioMouseClicked

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
        limpiarFormulario("GestionarCitaOnlineAlta");
}//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonMasMesFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasMesFechaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMasMesFechaActionPerformed

    private void jButtonMasAnioFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasAnioFechaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMasAnioFechaActionPerformed

    private void jButtonMenosDiaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosDiaFechaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMenosDiaFechaActionPerformed

    private void jButtonMenosMesFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosMesFechaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMenosMesFechaActionPerformed

    private void jButtonMasDiaFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasDiaFechaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMasDiaFechaActionPerformed

    private void jButtonMenosAnioPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosAnioPersonalActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButtonMenosAnioPersonalActionPerformed

    private void jTextFieldMesCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMesCitaActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldMesCitaActionPerformed

    private void jButtonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVolverMouseClicked
        // TODO add your handling code here:
        jTextFieldDNIPacienteCita.setEditable(true);
        mostrarPanel("GestionarCitaOnline");
    }//GEN-LAST:event_jButtonVolverMouseClicked

    private void jButtonMasDiaFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMasDiaFechaMouseClicked
        // TODO add your handling code here:
        int num = 0;

        num = Integer.parseInt(jTextFieldDiaCita.getText());

        if(num < 31)
            num ++;

        String numString;
        numString = String.valueOf(num);
        jTextFieldDiaCita.setText(numString);
    }//GEN-LAST:event_jButtonMasDiaFechaMouseClicked

    private void jButtonMenosDiaFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenosDiaFechaMouseClicked
        // TODO add your handling code here:
        int num = 0;

        num = Integer.parseInt(jTextFieldDiaCita.getText());

        if(num > 1)
            num --;

        String numString;
        numString = String.valueOf(num);
        jTextFieldDiaCita.setText(numString);
    }//GEN-LAST:event_jButtonMenosDiaFechaMouseClicked

    private void jButtonMasMesFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMasMesFechaMouseClicked
        // TODO add your handling code here:
        int num = 0;

        num = Integer.parseInt(jTextFieldMesCita.getText());

        if(num < 12)
            num ++;

        String numString;
        numString = String.valueOf(num);
        jTextFieldMesCita.setText(numString);
    }//GEN-LAST:event_jButtonMasMesFechaMouseClicked

    private void jButtonMenosMesFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenosMesFechaMouseClicked
        // TODO add your handling code here:
        int num = 0;

        num = Integer.parseInt(jTextFieldMesCita.getText());

        if(num > 1)
            num --;

        String numString;
        numString = String.valueOf(num);
        jTextFieldMesCita.setText(numString);
    }//GEN-LAST:event_jButtonMenosMesFechaMouseClicked

    private void jButtonMasAnioFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMasAnioFechaMouseClicked
        // TODO add your handling code here:
        int num = 0;
        int anioActual = 0;

        num = Integer.parseInt(jTextFieldAnioCita.getText());

        Calendar fechaActual = Calendar.getInstance();
        anioActual = fechaActual.get(Calendar.YEAR);

        if(num < anioActual)
            num ++;

        String numString;
        numString = String.valueOf(num);
        jTextFieldAnioCita.setText(numString);
    }//GEN-LAST:event_jButtonMasAnioFechaMouseClicked

    private void jButtonMenosAnioPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenosAnioPersonalMouseClicked
        // TODO add your handling code here:
        int num = 0;
        num = Integer.parseInt(jTextFieldAnioCita.getText());

        if(num > 1900)
            num --;

        String numString;
        numString = String.valueOf(num);
        jTextFieldAnioCita.setText(numString);
    }//GEN-LAST:event_jButtonMenosAnioPersonalMouseClicked

    private void jButtonGestionarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGestionarCitaMouseClicked
        // TODO add your handling code here:
        mostrarPanel("GestionarCitaOnline");

        SimpleDateFormat formatofecha = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("hh:mm");
        String elemento, tabula = "                                     ";
        modelo.clear();
        jList7.setModel(modelo);
        String dni = user.getDNI();
        try{
            ArrayList<Cita> array_citas = new ArrayList();
            array_citas = gstCit.VerCitas(dni);
            if(!array_citas.isEmpty()){
                for(int i = 0; i < array_citas.size(); i++){
                    elemento = formatofecha.format(array_citas.get(i).getFecha()) + tabula + formatohora.format(array_citas.get(i).getFecha());
                    modelo.addElement(elemento);
                }
            }
        }catch(SQLException ex){
            System.err.println(ex.getStackTrace());
        }
    }//GEN-LAST:event_jButtonGestionarCitaMouseClicked

    private void jButtonMasHoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMasHoraMouseClicked
        // TODO add your handling code here:
        int hora = 0;

        hora = Integer.parseInt(jTextFieldHoraCita.getText());

        if(hora < 24){
            hora ++;
            }else{
                hora = 0;
            }

        String numString = String.valueOf(hora);
        jTextFieldHoraCita.setText(numString);
    }//GEN-LAST:event_jButtonMasHoraMouseClicked

    private void jButtonMasHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMasHoraActionPerformed

    private void jButtonMasMinutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMasMinutoMouseClicked
        // TODO add your handling code here:
        int minuto = 0;

        minuto = Integer.parseInt(jTextFieldMinutoCita.getText());

        if(minuto < 60)
            minuto ++;

        String numString;
        numString = String.valueOf(minuto);
        jTextFieldMinutoCita.setText(numString);
    }//GEN-LAST:event_jButtonMasMinutoMouseClicked

    private void jButtonMasMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMasMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMasMinutoActionPerformed

    private void jTextFieldMinutoCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMinutoCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMinutoCitaActionPerformed

    private void jButtonMenosHoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenosHoraMouseClicked
        // TODO add your handling code here:
        int hora = 0;

        hora = Integer.parseInt(jTextFieldHoraCita.getText());

        if(hora > 0){
            hora --;
            }else{
                hora = 24;
            }

        String numString;
        numString = String.valueOf(hora);
        jTextFieldHoraCita.setText(numString);
    }//GEN-LAST:event_jButtonMenosHoraMouseClicked

    private void jButtonMenosHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenosHoraActionPerformed

    private void jButtonMenosMinutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMenosMinutoMouseClicked
        // TODO add your handling code here:
        int minuto = 0;

        minuto = Integer.parseInt(jTextFieldMinutoCita.getText());

        if(minuto > 0)
            minuto --;

        String numString;
        numString = String.valueOf(minuto);
        jTextFieldMinutoCita.setText(numString);
    }//GEN-LAST:event_jButtonMenosMinutoMouseClicked

    private void jButtonMenosMinutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMenosMinutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMenosMinutoActionPerformed

    private void jTextFieldAnioCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnioCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnioCitaActionPerformed

    private void jButtonPedirAltaCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPedirAltaCitaMouseClicked
        // TODO add your handling code here:
       
        /*try{
            if(gstCit.ObtenerCita(user.getDNI()) != null){
                JOptionPane.showMessageDialog(null, "Ya tiene una cita asignada", "Alta cita",JOptionPane.WARNING_MESSAGE);
            }else{
                jPanelAltaCita.setVisible(true);
                jPanelBotones.setVisible(false);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }*/

    }//GEN-LAST:event_jButtonPedirAltaCitaMouseClicked

    private void jTextFieldTelefonoPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoPacienteKeyTyped
        // TODO add your handling code here:

        /**Comprobamos que no se teclee una letra*/
        char teclaPresionada = evt.getKeyChar();
        if(jTextFieldTelefonoPaciente.getText().length() < 9)
            if(Character.isDigit(teclaPresionada) == false)
                evt.consume();

        if(jTextFieldTelefonoPaciente.getText().length() >= 9)
            evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoPacienteKeyTyped

    private void jTextFieldNombrePacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombrePacienteKeyTyped
        // TODO add your handling code here:

        /** Comprobamos que no se teclee un número **/
        char teclaPresionada = evt.getKeyChar();
        if(Character.isDigit(teclaPresionada) == true)
            evt.consume();
}//GEN-LAST:event_jTextFieldNombrePacienteKeyTyped

    private void jTextFieldDNIPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIPacienteKeyTyped
        // TODO add your handling code here:

        /** Limitamos a que el DNI siempre sea correcto sintácticamente **/
        char teclaPresionada = evt.getKeyChar();

        if(jTextFieldDNIPaciente.getText().length() < 8)
            if(Character.isDigit(teclaPresionada) == false)
                evt.consume();

        if(jTextFieldDNIPaciente.getText().length() == 8)
            if(Character.isDigit(teclaPresionada) == true){
                evt.consume();
            }else if(Character.isLowerCase(teclaPresionada)){
                jTextFieldDNIPaciente.setText(jTextFieldDNIPaciente.getText().toUpperCase());
            }

        if(jTextFieldDNIPaciente.getText().length() > 8)
            evt.consume();
}//GEN-LAST:event_jTextFieldDNIPacienteKeyTyped

    private void jTextFieldApellidosPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidosPacienteKeyTyped
        // TODO add your handling code here:

        /** Comprobamos que no se teclee un número **/
        char teclaPresionada = evt.getKeyChar();
        if(Character.isDigit(teclaPresionada) == true)
            evt.consume();
}//GEN-LAST:event_jTextFieldApellidosPacienteKeyTyped

    private void jTextFieldDireccionPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDireccionPacienteKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDireccionPacienteKeyTyped

    private void jTextFieldEmailPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailPacienteKeyTyped
        // TODO add your handling code here:
}//GEN-LAST:event_jTextFieldEmailPacienteKeyTyped

    private void jTextFieldLugarNacimientoPacienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLugarNacimientoPacienteKeyTyped
        // TODO add your handling code here:

        /** Comprobamos que no se teclee un número **/
        char teclaPresionada = evt.getKeyChar();
        if(Character.isDigit(teclaPresionada) == true)
            evt.consume();
}//GEN-LAST:event_jTextFieldLugarNacimientoPacienteKeyTyped

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked
        // TODO add your handling code here:
        if(1 != JOptionPane.showOptionDialog(null, "¿Cancelar la cita?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null)){

            try{
                gstCit.CancelarCita(user.getDNI()); //Hasta que "obtenercita" no funcione bien, no puedo funcionar "cancelarcita"
                limpiarFormulario("ConsultarCitaOnline");
                JOptionPane.showMessageDialog(null, "Ha cancelado la cita", "Salir",JOptionPane.INFORMATION_MESSAGE);
                mostrarPanel("GestionarCitaOnline");
            }catch(SQLException ex){
                System.err.print(ex.getMessage());
                JOptionPane.showMessageDialog(null, "No fue posible cancelar la cita", "Error",JOptionPane.ERROR);
            }

        }
    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldDNIPacienteCitaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIPacienteCitaKeyTyped
        // TODO add your handling code here:

        /**Limitamos a que el DNI siempre sea correcto sintácticamente*/
        char teclaPresionada = evt.getKeyChar();

        if(jTextFieldDNIPacienteCita.getText().length() < 8)
            if(Character.isDigit(teclaPresionada) == false)
                evt.consume();

        if(jTextFieldDNIPacienteCita.getText().length() == 8)
            if(Character.isDigit(teclaPresionada) == true){
                evt.consume();
            }else if(Character.isLowerCase(teclaPresionada)){
                jTextFieldDNIPacienteCita.setText(jTextFieldDNIPacienteCita.getText().toUpperCase());
            }

        if(jTextFieldDNIPacienteCita.getText().length() > 8)
            evt.consume();
    }//GEN-LAST:event_jTextFieldDNIPacienteCitaKeyTyped

    private void jTextFieldDNIMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldDNIMedicoKeyTyped
        // TODO add your handling code here:

        /** Limitamos a que el DNI siempre sea correcto sintácticamente **/
        char teclaPresionada = evt.getKeyChar();

        if(jTextFieldDNIMedico.getText().length() < 8)
            if(Character.isDigit(teclaPresionada) == false)
                evt.consume();

        if(jTextFieldDNIMedico.getText().length() == 8)
            if(Character.isDigit(teclaPresionada) == true){
                evt.consume();
            }else if(Character.isLowerCase(teclaPresionada)){
                jTextFieldDNIMedico.setText(jTextFieldDNIMedico.getText().toUpperCase());
            }

        if(jTextFieldDNIMedico.getText().length() > 8)
            evt.consume();
    }//GEN-LAST:event_jTextFieldDNIMedicoKeyTyped

    private void jButtonAceptarCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAceptarCitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAceptarCitaMouseClicked

    private void jButtonConsultarCita1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsultarCita1MouseClicked

        // TODO add your handling code here:
        /*        try{
            GestorCitas gtcts = new GestorCitas();
            Cita ct = gtcts.ObtenerCita(user.getDNI());

            if(ct == null){
                JOptionPane.showMessageDialog(null, "No tiene ninguna cita concertada","Consultar", JOptionPane.INFORMATION_MESSAGE);
            }else{
                mostrarPanel("ConsultarCitaOnline");
                Date fechacita = ct.getFecha();

                jTextFieldMinutoCita.setText(String.valueOf(fechacita.getMinutes()));
                jTextFieldHoraCita.setText(String.valueOf(fechacita.getHours()));
                jTextFieldDiaCita.setText(String.valueOf(fechacita.getDay()));
                jTextFieldMesCita.setText(String.valueOf(fechacita.getMonth()));
                jTextFieldAnioCita.setText(String.valueOf(fechacita.getYear()));

                jTextFieldDNIMedico.setText("inventado");
                System.out.println(user.getDNI());
                jTextFieldDNIPacienteCita.setText(user.getDNI());
                jTextFieldDNIPacienteCita.setEditable(false);
                jTextFieldDNIMedico.setEditable(false);
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            jTextAreaInfo1.setText("¡Se produjo un error!\n\tPerdone las molestias");
        }*/

    }//GEN-LAST:event_jButtonConsultarCita1MouseClicked

    private void jButtonModificarPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificarPacienteMouseClicked

        // TODO add your handling code here:
         if(compruebaFormulario("GestionarPaciente")){
            GestorPacientes gesPac = new GestorPacientes();
            Date fechaNacimiento = null;                        
            byte[] urlFoto = null;                             
            boolean exito;
            String url=null;

            fechaNacimiento = dateChooserCombo2.getSelectedDate().getTime();

            try {
                exito = gesPac.modificarPaciente(jTextFieldDNIPaciente.getText(), jTextFieldNombrePaciente.getText(), jTextFieldApellidosPaciente.getText(), jTextFieldDireccionPaciente.getText(), jTextFieldEmailPaciente.getText(),jTextFieldContraseniaPaciente.getText(), jTextFieldTelefonoPaciente.getText(), fechaNacimiento, jTextFieldLugarNacimientoPaciente.getText(), sfotografia);

                if(exito)
                    JOptionPane.showMessageDialog(null, "Su operación se realizó", "Éxito",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "Se produjo un error", "Error",JOptionPane.ERROR_MESSAGE);
                
            } catch (Exception ex) {
                Logger.getLogger(UI_Paciente.class.getName()).log(Level.SEVERE, null, ex);
            }//catch (SQLException ex) {
               // Logger.getLogger(UI_Administrador.class.getName()).log(Level.SEVERE, null, ex);
           // }

        }
        
    }//GEN-LAST:event_jButtonModificarPacienteMouseClicked

    private void jButtonConsultarRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsultarRecetaMouseClicked
        // TODO add your handling code here:
         try{
            String receta_string = (String)jList3.getSelectedValue(),
            valores="",
                       numero="";

            String receta_id="";
            char espacio=' ';
            boolean ya=false;

            for ( int i=receta_string.length()-1; i>0 && !ya; i--){
                if (receta_string.charAt(i)!= espacio){
                    receta_id+=String.valueOf(receta_string.charAt(i));
                }
                else ya=true;

            }
        
       
           
                Receta receta = gstPac.seleccionarReceta(Integer.valueOf(receta_id));

                //Mostrar los datos de la receta
                jTextPane2.setText(receta.getJuicioDiagnostico());
                jTextPane1.setText(receta.getInstrucciones());
                jTextFieldFechaReceta.setText(receta.getFecha().toString());
                /*jTextFieldDNIMedicoReceta.setText(receta.getMedi().getDNI());
                jTextFieldNombreMedicoReceta.setText(receta.getMedi().getNombre() + " " + receta.getMedi().getApellidos());
                jTextFieldTelefonoMedicoReceta.setText(receta.getMedi().getTelefono());
                jTextFieldEmailMedicoReceta.setText(receta.getMedi().getEmail());
                 */
                
                jTextFieldDNIMedicoReceta.setText("no funciona receta.getMedi()");
                jTextFieldNombreMedicoReceta.setText("no funciona receta.getMedi()");
                jTextFieldTelefonoMedicoReceta.setText("no funciona receta.getMedi()");
                jTextFieldEmailMedicoReceta.setText("no funciona receta.getMedi()");
                        
                modelo.clear();
                jList8.setModel(modelo);
                Set<MedicamentoRecetado> medicamentos = receta.getMedicamentosRecetados();
                if( !(medicamentos.isEmpty() ) ){
                    for(Iterator<MedicamentoRecetado> it = medicamentos.iterator(); it.hasNext();){
                        modelo.addElement(it.next().getMedicamento().getNombre());
                    }
                }else{
                    modelo.addElement("No hay medicamentos");
                }
 
                mostrarPanel("ConsultarReceta");
            }
            catch(SQLException ex){
                System.err.println(ex.getStackTrace());
            }
    
    }//GEN-LAST:event_jButtonConsultarRecetaMouseClicked

    private void jButtonConsultarRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarRecetasActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonConsultarRecetasActionPerformed

    private void jButtonConsultarRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsultarRecetaActionPerformed

    private void jButtonConsultarRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsultarRecetasMouseClicked
        // TODO add your handling code here:

        //Vaciar el panel
        String espacio = "             ";
        modelo.clear();
        jList3.setModel(modelo);

        try{
            ArrayList<Receta> set_receta = gstPac.obtenerRecetas(user.getDNI());
            if(!set_receta.isEmpty()){
                Receta recet;
                for(Iterator it = set_receta.iterator(); it.hasNext();){
                    recet = (Receta)it.next();
                    String total="";
                    String fecha=recet.getFecha().toString();
                   String medico= recet.getMedi().getNombre();
                  
                    String id_string= String.valueOf(recet.getId());
                    total=fecha+espacio+medico+espacio+id_string;
                    modelo.addElement(total);
                }    
                jList3.setModel(modelo);
                mostrarPanel("VerRecetas");
            }else
                JOptionPane.showMessageDialog(null, "¡No tiene recetas disponibles!", "Aviso",JOptionPane.INFORMATION_MESSAGE);

        }
        catch(SQLException ex){
            System.err.println(ex.getStackTrace());
        }

    }//GEN-LAST:event_jButtonConsultarRecetasMouseClicked

    private void jButtonGestionarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGestionarCitaActionPerformed

    private void jButtonVolverRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVolverRecetaMouseClicked
        // TODO add your handling code here:
        mostrarPanel("VerRecetas");
    }//GEN-LAST:event_jButtonVolverRecetaMouseClicked

    private void jTextFieldDNIMedicoRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNIMedicoRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNIMedicoRecetaActionPerformed

    private void jTextFieldEmailMedicoRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailMedicoRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailMedicoRecetaActionPerformed

    private void jButtonVerPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerPruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVerPruebaActionPerformed

    private void jButtonConsPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsPruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsPruebaActionPerformed

    private void jButtonModificarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificarPacienteActionPerformed

    private void jButtonGestionarHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGestionarHistorialMouseClicked
        // TODO add your handling code here:
        
            ArrayList<Enfermedad> enf;
            try {
                enf = gstPac.consultarInfoClinicaPaciente(user.getDNI());
                if (enf!=null){
                    DefaultListModel modeloEnfermedades = new DefaultListModel();
                    String espacio = "            ";
                    Enfermedad enfermedad= null;
                    for ( Iterator it = enf.iterator(); it.hasNext();){
                        enfermedad = (Enfermedad)it.next();
                        String total="";
                        total=enfermedad.getNombre()+espacio+enfermedad.getFechaDet();
                        modeloEnfermedades.addElement(total);
                    }
                    jList5.setModel(modeloEnfermedades);
                    mostrarPanel("ConsultarHistorial");
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(UI_Medico.class.getName()).log(Level.SEVERE, null, ex);
            }

    }//GEN-LAST:event_jButtonGestionarHistorialMouseClicked

    private void jButtonGestionarHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarHistorialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGestionarHistorialActionPerformed

    private void jButtonConsultarPruebasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsultarPruebasMouseClicked
        // TODO add your handling code here:
        String dni = user.getDNI();
        boolean noAnalisis = false, noPruebas = false;

        String elemento, tabula = "                                         ";
        modelo.clear();//Inicializando la lista vacia
        jList4.setModel(modelo);

        try{
            ArrayList<ArrayList<String> > Pruebas = gstPac.obtenerPruebas(dni);
                ArrayList<String> pruebas = Pruebas.get(0); //Pruebas de Análisis
                if(!pruebas.isEmpty()){
                    for(int i = 0; i < pruebas.size(); i++){
                        elemento = "        " + pruebas.get(i) + tabula + "Análisis";
                        modelo.addElement(elemento);
                    }
                }else
                    noAnalisis = true;

                pruebas.clear();
                pruebas = Pruebas.get(1);   //Pruebas de Radiologia
                if(!pruebas.isEmpty()){
                    for(int i = 0; i < pruebas.size(); i++){
                        elemento = "        " + pruebas.get(i) + tabula + "Radiología";
                        modelo.addElement(elemento);
                    }
                }else
                    noPruebas = true;
                                
        }catch(SQLException ex){
            System.err.println(ex.getStackTrace());
        }

        if(noAnalisis && noPruebas)
                    JOptionPane.showMessageDialog(null, "¡No tiene pruebas disponibles!", "Aviso",JOptionPane.INFORMATION_MESSAGE);
        else
            mostrarPanel("VerPruebas");
    }//GEN-LAST:event_jButtonConsultarPruebasMouseClicked

    private void jButtonConsultarPruebasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPruebasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConsultarPruebasActionPerformed

    private void jButtonGestionarCitassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGestionarCitassMouseClicked
        // TODO add your handling code here:

        SimpleDateFormat formatofecha = new SimpleDateFormat("dd.MM.yyyy"),
                         formatohora = new SimpleDateFormat("hh:mm");
        String elemento, 
               tabula = "                                                    ",
               dni = user.getDNI();
        modelo.clear();//Inicializando la lista vacia
        jList9.setModel(modelo);

        try{
            ArrayList<Cita> array_citas = gstCit.VerCitas(dni);
            if(!array_citas.isEmpty()){
                for(int i = 0; i < array_citas.size(); i++){
                    elemento = formatofecha.format(array_citas.get(i).getFecha()) + tabula + formatohora.format(array_citas.get(i).getFecha());
                    modelo.addElement(elemento);
                }
                mostrarPanel("VerCitas");
            }else{
                JOptionPane.showMessageDialog(null, "¡No tiene citas disponibles!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException ex){
            System.err.println(ex.getStackTrace());
        }

    }//GEN-LAST:event_jButtonGestionarCitassMouseClicked

    private void jButtonGestionarCitassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionarCitassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGestionarCitassActionPerformed

    private void jButtonVerPruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVerPruebaMouseClicked
        // TODO add your handling code here:

        int index = jList4.getSelectedIndex();
        String idPrueba = "",
               tipo = "";
        char espacio = ' ';
        String seleccion = (String) modelo.getElementAt(jList4.getSelectedIndex());

        if(index > -1){
            for(int i = 0; i < seleccion.length(); i++){
                if(seleccion.charAt(i) != espacio){
                    idPrueba += String.valueOf(seleccion.charAt(i));
                    if(seleccion.charAt(i+1) == espacio)
                        i = seleccion.length();
                }
            }

            PruebaAnalisisBD paBD = new PruebaAnalisisBD();
            PruebaAnalisis pa = paBD.obtener(Integer.valueOf(idPrueba));
            tipo = pa.getClass().toString();
            ArrayList<String> Resultados = new ArrayList<String>();
            if(seleccion.contains("Análisis")){
                Resultados = gstPru.ConsultarPruebaAnalisis(Integer.valueOf(idPrueba), tipo);
            } else
                if(seleccion.contains("Radiología")){
                    Resultados = gstPru.ConsultarPruebaRadiologia(Integer.valueOf(idPrueba), tipo);
                }

            if(tipo.contains("Orina")){
                jTextField1.setText("Orina");
            } else
                if(tipo.contains("Sangre")){
                    jTextField1.setText("Orina");
                } else
                    if(tipo.contains("Radiografia")){
                        jTextField1.setText("Radiografia");
                    } else
                        if(tipo.contains("Resonancia"))
                            jTextField1.setText("Resonancia");
            if(!Resultados.isEmpty())
                jTextField2.setText(Resultados.get(0));
            else
                jTextField2.setText("No hay resultados disponibles");
            jTextField3.setText(String.valueOf(idPrueba));

            if(seleccion.contains("Análisis")){
                modelo.clear();
                jList7.setModel(modelo);
                for(int i = 0; i < Resultados.size(); i++)
                    modelo.addElement(Resultados.get(i));
                mostrarPanel("PruebaAnalista");
            }else
                if(seleccion.contains("Radiología")){
                    modelo.clear();
                    jList6.setModel(modelo);
                    for(int i = 0; i < Resultados.size(); i++)
                        modelo.addElement(Resultados.get(i));
                    mostrarPanel("PruebaRadiologia");
                }
        }else
            JOptionPane.showMessageDialog(null, "No seleccionó ninguna prueba", "Selección prueba",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_jButtonVerPruebaMouseClicked

    private void jButtonConsCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsCitaMouseClicked
        // TODO add your handling code here:
        int index = jList9.getSelectedIndex();
        if(index > -1){
            try{
                ArrayList<Cita> array_cita = gstCit.VerCitas(user.getDNI());
                SimpleDateFormat formatofecha = new SimpleDateFormat("dd.MM.yyyy"),
                                 formatohora = new SimpleDateFormat("hh:mm");
                jTextPane3.setText(formatofecha.format(array_cita.get(index).getFecha()));
                jTextPane4.setText(formatohora.format(array_cita.get(index).getFecha()));
                jTextPane5.setText(array_cita.get(index).getTipo());
                if(array_cita.get(index).isEstado())
                    jTextPane6.setText("Pendiente");
                else
                    jTextPane6.setText("Realizada");
                jTextPane7.setText(array_cita.get(index).getDNIPaciente());
                jTextPane8.setText(user.getNombre() + " " + user.getApellidos());
                jTextPane9.setText(user.getTelefono());
                jTextPane10.setText(user.getEmail());
            }
            catch(SQLException ex){
                System.err.println(ex.getStackTrace());
            }


            mostrarPanel("DetalleCita");


        }else{
            JOptionPane.showMessageDialog(null, "No seleccionó ninguna cita", "Selección cita",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConsCitaMouseClicked

    private void jButtonConsPruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsPruebaMouseClicked

        try {
            // TODO add your handling code here:
            
            String dato=null;
            ArrayList  <ArrayList<String>> pruebas=gstPac.obtenerPruebas(user.getDNI());
            boolean analisis=true;
            PruebaAnalisis pa;
            PruebaRadiologia pr;
            ArrayList finales =null;
            DefaultListModel modeloPruebas = new DefaultListModel();
            if(pruebas.size()!=0){            
                for(Iterator it = pruebas.iterator(); it.hasNext();){
                    finales=(ArrayList)it.next();
                    if(finales!=null){
                    }
                    for(Iterator itPrueba= finales.iterator(); itPrueba.hasNext();){
                        if(analisis){
                            pa=(PruebaAnalisis)itPrueba.next();
                            modeloPruebas.addElement("Analisis                              "+String.valueOf(pa.getId()));
                        }
                        else{
                            dato=(String)itPrueba.next();
                            modeloPruebas.addElement("Radiologia                              "+dato);
                        }
                    }
                    analisis=false;
                }
                jList4.setModel(modeloPruebas);
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(UI_Paciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        pasoAtras=true;
        mostrarPanel("VerPruebas");
        
    }//GEN-LAST:event_jButtonConsPruebaMouseClicked

    private void jButtonConsRecetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsRecetaMouseClicked
        // TODO add your handling code here:
        mostrarPanel("VerRecetas");
    }//GEN-LAST:event_jButtonConsRecetaMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        mostrarPanel("VerCitas");
    }//GEN-LAST:event_jButton1MouseClicked


    /*Comprueba que la fecha introducida es correcta
     * 
     *@param persona, string que indica si se trata del formulario de Paciente o Personal
     *@return booleano diciendo si es válido o no
     */
   private boolean compruebaFecha(String formulario){

        int dia = 0;
        int mes = 0;
        int anio = 0;
        int diaActual;
        int mesActual;
        int anioActual;
        Calendar fecha;

        if(formulario.equals("GestionarPaciente")){
            fecha=dateChooserCombo2.getSelectedDate();

           dia=fecha.get(Calendar.DATE);
           mes=fecha.get(Calendar.MONTH)+1;
           anio=fecha.get(Calendar.YEAR);

        }


        if(formulario.equals("GestionarCitaOnline")){
            dia = Integer.parseInt(jTextFieldDiaCita.getText());
            mes = Integer.parseInt(jTextFieldMesCita.getText());
            anio = Integer.parseInt(jTextFieldAnioCita.getText());
        }

         Date fechaa= new Date();
         diaActual=fechaa.getDate();
         mesActual=fechaa.getMonth()+1;
         anioActual=fechaa.getYear()+1901;



        /**Si se sale de los rangos*/
        if((dia <= 0)
                || (dia > 31)
                || (mes <= 0)
                || (mes > 12)
                || (anio < 1900)
                || (anio > anioActual) ){
            return false;
        }

        /**Si ha nacido en el año actual, hay que ver que el mes no sea mayor que el actual*/
        /**Si ha nacido en el año y mes actual, hay que comprobar que el dia sea menor que el actual*/
        if(anio == anioActual){
            if(mes > mesActual){
                return false;
            } else{
                if(dia > diaActual){
                    return false;
                }
            }
        }

        /**Si estamos en un mes que tiene 30 días o 29 en el caso de febrero, hay que comprobar que no se pase*/
        if(mes%2 == 0){
            if((mes == 2) && (dia >29)){
                return false;
            }else{
                if(dia > 30){
                    return false;
                }
            }
        }

        return true;

    }


     /*Borra el formulario elegido
     *
     *@param persona, string que indica si se trata del formulario de Paciente o Personal
     */
    private void limpiarFormulario(String persona){

        String diaActual;
        String mesActual;
        String anioActual;
        String horaActual;
        String minutoActual;

        Calendar fechaActual = Calendar.getInstance();
        diaActual = Integer.toString(fechaActual.get(Calendar.DATE));
        mesActual = Integer.toString(fechaActual.get(Calendar.MONTH));
        anioActual = Integer.toString(fechaActual.get(Calendar.YEAR));
        horaActual = Integer.toString(fechaActual.get(Calendar.HOUR_OF_DAY));
        minutoActual = Integer.toString(fechaActual.get(Calendar.MINUTE));


        if(persona.equals("GestionarPaciente")){
            jTextFieldNombrePaciente.setText("");
            jTextFieldApellidosPaciente.setText("");
            jTextFieldDNIPaciente.setText("");
            jTextFieldDireccionPaciente.setText("");
            jTextFieldEmailPaciente.setText("");
            jTextFieldTelefonoPaciente.setText("");
            jTextFieldContraseniaPaciente.setText("");
            jTextFieldLugarNacimientoPaciente.setText("");

            jLabelFotoPaciente.setIcon(null);
        }

        if(persona.equals("GestionarCitaOnlineAlta")){
            jTextFieldDiaCita.setText(diaActual);
            jTextFieldMesCita.setText(mesActual);
            jTextFieldAnioCita.setText(anioActual);
            jTextFieldHoraCita.setText(horaActual);
            jTextFieldMinutoCita.setText(minutoActual);
        }
        
        if(persona.equals("ConsultarCitaOnline")){
            jTextFieldDNIPacienteCita.setText(null);
                jTextFieldDNIMedico.setText(null);
                jTextFieldMinutoCita.setText(null);
                jTextFieldHoraCita.setText(null);
                jTextFieldDiaCita.setText(null);
                jTextFieldMesCita.setText(null);
                jTextFieldAnioCita.setText(null);
        }

    }

    private boolean compruebaFormulario(String formulario){

        if(formulario.equals("GestionarPaciente")){

            if(!compruebaFecha("GestionarPaciente")){
                jLabelFechaNacimientoPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelFechaNacimientoPaciente.setForeground(Color.black);
                }

            if(jTextFieldNombrePaciente.getText().length() == 0){
                jLabelNombrePaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelNombrePaciente.setForeground(Color.black);
            }

            if(jTextFieldApellidosPaciente.getText().length() == 0){
                jLabelApellidosPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelApellidosPaciente.setForeground(Color.black);
            }

            if(jTextFieldDNIPaciente.getText().length() != 9){
                jLabelDNIPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelDNIPaciente.setForeground(Color.black);
            }

            if(jTextFieldDireccionPaciente.getText().length() == 0){
                jLabelDireccionPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelDireccionPaciente.setForeground(Color.black);
            }

            if(jTextFieldEmailPaciente.getText().length() == 0){
                jLabelEmailPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelEmailPaciente.setForeground(Color.black);
            }

            if(jTextFieldTelefonoPaciente.getText().length() == 0){
                jLabelTelefonoPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelTelefonoPaciente.setForeground(Color.black);
            }

            if(jTextFieldLugarNacimientoPaciente.getText().length() == 0){
                jLabelLugarNacimientoPaciente.setForeground(Color.red);
                return false;
                }else{
                jLabelLugarNacimientoPaciente.setForeground(Color.black);
            }

             }
        
            return true;

       
  
     }

    /*Muestra el panel elegido en ZonaTrabajo
     *
     *@param panel, string que indica el panel a mostrar
     */     
    private void mostrarPanel(String panel){

        /* Ocultar todos los paneles */
        jPanelPrincipal.setVisible(false);
        jPanelConsultarCitaOnline.setVisible(false);
        jPanelGestionarCitaOnline.setVisible(false);
        jPanelGestionarPaciente.setVisible(false);
        jPanelVerRecetas.setVisible(false);
        jPanelConsultarReceta.setVisible(false);
        jPanelVerPruebas.setVisible(false);
        jPanelConsultarHistorial.setVisible(false);
        jPanelPruebaRadiologia.setVisible(false);
        jPanelPruebaAnalista.setVisible(false);
        jPanelVerCita.setVisible(false);
        jPanelDetalleCita.setVisible(false);

        /* Ocultar todos los marcos */
        jPanelPrincipal.setBorder(null);
        jPanelGestionarPaciente.setBorder(null);
        jPanelGestionarCitaOnline.setBorder(null);
        jPanelConsultarCitaOnline.setBorder(null);
        jPanelVerRecetas.setBorder(null);
        jPanelConsultarReceta.setBorder(null);
        jPanelVerPruebas.setBorder(null);
        jPanelConsultarHistorial.setBorder(null);
        jPanelPruebaRadiologia.setBorder(null);
        jPanelPruebaAnalista.setBorder(null);
        jPanelVerCita.setBorder(null);
        jPanelDetalleCita.setBorder(null);
        
        if(panel.equals("Principal")){
            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(false);
            jLabelIconoInicio.setVisible(false);

            /**Hacemos visible el panel seleccionado*/
            jPanelPrincipal.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /**Activamos el marco*/
            jPanelPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);
        }

        if(panel.equals("GestionarPaciente")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Insertamos icono de foto anónima*/
            //jLabelFotoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Principal/Foto-Anonima.png"))); // NOI18N


            /**Hacemos visible el panel seleccionado*/
            jPanelGestionarPaciente.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /**Activamos el marco*/
            jPanelGestionarPaciente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);

        }

        if(panel.equals("GestionarCitaOnline")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);
            jPanelAltaCita.setVisible(false);
            jPanelBotones.setVisible(true);


            /**Hacemos visible el panel seleccionado*/
            jPanelGestionarCitaOnline.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /**Activamos el marco*/
            jPanelGestionarCitaOnline.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);
        
        }


        if(panel.equals("ConsultarCitaOnline")){

            /**Limpiamos posibles datos introducidos anteriormente*/
            limpiarFormulario("ConsultarCitaOnline");

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelConsultarCitaOnline.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /**Activamos el marco*/
            jPanelConsultarCitaOnline.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);
        }


        if(panel.equals("VerRecetas")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelVerRecetas.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /**Activamos el marco*/
            jPanelVerRecetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);

        }

        if(panel.equals("ConsultarReceta")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelConsultarReceta.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);

            /** Bloquear campos texto **/
            jTextPane2.setEditable(false);
            jTextPane1.setEditable(false);
            jTextFieldFechaReceta.setEditable(false);
            jTextFieldDNIMedicoReceta.setEditable(false);
            jTextFieldNombreMedicoReceta.setEditable(false);
            jTextFieldTelefonoMedicoReceta.setEditable(false);
            jTextFieldEmailMedicoReceta.setEditable(false);


            /**Activamos el marco*/
            jPanelVerRecetas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);
        }

        if(panel.equals("VerPruebas")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelVerPruebas.setVisible(true);
            
            /**Activamos el marco*/
            jPanelVerPruebas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);

        }

        if(panel.equals("VerCitas")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelVerCita.setVisible(true);
            jPanelConsultarHistorial.setVisible(false);
            jPanelPruebaRadiologia.setVisible(false);
            jPanelPruebaAnalista.setVisible(false);
            jPanelDetalleCita.setVisible(false);


            /**Activamos el marco*/
            jPanelConsultarHistorial.setBorder(null);
            jPanelPruebaRadiologia.setBorder(null);
            jPanelPruebaAnalista.setBorder(null);
            jPanelDetalleCita.setBorder(null);
            jPanelVerCita.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        }

        if(panel.equals("DetalleCita")){

            jTextPane3.setEditable(false);
            jTextPane4.setEditable(false);
            jTextPane5.setEditable(false);
            jTextPane6.setEditable(false);
            jTextPane7.setEditable(false);
            jTextPane8.setEditable(false);
            jTextPane9.setEditable(false);
            jTextPane10.setEditable(false);
            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelDetalleCita.setVisible(true);


            /**Activamos el marco*/
            jPanelDetalleCita.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        }

        if(panel.equals("ConsultarHistorial")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelConsultarHistorial.setVisible(true);
            
            /**Activamos el marco*/
            jPanelConsultarHistorial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        }

         if(panel.equals("PruebaAnalista")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelPruebaAnalista.setVisible(true);
            /**Activamos el marco*/
            jPanelPruebaAnalista.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        }

        if(panel.equals("PruebaRadiologia")){

            /**Hacemos visible el botón jLabelIconoInicio*/
            jLabelInicio.setVisible(true);
            jLabelIconoInicio.setVisible(true);

            /**Hacemos visible el panel seleccionado*/
            jPanelPruebaRadiologia.setVisible(true);
            /**Activamos el marco*/
            jPanelPruebaRadiologia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        }

    }


     /*Carga la foto en el formulario pasado por parámetro
     *
     *@param formulario, string que indica el formulario donde cargar la foto
     */
    private void cargarFoto(String formulario){

       /* if(formulario.equals("GestionarPaciente")){
            JFileChooser dlg = new JFileChooser();
            int resp = dlg.showOpenDialog(this);
            if (resp == JFileChooser.APPROVE_OPTION){
                try{
                    ImageIcon icono = new ImageIcon(dlg.getSelectedFile().getCanonicalPath());
                    Image imagen = icono.getImage();
                    ImageIcon aescala = new ImageIcon(imagen.getScaledInstance(130,150,Image.SCALE_SMOOTH));
                    jLabelFotoPaciente.setIcon(aescala); // NOI18N
                }
                catch(Exception ex){
                    System.err.print("Error al leer el archivo");
                }
            }
        }
*/
    }


    
    // @param args the command line arguments
    
/*    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI_Paciente("Paciente", "paciente").setVisible(true);
            }
        });
    }
*/
    Boolean pasoAtras;
    byte[] sfotografia;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane ZonaTrabajo;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAceptarCita;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsCita;
    private javax.swing.JButton jButtonConsPrueba;
    private javax.swing.JButton jButtonConsReceta;
    private javax.swing.JButton jButtonConsultarCita1;
    private javax.swing.JButton jButtonConsultarPruebas;
    private javax.swing.JButton jButtonConsultarReceta;
    private javax.swing.JButton jButtonConsultarRecetas;
    private javax.swing.JButton jButtonGestionarCita;
    private javax.swing.JButton jButtonGestionarCitass;
    private javax.swing.JButton jButtonGestionarHistorial;
    private javax.swing.JButton jButtonGestionarPaciente;
    private javax.swing.JButton jButtonMasAnioFecha;
    private javax.swing.JButton jButtonMasDiaFecha;
    private javax.swing.JButton jButtonMasHora;
    private javax.swing.JButton jButtonMasMesFecha;
    private javax.swing.JButton jButtonMasMinuto;
    private javax.swing.JButton jButtonMenosAnioPersonal;
    private javax.swing.JButton jButtonMenosDiaFecha;
    private javax.swing.JButton jButtonMenosHora;
    private javax.swing.JButton jButtonMenosMesFecha;
    private javax.swing.JButton jButtonMenosMinuto;
    private javax.swing.JButton jButtonModificarCitaOnline;
    private javax.swing.JButton jButtonModificarPaciente;
    private javax.swing.JButton jButtonPedirAltaCita;
    private javax.swing.JButton jButtonVerPrueba;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JButton jButtonVolverReceta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel18FechaReceta;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelApellidosPaciente;
    private javax.swing.JLabel jLabelAyuda;
    private javax.swing.JLabel jLabelCentroMedico;
    private javax.swing.JLabel jLabelContraseniaPaciente;
    private javax.swing.JLabel jLabelDNIMedicoReceta;
    private javax.swing.JLabel jLabelDNIPaciente;
    private javax.swing.JLabel jLabelDireccionPaciente;
    private javax.swing.JLabel jLabelEmailMedicoReceta;
    private javax.swing.JLabel jLabelEmailPaciente;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFecha1;
    private javax.swing.JLabel jLabelFecha2;
    private javax.swing.JLabel jLabelFechaNacimientoPaciente;
    private javax.swing.JLabel jLabelFechaReceta;
    private javax.swing.JLabel jLabelFotoPaciente;
    private javax.swing.JLabel jLabelFotografiaPaciente;
    private javax.swing.JLabel jLabelGestionarCita1;
    private javax.swing.JLabel jLabelGestionarPaciente2;
    private javax.swing.JLabel jLabelGestionarPaciente3;
    private javax.swing.JLabel jLabelGestionarPaciente4;
    private javax.swing.JLabel jLabelGestionarPaciente5;
    private javax.swing.JLabel jLabelGestionarPaciente7;
    private javax.swing.JLabel jLabelHoraCita;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelIconoAyuda;
    private javax.swing.JLabel jLabelIconoInicio;
    private javax.swing.JLabel jLabelIconoSalir;
    private javax.swing.JLabel jLabelInformacionDetalladaReceta;
    private javax.swing.JLabel jLabelInicio;
    private javax.swing.JLabel jLabelInstruccionReceta;
    private javax.swing.JLabel jLabelJuicioReceta;
    private javax.swing.JLabel jLabelListaRecetas;
    private javax.swing.JLabel jLabelLugarNacimientoPaciente;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelMedico1;
    private javax.swing.JLabel jLabelMedicoReceta;
    private javax.swing.JLabel jLabelNombreMedicoReceta;
    private javax.swing.JLabel jLabelNombrePaciente;
    private javax.swing.JLabel jLabelNombreUsuario;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelTelefonoPaciente;
    private javax.swing.JLabel jLabelTipoUsuario;
    private javax.swing.JLabel jLabelTipoUsuarioIdentificado;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JList jList1;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JList jList7;
    private javax.swing.JList jList8;
    private javax.swing.JList jList9;
    private javax.swing.JPanel jPanelAltaCita;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelConsultarCitaOnline;
    private javax.swing.JPanel jPanelConsultarHistorial;
    private javax.swing.JPanel jPanelConsultarReceta;
    private javax.swing.JPanel jPanelDetalleCita;
    private javax.swing.JPanel jPanelGestionarCitaOnline;
    private javax.swing.JPanel jPanelGestionarPaciente;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelPruebaAnalista;
    private javax.swing.JPanel jPanelPruebaRadiologia;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPanel jPanelVerCita;
    private javax.swing.JPanel jPanelVerPruebas;
    private javax.swing.JPanel jPanelVerRecetas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JTextArea jTextAreaInfo1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldAnioCita;
    private javax.swing.JTextField jTextFieldApellidosPaciente;
    private javax.swing.JTextField jTextFieldContraseniaPaciente;
    private javax.swing.JTextField jTextFieldDNIMedico;
    private javax.swing.JTextField jTextFieldDNIMedicoReceta;
    private javax.swing.JTextField jTextFieldDNIPaciente;
    private javax.swing.JTextField jTextFieldDNIPacienteCita;
    private javax.swing.JTextField jTextFieldDiaCita;
    private javax.swing.JTextField jTextFieldDireccionPaciente;
    private javax.swing.JTextField jTextFieldEmailMedicoReceta;
    private javax.swing.JTextField jTextFieldEmailPaciente;
    private javax.swing.JTextField jTextFieldFechaReceta;
    private javax.swing.JTextField jTextFieldHoraCita;
    private javax.swing.JTextField jTextFieldLugarNacimientoPaciente;
    private javax.swing.JTextField jTextFieldMesCita;
    private javax.swing.JTextField jTextFieldMinutoCita;
    private javax.swing.JTextField jTextFieldNombreMedicoReceta;
    private javax.swing.JTextField jTextFieldNombrePaciente;
    private javax.swing.JTextField jTextFieldTelefonoMedicoReceta;
    private javax.swing.JTextField jTextFieldTelefonoPaciente;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    // End of variables declaration//GEN-END:variables

}
