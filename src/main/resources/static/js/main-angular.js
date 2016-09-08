// create angular app
var blueCloud = angular.module('blueCloud', ['ngRoute']);

// configure our routes
blueCloud.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'html/partial/projects/home.html'
        })
        .when('/projects-home', {
            templateUrl : 'html/partial/projects/home.html'
        })
        .when('/projects-view-project', {
            templateUrl : 'html/partial/projects/view-project.html'
        })
        .when('/projects-view-task', {
            templateUrl : 'html/partial/projects/view-task.html'
        })
        .when('/projects-create-project', {
            templateUrl : 'html/partial/projects/crud-project.html'
        })
        .when('/projects-update-project', {
            templateUrl : 'html/partial/projects/crud-project.html'
        })
        .when('/projects-create-task', {
            templateUrl : 'html/partial/projects/crud-task.html'
        })
        .when('/projects-update-task', {
            templateUrl : 'html/partial/projects/crud-task.html'
        })


        .when('/communicate-home', {
            templateUrl : 'html/partial/communicate/home.html'
        })
        .when('/dashboard-home', {
            templateUrl : 'html/partial/dashboard/home.html'
        })
        .when('/calendar-home', {
            templateUrl : 'html/partial/calendar/home.html'
        })
        .when('/people-home', {
            templateUrl : 'html/partial/people/home.html'
        })
        .when('/documents-home', {
            templateUrl : 'html/partial/documents/home.html'
        });

});

// create angular controller
blueCloud.controller('mainController', function($scope, $http, $location) {

    // initialize the form data fields
    $scope.formData = {};

    $http.get('http://localhost:8080/projects').success(function(data) {
        $scope.elements = data;
    });

    // create a new element
    $scope.createAction = function(element) {
        $scope.action = 'create';
        $scope.message = '';
        $scope.formData = {};
        $scope.element = element;
    };

    // this gives us the option to update or delete an element
    $scope.updateAction = function(element) {
        $scope.action = 'update';
        $scope.formData = element;
        $scope.message = '';
    };

    $scope.findAllElements = function(type) {
        $http.get('http://localhost:8080/'+ type).success(function(data) {
            $scope.elements = data;
        });
    };

    // finds an element using the type and an id
    $scope.findElement = function(type, id) {
        $http.get('http://localhost:8080/'+ type + '/' + id).success(function(data) {
            $scope.element = data;
        });
    };

    // creates an element using a type
    $scope.createElement = function(type) {
        var data = $scope.formData;
        $http.post('http://localhost:8080/'+ type, data).success(function(data, status, headers) {
            $scope.elements.push(data);
        });
        $scope.message = "created";
    };

    $scope.updateElement = function(type, id) {
        var data = $scope.formData;
        $http.put('http://localhost:8080/' + type + '/' + id, data).success(function(data, status, headers) {
            //$scope.elements.objects[index] = data;
        });
        $scope.message = "updated";
    };

    $scope.deleteElement = function(type, id) {
        $http.delete('http://localhost:8080/'+ type + '/' + id).success(function(data) {
            var index = $scope.elements.indexOf(data);
            $scope.elements.splice(index, 1);
        });
        $scope.message = "deleted";
        $scope.formData = {};
    };

    $scope.getElementAndParent = function(type1, id1, type2, id2) {
        $http.get('http://localhost:8080/' + type1 + '/' + id1).success(function(data) {
            $scope.child = data;
        });
        $http.get('http://localhost:8080/' + type2 + '/' + id2).success(function(data) {
            $scope.parent = data;
        });
    };

    $scope.isActive = function (viewLocation) {
        var active = ($location.path().indexOf(viewLocation) > -1);
        return active;
    };

});




