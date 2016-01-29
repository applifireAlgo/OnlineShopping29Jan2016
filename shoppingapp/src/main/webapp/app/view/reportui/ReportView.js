Ext.define('Shoppingapp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Shoppingapp.view.reportui.querycriteria.QueryCriteriaView',
			'Shoppingapp.view.reportui.datachart.DataChartViewTab',
			'Shoppingapp.view.reportui.datachart.DataChartViewPanel',
			'Shoppingapp.view.reportui.ReportViewController' ,
			'Shoppingapp.view.fw.MainDataPointPanel',
			'Shoppingapp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
