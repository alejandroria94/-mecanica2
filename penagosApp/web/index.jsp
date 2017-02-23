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
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
    </head>
    <body>
        <div>
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
                    <nav class="nav-wrapper white ">
                        <a href="#!"><img src="img/logo.png"/></a>
                        <ul class="right hide-on-med-and-down">
                            <li ><a class="red-text text-accent-4" href="#">Info</a></li>
                            <%
                                 usuarios = (beans.Usuario) session.getAttribute("usr");
                                 if(usuarios!=null){
                            %>
                            <li ><a class="blue-text text-darken-2" href="#">Maquinas</a></li>
                            <li><a class="blue-text text-darken-2" href="#">Orden de Trabajo</a></li>
                            <li ><a class="blue-text text-darken-2" href="#">Mantenimiento</a></li>
                            <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="indicadores">&nbsp;&nbsp;&nbsp;Indicadores&nbsp;&nbsp;&nbsp;▼</a></li>
                            <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="almacen">&nbsp;&nbsp;&nbsp;Almacen&nbsp;&nbsp;&nbsp;▼</a></li>
                            <li><a class="dropdown-button red-text text-accent-4" href="#!" data-activates="almacen">Salir</a></li>
                            <%}%>
                            <li><a class="dropdown-button blue-text text-darken-2" href="#login" >&nbsp;Ingreso&nbsp;</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="row">
                <div class="col s10 offset-s1">
                    <div class="carousel carousel-slider center" data-indicators="true">
                        <a class="carousel-item" href="#one!"><img src="http://lorempixel.com/800/400/food/1"></a>
                        <a class="carousel-item" href="#two!"><img src="http://lorempixel.com/800/400/food/2"></a>
                        <a class="carousel-item" href="#three!"><img src="http://lorempixel.com/800/400/food/3"></a>
                        <a class="carousel-item" href="#four!"><img src="http://lorempixel.com/800/400/food/4"></a>
                    </div>
                </div>
            </div>

        </div>
        <!-- Modal Structure -->
        <div id="login" class="modal" style="width: 25%" ng-app="penagosApp">
            <div class="modal-content" ng-controller="penagosAppCtrl as vm">
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
