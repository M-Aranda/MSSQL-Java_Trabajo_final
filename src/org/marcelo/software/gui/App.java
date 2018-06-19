package org.marcelo.software.gui;

import com.jtattoo.plaf.luna.LunaLookAndFeel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Data;
import model.Genero;
import model.TMModelOrientacionSexual;

public class App extends javax.swing.JFrame {

    private Data d;
    private TMModelOrientacionSexual modelOrientacionSexual;

    private List<Genero> orientacionSexuales;

    public App() throws SQLException {
        initComponents();
        this.setTitle("Sistema de soporte a la PDI");
        this.setLocationRelativeTo(null);

        try {
            d = new Data();//Conexion exitosa, metodos de data se ejecutan con normalidad
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cargarTablaOrientacionesSexuales();

    }

    private void msgDeExito() {
        String titulo = "Mensaje";
        String msg = "Registro exitoso";
        int tipo_msg = JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(null, msg, titulo, tipo_msg);
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
        rbtSexoMasculino = new javax.swing.JRadioButton();
        rbtSexoFemenino = new javax.swing.JRadioButton();
        txtGeneroPerpetrador = new javax.swing.JTextField();
        spnEdadPerpetrador = new javax.swing.JSpinner();
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
        txtSexoJuez = new javax.swing.JTextField();
        spnEdadJuez = new javax.swing.JSpinner();
        rbtSexoMasculinoJuez = new javax.swing.JRadioButton();
        rbtSexoFemeninoJuez = new javax.swing.JRadioButton();
        pnlOrientacionSexual = new javax.swing.JPanel();
        lblNombreOrientacionSexual = new javax.swing.JLabel();
        txtNombreOrientacionSexual = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrientacionSexual = new javax.swing.JTable();
        pnlTipoDeDelito = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTipoDeDelito = new javax.swing.JTextField();
        pnlDelito = new javax.swing.JPanel();
        pnlCondena = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRunPerpetrador.setText("Run:");

        lblNombrePerpetrador.setText("Nombre:");

        lblApellidoPerpetrador.setText("Apellido:");

        lblEdadPerpetrador.setText("Edad:");

        lblGeneroPerpetrador.setText("Genero:");

        jLabel6.setText("Sexo:");

        txtRunPerpetrador.setText(" ");

        txtNombrePerpetrador.setText(" ");

        btnGrPerpetrador.add(rbtSexoMasculino);
        rbtSexoMasculino.setText("Masculino");

        btnGrPerpetrador.add(rbtSexoFemenino);
        rbtSexoFemenino.setText("Femenino");

        spnEdadPerpetrador.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        javax.swing.GroupLayout pnlPerpetradorLayout = new javax.swing.GroupLayout(pnlPerpetrador);
        pnlPerpetrador.setLayout(pnlPerpetradorLayout);
        pnlPerpetradorLayout.setHorizontalGroup(
            pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSexoMasculino)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSexoFemenino))
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
                            .addComponent(txtNombrePerpetrador)))
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
                .addContainerGap(376, Short.MAX_VALUE))
        );
        pnlPerpetradorLayout.setVerticalGroup(
            pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerpetradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunPerpetrador)
                    .addComponent(txtRunPerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPerpetradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePerpetrador)
                    .addComponent(txtNombrePerpetrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                    .addComponent(rbtSexoMasculino)
                    .addComponent(rbtSexoFemenino))
                .addContainerGap(293, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnlVictimaLayout = new javax.swing.GroupLayout(pnlVictima);
        pnlVictima.setLayout(pnlVictimaLayout);
        pnlVictimaLayout.setHorizontalGroup(
            pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVictimaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVictimaLayout.createSequentialGroup()
                        .addComponent(lblSexoVictima)
                        .addGap(18, 18, 18)
                        .addComponent(rbtSexoMasculinoVictima)
                        .addGap(10, 10, 10)
                        .addComponent(rbtSexoFemeninoVictima))
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
                .addGap(299, 394, Short.MAX_VALUE))
        );
        pnlVictimaLayout.setVerticalGroup(
            pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVictimaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVictimaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRunVictima)
                    .addComponent(txtRunVictima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(306, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnlJuezLayout = new javax.swing.GroupLayout(pnlJuez);
        pnlJuez.setLayout(pnlJuezLayout);
        pnlJuezLayout.setHorizontalGroup(
            pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJuezLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlJuezLayout.createSequentialGroup()
                        .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGeneroJuez)
                            .addComponent(lblSexoJuez))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlJuezLayout.createSequentialGroup()
                                .addComponent(rbtSexoMasculinoJuez)
                                .addGap(18, 18, 18)
                                .addComponent(rbtSexoFemeninoJuez))
                            .addGroup(pnlJuezLayout.createSequentialGroup()
                                .addComponent(txtSexoJuez)
                                .addGap(59, 59, 59))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJuezLayout.createSequentialGroup()
                        .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlJuezLayout.createSequentialGroup()
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApellidoJuez)
                                    .addComponent(lblEdadJuez))
                                .addGap(10, 10, 10)
                                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoJuez)
                                    .addComponent(spnEdadJuez)))
                            .addGroup(pnlJuezLayout.createSequentialGroup()
                                .addComponent(lblNombreJuez)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreJuez))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlJuezLayout.createSequentialGroup()
                                .addComponent(lblRunJuez)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRunJuez, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)))
                .addContainerGap(383, Short.MAX_VALUE))
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
                    .addComponent(txtNombreJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
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
                    .addComponent(txtSexoJuez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlJuezLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexoJuez)
                    .addComponent(rbtSexoMasculinoJuez)
                    .addComponent(rbtSexoFemeninoJuez))
                .addContainerGap(264, Short.MAX_VALUE))
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

        javax.swing.GroupLayout pnlOrientacionSexualLayout = new javax.swing.GroupLayout(pnlOrientacionSexual);
        pnlOrientacionSexual.setLayout(pnlOrientacionSexualLayout);
        pnlOrientacionSexualLayout.setHorizontalGroup(
            pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrientacionSexualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreOrientacionSexual)
                .addGap(18, 18, 18)
                .addComponent(txtNombreOrientacionSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrientacionSexualLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlOrientacionSexualLayout.setVerticalGroup(
            pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrientacionSexualLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlOrientacionSexualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreOrientacionSexual)
                    .addComponent(txtNombreOrientacionSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Orientacion Sexual", pnlOrientacionSexual);

        jLabel1.setText("Nombre tipo de delito:");

        javax.swing.GroupLayout pnlTipoDeDelitoLayout = new javax.swing.GroupLayout(pnlTipoDeDelito);
        pnlTipoDeDelito.setLayout(pnlTipoDeDelitoLayout);
        pnlTipoDeDelitoLayout.setHorizontalGroup(
            pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreTipoDeDelito, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );
        pnlTipoDeDelitoLayout.setVerticalGroup(
            pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTipoDeDelitoLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlTipoDeDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreTipoDeDelito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(448, Short.MAX_VALUE))
        );

        tbpOpciones.addTab("Tipo de delito", pnlTipoDeDelito);

        javax.swing.GroupLayout pnlDelitoLayout = new javax.swing.GroupLayout(pnlDelito);
        pnlDelito.setLayout(pnlDelitoLayout);
        pnlDelitoLayout.setHorizontalGroup(
            pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        pnlDelitoLayout.setVerticalGroup(
            pnlDelitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        tbpOpciones.addTab("Delito", pnlDelito);

        javax.swing.GroupLayout pnlCondenaLayout = new javax.swing.GroupLayout(pnlCondena);
        pnlCondena.setLayout(pnlCondenaLayout);
        pnlCondenaLayout.setHorizontalGroup(
            pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        pnlCondenaLayout.setVerticalGroup(
            pnlCondenaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        tbpOpciones.addTab("Condena", pnlCondena);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tbpOpciones)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void cargarTablaOrientacionesSexuales() throws SQLException {
        orientacionSexuales = new ArrayList();
        orientacionSexuales = d.leerTodasLasOrientacionesSexuales();
        modelOrientacionSexual = new TMModelOrientacionSexual(orientacionSexuales);
        tblOrientacionSexual.setModel(modelOrientacionSexual);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidoJuez;
    private javax.swing.JLabel lblApellidoPerpetrador;
    private javax.swing.JLabel lblApellidoVictima;
    private javax.swing.JLabel lblEdadJuez;
    private javax.swing.JLabel lblEdadPerpetrador;
    private javax.swing.JLabel lblEdadVictima;
    private javax.swing.JLabel lblGeneroDeVictima;
    private javax.swing.JLabel lblGeneroJuez;
    private javax.swing.JLabel lblGeneroPerpetrador;
    private javax.swing.JLabel lblNombreJuez;
    private javax.swing.JLabel lblNombreOrientacionSexual;
    private javax.swing.JLabel lblNombrePerpetrador;
    private javax.swing.JLabel lblNombreVictima;
    private javax.swing.JLabel lblRunJuez;
    private javax.swing.JLabel lblRunPerpetrador;
    private javax.swing.JLabel lblRunVictima;
    private javax.swing.JLabel lblSexoJuez;
    private javax.swing.JLabel lblSexoVictima;
    private javax.swing.JPanel pnlCondena;
    private javax.swing.JPanel pnlDelito;
    private javax.swing.JPanel pnlJuez;
    private javax.swing.JPanel pnlOrientacionSexual;
    private javax.swing.JPanel pnlPerpetrador;
    private javax.swing.JPanel pnlTipoDeDelito;
    private javax.swing.JPanel pnlVictima;
    private javax.swing.JRadioButton rbtSexoFemenino;
    private javax.swing.JRadioButton rbtSexoFemeninoJuez;
    private javax.swing.JRadioButton rbtSexoFemeninoVictima;
    private javax.swing.JRadioButton rbtSexoMasculino;
    private javax.swing.JRadioButton rbtSexoMasculinoJuez;
    private javax.swing.JRadioButton rbtSexoMasculinoVictima;
    private javax.swing.JSpinner spnEdadJuez;
    private javax.swing.JSpinner spnEdadPerpetrador;
    private javax.swing.JSpinner spnEdadVictima;
    private javax.swing.JTable tblOrientacionSexual;
    private javax.swing.JTabbedPane tbpOpciones;
    private javax.swing.JTextField txtApellidoJuez;
    private javax.swing.JTextField txtApellidoPerpetrador;
    private javax.swing.JTextField txtApellidoVictima;
    private javax.swing.JTextField txtGeneroPerpetrador;
    private javax.swing.JTextField txtGeneroVictima;
    private javax.swing.JTextField txtNombreJuez;
    private javax.swing.JTextField txtNombreOrientacionSexual;
    private javax.swing.JTextField txtNombrePerpetrador;
    private javax.swing.JTextField txtNombreTipoDeDelito;
    private javax.swing.JTextField txtNombreVictima;
    private javax.swing.JTextField txtRunJuez;
    private javax.swing.JTextField txtRunPerpetrador;
    private javax.swing.JTextField txtRunVictima;
    private javax.swing.JTextField txtSexoJuez;
    // End of variables declaration//GEN-END:variables
}
