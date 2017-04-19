/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fido
 */
public class Demo {
    
    public static void main(String[] args) throws SQLException, IOException, DocumentException, ParseException {

//        Equipo e = new Equipo();
//        e.setNombre("nombre0");
//        e.setCodigo("codigo0");
//        e.setTipoEquipo("tipo equipo0");
//        e.setMarca("marca0");
//        e.setModelo("modelo0");
//        e.setUbicacion("ubicacion0");
//        e.setEstado("estado0");
//        e.setSerie("serie0");
//        e.setPeso("peso kg0");
//        e.setAltura("altura0");
//        e.setLargo("largo0");
//        e.setAncho("ancho0");
//        e.setPotencia("potencia0");
//        e.setTipoPotencia("tipo potencia0");
//        e.setFrecuencia("frecuencia0");
//        e.setAlimentacion("alimentacion0");
//        e.setAmbienteCorrosivo(false);
//        e.setTiempoDeFuncionamiento(3);
//        e.setHorasDeUso((float) 3);
//        e.setFunciones("funciones0");
//        e.setCaracteristicasEspecificas("caracteristicasEspecificas0");
//        e.setObservaciones("observaciones0");
//        e.setControl("control0");
//        e.setEstadoPintura("estadoPintura0");
//        e.setImagen("imagen0");
//        e.setOperario("operario0");
//        e.actualizarrEquipo();
//        e.guardarEquipo();
//        e.eliminarEquipo("5");
//        for (Equipo arg : e.getListaDeEquipos()) {
//            System.out.println("");
//        }
//        SolicitudDeMantenimiento sM = new SolicitudDeMantenimiento();
//        sM = new SolicitudDeMantenimiento();
//        sM.setIdequipo(1);
//        sM.setCodigo("codigo");
//        sM.setRevision("revision");
//        sM.setSolicitudDeServicio("solicitudDeServicio");
//        sM.setFecha("2012-12-12");
//        sM.setReparacion(true);
//        sM.setMtoMecanico(false);
//        sM.setMtoPreventivo(true);
//        sM.setMtoElectrico(false);
//        sM.setMtoCorrectivo(true);
//        sM.setOtros(false);
//        sM.setDescripcionServicio("descripcionServicio");
//        sM.setDescripcionAcciones("descripcionAcciones");
//        sM.setMaterial("material");
//        sM.setHorasParada(0);
//        sM.setHorasMTO(1);
//        sM.setHoraSolicitud("00:00:00");
//        sM.setHoraEntrega("00:00:00");
//        sM.setSolicitadoPor("solicitadoPor");
//        sM.setRealizadoPor("realizadoPor");
//        sM.setRecibidoPor("recibidoPor");
//        
//        sM.guardarSolicitudDeMantenimiento();
//        sM.setIdequipo(2);
//        sM.setCodigo("codigo4");
//        sM.setRevision("revision4");
//        sM.setSolicitudDeServicio("solicitudDeServicio4");
//        sM.setFecha("2015-01-01");
//        sM.setReparacion(false);
//        sM.setMtoMecanico(true);
//        sM.setMtoPreventivo(true);
//        sM.setMtoElectrico(true);
//        sM.setMtoCorrectivo(true);
//        sM.setOtros(true);
//        sM.setDescripcionServicio("descripcionServicio4");
//        sM.setDescripcionAcciones("descripcionAcciones4");
//        sM.setMaterial("material4");
//        sM.setHorasParada(10);
//        sM.setHorasMTO(20);
//        sM.setHoraSolicitud("04:00:35");
//        sM.setHoraEntrega("04:00:46");
//        sM.setSolicitadoPor("solicitadoPor");
//        sM.setRealizadoPor("realizadoPor4");
//        sM.setRecibidoPor("recibidoPor4");
//        
////        System.out.println(sM.actualizarSolicitudDeMantenimiento("4"));
//        SolicitudDeMantenimiento sM = new SolicitudDeMantenimiento();
//        CronogramaPDF crPDF = new CronogramaPDF(sM.getListaSolicitudesDeMantenimiento());
//        System.out.println(crPDF.pdfCronograma());
//        
//        System.out.println(sM.eliminarSolicitudDeMantenimiento("2"));
//        OrdenDeTrabajo ot = new OrdenDeTrabajo().buscarOrdenDeTrabajo("4", "2");
//        ot.setObservaciones("para cambiar");
//        ot.actualizarOrdenDeTrabajo();
//        OrdenDeTrabajoPDF otPDF = new OrdenDeTrabajoPDF(new OrdenDeTrabajo().buscarOrdenDeTrabajo("6", "1"));
//        otPDF.pdfCronograma();
//            SolicitudDeMantenimiento sm=new SolicitudDeMantenimiento().buscarSolicitudDeMantenimiento("4");
//            SolicitudDeMantenimientoPDF smPDF=new SolicitudDeMantenimientoPDF(sm);
//            smPDF.pdfSM();
//        OrdenDeTrabajo ot = new OrdenDeTrabajo();
//        for (OrdenDeTrabajo arg : ot.getListaOrdenesDeTrabajo()) {
//        System.out.println("");
//        }
//        System.out.println(new Parametrizacion().getParametro("rutaImgServer"));
//        System.out.println(new Parametrizacion().getParametro("rutaImgDB"));

        Instructivo i = new Instructivo();
        i.setSistema("sistema");
        i.setHerramientas("herramientas");
        i.setActividades("actividades");
        i.setRecomendaciones("recomendaciones");
        i.setRepuestos("repuestos");
        i.setGeneralidades("generalidades");
        i.setNombre("nombre");
        System.out.println(i.guardarInstructivo("1"));
          // i.borrarInstructivo("4");
    }
    
}
