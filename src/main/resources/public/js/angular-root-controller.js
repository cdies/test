app.controller('topMenuController', function ($scope, $state) {

    $scope.menuItemClick = function (url) {
        if (url === '')
            console.log('Указан пустой url state');
        else
            $state.go(url);
    };
});

app.factory('showAll', function ($http) {

    var showAll = {
        async: function (path) {
            var promise = $http.get(path).then(function (data) {
                return data.data;
            }, function (error) {
                console.log(error);
            });
            return promise;
        }
    };
    return showAll;
});