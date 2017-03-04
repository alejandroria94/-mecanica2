<%-- 
    Document   : FichaTecnica
    Created on : 23/02/2017, 04:34:07 PM
    Author     : Andres
--%>


<%@page import="beans.OrdenDeTrabajo"%>
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
                            <li><a class="blue-text text-darken-2"href="#!">Cronograma</a></li>
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
            <div ng-controller="penagosOTAppCtrl as ot"> <!--formulario-->
                <%
                    String id = "" + request.getParameter("codigo");
                    OrdenDeTrabajo ot = new OrdenDeTrabajo(id);
                    ot.getEstado();
                %>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate " ng-model="ot.ordentrabajo">
                                <label for="last_name" class="indigo-text text-darken-4" >Orden de trabajo</label> 
                            </div>
                            <div class="input-field col s3">
                                <input type="text" class="datepicker" ng-model="ot.fechainicio">
                                <label for="last_name" class="indigo-text text-darken-4" >Fecha inicio</label> 
                            </div>
                            <div class="input-field col s3">
                                <input type="text" class="datepicker" ng-model="ot.fechafin">
                                <label for="last_name" class="indigo-text text-darken-4" >Fecha fin</label> 
                            </div>
                            <div class="input-field col s3">
                                <input id="last_name" type="text" class="validate codigosolicitud hide" value="<%=id%>" >
                                <input id="last_name" type="text" class="validate" value="<%=ot.getSolicitudDeMantenimiento().getCodigo()%>" >
                                <label for="last_name" class="indigo-text text-darken-4" >Solicitud</label> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4 offset-s1">
                        <input id="last_name" type="text" class="validate hide idequipo"  value="<%=ot.getSolicitudDeMantenimiento().getEquipo().getIdEquipo()%>">
                        <input id="last_name" type="text" class="validate " value="<%=ot.getSolicitudDeMantenimiento().getEquipo().getCodigo()%>">
                        <label for="last_name" class="indigo-text text-darken-4" >Codigo equipo</label> 
                    </div>
                    <div class="input-field col s6">
                        <input id="last_name" type="text" class="validate " value="<%=ot.getSolicitudDeMantenimiento().getEquipo().getNombre()%>">
                        <label for="last_name" class="indigo-text text-darken-4" >Nombre equipo</label> 
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Tipo de mantenimiento</strong></legend>
                        <ul><%for (String str : ot.getTiposDeMantenimiento()) {%>
                            <ol><%=str%></ol> <%}%></ul>
                    </div>
                    <div class=" col s3">
                        <label class="indigo-text text-darken-4">Dto.Adms. Y control genera orden</label>
                        <div class="switch">
                            <label >
                                No
                                <input type="checkbox"ng-model="ot.generasolicitud">
                                <span class="lever"></span>
                                Si
                            </label>
                        </div>
                    </div>
                    <div class="input-field col s3">

                        <select class="icons" ng-model="ot.tiposolicitud"  id="equipos">
                            <option value="" disabled selected>Seleccione....</option>
                            <option value="Urgente" class="left circle">Urgente</option>
                            <option value="Normal" class="left circle">Normal</option>
                        </select>
                        <label>Tipo de solicitud</label
                    </div>
                </div>
                <div class="row" >
                    <div class="col s10 offset-s1" >
                        <div class="col s12 tablaanomalia" style="border: 1px solid #0059bc">
                            <div class="row">
                                <div class="input-field col s3">
                                    <label for="last_name" class="indigo-text text-darken-4" >Parte</label> 
                                </div>
                                <div class="input-field col s3">
                                    <label for="last_name" class="indigo-text text-darken-4" >Anomalia</label> 
                                </div>
                                <div class="input-field col s3">
                                    <label for="last_name" class="indigo-text text-darken-4" >Causa</label> 
                                </div>
                                <div class="input-field col s3">
                                    <label for="last_name" class="indigo-text text-darken-4" >Posible solucion</label> 
                                </div>
                            </div>
                            <div class="row anomaliaparte">
                                <div class="input-field col s3">
                                    <input id="last_name" type="text" class="validate parte" >
                                </div>
                                <div class="input-field col s3">
                                    <input type="text" class="validate anomalia">
                                </div>
                                <div class="input-field col s3">
                                    <input type="text" class="validate causa">
                                </div>
                                <div class="input-field col s3">
                                    <input id="last_name" type="text" class="validate solucion" value="" >
                                </div>
                            </div>

                        </div>
                        <div class="input-field  right">
                            <a class="waves-effect btn left-align addanomalia" >Agregar</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " ng-model="ot.solicitada">
                                <label for="last_name" class="indigo-text text-darken-4" >Solicitada por</label> 
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate "ng-model="ot.revisada" >
                                <label for="last_name" class="indigo-text text-darken-4" >Revisada por</label> 
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate " ng-model="ot.autorizada">
                                <label for="last_name" class="indigo-text text-darken-4" >Autorizada por</label> 
                            </div>

                        </div>
                    </div>
                </div>
                <!--aqui tabla-->
                <div class="row" >
                    <div class="col s10 offset-s1" >
                        <div class="col s12 tablatrabajos" style="border: 1px solid #0059bc">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="last_name" class="indigo-text text-darken-4" >Descripcion de los trabajos a realizar</label> 
                                </div>
                            </div>
                            <div class="row descripciontrabajo">
                                <div class="input-field col s12">
                                    <input id="last_name" type="text" class="validate trabajo" >
                                </div>
                            </div>
                        </div>
                        <div class="input-field  right">
                            <a class="waves-effect btn left-align addtrabajo" >Agregar</a>
                        </div>
                    </div>
                </div>
                <!--aqui tabla-->
                <div class="row" >
                    <div class="col s10 offset-s1" >
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Materiales</strong></legend>
                        <div class="col s12 tablamateriales" style="border: 1px solid #0059bc">
                            <div class="row">
                                <div class="input-field col s2">
                                    <label for="last_name" class="indigo-text text-darken-4" >Cantidad</label> 
                                </div>
                                <div class="input-field col s4">
                                    <label for="last_name" class="indigo-text text-darken-4" >Descripcion</label> 
                                </div>
                                <div class="input-field col s2">
                                    <label for="last_name" class="indigo-text text-darken-4" >Referencia</label> 
                                </div>
                                <div class="input-field col s2">
                                    <label for="last_name" class="indigo-text text-darken-4" >Valor unitario</label> 
                                </div>
                                <div class="input-field col s2">
                                    <label for="last_name" class="indigo-text text-darken-4" >Valor total</label> 
                                </div>
                            </div>
                            <div class="row materiales">
                                <div class="input-field col s2">
                                    <input id="last_name" type="number" class="validate cantidad" >
                                </div>
                                <div class="input-field col s4">
                                    <input type="text" class="validate descripcion">
                                </div>
                                <div class="input-field col s2">
                                    <input type="text" class="validate referencia">
                                </div>
                                <div class="input-field col s2">
                                    <input id="last_name" type="number" class="validate vunitario" >
                                </div>
                                <div class="input-field col s2">
                                    <input id="last_name" type="number" class="validate vtotal" readonly="">
                                </div>
                            </div>

                        </div>
                        <div class="input-field  right">
                            <a class="waves-effect btn left-align addmaterial" >Agregar</a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Costos</strong></legend>
                        <div class="row">
                            <div class="input-field col s4">
                                <input id="last_name" type="number" class="validate manoobra" ng-model="ot.manoobra" ng-change="ot.sumar()" >
                                <label for="last_name" class="indigo-text text-darken-4" >Mano de obra</label> 
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate materialesvalor" ng-model="ot.materiales" placeholder="" >
                                <label for="last_name" class="indigo-text text-darken-4" >Materiales</label> 
                            </div>
                            <div class="input-field col s4">
                                <input id="last_name" type="text" class="validate valortotal" ng-model="ot.valortotal" placeholder="" readonly="" >
                                <label for="last_name" class="indigo-text text-darken-4" >Total</label> 
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Tiempo empleado</strong></legend>
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="number" class="horasMTO " ng-model="ot.horasmto">
                                <label for="last_name" class="indigo-text text-darken-4" >Total horas mantenimiento</label> 
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="number" class="horasParada" ng-model="ot.horasparada">
                                <label for="last_name" class="indigo-text text-darken-4 horasParada" >Total horas parada</label> 
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Descripcion de daños encontrados</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ot.danos"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Descripcion de los trabajos realizados</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ot.trabajosrealizados"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s10 offset-s1">
                        <legend><strong  class="indigo-text text-darken-4" style="font-size: 20px">Observaciones y recomendaciones</strong></legend>
                        <textarea id="textarea1" class="materialize-textarea" length="120" ng-model="ot.observaciones"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col s10 offset-s1">
                        <div class="row">
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" ng-model="ot.ejecuto">
                                <label for="last_name" class="indigo-text text-darken-4" >Ejecuto</label> 
                            </div>
                            <div class="input-field col s6">
                                <input id="last_name" type="text" class="validate" ng-model="ot.recibio">
                                <label for="last_name" class="indigo-text text-darken-4" >Recibio y aprobo</label> 
                            </div>

                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s4 right">
                        <a class="waves-effect red darken-2 btn left-align" ng-click="ot.cancelar()">Cancelar</a>
                        <a class="waves-effect  green  btn left-align" ng-click="ot.guardar()">Guardar</a>
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

        <script type="text/template" id="filaanomalia">
            <div class="row anomaliaparte">
            <div class="input-field col s3">
            <input id="last_name" type="text" class="validate parte" >
            </div>
            <div class="input-field col s3">
            <input type="text" class="validate anomalia">
            </div>
            <div class="input-field col s3">
            <input type="text" class="validate causa">
            </div>
            <div class="input-field col s3">
            <input id="last_name" type="text" class="validate solucion" value="" >
            </div>
            </div>
        </script>
        <script type="text/template" id="filamaterial">
            <div class="row materiales">
            <div class="input-field col s2">
            <input id="last_name" type="number" class="validate cantidad" value="0">
            </div>
            <div class="input-field col s4">
            <input type="text" class="validate descripcion">
            </div>
            <div class="input-field col s2">
            <input type="text" class="validate referencia">
            </div>
            <div class="input-field col s2">
            <input id="last_name" type="number" class="validate vunitario"value="0" >
            </div>
            <div class="input-field col s2">
            <input id="last_name" type="number" class="validate vtotal" readonly=""value="0">
             </div>
            </div>
        </script>
        <script type="text/template" id="filatrabajo">
            <div class="row descripciontrabajo">
            <div class="input-field col s12">
            <input id="last_name" type="text" class="validate trabajo" >
            </div>
            </div>
        </script>
        <script src="js/jquery.min.js"></script>
        <script src="js/materialize.min.js"></script>
        <script src="js/angular.min.js"></script>
        <script src="js/index.js"></script>
        <script src="js/jasny-bootstrap.min.js"></script>
        <script src="js/underscore.js"></script>
         <script src="js/sweetalert.min.js"></script>
        <script>
                            var app = {
                                _plantillaAnomalia: _.template($('#filaanomalia').html().replace(/\n/gi, "")),
                                _plantillaMateriales: _.template($('#filamaterial').html().replace(/\n/gi, "")),
                                _plantillaTrabajo: _.template($('#filatrabajo').html().replace(/\n/gi, "")),
                                init: function () {
                                    $('select').material_select();
                                    $(".manoobra").val("0");
                                    $(".materialesvalor").val("0");
                                    $(".valortotal").val("0");
                                    $(".horasParada").val("0");
                                    $(".horasMTO").val("0");
                                    $(".cantidad").val("0");
                                    $(".vtotal").val("0");
                                    $(".vunitario").val("0");
                                    $(".addanomalia").off('click').on('click', function () {
                                        $(app._plantillaAnomalia()).appendTo(".tablaanomalia");
                                    });
                                    $(".addmaterial").off('click').on('click', function () {
                                        $(app._plantillaMateriales()).appendTo(".tablamateriales");
                                        app.evento();
                                    });
                                    $(".addtrabajo").off('click').on('click', function () {
                                        $(app._plantillaTrabajo()).appendTo(".tablatrabajos");
                                    });
//                                            var materiales = [];
//                                            $('.anomaliaparte').each(function (indice, elemento) {
//                                                var parte = $(elemento).find(".parte").val();
//                                                var anomalia = $(elemento).find(".anomalia").val();
//                                                var causa = $(elemento).find(".causa").val();
//                                                var solucion = $(elemento).find(".solucion").val();
//                                                var obj = {};
//                                                obj.parte = parte;
//                                                obj.anomalia = anomalia;
//                                                obj.causa = causa;
//                                                obj.solucion = solucion;
//                                                materiales.push(obj);
//                                            });
                                    $(".vunitario, .cantidad").on('change', function () {
                                        var cantidad = $(this).parents(".materiales").find(".cantidad").val();
                                        var unitario = $(this).parents(".materiales").find(".vunitario").val();
                                        $(this).parents(".materiales").find(".vtotal").val(parseFloat(cantidad) * unitario);
                                        var vtotal = 0;
                                        $('.materiales').each(function (indice, elemento) {
                                            var total = $(elemento).find(".vtotal").val();
                                            vtotal += parseFloat(total);
                                        });
                                        $(".materialesvalor").val(vtotal);
                                        $(".valortotal").val(parseFloat($(".materialesvalor").val()) + parseFloat($(".manoobra").val()));
                                    });
                                    
                                    $('.datepicker').pickadate({
                                        format: "yyyy-mm-dd"
                                    });
                                    $("#fileUpload").on('change', function () {
                                        var inputFileImage = document.getElementById("fileUpload");
                                        var file = inputFileImage.files[0];
                                        var data = new FormData();
                                        data.append('Archivo', file);
                                        var countFiles = $(this)[0].files.length;
                                        var imgPath = $(this)[0].value;
                                        var reader = new FileReader();
                                        reader.onload = function (e) {
                                            $('#image_upload_preview').attr('src', e.target.result);
                                        };
                                        reader.readAsDataURL(this.files[0]);
                                    });
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
                                },
                                evento: function () {
                                  $(".vunitario, .cantidad").on('change', function () {
                                        var cantidad = $(this).parents(".materiales").find(".cantidad").val();
                                        var unitario = $(this).parents(".materiales").find(".vunitario").val();
                                        $(this).parents(".materiales").find(".vtotal").val(parseFloat(cantidad) * unitario);
                                        var vtotal = 0;
                                        $('.materiales').each(function (indice, elemento) {
                                            var total = $(elemento).find(".vtotal").val();
                                            vtotal += parseFloat(total);
                                        });
                                        $(".materialesvalor").val(vtotal);
                                        $(".valortotal").val(parseFloat($(".materialesvalor").val()) + parseFloat($(".manoobra").val()));
                                    });
                                }
                            };
                            $(document).ready(function () {
                                app.init();
                            });
        </script>
    </body>
</html>
