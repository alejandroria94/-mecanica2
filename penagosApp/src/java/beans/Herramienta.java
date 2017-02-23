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
public class Herramienta {

    private int idherramientas;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private String codigo;
    private ArrayList<Herramienta> listaHerramientas;

    public boolean guardarHerramienta() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO Herramientas( nombre, descripcion, cantidad,codigo) "
                + " VALUES ( '" + this.nombre + "','" + this.descripcion + "','" + this.cantidad + "','" + this.codigo + "');";
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

    public boolean actualizarHerramienta() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
            String sql2 = "UPDATE `Herramientas` SET nombre='" + this.nombre + "',descripcion='" + this.descripcion + "',cantidad='" + this.cantidad + "',codigo='" + this.codigo + "' WHERE `idherramientas`='" + this.idherramientas + "'";
        if (conexion.setAutoCommitBD(false)) {
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

    public boolean borrarHerramienta(String idherramientas) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            String sql2 = "DELETE FROM `Herramientas` WHERE `idherramientas`='" + idherramientas + "'";
            boolean borro2 = conexion.borrarBD(sql2);
            if (borro2) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        return exito;
    }

    public ArrayList<Herramienta> listarHErramientas() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Herramienta h;
        this.listaHerramientas = new ArrayList<>();
        String sql = "select * from Herramientas";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            h = new Herramienta();
            h.setIdherramientas(rs.getInt("idherramientas"));
            h.setNombre(rs.getString("nombre"));
            h.setDescripcion(rs.getString("descripcion"));
            h.setCantidad(rs.getInt("cantidad"));
            h.setCodigo(rs.getString("codigo"));
            listaHerramientas.add(h);
        }
        return this.listaHerramientas;
    }

    public int getIdherramientas() {
        return idherramientas;
    }

    public void setIdherramientas(int idherrmientas) {
        this.idherramientas = idherrmientas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
