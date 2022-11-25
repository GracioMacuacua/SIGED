package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Grácio Macuácua
 */

public class PDF {
    
    public void gerarRelatorio(String total, String media, String totalPagas, String devMenor, String devMaior, String menor, String maior){
        
        Document documento = new Document();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(Calendar.getInstance().getTime());
        
        try{
            PdfWriter.getInstance(documento, new FileOutputStream("PDF.pdf"));
            
            documento.open();
            documento.setPageSize(PageSize.A4);
            
            documento.add(new Paragraph("RELATÓRIO"));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            documento.add(new Paragraph("Total em dívidas        :  " + total));
            documento.add(new Paragraph("Média das dívidas       :  " + media));
            documento.add(new Paragraph("Total em dívidas pagas  :  " + totalPagas));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Devedor com maior dívida:  " + devMaior));
            documento.add(new Paragraph("Devedor com menor dívida:  " + devMenor)); 
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Maior dívida            :  " + maior));
            documento.add(new Paragraph("Menor dívida            :  " + menor));
            
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Data: " + data));
            
        }catch (DocumentException | IOException ex){
            JOptionPane.showMessageDialog(null, "Erro ao criar documento.\nERRO: " + ex);
        }finally{
            documento.close();
        }
    }
}
