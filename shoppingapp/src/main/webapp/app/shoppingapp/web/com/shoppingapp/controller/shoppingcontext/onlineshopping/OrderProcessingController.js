Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.OrderProcessingController', {
     extend: 'Shoppingapp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.OrderProcessingController',
     onmakePaymentclick: function(me, e, eOpts) {
          var jsonData = {};
          jsonData.amount = this.view.down('#aggbedi').getValue();
          jsonData.ccHolderName = this.view.down('#piobfmi').getValue();
          jsonData.creditCardNo = this.view.down('#ppeefii').getValue();
          jsonData.customerId = this.view.down('#blnapki').getValue();
          jsonData.cvvNo = this.view.down('#abpoeoi').getValue();
          jsonData.expiryMonth = this.view.down('#ahodfhi').getValue();
          jsonData.expiryYear = this.view.down('#oladidi').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/OrderProcessingServiceWS/processOrder',
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