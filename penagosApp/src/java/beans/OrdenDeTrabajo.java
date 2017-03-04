/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fido
 */
public class OrdenDeTrabajo {

//    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    private final Calendar cal = Calendar.getInstance();
    private Date fechaHoy;
    //campos tabla solicitud
    private SolicitudDeMantenimiento solicitudDeMantenimiento;
    //fin campos tabla solicitud
    private int idsolicitudDeMantenimiento;
    private int idequipo;
    private String numeroOrdenDeTrabajo;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoSolicitud;//'Urgente','Normal'
    private String partes;
    private String solicitadaPor;
    private String revisadaPor;
    private String autorizadaPor;
    private String descripcionesTrabajos;
    private String materiales;
    private float costoManoDeObra;
    private float costoMateriales;
    private float costoTotal;
    private float totalHorasMto;
    private float totalHorasParada;
    private String descripcionDanos;
    private String descripcionTrabajosRealizados;
    private String ejecutadoPor;
    private String recibidoAprobadoPor;
    private boolean dptAdmyControl;
    private String observaciones;
    private String estado = "Pendiente"; //enum('Pendiente','Realizada','Vencida')
    private boolean cerrada;
    private String ruta;
    private boolean pdf;
    private List<String> tiposDeMantenimiento;

    public OrdenDeTrabajo() {
    }

    public OrdenDeTrabajo(String idsolicitudesDeMantenimiento) throws SQLException {
        this.idsolicitudDeMantenimiento = Integer.parseInt(idsolicitudesDeMantenimiento);
        this.solicitudDeMantenimiento = new SolicitudDeMantenimiento().buscarSolicitudDeMantenimiento(idsolicitudesDeMantenimiento);
        this.idequipo = solicitudDeMantenimiento.getEquipo().getIdEquipo();
        tiposDeMantenimiento = new ArrayList<>();
        if (solicitudDeMantenimiento.isReparacion()) {
            tiposDeMantenimiento.add("Reparación");
        }
        if (solicitudDeMantenimiento.isMtoMecanico()) {
            tiposDeMantenimiento.add("Mto mecánico");
        }
        if (solicitudDeMantenimiento.isMtoPreventivo()) {
            tiposDeMantenimiento.add("Mto preventivo");
        }
        if (solicitudDeMantenimiento.isMtoElectrico()) {
            tiposDeMantenimiento.add("Mto eléctrico");
        }
        if (solicitudDeMantenimiento.isMtoCorrectivo()) {
            tiposDeMantenimiento.add("Mto correctivo");
        }
        if (solicitudDeMantenimiento.isOtros()) {
            tiposDeMantenimiento.add("Otros");
        }

        fechaHoy = Calendar.getInstance().getTime();
    }

