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
public class Produccion {

    private int idproduccion;
    private String nombre;
    private String imagen;
    private String descripcion;
    private ArrayList<Produccion> listaProduccion;

    public boolean guardarProduccion() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO produccion( nombre, imagen, descripcion) "
                + " VALUES ( '" + this.nombre + "','" + this.imagen + "','" + this.descripcion + "');";
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

    public boolean borrarProduccion(String idproduccion) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `produccion` WHERE `idproduccion`='" + idproduccion + "'";
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

    public Produccion obtenerProduccion(String idproduccion) throws SQLException {
        ResultSet datosE = buscarProduccion("idproduccion", idproduccion);
        Produccion p = llenarDatosObjetoEquipo(datosE);
        return p;
    }

    public Produccion llenarDatosObjetoEquipo(ResultSet rs) throws SQLException {
        Produccion p = null;

        if (rs.next()) {
            p = new Produccion();
            p.setIdproduccion(Integer.parseInt(rs.getString("idproduccion")));
            p.setNombre(rs.getString("nombre"));
            p.setImagen(rs.getString("imagen"));
            p.setDescripcion(rs.getString("descripcion"));
        }

        return p;
    }

    public ResultSet buscarProduccion(String parametro, String busqueda) {
        ConexionBD conexion = new ConexionBD();
        ResultSet datosE = conexion.consultarBD("select * from produccion where " + parametro + "='" + busqueda + "'");
        return datosE;
    }

    public ArrayList<Produccion> listarProduccion() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Produccion p;
        this.listaProduccion = new ArrayList<>();
        String sql = "select * from produccion";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            p = new Produccion();

            p.setIdproduccion(rs.getInt("idproduccion"));
            p.setNombre(rs.getString("nombre"));
            p.setImagen(rs.getString("imagen"));
            p.setDescripcion(rs.getString("descripcion"));
            listaProduccion.add(p);
        }
        return this.listaProduccion;
    }

    public int getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(int idproduccion) {
        this.idproduccion = idproduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripción;
    }

}
