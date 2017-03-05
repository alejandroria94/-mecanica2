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
        <link href="css/materialize.clockpicker.css" rel="stylesheet">
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
                                <li><a class="dropdown-button blue-text text-darken-2" href="#!" style="background-color: #ccc" data-activates="mantenimiento">Mantenimiento&nbsp;▼</a></li>
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

            <div ng-controller="penagosSolicitudAppCtrl as st" > <!--formulario-->
                <div class="row">
                    <div class="col s2 offset-s5">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Nueva Solicitud</strong></legend>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate " ng-model="st.codigo">
                                <label for="last_name" class="indigo-text text-darken-4" >Codigo</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate " ng-model="st.revision">
                                <label for="last_name" class="indigo-text text-darken-4" >Revision</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate "ng-model="st.solicitud">
                                <label for="last_name" class="indigo-text text-darken-4" >Solicitud de servicio</label> 
                            </div>
                            <div class="input-field col s3">
                                <input type="text" class="datepicker" ng-model="st.fecha">
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
                        <select class="icons" ng-model="st.equipos" ng-change="st.equipo()" id="equipos">
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
                        <input id="last_name" type="text" class="validate "  placeholder=" " ng-model="st.seccion">
                        <label for="last_name" class="indigo-text text-darken-4" >Seccion</label> 
                    </div>
                    <div class="input-field col s3">
                        <input id="last_name" type="text" class="active validate "  placeholder=" "  ng-model="st.operario">
                        <label for="last_name" class="indigo-text text-darken-4" >Operario</label> 
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Servicio solicitado</strong></legend>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="reparacion" ng-model="st.reparacion" o />
                                    <label for="reparacion">Reparacion</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="electrico" ng-model="st.mtoelectrico" checked= />
                                    <label for="electrico">Mto. Electrico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="macanico" ng-model="st.mtomecanico"  checked="false"/>
                                    <label for="macanico">Mto. Mecanico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="correctivo" ng-model="st.mtocorrectivo" checked="false" />
                                    <label for="correctivo">Mto. Correctivo</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="preventivo"  ng-model="st.mtopreventivo" checked="false"/>
                                    <label for="preventivo">Mto. Preventico</label>
                                </p>
                            </div>
                            <div class="col s2">
                                <p>
                                    <input type="checkbox" id="otros" ng-model="st.otros"  checked="false"/>
                                    <label for="otros">Otros</label>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Descripcion del servicio solicitado</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="st.servicio"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Descripcion acciones a realizar</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="st.acciones"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Material a emplear</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="st.material"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s3">
                                <input id="last_name" type="number" class="validate "ng-model="st.horasparada">
                                <label for="last_name" class="indigo-text text-darken-4" >Total horas parada</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="number" class="validate " ng-model="st.horasmto">
                                <label for="last_name" class="indigo-text text-darken-4" >Total horas mto</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="timepicker_ampm_dark"  placeholder="" class="timepicker" type="text"ng-model="st.horasolicitud">
                                <label for="last_name" class="indigo-text text-darken-4 " >Hora solicitud</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="timepicker_ampm_dark" placeholder="" class="timepicker" type="text" ng-model="st.horaentrega">
                                <label for="last_name" class="indigo-text text-darken-4" >Hora entrega</label> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate "ng-model="st.solicitado">
                                <label for="last_name" class="indigo-text text-darken-4" >Servicio solicitado por</label> 
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " ng-model="st.realizado">
                                <label for="last_name" class="indigo-text text-darken-4" >Servicio realizado por</label> 
                            </div>
                            <div class="input-field col s4">
                                <input class="validate" d="last_name"  type="text" ng-model="st.recibido">
                                <label for="last_name" class="indigo-text text-darken-4 " >Recibido a conformidad</label> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 right">
                        <a class="waves-effect red darken-2 btn left-align" ng-click="st.salir()">Cancelar</a>
                        <a class="waves-effect  green  btn left-align" ng-click="st.guardar()">Guardar</a>
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
        <script src="js/materialize.clockpicker.js"></script>
        <script src="js/sweetalert.min.js"></script>
        <script>
                            var app = {
                                init: function () {
                                    $('.timepicker').pickatime({
                                        format:"hh:mm:ss",
                                        twelvehour: false, // change to 12 hour AM/PM clock from 24 hour
                                        autoclose: true,
                                        vibrate: true // vibrate the device when dragging clock hand
                                    });
                                    $('.datepicker').pickadate({
                                        format:"yyyy-mm-dd"
                                    });
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