    public boolean guardarOrdenDeTrabajo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO ordenesdetrabajo(solicitudesDeMantenimiento_idsolicitudesDeMantenimiento, solicitudesDeMantenimiento_equipos_idequipos, numeroOrdenDeTrabajo, fechaInicio,fechaFin"
                + ", tipoSolicitud, partes,solicitadaPor, revisadaPor, autorizadaPor, descripcionesTrabajos, materiales, costoManoDeObra,costoMateriales,totalHorasMto, totalHorasParada"
                + ", descripcionDanos, descripcionTrabajosRealizados, ejecutadoPor, recibidoAprobadoPor,dptAdmyControl,observaciones,estado,cerrada,ruta,pdf) "
                + " VALUES ('" + this.idsolicitudDeMantenimiento + "','" + this.idequipo + "','" + this.numeroOrdenDeTrabajo + "','" + dateFormat.format(this.fechaInicio) + "','" + dateFormat.format(this.fechaFin) + "','" + this.tipoSolicitud + "','" + this.partes + "'"
                + ",'" + this.solicitadaPor + "','" + this.revisadaPor + "','" + this.autorizadaPor + "','" + this.descripcionesTrabajos + "','" + this.materiales + "','" + this.costoManoDeObra + "','" + this.costoMateriales + "','" + this.totalHorasMto + "','" + this.totalHorasParada + "'"
                + ",'" + this.descripcionDanos + "','" + this.descripcionTrabajosRealizados + "','" + this.ejecutadoPor + "','" + this.recibidoAprobadoPor + "','" + this.dptAdmyControl + "','" + this.observaciones + "','" + this.estado + "','" + this.cerrada + "','ruta','false');";
        if (conexion.setAutoCommitBD(false)) {
            boolean inserto = conexion.insertarBD(sentencia);
            if (inserto) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    public OrdenDeTrabajo buscarOrdenDeTrabajo(String idSolicitudMantenimiento, String idEquipo) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        ResultSet datosOT = conexion.consultarBD("select * from ordenesdetrabajo where  solicitudesDeMantenimiento_idsolicitudesDeMantenimiento ='" + idSolicitudMantenimiento + "' and solicitudesDeMantenimiento_equipos_idequipos='" + idEquipo + "'");
        OrdenDeTrabajo ot = null;

        if (datosOT.next()) {
            String idSolicitud = datosOT.getString("solicitudesDeMantenimiento_idsolicitudesDeMantenimiento");
            ot = new OrdenDeTrabajo(idSolicitud);
            ot.setNumeroOrdenDeTrabajo(datosOT.getString("numeroOrdenDeTrabajo"));
            ot.setFechaInicio(datosOT.getDate("fechaInicio"));
            ot.setFechaFin(datosOT.getDate("fechaFin"));
            ot.setTipoSolicitud(datosOT.getString("tipoSolicitud"));
            ot.setPartes(datosOT.getString("partes"));
            ot.setSolicitadaPor(datosOT.getString("solicitadaPor"));
            ot.setRevisadaPor(datosOT.getString("revisadaPor"));
            ot.setAutorizadaPor(datosOT.getString("autorizadaPor"));
            ot.setDescripcionesTrabajos(datosOT.getString("descripcionesTrabajos"));
            ot.setMateriales(datosOT.getString("materiales"));
            ot.setCostoManoDeObra(datosOT.getFloat("costoManoDeObra"));
            ot.setCostoMateriales(datosOT.getFloat("costoMateriales"));
            ot.setCostoTotal(ot.getCostoTotal());
            ot.setTotalHorasMto(datosOT.getFloat("totalHorasMto"));
            ot.setTotalHorasParada(datosOT.getFloat("totalHorasParada"));
            ot.setDescripcionDanos(datosOT.getString("descripcionDanos"));
            ot.setDescripcionTrabajosRealizados(datosOT.getString("descripcionTrabajosRealizados"));
            ot.setObservaciones(datosOT.getString("observaciones"));
            ot.setEjecutadoPor(datosOT.getString("ejecutadoPor"));
            ot.setRecibidoAprobadoPor(datosOT.getString("recibidoAprobadoPor"));
            ot.setCerrada(datosOT.getBoolean("cerrada"));
            ot.setEstado(datosOT.getString("estado"));//para actualizar el estado
            ot.setEstado(ot.estadoActual());//valor que debe quedar en el estado 
            ot.setDptAdmyControl(datosOT.getBoolean("dptAdmyControl"));
            ot.setRuta(datosOT.getString("ruta"));
            ot.setPdf(datosOT.getBoolean("pdf"));

            ot.actualizarOrdenDeTrabajo();//actualizacion a base de datos

        }
        conexion.cerrarConexion();
        return ot;
    }

    public List<OrdenDeTrabajo> getListaOrdenesDeTrabajo() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        OrdenDeTrabajo ot;
        List<OrdenDeTrabajo> listaOrdenesDeTrabajo = new ArrayList<>();
        String sql = "select * from ordenesdetrabajo ORDER BY `fechaInicio` ASC";
        ResultSet datosOT = conexion.consultarBD(sql);
        while (datosOT.next()) {
            String idSolicitud = datosOT.getString("solicitudesDeMantenimiento_idsolicitudesDeMantenimiento");
            ot = new OrdenDeTrabajo(idSolicitud);
            ot.setNumeroOrdenDeTrabajo(datosOT.getString("numeroOrdenDeTrabajo"));
            ot.setFechaInicio(datosOT.getDate("fechaInicio"));
            ot.setFechaFin(datosOT.getDate("fechaFin"));
            ot.setTipoSolicitud(datosOT.getString("tipoSolicitud"));
            ot.setPartes(datosOT.getString("partes"));
            ot.setSolicitadaPor(datosOT.getString("solicitadaPor"));
            ot.setRevisadaPor(datosOT.getString("revisadaPor"));
            ot.setAutorizadaPor(datosOT.getString("autorizadaPor"));
            ot.setDescripcionesTrabajos(datosOT.getString("descripcionesTrabajos"));
            ot.setMateriales(datosOT.getString("materiales"));
            ot.setCostoManoDeObra(datosOT.getFloat("costoManoDeObra"));
            ot.setCostoMateriales(datosOT.getFloat("costoMateriales"));
            ot.setCostoTotal(ot.getCostoTotal());
            ot.setTotalHorasMto(datosOT.getFloat("totalHorasMto"));
            ot.setTotalHorasParada(datosOT.getFloat("totalHorasParada"));
            ot.setDescripcionDanos(datosOT.getString("descripcionDanos"));
            ot.setDescripcionTrabajosRealizados(datosOT.getString("descripcionTrabajosRealizados"));
            ot.setObservaciones(datosOT.getString("observaciones"));
            ot.setEjecutadoPor(datosOT.getString("ejecutadoPor"));
            ot.setRecibidoAprobadoPor(datosOT.getString("recibidoAprobadoPor"));
            ot.setCerrada(datosOT.getBoolean("cerrada"));
            ot.setEstado(datosOT.getString("estado"));//valor en base de datos
            ot.setEstado(ot.estadoActual());//estado que debe quedar en base de datos
            ot.setDptAdmyControl(datosOT.getBoolean("dptAdmyControl"));
            ot.setRuta(datosOT.getString("ruta"));
            ot.setPdf(datosOT.getBoolean("pdf"));
            ot.actualizarOrdenDeTrabajo();
            listaOrdenesDeTrabajo.add(ot);//actualizacion de estado 
        }
        conexion.cerrarConexion();
        return listaOrdenesDeTrabajo;
    }

