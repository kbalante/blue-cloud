// create angular app
var blueCloud = angular.module('blueCloud', ['ngRoute']);

// configure our routes
blueCloud.config(function($routeProvider) {
    $routeProvider
        // route for the projects page
        .when('/', {
            templateUrl : 'html/include/project/projects.html'
        })

        // route for the project page
        .when('/project', {
            templateUrl : 'html/include/project/project.html'
        })

        // route for the task page
        .when('/task', {
            templateUrl : 'html/include/project/task.html'
        })

        .when('/create-project', {
            templateUrl : 'html/include/project/crud-project.html'
        })

        .when('/update-project', {
            templateUrl : 'html/include/project/crud-project.html'
        });

});

// create angular controller
blueCloud.controller('mainController', function($scope, $http, $route, $location) {

    // initialize the form data fields
    $scope.formData = {};

    $scope.booleans = ["true", "false"];


    $http.get('http://localhost:8080/projects').success(function(data) {
        $scope.projects = data;
    });

    // create a new element
    $scope.createAction = function() {
        $scope.action = 'create';
        $scope.method = 'post';
    };

    // this gives us the option to update or delete an element
    $scope.updateAction = function(element) {
        $scope.action = 'update';
        $scope.method = 'update';
        $scope.formData = element;
    };

    $scope.findAllElements = function(type) {
        $http.get('http://localhost:8080/' + type).success(function(data) {
            $scope.elements = data;
        });
    };

    $scope.findElement = function(type, id) {
        $http.get('http://localhost:8080/'+ type + '/' + id).success(function(data) {
            $scope.element = data;
        });
    };

    $scope.createElement = function(type) {
        var data = {name:$scope.formData.name, ownerUserID:$scope.formData.ownerUserID, private:$scope.formData.private};
        $http.post('http://localhost:8080/'+ type, data).success(function(data, status, headers) {
            // create in db and update hazelcast
        });
        alert('Item Created');
    };

    $scope.updateElement = function(type, id) {
        var data = {name:$scope.formData.name, ownerUserID:$scope.formData.ownerUserID, private:$scope.formData.private};
        $http.put('http://localhost:8080/' + type + '/' + id, data).success(function(data, status, headers) {
            // update in db and update hazelcast
        });
        alert('Item updated');
    };

    $scope.deleteElement = function(type, id) {
        $http.delete('http://localhost:8080/'+ type + '/' + id).success(function(data) {
            $scope.element = data;
            // delete in db and update hazelcast
        });
        alert('Item Deleted');
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




