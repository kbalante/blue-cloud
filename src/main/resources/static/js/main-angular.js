// create angular app
var blueCloud = angular.module('blueCloud', []);

// create angular controller
blueCloud.controller('mainController', function($scope, $http) {

    $http.get('http://localhost:8080/projects').success(function(data) {
        $scope.projects = data;
    });

    $("#project-view").hide();
    $("#task-view").hide();
    $("#crud-project-view").hide();
    $("#crud-task-view").hide();

    /**
     ******** Project REST webservice calls ********
     */

    $scope.showProjects = function() {
        $("#projects-view").fadeIn();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.getProjects = function() {

        $http.get('http://localhost:8080/projects').success(function(data) {
            $scope.projects = data;
        });

        $("#projects-view").fadeIn();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.showProjectForm = function() {
        $("#projects-view").hide();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").fadeIn();
        $("#crud-task-view").hide();
    };

    $scope.getProject = function(id) {
        $http.get('http://localhost:8080/projects/' + id).success(function(data) {
            $scope.project = data;
        });
        $("#projects-view").hide();
        $("#project-view").fadeIn();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.createProject = function() {
        var data = {name:$scope.name, ownerUserID:$scope.ownerUserID, private:$scope.private};
        $http.post('http://localhost:8080/projects', data).success(function(data, status, headers) {
            //$scope.projects.push({id:$scope.id, name:$scope.name});
        });

        $("#projects-view").hide();
        $("#project-view").fadeIn();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.updateProject = function() {
        var data = {name:$scope.name, ownerUserID:$scope.ownerUserID, private:$scope.private};
        $http.put('http://localhost:8080/projects', data).success(function(data, status, headers) {
            //$scope.projects.push({id:$scope.id, name:$scope.name});
        });

        $("#projects-view").hide();
        $("#project-view").fadeIn();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.deleteProject = function(id) {
        $http.delete('http://localhost:8080/projects/').success(function(data) {
            $scope.project = data;
        });

        // list all the projects
        $("#projects-view").fadeIn();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    /**
     ******** Task REST webservice calls ********
     */

    $scope.getTask = function(taskid, projectid) {
        $http.get('http://localhost:8080/tasks/' + taskid).success(function(data) {
            $scope.task = data;
        });
        $scope.projectid = projectid;
        $("#projects-view").hide();
        $("#project-view").hide();
        $("#task-view").fadeIn();
        $("#crud-project-view").hide();
        $("#crud-task-view").hide();
    };

    $scope.showTaskForm = function() {
        $("#projects-view").hide();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").fadeIn();
    };


    // create hide all divs function

});


