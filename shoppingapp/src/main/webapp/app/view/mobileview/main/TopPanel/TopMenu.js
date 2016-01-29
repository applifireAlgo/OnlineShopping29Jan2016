Ext.define('Shoppingapp.view.mobileview.main.TopPanel.TopMenu', { 
	extend: 'Ext.toolbar.Toolbar',
    xtype: 'topMenu',
    requires:['Shoppingapp.view.mobileview.main.TopPanel.TopMenuController',/*'Shoppingapp.view.mobileview.main.ResourceWindow'*/],
    controller :'topMenuController',
    border:0,
    itemId:'topMenuPanel',
    autoScroll :true,
    items:[]
});