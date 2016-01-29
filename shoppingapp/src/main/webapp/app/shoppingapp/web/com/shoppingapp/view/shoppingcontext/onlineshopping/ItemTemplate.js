Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.ItemTemplate', {
     "xtype": "itemTemplate",
     "items": [
{
          "xtype": "hiddenfield",
          "fieldLabel": "itemId",
          "bindable": "itemId",
          "margin": 5,
          "name": "itemId",
          "title": "itemId",
          "itemId": "gedmkhi",

     },{
          "xtype": "displayfield",
          "fieldLabel": "",
          "margin": "2 2 2 2",
          "bindable": "itemName",
          "name": "itemName",
          "itemId": "jgcnioi",
	"fieldStyle": {
            "fontStyle": "normal",
            "fontWeight": "bold",
            "color": "#157fcc",
            "fontSize": "14px"
          },

     },
 {
          "xtype": "image",
          "name": "itemIcon",
          "height": 150,
          "width": 150,
          "border": true,
          "margin": 5,
          "bindable": "itemIcon",
          "itemId": "kedjdji",
        
     },{
          "xtype": "displayfield",
          "fieldLabel": "Product",
          "margin": 5,
          "bindable": "productName",
          "name": "productName",
          "title": "Product",
          "readOnly": true,
	  "labelWidth":100,
          "itemId": "fpfbiii",
    
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Category",
          "margin": 5,
          "bindable": "categoryName",
          "name": "categoryName",
	  "labelWidth":100,
          "title": "Category",
          "readOnly": true,
          "itemId": "bhbadli",
       
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Brand",
          "margin": 5,
          "bindable": "brandName",
          "name": "brandName",
          "title": "Brand",
          "readOnly": true,
	  "labelWidth":100,
          "itemId": "ccagedi",
         
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Price",
          "name": "itemPrice",
          "margin": 5,
          "bindable": "itemPrice",
          "title": "Price",
"labelWidth":80,
          "readOnly": true,
          "itemId": "fihhgai",
         
     }, {
          "xtype": "numberfield",
          "fieldLabel": "Quantity",
          "name": "itemQuantity",
          "margin": 5,
          "bindable": "itemQuantity",
          "title": "Quantity",
          "itemId": "diohjai",
	"width":200,
        
     }, {
              "xtype": "button",
              "text": "Add To Cart",
              "isSubmitBtn": true,
              "width": "",
              "height": "",
              "margin": 5,
              "name": "addToCart",
              "style": {
                "background": "#FF9900",
                "borderColor": "",
                "borderWidth": "0px",
                "borderRadius": "2px",
                "color": "#ffffff",
                "fontColor": "#ffffff"
              },
            "text": "Add To Cart",
          "margin": 5,
          "itemId": "ajjaemi",
          "listeners": {
               "click": "onaddToCartclick"
          }}],
     "autoScroll": false,
  "border": false,
  "layoutDefaults": {},
  "titleCollapse": false,
  "collapsed": false,
  "collapsible": false,
  "margin": 15,
  "layout": {
    "type": "vbox",
    "align": "center",
    "pack": "center"
  },
  "style": {
    "borderColor": "",
    "boxShadow": "0 0 5px #808080",
    "borderStyle": "solid",
    "borderWidth": "1px"
  },
 
     "itemId": "eeheiai",
     "dockedItems": [],
	"title":"",
     "extend": "Ext.panel.Panel",
    "requires": ["Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.ItemTemplateController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.ItemTemplateViewModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemTemplateModel"],
     "viewModel": "ItemTemplateViewModel",
     "controller": "ItemTemplateController"
});
