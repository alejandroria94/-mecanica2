/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Fido
 */
public class TiempoOcio {

    private int dia;
    private int mes;
    private int anno;
    private float tiempo;
    private float oEE;

    public TiempoOcio() {
        this.oEE = 100;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public void sumarTiempo(float tiempo) {
        this.tiempo += tiempo;
    }

    public float getoEE() {
        return oEE;
    }

    public void setoEE(float oEE) {
        this.oEE = oEE;
    }

}
