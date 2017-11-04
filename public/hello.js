angular.module("myApp", [])
        .controller("Hello", function ($scope, $http) {

            var isUpdated = false;

            $scope.addNewClient = function () {
                $http.post('../add', {client: $scope.client, city: $scope.city}).
                        then(function (data) {

                            if (!isUpdated) {
                                $scope.update();
                            } else {

                                var id = $scope.clients.length + 1;

                                $scope.clients.push({
                                    id: id,
                                    client: $scope.client,
                                    city: $scope.city
                                });
                            }

                            console.log(data);
                        }, function (error) {
                            console.log(error);
                        });

                $scope.$apply();
            };

            $scope.update = function () {

                if (!isUpdated) {
                    $http.get('../all').
                            then(function (data) {
                                $scope.clients = data.data;
                            }, function (error) {
                                console.log(error);
                            });
                }
                isUpdated = true;
            };
        });



