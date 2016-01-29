Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.CategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CategoryMainController",
     "restURL": "/Category",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.CategoryMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.CategoryViewModel"],
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
               "displayName": "Category",
               "name": "CategoryTreeContainer",
               "itemId": "CategoryTreeContainer",
               "restURL": "/Category",
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
                    "itemId": "CategoryTree",
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
                         "fieldId": "D2B0960F-5C58-4FCF-9EE1-33802605B133",
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
                         "name": "categoryName",
                         "itemId": "categoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category",
                         "fieldId": "4A55E86B-4CBB-4912-B902-0DE487FD6464",
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
                    "viewModel": "CategoryViewModel",
                    "xtype": "form",
                    "displayName": "Category",
                    "title": "Category",
                    "name": "Category",
                    "itemId": "Category",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "categoryId",
                         "itemId": "categoryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category Id<font color='red'> *<\/font>",
                         "fieldId": "A20CC8B4-A8EB-49D7-A421-C28676A9ED84",
                         "hidden": true,
                         "value": "",
                         "bindable": "categoryId",
                         "bind": "{categoryId}"
                    }, {
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D2B0960F-5C58-4FCF-9EE1-33802605B133",
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
                         "columnWidth": 0.5
                    }, {
                         "name": "categoryName",
                         "itemId": "categoryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4A55E86B-4CBB-4912-B902-0DE487FD6464",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "categoryName",
                         "bind": "{categoryName}",
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
                         "fieldId": "1A0AA7E1-D5DF-4F60-B866-135D1CB308FA",
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
                         "customId": 116,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 116,
                              "customId": 69
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 116,
                              "customId": 70,
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
                              "parentId": 116,
                              "customId": 71,
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
                    "displayName": "Category",
                    "title": "Details Grid",
                    "name": "CategoryGrid",
                    "itemId": "CategoryGrid",
                    "restURL": "/Category",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Category Id",
                         "dataIndex": "categoryId",
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
                         "dataIndex": "categoryName",
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
               "viewModel": "CategoryViewModel",
               "xtype": "form",
               "displayName": "Category",
               "title": "Category",
               "name": "Category",
               "itemId": "Category",
               "bodyPadding": 10,
               "items": [{
                    "name": "categoryId",
                    "itemId": "categoryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Category Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category Id<font color='red'> *<\/font>",
                    "fieldId": "A20CC8B4-A8EB-49D7-A421-C28676A9ED84",
                    "hidden": true,
                    "value": "",
                    "bindable": "categoryId",
                    "bind": "{categoryId}"
               }, {
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D2B0960F-5C58-4FCF-9EE1-33802605B133",
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
                    "columnWidth": 0.5
               }, {
                    "name": "categoryName",
                    "itemId": "categoryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4A55E86B-4CBB-4912-B902-0DE487FD6464",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "categoryName",
                    "bind": "{categoryName}",
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
                    "fieldId": "1A0AA7E1-D5DF-4F60-B866-135D1CB308FA",
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
                    "customId": 116,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 116,
                         "customId": 69
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 116,
                         "customId": 70,
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
                         "parentId": 116,
                         "customId": 71,
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