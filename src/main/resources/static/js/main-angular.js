// create angular app
var blueCloud = angular.module('blueCloud', ['ngRoute']);

// configure our routes
blueCloud.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'html/partial/project/projects.html'
        })
        .when('/project', {
            templateUrl : 'html/partial/project/project.html'
        })
        .when('/task', {
            templateUrl : 'html/partial/project/task.html'
        })
        .when('/create-project', {
            templateUrl : 'html/partial/project/crud-project.html'
        })
        .when('/update-project', {
            templateUrl : 'html/partial/project/crud-project.html'
        })
        .when('/create-task', {
            templateUrl : 'html/partial/project/crud-task.html'
        })
        .when('/update-task', {
            templateUrl : 'html/partial/project/crud-task.html'
        });

});

// create angular controller
blueCloud.controller('mainController', function($scope, $http) {

    // initialize the form data fields
    $scope.formData = {};

    $http.get('http://localhost:8080/projects').success(function(data) {
        $scope.projects = data;
    });

    // create a new element
    $scope.createAction = function() {
        $scope.action = 'create';
        $scope.message = '';
        $scope.formData = {};
    };

    // this gives us the option to update or delete an element
    $scope.updateAction = function(element) {
        $scope.action = 'update';
        $scope.formData = element;
        $scope.message = '';
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
            // create in db and update hazelcast
        });
        $scope.message = "created";
    };

    $scope.updateElement = function(type, id) {
        var data = $scope.formData;
        $http.put('http://localhost:8080/' + type + '/' + id, data).success(function(data, status, headers) {
            // update in db and update hazelcast
        });
        $scope.message = "updated";
    };

    $scope.deleteElement = function(type, id) {
        $http.delete('http://localhost:8080/'+ type + '/' + id).success(function(data) {
            $scope.element = data;
            // delete in db and update hazelcast
        });
        $scope.message = "deleted";
    };




















    /**
     ******** Task REST webservice calls ********
     */

    $scope.getElementAndParent = function(type, taskid, projectid) {
        $http.get('http://localhost:8080/' + type + '/' + taskid).success(function(data) {
            $scope.task = data;
        });
        $scope.projectid = projectid;
    };

});




