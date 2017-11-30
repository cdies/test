app.controller("ClientShowAll", function ($scope, $http, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = data;

    });

    $scope.showLoans = function () {

        if (!!$scope.selectedClient) {
            $http.post('../client/loan', $scope.selectedClient.id).
                    then(function (data) {
                        $scope.loans = data.data;
                    }, function (error) {
                        alert(error.data.message);
                        console.log(error);
                    });
        } else {
            alert("Choose user!");
        }
    };

    $scope.isBlacklistFilter = function (clients) {
        var result = [];
        angular.forEach(clients, function (client, key) {

            if (client.isBlacklist === true) {
                return;
            }
            result.push(client);
        });
        return result;
    };

    $scope.addBlacklist = function () {

        if (!!$scope.selectedClient) {
            $http.post('../client/add_blacklist', $scope.selectedClient.id).
                    then(function (data) {
                        alert(data.data.text);
                    }, function (error) {
                        alert(error.data.message);
                        console.log(error);
                    });
        } else {
            alert("Choose user!");
        }
    };

});


app.controller("addClient", function ($scope, $http, showAll) {

    showAll.async('../country/all').then(function (data) {
        $scope.countries = data;
    });
//TODO: Make sure all fiels is write correctly and not empty
    $scope.addNewClient = function () {
        if (!!$scope.selectedCountry) {
            $http.post('../client/add', {name: $scope.name, surname: $scope.surname, country: $scope.selectedCountry}).
                    then(function (data) {
                        alert(data.data.text);
                    }, function (error) {
                        alert(error.data.message);
                        console.log(error);
                    });
        } else {
            alert("Choose country!");
        }
    };
});
