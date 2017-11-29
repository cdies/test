app.controller("ClientShowAll", function ($scope, showAll) {

    showAll.async('../client/all').then(function (data) {
        $scope.clients = data;
    });

});