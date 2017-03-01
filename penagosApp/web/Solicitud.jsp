<%-- 
    Document   : FichaTecnica
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page import="java.util.List"%>
<%@page import="beans.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Solicitud</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
        <link href="css/jasny-bootstrap.css" rel="stylesheet">
        <style>
            .switch label input[type=checkbox]:checked+.lever:after{
                background-color: #1b5e20;
            }
            .switch label input[type=checkbox]:checked+.lever{
                background-color: green;
            }
            .switch label .lever:after{
                background-color: #b71c1c;
            }
            .switch label .lever{
                background-color:red;
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
                            <li><a class="blue-text text-darken-2"href="#">Cronograma</a></li>
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
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp">Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="#">Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" style="background-color: #ccc" data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
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

            <div ng-controller=""> <!--formulario-->
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate "ng-model="">
                                <label for="last_name" class="indigo-text text-darken-4" >Codigo</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate "ng-model="">
                                <label for="last_name" class="indigo-text text-darken-4" >Revision</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate "ng-model="">
                                <label for="last_name" class="indigo-text text-darken-4" >Solicitud de servicio</label> 
                            </div>
                            <div class="input-field col s3">
                                <input type="date" class="datepicker" >
                                <label for="last_name" class="indigo-text text-darken-4" >Fecha</label> 
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <%
                        Equipo e = new Equipo();
                        List<Equipo> lista = e.getListaDeEquipos();
                    %>
                    <div class="input-field col s4 offset-s1">
                        <select class="icons">
                            <option value="" disabled selected>Seleccione un equipo.</option>
                            <%
                                for (Equipo eq : lista) {
                            %>
                            <option value="<%=eq.getIdEquipo()%>//<%=eq.getUbicacion()%>//<%=eq.getOperario()%>" data-icon="<%=eq.getImagen()%>" class="left circle"><%=eq.getNombre()%></option>
                            <%}%>
                        </select>
                        <label>Equipo</label>
                    </div>
                    <div class="input-field col s3">
                        <input id="last_name" type="text" class="validate "ng-model="">
                        <label for="last_name" class="indigo-text text-darken-4" >Seccion</label> 
                    </div>
                    <div class="input-field col s3">
                        <input id="last_name" type="text" class="validate "ng-model="">
                        <label for="last_name" class="indigo-text text-darken-4" >Operario</label> 
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Servicio solicitado</strong></legend>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="reparacion"  />
                                    <label for="reparacion">Reparacion</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="electrico"  />
                                    <label for="electrico">Mto. Electrico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="macanico"  />
                                    <label for="macanico">Mto. Mecanico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="correctivo"  />
                                    <label for="correctivo">Mto. Correctivo</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="preventivo"  />
                                    <label for="preventivo">Mto. Preventico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="otros"  />
                                    <label for="otros">Otros</label>
                                </p>
                            </div>
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
        <script src="js/materialize.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
        <script>
                                    var app = {
                                        init: function () {
                                            $('.datepicker').pickadate();
                                            $('select').material_select();
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