    public boolean actualizarOrdenDeTrabajo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            //UPDATE table_name
            //SET column1=value1,column2=value2,...
            //WHERE some_column=some_value;
            String sql2 = "UPDATE `ordenesdetrabajo` SET numeroOrdenDeTrabajo='" + this.numeroOrdenDeTrabajo + "',fechaInicio='" + dateFormat.format(this.fechaInicio) + "',fechaFin='" + dateFormat.format(this.fechaFin) + "',tipoSolicitud='" + this.tipoSolicitud + "'"
                    + ",partes='" + this.partes + "',solicitadaPor='" + this.solicitadaPor + "',revisadaPor='" + this.revisadaPor + "',autorizadaPor='" + this.autorizadaPor + "',descripcionesTrabajos='" + this.descripcionesTrabajos + "',estado='" + this.estado + "'"
                    + ",materiales='" + this.materiales + "',costoManoDeObra='" + this.costoManoDeObra + "',costoMateriales='" + this.costoMateriales + "',totalHorasMto='" + this.totalHorasMto + "',totalHorasParada='" + this.totalHorasParada + "',observaciones='" + this.observaciones + "'"
                    + ",descripcionDanos='" + this.descripcionDanos + "',descripcionTrabajosRealizados='" + this.descripcionTrabajosRealizados + "',ejecutadoPor='" + this.ejecutadoPor + "',recibidoAprobadoPor='" + this.recibidoAprobadoPor + "',dptAdmyControl='" + this.dptAdmyControl + "',ruta='"+this.ruta+"',pdf='"+this.pdf+"'"
                    + "WHERE `solicitudesDeMantenimiento_idsolicitudesDeMantenimiento`='" + this.idsolicitudDeMantenimiento + "' AND `solicitudesDeMantenimiento_equipos_idequipos`='" + this.idequipo + "'";
            boolean actualizo = conexion.actualizarBD(sql2);
            if (actualizo) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    public boolean eliminarOrdenesDeTrabajo(String idSolicitudDeMantenimiento, String idEquipo) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `ordenesdetrabajo` WHERE `solicitudesDeMantenimiento_idsolicitudesDeMantenimiento`='" + idSolicitudDeMantenimiento + "' AND `solicitudesDeMantenimiento_equipos_idequipos`='" + idEquipo + "'";
            boolean borro2 = conexion.borrarBD(sql2);
            if (borro2) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    /**
     *
     * @param idSolicitud
     * @param idEquipo
     * @return
     */
    public boolean actualizarOrdenesDeTrabajo(String idSolicitud, String idEquipo) {
        this.idsolicitudDeMantenimiento = Integer.parseInt(idSolicitud);
        this.idequipo = Integer.parseInt(idEquipo);
        return this.actualizarOrdenDeTrabajo();
    }

    public SolicitudDeMantenimiento getSolicitudDeMantenimiento() {
        return solicitudDeMantenimiento;
    }

