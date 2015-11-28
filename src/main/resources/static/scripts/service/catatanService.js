/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


angular.module('aplikasiCatatan')
        .factory('catatanService',function ($http) {
            return {
                getCatatan: function() {
                    return $http.get("/catatan");
                },
                getListCatatan: function() {
                    return $http.get("/listCatatan");
                },
                save: function (data) {
                    return $http.post("/api/catatan",data);
                },
                getCatatanFromDb: function () {
                    return $http.get("/api/catatan");
                },
                delete: function(id) {
                    return $http.delete("/api/catatan/"+id);
                },
                update: function(id,data) {
                    return $http.put("/api/catatan/"+id,data);
                }
            };
});