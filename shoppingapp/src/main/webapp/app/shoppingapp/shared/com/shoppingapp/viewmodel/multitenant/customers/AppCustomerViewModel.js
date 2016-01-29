Ext.define('Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.multitenant.customers.AppCustomerViewModel', {
     "extend": "Ext.app.ViewModel",
     "alias": "viewmodel.AppCustomerViewModel",
     "model": "AppCustomerModel",
     "data": {
          "deploymentModel": "1",
          "customerStatus": "1",
          "userRequested": "1",
          "evalTimePeriod": "60"
     }
});