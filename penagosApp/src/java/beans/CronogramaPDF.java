/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Fido
 */
public class CronogramaPDF {

    public static String ruta = "";
    public List<SolicitudDeMantenimiento> solicitudes;

    public CronogramaPDF(List<SolicitudDeMantenimiento> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public boolean pdfCronograma() throws IOException, DocumentException, SQLException {
        Parametrizacion p = new Parametrizacion();
        try {
            ruta = p.getParametro("rutaPDFServer") + "Cronograma.pdf";
            //ot.setRuta(p.getParametro("rutaPDFBD") + "Cronograma.pdf");
            File file = new File(ruta);
            file.getParentFile().mkdirs();
            new CronogramaPDF(this.solicitudes).createPdf(ruta);
            // ot.setPdf(true);
            // ot.actualizarOrdenDeTrabajo();
//            System.out.println("Documento creado Correctamente");
            return true;
        } catch (IOException | DocumentException e) {
//            System.out.println("Documento en uso, no se ha creado el nuevo");
            return false;
        }
    }

    private void createPdf(String dest) throws IOException, DocumentException, SQLException {
        Parametrizacion p = new Parametrizacion();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(12);
        BaseColor color = new BaseColor(142, 170, 219);
        PdfPCell celda;
        Phrase texto;
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 7);
        Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        table.setWidthPercentage(100);

        Image img = Image.getInstance(p.getParametro("rutaImgServer") + "logo.png");
        celda = new PdfPCell(img, true);
        celda.setPadding(5);
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("\n\n\nFecha de creacion pdf: " + dateFormat.format(Calendar.getInstance().getTime()), font1));
        celda.setColspan(8);
        // head.setBackgroundColor(BaseColor.CYAN);
        table.addCell(celda);
        
        
        celda = new PdfPCell(new Phrase("CRONOGRAMA DE MANTENIMIENTOS", font));
        celda.setColspan(112);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("N°", font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CODIGO", font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("FECHA SOLICITUD", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("EQUIPO", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("ESTADO SOLICITUD", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SOLICITADA POR", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        int i = 1;
        for (SolicitudDeMantenimiento sM : this.solicitudes) {

            celda = new PdfPCell(new Phrase(i + "", font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(sM.getCodigo(), font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(sM.getFecha(), font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(sM.getEquipo().getNombre(), font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(sM.getEstado(), font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(sM.getSolicitadoPor(), font));
            celda.setColspan(3);
            table.addCell(celda);
            i++;
        }
        document.add(table);
        document.close();
    }
}
