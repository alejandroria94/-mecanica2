/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fido
 */
public class Parametrizacion {

    private final Map<String, String> parametros = new HashMap<>();

    public Parametrizacion() {
        this.parametros.put("rutaImgServer", "C:\\Users\\Fido\\Documents\\GitHub\\-mecanica2\\penagosApp\\web\\img\\");
        this.parametros.put("rutaImgDB", "img\\");
    }

    public String getParametro(String parametro) {
        return this.parametros.get(parametro);
    }

}
