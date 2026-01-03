package view.user;

import dao.PickupRequestDAO;
import helper.Sessions;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.auth.FormLogin;

public class FormSetor extends javax.swing.JFrame {

    private DefaultTableModel model;
    private int selectedRequestId = -1;
    private String selectedStatus;
    TableRowSorter<DefaultTableModel> sorter;

    public FormSetor() {
        if (Sessions.user == null) {
            JOptionPane.showMessageDialog(this,
                    "Silakan login terlebih dahulu");
            new FormLogin().setVisible(true);
            return;
        }
        initComponents();
        setLocationRelativeTo(null);
        

        String namaUser = Sessions.user.getNama();
        txtNamaPenyetor.setText(namaUser);
        txtNamaPenyetor.setEditable(false);
        txtNamaPenyetor.setBackground(new java.awt.Color(230, 230, 230));
        model = new DefaultTableModel();
        tblPickup.setModel(model);
        model.addColumn("ID_Request");
        model.addColumn("Nama");
        model.addColumn("Jenis Sampah");
        model.addColumn("Estimasi Berat");
        model.addColumn("Alamat Pickup");
        model.addColumn("Status");
        model.addColumn("Petugas");
        lblInfo.setVisible(false);
        loadData();
        search.setText("Cari data pengajuan");
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNamaPenyetor = new javax.swing.JTextField();
        txtPerkiraanBeratSampah = new javax.swing.JTextField();
        btnKonfirmasi = new javax.swing.JButton();
        cbKategoriSampah = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatLengkap = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPickup = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        MenuPanel2 = new javax.swing.JPanel();
        btnPanduan2 = new javax.swing.JButton();
        btnSetor3 = new javax.swing.JButton();
        btnTukarPoint3 = new javax.swing.JButton();
        btnMenuUtama3 = new javax.swing.JButton();
        btnLogout2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nama Penyetor :");

        jLabel3.setText("Kategori Sampah :");

        jLabel4.setText("Perkiraan Berat Sampah :");

        jLabel5.setText("Alamat Lengkap :");

        txtNamaPenyetor.setBackground(new java.awt.Color(204, 204, 204));

        txtPerkiraanBeratSampah.setBackground(new java.awt.Color(204, 204, 204));

        btnKonfirmasi.setBackground(new java.awt.Color(153, 204, 0));
        btnKonfirmasi.setText("Konfimasi");
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });

        cbKategoriSampah.setBackground(new java.awt.Color(204, 204, 204));
        cbKategoriSampah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Organik (Sisa Makanan, Daun)", "Anorganik (Plastik, Kertas, Logam, Kaca)", "B3 (Bahan Berbahaya dan Beracun)" }));

        jPanel2.setBackground(new java.awt.Color(153, 204, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Setor Sampah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Detail Setoran Sampah");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        txtAlamatLengkap.setColumns(20);
        txtAlamatLengkap.setRows(5);
        jScrollPane2.setViewportView(txtAlamatLengkap);

        tblPickup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jScrollPane4.setViewportView(tblPickup);

        jScrollPane1.setViewportView(jScrollPane4);

        search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFocusLost(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(153, 204, 0));
        btnUbah.setText("Ubah Data");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        lblInfo.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(153, 204, 0));
        lblInfo.setText("Data Tidak Ditemukan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKonfirmasi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtPerkiraanBeratSampah))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbKategoriSampah, 0, 519, Short.MAX_VALUE)
                            .addComponent(txtNamaPenyetor))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaPenyetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbKategoriSampah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPerkiraanBeratSampah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnKonfirmasi)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUbah)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblInfo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuPanel2.setBackground(new java.awt.Color(153, 204, 0));

        btnPanduan2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPanduan2.setForeground(new java.awt.Color(153, 204, 0));
        btnPanduan2.setText("Panduan");
        btnPanduan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanduan2ActionPerformed(evt);
            }
        });

        btnSetor3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSetor3.setForeground(new java.awt.Color(153, 204, 0));
        btnSetor3.setText("Setor");
        btnSetor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetor3ActionPerformed(evt);
            }
        });

        btnTukarPoint3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTukarPoint3.setForeground(new java.awt.Color(153, 204, 0));
        btnTukarPoint3.setText("Tukar Point");
        btnTukarPoint3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTukarPoint3ActionPerformed(evt);
            }
        });

        btnMenuUtama3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuUtama3.setForeground(new java.awt.Color(153, 204, 0));
        btnMenuUtama3.setText("Home");
        btnMenuUtama3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuUtama3ActionPerformed(evt);
            }
        });

        btnLogout2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout2.setForeground(new java.awt.Color(153, 204, 0));
        btnLogout2.setText("Logout");
        btnLogout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanel2Layout = new javax.swing.GroupLayout(MenuPanel2);
        MenuPanel2.setLayout(MenuPanel2Layout);
        MenuPanel2Layout.setHorizontalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPanduan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTukarPoint3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuUtama3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogout2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        MenuPanel2Layout.setVerticalGroup(
            MenuPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnMenuUtama3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnPanduan2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSetor3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTukarPoint3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(484, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(MenuPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        // TODO add your handling code here:
        if (txtPerkiraanBeratSampah.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat sampah harus diisi");
            return;
        }

        if (txtAlamatLengkap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Alamat lengkap harus diisi");
            return;
        }

        double estimasiBerat;
        try {
            String angkaSaja = txtPerkiraanBeratSampah.getText()
                    .replaceAll("[^0-9.]", "");
            estimasiBerat = Double.parseDouble(angkaSaja);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat harus berupa angka");
            return;
        }

        if (estimasiBerat <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat harus lebih dari 0");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin mengirim permintaan pickup?\n\n"
                + "Kategori : " + cbKategoriSampah.getSelectedItem() + "\n"
                + "Berat    : " + estimasiBerat + " kg\n"
                + "Alamat   : " + txtAlamatLengkap.getText(),
                "Konfirmasi Setor Sampah",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int idUser = Sessions.user.getId_user();
            String jenisSampah = cbKategoriSampah.getSelectedItem().toString();
            String alamat = txtAlamatLengkap.getText();

            PickupRequestDAO dao = new PickupRequestDAO();
            boolean sukses = dao.insertPickupRequest(
                    idUser,
                    jenisSampah,
                    estimasiBerat,
                    alamat
            );

            if (sukses) {
                JOptionPane.showMessageDialog(this,
                        "Permintaan pickup berhasil dikirim");
                loadData();
                bersihkan();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Gagal mengirim permintaan pickup");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Terjadi kesalahan sistem");
        }
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void btnPanduan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanduan2ActionPerformed
        // TODO add your handling code here:
        FormPanduan panduan = new FormPanduan();

        panduan.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnPanduan2ActionPerformed

    private void btnSetor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetor3ActionPerformed
        // TODO add your handling code here:
        FormSetor setor = new FormSetor();
        setor.setLocationRelativeTo(null); // Membuat window muncul di tengah
        setor.setVisible(true);
        this.dispose(); //
    }//GEN-LAST:event_btnSetor3ActionPerformed

    private void btnTukarPoint3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTukarPoint3ActionPerformed
        // TODO add your handling code here:
        FormTukarPoint ftp = new FormTukarPoint();
        ftp.setLocationRelativeTo(null); // Agar muncul di tengah layar
        ftp.setVisible(true);

        // Menutup Dashboard
        this.dispose();
    }//GEN-LAST:event_btnTukarPoint3ActionPerformed

    private void btnMenuUtama3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuUtama3ActionPerformed
        // TODO add your handling code here:
        new DashboardUser().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuUtama3ActionPerformed

    private void btnLogout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout2ActionPerformed
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
    }//GEN-LAST:event_btnLogout2ActionPerformed

    private void tblPickupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPickupMouseClicked
        // TODO add your handling code here:

        int row = tblPickup.getSelectedRow();
        if (row == -1) {
            return;
        }

        selectedRequestId = Integer.parseInt(
                tblPickup.getValueAt(row, 0).toString()
        );

        String kategori = tblPickup.getValueAt(row, 2).toString();
        selectedStatus = tblPickup.getValueAt(row, 5).toString();

        cbKategoriSampah.setSelectedItem(kategori);
        txtNamaPenyetor.setText(model.getValueAt(row, 1).toString());
        txtPerkiraanBeratSampah.setText(model.getValueAt(row, 3).toString());
        txtAlamatLengkap.setText(model.getValueAt(row, 4).toString());

    }//GEN-LAST:event_tblPickupMouseClicked

    private void searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFocusGained
        // TODO add your handling code here:
        if (search.getText().equals("Cari data pengajuan") && search.getForeground().equals(Color.GRAY)) {
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

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        if (selectedRequestId == -1) {
            JOptionPane.showMessageDialog(this,
                    "Pilih data setoran terlebih dahulu");
            return;
        }

        if (!selectedStatus.equalsIgnoreCase("menunggu")) {
            JOptionPane.showMessageDialog(this,
                    "Data tidak dapat diubah karena sudah diproses");
            return;
        }

        if (txtPerkiraanBeratSampah.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat harus diisi");
            return;
        }

        if (txtAlamatLengkap.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Alamat lengkap harus diisi");
            return;
        }

        double berat;
        try {
            berat = Double.parseDouble(txtPerkiraanBeratSampah.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat harus berupa angka");
            return;
        }

        if (berat <= 0) {
            JOptionPane.showMessageDialog(this,
                    "Perkiraan berat harus lebih dari 0");
            return;
        }


        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Yakin ingin mengubah data setoran ini?\n\n"
                + "Kategori : " + cbKategoriSampah.getSelectedItem() + "\n"
                + "Berat    : " + berat + " kg\n"
                + "Alamat   : " + txtAlamatLengkap.getText(),
                "Konfirmasi Ubah Data",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }


        PickupRequestDAO dao = new PickupRequestDAO();
        boolean sukses = dao.updatePickupRequest(
                selectedRequestId,
                cbKategoriSampah.getSelectedItem().toString(),
                berat,
                txtAlamatLengkap.getText()
        );

        if (sukses) {
            JOptionPane.showMessageDialog(this,
                    "Data setoran berhasil diperbarui");
            loadData();
            selectedRequestId = -1;
            bersihkan();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Gagal memperbarui data");
        }


    }//GEN-LAST:event_btnUbahActionPerformed

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
            java.util.logging.Logger.getLogger(FormSetor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSetor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSetor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSetor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSetor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel2;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JButton btnLogout2;
    private javax.swing.JButton btnMenuUtama3;
    private javax.swing.JButton btnPanduan2;
    private javax.swing.JButton btnSetor3;
    private javax.swing.JButton btnTukarPoint3;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cbKategoriSampah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTextField search;
    private javax.swing.JTable tblPickup;
    private javax.swing.JTextArea txtAlamatLengkap;
    private javax.swing.JTextField txtNamaPenyetor;
    private javax.swing.JTextField txtPerkiraanBeratSampah;
    // End of variables declaration//GEN-END:variables

    private void bersihkan() {
        txtNamaPenyetor.setText("");
        cbKategoriSampah.setSelectedIndex(0);
        txtPerkiraanBeratSampah.setText("");
        txtAlamatLengkap.setText("");
    }

    private void loadData() {
        int idUser = Sessions.user.getId_user();
        DefaultTableModel model = (DefaultTableModel) tblPickup.getModel();
        model.setRowCount(0);

        PickupRequestDAO dao = new PickupRequestDAO();
        ResultSet rs = dao.getPickupRequestByUser(idUser);

        try {
            while (rs != null && rs.next()) {
                Object[] row = {
                    rs.getInt("id_request"),
                    rs.getString("nama_user"),
                    rs.getString("jenis_sampah"),
                    rs.getString("estimasi_berat"),
                    rs.getString("alamat_pickup"),
                    rs.getString("status"),
                    rs.getString("nama_petugas")
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal load pickup");
        }
    }
}
