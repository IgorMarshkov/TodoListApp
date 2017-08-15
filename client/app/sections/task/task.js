angular.module('todoListApp.task', ['ngRoute', 'todoListApp.service.factory'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/task', {
                controller: 'TaskCtrl as taskCtrl',
                templateUrl: 'sections/task/task.tmpl.html'
            })
            .when('/task/:taskId', {
                controller: 'TaskCtrl as taskCtrl',
                templateUrl: 'sections/task/task.tmpl.html'
            });
    }])
    .controller('TaskCtrl', function ($scope, $routeParams, $location, webServiceFactory) {
        var taskId = $routeParams.taskId;

        $scope.priorityList = [];
        $scope.task = {};
        $scope.errorMap = [];

        if (taskId) {
            webServiceFactory.getTask(taskId,
                function (response) {
                    $scope.task = response.data;
                });
        } else {
            $scope.task.done = false;
        }

        webServiceFactory.getPriorityList(
            function (response) {
                $scope.priorityList = response.data;
            });

        $scope.saveTask = function () {
            webServiceFactory.saveTask($scope.task,
                function (response) {
                    $location.path('/');
                },
                function (response) {
                    angular.forEach(response.data.errors, function(value, key) {
                        $scope.errorMap[value.field] = value.defaultMessage;
                    });
                });
        };
    });