
var app = angular.module('penagosApp', []);
app.controller('penagosAppCtrl', ['$http', controladorPrincipal]);
app.controller('penagosListaAppCtrl', ['$http', controladorLista]);
app.controller('penagosFichaAppCtrl', ['$http', controladorFichaTecnica]);
app.controller('penagosFichaEdtiAppCtrl', ['$http', controladorFichaTecnicaEditar]);
app.controller('penagosSolicitudesAppCtrl', ['$http', controladorSolicitudesEditar]);
app.controller('penagosSolicitudAppCtrl', ['$http', controladorSolicitud]);
app.controller('penagosOTAppCtrl', ['$http', controladorOT]);
app.controller('penagosListOTAppCtrl', ['$http', controladorListOT]);
app.controller('penagosProvAppCtrl', ['$http', controladorProv]);
app.controller('penagosHerrAppCtrl', ['$http', controladorHerr]);

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
    sm.PDF = function (ids, ide) {
        var params = {
            proceso: "generarpdfsolicitud",
            id: ids,
            idequipo: ide
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[params.proceso] === true) {
                    swal("Pdf", "Generado con exito", "success");
                } else {
                    swal("Pdf", "Ha ocurrido un error, consulte con el administrador", "error");
                }
            } else {
                swal(res.data.errorMsg);
            }
        });
    };

}
;
function controladorSolicitud($http) {
    var st = this;
    var id;
    st.equipo = function () {
        var datos = st.equipos;
        datos = datos.split("//");
        st.operario = datos[2];
        st.seccion = datos[1];
        id = datos[0];
    };
    st.guardar = function () {
        if (st.mtocorrectivo === undefined) {
            st.mtocorrectivo = false;
        }
        if (st.reparacion === undefined) {
            st.reparacion = false;
        }
        if (st.mtoelectrico === undefined) {
            st.mtoelectrico = false;
        }
        if (st.mtomecanico === undefined) {
            st.mtomecanico = false;
        }
        if (st.mtopreventivo === undefined) {
            st.mtopreventivo = false;
        }
        if (st.otros === undefined) {
            st.otros = false;
        }
        var solicitud = {
            proceso: "guardasolicitud",
            codigo: st.codigo,
            revision: st.revision,
            solicitud: st.solicitud,
            fecha: st.fecha,
            idequipo: id,
            reparacion: st.reparacion,
            electrico: st.mtoelectrico,
            mecanico: st.mtomecanico,
            correctivo: st.mtocorrectivo,
            preventivo: st.mtopreventivo,
            otros: st.otros,
            servicio: st.servicio,
            acciones: st.acciones,
            material: st.material,
            horasparada: st.horasparada,
            horasmto: st.horasmto,
            horasolicitud: st.horasolicitud,
            horaentrega: st.horaentrega,
            solicitado: st.solicitado,
            realizado: st.realizado,
            recibido: st.recibido
        };
        if (st.fecha !== undefined) {
            if (id !== undefined) {
                $http({
                    method: 'POST',
                    url: 'Peticiones.jsp',
                    params: solicitud
                }).then(function (res, textStatus, jqXHR) {
                    if (res.data.ok === true) {
                        if (res.data[solicitud.proceso] === true) {
                            window.location = "SolicitudesMto.jsp";
                        } else {
                            alert("Por favor vefifique sus datos");
                        }
                    } else {
                        alert(res.data.errorMsg);
                    }
                });
            } else {
                swal("Error", "Debe selecionar un equipo", "error");
            }
        } else {
            swal("Error", "Debe selecionar una fecha", "error");
        }

    };
    st.cancelar = function () {
        window.location = "SolicitudesMto.jsp";
    };
}
;
function controladorOT($http) {
    var ot = this;

    ot.guardar = function () {
        var anomalialist = [];
        $('.anomaliaparte').each(function (indice, elemento) {
            var parte = $(elemento).find(".parte").val();
            var anomalia = $(elemento).find(".anomalia").val();
            var causa = $(elemento).find(".causa").val();
            var solucion = $(elemento).find(".solucion").val();
            if (parte !== "" && anomalia !== "" && causa !== "" && solucion !== "") {
                var obj = {};
                obj.parte = parte;
                obj.anomalia = anomalia;
                obj.causa = causa;
                obj.solucion = solucion;
                anomalialist.push(obj);
            }
        });
        var materiales = [];
        $('.materiales').each(function (indice, elemento) {
            var cantidad = $(elemento).find(".cantidad").val();
            var descripcion = $(elemento).find(".descripcion").val();
            var referencia = $(elemento).find(".referencia").val();
            var unitario = $(elemento).find(".vunitario").val();
            var total = $(elemento).find(".vtotal").val();
            if (cantidad !== "" && descripcion !== "" && unitario !== "" && total !== "") {
                var obj = {};
                obj.cantidad = cantidad;
                obj.descripcion = descripcion;
                obj.referencia = referencia;
                obj.unitario = unitario;
                obj.total = total;
                materiales.push(obj);
            }
        });
        var trabajos = [];
        $('.descripciontrabajo').each(function (indice, elemento) {
            var trabajo = $(elemento).find(".trabajo").val();
            if (trabajo !== "") {
                var obj = {};
                obj.trabajo = trabajo;
                trabajos.push(obj);
            }
        });
        if (ot.tiposolicitud === null) {
            ot.tiposolicitud = "Normal";
        }
        ;
        if (ot.generasolicitud === undefined) {
            ot.generasolicitud = "false";
        }
        ;

        var odt = {
            proceso: "guardarot",
            ordendetrabajo: ot.ordentrabajo,
            fechainicio: ot.fechainicio,
            fechafin: ot.fechafin,
            tiposolicitud: ot.tiposolicitud,
            generasolicitud: ot.generasolicitud,
            solicitud: $(".codigosolicitud").val(),
            idequipo: $(".idequipo").val(),
            anomaliaparte: JSON.stringify(anomalialist),
            solicitada: ot.solicitada,
            revisada: ot.revisada,
            autorizada: ot.autorizada,
            trabajos: JSON.stringify(trabajos),
            materiales: JSON.stringify(materiales),
            cmanoobra: $(".manoobra").val(),
            cmateriales: $(".materialesvalor").val(),
            horasmto: $(".horasMTO").val(),
            horasparada: $(".horasParada").val(),
            daños: ot.danos,
            trabajosrealizados: ot.trabajosrealizados,
            observaciones: ot.observaciones,
            ejecuto: ot.ejecuto,
            recibio: ot.recibio
        };
        if (ot.fechafin === undefined || ot.fechainicio === undefined) {
            swal("Error", "Debe seleccionar fecha inicio y fecha fin", "error");
        } else {
            $http({
                method: 'POST',
                url: 'Peticiones.jsp',
                params: odt
            }).then(function (res, textStatus, jqXHR) {
                if (res.data.ok === true) {
                    if (res.data[odt.proceso] === true) {
                        window.location = "SolicitudesMto.jsp";
                    } else {
                        alert("Por favor vefifique sus datos");
                    }
                } else {
                    alert(res.data.errorMsg);
                }
            });
        }
    };
    ot.sumar = function () {
        var valor = $(".materialesvalor").val();
        ot.valortotal = parseFloat(valor) + parseFloat(ot.manoobra);
    };
    ot.cancelar = function () {
        window.location = "SolicitudesMto.jsp";
    };
}
;
function controladorListOT($http) {
    var lot = this;
    var params = {
        proceso: "listarordenes"
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        lot.Ordenes = res.data.Ordenes;
    });
    lot.generarPdf = function (ids, ide) {
        var params = {
            proceso: "generarpdfot",
            id: ids,
            idequipo: ide
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[params.proceso] === true) {
                    swal("Pdf", "Generado con exito", "success");
                } else {
                    swal("Pdf", "Ha ocurrido un error, consulte con el administrador", "error");
                }
            } else {
                swal(res.data.errorMsg);
            }
        });
    };

}
;
function controladorProv($http) {
    var p = this;
    var params = {
        proceso: "listarproveedores"
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        p.Proveedores = res.data.Proveedores;
    });
    p.nuevo = function () {
        window.location = "Proveedor.jsp";
    };
    p.guardar = function () {
        var params = {
            proceso: "guardaproveedor",
            nombre: p.nombre,
            direccion: p.direccion,
            telefono: p.telefono,
            correo: p.correo
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[params.proceso] === true) {
                    swal({
                        title: "Proveedor",
                        text: "Guardado con exito",
                        type: "success",
                        confirmButtonColor: "#8CD4F5",
                        confirmButtonText: "OK",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                            function (isConfirm) {
                                if (isConfirm) {
                                    window.location = "ListaProveedores.jsp";
                                }
                            });
                } else {
                    swal("Proveedor", "Ha ocurrido un error, consulte con el administrador", "error");
                }
            } else {
                swal(res.data.errorMsg);
            }
        });
    };
    p.eliminar = function (id) {
        var params = {
            proceso: "eliminarproveedor",
            id: id
        };
        swal({
            title: "Esta seguro?",
            text: "Se eliminara este proveedor",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Si, eliminar!",
            cancelButtonText: "No, cancelar!",
            closeOnConfirm: false,
            closeOnCancel: true
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
                                    swal({
                                        title: "Proveedor",
                                        text: "Eliminado con exito",
                                        type: "success",
                                        confirmButtonColor: "#8CD4F5",
                                        confirmButtonText: "OK",
                                        closeOnConfirm: false,
                                        closeOnCancel: false
                                    },
                                            function (isConfirm) {
                                                if (isConfirm) {
                                                    window.location.reload();
                                                }
                                            });
                                } else {
                                    swal("Error", "No se ha eliminado, consulte con su administrador", "error");
                                }
                            } else {
                                swal(res.data.errorMsg);
                            }
                            ;
                        });
                    } 
                });
    };
}
;
function controladorHerr($http) {
    var h = this;
    var params = {
        proceso: "listarherramientas"
    };
    $http({
        method: 'POST',
        url: 'Peticiones.jsp',
        params: params
    }).then(function (res, textStatus, jqXHR) {
        h.Herramientas = res.data.Herramientas;
    });
    h.nuevo = function () {
        window.location = "Herramienta.jsp";
    };
    h.guardar = function () {
        var params = {
            proceso: "guardaherramineta",
            nombre: h.nombre,
            direccion: h.direccion,
            codigo: h.codigo,
            cantidad: h.cantidad
        };
        $http({
            method: 'POST',
            url: 'Peticiones.jsp',
            params: params
        }).then(function (res, textStatus, jqXHR) {
            if (res.data.ok === true) {
                if (res.data[params.proceso] === true) {
                    swal({
                        title: "Herramienta",
                        text: "Guardada con exito",
                        type: "success",
                        confirmButtonColor: "#8CD4F5",
                        confirmButtonText: "OK",
                        closeOnConfirm: false,
                        closeOnCancel: false
                    },
                            function (isConfirm) {
                                if (isConfirm) {
                                    window.location = "ListaHerramientas.jsp";
                                }
                            });
                } else {
                    swal("Proveedor", "Ha ocurrido un error, consulte con el administrador", "error");
                }
            } else {
                swal(res.data.errorMsg);
            }
        });
    };
    h.eliminar = function (id) {
        var params = {
            proceso: "eliminarherramienta",
            id: id
        };
        swal({
            title: "Esta seguro?",
            text: "Se eliminara esta herramienta",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Si, eliminar!",
            cancelButtonText: "No, cancelar!",
            closeOnConfirm: false,
            closeOnCancel: true
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
                                    swal({
                                        title: "Herramienta",
                                        text: "Eliminada con exito",
                                        type: "success",
                                        confirmButtonColor: "#8CD4F5",
                                        confirmButtonText: "OK",
                                        closeOnConfirm: false,
                                        closeOnCancel: false
                                    },
                                            function (isConfirm) {
                                                if (isConfirm) {
                                                    window.location.reload();
                                                }
                                            });
                                } else {
                                    swal("Error", "No se ha eliminado, consulte con su administrador", "error");
                                }
                            } else {
                                swal(res.data.errorMsg);
                            }
                            ;
                        });
                    } 
                });
    };
}
;

