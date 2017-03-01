var app = angular.module('penagosApp', []);
app.controller('penagosAppCtrl', ['$http', controladorPrincipal]);
app.controller('penagosListaAppCtrl', ['$http', controladorLista]);
app.controller('penagosFichaAppCtrl', ['$http', controladorFichaTecnica]);
app.controller('penagosFichaEdtiAppCtrl', ['$http', controladorFichaTecnicaEditar]);
app.controller('penagosSolicitudesAppCtrl', ['$http', controladorSolicitudesEditar]);
app.controller('penagosSolicitudAppCtrl', ['$http', controladorSolicitud]);

function controladorLista($http) {
    var ma = this;
    var params = {
        proceso: "listar"
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        ma.Maquinas = res.data.Maquinas;
    });
    ma.nuevaMaquina = function () {
        window.location = "FichaTecnica.jsp";
    };
    ma.eliminar = function (id) {
        var params = {
            proceso: "eliminar",
            id: id
        };
        swal({
            title: "Esta seguro?",
            text: "Se eliminara todo los registros asociados",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Si, eliminar!",
            cancelButtonText: "No, cancelar!",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        $http({
                            method: 'POST',
                            url: 'Peticiones.jsp',
                            params: params
                        }).then(function (res, textStatus, jqXHR) {
                            if (res.data.ok === true) {
                                if (res.data[params.proceso] === true) {
                                    swal("Eliminado!", "Se ha eliminado el registro", "success", function () {
                                        window.location.reload();
                                    });
                                } else {
                                    swal("Error", "No se ha eliminado, consulte con su administrador", "error");
                                }
                            } else {
                                swal(res.data.errorMsg);
                            }
                            ;
                        });
                    } else {
                        swal("Cancelado", "", "error");
                    }
                });

    };
}
;
function controladorFichaTecnicaEditar($http) {
    var fte = this;
    var params = {
        proceso: "vereditar",
        id: $("#identificador").val()
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        var Equipo = res.data.Equipo;
        fte.nombre = Equipo.nombre;
        fte.codigo = Equipo.codigo;
        fte.tipo = Equipo.tipoEquipo;
        fte.seccion = Equipo.ubicacion;
        fte.estado = Equipo.estado;
        fte.marca = Equipo.marca;
        fte.modelo = Equipo.modelo;
        fte.serie = Equipo.serie;
        fte.operario = Equipo.operario;
        fte.tipoCF = Equipo.tipoPotencia;
        fte.potencia = Equipo.potencia;
        fte.control = Equipo.control;
        fte.alimentacion = Equipo.alimentacion;
        fte.frecuencia = Equipo.frecuencia;
        fte.largo = Equipo.largo;
        fte.alto = Equipo.altura;
        fte.ancho = Equipo.ancho;
        fte.peso = Equipo.peso;
        fte.horasuso = Equipo.horasDeUso;
        fte.tiempofuncionamiento = Equipo.tiempoDeFuncionamiento;
        fte.pintura = Equipo.estadoPintura;
        fte.corrosivo = Equipo.ambienteCorrosivo;
        fte.cespecificas = Equipo.caracteristicasEspecificas;
        fte.funciones = Equipo.funciones;
        fte.observaciones = Equipo.observaciones;
    });
    fte.guardar = function () {
        var equipo = {
            id: $("#identificador").val(),
            proceso: "editar",
            nombre: fte.nombre,
            codigo: fte.codigo,
            tipo: fte.tipo,
            seccion: fte.seccion,
            estado: fte.estado,
            marca: fte.marca,
            ubicacion: fte.seccion,
            modelo: fte.modelo,
            serie: fte.serie,
            operario: fte.operario,
            imagen: $('.fileinput').find('img').attr('src'),
            tipoCF: fte.tipoCF,
            potencia: fte.potencia,
            control: fte.control,
            alimentacion: fte.alimentacion,
            frecuencia: fte.frecuencia,
            largo: fte.largo,
            alto: fte.alto,
            ancho: fte.ancho,
            peso: fte.peso,
            horasuso: fte.horasuso,
            tiempofuncionamiento: fte.tiempofuncionamiento,
            pintura: fte.pintura,
            corrosivo: fte.corrosivo,
            cespecificas: fte.cespecificas,
            funciones: fte.funciones,
            observaciones: fte.observaciones
        };

        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: equipo
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[equipo.proceso] === true) {
                    window.location = "Maquinas.jsp";
                } else {
                    alert("Por favor vefifique sus datos");
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
    fte.salir = function () {
        window.location = "Maquinas.jsp";
    };
}
;
function controladorFichaTecnica($http) {
    var ft = this;
    ft.guardar = function () {
        var equipo = {
            proceso: "guardar",
            nombre: ft.nombre,
            codigo: ft.codigo,
            tipo: ft.tipo,
            seccion: ft.seccion,
            estado: ft.estado,
            marca: ft.marca,
            ubicacion: ft.seccion,
            modelo: ft.modelo,
            serie: ft.serie,
            operario: ft.operario,
            imagen: $('.fileinput').find('img').attr('src'),
            tipoCF: ft.tipoCF,
            potencia: ft.potencia,
            control: ft.control,
            alimentacion: ft.alimentacion,
            frecuencia: ft.frecuencia,
            largo: ft.largo,
            alto: ft.alto,
            ancho: ft.ancho,
            peso: ft.peso,
            horasuso: ft.horasuso,
            tiempofuncionamiento: ft.tiempofuncionamiento,
            pintura: ft.pintura,
            corrosivo: ft.corrosivo,
            cespecificas: ft.cespecificas,
            funciones: ft.funciones,
            observaciones: ft.observaciones
        };

        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: equipo
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[equipo.proceso] === true) {
                    window.location = "Maquinas.jsp";
                } else {
                    alert("Por favor vefifique sus datos");
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
    ft.salir = function () {
        window.location = "Maquinas.jsp";
    };
}
;
function controladorPrincipal($http) {
    var vm = this;

    vm.login = function () {
        var c = {
            proceso: "login",
            usr: vm.username,
            pass: vm.password
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: c
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[c.proceso] === true) {
                    window.location.reload();
                } else {
                    alert("Por favor vefifique sus datos");
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
    vm.salir = function () {
        var c1 = {
            proceso: "logout"
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: c1
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[c1.proceso] === true) {
                    window.location.reload();
                } else {
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
    vm.eliminar = function (index) {
        var contac = vm.Contactos[index];
        var data = {
            proceso: "eliminar",
            id: contac.identificacion
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: data
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[data.proceso] === true) {
                    vm.Contactos.splice(index, 1);
                    alert("Se elimino");
                } else {
                    alert("No se pudo guardar");
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
    vm.archivo = function () {
        var inputFileImage = document.getElementById("fileUpload");
        var file = inputFileImage.files[0];
        var data = new FormData();
        data.append('Archivo', file);
        var data = {
            proceso: "archivo",
            file: file
        };
        $http({
            method: 'POST',
            url: 'Peticiones1.jsp',
            contentType: 'multipart/form-data',
            params: data
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[data.proceso] === true) {
                    alert("Se elimino");
                } else {
                    alert("No se pudo guardar");
                }
            } else {
                alert(res.data.errorMsg);
            }
        });
    };
}
;
function controladorSolicitudesEditar($http) {
    var sm = this;
    var params = {
        proceso: "listarsolicitud"
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        sm.Solicitudes = res.data.Solicitudes;
    });
    sm.nuevaSolicitud = function () {
        window.location = "Solicitud.jsp";
    };
//    sm.eliminar = function (id) {
//        var params = {
//            proceso: "eliminar",
//            id: id
//        };
//        swal({
//            title: "Esta seguro?",
//            text: "Se eliminara todo los registros asociados",
//            type: "warning",
//            showCancelButton: true,
//            confirmButtonColor: "#DD6B55",
//            confirmButtonText: "Si, eliminar!",
//            cancelButtonText: "No, cancelar!",
//            closeOnConfirm: false,
//            closeOnCancel: false
//        },
//                function (isConfirm) {
//                    if (isConfirm) {
//                        $http({
//                            method: 'POST',
//                            url: 'Peticiones.jsp',
//                            params: params
//                        }).then(function (res, textStatus, jqXHR) {
//                            if (res.data.ok === true) {
//                                if (res.data[params.proceso] === true) {
//                                    swal("Eliminado!", "Se ha eliminado el registro", "success", function () {
//                                        window.location.reload();
//                                    });
//                                } else {
//                                    swal("Error", "No se ha eliminado, consulte con su administrador", "error");
//                                }
//                            } else {
//                                swal(res.data.errorMsg);
//                            }
//                            ;
//                        });
//                    } else {
//                        swal("Cancelado", "", "error");
//                    }
//                });
//
//    };
}
;
function controladorSolicitud($http){
    
};

