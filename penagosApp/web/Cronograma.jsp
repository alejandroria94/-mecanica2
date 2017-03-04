<%-- 
    Document   : Solicitudes Mantenimiento
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="beans.SolicitudDeMantenimiento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Ordenes de trabajo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
        <link href="css/jasny-bootstrap.css" rel="stylesheet">
        <link href="css/sweetalert.css" rel="stylesheet">
        <link href="css/fullcalendar.print.min.css" rel="stylesheet" media="print">
        <link href="css/fullcalendar.min.css" rel="stylesheet">
        <style>
            #menu {  
                text-align: center;
                font-size: 0.8em;
                width: 100%;
                margin: 20px auto;
            }
            #menu ul { 
                list-style-type: none;}
            #menu ul li.nivel1 {
                float: left;
                width: 100%;
                margin-right: 2px;
            }
            #menu ul li a {
                display: block;
                text-decoration: none;
                color: #fff;
                background-color: #26a69a;
            }
            #menu ul li:hover {
                position: relative;
            }
            #menu ul li a:hover, #menu ul li:hover a.nivel1 {
                background-color: #2bbbad;
                color: #000;
            }
            #menu ul li a.nivel1 {
                display: block!important;display: none;
            }
            #menu ul li ul {
                display: none;
            }
            #menu ul li a:hover ul, #menu ul li:hover ul {
                display: block;
                position: absolute;left: 0px;
            }
            #menu ul li ul li a {
                width: 190px;
                border-top-color: #000;
            }
            #menu ul li ul li a:hover {
                border-top-color: #000;
                position: relative;
            }
            table.falsa {
                border-collapse:collapse;
                border:0px;
                float: left;
                position: relative;
            }
        </style>
    </head>
    <body >
        <div ng-app="penagosApp">
            <div ng-controller="penagosAppCtrl as vm">
                <br>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <!-- Dropdown Structure -->
                        <ul id="indicadores" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="#!">Disponibilidad</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Confiabilidad</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Mantenibilidad</a></li>
                        </ul>
                        <ul id="almacen" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="ListaProveedores.jsp">Proveedores</a></li>
                            <li><a class="blue-text text-darken-2" href="ListaHerramientas.jsp">Herramientas</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Repuestos</a></li>
                        </ul>
                        <ul id="mantenimiento" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="Cronograma.jsp">Cronograma</a></li>
                            <li><a class="blue-text text-darken-2" href="SolicitudesMto.jsp">Gestionar Mto</a></li>
                        </ul>
                        <nav class="nav-wrapper white ">
                            <a href="index.jsp"><img src="img/logo.png"/></a>
                            <ul class="right hide-on-med-and-down">
                                <li ><a class="red-text text-accent-4" href="#">Info</a></li>
                                    <%
                                        usuarios = (beans.Usuario) session.getAttribute("usr");
                                        if (usuarios != null) {
                                    %>
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp" >Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="ListaOrdenDeTrabajo.jsp" >Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="SolicitudesMto.jsp" style="background-color: #ccc"  data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="indicadores">&nbsp;&nbsp;&nbsp;Indicadores&nbsp;&nbsp;&nbsp;▼</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="almacen">&nbsp;&nbsp;&nbsp;Almacen&nbsp;&nbsp;&nbsp;▼</a></li>
                                <li><a class="dropdown-button red-text text-accent-4" ng-click="vm.salir()">Salir</a></li>
                                    <%} else
                                        if (usuarios == null) {%>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#login" >&nbsp;Ingreso&nbsp;</a></li>
                                    <%}%>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div id="login" class="modal" style="width: 25%" >
                    <div class="modal-content" >
                        <div class="row">
                            <div class="col s10 offset-s1">
                                <img src="img/logo.png">
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s10 offset-s1 ">
                                <input id="email" type="text" ng-model="vm.username">
                                <label for="email" class="blue-text text-darken-2">Username</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s10 offset-s1">
                                <input id="password" type="password" ng-model="vm.password">
                                <label for="password" class="blue-text text-darken-2">Password</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s5 offset-s1">
                                <a class="waves-effect  light-blue darken-4  btn" ng-click="vm.login()">Login</a>
                            </div>
                            <div class="col s5">
                                <a class="waves-effect red btn">Exit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%
                if (usuarios != null) {
            %>
            <!--inicio de contenido-->
            <div ng-controller="penagosCRAppCtrl as c">
                <div class="row">
                    <div class="col s6 offset-s3">
                        <a class="waves-effect green accent-4 btn left-align" href="#login">Realizada</a>
                        <a class="waves-effect yellow darken-4 btn left-align" href="#login">Pendiente</a>
                        <a class="waves-effect red darken-4 btn left-align" href="#login">Vencida</a>
                        <a class="waves-effect blue darken-4 btn left-align" href="#login">Sin asignar</a>
                    </div>
                    <div class="col s3">
                        <a class="waves-effect btn left-align" ng-click="c.PDF()"href="#login">PDF</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <hr>
                        <div id="calendar"></div>
                    </div>
                </div>

            </div>
            <!-- MFin de contenido-->
            <%} else {%>
            <div class="row">
                <div class="col s10 offset-s1">
                    <div class="card light-blue accent-1 ">
                        <div class="card-content black-text">
                            <p>Lo sentimos su sesion a caducado. Por favor ingrese de nuevo</p>
                        </div>
                        <div class="card-action">
                            <a class="waves-effect cyan darken-1 btn left-align" href="index.jsp">Inicio</a>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
            <!-- Modal Structure -->
            <%
                List<SolicitudDeMantenimiento> lista = new SolicitudDeMantenimiento().getListaSolicitudesDeMantenimiento();
                JsonArray solicitudes = new JsonArray();
                JsonObject jo;
                for (SolicitudDeMantenimiento sm : lista) {
                    jo = new JsonObject();
                    jo.addProperty("codigo", sm.getCodigo());
                    jo.addProperty("title", sm.getCodigo());
                    jo.addProperty("start", sm.getFecha());
                    jo.addProperty("descripcion", sm.getDescripcionServicio());
                    jo.addProperty("solicitado", sm.getSolicitadoPor());
                    if (sm.getEstado().equals("Pendiente")) {
                        jo.addProperty("backgroundColor", "#f57f17");
                        jo.addProperty("borderColor", "#f57f17");
                    }
                    if (sm.getEstado().equals("Realizada")) {
                        jo.addProperty("backgroundColor", "#00c853");
                        jo.addProperty("borderColor", "#00c853");
                    }
                    if (sm.getEstado().equals("Vencida")) {
                        jo.addProperty("backgroundColor", "#b71c1c");
                        jo.addProperty("borderColor", "#b71c1c");
                    }
                    if (sm.getEstado().equals("Sin Asignar")) {
                        jo.addProperty("backgroundColor", "#0d47a1");
                        jo.addProperty("borderColor", "#0d47a1");
                    }
                    solicitudes.add(jo);
                }
            %>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/sweetalert.min.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
        <script src="js/underscore.js"></script>
        <script src="js/moment.min.js"></script>
        <script src="js/fullcalendar.js"></script>
        <script>
                            var Solicitudes = <%=solicitudes%>;
                            var app = {
                                init: function () {

                                    $('#calendar').fullCalendar({
                                        locale: 'es',
                                        header: {
                                            left: 'prev,next today',
                                            center: 'title',
                                            right: 'month,basicWeek,basicDay'
                                        },
                                        events: Solicitudes,
                                        eventRender: function (calEvent, element) {
                                            $(element).off('click').on('click', function () {
                                                swal({
                                                    title: calEvent.title,
                                                    text: "<p style='font-size:15px'>" + calEvent.descripcion + "</p><br>Solicitado por: <h2><strong>"+calEvent.solicitado+"</strong></h2>",
                                                    html: true
                                                });
                                            });
                                        }

                                    });


                                }
                            };
                            $(document).ready(function () {
                                app.init();
                            });
        </script>
    </body>
</html>
