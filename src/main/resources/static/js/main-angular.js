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

        .when('/new-project', {
            templateUrl : 'html/include/project/crud-project.html'
        })

        .when('/new-task', {
            templateUrl : 'html/include/project/crud-task.html'
        });
});

// create angular controller
blueCloud.controller('mainController', function($scope, $http) {

    $http.get('http://localhost:8080/projects').success(function(data) {
        $scope.projects = data;
    });

    /**
     ******** Project REST webservice calls ********
     */

    $scope.showProjects = function() {
        $http.get('http://localhost:8080/projects').success(function(data) {
            $scope.projects = data;
        });
    };

    $scope.getProjects = function() {
        $http.get('http://localhost:8080/projects').success(function(data) {
            $scope.projects = data;
        });
    };

    $scope.showProjectForm = function() {

    };

    $scope.getProject = function(id) {
        $http.get('http://localhost:8080/projects/' + id).success(function(data) {
            $scope.project = data;
        });

    };

    $scope.createProject = function() {
        var data = {name:$scope.name, ownerUserID:$scope.ownerUserID, private:$scope.private};
        $http.post('http://localhost:8080/projects', data).success(function(data, status, headers) {
            //$scope.projects.push({id:$scope.id, name:$scope.name});
        });


    };

    $scope.updateProject = function() {
        var data = {name:$scope.name, ownerUserID:$scope.ownerUserID, private:$scope.private};
        $http.put('http://localhost:8080/projects', data).success(function(data, status, headers) {
            //$scope.projects.push({id:$scope.id, name:$scope.name});
        });


    };

    $scope.deleteProject = function(id) {
        $http.delete('http://localhost:8080/projects/').success(function(data) {
            $scope.project = data;
        });


    };

    /**
     ******** Task REST webservice calls ********
     */

    $scope.getTask = function(taskid, projectid) {
        $http.get('http://localhost:8080/tasks/' + taskid).success(function(data) {
            $scope.task = data;
        });
        $scope.projectid = projectid;

    };

    $scope.showTaskForm = function() {

    };
});




