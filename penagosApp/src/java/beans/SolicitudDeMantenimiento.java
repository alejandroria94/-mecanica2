/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fido
 */
public class SolicitudDeMantenimiento {

    private int idsolicitudDeMantenimiento;
    private int idequipo;
    private String codigo;
    private String revision;
    private String solicitudDeServicio;
    private String fecha;
    private boolean reparacion;
    private boolean mtoMecanico;
    private boolean mtoPreventivo;
    private boolean mtoElectrico;
    private boolean mtoCorrectivo;
    private boolean otros;
    private String descripcionServicio;
    private String descripcionAcciones;
    private String material;
    private float horasParada;
    private float horasMTO;
    private String horaSolicitud;
    private String horaEntrega;
    private String solicitadoPor;
    private String realizadoPor;
    private String recibidoPor;
    private Equipo equipo;
    private boolean ordenDeTrabajo;
    private OrdenDeTrabajo ot;
    private String estado;
    private String ruta;
    private boolean pdf;

    public SolicitudDeMantenimiento() {
    }

    public boolean guardarSolicitudDeMantenimiento() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO solicitudesdemantenimiento(equipos_idequipos, codigo, revision, solicitudDeServicio, reparacion, mtoMecanico, mtoPreventivo, mtoElectrico, mtoCorrectivo, otros, descripcionServicio, descripcionAcciones, material, horasParada, horasMTO, horaSolicitud, horaEntrega, solicitadoPor, realizadoPor, recibidoPor,fecha,ordenDeTrabajo,ruta,pdf) "
                + " VALUES ( '" + this.idequipo + "','" + this.codigo + "','" + this.revision + "','" + this.solicitudDeServicio + "','" + this.reparacion + "','" + this.mtoMecanico + "','" + this.mtoPreventivo + "','" + this.mtoElectrico + "','" + this.mtoCorrectivo + "','" + this.otros + "','"
                + this.descripcionServicio + "','" + this.descripcionAcciones + "','" + this.material + "','" + this.horasParada + "','" + this.horasMTO + "','" + this.horaSolicitud + "','" + this.horaEntrega + "','" + this.solicitadoPor + "','" + this.realizadoPor + "','" + this.recibidoPor + "','" + this.fecha + "','" + this.ordenDeTrabajo + "','ruta','false');  ";
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

    public SolicitudDeMantenimiento buscarSolicitudDeMantenimiento(String idSolicitudDeMantenimiento) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        ResultSet datosSM = conexion.consultarBD("select * from solicitudesdemantenimiento where  idsolicitudesDeMantenimiento ='" + idSolicitudDeMantenimiento + "'");
        SolicitudDeMantenimiento sM = null;

