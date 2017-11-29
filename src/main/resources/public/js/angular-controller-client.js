app.controller("ClientShowAll", function ($scope, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = data;
    });

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