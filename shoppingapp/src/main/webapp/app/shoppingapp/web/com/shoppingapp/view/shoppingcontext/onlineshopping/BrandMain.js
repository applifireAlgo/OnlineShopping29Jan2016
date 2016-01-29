Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.BrandMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "BrandMainController",
     "restURL": "/Brand",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.BrandModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.BrandMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.BrandViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Brand",
               "name": "BrandTreeContainer",
               "itemId": "BrandTreeContainer",
               "restURL": "/Brand",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "BrandTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product",
                         "fieldId": "BB45DC1C-6B18-4E71-A2DB-0437D63F9756",
                         "restURL": "Product",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel"
                         }
                    }, {
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category",
                         "fieldId": "A328D191-0FD6-4B69-8F59-3CB634B3076E",
                         "restURL": "Category",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel"
                         }
                    }, {
                         "name": "brandName",
                         "itemId": "brandName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand",
                         "fieldId": "862A2BBC-F945-4B31-9CED-B25A9FD320E6",
                         "minLength": "0",
                         "maxLength": "256"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "BrandViewModel",
                    "xtype": "form",
                    "displayName": "Brand",
                    "title": "Brand",
                    "name": "Brand",
                    "itemId": "Brand",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "brandId",
                         "itemId": "brandId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Brand Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand Id<font color='red'> *<\/font>",
                         "fieldId": "DE953F2E-A3FC-4F1B-B7A6-F93790B9CAF4",
                         "hidden": true,
                         "value": "",
                         "bindable": "brandId",
                         "bind": "{brandId}"
                    }, {
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BB45DC1C-6B18-4E71-A2DB-0437D63F9756",
                         "restURL": "Product",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel"
                         },
                         "bindable": "productId",
                         "bind": "{productId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onProductIdChange"
                         }
                    }, {
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A328D191-0FD6-4B69-8F59-3CB634B3076E",
                         "restURL": "Category",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel"
                         },
                         "bindable": "categoryId",
                         "bind": "{categoryId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "brandName",
                         "itemId": "brandName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "862A2BBC-F945-4B31-9CED-B25A9FD320E6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "brandName",
                         "bind": "{brandName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "5A62BDEC-FB54-48AB-B054-F4256EBC6E58",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 921,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 921,
                              "customId": 875
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 921,
                              "customId": 876,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 921,
                              "customId": 877,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Brand",
                    "title": "Details Grid",
                    "name": "BrandGrid",
                    "itemId": "BrandGrid",
                    "restURL": "/Brand",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Brand Id",
                         "dataIndex": "brandId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Product",
                         "dataIndex": "productId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Category",
                         "dataIndex": "categoryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Brand",
                         "dataIndex": "brandName",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "BrandViewModel",
               "xtype": "form",
               "displayName": "Brand",
               "title": "Brand",
               "name": "Brand",
               "itemId": "Brand",
               "bodyPadding": 10,
               "items": [{
                    "name": "brandId",
                    "itemId": "brandId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Brand Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Brand Id<font color='red'> *<\/font>",
                    "fieldId": "DE953F2E-A3FC-4F1B-B7A6-F93790B9CAF4",
                    "hidden": true,
                    "value": "",
                    "bindable": "brandId",
                    "bind": "{brandId}"
               }, {
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BB45DC1C-6B18-4E71-A2DB-0437D63F9756",
                    "restURL": "Product",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel"
                    },
                    "bindable": "productId",
                    "bind": "{productId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onProductIdChange"
                    }
               }, {
                    "name": "categoryId",
                    "itemId": "categoryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A328D191-0FD6-4B69-8F59-3CB634B3076E",
                    "restURL": "Category",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel"
                    },
                    "bindable": "categoryId",
                    "bind": "{categoryId}",
                    "columnWidth": 0.5
               }, {
                    "name": "brandName",
                    "itemId": "brandName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Brand",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Brand<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "862A2BBC-F945-4B31-9CED-B25A9FD320E6",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "brandName",
                    "bind": "{brandName}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "5A62BDEC-FB54-48AB-B054-F4256EBC6E58",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 921,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 921,
                         "customId": 875
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 921,
                         "customId": 876,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 921,
                         "customId": 877,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});