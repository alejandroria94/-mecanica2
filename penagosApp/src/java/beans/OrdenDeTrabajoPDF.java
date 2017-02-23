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
public class OrdenDeTrabajoPDF {

    public static final String DEST = "web/pdf/ejemploOT.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
//        try {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new OrdenDeTrabajoPDF().createPdf(DEST);
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
        BaseColor color=new BaseColor(142, 170, 219);
        PdfPCell celda;
        Phrase texto;
        Font font=new Font(Font.FontFamily.TIMES_ROMAN, 10);
        table.setWidthPercentage(100);

        Image img = Image.getInstance("web/images/logopenagos.jpg");
        celda = new PdfPCell(img, true);
        celda.setPadding(5);
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("ORDEN DE TRABAJO N°:\nFECHA INICIO:\nFECHA FIN:\nSOLICITUD N°:",font));
        celda.setColspan(8);
        // head.setBackgroundColor(BaseColor.CYAN);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TIPO DE SOLICITUD    NORMAL:     URGENTE:",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DTO.ADMS. Y CONTROL DE LA PRODUCCION"
                + " GENERA ORDEN DE TRABAJO DE MTTO SI:X           NO:",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CÓDIGO",font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("EQUIPO DE INSTALACIÓN",font));
        celda.setColspan(9);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TIPO DE MANTENIMIENTO\n",font));
        celda.setColspan(12);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("'\n\n",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("PARTE",font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("ANOMALIA",font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CAUSA",font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("POSIBLE SOLUCION",font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < 4; i++) {

            celda = new PdfPCell(new Phrase("p" + i,font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("a" + i,font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("c" + i,font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("ps" + i,font));
            celda.setColspan(3);
            table.addCell(celda);

        }

        celda = new PdfPCell(new Phrase("SOLICTADA POR:\n\nFIRMA",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("REVISADA POR:\n\nFIRMA",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("AUTORIZADA POR:\n\nFIRMA",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("N°",font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS TRABAJOS A REALIZAR",font));
        celda.setColspan(11);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < 2; i++) {

            celda = new PdfPCell(new Phrase(i + "",font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("D" + i,font));
            celda.setColspan(11);
            table.addCell(celda);

        }

        celda = new PdfPCell(new Phrase("MATERIALES",font));
        celda.setColspan(12);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("N°",font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CANTIDAD",font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN",font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("REFERENCIA",font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("VALOR UNI",font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("VALOR TOTAL",font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < 2; i++) {
            celda = new PdfPCell(new Phrase("" + i,font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("CANTIDAD" + i,font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("DESCRIPCIÓN" + i,font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("REFERENCIA" + i,font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("VALOR UNI" + i,font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase("VALOR TOTAL" + i,font));
            celda.setColspan(2);
            table.addCell(celda);
        }
        celda = new PdfPCell(new Phrase("COSTOS",font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MANO DE OBRA",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("MATERIALES",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL",font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TIEMPO EMPLEADO",font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS MTO:",font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS PARADA:",font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS DAÑOS ENCONTRADOS",font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n\n",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS TRABAJOS REALIZADOS",font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("OBSERVACIONES Y RECOMENDACIONES",font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("\n\n\n",font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("EJECUTO\n\nFIRMA",font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("RECIBIÓ Y APROBÓ\n\nFIRMA",font));
        celda.setColspan(6);
        table.addCell(celda);

       
        document.add(table);
        document.close();
    }
}
