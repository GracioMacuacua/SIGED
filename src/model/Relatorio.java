package model;

/*
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;*/

/**
 *
 * @author Grácio Macuácua
 */
public final class Relatorio {
    
    public Relatorio() {
    }

    /**    TEMPORARIAMENTE NÃO FUNCIONAL              TEMPORARIAMENTE NÃO FUNCIONAL              TEMPORARIAMENTE NÃO FUNCIONAL
    public static final void gerarRelatorio(List<Dados> dados) {
        try {
            InputStream fonte = Relatorio.class.getResourceAsStream("relatorio.jrxml");
            JasperReport report = JasperCompileManager.compileReport(fonte);
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(dados));
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public final class Dados {

        public String total;
        public String media;
        public String totalPagas;
        public String devedorMenor;
        public String devedorMaior;
        public String menorDivida;
        public String maiorDivida;

        public Dados(String total, String media, String totalPagas, String devMenor, String devMaior, String menor, String maior) {
            this.total = total;
            this.media = media;
            this.totalPagas = totalPagas;
            this.devedorMenor = devMenor;
            this.devedorMaior = devMaior;
            this.menorDivida = menor;
            this.maiorDivida = maior;
        }

    }
    */
    
}
