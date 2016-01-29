Ext.define('Shoppingapp.view.mainleftmenutree.MainPanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'mainPanelWithLeftMenu',
	requires : [ 'Shoppingapp.view.resource.ResourcePanel',
	             'Shoppingapp.view.mainleftmenutree.TopPanel.TopPanel',
	             'Shoppingapp.view.resource.DockedResourcePanel',
	             'Shoppingapp.view.fw.mainViewPanel.MainPanelController'
	           ],
	controller:'mainViewPanelController',
	layout : 'border',
	items : [{
		    	region: 'west',
		        xtype: 'resourcePanel',
		        width: '16%',
				placeholder : {
					xtype : 'dockedResourcePanel'
				},		
				placeholderCollapseHideMode : Ext.Element.DISPLAY, 
				collapsible : true,
				hideCollapseTool : true,
				titleCollapse : true
				
			}, {
		        region: 'center',
		        xtype: 'tabpanel',
		        itemId : 'appMainTabPanel',
				id : 'appMainTabPanel',
		        dockedItems : [{
					xtype : 'menuTopPanel'
				}],
				listeners:{
					afterrender:'aftrAppMainTabPanelRender'
				}
			}],
	listeners:{
		scope:'controller',
		afterrender:'afterRender'
	}
});
