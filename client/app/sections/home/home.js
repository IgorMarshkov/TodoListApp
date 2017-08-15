angular.module('todoListApp.home', ['ngRoute', 'todoListApp.service.factory'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeCtrl as homeCtrl',
                templateUrl: 'sections/home/home.tmpl.html'
            });
    }])
    .controller('HomeCtrl', function ($scope, webServiceFactory) {
        $scope.taskList = [];

        initTaskList();

        $scope.deleteTask = function (id) {
            webServiceFactory.deleteTask(id,
                function (response) {
                    initTaskList();
                });
        };

        function initTaskList() {
            webServiceFactory.getTaskList(
                function (response) {
                    $scope.taskList = response.data;
                });
        }
    });
