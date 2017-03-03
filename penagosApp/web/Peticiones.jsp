<%-- 
    Document   : PeticionesCalendario
    Created on : 14/07/2016, 02:29:23 PM
    Author     : Andres

--%>


<%@page import="beans.CrearPDF"%>
<%@page import="beans.OrdenDeTrabajoPDF"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@page import="beans.SolicitudDeMantenimiento"%>
<%@page import="beans.Produccion"%>
<%@page import="beans.Proveedor"%>
<%@page import="beans.Indicador"%>
<%@page import="beans.OrdenDeTrabajo"%>
<%@page import="com.google.gson.JsonParser"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="beans.Repuesto"%>
<%@page import="beans.Herramienta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="beans.Equipo"%>
<%@page import="beans.TiempoOcio"%>
<%@page import="beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%-- Beans de aplicación aquí --%>

<%    // Iniciando respuesta JSON.
    String respuesta = "{";

    //Lista de procesos o tareas a realizar 
    List<String> tareas = Arrays.asList(new String[]{
        "login",
        "logout",
        "listar",
        "listarsolicitud",
        "guardar",
        "vereditar",
        "editar",
        "eliminar",
        "generarpdf",
        "guardasolicitud",
        "listarordenes",
        "guardarot",});

    // Si el usuario tiene sesión válida y permisos.
    String proceso = "" + request.getParameter("proceso");
    // Validación de parámetros utilizados en todos los procesos.
    if (tareas.contains(proceso)) {
        respuesta += "\"ok\": true";
        // ------------------------------------------------------------------------------------- //
        // -----------------------------------INICIO PROCESOS----------------------------------- //
        // ------------------------------------------------------------------------------------- //
        // ---------------------------------Proceso 1--------------------------------- //
        if (proceso.equals("logout")) {
            session.invalidate();
            respuesta += ",\"" + proceso + "\": true";
            // --------------------------------Proceso 2---------------------------------- //
        } else if (proceso.equals("login")) {
            String login = "" + request.getParameter("usr");
            String pass = "" + request.getParameter("pass");
            Usuario u = new Usuario();
            if (u.validarLogin(login, pass)) {
                session.setAttribute("usr", u);
                respuesta += ",\"" + proceso + "\": true";
            } else {
                u = null;
                session.setAttribute("usuario", u);
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("listar")) {
            Equipo e = new Equipo();
            List<Equipo> lista = e.getListaDeEquipos();
            respuesta += ",\"" + proceso + "\": true,\"Maquinas\":" + new Gson().toJson(lista);

        } else if (proceso.equals("listarsolicitud")) {
            SolicitudDeMantenimiento sm = new SolicitudDeMantenimiento();
            List<SolicitudDeMantenimiento> lista = sm.getListaSolicitudesDeMantenimiento();
            respuesta += ",\"" + proceso + "\": true,\"Solicitudes\":" + new Gson().toJson(lista);

        } else if (proceso.equals("guardar")) {
            String nombre = "" + request.getParameter("nombre");
            String codigo = "" + request.getParameter("codigo");
            String tipo = "" + request.getParameter("tipo");
            String ubicacion = "" + request.getParameter("ubicacion");
            String estado = "" + request.getParameter("estado");
            String marca = "" + request.getParameter("marca");
            String modelo = "" + request.getParameter("modelo");
            String serie = "" + request.getParameter("serie");
            String imagen = "" + request.getParameter("imagen");
            String peso = "" + request.getParameter("peso");
            String altura = "" + request.getParameter("altura");
            String largo = "" + request.getParameter("largo");
            String ancho = "" + request.getParameter("ancho");
            String potencia = "" + request.getParameter("potencia");
            String tipopotencia = "" + request.getParameter("tipoCF");
            String control = "" + request.getParameter("control");
            String frecuencia = "" + request.getParameter("frecuencia");
            String alimentacion = "" + request.getParameter("alimentacion");
            String tiempofuncionamiento = "" + request.getParameter("tiempofuncionamiento");
            String horasuso = "" + request.getParameter("horasuso");
            String ambientecorrosivo = "" + request.getParameter("corrosivo");
            String estadopintura = "" + request.getParameter("pintura");
            String funciones = "" + request.getParameter("funciones");
            String caracteristicasespecificas = "" + request.getParameter("cespecificas");
            String observaciones = "" + request.getParameter("observaciones");
            String operario = "" + request.getParameter("operario");

            Equipo e = new Equipo();
            e.setCodigo(codigo);
            e.setNombre(nombre);
            e.setTipoEquipo(tipo);
            e.setMarca(marca);
            e.setModelo(modelo);
            e.setUbicacion(ubicacion);
            e.setEstado(estado);
            e.setSerie(serie);
            e.setPeso(peso);
            e.setAltura(altura);
            e.setLargo(largo);
            e.setAncho(ancho);
            e.setPotencia(potencia);
            e.setTipoPotencia(tipopotencia);
            e.setFrecuencia(frecuencia);
            e.setAlimentacion(alimentacion);
            e.setAmbienteCorrosivo(Boolean.parseBoolean(ambientecorrosivo));
            e.setTiempoDeFuncionamiento(Float.parseFloat(tiempofuncionamiento));
            e.setHorasDeUso(Float.parseFloat(horasuso));
            e.setFunciones(funciones);
            e.setCaracteristicasEspecificas(caracteristicasespecificas);
            e.setObservaciones(observaciones);
            e.setControl(control);
            e.setEstadoPintura(estadopintura);
            e.setImagen(imagen);
            e.setOperario(operario);
            if (e.guardarEquipo()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("editar")) {
            String nombre = "" + request.getParameter("nombre");
            String codigo = "" + request.getParameter("codigo");
            String tipo = "" + request.getParameter("tipo");
            String ubicacion = "" + request.getParameter("ubicacion");
            String estado = "" + request.getParameter("estado");
            String marca = "" + request.getParameter("marca");
            String modelo = "" + request.getParameter("modelo");
            String serie = "" + request.getParameter("serie");
            String imagen = "" + request.getParameter("imagen");
            String peso = "" + request.getParameter("peso");
            String altura = "" + request.getParameter("alto");
            String largo = "" + request.getParameter("largo");
            String ancho = "" + request.getParameter("ancho");
            String potencia = "" + request.getParameter("potencia");
            String tipopotencia = "" + request.getParameter("tipoCF");
            String control = "" + request.getParameter("control");
            String frecuencia = "" + request.getParameter("frecuencia");
            String alimentacion = "" + request.getParameter("alimentacion");
            String tiempofuncionamiento = "" + request.getParameter("tiempofuncionamiento");
            String horasuso = "" + request.getParameter("horasuso");
            String ambientecorrosivo = "" + request.getParameter("corrosivo");
            String estadopintura = "" + request.getParameter("pintura");
            String funciones = "" + request.getParameter("funciones");
            String caracteristicasespecificas = "" + request.getParameter("cespecificas");
            String observaciones = "" + request.getParameter("observaciones");
            String Id = "" + request.getParameter("id");
            String operario = "" + request.getParameter("operario");

            Equipo e = new Equipo();
            e.setIdEquipo(Integer.parseInt(Id));
            e.setCodigo(codigo);
            e.setNombre(nombre);
            e.setTipoEquipo(tipo);
            e.setMarca(marca);
            e.setModelo(modelo);
            e.setUbicacion(ubicacion);
            e.setEstado(estado);
            e.setSerie(serie);
            e.setPeso(peso);
            e.setAltura(altura);
            e.setLargo(largo);
            e.setAncho(ancho);
            e.setPotencia(potencia);
            e.setTipoPotencia(tipopotencia);
            e.setFrecuencia(frecuencia);
            e.setAlimentacion(alimentacion);
            e.setAmbienteCorrosivo(Boolean.parseBoolean(ambientecorrosivo));
            e.setTiempoDeFuncionamiento(Float.parseFloat(tiempofuncionamiento));
            e.setHorasDeUso(Float.parseFloat(horasuso));
            e.setFunciones(funciones);
            e.setCaracteristicasEspecificas(caracteristicasespecificas);
            e.setObservaciones(observaciones);
            e.setControl(control);
            e.setEstadoPintura(estadopintura);
            e.setImagen(imagen);
            e.setOperario(operario);
            if (e.actualizarrEquipo()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("guardasolicitud")) {
            String codigo = "" + request.getParameter("codigo");
            String revision = "" + request.getParameter("revision");
            String solicitud = "" + request.getParameter("solicitud");
            String fecha = "" + request.getParameter("fecha");
            String idequipo = "" + request.getParameter("idequipo");
            String reparacion = "" + request.getParameter("reparacion");
            String electrico = "" + request.getParameter("electrico");
            String mecanico = "" + request.getParameter("mecanico");
            String correctivo = "" + request.getParameter("correctivo");
            String preventivo = "" + request.getParameter("preventivo");
            String otros = "" + request.getParameter("otros");
            String servicio = "" + request.getParameter("servicio");
            String acciones = "" + request.getParameter("acciones");
            String material = "" + request.getParameter("material");
            String horasparada = "" + request.getParameter("horasparada");
            String horasmto = "" + request.getParameter("horasmto");
            String horasolicitud = "" + request.getParameter("horasolicitud");
            String horaentrega = "" + request.getParameter("horaentrega");
            String solicitado = "" + request.getParameter("solicitado");
            String realizado = "" + request.getParameter("realizado");
            String recibido = "" + request.getParameter("recibido");

            SolicitudDeMantenimiento st = new SolicitudDeMantenimiento();
            st.setCodigo(codigo);
            st.setDescripcionAcciones(acciones);
            st.setDescripcionServicio(servicio);
            st.setFecha(fecha);
            st.setHoraEntrega(horaentrega);
            st.setHoraSolicitud(horasolicitud);
            st.setHorasMTO(Float.parseFloat(horasmto));
            st.setHorasParada(Float.parseFloat(horasparada));
            st.setIdequipo(Integer.parseInt(idequipo));
            st.setMaterial(material);
            st.setMtoCorrectivo(Boolean.parseBoolean(correctivo));
            st.setMtoElectrico(Boolean.parseBoolean(electrico));
            st.setMtoMecanico(Boolean.parseBoolean(mecanico));
            st.setMtoPreventivo(Boolean.parseBoolean(preventivo));
            st.setOrdenDeTrabajo(false);
            st.setOtros(Boolean.parseBoolean(otros));
            st.setRevision(revision);
            st.setSolicitadoPor(solicitado);
            st.setRealizadoPor(realizado);
            st.setRecibidoPor(recibido);
            st.setReparacion(Boolean.parseBoolean(reparacion));
            st.setSolicitudDeServicio(solicitud);
            if (st.guardarSolicitudDeMantenimiento()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }

        } else if (proceso.equals("guardarot")) {
            String ordendetrabajo = "" + request.getParameter("ordendetrabajo");
            String fechainicio = "" + request.getParameter("fechainicio");
            String fechafin = "" + request.getParameter("fechafin");
            String solicitud = "" + request.getParameter("solicitud");
            String idequipo = "" + request.getParameter("idequipo");
            String anomaliaparte = "" + request.getParameter("anomaliaparte");
            String solicitada = "" + request.getParameter("solicitada");
            String revisada = "" + request.getParameter("revisada");
            String autorizada = "" + request.getParameter("autorizada");
            String trabajos = "" + request.getParameter("trabajos");
            String materiales = "" + request.getParameter("materiales");
            String cmanoobra = "" + request.getParameter("cmanoobra");
            String cmateriales = "" + request.getParameter("cmateriales");
            String horasmto = "" + request.getParameter("horasmto");
            String horasparada = "" + request.getParameter("horasparada");
            String daños = "" + request.getParameter("daños");
            String trabajosrealizados = "" + request.getParameter("trabajosrealizados");
            String observaciones = "" + request.getParameter("observaciones");
            String ejecuto = "" + request.getParameter("ejecuto");
            String recibio = "" + request.getParameter("recibio");
            String tiposolicitud = "" + request.getParameter("tiposolicitud");
            String generasolicitud = "" + request.getParameter("generasolicitud");

            OrdenDeTrabajo ot = new OrdenDeTrabajo();

            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ot.setIdsolicitudDeMantenimiento(Integer.parseInt(solicitud));
            ot.setIdequipo(Integer.parseInt(idequipo));
            ot.setNumeroOrdenDeTrabajo(ordendetrabajo);
            ot.setFechaInicio(format.parse(fechainicio));
            ot.setFechaFin(format.parse(fechafin));
            ot.setTipoSolicitud(tiposolicitud);
            ot.setPartes(anomaliaparte);
            ot.setSolicitadaPor(solicitada);
            ot.setRevisadaPor(revisada);
            ot.setAutorizadaPor(autorizada);
            ot.setDescripcionesTrabajos(trabajos);
            ot.setMateriales(materiales);
            ot.setCostoManoDeObra(Float.parseFloat(cmanoobra));
            ot.setCostoMateriales(Float.parseFloat(cmateriales));
            ot.setTotalHorasMto(Float.parseFloat(horasmto));
            ot.setTotalHorasParada(Float.parseFloat(horasparada));
            ot.setDescripcionDanos(daños);
            ot.setDescripcionTrabajosRealizados(trabajosrealizados);
            ot.setEjecutadoPor(ejecuto);
            ot.setRecibidoAprobadoPor(recibio);
            ot.setDptAdmyControl(Boolean.parseBoolean(generasolicitud));//departamento de administracion y control genera la orden ?
            ot.setObservaciones(observaciones);
            ot.setCerrada(false);

            if (ot.guardarOrdenDeTrabajo()) {
                SolicitudDeMantenimiento sM = new SolicitudDeMantenimiento().buscarSolicitudDeMantenimiento(solicitud);
                sM.setOrdenDeTrabajo(true);
                sM.actualizarSolicitudDeMantenimiento();
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }

        } else if (proceso.equals("listarordenes")) {
            OrdenDeTrabajo ot = new OrdenDeTrabajo();
            List<OrdenDeTrabajo> lista = ot.getListaOrdenesDeTrabajo();
            respuesta += ",\"" + proceso + "\": true,\"Ordenes\":" + new Gson().toJson(lista);
        } else if (proceso.equals("generarpdf")) {
            String idSolicitud = "" + request.getParameter("id");
            String idEquipo = "" + request.getParameter("idequipo");
            CrearPDF.crear(idSolicitud, idEquipo);

        } else if (proceso.equals("tiempodeocio")) {
            String Id = "" + request.getParameter("id");
            String Tiempo = "" + request.getParameter("tiempo");
            String Tipo = "" + request.getParameter("tipo");
            String Fecha = "" + request.getParameter("fecha");

            Equipo e = new Equipo();
            if (e.agregarTiempoDeOcio(Id, Tiempo, Tipo, Fecha)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }

        } else if (proceso.equals("eliminar")) {
            String Id = "" + request.getParameter("id");
            Equipo e = new Equipo();
            if (e.eliminarEquipo(Id)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("vereditar")) {
            String Id = "" + request.getParameter("id");
            Equipo e = new Equipo();
            respuesta += ",\"" + proceso + "\": true,\"Equipo\":" + new Gson().toJson(e.buscarEquipo(Id));
        } else if (proceso.equals("OEE")) {
            String Id = "" + request.getParameter("id");
            String Mes = "" + request.getParameter("mes");
            String Anno = "" + request.getParameter("anno");
            Equipo e = new Equipo();
            List<TiempoOcio> mes = e.listaMes(Id, Mes, Anno);
            List<TiempoOcio> anno = e.listaAnno(Id, Anno);
            List<Float> tiempomes = new ArrayList<>();
            List<Float> tiempoanno = new ArrayList<>();
            for (TiempoOcio to : anno) {
                tiempoanno.add(to.getoEE());
            }
            for (TiempoOcio to : mes) {
                tiempomes.add(to.getoEE());
            }
            respuesta += ",\"" + proceso + "\": true";
            respuesta = respuesta + ",\"Mes\":" + new Gson().toJson(tiempomes);
            respuesta = respuesta + ",\"ANNO\":" + new Gson().toJson(tiempoanno);
        } else if (proceso.equals("guardaherramineta")) {
            String Codigo = "" + request.getParameter("codigo");
            String Nombre = "" + request.getParameter("nombre");
            String Cantidad = "" + request.getParameter("cantidad");
            String Descripcion = "" + request.getParameter("descripcion");
            Herramienta h = new Herramienta();
            h.setCodigo(Codigo);
            h.setNombre(Nombre);
            h.setCantidad(Integer.parseInt(Cantidad));
            h.setDescripcion(Descripcion);
            if (h.guardarHerramienta()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }

        } else if (proceso.equals("eliminarherramienta")) {
            String Id = "" + request.getParameter("id");

            Herramienta h = new Herramienta();
            if (h.borrarHerramienta(Id)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("guardarepuesto")) {
            String Codigo = "" + request.getParameter("codigo");
            String Nombre = "" + request.getParameter("nombre");
            String Cantidad = "" + request.getParameter("cantidad");
            String Precio = "" + request.getParameter("precio");
            String Minimo = "" + request.getParameter("minimo");
            String Descripcion = "" + request.getParameter("descripcion");
            Repuesto r = new Repuesto();
            r.setNombre(Nombre);
            r.setCantidad(Integer.parseInt(Cantidad));
            r.setDescripcion(Descripcion);
            r.setPrecio(Float.parseFloat(Precio));
            r.setMinimo(Integer.parseInt(Minimo));
            r.setCodigo(Codigo);
            if (r.guardarRepuesto()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("eliminarrepuesto")) {
            String Id = "" + request.getParameter("id");

            Repuesto r = new Repuesto();
            if (r.borrarRepuesto(Id)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("guardarot")) {
//            Tarea t;
//            OrdenDeTrabajo ot = new OrdenDeTrabajo();
//            String tareasOT = "" + request.getParameter("tareas");
//            String IdEquipo = "" + request.getParameter("idequipo");
//            String OdtTrabajo = "" + request.getParameter("ordtrabajo");
//            String Solicita = "" + request.getParameter("solicita");
//            String FechaInicio = "" + request.getParameter("fechainicio");
//            String FechafFinal = "" + request.getParameter("fechafinal");
//            String Mantenimiento = "" + request.getParameter("mantenimiento");
//            String Diagnostico = "" + request.getParameter("diagnostico");
//            boolean Electrico = Boolean.parseBoolean("" + request.getParameter("electrico"));
//            boolean Mecanico = Boolean.parseBoolean("" + request.getParameter("mecanico"));
//            boolean Electronico = Boolean.parseBoolean("" + request.getParameter("electronico"));
//
//            ot.setSolicitante(Solicita);
//            ot.setDiagnostico(Diagnostico);
//            ot.setFechaFin(FechafFinal);
//            ot.setFechaInicio(FechaInicio);
//            ot.setTipoMantenimiento(Mantenimiento);
//            ot.setDnElectrico(Electrico);
//            ot.setDnElectronico(Electronico);
//            ot.setDnMecanico(Mecanico);
//            ot.setCodigo(OdtTrabajo);
//
//            if (ot.guardarOT(IdEquipo)) {
//                JsonArray tareajson = new JsonParser().parse(tareasOT).getAsJsonArray();
//                for (int i = 0; i < tareajson.size(); i++) {
//                    String nombre = tareajson.get(i).getAsJsonObject().get("tarea").toString().replace("\"", "");
//                    String fechainicio = tareajson.get(i).getAsJsonObject().get("fechainicio").toString().replace("\"", "");
//                    String fechafin = tareajson.get(i).getAsJsonObject().get("fechafinal").toString().replace("\"", "");
//                    String materiales = tareajson.get(i).getAsJsonObject().get("materiales").toString();
//                    float costo = Float.parseFloat(tareajson.get(i).getAsJsonObject().get("costo").toString().replace("\"", ""));
//                    t = new Tarea();
//                    t.setNombre(nombre);
//                    t.setFechaInicio(fechainicio);
//                    t.setFechaFin(fechafin);
//                    t.setMateriales(materiales);
//                    t.setCosto(costo);
//                    if (t.guardarTarea(String.valueOf(ot.getIdOrdenesDeTrabajo()), IdEquipo)) {
//                        respuesta += ",\"" + proceso + "\": true";
//                    } else {
//                        respuesta += ",\"" + proceso + "\": false";
//                    }
//                }
//            } else {
//                respuesta += ",\"" + proceso + "\": false";
//            }

        } else if (proceso.equals("accidentabilidad")) {
            String Id = "" + request.getParameter("id");
            String Mes = "" + request.getParameter("mes");
            String Anno = "" + request.getParameter("anno");
            Equipo e = new Equipo();
            List<Indicador> mes = e.listaMesIndicador(Id, Mes, Anno, proceso);
            List<Indicador> anno = e.listaAnnoIndicador(Id, Anno, proceso);
            List<Float> tiempomes = new ArrayList<>();
            List<Float> tiempoanno = new ArrayList<>();
            for (Indicador to : anno) {
                tiempoanno.add(to.getAccidentabilidad());
            }
            for (Indicador to : mes) {
                tiempomes.add(to.getAccidentabilidad());
            }
            respuesta += ",\"" + proceso + "\": true";
            respuesta = respuesta + ",\"Mes\":" + new Gson().toJson(tiempomes);
            respuesta = respuesta + ",\"ANNO\":" + new Gson().toJson(tiempoanno);
        } else if (proceso.equals("disponibilidad")) {
            String Id = "" + request.getParameter("id");
            String Mes = "" + request.getParameter("mes");
            String Anno = "" + request.getParameter("anno");
            Equipo e = new Equipo();
            List<Indicador> mes = e.listaMesIndicador(Id, Mes, Anno, proceso);
            List<Indicador> anno = e.listaAnnoIndicador(Id, Anno, proceso);
            List<Float> tiempomes = new ArrayList<>();
            List<Float> tiempoanno = new ArrayList<>();
            for (Indicador to : anno) {
                tiempoanno.add(to.getDisponibilidad());
            }
            for (Indicador to : mes) {
                tiempomes.add(to.getDisponibilidad());
            }
            respuesta += ",\"" + proceso + "\": true";
            respuesta = respuesta + ",\"Mes\":" + new Gson().toJson(tiempomes);
            respuesta = respuesta + ",\"ANNO\":" + new Gson().toJson(tiempoanno);
        } else if (proceso.equals("confiabilidad")) {
            String Id = "" + request.getParameter("id");
            String Mes = "" + request.getParameter("mes");
            String Anno = "" + request.getParameter("anno");
            Equipo e = new Equipo();
            List<Indicador> mes = e.listaMesIndicador(Id, Mes, Anno, proceso);
            List<Indicador> anno = e.listaAnnoIndicador(Id, Anno, proceso);
            List<Float> tiempomes = new ArrayList<>();
            List<Float> tiempoanno = new ArrayList<>();
            for (Indicador to : anno) {
                tiempoanno.add(to.getConfiabilidad());
            }
            for (Indicador to : mes) {
                tiempomes.add(to.getConfiabilidad());
            }
            respuesta += ",\"" + proceso + "\": true";
            respuesta = respuesta + ",\"Mes\":" + new Gson().toJson(tiempomes);
            respuesta = respuesta + ",\"ANNO\":" + new Gson().toJson(tiempoanno);
        } else if (proceso.equals("mantenibilidad")) {
            String Id = "" + request.getParameter("id");
            String Mes = "" + request.getParameter("mes");
            String Anno = "" + request.getParameter("anno");
            Equipo e = new Equipo();
            List<Indicador> mes = e.listaMesIndicador(Id, Mes, Anno, proceso);
            List<Indicador> anno = e.listaAnnoIndicador(Id, Anno, proceso);
            List<Float> tiempomes = new ArrayList<>();
            List<Float> tiempoanno = new ArrayList<>();
            for (Indicador to : anno) {
                tiempoanno.add(to.getMantenibilidad());
            }
            for (Indicador to : mes) {
                tiempomes.add(to.getMantenibilidad());
            }
            respuesta += ",\"" + proceso + "\": true";
            respuesta = respuesta + ",\"Mes\":" + new Gson().toJson(tiempomes);
            respuesta = respuesta + ",\"ANNO\":" + new Gson().toJson(tiempoanno);
        } else if (proceso.equals("guardarmantenimiento")) {
//            String Id = "" + request.getParameter("id");
//            String Nombre = "" + request.getParameter("nombre");
//            String Codigo = "" + request.getParameter("codigo");
//            String Operario = "" + request.getParameter("operario");
//            String Departamento = "" + request.getParameter("departamento");
//            String Fecha = "" + request.getParameter("fecha");
//            String Partes = "" + request.getParameter("partes");
//            String Actividades = "" + request.getParameter("actividades");
//            String Frecuencia = "" + request.getParameter("frecuencia");
//            Mantenimiento m = new Mantenimiento();
//            m.setNombre(Nombre);
//            m.setCodigo(Codigo);
//            m.setActividades(Actividades);
//            m.setDepartamento(Departamento);
//            m.setOperario(Operario);
//            m.setFecha(Fecha);
//            m.setFrecuencia(Frecuencia);
//            m.setPartesDelEquipo(Partes);
//            if (m.guardarMantenimiento(Id)) {
//                respuesta += ",\"" + proceso + "\": true";
//            } else {
//                respuesta += ",\"" + proceso + "\": false";
//            }

        } else if (proceso.equals("guardaproveedor")) {
            String Nombre = "" + request.getParameter("nombre");
            String Direccion = "" + request.getParameter("direccion");
            String Telefono = "" + request.getParameter("telefono");
            String Correo = "" + request.getParameter("correo");
            Proveedor p = new Proveedor();
            p.setCorreoElectronico(Correo);
            p.setDireccion(Direccion);
            p.setNombre(Nombre);
            p.setTelefono(Telefono);
            if (p.guardarProveedor()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("eliminarproveedor")) {
            String Id = "" + request.getParameter("id");

            Proveedor p = new Proveedor();
            if (p.borrarProveedor(Id)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("guardaproduccion")) {
            String Nombre = "" + request.getParameter("nombre");
            String Imagen = "" + request.getParameter("imagen");
            String Descripcion = "" + request.getParameter("descripcion");
            Produccion p = new Produccion();
            p.setNombre(Nombre);
            p.setImagen(Imagen);
            p.setDescripcion(Descripcion);

            if (p.guardarProduccion()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("eliminarproducto")) {
            String Id = "" + request.getParameter("id");
            Produccion p = new Produccion();
            if (p.borrarProduccion(Id)) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }
        } else if (proceso.equals("estadomantenimiento")) {
//            String Id = "" + request.getParameter("id");
//            String Estado = "" + request.getParameter("estado");
//            Mantenimiento m = new Mantenimiento();
//            if (m.actualizarEstadoMAntenimiento(Id, Estado)) {
//                respuesta += ",\"" + proceso + "\": true";
//            } else {
//                respuesta += ",\"" + proceso + "\": false";
//            }
        } else if (proceso.equals("repuestosuma")) {
            String Total = "" + request.getParameter("total");
            String Id = "" + request.getParameter("id");
            Repuesto r = new Repuesto();
            r.setIdRepuestos(Integer.parseInt(Id));
            r.setCantidad(Integer.parseInt(Total));
            if (r.actualizarCantidadRepuesto()) {
                respuesta += ",\"" + proceso + "\": true";
            } else {
                respuesta += ",\"" + proceso + "\": false";
            }

        }

        // ------------------------------------------------------------------------------------- //
        // -----------------------------------FIN PROCESOS-------------------------------------- //
        // ------------------------------------------------------------------------------------- //
        // Proceso desconocido.
    } else {
        respuesta += "\"ok\": false,";
        respuesta += "\"error\": \"INVALID\",";
        respuesta += "\"errorMsg\": \"Lo sentimos, los datos que ha enviado,"
                + " son inválidos. Corrijalos y vuelva a intentar por favor.\"";
    }

    // Responder como objeto JSON codificación ISO 8859-1.
    respuesta += "}";
    response.setContentType("application/json;charset=iso-8859-1");
    out.print(respuesta);
%>
