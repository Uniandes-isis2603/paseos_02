(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        //'ui.select',
        
        // Internal modules dependencies
        
        'caminanteModule',
        'guiaModule',
        'inscripcionModule',
        'calificacionModule',
        'lugaresModule',
        'actividadModule',
        'opinionesModule',
        'paseosModule'
    ]);
    // Resuelve problemas de las promesas. Presenta error al desplegar. No se incluye por ahora.
    //
    //app.config(['$qProvider', function ($qProvider) {
    //       $qProvider.errorOnUnhandledRejections(false);
     //   }]);
   
})(window.angular);
