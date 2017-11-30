app.controller("LoanShowAll", function ($scope, showAll) {

    showAll.async('../loan/all').then(function (data) {
        $scope.loans = data;
    });

});


app.controller("addLoan", function ($scope, $http, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = $scope.isBlacklistFilter(data);
    });

//TODO: check parametrs for correct values
    $scope.addNewLoan = function () {
        if (!!$scope.selectedClient) {
            $http.post('../loan/add', {userId: $scope.selectedClient.id, loan: $scope.loan, term: $scope.term}).
                    then(function (data) {
                        alert(data.data.text);
                    }, function (error) {
                        alert(error.data.message);
                        console.log(error);
                    });
        } else {
            alert("choose client!");
        }
    };

    $scope.isBlacklistFilter = function (clients) {
        var result = [];
        angular.forEach(clients, function (client, key) {

            if (client.isBlacklist === true || client.country.isBlacklist === true) {
                return;
            }
            result.push(client);
        });
        return result;
    };

});
