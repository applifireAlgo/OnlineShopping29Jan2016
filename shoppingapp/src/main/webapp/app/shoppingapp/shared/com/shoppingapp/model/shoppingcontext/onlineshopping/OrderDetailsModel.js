Ext.define('Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.OrderDetailsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "orderItemId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "itemid",
          "reference": "Item",
          "defaultValue": ""
     }, {
          "name": "itemPrice",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "itemQuantity",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "subTotal",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "OrderMain",
          "reference": "OrderMainModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});