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
public class Demo {

    public static void main(String[] args) throws SQLException {
        Produccion p =new Produccion().obtenerProduccion("2");
        
        System.out.println(p.getIdproduccion()+p.getNombre()+p.getDescripcion());
        System.out.println(p.getImagen());

    }

    public void listaMes(String idEquipo, String mesActual, String annoActual) throws SQLException {
        YearMonth ym;
        ym = YearMonth.of(Integer.parseInt(annoActual), Integer.parseInt(mesActual));
        int diasDelmes = ym.lengthOfMonth();
//        System.out.println(mesActual + "mes");
//        System.out.println(annoActual + "año");
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        ArrayList<TiempoOcio> listaTiemposDeOcioEnDb = listaDiaEnDb(idEquipo, mesActual, annoActual);
        for (int i = 0; i < diasDelmes; i++) {
            tO = new TiempoOcio();
            tO.setDia(i + 1);
            tO.setMes(Integer.parseInt(mesActual));
            tO.setAnno(Integer.parseInt(annoActual));
            tO.setTiempo(0);
            listaTiemposDeOcio.add(tO);
        }
        if (!listaTiemposDeOcioEnDb.isEmpty()) {
            listaTiemposDeOcio.stream().forEach((TiempoOcio t) -> {
                listaTiemposDeOcioEnDb.stream().filter((tDb) -> (t.getDia() == tDb.getDia())).forEach((tDb) -> {
                    t.sumarTiempo(tDb.getTiempo());
                });
            });
        }
        for (TiempoOcio t : listaTiemposDeOcio) {
            System.out.println(t.getDia() + " " + t.getTiempo());

        }
        System.out.println("--------");
        for (TiempoOcio t : listaTiemposDeOcioEnDb) {
            System.out.println(t.getDia() + " " + t.getTiempo());

        }

    }

    public void listaAnno(String idEquipo, String annoActual) throws SQLException {
        //        System.out.println(annoActual + "año");
        TiempoOcio tO;
        ArrayList<TiempoOcio> listaTiemposDeOcio = new ArrayList<>();
        ArrayList<TiempoOcio> listaTiemposDeOcioEnDb = listaMesEnDb(idEquipo, annoActual);
        for (int i = 0; i < 12; i++) {
            tO = new TiempoOcio();
            tO.setMes(i + 1);
            tO.setAnno(Integer.parseInt(annoActual));
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
        for (TiempoOcio t : listaTiemposDeOcio) {
            System.out.println(t.getMes() + " " + t.getTiempo());

        }
        System.out.println("--------");
        for (TiempoOcio t : listaTiemposDeOcioEnDb) {
            System.out.println(t.getMes() + " " + t.getTiempo());

        }

    }

    public ArrayList<TiempoOcio> listaDiaEnDb(String idEquipos, String mes, String anno) throws SQLException {
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

    public ArrayList<TiempoOcio> listaMesEnDb(String idEquipos, String anno) throws SQLException {
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
}
