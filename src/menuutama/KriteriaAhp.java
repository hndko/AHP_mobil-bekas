package menuutama;
import java.text.DecimalFormat;

/**
 *
 * @author NaufalSholahuddin
 */
public class KriteriaAhp {
    /**
     * n banyak kriteria
     */
    protected int nBanyak = 6;  // Update jumlah kriteria menjadi 6

    /**
     * Random Index Consistency (RI)
     */
    protected double RI[] = {0.0, 0.0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1.51, 1.48, 1.56, 1.57, 1.59};

    /**
     * Sebuah Matriks berpasangan Kriteria
     */
    double[][] matriksBerpasangan = new double[nBanyak][nBanyak];
    double[] jumlahMatriksBerpasangan = new double[nBanyak];

    /**
     * Matriks Normalisasi Kriteria
     */    
    double[][] matriksNormalisasi = new double[nBanyak][nBanyak];
    double[] jumlahMatriksNormalisasi = new double[nBanyak];
    double[] prioritas = new double[nBanyak];

    /**
     * Matriks Penjumlahan Kriteria
     */
    double[][] matriksPenjumlahan = new double[nBanyak][nBanyak];
    double[] jumlahMatriksPenjumlahan = new double[nBanyak];

    /**
     * cek konsistensi rasio kriteria
     */
    double[] jumlahCekKonsistensi = new double[nBanyak];

    /**
     * Format desimal
     */
    DecimalFormat df = new DecimalFormat("#.##");

    /**
     * Menentukan IR dari nBanyak kriteria/sub
     */
    double IR;
    //Dapatkan Nilai IR
    double getIR(){
        if(nBanyak >= 1 && nBanyak <= 10){
            IR = RI[nBanyak];
        }else{
            // Penanganan untuk nBanyak di luar jangkauan
            IR = 0.0;
        }
        return IR;
    }
    
    //set Nilai
    public void setNilaiKriteria(){
        //nilai dari matriks berpasangan kriteria untuk 6 kriteria
        double matriks[][] = {
            {1, 2, 3, 0.5, 4, 1},
            {0.5, 1, 2, 0.25, 3, 0.5},
            {1.0/3.0, 0.5, 1, 0.2, 2, 0.33},
            {2, 4, 5, 1, 6, 2},
            {0.25, 1.0/3.0, 0.5, 1.0/6.0, 1, 0.2},
            {1, 2, 3, 0.5, 5, 1}
        };
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksBerpasangan[row][col] =  matriks[row][col];
            }
        }
    }
    
    //Membuat Matriks Kriteria Normalisasi Metode AHP
    public void MatriksBerpasangan(){
        //masukkan nilai matriks berpasangan
        setNilaiKriteria();
        //Jumlah PerKolom Pada Matriks berpasangan 
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                jumlahMatriksBerpasangan[col] +=  matriksBerpasangan[row][col];
            }
        }
    }
    
    //membuat matriks normalisasi kriteria
    public void MatriksNormalisasi(){
        //perhitungan nilai dari matriks normalisasi kriteria
        //Jumlah setiap baris dan nilai prioritas
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksNormalisasi[row][col] = matriksBerpasangan[row][col]/jumlahMatriksBerpasangan[col];
                jumlahMatriksNormalisasi[row] += matriksNormalisasi[row][col];
            }
            prioritas[row] = jumlahMatriksNormalisasi[row]/nBanyak; 
        }
    }
    
    //membuat matriks penjumlahan setiap baris untuk kriteria
    public void MatriksPenjumlahan(){
        for (int row = 0; row < nBanyak; row++) {
            for (int col = 0; col < nBanyak; col++) {
                matriksPenjumlahan[row][col] = matriksBerpasangan[row][col]*prioritas[col];
                jumlahMatriksPenjumlahan[row] += matriksPenjumlahan[row][col];
            }
        }
    }
    
    //cek konsistensi rasio kriteria
    public String getCekKonsistensi(){
        double totalJumlah=0;
        for (int row = 0; row < nBanyak; row++) {
            jumlahCekKonsistensi[row] = jumlahMatriksPenjumlahan[row] + prioritas[row];
            totalJumlah += jumlahCekKonsistensi[row];
        }
        double ir = getIR();
        double lamdaMaks = totalJumlah/nBanyak;
        double CI=(lamdaMaks-nBanyak)/(nBanyak-1);
        double CR=CI/ir;
        if(CR <= 0.1){
            return "Konsisten";
        }else{
            return "Tidak Konsisten"; 
        }    
    }

    public KriteriaAhp(){
        MatriksBerpasangan();
        MatriksNormalisasi();
        MatriksPenjumlahan();
    }
}
