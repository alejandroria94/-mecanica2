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

/**
 *
 * @author Fido
 */
public class Equipo {

    private int idEquipos;
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
    private ArrayList<OrdenDeTrabajo> listaOrdenesDeTrabajo;
    private ArrayList<Equipo> listaDeEquipos;
    private String operario;

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
        String sentencia = "INSERT INTO Equipos(nombre, tipoEquipo, marca, modelo, ubicacion, estado, serie, peso, altura, largo, ancho, potencia, tipoPotencia, frecuencia, alimentacion, ambienteCorrosivo, tiempoDeFuncionamiento, horasDeUso, funciones, caracteristicasEspecificas, observaciones, control, estadoPintura, imagen,codigo,operario) "
                + " VALUES ( '" + this.nombre + "','" + this.tipoEquipo + "','" + this.marca + "','" + this.modelo + "','" + this.ubicacion + "','" + this.estado + "','" + this.serie + "','" + this.peso + "','" + this.altura + "','" + this.largo + "','"
                + this.ancho + "','" + this.potencia + "','" + this.tipoPotencia + "','" + this.frecuencia + "','" + this.alimentacion + "','" + this.ambienteCorrosivo + "','" + this.tiempoDeFuncionamiento + "','" + this.horasDeUso + "','" + this.funciones + "','"
                + this.caracteristicasEspecificas + "','" + this.observaciones + "','" + this.control + "','" + this.estadoPintura + "','" + this.imagen + "','" + this.codigo + "','" + this.operario + "');  ";
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
        this.idEquipos = Integer.parseInt(idEquipos);
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
                    + "',imagen='" + this.imagen + "',codigo='" + this.codigo + "',operario='" + this.operario + "' WHERE `idEquipos`='" + this.idEquipos + "'";
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
            String sql2 = "DELETE FROM `Equipos` WHERE `idEquipos`='" + idEquipos + "'";
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

