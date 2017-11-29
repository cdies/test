app.controller("LoanShowAll", function ($scope, showAll) {

    showAll.async('../loan/all').then(function (data) {
        $scope.loans = data;
    });

});


app.controller("addLoan", function ($scope, $http, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = $scope.isBlacklistFilter(data);
    });

//TODO: check value for correct
    $scope.addNewLoan = function () {
        $http.post('../loan/add', {userId: $scope.selectedClient.id, loan: $scope.loan, term: $scope.term}).
                then(function (data) {
                    alert(data.data.text);
                }, function (error) {
                    alert(error.data.message);
                    console.log(error);
                });
    };

    $scope.isBlacklistFilter = function (clients) {
        var result = [];
        angular.forEach(clients, function (client, key) {

            if (client.isBlacklist) {
                return;
            }
            result.push(client);
        });
        return result;
    };

});
