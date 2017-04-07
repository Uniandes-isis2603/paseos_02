//IMPORTANTE: con el codigo comentado ya esta la conexion con el back, se deja el codigo que funciona con JSON para  
//ver la aplicacion funcionando en su totalidad

/*(function (ng) {
    var mod = ng.module("actividadModule", ['ui.router']);
    
    mod.constant("actividadesContext", "/actividades");
    mod.constant("paseosContext", "api/paseos");
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/actividades/';
        $urlRouterProvider.otherwise("/actividadesList");

            $stateProvider
               .state('actividades', {
                    url: '/actividades',
                    abstract: true,
                    parent: 'paseoDetail',
                    views: {
                        childrenView: {                       
                            resolve: {
                                paseos: ['$http', 'paseosContext', function ($http,paseosContext) {
                                        return $http.get( paseosContext );
                                    }],
                                actividades: ['$scope','$http', 'paseosContext','actividadesContext', function($scope,$http,paseosContext,actividadesContext){
                                        $scope.currentPaseo = paseos.data[$params.paseoId - 1];        
                                        return $http.get(paseosContext + '/'+ $scope.currentPaseo.id + actividadesContext);
                                    }]
                            },
                        templateUrl: basePath + 'actividades.html',
                        controller: ['$scope', 'paseos', 'actividades', '$stateParams', function ($scope, paseos, actividades, $params) {
                                $scope.actividadesRecords = actividades.data;
                            }]
                    }
                }

            })
                    .state('actividadesList', {
                url: '/list',
                parent: 'actividades',
                views: {
                    'listView': {
                        templateUrl: basePath + 'actividades.list.html'
                    }
                }
            })
                    .state('actividadDetail',{
                url: '/{actividadId:int}/detail',
                parent: 'actividades',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'actividades.detail.html',
                        controller: ['$scope', '$stateParams', function($scope, $stateParams) { $scope.currentActividad = $scope.actividadesRecords[$stateParams.actividadId-1]}]
                    }
                }});
                    
        }]);
})(window.angular);
*/


 //El siguiente codigo es el que funciona con los JSON
(function (ng) {
    var mod = ng.module("actividadModule", ['ui.router']);

    //mod.constant("paseosContext", "api/paseos");
    //mod.constant("actividadesContext", "actividades");

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/actividades/';
            $urlRouterProvider.otherwise("/actividadesList");

            $stateProvider
                    .state('actividades', {
                        url: '/actividades',
                        abstract: true,
                        parent: 'paseoDetail',
                        views: {
                            childrenView: {
                                resolve: {
                                    paseos: ['$http', function ($http) {
                                            return $http.get('data/paseos.json');
                                        }],
                                    actividades: ['$http', function ($http) {
                                            return $http.get('data/actividades.json');
                                        }]
                                },
                                templateUrl: basePath + 'actividades.html',
                                controller: ['$scope', 'paseos', 'actividades', '$stateParams', function ($scope, paseos, actividades, $params) {
                                        $scope.currentPaseo = paseos.data[$params.paseoId - 1];
                                        $scope.actividadesRecords = actividades.data;
                                    }]
                            }
                        }
                    })
                    .state('actividadesList', {
                        url: '/list',
                        parent: 'actividades',
                        views: {
                            'listView': {
                                templateUrl: basePath + 'actividades.list.html'
                            }
                        }
                    })
                    .state('actividadDetail', {
                        url: '/{actividadId:int}/detail',
                        parent: 'actividades',
                        views: {
                            'listView': {
                                templateUrl: basePath + 'actividades.list.html'
                            },
                            'detailView': {
                                templateUrl: basePath + 'actividades.detail.html',
                                controller: ['$scope', '$stateParams', function ($scope, $stateParams) {
                                        $scope.currentActividad = $scope.actividadesRecords[$stateParams.actividadId - 1];
                                    }]
                            }
                        }});

        }]);
})(window.angular);