    public ArrayList<Equipo> getListaDeEquipos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Equipo e;
        this.listaDeEquipos = new ArrayList<>();
        String sql = "select * from Equipos";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            e = new Equipo();
            e.setIdEquipos(Integer.parseInt(rs.getString("idEquipos")));
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
            listaDeEquipos.add(e);
        }
        conexion.cerrarConexion();
        return this.listaDeEquipos;
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
            e.setIdEquipos(Integer.parseInt(datosE.getString("idEquipos")));
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
        return exito;
    }

    /**
     *
     * @param idEquipo
     * @param mes
     * @param anno
     * @return lista de horas ocio por dias para un mes del año
     * @throws SQLException
     */
    public ArrayList<TiempoOcio> listaMes(String idEquipo, String mes, String anno) throws SQLException {
        YearMonth ym;
        ym = YearMonth.of(Integer.parseInt(anno), Integer.parseInt(mes));
        Equipo e = new Equipo().buscarEquipo(idEquipo);
        float tiempoFuncionamiento = e.getTiempoDeFuncionamiento();
        int diasDelmes = ym.lengthOfMonth();
//        System.out.println(mesActual + "mes");
//        System.out.println(annoActual + "año");
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        ArrayList<TiempoOcio> listaTiemposDeOcioEnDb = listaDiaEnDbOEE(idEquipo, mes, anno);
        for (int i = 0; i < diasDelmes; i++) {
            tO = new TiempoOcio();
            tO.setDia(i + 1);
            tO.setMes(Integer.parseInt(mes));
            tO.setAnno(Integer.parseInt(anno));
            tO.setTiempo(0);
            listaTiemposDeOcio.add(tO);
        }
        if (!listaTiemposDeOcioEnDb.isEmpty()) {
            for (TiempoOcio t : listaTiemposDeOcio) {
                for (TiempoOcio tDb : listaTiemposDeOcioEnDb) {
                    if (t.getDia() == tDb.getDia()) {
                        t.sumarTiempo(tDb.getTiempo());
                    }

                }
            }
            //calcular OEE
            for (TiempoOcio t : listaTiemposDeOcio) {
                t.setoEE(calcularOEE(tiempoFuncionamiento, t.getTiempo()));
                // System.out.println(t.getoEE());
            }
        }
        return listaTiemposDeOcio;
    }

    /**
     *
     * @param idEquipo
     * @param anno
     * @return lista de horas ocio por meses para un año particular
     * @throws SQLException
     */
    public ArrayList<TiempoOcio> listaAnno(String idEquipo, String anno) throws SQLException {
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        ArrayList<TiempoOcio> listaTiemposDeOcioEnDb = listaMesEnDbOEE(idEquipo, anno);
        YearMonth ym;

        Equipo e = new Equipo().buscarEquipo(idEquipo);
        float tiempoFuncionamiento = e.getTiempoDeFuncionamiento();
        for (int i = 0; i < 12; i++) {
            tO = new TiempoOcio();
            tO.setMes(i + 1);
            tO.setAnno(Integer.parseInt(anno));
            tO.setTiempo(0);
            listaTiemposDeOcio.add(tO);
        }
        if (!listaTiemposDeOcioEnDb.isEmpty()) {
            for (TiempoOcio t : listaTiemposDeOcio) {
                for (TiempoOcio tDb : listaTiemposDeOcioEnDb) {

                    if (t.getMes() == tDb.getMes()) {
                        t.sumarTiempo(tDb.getTiempo());
                    }

                }
            }
        }
        //calcular OEE
        int mes = 1;
        int diasDelmes;
        for (TiempoOcio t : listaTiemposDeOcio) {
            ym = YearMonth.of(Integer.parseInt(anno), mes);
            diasDelmes = ym.lengthOfMonth();
            mes++;
            t.setoEE(calcularOEE(tiempoFuncionamiento * diasDelmes, t.getTiempo()));
            //System.out.println(t.getoEE());
        }
        return listaTiemposDeOcio;
    }

    public ArrayList<TiempoOcio> listaDiaEnDbOEE(String idEquipos, String mes, String anno) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "SELECT `tiempo`, EXTRACT(YEAR FROM `fecha`) AS anno, EXTRACT(MONTH FROM `fecha`) AS mes ,EXTRACT(DAY FROM `fecha`) AS dia FROM `tiemposocio` WHERE `Equipos_idEquipos`='" + idEquipos + "' AND MONTH(`fecha`)='" + mes + "' AND YEAR(`fecha`)='" + anno + "'";
        ResultSet datos = conexion.consultarBD(sql);
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        while (datos.next()) {
            tO = new TiempoOcio();
            tO.setAnno(datos.getInt("anno"));
            tO.setMes(datos.getInt("mes"));
            tO.setDia(datos.getInt("dia"));
            tO.setTiempo(datos.getFloat("tiempo"));
            listaTiemposDeOcio.add(tO);
        }
        return listaTiemposDeOcio;
    }

    public ArrayList<TiempoOcio> listaMesEnDbOEE(String idEquipos, String anno) throws SQLException {
        ConexionBD conexion = new ConexionBD();
        String sql = "SELECT `tiempo`, EXTRACT(YEAR FROM `fecha`) AS anno, EXTRACT(MONTH FROM `fecha`) AS mes ,EXTRACT(DAY FROM `fecha`) AS dia FROM `tiemposocio` WHERE `Equipos_idEquipos`='" + idEquipos + "' AND YEAR(`fecha`)='" + anno + "'";
        ResultSet datos = conexion.consultarBD(sql);
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        while (datos.next()) {
            tO = new TiempoOcio();
            tO.setAnno(datos.getInt("anno"));
            tO.setMes(datos.getInt("mes"));
            tO.setDia(datos.getInt("dia"));
            tO.setTiempo(datos.getFloat("tiempo"));
            listaTiemposDeOcio.add(tO);
        }
        return listaTiemposDeOcio;
    }

    public float calcularOEE(float tiempoFuncionamiento, float tiempoDeOcio) {
        float oEE;
        oEE = ((tiempoFuncionamiento - tiempoDeOcio) / tiempoFuncionamiento) * 100;
        return oEE;
    }

    //inidcadores mantenibilidad disponibilidad accidentabilidad confiablidad
    /**
     *
     * @param idEquipo
     * @param mes
     * @param anno
     * @param indicador
     * @return lista de indicador por dias para un mes del año
     * @throws SQLException
     */
    public ArrayList<Indicador> listaMesIndicador(String idEquipo, String mes, String anno, String indicador) throws SQLException {
        YearMonth ym;
        ym = YearMonth.of(Integer.parseInt(anno), Integer.parseInt(mes));
        Equipo e = new Equipo().buscarEquipo(idEquipo);
        float tiempoFuncionamiento = e.getTiempoDeFuncionamiento();
        int diasDelmes = ym.lengthOfMonth();
//        System.out.println(mesActual + "mes");
//        System.out.println(annoActual + "año");
        Indicador in;
        ArrayList<Indicador> listaIndicador = new ArrayList<>();
        // ArrayList<Indicador> listaIndicadorEnDb = listaDiaEnDb(idEquipo, mes, anno);
        for (int i = 0; i < diasDelmes; i++) {
            in = new Indicador();
            listaIndicador.add(in);
        }

        switch (indicador) {
            case "mantenibilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setMantenibilidad((float) (int) (Math.random() * 4) + 1);
                        }

                    }
                }
                break;

            case "accidentabilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setAccidentabilidad(20);
                        }

                    }
                }
                break;
            case "disponibilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setDisponibilidad((float) (int) (Math.random() * 5) + 1);
                        }

                    }
                }
                break;
            case "confiabilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setConfiabilidad((float) (int) (Math.random() * 4) + 1);
                        }

                    }
                }
                break;
            default:
                break;
        }

