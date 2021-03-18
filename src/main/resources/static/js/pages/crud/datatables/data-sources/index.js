/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
var __webpack_exports__ = {};
/*!******************************************************************!*\
  !*** ../demo8/src/js/pages/crud/datatables/data-sources/html.js ***!
  \******************************************************************/

var KTDatatablesDataSourceHtml = function() {

	var initTable1 = function() {
		var table = $('#kt_datatable');

		// begin first table
		table.DataTable({
			responsive: true,
			language: {
				"decimal":        "",
				"emptyTable":     "No data available in table",
				"info":           "Mostrando _START_ a _END_ de _TOTAL_ entradas",
				"infoEmpty":      "Mostrando 0 a 0 de 0 entradas",
				"infoFiltered":   "(filtered from _MAX_ total entries)",
				"infoPostFix":    "",
				"thousands":      ",",
				"lengthMenu":     "Mostrar _MENU_ entradas",
				"loadingRecords": "Loading...",
				"processing":     "Processing...",
				"search":         "Buscar:",
				"zeroRecords":    "No matching records found",
				"paginate": {
						"first":      "Primero",
						"last":       "Último",
						"next":       "Siguiente",
						"previous":   "Anterior"
				},
				"aria": {
						"sortAscending":  ": activate to sort column ascending",
						"sortDescending": ": activate to sort column descending"
				}
			},
			"lengthMenu": [ 5, 10, 20, 50 ]
		});

	};

	return {

		//main function to initiate the module
		init: function() {
			initTable1();
		},

	};

}();

jQuery(document).ready(function() {
	KTDatatablesDataSourceHtml.init();
});

/******/ })()
;
//# sourceMappingURL=html.js.map