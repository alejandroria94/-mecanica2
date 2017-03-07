<%-- 
    Document   : Solicitudes Mantenimiento
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="beans.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Indicadores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
        <link href="css/jasny-bootstrap.css" rel="stylesheet">
        <link href="css/sweetalert.css" rel="stylesheet">
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
                        <ul id="almacen" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="ListaProveedores.jsp">Proveedores</a></li>
                            <li><a class="blue-text text-darken-2" href="ListaHerramientas.jsp">Herramientas</a></li>
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
                                <li ><a class="blue-text text-darken-2" href="Matriz.jsp" >Matriz De Criticidad</a></li>
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp" >Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="ListaOrdenDeTrabajo.jsp" >Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="SolicitudesMto.jsp"  data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" style="background-color: #ccc" href="Indicadores.jsp" >Indicadores</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!"  data-activates="almacen">&nbsp;&nbsp;&nbsp;Almacen&nbsp;&nbsp;&nbsp;▼</a></li>
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
            <div ng-controller="penagosIndicadorAppCtrl as ind">
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <%
                                Equipo e = new Equipo();
                                List<Equipo> lista = e.getListaDeEquipos();
                            %>
                            <div class="input-field col s3">
                                <select class="icons"  id="equipos" ng-model="ind.equipo">
                                    <option value="" disabled selected>Seleccione un equipo.</option>
                                    <%
                                        for (Equipo eq : lista) {
                                    %>
                                    <option value="<%=eq.getIdEquipo()%>+<%=eq.getNombre()%>" data-icon="<%=eq.getImagen()%>" class="left circle"><%=eq.getNombre()%></option>
                                    <%}%>
                                </select>
                                <label>Equipo</label>
                            </div>
                            <div class="input-field col s3">
                                <select class="icons" id="indicador" ng-model="ind.indicador">
                                    <option value="" disabled selected>Seleccione un indicador.</option>
                                    <option value="disponibilidad" class="left">Disponibilidad</option>
                                    <option value="confiabilidad" class="left">Confiabilidad</option>
                                    <option value="mantenibilidad" class="left">Mantenibilidad</option>
                                </select>
                                <label>Indicador</label>
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="number" class="validate "  placeholder=" " ng-model="ind.anno">
                                <label for="last_name" class="indigo-text text-darken-4" >Año</label> 
                            </div>
                            <div class="input-field col s2">
                                <a class="waves-effect cyan darken-2 btn left-align" href=""ng-click="ind.ver()">Ver Indicador</a>
                            </div>
                        </div>
                    </div>
                </div>
<!--                <div class="row">
                    <div class="col s10 offset-s1">
                        <div id="fallasmes">

                        </div>
                    </div>
                </div>-->
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div id="fallasaño">

                        </div>
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
                            <a class="waves-effect cyan darken-2 btn left-align" href="#login">Ingresar</a>
                            <a class="waves-effect cyan darken-1 btn left-align" href="index.jsp">Inicio</a>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
            <!-- Modal Structure -->
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/sweetalert.min.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
        <script src="js/underscore.js"></script>
        <script src="js/highcharts.js"></script>
        <script>
                                    var app = {
                                    init: function () {
                                    $('select').material_select();
                                    $('.modal').modal({
                                    dismissible: true, // Modal can be dismissed by clicking outside of the modal
                                            opacity: .5, // Opacity of modal background
                                            inDuration: 300, // Transition in duration
                                            outDuration: 200, // Transition out duration
                                            startingTop: '40%', // Starting top style attribute
                                            endingTop: '10%'
                                    });
                                    }
                                    };
                                    $(document).ready(function () {
                                    app.init();
                                    });
        </script>
    </body>
</html>
