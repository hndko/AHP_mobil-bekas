package menuutama;
import java.text.DecimalFormat;

/**
 *
 * @author The-Silver001
 */
public class SubKriteriaAhp {
    /**
     * n banyak kriteria
     */
    protected static int N_BANYAK_4X4 = 4;
    /**
     * Random Index Consistency (RI)
     */
    protected static double RI[] = {0.0, 0.0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45, 1.49, 1.51, 1.48, 1.56, 1.57, 1.59};
    
    /**
     * Sebuah Matriks berpasangan
     */
    static double[][] matriksBerpasangan4x4 = new double[N_BANYAK_4X4][N_BANYAK_4X4];
    static double[] jumlahMatriksBerpasangan4x4 = new double[N_BANYAK_4X4];
    
    /**
     * Matriks Normalisasi Kriteria
     */    
    static double[][] matriksNormalisasi4x4 = new double[N_BANYAK_4X4][N_BANYAK_4X4];
    static double[] jumlahMatriksNormalisasi4x4 = new double[N_BANYAK_4X4];
    static double[] prioritas4x4 = new double[N_BANYAK_4X4];
    static double[] prioritasSub4x4 = new double[N_BANYAK_4X4];
    
    /**
     * Matriks Penjumlahan Kriteria
     */
    static double[][] matriksPenjumlahan4x4 = new double[N_BANYAK_4X4][N_BANYAK_4X4];
    static double[] jumlahMatriksPenjumlahan4x4 = new double[N_BANYAK_4X4];
    
    /**
     * cek konsistensi rasio kriteria
     */
    static double[] jumlahCekKonsistensi4x4 = new double[N_BANYAK_4X4];
    
    /**
     * Format desimal
     */
    static DecimalFormat df = new DecimalFormat("#.##");
    
    /**
     * Menentukan IR dari N_BANYAK_4X4 kriteria/sub
     */
    static double IR;
    //Dapatkan Nilai IR
    static double getIR(){
        if(N_BANYAK_4X4 == 1 || N_BANYAK_4X4 == 2){
            IR = RI[0];
        }else if(N_BANYAK_4X4 == 3){
            IR = RI[2];
        }else if(N_BANYAK_4X4 == 4){
            IR = RI[3];
        }else if(N_BANYAK_4X4 == 5){
            IR = RI[4];
        }else if(N_BANYAK_4X4 == 6){
            IR = RI[5];
        }else if(N_BANYAK_4X4 == 7){
            IR = RI[6];
        }else if(N_BANYAK_4X4 == 8){
            IR = RI[7];
        }else if(N_BANYAK_4X4 == 9){
            IR = RI[8];
        }else if(N_BANYAK_4X4 == 10){
            IR = RI[9];
        }
        return IR;
    }
    //set Nilai
    public static void setNilaiKriteria4x4(){
        //nilai dari matriks berpasangan kriteria
        double matriks[][] = {
            {1, 3.0, 5.0, 9.0},
            {1.0/3.0, 1, 3.0, 5.0},
            {1.0/5.0, 1.0/3.0, 1, 3.0},
            {1.0/9.0, 1.0/5.0, 1.0/3.0, 1}
        };
        for (int row = 0; row < N_BANYAK_4X4; row++) {
            for (int col = 0; col < N_BANYAK_4X4; col++) {
                matriksBerpasangan4x4[row][col] =  matriks[row][col];
            }
        }
    }
    //Membuat Matriks Kriteria Normalisasi Metode AHP
    public static void MatriksBerpasangan4x4(){
        //masukkan nilai matriks berpasangan
        setNilaiKriteria4x4();
        //Jumlah PerKolom Pada Matriks berpasangan 
        for (int row = 0; row < N_BANYAK_4X4; row++) {
            for (int col = 0; col < N_BANYAK_4X4; col++) {
                jumlahMatriksBerpasangan4x4[col] +=  matriksBerpasangan4x4[row][col];
            }
        }
    }
    //membuat matriks normalisasi kriteria
    public static void MatriksNormalisasi4x4(){
        //perhitungan nilai dari matriks normalisasi kriteria
        //Jumlah setiap baris dan nilai prioritas
        for (int row = 0; row < N_BANYAK_4X4; row++) {
            for (int col = 0; col < N_BANYAK_4X4; col++) {
                matriksNormalisasi4x4[row][col] = matriksBerpasangan4x4[row][col]/jumlahMatriksBerpasangan4x4[col];
                jumlahMatriksNormalisasi4x4[row] += matriksNormalisasi4x4[row][col];
                prioritas4x4[row] = jumlahMatriksNormalisasi4x4[row]/N_BANYAK_4X4; 
            }
        }
        
        //mencari nilai terbesar atau maks dari prioritas untuk prioritas SubKriteria
        double maxNum = prioritas4x4[0];
        for (double j : prioritas4x4) {
            if (j > maxNum)
                maxNum = j;
        }
        for(int i=0;i<N_BANYAK_4X4;i++){
            //Perhitungan Prioritas SubKriteria
            prioritasSub4x4[i] = prioritas4x4[i]/maxNum; 
        }
    }
    
    //membuat matriks penjumlahan setiap baris untuk kriteria
    public static void MatriksPenjumlahan4x4(){
        for (int row = 0; row < N_BANYAK_4X4; row++) {
            for (int col = 0; col < N_BANYAK_4X4; col++) {
                matriksPenjumlahan4x4[row][col] = matriksBerpasangan4x4[row][col]*prioritas4x4[col];
                jumlahMatriksPenjumlahan4x4[row] += matriksPenjumlahan4x4[row][col];
            }
        }
    }
    
    //cek konsistensi rasio kriteria
    public static String getCekKonsistensi4x4(){
        double totalJumlah = 0;
        for (int row = 0; row < N_BANYAK_4X4; row++) {
            jumlahCekKonsistensi4x4[row] = jumlahMatriksPenjumlahan4x4[row] + prioritas4x4[row];
            totalJumlah += jumlahCekKonsistensi4x4[row];
        }
        double ir = getIR();
        double lamdaMaks = totalJumlah / N_BANYAK_4X4;
        double CI = (lamdaMaks - N_BANYAK_4X4) / (N_BANYAK_4X4 - 1);
        double CR = CI / ir;
        return CR <= 0.1 ? "Konsisten" : "Tidak Konsisten"; 
    }
    
    public SubKriteriaAhp(){
        MatriksBerpasangan4x4();
        MatriksNormalisasi4x4();
        MatriksPenjumlahan4x4();
    }
}
