Ext.define('Shoppingapp.view.databrowsercalendar.DBCalendar', {
	extend : 'Shoppingapp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Shoppingapp.view.databrowsercalendar.DBCalendarController',
	             'Shoppingapp.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
