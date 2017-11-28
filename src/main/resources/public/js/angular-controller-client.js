app.controller("Hello", function ($scope, $http) {

    $scope.addNewClient = function () {
        $http.post('../client/add', {name: $scope.name, country: $scope.country}).
                then(function (data) {

                    var id = $scope.clients.length + 1;

                    $scope.clients.push({
                        id: id,
                        name: $scope.name,
                        country: $scope.country
                    });

                    console.log(data);
                }, function (error) {
                    console.log(error);
                });

        $scope.$apply();
    };

    $scope.update = function () {

        $http.get('../client/all').
                then(function (data) {
                    $scope.clients = data.data;
                }, function (error) {
                    console.log(error);
                });

    };
});
