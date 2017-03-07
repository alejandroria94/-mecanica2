/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fido
 */
public class Equipo {

    private int idEquipo;
    private String nombre;
    private String codigo;
    private String tipoEquipo;
    private String marca;
    private String modelo;
    private String ubicacion;
    private String estado;
    private String serie;
    private String peso;
    private String altura;
    private String largo;
    private String ancho;
    private String potencia;
    private String tipoPotencia;
    private String frecuencia;
    private String alimentacion;
    private boolean ambienteCorrosivo;
    private float tiempoDeFuncionamiento;
    private float horasDeUso;
    private String funciones;
    private String caracteristicasEspecificas;
    private String observaciones;
    private String control;
    private String estadoPintura;
    private String imagen;
    private String operario;
    private int seguridad;
    private int ambiental;
    private int numeroOrdenes;
    private float costo;
    private int totalHorasParada;
    private int valorMatriz;

    public Equipo() {
//        this.nombre = "";
//        this.codigo = "";
//        this.tipoEquipo = "";
//        this.marca = "";
//        this.modelo = "";
//        this.ubicacion = "";
//        this.estado = "";
//        this.serie = "";
//        this.peso = "";
//        this.altura = "";
//        this.largo = "";
//        this.ancho = "";
//        this.potencia = "";
//        this.tipoPotencia = "";
//        this.frecuencia = "";
//        this.alimentacion = "";
//        this.ambienteCorrosivo = 0;
//        this.tiempoDeFuncionamiento = (float) 0.1;
//        this.horasDeUso = (float) 0.1;
//        this.funciones = "";
//        this.caracteristicasEspecificas = "";
//        this.observaciones = "";
//        this.control = "";
//        this.estadoPintura = "";
//        this.imagen = "";

    }

