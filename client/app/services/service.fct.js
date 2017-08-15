angular.module('todoListApp.service.factory', [])
    .factory('webServiceFactory', ['$http', function ($http) {
        var serviceFactory = {};

        serviceFactory.getTaskList = function (callback) {
            $http.get(baseUrl + '/task').then(callback);
        };

        serviceFactory.getTask = function (id, callback) {
            $http.get(baseUrl + '/task/' + id).then(callback);
        };

        serviceFactory.saveTask = function (task, successCallback, errorCallback) {
            $http.post(baseUrl + '/task', task)
                .then(successCallback)
                .catch(errorCallback);
        };

        serviceFactory.deleteTask = function (id, callback) {
            $http.delete(baseUrl + '/task/' + id).then(callback);
        };

        serviceFactory.getPriorityList = function (callback) {
            $http.get(baseUrl + '/priority').then(callback);
        };

        return serviceFactory;
    }]);
