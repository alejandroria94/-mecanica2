<%-- 
    Document   : Solicitudes Mantenimiento
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Solicitudes</title>
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
                        <ul id="indicadores" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="#!">Disponibilidad</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Confiabilidad</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Mantenibilidad</a></li>
                        </ul>
                        <ul id="almacen" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="#!">Proveedores</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Produccion</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Herramientas</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Repuestos</a></li>
                        </ul>
                        <ul id="mantenimiento" class="dropdown-content">
                            <li><a class="blue-text text-darken-2"href="Maquinas.jsp">Cronograma</a></li>
                            <li><a class="blue-text text-darken-2" href="#!">Gestionar Mto</a></li>
                        </ul>
                        <nav class="nav-wrapper white ">
                            <a href="#!"><img src="img/logo.png"/></a>
                            <ul class="right hide-on-med-and-down">
                                <li ><a class="red-text text-accent-4" href="#">Info</a></li>
                                    <%
                                        usuarios = (beans.Usuario) session.getAttribute("usr");
                                        if (usuarios != null) {
                                    %>
                                <li ><a class="blue-text text-darken-2" href="#" >Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="#">Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="SolicitudesMto.jsp" style="background-color: #ccc" data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
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
            <div ng-controller="penagosSolicitudesAppCtrl as sm">
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s3">
                                <a class="waves-effect light-blue lighten-1 btn left-align" ng-click="sm.nuevaSolicitud()">Nueva Solicitud</a>
                            </div>
                            <div class="input-field col s2 offset-s7">
                                <input id="last_name" type="text" ng-model="sm.busqueda" class="validate ">
                                <label class="indigo-text text-darken-4" >Busqueda</label>
                            </div>

                        </div>
                        <table class="bordered highlight responsive-table">
                            <thead>
                                <tr>
                                    <th class="indigo-text text-darken-4">Codigo</th>
                                    <th class="indigo-text text-darken-4">NombreEquipo</th>
                                    <th class="indigo-text text-darken-4">Fecha</th>
                                    <th class="indigo-text text-darken-4">Solicitado Por</th>
                                    <th class="indigo-text text-darken-4" style="width: 200px">Opciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr  ng-repeat="mto in sm.Solicitudes| filter:sm.busqueda |orderBy: 'fecha'" data-id="{{mto.idsolicitudesDeMantenimiento}}">
                                    <td>{{mto.codigo}}</td>
                                    <td>{{mto.equipo.nombre}}</td>
                                    <td>{{mto.fecha}}</td>
                                    <td>{{mto.solicitadoPor}}</td>
                                    <td>
                                        <div id="menu">
                                            <ul>
                                                <li class="nivel1 btn"><a href="#" class="nivel1">Opciones</a>
                                                    <ul>
                                                        <li><a href="EditarFichaTecnica.jsp?id={{mto.idsolicitudesDeMantenimiento}}" >Editar</a></li>
                                                        <li><a href="#" ng-click="sm.eliminar(mto.idsolicitudesDeMantenimiento)">Eliminar</a></li>
                                                        <li ng-if="mto.ordenDeTrabajo===false"><a href="OrdenDeTrabajo.jsp?codigo={{mto.idsolicitudDeMantenimiento}}">Orden de trabajo</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
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
        <script>
                                                            var app = {
                                                                init: function () {

                                                                    $('.carousel.carousel-slider').carousel({
                                                                        fullWidth: true,
                                                                        duration: 500
                                                                    });
                                                                    $('.modal').modal({
                                                                        dismissible: true, // Modal can be dismissed by clicking outside of the modal
                                                                        opacity: .5, // Opacity of modal background
                                                                        inDuration: 300, // Transition in duration
                                                                        outDuration: 200, // Transition out duration
                                                                        startingTop: '40%', // Starting top style attribute
                                                                        endingTop: '10%'
                                                                    });

                                                                },
                                                                boton: function (btn) {
                                                                    $(btn).parents("tr").find("#menu").show();
                                                                    //                                                    $("#menu").show();
                                                                }

                                                            };
                                                            $(document).ready(function () {
                                                                app.init();
                                                            });
        </script>
    </body>
</html>
