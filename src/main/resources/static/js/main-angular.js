// create angular app
var blueCloud = angular.module('blueCloud', []);

// create angular controller
blueCloud.controller('mainController', function($scope, $http) {

    $("#project-view").hide();
    $("#task-view").hide();
    $("#crud-project-view").hide();
    $("#crud-task-view").hide();

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

    $scope.getProjectForm = function() {
        $("#projects-view").hide();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").fadeIn();
        $("#crud-task-view").hide();
    };

    $scope.getTaskForm = function() {
        $("#projects-view").hide();
        $("#project-view").hide();
        $("#task-view").hide();
        $("#crud-project-view").hide();
        $("#crud-task-view").fadeIn();
    };



});


