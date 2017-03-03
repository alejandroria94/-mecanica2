/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Fido
 */
public class CrearPDF {

    public static void crear(String idSolicitud, String idEquipo) throws SQLException, IOException, DocumentException {
        OrdenDeTrabajoPDF otPDF = new OrdenDeTrabajoPDF(new OrdenDeTrabajo().buscarOrdenDeTrabajo(idSolicitud, idEquipo));
        otPDF.pdfOT();
    }

}