    public void setSolicitudDeMantenimiento(SolicitudDeMantenimiento solicitudDeMantenimiento) {
        this.solicitudDeMantenimiento = solicitudDeMantenimiento;
    }

    public int getIdsolicitudDeMantenimiento() {
        return idsolicitudDeMantenimiento;
    }

    public void setIdsolicitudDeMantenimiento(int idsolicitudesDeMantenimiento) {
        this.idsolicitudDeMantenimiento = idsolicitudesDeMantenimiento;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipos) {
        this.idequipo = idequipos;
    }

    public String getNumeroOrdenDeTrabajo() {
        return numeroOrdenDeTrabajo;
    }

    public void setNumeroOrdenDeTrabajo(String numeroOrdenDeTrabajo) {
        this.numeroOrdenDeTrabajo = numeroOrdenDeTrabajo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFindate) {
        this.fechaFin = fechaFindate;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    /**
     *
     * @param tipoSolicitud Urgente Normal
     */
    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getPartes() {
        return partes;
    }

    public void setPartes(String partes) {
        this.partes = partes;
    }

    public String getSolicitadaPor() {
        return solicitadaPor;
    }

    public void setSolicitadaPor(String solicitadaPor) {
        this.solicitadaPor = solicitadaPor;
    }

    public String getRevisadaPor() {
        return revisadaPor;
    }

    public void setRevisadaPor(String revisadaPor) {
        this.revisadaPor = revisadaPor;
    }

    public String getAutorizadaPor() {
        return autorizadaPor;
    }

    public void setAutorizadaPor(String autorizadaPor) {
        this.autorizadaPor = autorizadaPor;
    }

    public String getDescripcionesTrabajos() {
        return descripcionesTrabajos;
    }

    public void setDescripcionesTrabajos(String descripcionesTrabajos) {
        this.descripcionesTrabajos = descripcionesTrabajos;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public float getCostoManoDeObra() {
        return costoManoDeObra;
    }

    public void setCostoManoDeObra(float costoManoDeObra) {
        this.costoManoDeObra = costoManoDeObra;
    }

    public float getCostoMateriales() {
        return costoMateriales;
    }

    public void setCostoMateriales(float costoMateriales) {
        this.costoMateriales = costoMateriales;
    }

    public float getCostoTotal() {
        return costoTotal = costoManoDeObra + costoMateriales;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getTotalHorasMto() {
        return totalHorasMto;
    }

    public void setTotalHorasMto(float totalHorasMto) {
        this.totalHorasMto = totalHorasMto;
    }

    public float getTotalHorasParada() {
        return totalHorasParada;
    }

    public void setTotalHorasParada(float totalHorasParada) {
        this.totalHorasParada = totalHorasParada;
    }

    public String getDescripcionDanos() {
        return descripcionDanos;
    }

    public void setDescripcionDanos(String descripcionDanos) {
        this.descripcionDanos = descripcionDanos;
    }

    public String getDescripcionTrabajosRealizados() {
        return descripcionTrabajosRealizados;
    }

    public void setDescripcionTrabajosRealizados(String descripcionTrabajosRealizados) {
        this.descripcionTrabajosRealizados = descripcionTrabajosRealizados;
    }

    public String getEjecutadoPor() {
        return ejecutadoPor;
    }

    public void setEjecutadoPor(String ejecutadoPor) {
        this.ejecutadoPor = ejecutadoPor;
    }

    public String getRecibidoAprobadoPor() {
        return recibidoAprobadoPor;
    }

    public void setRecibidoAprobadoPor(String recibidoAprobadoPor) {
        this.recibidoAprobadoPor = recibidoAprobadoPor;
    }

    public boolean isDptAdmyControl() {
        return dptAdmyControl;
    }

    public void setDptAdmyControl(boolean dptAdmyControl) {
        this.dptAdmyControl = dptAdmyControl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<String> getTiposDeMantenimiento() {
        return tiposDeMantenimiento;
    }

    public String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    public Date getFechaHoy() {
        return fechaHoy;
    }

    public String estadoActual() {
        if (this.cerrada) {
            this.estado = "Realizada";
        } else {

            if (fechaFin.before(fechaHoy)) {
                this.estado = "Vencida";
            }
            if (fechaFin.after(fechaHoy)) {
                this.estado = "Pendiente";
            }
        }
        return this.estado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean isPdf() {
        return pdf;
    }

    public void setPdf(boolean pdf) {
        this.pdf = pdf;
    }

}