    public Equipo(String nombre, String codigo, String tipoEquipo, String marca, String modelo, String ubicacion, String estado, String serie, String peso, String altura, String largo, String ancho, String potencia, String tipoPotencia, String frecuencia, String alimentacion, boolean ambienteCorrosivo, float tiempoDeFuncionamiento, float horasDeUso, String funciones, String caracteristicasEspecificas, String observaciones, String control, String estadoPintura, String imagen, String operario) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipoEquipo = tipoEquipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.serie = serie;
        this.peso = peso;
        this.altura = altura;
        this.largo = largo;
        this.ancho = ancho;
        this.potencia = potencia;
        this.tipoPotencia = tipoPotencia;
        this.frecuencia = frecuencia;
        this.alimentacion = alimentacion;
        this.ambienteCorrosivo = ambienteCorrosivo;
        this.tiempoDeFuncionamiento = tiempoDeFuncionamiento;
        this.horasDeUso = horasDeUso;
        this.funciones = funciones;
        this.caracteristicasEspecificas = caracteristicasEspecificas;
        this.observaciones = observaciones;
        this.control = control;
        this.estadoPintura = estadoPintura;
        this.imagen = imagen;
        this.operario = operario;
    }

    public boolean guardarEquipo() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO Equipos(nombre, tipoEquipo, marca, modelo, ubicacion, estado, serie, peso, altura, largo, ancho, potencia, tipoPotencia, frecuencia, alimentacion, ambienteCorrosivo, tiempoDeFuncionamiento, horasDeUso, funciones, caracteristicasEspecificas, observaciones, control, estadoPintura, imagen,codigo,operario,seguridad,ambiental) "
                + " VALUES ( '" + this.nombre + "','" + this.tipoEquipo + "','" + this.marca + "','" + this.modelo + "','" + this.ubicacion + "','" + this.estado + "','" + this.serie + "','" + this.peso + "','" + this.altura + "','" + this.largo + "','"
                + this.ancho + "','" + this.potencia + "','" + this.tipoPotencia + "','" + this.frecuencia + "','" + this.alimentacion + "','" + this.ambienteCorrosivo + "','" + this.tiempoDeFuncionamiento + "','" + this.horasDeUso + "','" + this.funciones + "','"
                + this.caracteristicasEspecificas + "','" + this.observaciones + "','" + this.control + "','" + this.estadoPintura + "','" + this.imagen + "','" + this.codigo + "','" + this.operario + "','1','1');  ";
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

    public boolean actualizarrEquipo(String idEquipos) {
        this.idEquipo = Integer.parseInt(idEquipos);
        return this.actualizarrEquipo();
    }

    public boolean actualizarrEquipo() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            //UPDATE table_name
            //SET column1=value1,column2=value2,...
            //WHERE some_column=some_value;
            String sql2 = "UPDATE `Equipos` SET nombre='" + this.nombre + "',tipoEquipo='" + this.tipoEquipo + "',marca='" + this.marca
                    + "',modelo='" + this.modelo + "',ubicacion='" + this.ubicacion + "',estado='" + this.estado + "',serie='" + this.serie
                    + "',peso='" + this.peso + "',altura='" + this.altura + "',largo='" + this.largo + "',ancho='" + this.ancho
                    + "',potencia='" + this.potencia + "',tipoPotencia='" + this.tipoPotencia + "',frecuencia='" + this.frecuencia + "',alimentacion='" + this.alimentacion
                    + "',ambienteCorrosivo='" + this.ambienteCorrosivo + "',tiempoDeFuncionamiento='" + this.tiempoDeFuncionamiento + "',horasDeUso='" + this.horasDeUso + "',funciones='" + this.funciones
                    + "',caracteristicasEspecificas='" + this.caracteristicasEspecificas + "',observaciones='" + this.observaciones + "',control='" + this.control + "',estadoPintura='" + this.estadoPintura
                    + "',imagen='" + this.imagen + "',codigo='" + this.codigo + "',operario='" + this.operario + "',seguridad='" + this.seguridad + "',ambiental='" + this.ambiental + "' WHERE `idEquipos`='" + this.idEquipo + "'";
            boolean borro2 = conexion.actualizarBD(sql2);
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

    public boolean eliminarEquipo(String idEquipos) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `Equipos` WHERE `idequipos`='" + idEquipos + "'";
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

    public List<Equipo> getListaDeEquipos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Equipo e;
        List<Equipo> listaDeEquipos = new ArrayList<>();
        String sql = "select * from Equipos";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            e = new Equipo();
            e.setIdEquipo(Integer.parseInt(rs.getString("idEquipos")));
            e.setNombre(rs.getString("nombre"));
            e.setCodigo(rs.getString("codigo"));
            e.setTipoEquipo(rs.getString("tipoEquipo"));
            e.setMarca(rs.getString("marca"));
            e.setModelo(rs.getString("modelo"));
            e.setUbicacion(rs.getString("ubicacion"));
            e.setEstado(rs.getString("estado"));
            e.setSerie(rs.getString("serie"));
            e.setPeso(rs.getString("peso"));
            e.setAltura(rs.getString("altura"));
            e.setLargo(rs.getString("largo"));
            e.setAncho(rs.getString("ancho"));
            e.setPotencia(rs.getString("potencia"));
            e.setTipoPotencia(rs.getString("tipoPotencia"));
            e.setFrecuencia(rs.getString("frecuencia"));
            e.setAlimentacion(rs.getString("alimentacion"));
            e.setAmbienteCorrosivo(rs.getBoolean("ambienteCorrosivo"));
            e.setTiempoDeFuncionamiento(rs.getFloat("tiempoDeFuncionamiento"));
            e.setHorasDeUso(rs.getFloat("horasDeUso"));
            e.setFunciones(rs.getString("funciones"));
            e.setCaracteristicasEspecificas(rs.getString("caracteristicasEspecificas"));
            e.setObservaciones(rs.getString("observaciones"));
            e.setControl(rs.getString("control"));
            e.setEstadoPintura(rs.getString("estadoPintura"));
            e.setImagen(rs.getString("imagen"));
            e.setOperario(rs.getString("operario"));
            e.setSeguridad(rs.getInt("seguridad"));
            e.setAmbiental(rs.getInt("ambiental"));
            listaDeEquipos.add(e);
        }
        conexion.cerrarConexion();
        return listaDeEquipos;
    }

    public List<Equipo> getListaDeEquipos(String anno) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Equipo e;
        List<Equipo> listaDeEquipos = new ArrayList<>();
        String sql = "select * from Equipos;";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            e = new Equipo();
            e.setIdEquipo(Integer.parseInt(rs.getString("idEquipos")));
            e.setNombre(rs.getString("nombre"));
            e.setCodigo(rs.getString("codigo"));
            e.setTipoEquipo(rs.getString("tipoEquipo"));
            e.setMarca(rs.getString("marca"));
            e.setModelo(rs.getString("modelo"));
            e.setUbicacion(rs.getString("ubicacion"));
            e.setEstado(rs.getString("estado"));
            e.setSerie(rs.getString("serie"));
            e.setPeso(rs.getString("peso"));
            e.setAltura(rs.getString("altura"));
            e.setLargo(rs.getString("largo"));
            e.setAncho(rs.getString("ancho"));
            e.setPotencia(rs.getString("potencia"));
            e.setTipoPotencia(rs.getString("tipoPotencia"));
            e.setFrecuencia(rs.getString("frecuencia"));
            e.setAlimentacion(rs.getString("alimentacion"));
            e.setAmbienteCorrosivo(rs.getBoolean("ambienteCorrosivo"));
            e.setTiempoDeFuncionamiento(rs.getFloat("tiempoDeFuncionamiento"));
            e.setHorasDeUso(rs.getFloat("horasDeUso"));
            e.setFunciones(rs.getString("funciones"));
            e.setCaracteristicasEspecificas(rs.getString("caracteristicasEspecificas"));
            e.setObservaciones(rs.getString("observaciones"));
            e.setControl(rs.getString("control"));
            e.setEstadoPintura(rs.getString("estadoPintura"));
            e.setImagen(rs.getString("imagen"));
            e.setOperario(rs.getString("operario"));
            e.setSeguridad(rs.getInt("seguridad"));
            e.setAmbiental(rs.getInt("ambiental"));
            e.calcularValorMatriz(anno);
            listaDeEquipos.add(e);
        }
        conexion.cerrarConexion();
        return listaDeEquipos;
    }

    /**
     *
     * @param idEquipo retorna null Si la consulta no es exitosa,si es exitosa
     * retorna un objeto con los datos de la busqueda
     * @return
     * @throws java.sql.SQLException
     */
    public Equipo buscarEquipo(String idEquipo) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        ResultSet datosE = conexion.consultarBD("select * from Equipos where  idEquipos ='" + idEquipo + "'");
        Equipo e = null;

        if (datosE.next()) {
            e = new Equipo();
            e.setIdEquipo(Integer.parseInt(datosE.getString("idEquipos")));
            e.setNombre(datosE.getString("nombre"));
            e.setCodigo(datosE.getString("codigo"));
            e.setTipoEquipo(datosE.getString("tipoEquipo"));
            e.setMarca(datosE.getString("marca"));
            e.setModelo(datosE.getString("modelo"));
            e.setUbicacion(datosE.getString("ubicacion"));
            e.setEstado(datosE.getString("estado"));
            e.setSerie(datosE.getString("serie"));
            e.setPeso(datosE.getString("peso"));
            e.setAltura(datosE.getString("altura"));
            e.setLargo(datosE.getString("largo"));
            e.setAncho(datosE.getString("ancho"));
            e.setPotencia(datosE.getString("potencia"));
            e.setTipoPotencia(datosE.getString("tipoPotencia"));
            e.setFrecuencia(datosE.getString("frecuencia"));
            e.setAlimentacion(datosE.getString("alimentacion"));
            e.setAmbienteCorrosivo(datosE.getBoolean("ambienteCorrosivo"));
            e.setTiempoDeFuncionamiento(datosE.getFloat("tiempoDeFuncionamiento"));
            e.setHorasDeUso(datosE.getFloat("horasDeUso"));
            e.setFunciones(datosE.getString("funciones"));
            e.setCaracteristicasEspecificas(datosE.getString("caracteristicasEspecificas"));
            e.setObservaciones(datosE.getString("observaciones"));
            e.setControl(datosE.getString("control"));
            e.setEstadoPintura(datosE.getString("estadoPintura"));
            e.setImagen(datosE.getString("imagen"));
            e.setOperario(datosE.getString("operario"));
            e.setSeguridad(datosE.getInt("seguridad"));
            e.setAmbiental(datosE.getInt("ambiental"));
        }
        conexion.cerrarConexion();
        return e;
    }

    /**
     *
     * @param idEquipos
     * @param tiempo
     * @param tipo TPA(parada planificada) TPNP(preparacion equipo)
     * TPOP(descanso operadores) TPD(parada de emergencia)
     * @param fecha
     * @return
     */
    public boolean agregarTiempoDeOcio(String idEquipos, String tiempo, String tipo, String fecha) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO tiemposocio(Equipos_idEquipos,tiempo,tipo,fecha) "
                + " VALUES ( '" + idEquipos + "','" + tiempo + "','" + tipo + "','" + fecha + "');";
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

    public ArrayList<Indicador> listaMesEnDb(String idEquipo, String anno) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        int ots = 0;
        String sql = "SELECT totalHorasMto,totalHorasParada, EXTRACT(YEAR FROM `fechaInicio`) AS anno, EXTRACT(MONTH FROM `fechaInicio`) AS mes ,EXTRACT(DAY FROM `fechaInicio`) AS dia FROM `ordenesdetrabajo` WHERE `solicitudesDeMantenimiento_equipos_idequipos`='" + idEquipo + "' AND YEAR(`fechaInicio`)='" + anno + "';";
        ResultSet datos = conexion.consultarBD(sql);
        Indicador i;
        ArrayList<Indicador> lista = new ArrayList<>();
        while (datos.next()) {
            i = new Indicador();
            i.setAnno(datos.getInt("anno"));
            i.setMes(datos.getInt("mes"));
            i.setDia(datos.getInt("dia"));
            i.setTotalHorasMto(datos.getFloat("totalHorasMto"));
            i.setTotalHorasParada(datos.getFloat("totalHorasParada"));
            lista.add(i);
            ots++;
        }
        conexion.cerrarConexion();
        return lista;
    }

    /**
     *
     * @param idEquipo
     * @param anno
     * @param tipoIndicador
     * @return lista de indicador por meses para un año particular
     * @throws SQLException
     */
    public ArrayList<Indicador> listaAnnoIndicador(String idEquipo, String anno, String tipoIndicador) throws SQLException {
        Indicador indicador;
        ArrayList<Indicador> listaIndicador = new ArrayList<>();
        ArrayList<Indicador> listaIndicadorDB = listaMesEnDb(idEquipo, anno);
        YearMonth ym;

        Equipo e = new Equipo().buscarEquipo(idEquipo);
        float tiempoFuncionamiento = e.getTiempoDeFuncionamiento();
        for (int i = 1; i <= 12; i++) {
            indicador = new Indicador();
            indicador.setMes(i);
            indicador.setAnno(Integer.parseInt(anno));
            indicador.setTotalHorasMto(0);
            indicador.setTotalHorasParada(0);
            listaIndicador.add(indicador);
        }

        if (!listaIndicadorDB.isEmpty()) {
            for (Indicador in : listaIndicador) {

                for (Indicador inDb : listaIndicadorDB) {
                    if (in.getMes() == inDb.getMes()) {
                        in.sumarHorasParada(inDb.getTotalHorasParada());
                        in.sumarHorasMTO(inDb.getTotalHorasMto());
                        in.sumarNumeroOt();
                    }

                }
            }
        }

        //calcular Confiablilidad  y  Mantenibilidad
        int mes = 1;
        int diasDelmes;
        for (Indicador in : listaIndicador) {
            ym = YearMonth.of(Integer.parseInt(anno), mes);
            diasDelmes = ym.lengthOfMonth();
            mes++;
            float confiabilidad;
            float mantenibilidad;
            if (in.getNumeroOTs() != 0) {
                confiabilidad = (tiempoFuncionamiento * diasDelmes) / in.getNumeroOTs();
                mantenibilidad = in.getTotalHorasParada() / in.getNumeroOTs();
            } else {
                confiabilidad = (tiempoFuncionamiento * diasDelmes);
                mantenibilidad = in.getTotalHorasParada();
            }
            in.setConfiabilidad(confiabilidad);
            in.setMantenibilidad(mantenibilidad);
            //System.out.println(t.getoEE());
        }

        switch (tipoIndicador) {
            case "mantenibilidad":
                //ya calculado
                break;

            case "confiabilidad":
                //ya calculado
                break;
            case "disponibilidad":
                float disponibilidad;
                for (Indicador in : listaIndicador) {
                    disponibilidad = (in.getConfiabilidad() / (in.getConfiabilidad() + in.getMantenibilidad())) * 100;
                    in.setDisponibilidad(disponibilidad);
                }
                break;
            default:
                break;
        }

        return listaIndicador;
    }

    public List<OrdenDeTrabajo> getListaOrdenesDeTrabajo() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        OrdenDeTrabajo ot;
        List<OrdenDeTrabajo> listaOrdenesDeTrabajo = new ArrayList<>();
        String sql = "SELECT * FROM `ordenesdetrabajo` WHERE `solicitudesDeMantenimiento_equipos_idequipos`='" + this.idEquipo + "' ORDER BY `fechaInicio` ASC;";
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

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipos) {
        this.idEquipo = idEquipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getLargo() {
        return largo;
    }

    public void setLargo(String largo) {
        this.largo = largo;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getTipoPotencia() {
        return tipoPotencia;
    }

    public void setTipoPotencia(String tipoPotencia) {
        this.tipoPotencia = tipoPotencia;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public boolean isAmbienteCorrosivo() {
        return ambienteCorrosivo;
    }

    public void setAmbienteCorrosivo(boolean ambienteCorrosivo) {
        this.ambienteCorrosivo = ambienteCorrosivo;
    }

    public float getTiempoDeFuncionamiento() {
        return tiempoDeFuncionamiento;
    }

    public void setTiempoDeFuncionamiento(float tiapoDeFuncionamiento) {
        this.tiempoDeFuncionamiento = tiapoDeFuncionamiento;
    }

    public float getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(float horasDeUso) {
        this.horasDeUso = horasDeUso;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getCaracteristicasEspecificas() {
        return caracteristicasEspecificas;
    }

    public void setCaracteristicasEspecificas(String caracteristicasEspecificas) {
        this.caracteristicasEspecificas = caracteristicasEspecificas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getEstadoPintura() {
        return estadoPintura;
    }

    public void setEstadoPintura(String estadoPintura) {
        this.estadoPintura = estadoPintura;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
        this.seguridad = seguridad;
    }

    public int getAmbiental() {
        return ambiental;
    }

    public void setAmbiental(int ambiental) {
        this.ambiental = ambiental;
    }

    public int getValorMatriz() {
        return valorMatriz;
    }

    public void calcularCostosyNumeroDeOT(String anno) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        this.numeroOrdenes = 0;
        this.costo = 0;
        this.totalHorasParada = 0;
        String sql = " SELECT totalHorasParada, (costoManoDeObra + costoMateriales )AS costo FROM `ordenesdetrabajo`"
                + " WHERE solicitudesDeMantenimiento_equipos_idequipos='" + this.idEquipo + "' AND YEAR(`fechaInicio`)='" + anno + "';";
        ResultSet datosE = conexion.consultarBD(sql);
        while (datosE.next()) {
            this.numeroOrdenes++;
            this.costo += datosE.getInt("costo");
            this.totalHorasParada += datosE.getFloat("totalHorasParada");
        }
        conexion.cerrarConexion();
    }

    public void calcularValorMatriz(String anno) throws SQLException {
        calcularCostosyNumeroDeOT(anno);
        int operacion;
        if (this.numeroOrdenes == 0) {operacion = this.totalHorasParada;}
        else { operacion = this.totalHorasParada / this.numeroOrdenes;}
        int f = 0;
        if (this.numeroOrdenes <= 1) { f = 1;}
        else if (this.numeroOrdenes <= 12){f = 3;}
        else if(this.numeroOrdenes <= 52){f = 4;}
        else if(this.numeroOrdenes >52){f = 6;}
        int tfs = 0;
        if (operacion < 4) { tfs = 1;}
        else if (operacion <= 8){tfs = 2;}
        else if(operacion <= 24){tfs = 4;}
        else if(operacion >24){tfs = 6;}
        int ic = 0;
        if (this.costo < 5000000) { ic = 3;}
        else if (this.costo <= 20000000){ic = 5;}
        else if(this.costo <= 50000000){ic = 10;}
        else if(this.costo <=100000000){ic = 25;}
        else if(this.costo >100000000){ic = 30;}
        
        
        this.valorMatriz = (int) (f + this.seguridad + this.ambiental + ic + tfs);
    }

}
