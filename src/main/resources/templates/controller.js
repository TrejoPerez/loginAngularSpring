angular.module("LogUsuario",[])
        .controller("ControllerUsuario",function($scope,$http){
        $scope.buscarUsuario=function(){
            $http.get('http://localhost:8080/usuario/'+$scope.email +'/'+$scope.password)
                    .success(function(json){
                        $scope.encontrado=json;
            });
        }
});
