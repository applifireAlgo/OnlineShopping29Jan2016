Ext.define('Shoppingapp.view.usermanagement.enduser.EndUserProfileMainView', {
	extend : 'Ext.tab.Panel',
	requires : ['Shoppingapp.view.usermanagement.enduser.UserProfile',
	            'Shoppingapp.view.usermanagement.enduser.ChangePwd'],
	xtype : 'endUserMainView',
	margin : '3 0 0 0',
	items:[{
				xtype:'userProfileView',
				title:'User Profile',
				iconCls:'editUserTabIcon',
				tooltip:'View/Edit your profile'
			},
			{
				xtype:'changePwdView',
				title:'Change Password',
				iconCls:'changePwdTabIcon',
				tooltip:'Change Password'
			}]
});