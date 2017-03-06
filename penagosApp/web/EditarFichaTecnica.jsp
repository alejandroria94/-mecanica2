<%-- 
    Document   : FichaTecnica
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page import="beans.Equipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <%
            String id = request.getParameter("id");
        %>
        <title>Editar Ficha Tecnica</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/materialize.min.css" rel="stylesheet">
        <link href="css/jasny-bootstrap.css" rel="stylesheet">
        <link href="css/sweetalert.css" rel="stylesheet">
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
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp">Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="ListaOrdenDeTrabajo.jsp">Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2"href="Indicadores.jsp" >Indicadores</a></li>
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
            <div ng-controller="penagosFichaEdtiAppCtrl as fte"> <!--formulario-->
                <input type="text" id="identificador" value="<%=id%>" hidden="true"/>
                <div class="row">
                    <div class="col s2 offset-s5">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Editar Ficha Tecnica</strong></legend>
                    </div>
                </div>
                <div class="row">
                    <div class="col s5 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Equipo</strong></legend>
                        <div class="row">
                            <div class="input-field col s12">
                                <input  type="text" class="active validate" placeholder="nombre" ng-model="fte.nombre">
                                <label  class="indigo-text text-darken-4 active" >Nombre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " placeholder="" ng-model="fte.codigo">
                                <label for="last_name" class="indigo-text text-darken-4" >Codigo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " placeholder="" ng-model="fte.tipo">
                                <label for="last_name" class="indigo-text text-darken-4" >Tipo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate"placeholder="" ng-model="fte.seccion">
                                <label for="last_name" class="indigo-text text-darken-4">Seccion</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " placeholder=""ng-model="fte.estado">
                                <label for="last_name" class="indigo-text text-darken-4" >Estado</label>
                            </div>
                        </div>
                    </div>
                    <div class="col s5">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Fabricante</strong></legend>   
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="last_name" type="text" class="validate "placeholder=""ng-model="fte.marca">
                                <label for="last_name" class="indigo-text text-darken-4">Marca</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " placeholder="" ng-model="fte.modelo">
                                <label for="last_name" class="indigo-text text-darken-4" >Modelo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " placeholder=""ng-model="fte.serie">
                                <label for="last_name" class="indigo-text text-darken-4" >Serie</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="last_name" type="text" class="validate "placeholder=""ng-model="fte.operario">
                                <label for="last_name" class="red-text text-darken-4">Operario</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s5 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Tecnicas</strong></legend>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " placeholder=""ng-model="fte.tipoCF">
                                <label for="last_name" class="indigo-text text-darken-4">Tipo</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.potencia">
                                <label for="last_name" class="indigo-text text-darken-4">Potencia</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.control">
                                <label for="last_name" class="indigo-text text-darken-4">Control</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.alimentacion">
                                <label for="last_name" class="indigo-text text-darken-4">Alimentacion</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.frecuencia">
                                <label for="last_name" class="indigo-text text-darken-4">Frecuencia</label>
                            </div>
                        </div>
                    </div>
                    <div class="col s5">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Fisicas</strong></legend>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate"placeholder="" ng-model="fte.largo">
                                <label for="last_name" class="indigo-text text-darken-4" >Largo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" placeholder=""ng-model="fte.alto">
                                <label for="last_name" class="indigo-text text-darken-4">Alto</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.ancho">
                                <label for="last_name" class="indigo-text text-darken-4">Ancho</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.peso">
                                <label for="last_name" class="indigo-text text-darken-4">Peso</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Condiciones de Trabajo</strong></legend>
                        <div class="input-field col s3">
                            <input id="last_name" type="number" class="validate "placeholder="" ng-model="fte.horasuso">
                            <label for="last_name" class="indigo-text text-darken-4">Horas de uso</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="last_name" type="number" class="validate"placeholder=""ng-model="fte.tiempofuncionamiento">
                            <label for="last_name" class="indigo-text text-darken-4">Tiempo de funcionamiento</label>
                        </div>
<!--                        <div class="input-field col s3">
                            <input id="last_name" type="text" class="validate "placeholder="" ng-model="fte.pintura">
                            <label for="last_name" class="indigo-text text-darken-4">Estado pintura</label>
                        </div>
                        <div class="col s3">
                            <label for="last_name" class="indigo-text text-darken-4">Ambiente corrosivo</label>
                            <div class="switch">
                                <label >
                                    No
                                    <input type="checkbox" ng-model="fte.corrosivo">
                                    <span class="lever"></span>
                                    Si
                                </label>
                            </div>

                            <input id="last_name" type="text" class="validate ">
                        </div>-->
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Especificas</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea" placeholder="" length="120" ng-model="fte.cespecificas"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Funciones</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea" placeholder=""length="120" ng-model="fte.funciones"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Observaciones</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea"placeholder="" length="120" ng-model="fte.observaciones"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 right">
                        <a class="waves-effect red darken-2 btn left-align" ng-click="fte.salir()">Cancelar</a>
                        <a class="waves-effect  green  btn left-align" ng-click="fte.guardar()">Guardar</a>
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
        <script src="js/sweetalert.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
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