        if (datosSM.next()) {
            sM = new SolicitudDeMantenimiento();
            sM.setIdsolicitudDeMantenimiento(Integer.parseInt(datosSM.getString("idsolicitudesDeMantenimiento")));
            sM.setIdequipo(datosSM.getInt("equipos_idequipos"));
            sM.setCodigo(datosSM.getString("codigo"));
            sM.setRevision(datosSM.getString("revision"));
            sM.setSolicitudDeServicio(datosSM.getString("solicitudDeServicio"));
            sM.setFecha(datosSM.getString("fecha"));
            sM.setReparacion(datosSM.getBoolean("reparacion"));
            sM.setMtoMecanico(datosSM.getBoolean("mtoMecanico"));
            sM.setMtoPreventivo(datosSM.getBoolean("mtoPreventivo"));
            sM.setMtoElectrico(datosSM.getBoolean("mtoElectrico"));
            sM.setMtoCorrectivo(datosSM.getBoolean("mtoCorrectivo"));
            sM.setOtros(datosSM.getBoolean("otros"));
            sM.setDescripcionServicio(datosSM.getString("descripcionServicio"));
            sM.setDescripcionAcciones(datosSM.getString("descripcionAcciones"));
            sM.setMaterial(datosSM.getString("material"));
            sM.setHorasParada(datosSM.getFloat("horasParada"));
            sM.setHorasMTO(datosSM.getFloat("horasMTO"));
            sM.setHoraSolicitud(datosSM.getString("horaSolicitud"));
            sM.setHoraEntrega(datosSM.getString("horaEntrega"));
            sM.setSolicitadoPor(datosSM.getString("solicitadoPor"));
            sM.setRealizadoPor(datosSM.getString("realizadoPor"));
            sM.setRecibidoPor(datosSM.getString("recibidoPor"));
            sM.setEquipo(new Equipo().buscarEquipo(Integer.toString(sM.getIdequipo())));
            sM.setOrdenDeTrabajo(datosSM.getBoolean("ordenDeTrabajo"));
            sM.setRuta(datosSM.getString("ruta"));
            sM.setPdf(datosSM.getBoolean("pdf"));
        }
        conexion.cerrarConexion();
        return sM;
    }

    public List<SolicitudDeMantenimiento> getListaSolicitudesDeMantenimiento() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        SolicitudDeMantenimiento sM;
        List<SolicitudDeMantenimiento> listaSolicitudesDeMantenimiento = new ArrayList<>();
        String sql = "select * from solicitudesdemantenimiento ORDER BY `fecha` ASC";
        ResultSet datosSM = conexion.consultarBD(sql);
        while (datosSM.next()) {
            sM = new SolicitudDeMantenimiento();
            sM.setIdsolicitudDeMantenimiento(Integer.parseInt(datosSM.getString("idsolicitudesDeMantenimiento")));
            sM.setIdequipo(datosSM.getInt("equipos_idequipos"));
            sM.setCodigo(datosSM.getString("codigo"));
            sM.setRevision(datosSM.getString("revision"));
            sM.setSolicitudDeServicio(datosSM.getString("solicitudDeServicio"));
            sM.setFecha(datosSM.getString("fecha"));
            sM.setReparacion(datosSM.getBoolean("reparacion"));
            sM.setMtoMecanico(datosSM.getBoolean("mtoMecanico"));
            sM.setMtoPreventivo(datosSM.getBoolean("mtoPreventivo"));
            sM.setMtoElectrico(datosSM.getBoolean("mtoElectrico"));
            sM.setMtoCorrectivo(datosSM.getBoolean("mtoCorrectivo"));
            sM.setOtros(datosSM.getBoolean("otros"));
            sM.setDescripcionServicio(datosSM.getString("descripcionServicio"));
            sM.setDescripcionAcciones(datosSM.getString("descripcionAcciones"));
            sM.setMaterial(datosSM.getString("material"));
            sM.setHorasParada(datosSM.getFloat("horasParada"));
            sM.setHorasMTO(datosSM.getFloat("horasMTO"));
            sM.setHoraSolicitud(datosSM.getString("horaSolicitud"));
            sM.setHoraEntrega(datosSM.getString("horaEntrega"));
            sM.setSolicitadoPor(datosSM.getString("solicitadoPor"));
            sM.setRealizadoPor(datosSM.getString("realizadoPor"));
            sM.setRecibidoPor(datosSM.getString("recibidoPor"));
            sM.setEquipo(new Equipo().buscarEquipo(Integer.toString(sM.getIdequipo())));
            sM.setOrdenDeTrabajo(datosSM.getBoolean("ordenDeTrabajo"));
            sM.setRuta(datosSM.getString("ruta"));
            sM.setPdf(datosSM.getBoolean("pdf"));
            listaSolicitudesDeMantenimiento.add(sM);
        }
        conexion.cerrarConexion();
        return listaSolicitudesDeMantenimiento;
    }

    public boolean actualizarSolicitudDeMantenimiento() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            //UPDATE table_name
            //SET column1=value1,column2=value2,...
            //WHERE some_column=some_value;
            String sql2 = "UPDATE `solicitudesdemantenimiento` SET equipos_idequipos='" + this.idequipo + "',codigo='" + this.codigo + "',revision='" + this.revision
                    + "',solicitudDeServicio='" + this.solicitudDeServicio + "',fecha='" + this.fecha + "',reparacion='" + this.reparacion + "',mtoMecanico='" + this.mtoMecanico
                    + "',mtoPreventivo='" + this.mtoPreventivo + "',mtoElectrico='" + this.mtoElectrico + "',mtoCorrectivo='" + this.mtoCorrectivo + "',otros='" + this.otros
                    + "',descripcionServicio='" + this.descripcionServicio + "',descripcionAcciones='" + this.descripcionAcciones + "',material='" + this.material + "',horasParada='" + this.horasParada
                    + "',horasMTO='" + this.horasMTO + "',horaSolicitud='" + this.horaSolicitud + "',horaEntrega='" + this.horaEntrega + "',solicitadoPor='" + this.solicitadoPor
                    + "',realizadoPor='" + this.realizadoPor + "',recibidoPor='" + this.recibidoPor + "',ordenDeTrabajo='" + this.ordenDeTrabajo + "',ruta='"+this.ruta+"',pdf='"+this.pdf+"' WHERE `idsolicitudesDeMantenimiento`='" + this.idsolicitudDeMantenimiento +"'";
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

    public boolean actualizarSolicitudDeMantenimiento(String idsolicitudesDeMantenimiento) {
        this.idsolicitudDeMantenimiento = Integer.parseInt(idsolicitudesDeMantenimiento);
        return this.actualizarSolicitudDeMantenimiento();
    }

    public boolean eliminarSolicitudDeMantenimiento(String idSolicitudDeMantenimiento) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `solicitudesdemantenimiento` WHERE `idsolicitudesDeMantenimiento`='" + idSolicitudDeMantenimiento + "'";
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

    public int getIdsolicitudDeMantenimiento() {
        return idsolicitudDeMantenimiento;
    }

    public void setIdsolicitudDeMantenimiento(int idsolicitudesDeMantenimiento) {
        this.idsolicitudDeMantenimiento = idsolicitudesDeMantenimiento;
    }

    public int getIdequipo() {
        return idequipo;
    }

    public void setIdequipo(int idequipo) {
        this.idequipo = idequipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSolicitudDeServicio() {
        return solicitudDeServicio;
    }

    public void setSolicitudDeServicio(String solicitudDeServicio) {
        this.solicitudDeServicio = solicitudDeServicio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isReparacion() {
        return reparacion;
    }

    public void setReparacion(boolean reparacion) {
        this.reparacion = reparacion;
    }

    public boolean isMtoMecanico() {
        return mtoMecanico;
    }

    public void setMtoMecanico(boolean mtoMecanico) {
        this.mtoMecanico = mtoMecanico;
    }

    public boolean isMtoPreventivo() {
        return mtoPreventivo;
    }

    public void setMtoPreventivo(boolean mtoPreventivo) {
        this.mtoPreventivo = mtoPreventivo;
    }

    public boolean isMtoElectrico() {
        return mtoElectrico;
    }

    public void setMtoElectrico(boolean mtoElectrico) {
        this.mtoElectrico = mtoElectrico;
    }

    public boolean isMtoCorrectivo() {
        return mtoCorrectivo;
    }

    public void setMtoCorrectivo(boolean mtoCorrectivo) {
        this.mtoCorrectivo = mtoCorrectivo;
    }

    public boolean isOtros() {
        return otros;
    }

    public void setOtros(boolean otros) {
        this.otros = otros;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getDescripcionAcciones() {
        return descripcionAcciones;
    }

    public void setDescripcionAcciones(String descripcionAcciones) {
        this.descripcionAcciones = descripcionAcciones;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getHorasParada() {
        return horasParada;
    }

    public void setHorasParada(float horasParada) {
        this.horasParada = horasParada;
    }

    public float getHorasMTO() {
        return horasMTO;
    }

    public void setHorasMTO(float horasMTO) {
        this.horasMTO = horasMTO;
    }

    public String getHoraSolicitud() {
        return horaSolicitud;
    }

    public void setHoraSolicitud(String horaSolicitud) {
        this.horaSolicitud = horaSolicitud;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getSolicitadoPor() {
        return solicitadoPor;
    }

    public void setSolicitadoPor(String solicitadoPor) {
        this.solicitadoPor = solicitadoPor;
    }

    public String getRealizadoPor() {
        return realizadoPor;
    }

    public void setRealizadoPor(String realizadoPor) {
        this.realizadoPor = realizadoPor;
    }

    public String getRecibidoPor() {
        return recibidoPor;
    }

    public void setRecibidoPor(String recibidoPor) {
        this.recibidoPor = recibidoPor;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public boolean isOrdenDeTrabajo() {
        return ordenDeTrabajo;
    }

    public void setOrdenDeTrabajo(boolean ordenDeTrabajo) {
        this.ordenDeTrabajo = ordenDeTrabajo;
    }

    public String getEstado() throws SQLException {
        this.estado = "Sin Asignar";
        if (this.ordenDeTrabajo) {
            this.ot = new OrdenDeTrabajo().buscarOrdenDeTrabajo(this.getIdsolicitudDeMantenimiento() + "", this.getIdequipo() + "");
            this.estado = ot.estadoActual();
        }
        return estado;
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
