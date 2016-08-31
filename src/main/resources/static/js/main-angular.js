// create angular app
var blueCloud = angular.module('blueCloud', []);

// create angular controller
blueCloud.controller('mainController', function($scope, $http) {

    $("#project-view").hide();
    $("#task-view").hide();

    $scope.getProject = function(id) {
        $http.get('http://localhost:8080/projects/' + id).success(function(data) {
            $scope.project = data;
        });

        $("#projects-view").hide();
        $("#task-view").hide();
        $("#project-view").fadeIn();

    };

    $scope.getTask = function(taskid, projectid) {

        $http.get('http://localhost:8080/tasks/' + taskid).success(function(data) {
            $scope.task = data;
        });

        $scope.projectid = projectid;

        $("#project-view").hide();
        $("#projects-view").hide();
        $("#task-view").fadeIn();
    };



});


