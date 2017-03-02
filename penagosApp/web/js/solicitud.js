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

}
;

function controladorSolicitud($http){
    
};


