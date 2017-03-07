<%-- 
    Document   : index
    Created on : 22/02/2017, 05:42:56 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Penagos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
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
                                <li ><a class="blue-text text-darken-2" href="Matriz.jsp">Matriz De Criticidad</a></li>
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp">Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="ListaOrdenDeTrabajo.jsp">Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" data-activates="mantenimiento">Mantenimiento▼</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2"href="Indicadores.jsp" >Indicadores</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="almacen">&nbsp;&nbsp;&nbsp;Almacen&nbsp;&nbsp;&nbsp;▼</a></li>
                                <li><a class="dropdown-button red-text text-accent-4" ng-click="vm.salir()" href="#!" >Salir</a></li>
                                    <%} else
                                        if (usuarios == null) {%>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#login" >&nbsp;Ingreso&nbsp;</a></li>
                                    <%}%>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="carousel carousel-slider center" data-indicators="true">
                            <a class="carousel-item" href="#one!"><img src="img/001.jpg"></a>
                            <a class="carousel-item" href="#two!"><img src="img/001.jpg"></a>
                            <a class="carousel-item" href="#three!"><img src="img/001.jpg"></a>
                            <a class="carousel-item" href="#four!"><img src="img/001.jpg"></a>
                        </div>
                    </div>
                </div>
                <!-- Modal Structure -->
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

        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script>
                                    var app = {
                                        init: function () {
                                            $(".dropdown-button").dropdown({
                                                inDuration: 300,
                                                outDuration: 225,
                                                constrainWidth: true
                                            });
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
                                        }
                                    };
                                    $(document).ready(function () {
                                        app.init();
                                    });
        </script>
    </body>
</html>
