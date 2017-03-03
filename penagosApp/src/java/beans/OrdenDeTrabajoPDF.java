/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
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

    public static String ruta = "";
    public OrdenDeTrabajo ot;
    private JsonArray listaPartes ;////json object
    private JsonArray listaDescripcionesTrabajos ;////json object
    private JsonArray listaMateriales ;////json object

    public OrdenDeTrabajoPDF(OrdenDeTrabajo ot) {
        this.ot = ot;
    }

    public void pdfOT() throws IOException, DocumentException {
        try {
            ruta="web/pdf/"+ot.getIdsolicitudDeMantenimiento()+""+ot.getIdequipo()+"OrdenDeTrabajo.pdf";
            ot.setRuta(ruta);
            ot.actualizarOrdenDeTrabajo();
            File file = new File(ruta);
            file.getParentFile().mkdirs();
            new OrdenDeTrabajoPDF(this.ot).createPdf(ruta);
            System.out.println("Documento creado Correctamente");
        } catch (IOException | DocumentException e) {
            System.out.println("Documento en uso, no se ha creado el nuevo");

        }
    }

    private void createPdf(String dest) throws IOException, DocumentException {
        this.listaPartes=new JsonParser().parse(ot.getPartes()).getAsJsonArray();
        this.listaDescripcionesTrabajos=new JsonParser().parse(ot.getDescripcionesTrabajos()).getAsJsonArray();
        this.listaMateriales=new JsonParser().parse(ot.getMateriales()).getAsJsonArray();
        
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(12);
        BaseColor color = new BaseColor(142, 170, 219);
        PdfPCell celda;
        Phrase texto;
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 10);
        table.setWidthPercentage(100);

        Image img = Image.getInstance("web/img/logo.png");
        celda = new PdfPCell(img, true);
        celda.setPadding(5);
        celda.setColspan(4);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("ORDEN DE TRABAJO N°:" + this.ot.getNumeroOrdenDeTrabajo() + "\nFECHA INICIO:" + this.ot.getFechaInicio() + "\nFECHA FIN:" + this.ot.getFechaFin() + "\nSOLICITUD N°:" + this.ot.getSolicitudDeMantenimiento().getCodigo() + "", font));
        celda.setColspan(8);
        // head.setBackgroundColor(BaseColor.CYAN);
        table.addCell(celda);
        String tipoSolicitud = ot.getTipoSolicitud();
        if (tipoSolicitud.equals("Urgente")) {
            celda = new PdfPCell(new Phrase("TIPO DE SOLICITUD    NORMAL:      URGENTE: X", font));
            celda.setColspan(12);
            table.addCell(celda);
        } else {
            celda = new PdfPCell(new Phrase("TIPO DE SOLICITUD    NORMAL: X    URGENTE:", font));
            celda.setColspan(12);
            table.addCell(celda);
        }

        if (ot.isDptAdmyControl()) {
            celda = new PdfPCell(new Phrase("DTO.ADMS. Y CONTROL DE LA PRODUCCION"
                    + " GENERA ORDEN DE TRABAJO DE MTTO SI:X           NO:", font));
            celda.setColspan(12);
            table.addCell(celda);
        } else {
            celda = new PdfPCell(new Phrase("DTO.ADMS. Y CONTROL DE LA PRODUCCION"
                    + " GENERA ORDEN DE TRABAJO DE MTTO SI:            NO:X", font));
            celda.setColspan(12);
            table.addCell(celda);
        }

        celda = new PdfPCell(new Phrase("CODIGO EQUIPO: " + ot.getSolicitudDeMantenimiento().getEquipo().getCodigo(), font));
        celda.setColspan(3);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("NOMBRE EQUIPO: " + ot.getSolicitudDeMantenimiento().getEquipo().getNombre(), font));
        celda.setColspan(9);
        table.addCell(celda);
        String tipoMantenimiento = "";
        for (String element : ot.getTiposDeMantenimiento()) {
            tipoMantenimiento += element + "\n";
        }

        celda = new PdfPCell(new Phrase("TIPO DE MANTENIMIENTO\n", font));
        celda.setColspan(12);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);
        celda = new PdfPCell(new Phrase(tipoMantenimiento, font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("PARTE", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("ANOMALIA", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CAUSA", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("POSIBLE SOLUCION", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < listaPartes.size(); i++) {

            celda = new PdfPCell(new Phrase(listaPartes.get(i).getAsJsonObject().get("parte").toString().replace("\"", "") , font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaPartes.get(i).getAsJsonObject().get("anomalia").toString().replace("\"", "") , font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaPartes.get(i).getAsJsonObject().get("causa").toString().replace("\"", "") , font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaPartes.get(i).getAsJsonObject().get("solucion").toString().replace("\"", "") , font));
            celda.setColspan(3);
            table.addCell(celda);

        }

        celda = new PdfPCell(new Phrase("SOLICTADA POR: " + ot.getSolicitadaPor() + "\n\nFIRMA", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("REVISADA POR: " + ot.getRevisadaPor() + "\n\nFIRMA", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("AUTORIZADA POR: " + ot.getAutorizadaPor() + "\n\nFIRMA", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("N°", font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS TRABAJOS A REALIZAR", font));
        celda.setColspan(11);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < listaDescripcionesTrabajos.size(); i++) {

            celda = new PdfPCell(new Phrase((i+1) + "", font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaDescripcionesTrabajos.get(i).getAsJsonObject().get("trabajo").toString().replace("\"", ""), font));
            celda.setColspan(11);
            table.addCell(celda);

        }

        celda = new PdfPCell(new Phrase("MATERIALES", font));
        celda.setColspan(12);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("N°", font));
        celda.setColspan(1);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("CANTIDAD", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN", font));
        celda.setColspan(3);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("REFERENCIA", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("VALOR UNI", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("VALOR TOTAL", font));
        celda.setColspan(2);
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        table.addCell(celda);

        for (int i = 0; i < listaMateriales.size(); i++) {
            celda = new PdfPCell(new Phrase("" + (1+i), font));
            celda.setColspan(1);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaMateriales.get(i).getAsJsonObject().get("cantidad").toString().replace("\"", ""), font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaMateriales.get(i).getAsJsonObject().get("descripcion").toString().replace("\"", ""), font));
            celda.setColspan(3);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaMateriales.get(i).getAsJsonObject().get("referencia").toString().replace("\"", ""), font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaMateriales.get(i).getAsJsonObject().get("unitario").toString().replace("\"", ""), font));
            celda.setColspan(2);
            table.addCell(celda);

            celda = new PdfPCell(new Phrase(listaMateriales.get(i).getAsJsonObject().get("total").toString().replace("\"", ""), font));
            celda.setColspan(2);
            table.addCell(celda);
        }
        celda = new PdfPCell(new Phrase("COSTOS", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);
        celda = new PdfPCell(new Phrase("MANO DE OBRA: $" + ot.getCostoManoDeObra() + "", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("MATERIALES: $" + ot.getCostoMateriales() + "", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL: $" + ot.getCostoTotal() + "", font));
        celda.setColspan(4);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TIEMPO EMPLEADO", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS MTO: " + ot.getTotalHorasMto() + "", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("TOTAL HORAS PARADA: " + ot.getTotalHorasParada() + "", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS DAÑOS ENCONTRADOS", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("" + ot.getDescripcionDanos(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("DESCRIPCIÓN DE LOS TRABAJOS REALIZADOS", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("" + ot.getDescripcionTrabajosRealizados(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("OBSERVACIONES Y RECOMENDACIONES", font));
        celda.setBackgroundColor(new BaseColor(142, 170, 219));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("" + ot.getObservaciones(), font));
        celda.setColspan(12);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("EJECUTO: " + ot.getEjecutadoPor() + "\n\nFIRMA", font));
        celda.setColspan(6);
        table.addCell(celda);

        celda = new PdfPCell(new Phrase("RECIBIÓ Y APROBÓ: " + ot.getRecibidoAprobadoPor() + "\n\nFIRMA", font));
        celda.setColspan(6);
        table.addCell(celda);

        document.add(table);
        document.close();
    }
}
