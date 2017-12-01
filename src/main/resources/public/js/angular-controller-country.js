app.controller("country", function ($scope, $http, showAll) {

    showAll.async('../country/all').then(function (data) {
        $scope.countries = data;
    });

    $scope.addNewCountry = function () {
        if (!!$scope.countryName)
            $http.post('../country/add', $scope.countryName).
                    then(function (data) {
                        alert(data.data.text);
                    }, function (error) {
                        alert(error.data.message);
                        console.log(error);
                    });
    };

    $scope.BlaclistPerformance = function (selectedCountryItem) {

        $http.post('../country/blacklist', selectedCountryItem).
                then(function (data) {
                    alert(data.data.text);
                }, function (error) {
                    alert(error.data.message);
                    console.log(error);
                });

    };

    $scope.addBlacklist = function () {
        if (!!$scope.selectedCountry) {
            $scope.selectedCountry.isBlacklist = true;
            $scope.BlaclistPerformance($scope.selectedCountry);
        } else {
            alert("Choose country!");
        }
        ;
    };

    $scope.removeBlacklist = function () {
        if (!!$scope.selectedCountryRem) {
            $scope.selectedCountryRem.isBlacklist = false;
            $scope.BlaclistPerformance($scope.selectedCountryRem);
        } else {
            alert("Choose country!");
        }
        ;
    };

});


app.controller("countryLoanLimit", function ($scope, $http, showAll) {

    showAll.async('../country/all').then(function (data) {
        $scope.countries = data;
    });

//TODO: check value on correct or empty
    $scope.addLoanLimit = function () {

        $scope.selectedCountry.startTime = $scope.startTime.start + '-' + $scope.startTime.end;
        $scope.selectedCountry.endTime = $scope.endTime.start + '-' + $scope.endTime.end;
        $scope.selectedCountry.loanCount = $scope.loanCount;

        $http.post('../country/loanLimit', $scope.selectedCountry).
                then(function (data) {
                    alert(data.data.text);
                }, function (error) {
                    alert(error.data.message);
                    console.log(error);
                });
    };

});
