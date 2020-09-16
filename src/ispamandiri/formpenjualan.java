/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispamandiri;
import java.awt.Desktop;
import java.net.URL;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Syaidi Umar
 */
public class formpenjualan extends javax.swing.JFrame {
    public long total;
    public long bayar;
    public long kembali;
    public Statement st;
    Connection cn = koneksi.getKoneksi();
            
    private DefaultTableModel model;
    /**
     * Creates new form formbeli
     */
    public formpenjualan() {
        initComponents();
        model = new DefaultTableModel();

        tabel.setModel(model);
        model.addColumn("id penjualan");
        model.addColumn("id barang");
        model.addColumn("nama barang");
        model.addColumn("harga satuan");
        model.addColumn("jumlah beli");
        model.addColumn("harga total");
        model.addColumn("bayar");
        model.addColumn("kembalian");
        model.addColumn("tanggal");
       
        loadData();
        idpenjualan();
        tampilpilih();
        
    }
   public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, 
                   "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
   public final void loadData() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_penjualan";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[9];
                o[0] = r.getString("id_penjualan");
                o[1] = r.getString("id_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("hsatuan");
                o[4] = r.getString("jumlah_beli");
                o[5] = r.getString("harga");
                o[6] = r.getString("bayar");
                o[7] = r.getString("kembalian");
                o[8] = r.getString("tanggal");
            
                model.addRow(o);
            }
            r.close();
            s.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
   }
    private void tampilpilih() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT nama_barang FROM tbl_barang WHERE jumlah !='0'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                pilihbarang.addItem(r.getString("nama_barang"));
            }

            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
  private void idpenjualan() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_penjualan ORDER by id_penjualan desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id_penjualan").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                tidpenjualan.setText("P" + Nol + AN);
            } else {
                tidpenjualan.setText("P0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tidpenjualan = new javax.swing.JTextField();
        tidbarang = new javax.swing.JTextField();
        pilihbarang = new javax.swing.JComboBox<>();
        thsatuan = new javax.swing.JTextField();
        ttotal = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jBack = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        ttanggal = new com.toedter.calendar.JDateChooser();
        tkembalian = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bedit = new javax.swing.JButton();
        hitung1 = new javax.swing.JButton();
        tjumlah = new javax.swing.JTextField();
        tbayar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembelian");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Penjualan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Barang  ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama barang  ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Harga Satuan");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        tidpenjualan.setEditable(false);
        tidpenjualan.setBackground(new java.awt.Color(255, 255, 255));
        tidpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttidpenjualanActionPerformed(evt);
            }
        });
        jPanel1.add(tidpenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, 30));

        tidbarang.setEditable(false);
        tidbarang.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(tidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 130, 30));

        pilihbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH BARANG" }));
        pilihbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihbarangActionPerformed(evt);
            }
        });
        jPanel1.add(pilihbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 130, 30));

        thsatuan.setEditable(false);
        thsatuan.setBackground(new java.awt.Color(255, 255, 255));
        thsatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thsatuanActionPerformed(evt);
            }
        });
        jPanel1.add(thsatuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 130, 30));

        ttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttotalActionPerformed(evt);
            }
        });
        jPanel1.add(ttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 130, 30));

        hitung.setBackground(new java.awt.Color(255, 255, 255));
        hitung.setText("HITUNG TOTAL");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        jPanel1.add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 150, 30));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 940, 100));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Bayar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jumlah.setEnabled(false);
        jPanel1.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 20, 10));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Form Penjualan PT ISPA MANDIRI");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 60));

        jBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kembali.jpg"))); // NOI18N
        jBack.setText("Back");
        jBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackActionPerformed(evt);
            }
        });
        jPanel1.add(jBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 100, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Beli");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Harga Total");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Tanggal");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Kembalian");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        ttanggal.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(ttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 130, 30));

        tkembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkembalianActionPerformed(evt);
            }
        });
        jPanel1.add(tkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 130, 30));

        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        print.setText("SAVE dan PRINT INVOICE");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        jPanel1.add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 380, 30));

        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/document_delete.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel1.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 100, 50));

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gtk-edit.png"))); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 180, 100, 50));

        hitung1.setBackground(new java.awt.Color(255, 255, 255));
        hitung1.setText("HITUNG KEMBALIAN");
        hitung1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitung1ActionPerformed(evt);
            }
        });
        jPanel1.add(hitung1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 150, 30));

        tjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tjumlahActionPerformed(evt);
            }
        });
        jPanel1.add(tjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 130, 30));
        jPanel1.add(tbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thsatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thsatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thsatuanActionPerformed

    private void pilihbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihbarangActionPerformed
        // TODO add your handling code here:
         if (pilihbarang.getSelectedItem().equals("pilih barang")){
            tidbarang.setText("");
            jumlah.setText("");
            thsatuan.setText("");
        }else{
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT id_barang, harga_jual, jumlah FROM tbl_barang WHERE nama_barang ='" + pilihbarang.getSelectedItem() + "'";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                tidbarang.setText(r.getString("id_barang"));
                jumlah.setText(r.getString("jumlah"));
                thsatuan.setText(r.getString("harga_jual"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        }
    }//GEN-LAST:event_pilihbarangActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
         if(tidpenjualan.getText().equals("") ||tidbarang.getText().equals("") || pilihbarang.getSelectedItem().equals("")|| thsatuan.getText().equals("")|| tjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SariWater", JOptionPane.INFORMATION_MESSAGE);
        
        }else{
        String a = tjumlah.getText();
        int aa = Integer.parseInt(a);
        
        String b = jumlah.getText();
        int bb = Integer.parseInt(b);
        if(aa > bb){
             JOptionPane.showMessageDialog(null, "jumlah melebihi stok", "SariWater", JOptionPane.INFORMATION_MESSAGE);
             tjumlah.setText("");
        }else{
       
        if(tjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI JUMLAH BELI !");
        }else{
        int jumlah, harga, total;
       
        jumlah = Integer.parseInt(tjumlah.getText().toString());
        harga = Integer.parseInt(thsatuan.getText().toString());
        total = jumlah * harga;
       
       
             ttotal.setText(Integer.toString(total));
        
        }
        }
        }  
        
        
    }//GEN-LAST:event_hitungActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        print.setEnabled(false);
        bedit.setEnabled(true);
        bhapus.setEnabled(true);
        int i = tabel.getSelectedRow();
        if (i == -1) {
            return;
        }
        String idpenjualan = (String) model.getValueAt(i, 0);
        tidpenjualan.setText(idpenjualan);
        tidpenjualan.setEnabled(false);

        String idbarang = (String) model.getValueAt(i, 1);
        tidbarang.setText(idbarang);

        String barang = (String) model.getValueAt(i, 2);
        pilihbarang.setSelectedItem(barang);

        String satuan = (String) model.getValueAt(i, 3);
        thsatuan.setText(satuan);

        String jjumlah = (String) model.getValueAt(i, 4);
        tjumlah.setText(jjumlah);
        
        String harga = (String) model.getValueAt(i, 5);
        ttotal.setText(harga);
        
        String jbayar = (String) model.getValueAt(i, 6);
        tbayar.setText(jbayar);
        
        String kembalian = (String) model.getValueAt(i, 7);
        tkembalian.setText(kembalian);
        
        //String tanggal = (String) model.getValueAt(i, 8);
        //ttanggal.setDate(tanggal);
    }//GEN-LAST:event_tabelMouseClicked

    private void ttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttotalActionPerformed

    private void jBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackActionPerformed
        // TODO add your handling code here:
        formmenu au = new formmenu();
        au.setVisible(true);
        this.setVisible(false);                          
    }//GEN-LAST:event_jBackActionPerformed

    private void tkembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tkembalianActionPerformed

    private void ttidpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttidpenjualanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttidpenjualanActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        java.sql.Connection con = null;
        try {
            String jdbcDriver="com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/ispa_mandiri";
            String user = "root";
            String pass = "";

            con = DriverManager.getConnection(url, user, pass);
            Statement stm = con.createStatement();

            
                if(tidpenjualan.getText().equals("") ||tidbarang.getText().equals("") || tjumlah.getText().equals("")|| ttanggal.getDate().equals("")){
                JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "ISPA MANDIRI", JOptionPane.INFORMATION_MESSAGE);
                }else{
                String tgl = "yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(tgl);
                
                String tanggal = String.valueOf(fm.format(ttanggal.getDate()));

                String idpenjualan = tidpenjualan.getText();
                String idbarang = tidbarang.getText();
                String barang = (String)pilihbarang.getSelectedItem();
                String satuan = thsatuan.getText();
                String jjumlah = tjumlah.getText();
                String jbayar = tbayar.getText();
                String jtotal = ttotal.getText();
                String kembalian = tkembalian.getText();

                try {
                    long millis=System.currentTimeMillis();
                    java.sql.Date date=new java.sql.Date(millis);
                    System.out.println(date);
                    Connection c = koneksi.getKoneksi();

                    String sql = "INSERT INTO tbl_penjualan VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement p = c.prepareStatement(sql);
                    p.setString(1, idpenjualan);
                    p.setString(2, idbarang);
                    p.setString(3, barang);
                    p.setString(4, satuan);
                    p.setString(5, jjumlah);
                    p.setString(6, jtotal);
                    p.setString(7, jbayar);
                    p.setString(8, kembalian);
                    p.setString(9, tanggal);

                    p.executeUpdate();
                    
                    String sql2="UPDATE tbl_barang set jumlah=jumlah - '"+jjumlah+"' where id_barang='"+idbarang+"'";
                    PreparedStatement stat2= c.prepareStatement(sql2);
                    stat2.executeUpdate();
                    
                    p.close();

                } catch (SQLException e) {
                    System.out.println("Error"+e);
                } finally {
                    loadData();

                    tidbarang.setText("");
                    thsatuan.setText("");
                    pilihbarang.setSelectedItem("");
                    //ttanggal.setDate(date);
                    tjumlah.setText("");
                    tbayar.setText("");
                    ttotal.setText("");
                    tkembalian.setText("");

                    JOptionPane.showMessageDialog(null, "Data berhasil tersimpan dan segera print INVOICE", "ISPA MANDIRI", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            
            try{

                String namaFile = ("src/ispamandiri/invoice.jasper");
                Connection conn = new koneksi().getKoneksi();
                HashMap parameter = new HashMap();
                String param = tidpenjualan.getText();
                //parameter
                parameter.put("kode",param);
                File report_file = new File(namaFile);
                JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
                JasperViewer.viewReport(jasperPrint, false);
                JasperViewer.setDefaultLookAndFeelDecorated(true);
                
                idpenjualan();
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
            }

        } catch (Exception e )  {
            System.out.println(e);
        }

    }//GEN-LAST:event_printActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from tbl_penjualan where id_penjualan='"+tidpenjualan.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        tidbarang.setText("");
        thsatuan.setText("");
        pilihbarang.setSelectedItem("");
        //ttanggal.setDate(date);
        tjumlah.setText("");
        tbayar.setText("");
        ttotal.setText("");
        tkembalian.setText("");
    }//GEN-LAST:event_bhapusActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if(tidpenjualan.getText().equals("") ||tidbarang.getText().equals("") || tjumlah.getText().equals("")|| ttanggal.getDate().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SariWater", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int i = tabel.getSelectedRow();
            if (i == -1) {
                return;
            }
            String user = (String) model.getValueAt(i, 0);
            String tgl = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tgl);
            String tanggal = String.valueOf(fm.format(ttanggal.getDate()));
            try {
                Connection c = koneksi.getKoneksi();
                String sql = "UPDATE  tbl_penjualan SET id_barang = '" + tidbarang.getText() + "', nama_barang =  '" + pilihbarang.getSelectedItem() + "', hsatuan =  '" + thsatuan.getText() + "', jumlah_beli='"+ tjumlah.getText() + "', harga='"+ ttotal.getText() + "', bayar='"+ tbayar.getText() + "', kembalian='"+ tkembalian.getText() + "', tanggal='"+ tanggal + "' WHERE  id_penjualan ='" + tidpenjualan.getText() + "'";
                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                tidbarang.setText("");
                thsatuan.setText("");
                pilihbarang.setSelectedItem("");
                //ttanggal.setDate(date);
                tjumlah.setText("");
                tbayar.setText("");
                ttotal.setText("");
                tkembalian.setText("");
                JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Ispa Mandiri", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_beditActionPerformed

    private void hitung1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitung1ActionPerformed
        // TODO add your handling code here:
        if(tidpenjualan.getText().equals("") ||tidbarang.getText().equals("") || pilihbarang.getSelectedItem().equals("")|| thsatuan.getText().equals("")|| tjumlah.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SariWater", JOptionPane.INFORMATION_MESSAGE);
        
        }else{
        String a = ttotal.getText();
        
        String b = tkembalian.getText();
        
       
        if(ttotal.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ISI TOTAL BELI !");
        }else{
        int kembalian, bayar, total;
       
        total = Integer.parseInt(ttotal.getText().toString());
        bayar = Integer.parseInt(tbayar.getText().toString());
        kembalian = bayar - total;
       
       
             tkembalian.setText(Integer.toString(kembalian));
        
        }
        
        }  
    }//GEN-LAST:event_hitung1ActionPerformed

    private void tjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tjumlahActionPerformed

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
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formpenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton hitung;
    private javax.swing.JButton hitung1;
    private javax.swing.JButton jBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlah;
    private javax.swing.JComboBox<String> pilihbarang;
    private javax.swing.JButton print;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTextField thsatuan;
    private javax.swing.JTextField tidbarang;
    private javax.swing.JTextField tidpenjualan;
    private javax.swing.JTextField tjumlah;
    private javax.swing.JTextField tkembalian;
    private com.toedter.calendar.JDateChooser ttanggal;
    private javax.swing.JTextField ttotal;
    // End of variables declaration//GEN-END:variables

}
