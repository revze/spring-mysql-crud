angular.module('aplikasiCatatan', ['ngRoute'])
	.config(function($routeProvider){
		$routeProvider
			.when('/',{
				'templateUrl': 'views/home.html',
				'controller': 'catatanController'
			});
	});
