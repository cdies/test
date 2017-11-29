var app = angular.module('app', ['ui.router']);

app.config(function ($stateProvider) {

    $stateProvider
            .state('default', {
                url: '',
                templateUrl: 'template/home.html',
                data: {pageTitle: 'HomePage'}
            })
            .state('loans', {
                url: 'loans',
                templateUrl: 'template/all-loans.html',
                data: {pageTitle: 'All loans'},
                controller: 'LoanShowAll'
            })
            .state('clients', {
                url: 'clients',
                templateUrl: 'template/all-clients.html',
                data: {pageTitle: 'All clients'},
                controller: 'ClientShowAll'
            })
            .state('addClient', {
                url: 'addClient',
                templateUrl: 'template/add-client.html',
                data: {pageTitle: 'Add client'},
                controller: 'addClient'
            });
});

app.run(['$rootScope', '$state', '$stateParams', function ($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }]);






