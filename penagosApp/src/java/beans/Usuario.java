/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Usuario {

    private String login = "";
    private String pass = "";
    private String nombre;
    private final ConexionBD cDB = new ConexionBD();

    public Usuario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean validarLogin(String login, String pass) throws SQLException {
        ResultSet datos;
        boolean rs = false;
        String sql = "SELECT * FROM Usuarios WHERE login='" + login + "' AND pass='" + pass + "';";
        datos = cDB.consultarBD(sql);
        if (datos.next()) {
            this.login = datos.getString(2);
            this.pass = datos.getString(3);
            rs = true;
        }
        return rs;
    }

}
