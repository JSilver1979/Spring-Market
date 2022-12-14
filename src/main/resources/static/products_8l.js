angular.module('app',[]).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1'

    $scope.loadProducts = function() {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductList = response.data;
            });
    };

    $scope.changePrice = function (productId, price) {
        $http({
            url: contextPath + '/products/change_price',
            method: 'GET',
            params: {
                productId: productId,
                price: price
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    };

    $scope.deleteProduct = function (productId) {
        $http.delete(contextPath + '/products/delete/' + productId)
        .then (function (response) {
            $scope.loadProducts();
        });
    };

    $scope.addProduct = function (product) {
        $http.post(contextPath + '/products', $scope.newProduct)
            .then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});