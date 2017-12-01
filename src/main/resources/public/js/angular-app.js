var app = angular.module('app', ['ui.router']);

app.config(function ($stateProvider) {

    $stateProvider
            .state('default', {
                url: '',
                templateUrl: 'template/home.html',
                data: {pageTitle: 'HomePage'}
            })
            .state('about', {
                url: 'about',
                templateUrl: 'template/about.html',
                data: {pageTitle: 'About'}
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
            })
            .state('addLoan', {
                url: 'addLoan',
                templateUrl: 'template/add-loan.html',
                data: {pageTitle: 'Add loan'},
                controller: 'addLoan'
            })
            .state('loanByUser', {
                url: 'loanByUser',
                templateUrl: 'template/loan-by-user.html',
                data: {pageTitle: 'Show loan by user'},
                controller: 'ClientShowAll'
            })
            .state('addBlacklist', {
                url: 'addBlacklist',
                templateUrl: 'template/add-blacklist.html',
                data: {pageTitle: 'Add user to blacklist'},
                controller: 'ClientShowAll'
            })
            .state('country', {
                url: 'country',
                templateUrl: 'template/country.html',
                data: {pageTitle: 'Country stuff'},
                controller: 'country'
            });

});

app.run(['$rootScope', '$state', '$stateParams', function ($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }]);






