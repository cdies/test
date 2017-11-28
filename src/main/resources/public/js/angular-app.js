var app = angular.module('app', ['ui.router']);

app.config(function ($stateProvider) {

    $stateProvider
            .state('default', {
                url: '',
                templateUrl: 'template/home.html',
                data: {pageTitle: 'HomePage'},
                controller: 'Hello'
            });
});

app.run(['$rootScope', '$state', '$stateParams', function ($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }]);






