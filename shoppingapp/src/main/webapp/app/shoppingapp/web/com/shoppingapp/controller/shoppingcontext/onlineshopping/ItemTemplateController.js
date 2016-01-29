Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.ItemTemplateController', {
     extend: 'Shoppingapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.ItemTemplateController',
     onaddToCartclick: function(me, e, eOpts) {
          var jsonData = {};
          jsonData.itemId = this.view.down('#gedmkhi').getValue();
          jsonData.itemQuantity = this.view.down('#diohjai').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/Cart/',
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    } else {
                         Ext.Msg.alert('Server Response', responseText.response.message);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     }
});