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
public class Repuesto {

    private int idRepuestos;
    private int Equipos_idEquipos;
    private String nombre;
    private int cantidad;
    private int minimo;
    private float precio;
    private String descripcion;
    private ArrayList<Repuesto> listaRepuestos;
    private String codigo;

    // para repuestos 
    public boolean guardarRepuesto() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO repuestos(nombre,cantidad,minimo,precio,descripcion,codigo) "
                + " VALUES ( '" + this.nombre + "','" + this.cantidad + "','" + this.minimo + "','" + this.precio + "','" + this.descripcion + "','" + this.codigo + "');";
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

    public boolean borrarRepuesto(String idRepuestos) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `repuestos` WHERE `idRepuestos`='" + idRepuestos + "'";
            //System.out.println(sql2);
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

    public ArrayList<Repuesto> listarRepuestos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Repuesto r;
        this.listaRepuestos = new ArrayList<>();
        String sql = "SELECT * FROM `repuestos` ";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            r = new Repuesto();
            r.setIdRepuestos(rs.getInt("idRepuestos"));
            r.setNombre(rs.getString("nombre"));
            r.setCantidad(rs.getInt("cantidad"));
            r.setMinimo(rs.getInt("minimo"));
            r.setPrecio(rs.getFloat("precio"));
            r.setDescripcion(rs.getString("descripcion"));
            r.setCodigo(rs.getString("codigo"));
            listaRepuestos.add(r);
        }
        return this.listaRepuestos;
    }

    public boolean actualizarRepuesto() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            //UPDATE table_name
            //SET column1=value1,column2=value2,...
            //WHERE some_column=some_value;
            String sql2 = "UPDATE `repuestos` SET nombre='" + this.nombre + "',cantidad='" + this.cantidad + "',minimo='" + this.minimo + "',precio='" + this.precio + "',descripcion='" + this.descripcion + "',codigo='" + this.codigo
                    + "' WHERE `idRepuestos`='" + this.idRepuestos + "'";
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
    public boolean actualizarCantidadRepuesto() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
            String sql2 = "UPDATE `repuestos` SET cantidad='" + this.cantidad 
                    + "' WHERE `idRepuestos`='" + this.idRepuestos + "'";
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

    public void descontarCantidad(int descuento) {
        this.cantidad -= descuento;

    }

    public void aumentarCantidad(int aumento) {
        this.cantidad += aumento;
    }

    public int getIdRepuestos() {
        return idRepuestos;
    }

    public void setIdRepuestos(int idRepuestos) {
        this.idRepuestos = idRepuestos;
    }

    public int getEquipos_idEquipos() {
        return Equipos_idEquipos;
    }

    public void setEquipos_idEquipos(int Equipos_idEquipos) {
        this.Equipos_idEquipos = Equipos_idEquipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
