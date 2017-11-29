app.controller("ClientShowAll", function ($scope, $http, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = data;
    });

    $scope.showLoans = function () {

        if ($scope.selectedClient !== null) {
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

});


app.controller("addClient", function ($scope, $http) {

    $scope.addNewClient = function () {
        $http.post('../client/add', {name: $scope.name, surname: $scope.surname, country: $scope.country}).
                then(function (data) {
                    alert(data.data.text);
                }, function (error) {
                    alert(error.data.message);
                    console.log(error);
                });
    };
});
