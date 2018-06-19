package org.marcelo.software.gui;

import com.jtattoo.plaf.luna.LunaLookAndFeel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Condena;
import model.CriminalMuyPeligroso;
import model.Data;
import model.Delito;
import model.Genero;
import model.Juez;
import model.Perpetrador;
import model.TMModelCondena;
import model.TMModelCriminalMuyPeligroso;
import model.TMModelDelito;
import model.TMModelJuez;
import model.TMModelOrientacionSexual;
import model.TMModelPerpetrador;
import model.TMModelTipoDeDelito;
import model.TMModelVictima;
import model.TipoDeDelito;
import model.Victima;

public class App extends javax.swing.JFrame {

    private Data d;
    private TMModelOrientacionSexual modelOrientacionSexual;
    private TMModelTipoDeDelito modeloTipoDeDelito;
    private TMModelVictima modelVictima;
    private TMModelPerpetrador modelPerpetrador;
    private TMModelJuez modelJuez;
    private TMModelDelito modelDelito;
    private TMModelCondena modeloCondena;
    private TMModelCriminalMuyPeligroso modelocmp;

    private List<Genero> orientacionSexuales;
    private List<TipoDeDelito> tiposDeDelito;
    private List<Victima> listadoDeVictimas;
    private List<Perpetrador> listadoDePerpetradores;
    private List<Juez> listadoDeJueces;
    private List<Delito> listadoDeDelitos;
    private List<Condena> listadoDeCondenas;
    private List<CriminalMuyPeligroso> listadoCmp;

    public App() throws SQLException {
        initComponents();
        this.setTitle("Sistema de soporte a la PDI");
        this.setLocationRelativeTo(null);

        try {
            d = new Data();//Conexion exitosa, metodos de data se ejecutan con normalidad
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        rbtSexoMasculinoPerpetrador.setSelected(true);
        rbtSexoMasculinoJuez.setSelected(true);
        rbtSexoMasculinoVictima.setSelected(true);

      cargarTODASlasTablas();

        inicializarCboDelito();

    }

    private void cargarTODASlasTablas() throws SQLException {
        cargarTablaOrientacionesSexuales();
        cargarTablaTiposDeDelito();
        cargarTablaVictimas();
        cargarTablaPerpetradores();
        cargarTablaJueces();
        cargarTablaDelitos();
        cargarTablaCondenas();
        cargarTablaInforme();

    }

    private void msgDeOperacionExitosa() {
        String titulo = "Mensaje";
        String msg = "Operacion exitosa";
        int tipo_msg = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, msg, titulo, tipo_msg);
    }

    private void msgDatosIncorrectos() {
        String titulo = "Error";
        String msg = "Verificar datos";
        int tipo_msg = JOptionPane.ERROR_MESSAGE;
        JOptionPane.showMessageDialog(null, msg, titulo, tipo_msg);
    }

