import net.sf.jasperreports.engine.JasperCompileManager;
public class CompileJasper {
    public static void main(String[] args) {
        try {
            JasperCompileManager.compileReportToFile("src/laporan/LaporanPrioritasSubKriteria.jrxml", "src/laporan/LaporanPrioritasSubKriteria.jasper");
            System.out.println("Compiled successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
