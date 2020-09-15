/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package ispamandiri;

import java.sql.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author umar
 */
public class formbarangmasuk extends javax.swing.JFrame {
     private DefaultTableModel model;
    /**
     * Creates new form forminputbarang
     */
    public formbarangmasuk() {
        initComponents();
        
        model = new DefaultTableModel();

        tabelinput.setModel(model);

        model.addColumn("id_masuk");
        model.addColumn("id_barang");
        model.addColumn("nama_barang");
        model.addColumn("jumlah_barang");
        model.addColumn("tanggal_masuk");
        model.addColumn("keterangan");
        
      
        loadData();
        kode();
        tampilpilih();
        
       
    }
     public void FilterHuruf(KeyEvent a){
       if(Character.isDigit(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan huruf saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    public void FilterAngka(KeyEvent a){
       if(Character.isAlphabetic(a.getKeyChar())){
           a.consume();
           JOptionPane.showMessageDialog(null, "masukan angka saja!", "peringatan", JOptionPane.WARNING_MESSAGE);
       }
   }
    public final void loadData() {
        bsimpan.setEnabled(true);
        bhapus.setEnabled(false);
        bedit.setEnabled(false);
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();

        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_barang_masuk";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                Object[] o = new Object[6];
                o[0] = r.getString("id_barang_masuk");
                o[1] = r.getString("id_barang");
                o[2] = r.getString("nama_barang");
                o[3] = r.getString("jumlah");
                o[4] = r.getString("tanggal_masuk");
                o[5] = r.getString("keterangan");
               
                
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     private void kode() {
        try {
            Connection c = koneksi.getKoneksi();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM tbl_barang_masuk ORDER by id_barang_masuk desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id_barang_masuk").substring(1);
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

                tidmasuk.setText("M" + Nol + AN);
            } else {
                tidmasuk.setText("M0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tketerangan = new javax.swing.JTextField();
        tidmasuk = new javax.swing.JTextField();
        tidbarang = new javax.swing.JTextField();
        tjumlahbarang = new javax.swing.JTextField();
        bedit = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelinput = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        pilihbarang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        ttanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Input Barang");
        setBackground(new java.awt.Color(0, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("ID Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Nama Barang");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Jumlah Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Tanggal Masuk");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        tketerangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tketeranganKeyTyped(evt);
            }
        });
        jPanel1.add(tketerangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 230, 30));

        tidmasuk.setEditable(false);
        tidmasuk.setBackground(new java.awt.Color(255, 255, 255));
        tidmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidmasukActionPerformed(evt);
            }
        });
        jPanel1.add(tidmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 230, 30));

        tidbarang.setEditable(false);
        tidbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidbarangActionPerformed(evt);
            }
        });
        tidbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tidbarangKeyTyped(evt);
            }
        });
        jPanel1.add(tidbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 230, 30));

        tjumlahbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tjumlahbarangKeyTyped(evt);
            }
        });
        jPanel1.add(tjumlahbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 230, 30));

        bedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gtk-edit.png"))); // NOI18N
        bedit.setText("EDIT");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });
        jPanel1.add(bedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 100, 50));

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gtk-save-as.png"))); // NOI18N
        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });
        jPanel1.add(bsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 100, 50));

        bhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/document_delete.png"))); // NOI18N
        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });
        jPanel1.add(bhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 100, 50));

        tabelinput.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tabelinput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelinputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelinput);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 770, 180));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Keterangan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Pengadaan Barang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        exit.setBackground(new java.awt.Color(0, 204, 204));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kembali.jpg"))); // NOI18N
        exit.setText("KEMBALI");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, -1, -1));

        pilihbarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH BARANG" }));
        pilihbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihbarangActionPerformed(evt);
            }
        });
        jPanel1.add(pilihbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 130, 30));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("ID Masuk");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        ttanggal.setDateFormatString(" yyyy-MM-dd");
        jPanel1.add(ttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        formmenu fb = new formmenu();
        fb.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        if(tidmasuk.getText().equals("") ||tidbarang.getText().equals("") || tjumlahbarang.getText().equals("")|| ttanggal.getDate().equals("")|| tketerangan.getText().equals("") || tketerangan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "ISPA MANDIRI", JOptionPane.INFORMATION_MESSAGE);
        }else{
            String tgl = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tgl);
            String tanggal = String.valueOf(fm.format(ttanggal.getDate()));
            
            String idmasuk = tidmasuk.getText();
            String idbarang = tidbarang.getText();
            String barang = (String)pilihbarang.getSelectedItem();
            String jbarang = tjumlahbarang.getText();
            
            String keterangan = tketerangan.getText();
            
           
            
            try {
                long millis=System.currentTimeMillis();  
                java.sql.Date date=new java.sql.Date(millis);  
                System.out.println(date); 
                Connection c = koneksi.getKoneksi();

                String sql = "INSERT INTO tbl_barang_masuk VALUES (?, ?, ?, ?, ?, ?)";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, idmasuk);
                p.setString(2, idbarang);
                p.setString(3, barang);
                p.setString(4, jbarang);
                p.setString(5, tanggal);
                p.setString(6, keterangan);
              
                
                p.executeUpdate();
                p.close();
                
            } catch (SQLException e) {
                System.out.println("Terjadi Error");
            } finally {
                loadData();
                kode();
                
                tidmasuk.setText("");
                tidbarang.setText("");
                pilihbarang.setSelectedItem("");
                //ttanggal.setDate(date);
                tjumlahbarang.setText("");
                tketerangan.setText("");

                JOptionPane.showMessageDialog(null, "Data berhasil tersimpan", "ISPA MANDIRI", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void tabelinputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelinputMouseClicked
        // TODO add your handling code here:
         bsimpan.setEnabled(false);
         bedit.setEnabled(true);
         bhapus.setEnabled(true);
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String idmasuk = (String) model.getValueAt(i, 0);
        tidmasuk.setText(idmasuk);
        tidmasuk.setEnabled(false);

        String idbarang = (String) model.getValueAt(i, 1);
        tidbarang.setText(idbarang);
        
        String barang = (String) model.getValueAt(i, 2);
        pilihbarang.setSelectedItem(barang);

        String jumlah = (String) model.getValueAt(i, 3);
        tjumlahbarang.setText(jumlah);

        //String tanggal = (String) model.getValueAt(i, 4);
        //ttanggal.setDate(tanggal);

        String keterangan = (String) model.getValueAt(i, 5);
        tketerangan.setText(keterangan);
        
   
         
    }//GEN-LAST:event_tabelinputMouseClicked

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        // TODO add your handling code here:
         try {
            String sql ="delete from tbl_barang_masuk where id_barang_masuk='"+tidmasuk.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.getKoneksi();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadData();
        tidmasuk.setText("");
        tidbarang.setText("");
        pilihbarang.setSelectedItem("");
        //ttanggal.setDate(date);
        tjumlahbarang.setText("");
        tketerangan.setText("");
       
      
    }//GEN-LAST:event_bhapusActionPerformed

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        // TODO add your handling code here:
        if(tidmasuk.getText().equals("") ||tidbarang.getText().equals("") || tjumlahbarang.getText().equals("")|| ttanggal.getDate().equals("")|| tketerangan.getText().equals("") || tketerangan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "LENGKAPI DATA !", "SariWater", JOptionPane.INFORMATION_MESSAGE);
        }else{
        int i = tabelinput.getSelectedRow();
        if (i == -1) {
            return;
        }
        String user = (String) model.getValueAt(i, 0);
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(ttanggal.getDate()));
        try {
            Connection c = koneksi.getKoneksi();
            String sql = "UPDATE  tbl_barang_masuk SET id_barang = '" + tidbarang.getText() + "', nama_barang =  '" + pilihbarang.getSelectedItem() + "', jumlah='"+ tjumlahbarang.getText() + "', tanggal_masuk='"+ tanggal + "', keterangan='"+ tketerangan.getText() + "' WHERE  id_barang_masuk ='" + tidmasuk.getText() + "'";
            PreparedStatement p = c.prepareStatement(sql);
            p.executeUpdate();
            p.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        } finally {
            loadData();
            tidmasuk.setText("");
            tidbarang.setText("");
            pilihbarang.setSelectedItem("");
            //ttanggal.setDate(date);
            tjumlahbarang.setText("");
            tketerangan.setText("");
          
            bsimpan.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Ispa Mandiri", JOptionPane.INFORMATION_MESSAGE);
        }
        }
    }//GEN-LAST:event_beditActionPerformed

    private void tidbarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tidbarangKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tidbarangKeyTyped

    private void tjumlahbarangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjumlahbarangKeyTyped
        // TODO add your handling code here:
        FilterAngka(evt);
    }//GEN-LAST:event_tjumlahbarangKeyTyped

    private void tketeranganKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tketeranganKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tketeranganKeyTyped

    private void tidbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidbarangActionPerformed

    private void tidmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidmasukActionPerformed

    private void pilihbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihbarangActionPerformed
        // TODO add your handling code here:
        if (pilihbarang.getSelectedItem().equals("pilih barang")){
            tidbarang.setText("");
        }else{
            try {
                Connection c = koneksi.getKoneksi();
                Statement s = c.createStatement();

                String sql = "SELECT id_barang FROM tbl_barang WHERE nama_barang ='" + pilihbarang.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    tidbarang.setText(r.getString("id_barang"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_pilihbarangActionPerformed
    
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
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formbarangmasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formbarangmasuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilihbarang;
    private javax.swing.JTable tabelinput;
    private javax.swing.JTextField tidbarang;
    private javax.swing.JTextField tidmasuk;
    private javax.swing.JTextField tjumlahbarang;
    private javax.swing.JTextField tketerangan;
    private com.toedter.calendar.JDateChooser ttanggal;
    // End of variables declaration//GEN-END:variables
}
