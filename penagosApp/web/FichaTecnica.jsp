<%-- 
    Document   : FichaTecnica
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="beans.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Ficha Tecnica</title>
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
                                <li ><a class="blue-text text-darken-2" href="Maquinas.jsp">Maquinas</a></li>
                                <li><a class="blue-text text-darken-2" href="#">Orden de Trabajo</a></li>
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
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
            <div ng-controller="penagosFichaAppCtrl as ft"> <!--formulario-->
                <div class="row">
                    <div class="col s4 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Equipo</strong></legend>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="last_name" type="text" class="validate "ng-model="ft.nombre">
                                <label for="last_name" class="indigo-text text-darken-4" >Nombre</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "ng-model="ft.codigo">
                                <label for="last_name" class="indigo-text text-darken-4" >Codigo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate "ng-model="ft.tipo">
                                <label for="last_name" class="indigo-text text-darken-4" >Tipo</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.seccion">
                                <label for="last_name" class="indigo-text text-darken-4">Seccion</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.estado">
                                <label for="last_name" class="indigo-text text-darken-4" >Estado</label>
                            </div>
                        </div>
                    </div>
                    <div class="col s4">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Fabricante</strong></legend>   
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="last_name" type="text" class="validate " ng-model="ft.marca">
                                <label for="last_name" class="indigo-text text-darken-4">Marca</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.modelo">
                                <label for="last_name" class="indigo-text text-darken-4" >Modelo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.serie">
                                <label for="last_name" class="indigo-text text-darken-4" >Serie</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="last_name" type="text" class="validate " ng-model="ft.operario">
                                <label for="last_name" class="red-text text-darken-4">Operario</label>
                            </div>
                        </div>
                    </div>
                    <div class="col s2">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Imagen</strong></legend>
                        <div class=" col-lg-12 col-md-12 col-sm-12 fileinput fileinput-new" data-provides="fileinput">
                            <div class="fileinput-preview thumbnail" data-trigger="fileinput" style="width: 100%;height: 200px;"></div>
                            <div>
                                <span class="waves-effect light-blue darken-4  btn btn-file"><span class="fileinput-new">Seleccionar</span><span class="fileinput-exists">Cambiar</span><input type="file" name="..."></span>
                                <a href="#" class="waves-effect red darken-3 btn fileinput-exists" data-dismiss="fileinput">Quitar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s5 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Tecnicas</strong></legend>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate "ng-model="ft.tipoCF">
                                <label for="last_name" class="indigo-text text-darken-4">Tipo</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " ng-model="ft.potencia">
                                <label for="last_name" class="indigo-text text-darken-4">Potencia</label>
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " ng-model="ft.control">
                                <label for="last_name" class="indigo-text text-darken-4">Control</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.alimentacion">
                                <label for="last_name" class="indigo-text text-darken-4">Alimentacion</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.frecuencia">
                                <label for="last_name" class="indigo-text text-darken-4">Frecuencia</label>
                            </div>
                        </div>
                    </div>
                    <div class="col s5">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Fisicas</strong></legend>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" ng-model="ft.largo">
                                <label for="last_name" class="indigo-text text-darken-4" >Largo</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" ng-model="ft.alto">
                                <label for="last_name" class="indigo-text text-darken-4">Alto</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.ancho">
                                <label for="last_name" class="indigo-text text-darken-4">Ancho</label>
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate " ng-model="ft.peso">
                                <label for="last_name" class="indigo-text text-darken-4">Peso</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Condiciones de Trabajo</strong></legend>
                        <div class="input-field col s3">
                            <input id="last_name" type="number" class="validate " ng-model="ft.horasuso">
                            <label for="last_name" class="indigo-text text-darken-4">Horas de uso</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="last_name" type="number" class="validate"ng-model="ft.tiempofuncionamiento">
                            <label for="last_name" class="indigo-text text-darken-4">Tiempo de funcionamiento</label>
                        </div>
                        <div class="input-field col s3">
                            <input id="last_name" type="text" class="validate "ng-model="ft.pintura">
                            <label for="last_name" class="indigo-text text-darken-4">Estado pintura</label>
                        </div>
                        <div class="col s3">
                            <label for="last_name" class="indigo-text text-darken-4">Ambiente corrosivo</label>
                            <div class="switch">
                                <label >
                                    No
                                    <input type="checkbox" ng-model="ft.corrosivo">
                                    <span class="lever"></span>
                                    Si
                                </label>
                            </div>

                            <!--<input id="last_name" type="text" class="validate ">-->
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Caracteristicas Especificas</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ft.cespecificas"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Funciones</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ft.funciones"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Observaciones</strong></legend>
                        <div class="input-field col s12">
                            <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ft.observaciones"></textarea>
                            <label for="textarea1" class="indigo-text text-darken-4">Textarea</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 right">
                        <a class="waves-effect red darken-2 btn left-align" ng-click="ft.salir()">Cancelar</a>
                        <a class="waves-effect  green  btn left-align" ng-click="ft.guardar()">Guardar</a>
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
