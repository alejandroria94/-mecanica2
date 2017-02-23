var app = angular.module('penagosApp', []);
app.controller('penagosAppCtrl', ['$http', controladorPrincipal]);
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
}
;