    private void inicializarCboDelito() throws SQLException {
        cboTipoDelito.removeAllItems();

        tiposDeDelito = d.leerTodosLosTiposDeDelitos();

        for (TipoDeDelito td : tiposDeDelito) {

            cboTipoDelito.addItem(td.toString());

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrPerpetrador = new javax.swing.ButtonGroup();
        btnGrJuez = new javax.swing.ButtonGroup();
        btnGrVictima = new javax.swing.ButtonGroup();
        tbpOpciones = new javax.swing.JTabbedPane();
        pnlPerpetrador = new javax.swing.JPanel();
        lblRunPerpetrador = new javax.swing.JLabel();
        lblNombrePerpetrador = new javax.swing.JLabel();
        lblApellidoPerpetrador = new javax.swing.JLabel();
        lblEdadPerpetrador = new javax.swing.JLabel();
        lblGeneroPerpetrador = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRunPerpetrador = new javax.swing.JTextField();
        txtNombrePerpetrador = new javax.swing.JTextField();
        txtApellidoPerpetrador = new javax.swing.JTextField();
        rbtSexoMasculinoPerpetrador = new javax.swing.JRadioButton();
        rbtSexoFemeninoPerpetrador = new javax.swing.JRadioButton();
        txtGeneroPerpetrador = new javax.swing.JTextField();
        spnEdadPerpetrador = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPerpetrador = new javax.swing.JTable();
        btnRegistrarPerpetrador = new javax.swing.JButton();
        pnlVictima = new javax.swing.JPanel();
        lblRunVictima = new javax.swing.JLabel();
        lblNombreVictima = new javax.swing.JLabel();
        lblApellidoVictima = new javax.swing.JLabel();
        lblEdadVictima = new javax.swing.JLabel();
        lblGeneroDeVictima = new javax.swing.JLabel();
        lblSexoVictima = new javax.swing.JLabel();
        txtRunVictima = new javax.swing.JTextField();
        txtNombreVictima = new javax.swing.JTextField();
        txtApellidoVictima = new javax.swing.JTextField();
        txtGeneroVictima = new javax.swing.JTextField();
        rbtSexoMasculinoVictima = new javax.swing.JRadioButton();
        rbtSexoFemeninoVictima = new javax.swing.JRadioButton();
        spnEdadVictima = new javax.swing.JSpinner();
        btnRegistrarVictima = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVictima = new javax.swing.JTable();
        pnlJuez = new javax.swing.JPanel();
        lblRunJuez = new javax.swing.JLabel();
        lblNombreJuez = new javax.swing.JLabel();
        lblApellidoJuez = new javax.swing.JLabel();
        lblEdadJuez = new javax.swing.JLabel();
        lblGeneroJuez = new javax.swing.JLabel();
        lblSexoJuez = new javax.swing.JLabel();
        txtRunJuez = new javax.swing.JTextField();
        txtNombreJuez = new javax.swing.JTextField();
        txtApellidoJuez = new javax.swing.JTextField();
        txtGeneroJuez = new javax.swing.JTextField();
        spnEdadJuez = new javax.swing.JSpinner();
        rbtSexoMasculinoJuez = new javax.swing.JRadioButton();
        rbtSexoFemeninoJuez = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblJuez = new javax.swing.JTable();
        btnRegistrarJuez = new javax.swing.JToggleButton();
        pnlOrientacionSexual = new javax.swing.JPanel();
        lblNombreOrientacionSexual = new javax.swing.JLabel();
        txtNombreOrientacionSexual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrientacionSexual = new javax.swing.JTable();
        btnIngresarOrientacionSexual = new javax.swing.JToggleButton();
        pnlTipoDeDelito = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTipoDeDelito = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTipoDeDelito = new javax.swing.JTable();
        btnRegistrarNombreTipoDeDelito = new javax.swing.JButton();
        pnlDelito = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDelito = new javax.swing.JTable();
        lblTipoDeDelitoDelito = new javax.swing.JLabel();
        lblRunPerpDelito = new javax.swing.JLabel();
        lblRunVictDelito = new javax.swing.JLabel();
        lblDetalleDelito = new javax.swing.JLabel();
        lblFechaDelito = new javax.swing.JLabel();
        txtRunPerpDelito = new javax.swing.JTextField();
        txtRunVictimaDelito = new javax.swing.JTextField();
        txtDetalleDelito = new javax.swing.JTextField();
        txtFechaDelito = new javax.swing.JTextField();
        cboTipoDelito = new javax.swing.JComboBox<>();
        btnRegistrarDelito = new javax.swing.JButton();
        pnlCondena = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCondena = new javax.swing.JTable();
        lblRunJuezCondena = new javax.swing.JLabel();
        lblIdDelitoCondena = new javax.swing.JLabel();
        txtRunJuezCondena = new javax.swing.JTextField();
        txtIdDelitoJuez = new javax.swing.JTextField();
        btnRegistrarCondena = new javax.swing.JButton();
        pnlInforme = new javax.swing.JPanel();
        lblTop3Criminales = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTop3Criminales = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRunPerpetrador.setText("Run:");

        lblNombrePerpetrador.setText("Nombre:");

        lblApellidoPerpetrador.setText("Apellido:");

        lblEdadPerpetrador.setText("Edad:");

        lblGeneroPerpetrador.setText("Genero:");

        jLabel6.setText("Sexo:");

        txtRunPerpetrador.setText(" ");

        txtNombrePerpetrador.setText(" ");

        btnGrPerpetrador.add(rbtSexoMasculinoPerpetrador);
        rbtSexoMasculinoPerpetrador.setText("Masculino");

        btnGrPerpetrador.add(rbtSexoFemeninoPerpetrador);
        rbtSexoFemeninoPerpetrador.setText("Femenino");

        spnEdadPerpetrador.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        tblPerpetrador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblPerpetrador);

        btnRegistrarPerpetrador.setText("Registrar");
        btnRegistrarPerpetrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPerpetradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPerpetradorLayout = new javax.swing.GroupLayout(pnlPerpetrador);
        pnlPerpetrador.setLayout(pnlPerpetradorLayout);
        pnlPerpetradorLayout.setHorizontalGroup(
            pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                        .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPerpetradorLayout.createSequentialGroup()
                                .addComponent(lblNombrePerpetrador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                                .addComponent(lblRunPerpetrador)
                                .addGap(28, 28, 28)))
                        .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRunPerpetrador, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(txtNombrePerpetrador))
                        .addGap(41, 41, 41)
                        .addComponent(btnRegistrarPerpetrador))
                    .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSexoMasculinoPerpetrador)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSexoFemeninoPerpetrador))
                    .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                            .addComponent(lblGeneroPerpetrador)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtGeneroPerpetrador))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPerpetradorLayout.createSequentialGroup()
                            .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPerpetradorLayout.createSequentialGroup()
                                    .addComponent(lblApellidoPerpetrador)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                                    .addComponent(lblEdadPerpetrador)
                                    .addGap(23, 23, 23)))
                            .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtApellidoPerpetrador)
                                .addComponent(spnEdadPerpetrador, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPerpetradorLayout.setVerticalGroup(
            pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunPerpetrador)
                    .addComponent(txtRunPerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombrePerpetrador)
                            .addComponent(txtNombrePerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnRegistrarPerpetrador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoPerpetrador)
                    .addComponent(txtApellidoPerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdadPerpetrador)
                    .addComponent(spnEdadPerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroPerpetrador)
                    .addComponent(txtGeneroPerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbtSexoMasculinoPerpetrador)
                    .addComponent(rbtSexoFemeninoPerpetrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        tbpOpciones.addTab("Perpetrador", pnlPerpetrador);

        lblRunVictima.setText("Run:");

        lblNombreVictima.setText("Nombre:");

        lblApellidoVictima.setText("Apellido:");

        lblEdadVictima.setText("Edad:");

        lblGeneroDeVictima.setText("Genero:");

        lblSexoVictima.setText("Sexo:");

        btnGrVictima.add(rbtSexoMasculinoVictima);
        rbtSexoMasculinoVictima.setText("Masculino");

        btnGrVictima.add(rbtSexoFemeninoVictima);
        rbtSexoFemeninoVictima.setText("Femenino");

        spnEdadVictima.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        btnRegistrarVictima.setText("Registrar");
        btnRegistrarVictima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVictimaActionPerformed(evt);
            }
        });

        tblVictima.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblVictima);

        javax.swing.GroupLayout pnlVictimaLayout = new javax.swing.GroupLayout(pnlVictima);
        pnlVictima.setLayout(pnlVictimaLayout);
        pnlVictimaLayout.setHorizontalGroup(
            pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVictimaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVictimaLayout.createSequentialGroup()
                        .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVictimaLayout.createSequentialGroup()
                                    .addComponent(lblRunVictima)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtRunVictima))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVictimaLayout.createSequentialGroup()
                                    .addComponent(lblNombreVictima)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNombreVictima, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVictimaLayout.createSequentialGroup()
                                    .addComponent(lblGeneroDeVictima)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtGeneroVictima))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlVictimaLayout.createSequentialGroup()
                                    .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblApellidoVictima)
                                        .addComponent(lblEdadVictima))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtApellidoVictima)
                                        .addComponent(spnEdadVictima, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))))
                        .addGap(41, 41, 41)
                        .addComponent(btnRegistrarVictima))
                    .addGroup(pnlVictimaLayout.createSequentialGroup()
                        .addComponent(lblSexoVictima)
                        .addGap(18, 18, 18)
                        .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlVictimaLayout.createSequentialGroup()
                                .addComponent(rbtSexoMasculinoVictima)
                                .addGap(10, 10, 10)
                                .addComponent(rbtSexoFemeninoVictima)))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        pnlVictimaLayout.setVerticalGroup(
            pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVictimaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunVictima)
                    .addComponent(txtRunVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarVictima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreVictima)
                    .addComponent(txtNombreVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVictimaLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblApellidoVictima))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVictimaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellidoVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdadVictima)
                    .addComponent(spnEdadVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroDeVictima)
                    .addComponent(txtGeneroVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoVictima)
                    .addComponent(rbtSexoMasculinoVictima)
                    .addComponent(rbtSexoFemeninoVictima))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Victima", pnlVictima);

        lblRunJuez.setText("Run:");

        lblNombreJuez.setText("Nombre:");

        lblApellidoJuez.setText("Apellido:");

        lblEdadJuez.setText("Edad:");

        lblGeneroJuez.setText("Genero:");

        lblSexoJuez.setText("Sexo:");

        spnEdadJuez.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        btnGrJuez.add(rbtSexoMasculinoJuez);
        rbtSexoMasculinoJuez.setText("Masculino");

        btnGrJuez.add(rbtSexoFemeninoJuez);
        rbtSexoFemeninoJuez.setText("Femenino");

        tblJuez.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblJuez);

        btnRegistrarJuez.setText("Registrar");
        btnRegistrarJuez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarJuezActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJuezLayout = new javax.swing.GroupLayout(pnlJuez);
        pnlJuez.setLayout(pnlJuezLayout);
        pnlJuezLayout.setHorizontalGroup(
            pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuezLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuezLayout.createSequentialGroup()
                        .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlJuezLayout.createSequentialGroup()
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGeneroJuez)
                                    .addComponent(lblSexoJuez))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlJuezLayout.createSequentialGroup()
                                        .addComponent(rbtSexoMasculinoJuez)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtSexoFemeninoJuez)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtGeneroJuez)))
                            .addGroup(pnlJuezLayout.createSequentialGroup()
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoJuez)
                                    .addComponent(lblEdadJuez))
                                .addGap(10, 10, 10)
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoJuez)
                                    .addComponent(spnEdadJuez)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlJuezLayout.createSequentialGroup()
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreJuez)
                                    .addComponent(lblRunJuez))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRunJuez)
                                    .addComponent(txtNombreJuez))))
                        .addGap(35, 35, 35)
                        .addComponent(btnRegistrarJuez)
                        .addGap(380, 380, 380)))
                .addContainerGap())
        );
        pnlJuezLayout.setVerticalGroup(
            pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuezLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunJuez)
                    .addComponent(txtRunJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreJuez)
                    .addComponent(txtNombreJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarJuez))
                .addGap(20, 20, 20)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidoJuez)
                    .addComponent(txtApellidoJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdadJuez)
                    .addComponent(spnEdadJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGeneroJuez)
                    .addComponent(txtGeneroJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoJuez)
                    .addComponent(rbtSexoMasculinoJuez)
                    .addComponent(rbtSexoFemeninoJuez))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Juez", pnlJuez);

        lblNombreOrientacionSexual.setText("Nombre de orientacion Sexual:");

        tblOrientacionSexual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOrientacionSexual);

        btnIngresarOrientacionSexual.setText("Ingresar");
        btnIngresarOrientacionSexual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarOrientacionSexualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrientacionSexualLayout = new javax.swing.GroupLayout(pnlOrientacionSexual);
        pnlOrientacionSexual.setLayout(pnlOrientacionSexualLayout);
        pnlOrientacionSexualLayout.setHorizontalGroup(
            pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrientacionSexualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreOrientacionSexual)
                .addGap(18, 18, 18)
                .addComponent(txtNombreOrientacionSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarOrientacionSexual)
                .addContainerGap(296, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrientacionSexualLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOrientacionSexualLayout.setVerticalGroup(
            pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrientacionSexualLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreOrientacionSexual)
                    .addComponent(txtNombreOrientacionSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIngresarOrientacionSexual))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Orientacion Sexual", pnlOrientacionSexual);

        jLabel1.setText("Nombre tipo de delito:");

        tblTipoDeDelito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblTipoDeDelito);

        btnRegistrarNombreTipoDeDelito.setText("Registrar");
        btnRegistrarNombreTipoDeDelito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNombreTipoDeDelitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTipoDeDelitoLayout = new javax.swing.GroupLayout(pnlTipoDeDelito);
        pnlTipoDeDelito.setLayout(pnlTipoDeDelitoLayout);
        pnlTipoDeDelitoLayout.setHorizontalGroup(
            pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreTipoDeDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRegistrarNombreTipoDeDelito)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
        );
        pnlTipoDeDelitoLayout.setVerticalGroup(
            pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreTipoDeDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarNombreTipoDeDelito))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Tipo de delito", pnlTipoDeDelito);

        tblDelito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblDelito);

        lblTipoDeDelitoDelito.setText("Tipo de delito:");

        lblRunPerpDelito.setText("Run Perpetrador:");

        lblRunVictDelito.setText("Run Victima:");

        lblDetalleDelito.setText("Detalle:");

        lblFechaDelito.setText("Fecha de delito:");

        txtRunVictimaDelito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunVictimaDelitoActionPerformed(evt);
            }
        });

        cboTipoDelito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegistrarDelito.setText("Registrar");
        btnRegistrarDelito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDelitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDelitoLayout = new javax.swing.GroupLayout(pnlDelito);
        pnlDelito.setLayout(pnlDelitoLayout);
        pnlDelitoLayout.setHorizontalGroup(
            pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDelitoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(pnlDelitoLayout.createSequentialGroup()
                        .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDelitoLayout.createSequentialGroup()
                                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDelitoLayout.createSequentialGroup()
                                        .addComponent(lblFechaDelito)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFechaDelito))
                                    .addGroup(pnlDelitoLayout.createSequentialGroup()
                                        .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRunPerpDelito)
                                            .addComponent(lblTipoDeDelitoDelito))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboTipoDelito, 0, 215, Short.MAX_VALUE)
                                            .addComponent(txtRunPerpDelito)))
                                    .addGroup(pnlDelitoLayout.createSequentialGroup()
                                        .addComponent(lblDetalleDelito)
                                        .addGap(57, 57, 57)
                                        .addComponent(txtDetalleDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(172, 172, 172)
                                .addComponent(btnRegistrarDelito))
                            .addGroup(pnlDelitoLayout.createSequentialGroup()
                                .addComponent(lblRunVictDelito)
                                .addGap(35, 35, 35)
                                .addComponent(txtRunVictimaDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDelitoLayout.setVerticalGroup(
            pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDelitoLayout.createSequentialGroup()
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoDeDelitoDelito)
                    .addComponent(cboTipoDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunPerpDelito)
                    .addComponent(txtRunPerpDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarDelito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunVictDelito)
                    .addComponent(txtRunVictimaDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetalleDelito)
                    .addComponent(txtDetalleDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDelito)
                    .addComponent(txtFechaDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Delito", pnlDelito);

        tblCondena.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(tblCondena);

        lblRunJuezCondena.setText("Run juez:");

        lblIdDelitoCondena.setText("Id de delito");

        btnRegistrarCondena.setText("Registrar");
        btnRegistrarCondena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCondenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCondenaLayout = new javax.swing.GroupLayout(pnlCondena);
        pnlCondena.setLayout(pnlCondenaLayout);
        pnlCondenaLayout.setHorizontalGroup(
            pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCondenaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlCondenaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblIdDelitoCondena)
                    .addComponent(lblRunJuezCondena))
                .addGap(18, 18, 18)
                .addGroup(pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRunJuezCondena, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(txtIdDelitoJuez))
                .addGap(28, 28, 28)
                .addComponent(btnRegistrarCondena)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCondenaLayout.setVerticalGroup(
            pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCondenaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunJuezCondena)
                    .addComponent(txtRunJuezCondena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarCondena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdDelitoCondena)
                    .addComponent(txtIdDelitoJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        tbpOpciones.addTab("Condena", pnlCondena);

        lblTop3Criminales.setText("Top 3 criminales");

        tblTop3Criminales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(tblTop3Criminales);

        javax.swing.GroupLayout pnlInformeLayout = new javax.swing.GroupLayout(pnlInforme);
        pnlInforme.setLayout(pnlInformeLayout);
        pnlInformeLayout.setHorizontalGroup(
            pnlInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformeLayout.createSequentialGroup()
                .addGroup(pnlInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformeLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(lblTop3Criminales))
                    .addGroup(pnlInformeLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        pnlInformeLayout.setVerticalGroup(
            pnlInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTop3Criminales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Informe", pnlInforme);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tbpOpciones)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(tbpOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarOrientacionSexualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarOrientacionSexualActionPerformed

        String nombre = txtNombreOrientacionSexual.getText();
        try {
            d.crearOrientacionSexual(nombre);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();
        }

        try {
            cargarTablaOrientacionesSexuales();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtNombreOrientacionSexual.setText("");
        txtNombreOrientacionSexual.requestFocus();
        try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresarOrientacionSexualActionPerformed

    private void btnRegistrarNombreTipoDeDelitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNombreTipoDeDelitoActionPerformed
        String nombre = txtNombreTipoDeDelito.getText();
        try {
            d.crearTipoDeDelito(nombre);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();
        }

        try {
            cargarTablaTiposDeDelito();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            inicializarCboDelito();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtNombreTipoDeDelito.setText("");
        txtNombreTipoDeDelito.requestFocus();
          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRegistrarNombreTipoDeDelitoActionPerformed

    private void btnRegistrarVictimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVictimaActionPerformed
        String run = txtRunVictima.getText();
        String nombre = txtNombreVictima.getText();
        String apellido = txtApellidoVictima.getText();
        int edad = (Integer) spnEdadVictima.getValue();
        String genero = txtGeneroVictima.getText();
        String sexo = "";
        if (rbtSexoMasculinoVictima.isSelected()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }

        try {
            d.crearVictima(run, nombre, apellido, edad, genero, sexo);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();

        }

        try {
            cargarTablaVictimas();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtRunVictima.setText("");
        txtNombreVictima.setText("");
        txtApellidoVictima.setText("");
        txtGeneroVictima.setText("");
        rbtSexoMasculinoPerpetrador.setSelected(true);
          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarVictimaActionPerformed

    private void btnRegistrarPerpetradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPerpetradorActionPerformed
        String run = txtRunPerpetrador.getText();
        String nombre = txtNombrePerpetrador.getText();
        String apellido = txtApellidoPerpetrador.getText();
        int edad = (Integer) spnEdadPerpetrador.getValue();
        String genero = txtGeneroPerpetrador.getText();
        String sexo = "";
        if (rbtSexoMasculinoPerpetrador.isSelected()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }

        try {
            d.crearPerpetrador(run, nombre, apellido, edad, genero, sexo);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();

        }

        try {
            cargarTablaPerpetradores();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtRunPerpetrador.setText("");
        txtNombrePerpetrador.setText("");
        txtApellidoPerpetrador.setText("");
        txtGeneroPerpetrador.setText("");
        rbtSexoMasculinoPerpetrador.setSelected(true);
          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarPerpetradorActionPerformed

    private void btnRegistrarJuezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarJuezActionPerformed
        String run = txtRunJuez.getText();
        String nombre = txtNombreJuez.getText();
        String apellido = txtApellidoJuez.getText();
        int edad = (Integer) spnEdadJuez.getValue();
        String genero = txtGeneroJuez.getText();
        String sexo = "";
        if (rbtSexoMasculinoJuez.isSelected()) {
            sexo = "Masculino";
        } else {
            sexo = "Femenino";
        }

        try {
            d.crearJuez(run, nombre, apellido, edad, genero, sexo);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();

        }

        try {
            cargarTablaJueces();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtRunJuez.setText("");
        txtNombreJuez.setText("");
        txtApellidoJuez.setText("");
        txtGeneroJuez.setText("");
        rbtSexoMasculinoJuez.setSelected(true);

          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnRegistrarJuezActionPerformed

    private void btnRegistrarDelitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDelitoActionPerformed
        String seleccion = String.valueOf(cboTipoDelito.getSelectedItem());
        String runPerp = txtRunPerpDelito.getText();
        String runVict = txtRunVictimaDelito.getText();
        String detalle = txtDetalleDelito.getText();
        String fechaDelito = txtFechaDelito.getText();

        String[] partes = seleccion.split(". ");
        String parte1 = partes[0];
        String parte2 = partes[1];

        int idSelecccionadoTipoDelito = Integer.parseInt(parte1);

        try {
            d.crearDelito(1, idSelecccionadoTipoDelito, runPerp, runVict, detalle, fechaDelito, "irrelevante");//el id generado esta raro
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();
        }

        try {
            cargarTablaDelitos();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtRunPerpDelito.setText("");
        txtRunVictimaDelito.setText("");
        txtDetalleDelito.setText("");
        txtFechaDelito.setText("");
          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarDelitoActionPerformed

    private void txtRunVictimaDelitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunVictimaDelitoActionPerformed
        // Aqui nada
    }//GEN-LAST:event_txtRunVictimaDelitoActionPerformed

    private void btnRegistrarCondenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCondenaActionPerformed
        String run = txtRunJuezCondena.getText();
        int idDelito = Integer.parseInt(txtIdDelitoJuez.getText());

        try {
            d.crearCondena(1, run, idDelito);
            msgDeOperacionExitosa();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            msgDatosIncorrectos();
        }

        try {
            cargarTablaCondenas();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtRunJuezCondena.setText("");
        txtIdDelitoJuez.setText("");
          try {
            cargarTablaInforme();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnRegistrarCondenaActionPerformed

    /**
     * @param args the command line arguments
     */
    private void cargarTablaOrientacionesSexuales() throws SQLException {
        orientacionSexuales = new ArrayList();
        orientacionSexuales = d.leerTodasLasOrientacionesSexuales();
        modelOrientacionSexual = new TMModelOrientacionSexual(orientacionSexuales);
        tblOrientacionSexual.setModel(modelOrientacionSexual);

    }

    private void cargarTablaTiposDeDelito() throws SQLException {
        tiposDeDelito = new ArrayList();
        tiposDeDelito = d.leerTodosLosTiposDeDelitos();
        modeloTipoDeDelito = new TMModelTipoDeDelito(tiposDeDelito);
        tblTipoDeDelito.setModel(modeloTipoDeDelito);

    }

    private void cargarTablaVictimas() throws SQLException {
        listadoDeVictimas = new ArrayList();
        listadoDeVictimas = d.leerTodasLasVictimas();
        modelVictima = new TMModelVictima(listadoDeVictimas);
        tblVictima.setModel(modelVictima);

    }

    private void cargarTablaPerpetradores() throws SQLException {
        listadoDePerpetradores = new ArrayList();
        listadoDePerpetradores = d.leerTodosLosPerpetradores();
        modelPerpetrador = new TMModelPerpetrador(listadoDePerpetradores);
        tblPerpetrador.setModel(modelPerpetrador);

    }

    private void cargarTablaJueces() throws SQLException {
        listadoDeJueces = new ArrayList();
        listadoDeJueces = d.leerTodosLosJueces();
        modelJuez = new TMModelJuez(listadoDeJueces);
        tblJuez.setModel(modelJuez);

    }

    private void cargarTablaDelitos() throws SQLException {
        listadoDeDelitos = new ArrayList();
        listadoDeDelitos = d.leerTodosLosDelitos();
        modelDelito = new TMModelDelito(listadoDeDelitos);
        tblDelito.setModel(modelDelito);

    }

    private void cargarTablaCondenas() throws SQLException {
        listadoDeCondenas = new ArrayList();
        listadoDeCondenas = d.leerTodasLasCondenas();
        modeloCondena = new TMModelCondena(listadoDeCondenas);
        tblCondena.setModel(modeloCondena);
    }

    public void cargarTablaInforme() throws SQLException {
        listadoCmp = new ArrayList();
        listadoCmp = d.crearInformeEnTabla();
        modelocmp = new TMModelCriminalMuyPeligroso(listadoCmp);
        tblTop3Criminales.setModel(modelocmp);

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new LunaLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new App().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrJuez;
    private javax.swing.ButtonGroup btnGrPerpetrador;
    private javax.swing.ButtonGroup btnGrVictima;
    private javax.swing.JToggleButton btnIngresarOrientacionSexual;
    private javax.swing.JButton btnRegistrarCondena;
    private javax.swing.JButton btnRegistrarDelito;
    private javax.swing.JToggleButton btnRegistrarJuez;
    private javax.swing.JButton btnRegistrarNombreTipoDeDelito;
    private javax.swing.JButton btnRegistrarPerpetrador;
    private javax.swing.JButton btnRegistrarVictima;
    private javax.swing.JComboBox<String> cboTipoDelito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblApellidoJuez;
    private javax.swing.JLabel lblApellidoPerpetrador;
    private javax.swing.JLabel lblApellidoVictima;
    private javax.swing.JLabel lblDetalleDelito;
    private javax.swing.JLabel lblEdadJuez;
    private javax.swing.JLabel lblEdadPerpetrador;
    private javax.swing.JLabel lblEdadVictima;
    private javax.swing.JLabel lblFechaDelito;
    private javax.swing.JLabel lblGeneroDeVictima;
    private javax.swing.JLabel lblGeneroJuez;
    private javax.swing.JLabel lblGeneroPerpetrador;
    private javax.swing.JLabel lblIdDelitoCondena;
    private javax.swing.JLabel lblNombreJuez;
    private javax.swing.JLabel lblNombreOrientacionSexual;
    private javax.swing.JLabel lblNombrePerpetrador;
    private javax.swing.JLabel lblNombreVictima;
    private javax.swing.JLabel lblRunJuez;
    private javax.swing.JLabel lblRunJuezCondena;
    private javax.swing.JLabel lblRunPerpDelito;
    private javax.swing.JLabel lblRunPerpetrador;
    private javax.swing.JLabel lblRunVictDelito;
    private javax.swing.JLabel lblRunVictima;
    private javax.swing.JLabel lblSexoJuez;
    private javax.swing.JLabel lblSexoVictima;
    private javax.swing.JLabel lblTipoDeDelitoDelito;
    private javax.swing.JLabel lblTop3Criminales;
    private javax.swing.JPanel pnlCondena;
    private javax.swing.JPanel pnlDelito;
    private javax.swing.JPanel pnlInforme;
    private javax.swing.JPanel pnlJuez;
    private javax.swing.JPanel pnlOrientacionSexual;
    private javax.swing.JPanel pnlPerpetrador;
    private javax.swing.JPanel pnlTipoDeDelito;
    private javax.swing.JPanel pnlVictima;
    private javax.swing.JRadioButton rbtSexoFemeninoJuez;
    private javax.swing.JRadioButton rbtSexoFemeninoPerpetrador;
    private javax.swing.JRadioButton rbtSexoFemeninoVictima;
    private javax.swing.JRadioButton rbtSexoMasculinoJuez;
    private javax.swing.JRadioButton rbtSexoMasculinoPerpetrador;
    private javax.swing.JRadioButton rbtSexoMasculinoVictima;
    private javax.swing.JSpinner spnEdadJuez;
    private javax.swing.JSpinner spnEdadPerpetrador;
    private javax.swing.JSpinner spnEdadVictima;
    private javax.swing.JTable tblCondena;
    private javax.swing.JTable tblDelito;
    private javax.swing.JTable tblJuez;
    private javax.swing.JTable tblOrientacionSexual;
    private javax.swing.JTable tblPerpetrador;
    private javax.swing.JTable tblTipoDeDelito;
    private javax.swing.JTable tblTop3Criminales;
    private javax.swing.JTable tblVictima;
    private javax.swing.JTabbedPane tbpOpciones;
    private javax.swing.JTextField txtApellidoJuez;
    private javax.swing.JTextField txtApellidoPerpetrador;
    private javax.swing.JTextField txtApellidoVictima;
    private javax.swing.JTextField txtDetalleDelito;
    private javax.swing.JTextField txtFechaDelito;
    private javax.swing.JTextField txtGeneroJuez;
    private javax.swing.JTextField txtGeneroPerpetrador;
    private javax.swing.JTextField txtGeneroVictima;
    private javax.swing.JTextField txtIdDelitoJuez;
    private javax.swing.JTextField txtNombreJuez;
    private javax.swing.JTextField txtNombreOrientacionSexual;
    private javax.swing.JTextField txtNombrePerpetrador;
    private javax.swing.JTextField txtNombreTipoDeDelito;
    private javax.swing.JTextField txtNombreVictima;
    private javax.swing.JTextField txtRunJuez;
    private javax.swing.JTextField txtRunJuezCondena;
    private javax.swing.JTextField txtRunPerpDelito;
    private javax.swing.JTextField txtRunPerpetrador;
    private javax.swing.JTextField txtRunVictima;
    private javax.swing.JTextField txtRunVictimaDelito;
    // End of variables declaration//GEN-END:variables
}
