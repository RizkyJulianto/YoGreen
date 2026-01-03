package view.petugas;

import dao.PickupRequestDAO;
import helper.Sessions;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.auth.FormLogin;

public class FormTugasMasuk extends javax.swing.JFrame {

    private DefaultTableModel model;
    private int selectedRequestId;
    private int selectedUserId;
    TableRowSorter<DefaultTableModel> sorter;

    public FormTugasMasuk() {
        if (Sessions.user == null) {
            JOptionPane.showMessageDialog(this,
                    "Silakan login terlebih dahulu");
            new FormLogin().setVisible(true);
            return;
        }
        initComponents();
        setLocationRelativeTo(null);
        if (Sessions.user == null) {
            JOptionPane.showMessageDialog(this, "Silakan login terlebih dahulu");
            new FormLogin().setVisible(true);
            this.dispose();
            return;
        }

        model = (DefaultTableModel) tblPickup.getModel();
        model.setColumnCount(0);

        model.addColumn("ID_Request");
        model.addColumn("ID_User");
        model.addColumn("Nama User");
        model.addColumn("Poin");
        model.addColumn("Jenis Sampah");
        model.addColumn("Alamat Pickup");
        model.addColumn("Status");
        cbStatus.removeAllItems();
        cbStatus.addItem("terverifikasi");
        cbStatus.addItem("selesai");
        loadDataPickup();
        lblInfo.setVisible(false);
        search.setText("Cari data penugasan");
        search.setForeground(Color.GRAY);
        sorter = new TableRowSorter<>((DefaultTableModel) tblPickup.getModel());
        tblPickup.setRowSorter(sorter);

        search.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                filter();
            }

            private void filter() {
                String keyword = search.getText();

                if (keyword.trim().isEmpty()) {
                    sorter.setRowFilter(null);
                    lblInfo.setVisible(false);
                    return;
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + keyword));

                    if (tblPickup.getRowCount() == 0) {
                        lblInfo.setVisible(true);
                    } else {
                        lblInfo.setVisible(false);
                    }
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        btbTugasMasuk = new javax.swing.JButton();
        btnMenuUtama = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPickup = new javax.swing.JTable();
        btnProses = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPerkiraanBeratSampah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        MenuPanel.setBackground(new java.awt.Color(153, 204, 0));

        btbTugasMasuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btbTugasMasuk.setForeground(new java.awt.Color(153, 204, 0));
        btbTugasMasuk.setText("Tugas Masuk");
        btbTugasMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbTugasMasukActionPerformed(evt);
            }
        });

        btnMenuUtama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuUtama.setForeground(new java.awt.Color(153, 204, 0));
        btnMenuUtama.setText("Menu Utama");
        btnMenuUtama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuUtamaActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(153, 204, 0));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MenuPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbTugasMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnMenuUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btbTugasMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });

        tblPickup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPickup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPickupMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPickup);

        btnProses.setText("Proses");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        jLabel4.setText("Berat Sampah Final :");

        jLabel5.setText("Perbarui Status");

        cbStatus.setBackground(new java.awt.Color(204, 204, 204));

        lblInfo.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(153, 204, 0));
        lblInfo.setText("Data Tidak Ditemukan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnProses))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPerkiraanBeratSampah))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(58, 58, 58)
                                        .addComponent(cbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPerkiraanBeratSampah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProses)
                    .addComponent(lblInfo))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuUtamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuUtamaActionPerformed
        // TODO add your handling code here:
        DashboardPetugas dashboard = new DashboardPetugas();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuUtamaActionPerformed

    private void btbTugasMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbTugasMasukActionPerformed
        // TODO add your handling code here:
        FormTugasMasuk tugasMasuk = new FormTugasMasuk();
        tugasMasuk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btbTugasMasukActionPerformed

    private void tblPickupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPickupMouseClicked
        // TODO add your handling code here:
        int row = tblPickup.getSelectedRow();

        selectedRequestId = Integer.parseInt(tblPickup.getValueAt(row, 0).toString());
        selectedUserId = Integer.parseInt(tblPickup.getValueAt(row, 1).toString());
        cbStatus.setSelectedItem(tblPickup.getValueAt(row, 6).toString());

    }//GEN-LAST:event_tblPickupMouseClicked

    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        // TODO add your handling code here:
        if (selectedRequestId == 0) {
            JOptionPane.showMessageDialog(this, "Pilih data pickup terlebih dahulu");
            return;
        }

        if (txtPerkiraanBeratSampah.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Berat final harus diisi");
            return;
        }

        double beratFinal;
        try {
            beratFinal = Double.parseDouble(txtPerkiraanBeratSampah.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Berat harus berupa angka");
            return;
        }

        String status = cbStatus.getSelectedItem().toString();

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin memproses pickup ini?\n\n"
                + "Berat Final : " + beratFinal + " kg\n"
                + "Status      : " + status + "\n\n"
                + "Poin akan dihitung otomatis.",
                "Konfirmasi Proses Pickup",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        PickupRequestDAO dao = new PickupRequestDAO();
        boolean sukses = dao.prosesPickup(
                selectedRequestId,
                selectedUserId,
                beratFinal,
                status
        );

        if (sukses) {
            JOptionPane.showMessageDialog(this, "Pickup berhasil diproses");
            loadDataPickup();
            txtPerkiraanBeratSampah.setText("");
            selectedRequestId = 0;
            selectedUserId = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memproses pickup");
        }

    }//GEN-LAST:event_btnProsesActionPerformed

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        // TODO add your handling code here:
        if (search.getText().equals("Cari data penugasan") && search.getForeground().equals(Color.GRAY)) {
            search.setText("");
            search.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_searchFocusGained

    private void searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusLost
        // TODO add your handling code here:
        if (search.getText().isEmpty()) {
            search.setText("Cari data pengajuan");
            search.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_searchFocusLost

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int konfirmasi = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION
        );

        if (konfirmasi != JOptionPane.YES_OPTION) {
            return;
        }

        Sessions.logout();

        new FormLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(FormTugasMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTugasMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTugasMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTugasMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTugasMasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton btbTugasMasuk;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMenuUtama;
    private javax.swing.JButton btnProses;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTextField search;
    private javax.swing.JTable tblPickup;
    private javax.swing.JTextField txtPerkiraanBeratSampah;
    // End of variables declaration//GEN-END:variables

    private void loadDataPickup() {
        DefaultTableModel model = (DefaultTableModel) tblPickup.getModel();
        model.setRowCount(0);

        int idPetugas = Sessions.user.getId_user();

        PickupRequestDAO dao = new PickupRequestDAO();
        ResultSet rs = dao.getPickupByPetugas(idPetugas);

        try {
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id_request"),
                    rs.getInt("id_user"),
                    rs.getString("nama"),
                    rs.getInt("poin"),
                    rs.getString("jenis_sampah"),
                    rs.getString("alamat_pickup"),
                    rs.getString("status")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load data pickup");
        }

    }
}
