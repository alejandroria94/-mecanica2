var app = angular.module('penagosApp', []);
//app.controller('penagosAppCtrl', ['$http', controladorMaquina]);
//function controladorMaquina($http) {
//    var vm = this;
//    vm.upload = function () {
//        var file = vm.file;
//        var inputFiles = $("#FileSubida").val();
//        vm.archivo = inputFiles;
//
//    };
//}
//;
app.controller('penagosFTAppCtrl', ['$http', controladorFichaTecnica]);
function controladorFichaTecnica($http) {
    var ft = this;
    ft.upload = function () {
       

    };
}
;

