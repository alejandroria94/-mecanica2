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
public class SolicitudDeMantenimientoPDF {

    public static final String DEST = "web/pdf/ejemploMantenimiento.pdf";

     public SolicitudDeMantenimiento sm;

    public SolicitudDeMantenimientoPDF(SolicitudDeMantenimiento ot) {
        this.sm = ot;
    }

    public void pdfSM() throws IOException, DocumentException {
        try {
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            new SolicitudDeMantenimientoPDF(this.sm).createPdf(DEST);
            System.out.println("Documento creado Correctamente");
        } catch (IOException | DocumentException e) {
            System.out.println("Documento en uso, no se ha creado el nuevo");

        }
    }



    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(12);
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        PdfPCell celda;
        table.setWidthPercentage(100);

        Image img = Image.getInstance("web/img/logo.png");
        celda = new PdfPCell(img, true);
        celda.setPadding(5);
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CODIGO: "+sm.getCodigo()+"\nREVISION: "+sm.getRevision()+
                "\nSOLICITUD DE SERVICIO: "+sm.getSolicitudDeServicio()+"\nFECHA: "+sm.getFecha()+"", font));
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

        celda = new PdfPCell(new Phrase(""+sm.getEquipo().getUbicacion(), font));
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(""+sm.getEquipo().getNombre(), font));
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(""+sm.getEquipo().getOperario(), font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SERVICIO SOLICITADO", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);
        
        String reparacion=" ";
        String mtoMecanico=" ";
        String mtoPreventivo=" ";
        String mtoElectrico=" ";
        String mtoCorrectivo=" ";
        String otros=" ";
        if(sm.isReparacion()){reparacion+=" X";}
        if(sm.isMtoMecanico()){mtoMecanico+=" X";}
        if(sm.isMtoPreventivo()){mtoPreventivo+=" X";}
        if(sm.isMtoElectrico()){mtoElectrico+=" X";}
        if(sm.isMtoCorrectivo()){mtoCorrectivo+=" X";}
        if(sm.isOtros()){otros+=" X";}

        celda = new PdfPCell(new Phrase("REPARACION", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(reparacion, font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. MECANICO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(mtoMecanico, font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. PREVENTIVO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(mtoPreventivo, font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. ELECTRICO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(mtoElectrico, font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MTO. CORRECTIVO", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(mtoCorrectivo, font));
        celda.setColspan(1);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("OTROS", font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(otros, font));
        celda.setColspan(1);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DEL SERVICIO SOLICITADO", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase(""+sm.getDescripcionServicio(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE ACCIONES A REALIZAR", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase(""+sm.getDescripcionAcciones(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("MATERIAL A EMPLEAR", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase(""+sm.getMaterial(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("GENERALIDADES", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS PARADA: "+sm.getHorasParada()+"", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("HORA SOLICITUD: "+sm.getHoraSolicitud()+"", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS MTO: "+sm.getHorasMTO()+"", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("HORA ENTREGA: "+sm.getHoraEntrega()+"", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("SERVICIO SOLICITADO POR: "+sm.getSolicitadoPor()+"\n"
                + "SERVICIO REALIZADO POR: "+sm.getRealizadoPor()+"\n"
                + "RECIBO A CONFORMIDAD: "+sm.getRecibidoPor()+"\n\n\n FIRMA", font));
        celda.setColspan(12);
        table.addCell(celda);
        document.add(table);
        document.close();
    }
}