//        if (!listaIndicadorEnDb.isEmpty()) {
//            for (TiempoOcio t : listaIndicador) {
//                for (TiempoOcio tDb : listaIndicadorEnDb) {
//                    if (t.getDia() == tDb.getDia()) {
//                        t.sumarTiempo(tDb.getTiempo());
//                    }
//
//                }
//            }
//            //calcular OEE
//           
//        }
        return listaIndicador;
    }

    /**
     *
     * @param idEquipo
     * @param anno
     * @param indicador
     * @return lista de indicador por meses para un año particular
     * @throws SQLException
     */
    public ArrayList<Indicador> listaAnnoIndicador(String idEquipo, String anno, String indicador) throws SQLException {
        Indicador in;
        ArrayList<Indicador> listaIndicador = new ArrayList<>();
        //ArrayList<Indicador> listaIndicadorEnDb = listaMesEnDb(idEquipo, anno);
        YearMonth ym;
        Equipo e = new Equipo().buscarEquipo(idEquipo);
        float tiempoFuncionamiento = e.getTiempoDeFuncionamiento();
        for (int i = 0; i < 12; i++) {
            in = new Indicador();
            listaIndicador.add(in);
        }
        switch (indicador) {
            case "mantenibilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setMantenibilidad((float) (int) (Math.random() * 30) + 1);
                        }

                    }
                }
                break;

            case "accidentabilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setAccidentabilidad(20);
                        }

                    }
                }
                break;
            case "disponibilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setDisponibilidad((float) (int) (Math.random() * 35) + 1);
                        }

                    }
                }
                break;
            case "confiabilidad":
                for (Indicador t : listaIndicador) {
                    for (Indicador tDb : listaIndicador) {
                        if (t.getDia() == tDb.getDia()) {
                            t.setConfiabilidad((float) (int) (Math.random() * 50) + 1);
                        }

                    }
                }
                break;
            default:
                break;
        }

//        if (!listaIndicadorEnDb.isEmpty()) {
//            for (TiempoOcio t : listaIndicador) {
//                for (TiempoOcio tDb : listaIndicadorEnDb) {
//
//                    if (t.getMes() == tDb.getMes()) {
//                        t.sumarTiempo(tDb.getTiempo());
//                    }
//
//                }
//            }
//        }
        //calcular indicador
        return listaIndicador;
    }

    public int getIdEquipos() {
        return idEquipos;
    }

    public void setIdEquipos(int idEquipos) {
        this.idEquipos = idEquipos;
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

    public ArrayList<OrdenDeTrabajo> getListaOrdenesDeTrabajo() {
        return listaOrdenesDeTrabajo;
    }

    public void setListaOrdenesDeTrabajo(ArrayList<OrdenDeTrabajo> listaOrdenesDeTrabajo) {
        this.listaOrdenesDeTrabajo = listaOrdenesDeTrabajo;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

}
