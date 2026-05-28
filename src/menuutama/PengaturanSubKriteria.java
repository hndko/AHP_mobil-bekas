
package menuutama;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author NaufalSholahuddin
 */
public class PengaturanSubKriteria extends javax.swing.JPanel {
    private Connection conn = new Koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form Pengaturan
     */
    public PengaturanSubKriteria() {
        initComponents();
        updateDataTabel();
    }
    
protected void kosong(){
    cbSubTHPemb1.setSelectedIndex(0);
    cbSubTHPemb2.setSelectedIndex(0);
    cbSubTHPemb3.setSelectedIndex(0);
    cbSubTHPemb4.setSelectedIndex(0);
    
    cbSubTipeBB1.setSelectedIndex(0);
    cbSubTipeBB2.setSelectedIndex(0);
    cbSubTipeBB3.setSelectedIndex(0);
    cbSubTipeBB4.setSelectedIndex(0);
    
    cbSubGolHarga1.setSelectedIndex(0);
    cbSubGolHarga2.setSelectedIndex(0);
    cbSubGolHarga3.setSelectedIndex(0);
    cbSubGolHarga4.setSelectedIndex(0);
    
    cbSubKDokumen1.setSelectedIndex(0);
    cbSubKDokumen2.setSelectedIndex(0);
    cbSubKDokumen3.setSelectedIndex(0);
    cbSubKDokumen4.setSelectedIndex(0);
    
    cbSubKMesin1.setSelectedIndex(0);
    cbSubKMesin2.setSelectedIndex(0);
    cbSubKMesin3.setSelectedIndex(0);
    cbSubKMesin4.setSelectedIndex(0);
    
    cbSubTransmisi1.setSelectedIndex(0);
    cbSubTransmisi2.setSelectedIndex(0);
    cbSubTransmisi3.setSelectedIndex(0);
    cbSubTransmisi4.setSelectedIndex(0);
}

    
    protected void updateDataTabel(){
        Object[] Baris = {
            "Kode Kriteria",
            "Nama Kriteria",
            "Nama SubKriteria",
            "Kepentingan SubKriteria"
        };
        tabmode = new DefaultTableModel(null, Baris);
        tabelSubKriteria.setModel(tabmode);
        String sql = "SELECT * FROM sub_kriteria ORDER BY kd_kriteria, no_sub";
        try{
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String a = hasil.getString("kd_kriteria");
                String b = hasil.getString("nama_kriteria");
                String c = hasil.getString("nama_sub_kriteria");
                String d = hasil.getString("prioritas_kepentingan");
                
                String[] data={a, b, c, d};
                tabmode.addRow(data);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    protected void getDataTabel(){
    String sql = "SELECT nama_sub_kriteria FROM sub_kriteria ORDER BY kd_kriteria, no_sub";
    int n = 1;
    try{
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
        while(hasil.next()){
            String a = hasil.getString("nama_sub_kriteria");
            if(n == 1){
                cbSubTHPemb1.setSelectedItem(a);
            } else if(n == 2){
                cbSubTHPemb2.setSelectedItem(a);
            } else if(n == 3){
                cbSubTHPemb3.setSelectedItem(a);
            } else if(n == 4){
                cbSubTHPemb4.setSelectedItem(a);
            } else if(n == 5){
                cbSubTipeBB1.setSelectedItem(a);
            } else if(n == 6){
                cbSubTipeBB2.setSelectedItem(a);
            } else if(n == 7){
                cbSubTipeBB3.setSelectedItem(a);
            } else if(n == 8){
                cbSubGolHarga1.setSelectedItem(a);
            } else if(n == 9){
                cbSubGolHarga2.setSelectedItem(a);
            } else if(n == 10){
                cbSubGolHarga3.setSelectedItem(a);
            } else if(n == 11){
                cbSubKDokumen1.setSelectedItem(a);
            } else if(n == 12){
                cbSubKDokumen2.setSelectedItem(a);
            } else if(n == 13){
                cbSubKDokumen3.setSelectedItem(a);
            } else if(n == 14){
                cbSubKDokumen4.setSelectedItem(a);
            } else if(n == 15){
                cbSubKMesin1.setSelectedItem(a);
            } else if(n == 16){
                cbSubKMesin2.setSelectedItem(a);
            } else if(n == 17){
                cbSubKMesin3.setSelectedItem(a);
            } else if(n == 18){
                cbSubKMesin4.setSelectedItem(a);
            } else if(n == 19){
                cbSubTransmisi1.setSelectedItem(a);
            } else if(n == 20){
                cbSubTransmisi2.setSelectedItem(a);
            } else if(n == 21){
                cbSubTransmisi3.setSelectedItem(a);
            } else if(n == 22){
                cbSubTransmisi4.setSelectedItem(a);
            }
            n++;
        }
    } catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}

    
    //masukan data subkriteria
    protected void insertDataSubKriteria(){
        try{
        int n=1, nTHPembuatan=1, nTipeBB=1, nGolHarga=1, nKMesin=1, nKDokumen=1, nJTransmisi=1, i=1;
            do{
                String kepentingan;
                String sql = "INSERT INTO sub_kriteria VALUES (?,?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(sql);
                java.sql.Statement statCek = conn.createStatement();
                String sqlSub = "SELECT kd_kriteria, nama_kriteria FROM kriteria";
                String sqlTHPembuatan = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tahun Pembuatan'";
                String sqlTipeBB = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tipe Bahan Bakar'";
                String sqlGolonganHarga = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Golongan Harga'";
                String sqlKelengkapanDokumen = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kelengkapan Dokumen'";
                String sqlKondisiMesin = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kondisi Mesin'";
                String sqlJenisTransmisi = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Jenis Transmisi'";
                ResultSet hasil = statCek.executeQuery(sqlSub);
                if(n==1){
                    hasil = statCek.executeQuery(sqlTHPembuatan);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nTHPembuatan == 1){
                        stat.setString(4, cbSubTHPemb1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nTHPembuatan == 2){
                        stat.setString(4, cbSubTHPemb2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nTHPembuatan == 3){
                        stat.setString(4, cbSubTHPemb3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubTHPemb4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nTHPembuatan++;
                }else if(n==2){
                    hasil = statCek.executeQuery(sqlTipeBB);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nTipeBB == 1){
                        stat.setString(4, cbSubTipeBB1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nTipeBB == 2){
                        stat.setString(4, cbSubTipeBB2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nTipeBB == 3){
                        stat.setString(4, cbSubTipeBB3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubTipeBB4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nTipeBB++;
                }else if(n==3){
                    hasil = statCek.executeQuery(sqlGolonganHarga);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nGolHarga == 1){
                        stat.setString(4, cbSubGolHarga1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nGolHarga == 2){
                        stat.setString(4, cbSubGolHarga2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nGolHarga == 3){
                        stat.setString(4, cbSubGolHarga3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubGolHarga4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nGolHarga++;
                }else if(n==4){
                    hasil = statCek.executeQuery(sqlKelengkapanDokumen);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){    
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nKDokumen == 1){
                        stat.setString(4, cbSubKDokumen1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nKDokumen == 2){
                        stat.setString(4, cbSubKDokumen2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nKDokumen == 3){
                        stat.setString(4, cbSubKDokumen3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubKDokumen4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nKDokumen++;
                }else if(n==5){    
                    hasil = statCek.executeQuery(sqlKondisiMesin);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nKMesin == 1){
                        stat.setString(4, cbSubKMesin1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nKMesin == 2){
                        stat.setString(4, cbSubKMesin2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nKMesin == 3){
                        stat.setString(4, cbSubKMesin3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubKMesin4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nKMesin++;
                }else {    
                    hasil = statCek.executeQuery(sqlJenisTransmisi);
                    stat.setString(1, Integer.toString(i));
                    i++;
                    while(hasil.next()){
                        String a = hasil.getString("kd_kriteria");
                        String b = hasil.getString("nama_kriteria");
                        stat.setString(2, a);
                        stat.setString(3, b);
                    }
                    if(nJTransmisi == 1){
                        stat.setString(4, cbSubTransmisi1.getSelectedItem().toString());
                        kepentingan="Sangat Penting ke-1";
                    }else if(nJTransmisi == 2){
                        stat.setString(4, cbSubTransmisi2.getSelectedItem().toString());
                        kepentingan="Penting ke-2";
                    }else if(nJTransmisi == 3){
                        stat.setString(4, cbSubTransmisi3.getSelectedItem().toString());
                        kepentingan="Cukup Penting ke-3";
                    }else{
                        stat.setString(4, cbSubTransmisi4.getSelectedItem().toString());
                        kepentingan="Biasa ke-4";
                        n++;
                    }
                    stat.setString(5, kepentingan);
                    stat.executeUpdate();
                    nJTransmisi++;
                }
            }while(n<=6);   
            JOptionPane.showMessageDialog(null, "DATA Berhasil Disimpan");
            kosong();
            updateDataTabel();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
            System.out.println(e);
        }
    }
    
    protected void hapusDataSubKriteria(){
        int ok = JOptionPane.showConfirmDialog(null,"hapus","Konfirmasi Dialog",JOptionPane.YES_NO_OPTION);
        if(ok == 0){
            String sql = "DELETE FROM sub_kriteria";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);

                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil diHapus ");
                kosong();
                updateDataTabel();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal diHapus " + e);
            }
        }
    }
    
protected void editDataSubKriteria(){
    try{
        int n=1, nTHPembuatan=1, nTipeBB=1, nGolHarga=1, nKDokumen=1, nKMesin=1, nJTransmisi=1, i=1;
        do{
            String kepentingan;
            String sql = "UPDATE sub_kriteria SET kd_kriteria=?, nama_kriteria=?, nama_sub_kriteria=?, prioritas_kepentingan=? WHERE no_sub=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            java.sql.Statement statCek = conn.createStatement();
            String sqlSub = "SELECT kd_kriteria, nama_kriteria FROM kriteria";
            String sqlTHPembuatan = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tahun Pembuatan'";
            String sqlTipeBB = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Tipe Bahan Bakar'";
            String sqlGolonganHarga = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Golongan Harga'";
            String sqlKelengkapanDokumen = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kelengkapan Dokumen'";
            String sqlKondisiMesin = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Kondisi Mesin'";
            String sqlJenisTransmisi = "SELECT kd_kriteria, nama_kriteria FROM kriteria WHERE nama_kriteria='Jenis Transmisi'";
            ResultSet hasil = statCek.executeQuery(sqlSub);
            
            if(n==1){
                hasil = statCek.executeQuery(sqlTHPembuatan);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nTHPembuatan == 1){
                    stat.setString(3, cbSubTHPemb1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nTHPembuatan == 2){
                    stat.setString(3, cbSubTHPemb2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nTHPembuatan == 3){
                    stat.setString(3, cbSubTHPemb3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubTHPemb4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nTHPembuatan++;
            }else if(n==2){
                hasil = statCek.executeQuery(sqlTipeBB);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nTipeBB == 1){
                    stat.setString(3, cbSubTipeBB1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nTipeBB == 2){
                    stat.setString(3, cbSubTipeBB2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nTipeBB == 3){
                    stat.setString(3, cbSubTipeBB3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubTipeBB4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nTipeBB++;
            }else if(n==3){
                hasil = statCek.executeQuery(sqlGolonganHarga);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nGolHarga == 1){
                    stat.setString(3, cbSubGolHarga1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nGolHarga == 2){
                    stat.setString(3, cbSubGolHarga2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nGolHarga == 3){
                    stat.setString(3, cbSubGolHarga3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubGolHarga4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nGolHarga++;
            }else if(n==4){
                hasil = statCek.executeQuery(sqlKelengkapanDokumen);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nKDokumen == 1){
                    stat.setString(3, cbSubKDokumen1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nKDokumen == 2){
                    stat.setString(3, cbSubKDokumen2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nKDokumen == 3){
                    stat.setString(3, cbSubKDokumen3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubKDokumen4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nKDokumen++;
            }else if(n==5){
                hasil = statCek.executeQuery(sqlKondisiMesin);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nKMesin == 1){
                    stat.setString(3, cbSubKMesin1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nKMesin == 2){
                    stat.setString(3, cbSubKMesin2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nKMesin == 3){
                    stat.setString(3, cbSubKMesin3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubKMesin4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nKMesin++;
            }else{    
                hasil = statCek.executeQuery(sqlJenisTransmisi);
                stat.setString(5, Integer.toString(i));
                i++;
                while(hasil.next()){
                    String a = hasil.getString("kd_kriteria");
                    String b = hasil.getString("nama_kriteria");
                    stat.setString(1, a);
                    stat.setString(2, b);
                }
                if(nJTransmisi == 1){
                    stat.setString(3, cbSubTransmisi1.getSelectedItem().toString());
                    kepentingan="Sangat Penting ke-1";
                }else if(nJTransmisi == 2){
                    stat.setString(3, cbSubTransmisi2.getSelectedItem().toString());
                    kepentingan="Penting ke-2";
                }else if(nJTransmisi == 3){
                    stat.setString(3, cbSubTransmisi3.getSelectedItem().toString());
                    kepentingan="Cukup Penting ke-3";
                }else{
                    stat.setString(3, cbSubTransmisi4.getSelectedItem().toString());
                    kepentingan="Biasa ke-4";
                    n++;
                }
                stat.setString(4, kepentingan);
                stat.executeUpdate();
                nJTransmisi++;
            }
        }while(n<=6);   
        JOptionPane.showMessageDialog(null, "DATA Berhasil DiUbah");
        kosong();
        updateDataTabel();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Data Gagal DiUbah "+e);
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

        judul = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSubKriteria = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        tombolSimpan = new javax.swing.JButton();
        tombolEdit = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cbSubGolHarga1 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        cbSubGolHarga2 = new javax.swing.JComboBox<>();
        cbSubGolHarga3 = new javax.swing.JComboBox<>();
        cbSubGolHarga4 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cbSubKDokumen1 = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        cbSubKDokumen2 = new javax.swing.JComboBox<>();
        cbSubKDokumen3 = new javax.swing.JComboBox<>();
        cbSubKDokumen4 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cbSubTransmisi1 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cbSubTransmisi2 = new javax.swing.JComboBox<>();
        cbSubTransmisi3 = new javax.swing.JComboBox<>();
        cbSubTransmisi4 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbSubKMesin1 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbSubKMesin2 = new javax.swing.JComboBox<>();
        cbSubKMesin3 = new javax.swing.JComboBox<>();
        cbSubKMesin4 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbSubTipeBB1 = new javax.swing.JComboBox<>();
        cbSubTipeBB2 = new javax.swing.JComboBox<>();
        cbSubTipeBB3 = new javax.swing.JComboBox<>();
        cbSubTipeBB4 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbSubTHPemb1 = new javax.swing.JComboBox<>();
        cbSubTHPemb2 = new javax.swing.JComboBox<>();
        cbSubTHPemb3 = new javax.swing.JComboBox<>();
        cbSubTHPemb4 = new javax.swing.JComboBox<>();

        judul.setBackground(new java.awt.Color(255, 255, 255));
        judul.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        judul.setForeground(new java.awt.Color(0, 51, 153));
        judul.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        judul.setText("  Pengaturan Bobot Kepentingan SubKriteria");
        judul.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelSubKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode Kriteria", "Nama Kriteria", "Nama SubKriteria", "Kepentingan SubKriteria"
            }
        ));
        tabelSubKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSubKriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSubKriteria);

        jLabel1.setText("Catatan : Edit data, klik data pada tabel terlebih dahulu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(271, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tombolSimpan.setBackground(new java.awt.Color(0, 51, 102));
        tombolSimpan.setForeground(new java.awt.Color(255, 255, 255));
        tombolSimpan.setText("Simpan");
        tombolSimpan.setBorder(null);
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolEdit.setBackground(new java.awt.Color(0, 51, 102));
        tombolEdit.setForeground(new java.awt.Color(255, 255, 255));
        tombolEdit.setText("Edit");
        tombolEdit.setBorder(null);
        tombolEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditActionPerformed(evt);
            }
        });

        tombolHapus.setBackground(new java.awt.Color(102, 0, 0));
        tombolHapus.setForeground(new java.awt.Color(255, 255, 255));
        tombolHapus.setText("Hapus");
        tombolHapus.setBorder(null);
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Kepentingan Golongan Harga"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Harga Yang Sangat Penting ke-1");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setText("Harga Penting ke-2");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel31.setText("Harga Cukup Penting ke-3");

        cbSubGolHarga1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Golongan -", "Di bawah 100 juta", "100-150 juta", "150-200 juta", "Di atas 200 juta" }));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Harga Biasa ke-4");

        cbSubGolHarga2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Golongan -", "Di bawah 100 juta", "100-150 juta", "150-200 juta", "Di atas 200 juta" }));

        cbSubGolHarga3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Golongan -", "Di bawah 100 juta", "100-150 juta", "150-200 juta", "Di atas 200 juta" }));

        cbSubGolHarga4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Golongan -", "Di bawah 100 juta", "100-150 juta", "150-200 juta", "Di atas 200 juta" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSubGolHarga1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubGolHarga2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubGolHarga3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubGolHarga4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbSubGolHarga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSubGolHarga2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(cbSubGolHarga3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(cbSubGolHarga4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Kepentingan Kelengkapan Dokumen"));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Kondisi Yang Sangat Penting ke-1");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel34.setText("Kondisi Penting ke-2");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Kondisi Cukup Penting ke-3");

        cbSubKDokumen1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelengkapan -", "Lengkap", "Cukup Lengkap", "Kurang Lengkap", "Tidak Ada" }));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setText("Kondisi biasa ke-4");

        cbSubKDokumen2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelengkapan -", "Lengkap", "Cukup Lengkap", "Kurang Lengkap", "Tidak Ada" }));

        cbSubKDokumen3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelengkapan -", "Lengkap", "Cukup Lengkap", "Kurang Lengkap", "Tidak Ada" }));

        cbSubKDokumen4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelengkapan -", "Lengkap", "Cukup Lengkap", "Kurang Lengkap", "Tidak Ada" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbSubKDokumen1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubKDokumen2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubKDokumen3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSubKDokumen4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbSubKDokumen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(cbSubKDokumen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cbSubKDokumen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(cbSubKDokumen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Transmisi"));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Kondisi Yang Sangat Penting ke-1");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setText("Kondisi Penting ke-2");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel38.setText("Kondisi Cukup Penting ke-3");

        cbSubTransmisi1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Transmisi -", "Manual", "Otomatis", "Semi-Otomatis", "CVT" }));
        cbSubTransmisi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubTransmisi1ActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel39.setText("Kondisi biasa ke-4");

        cbSubTransmisi2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Transmisi -", "Manual", "Otomatis", "Semi-Otomatis", "CVT" }));
        cbSubTransmisi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubTransmisi2ActionPerformed(evt);
            }
        });

        cbSubTransmisi3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Transmisi -", "Manual", "Otomatis", "Semi-Otomatis", "CVT" }));
        cbSubTransmisi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubTransmisi3ActionPerformed(evt);
            }
        });

        cbSubTransmisi4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Transmisi -", "Manual", "Otomatis", "Semi-Otomatis", "CVT" }));
        cbSubTransmisi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSubTransmisi4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSubTransmisi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTransmisi2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTransmisi3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTransmisi4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbSubTransmisi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37))
                    .addComponent(cbSubTransmisi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel38)
                    .addComponent(cbSubTransmisi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(cbSubTransmisi4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Kepentingan Kondisi Mesin"));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Kondisi Yang Sangat Penting ke-1");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Kondisi Penting ke-2");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Kondisi Cukup Penting ke-3");

        cbSubKMesin1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kondisi -", "Sangat Bagus", "Bagus", "Cukup", "Kurang" }));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Kondisi Biasa ke-4");

        cbSubKMesin2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kondisi -", "Sangat Bagus", "Bagus", "Cukup", "Kurang" }));

        cbSubKMesin3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kondisi -", "Sangat Bagus", "Bagus", "Cukup", "Kurang" }));

        cbSubKMesin4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kondisi -", "Sangat Bagus", "Bagus", "Cukup", "Kurang" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbSubKMesin1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbSubKMesin2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSubKMesin4, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSubKMesin3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbSubKMesin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15))
                            .addComponent(cbSubKMesin2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addComponent(cbSubKMesin3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSubKMesin4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Kepentingan Tipe Bahan Bakar"));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Tipe Yang Sangat Penting ke-1");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Tipe Penting ke-2");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Tipe Cukup Penting ke-3");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Tipe biasa ke-4");

        cbSubTipeBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih -", "Bensin", "Diesel", "Hybrid", "Listrik" }));

        cbSubTipeBB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih -", "Bensin", "Diesel", "Hybrid", "Listrik" }));

        cbSubTipeBB3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih -", "Bensin", "Diesel", "Hybrid", "Listrik" }));

        cbSubTipeBB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih -", "Bensin", "Diesel", "Hybrid", "Listrik" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSubTipeBB1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTipeBB2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTipeBB3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTipeBB4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cbSubTipeBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22))
                    .addComponent(cbSubTipeBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cbSubTipeBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(cbSubTipeBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Kepentingan Tahun Pembuatan"));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Tahun Yang Sangat Penting ke-1");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Tahun Penting ke-2");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Tahun Cukup Penting ke-3");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Tahun biasa ke-4");

        cbSubTHPemb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun -", "2010 - 2012", "2013 - 2015", "2016 - 2019", "2020 keatas" }));

        cbSubTHPemb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun -", "2010 - 2012", "2013 - 2015", "2016 - 2019", "2020 keatas" }));

        cbSubTHPemb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun -", "2010 - 2012", "2013 - 2015", "2016 - 2019", "2020 keatas" }));

        cbSubTHPemb4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tahun -", "2010 - 2012", "2013 - 2015", "2016 - 2019", "2020 keatas" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbSubTHPemb1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTHPemb2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTHPemb3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSubTHPemb4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(cbSubTHPemb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18))
                            .addComponent(cbSubTHPemb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19))
                    .addComponent(cbSubTHPemb3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cbSubTHPemb4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        insertDataSubKriteria();
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEditActionPerformed
        // TODO add your handling code here:
        editDataSubKriteria();
    }//GEN-LAST:event_tombolEditActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        hapusDataSubKriteria();
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void tabelSubKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSubKriteriaMouseClicked
        // TODO add your handling code here:
        getDataTabel();
    }//GEN-LAST:event_tabelSubKriteriaMouseClicked

    private void cbSubTransmisi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubTransmisi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubTransmisi1ActionPerformed

    private void cbSubTransmisi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubTransmisi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubTransmisi2ActionPerformed

    private void cbSubTransmisi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubTransmisi3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubTransmisi3ActionPerformed

    private void cbSubTransmisi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSubTransmisi4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSubTransmisi4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbSubGolHarga1;
    private javax.swing.JComboBox<String> cbSubGolHarga2;
    private javax.swing.JComboBox<String> cbSubGolHarga3;
    private javax.swing.JComboBox<String> cbSubGolHarga4;
    private javax.swing.JComboBox<String> cbSubKDokumen1;
    private javax.swing.JComboBox<String> cbSubKDokumen2;
    private javax.swing.JComboBox<String> cbSubKDokumen3;
    private javax.swing.JComboBox<String> cbSubKDokumen4;
    private javax.swing.JComboBox<String> cbSubKMesin1;
    private javax.swing.JComboBox<String> cbSubKMesin2;
    private javax.swing.JComboBox<String> cbSubKMesin3;
    private javax.swing.JComboBox<String> cbSubKMesin4;
    private javax.swing.JComboBox<String> cbSubTHPemb1;
    private javax.swing.JComboBox<String> cbSubTHPemb2;
    private javax.swing.JComboBox<String> cbSubTHPemb3;
    private javax.swing.JComboBox<String> cbSubTHPemb4;
    private javax.swing.JComboBox<String> cbSubTipeBB1;
    private javax.swing.JComboBox<String> cbSubTipeBB2;
    private javax.swing.JComboBox<String> cbSubTipeBB3;
    private javax.swing.JComboBox<String> cbSubTipeBB4;
    private javax.swing.JComboBox<String> cbSubTransmisi1;
    private javax.swing.JComboBox<String> cbSubTransmisi2;
    private javax.swing.JComboBox<String> cbSubTransmisi3;
    private javax.swing.JComboBox<String> cbSubTransmisi4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel judul;
    private javax.swing.JTable tabelSubKriteria;
    private javax.swing.JButton tombolEdit;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolSimpan;
    // End of variables declaration//GEN-END:variables
}
