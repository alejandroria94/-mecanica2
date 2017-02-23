/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fido
 */
public class Mantenimiento {

    private int idMantenimiento;
    private String nombre;
    private String codigo;
    private String departamento;
    private String fecha;
    private String operario;
    private String partesDelEquipo;
    private String actividades;
    private String frecuencia;
    private int idEquipos;
    private ArrayList<Mantenimiento> listaMantenimientos;
    private String estado;

    public boolean guardarMantenimiento(String idEquipos) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO mantenimiento( nombre, codigo, operario, departamento, fecha, partesDelEquipo, actividades, frecuencia, Equipos_idEquipos,estado) "
                + " VALUES ( '" + this.nombre + "','" + this.codigo + "','" + this.operario + "','" + this.departamento + "','" + this.fecha + "','" + this.partesDelEquipo + "','" + this.actividades + "','" + this.frecuencia + "','" + idEquipos + "','Pendiente');";
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

    public ArrayList<Mantenimiento> listarMantenimientos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Mantenimiento m;
        this.listaMantenimientos = new ArrayList<>();
        String sql = "select * from mantenimiento";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            m = new Mantenimiento();

            m.setIdMantenimiento(rs.getInt("idMantenimiento"));
            m.setNombre(rs.getString("nombre"));
            m.setCodigo(rs.getString("codigo"));
            m.setOperario(rs.getString("operario"));
            m.setDepartamento(rs.getString("departamento"));
            m.setFecha(rs.getString("fecha"));
            m.setPartesDelEquipo(rs.getString("partesDelEquipo"));
            m.setActividades(rs.getString("actividades"));
            m.setFrecuencia(rs.getString("frecuencia"));
            m.setIdEquipos(rs.getInt("Equipos_idEquipos"));
            m.setEstado(rs.getString("estado"));
            listaMantenimientos.add(m);
        }
        return this.listaMantenimientos;
    }

    public boolean actualizarEstadoMAntenimiento(String idMantenimiento, String estado) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            //UPDATE table_name
            //SET column1=value1,column2=value2,...
            //WHERE some_column=some_value;
            String sql2 = "UPDATE `mantenimiento` SET estado='" + estado + "' WHERE `idMantenimiento`='" + idMantenimiento + "'";
            boolean borro2 = conexion.actualizarBD(sql2);
            if (borro2) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        return exito;
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPartesDelEquipo() {
        return partesDelEquipo;
    }

    public void setPartesDelEquipo(String partesDelEquipo) {
        this.partesDelEquipo = partesDelEquipo;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public int getIdEquipos() {
        return idEquipos;
    }

    public void setIdEquipos(int idEquipos) {
        this.idEquipos = idEquipos;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public ArrayList<Mantenimiento> getListaMantenimientos() {
        return listaMantenimientos;
    }

    public void setListaMantenimientos(ArrayList<Mantenimiento> listaMantenimientos) {
        this.listaMantenimientos = listaMantenimientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
