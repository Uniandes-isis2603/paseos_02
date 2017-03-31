(function (ng) {
    // Definición del módulo
    var mod = ng.module("caminanteModule", ['ui.router']);
 
   // Configuración de los estados del módulo
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            // En basePath se encuentran los templates y controladores de módulo
            var basePath = 'src/modules/caminantes/';
            // Mostrar la lista de caminantes será el estado por defecto del módulo
            $urlRouterProvider.otherwise("/caminantesList");
            // Definición del estado 'caminantesList' donde se listan los caminantes
            $stateProvider.state('caminantesList', {
                // Url que aparecerá en el browser
                url: '/caminantes/list',
                // Se define una variable books (del estado) que toma por valor 
                // la colección de libros que obtiene utilizando $http.get 
                 resolve: {
                    caminantes: ['$http', function ($http) {
                            return $http.get('data/caminantes.json'); // $http retorna una promesa que aquí no se está manejando si viene con error.
                        }]
                },
                // Template que se utilizara para ejecutar el estado
                templateUrl: basePath + 'caminantes.list.html',
                // El controlador guarda en el scope en la variable caminantesRecords los datos que trajo el resolve
                // caminantesRecords será visible en el template
                controller: ['$scope', 'caminantes', function ($scope, caminantes) {
                        $scope.caminantesRecords = caminantes.data;
                    }]              
            });
        }
    ]);
})(window.angular);
