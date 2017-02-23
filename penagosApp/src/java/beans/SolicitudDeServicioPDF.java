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

/**
 *
 * @author Fido
 */
public class SolicitudDeServicioPDF {

    public static final String DEST = "web/pdf/ejemplo.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
//        try {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SolicitudDeServicioPDF().createPdf(DEST);
        System.out.println("Documento creado Correctamente");
//        } catch (IOException | DocumentException e) {
//            System.out.println("Documento en uso, no se ha creado el nuevo");
//
//        }

    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(12);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        PdfPCell celda;
        table.setWidthPercentage(100);

        Image img = Image.getInstance("web/images/logopenagos.jpg");
        celda = new PdfPCell(img, true);
        celda.setPadding(5);
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CODIGO:\nREVISION:\nSOLICITUD DE SERVICIO:\nFECHA", font));
        celda.setColspan(8);
        // head.setBackgroundColor(BaseColor.CYAN);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SECCION", font));
        celda.setColspan(4);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MAQUINA", font));
        celda.setColspan(4);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("NOMBRE DEL OPERARIO", font));
        celda.setColspan(4);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("seccion 1", font));
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("maquina 1", font));
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("Operario maquina 1", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SERVICIO SOLICITADO", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("REPARACION", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. MECANICO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. PREVENTIVO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. ELECTRICO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. CORRECTIVO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("OTROS", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(" ", font));
        celda.setColspan(1);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DEL SERVICIO SOLICITADO", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n\n", font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE ACCIONES A REALIZAR", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n", font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("MATERIAL A EMPLEAR", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n", font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("GENERALIDADES", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS PARADA:", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("HORA SOLICITUD:", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS MTO:", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("HORA ENTREGA:", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SERVICIO SOLICITADO POR:\nSERVICIO REALIZADO POR:\nRECIBO A CONFORMIDAD:daniel perez\n\n\n FIRMA", font));
        celda.setColspan(12);
        table.addCell(celda);
        document.add(table);
        document.close();
    }
}
