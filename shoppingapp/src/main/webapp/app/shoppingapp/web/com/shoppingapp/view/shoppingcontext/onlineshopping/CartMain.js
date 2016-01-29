Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.CartMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CartMainController",
     "restURL": "/Cart",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CartModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.CartMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.aaaboundedcontext.authentication.UserModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.CartViewModel"],
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
               "displayName": "Cart",
               "name": "CartTreeContainer",
               "itemId": "CartTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CartTree",
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
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
                    }],
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Item Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item Id",
                         "fieldId": "B6BDFA6C-B351-4AA9-93B0-D8C7D1351D82",
                         "restURL": "Item",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel"
                         }
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price",
                         "fieldId": "F18F3D52-370F-4FC3-819F-4E3589EF7E49",
                         "minValue": "0",
                         "maxValue": "10000000"
                    }, {
                         "name": "itemQuantity",
                         "itemId": "itemQuantity",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Quantity",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Quantity",
                         "fieldId": "5AFD92C9-1C7B-4E44-A2F1-52D1B48EBFA3",
                         "minValue": "0",
                         "maxValue": "1000000000"
                    }, {
                         "name": "subTotal",
                         "itemId": "subTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Sub Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Sub Total",
                         "fieldId": "09132A63-07BC-4F95-B002-219B03B1D891",
                         "minValue": "0",
                         "maxValue": "10000000"
                    }, {
                         "name": "userId",
                         "itemId": "userId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User",
                         "margin": "5 5 5 5",
                         "fieldLabel": "User",
                         "fieldId": "1C9E86C6-6EDB-4D45-87FD-DDD51574DA90",
                         "restURL": "User",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.aaaboundedcontext.authentication.UserModel"
                         }
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
                    "xtype": "form",
                    "displayName": "Cart",
                    "name": "Cart",
                    "itemId": "CartForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "cartId",
                                   "itemId": "cartId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Cart Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Cart Id<font color='red'> *<\/font>",
                                   "fieldId": "987F9189-3844-4497-8113-93A6A4A67FC2",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "cartId",
                                   "bind": "{cartId}"
                              }, {
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Item Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Item Id<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "B6BDFA6C-B351-4AA9-93B0-D8C7D1351D82",
                                   "restURL": "Item",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel"
                                   },
                                   "bindable": "itemId",
                                   "columnWidth": 0.5,
                                   "bind": "{itemId}"
                              }, {
                                   "name": "itemPrice",
                                   "itemId": "itemPrice",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price",
                                   "fieldId": "F18F3D52-370F-4FC3-819F-4E3589EF7E49",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "itemPrice",
                                   "columnWidth": 0.5,
                                   "bind": "{itemPrice}"
                              }, {
                                   "name": "itemQuantity",
                                   "itemId": "itemQuantity",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5AFD92C9-1C7B-4E44-A2F1-52D1B48EBFA3",
                                   "minValue": "0",
                                   "maxValue": "1000000000",
                                   "bindable": "itemQuantity",
                                   "columnWidth": 0.5,
                                   "bind": "{itemQuantity}"
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total",
                                   "fieldId": "09132A63-07BC-4F95-B002-219B03B1D891",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "subTotal",
                                   "columnWidth": 0.5,
                                   "bind": "{subTotal}"
                              }, {
                                   "name": "userId",
                                   "itemId": "userId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "User",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "User",
                                   "fieldId": "1C9E86C6-6EDB-4D45-87FD-DDD51574DA90",
                                   "restURL": "User",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.aaaboundedcontext.authentication.UserModel"
                                   },
                                   "bindable": "userId",
                                   "columnWidth": 0.5,
                                   "bind": "{userId}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "8CB6EEBB-F27B-4C7C-907D-E86BF1925C92",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "CartViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Cart",
                    "title": "Details Grid",
                    "name": "CartGrid",
                    "itemId": "CartGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Cart Id",
                         "dataIndex": "cartId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Item Id",
                         "dataIndex": "itemId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Quantity",
                         "dataIndex": "itemQuantity",
                         "flex": 1
                    }, {
                         "header": "Sub Total",
                         "dataIndex": "subTotal",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "userId",
                         "renderer": "renderFormValue",
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
               "xtype": "form",
               "displayName": "Cart",
               "name": "Cart",
               "itemId": "CartForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "cartId",
                              "itemId": "cartId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Cart Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Cart Id<font color='red'> *<\/font>",
                              "fieldId": "987F9189-3844-4497-8113-93A6A4A67FC2",
                              "hidden": true,
                              "value": "",
                              "bindable": "cartId",
                              "bind": "{cartId}"
                         }, {
                              "name": "itemId",
                              "itemId": "itemId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Item Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Item Id<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "B6BDFA6C-B351-4AA9-93B0-D8C7D1351D82",
                              "restURL": "Item",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel"
                              },
                              "bindable": "itemId",
                              "columnWidth": 0.5,
                              "bind": "{itemId}"
                         }, {
                              "name": "itemPrice",
                              "itemId": "itemPrice",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Price",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Price",
                              "fieldId": "F18F3D52-370F-4FC3-819F-4E3589EF7E49",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "itemPrice",
                              "columnWidth": 0.5,
                              "bind": "{itemPrice}"
                         }, {
                              "name": "itemQuantity",
                              "itemId": "itemQuantity",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Quantity",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Quantity<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "5AFD92C9-1C7B-4E44-A2F1-52D1B48EBFA3",
                              "minValue": "0",
                              "maxValue": "1000000000",
                              "bindable": "itemQuantity",
                              "columnWidth": 0.5,
                              "bind": "{itemQuantity}"
                         }, {
                              "name": "subTotal",
                              "itemId": "subTotal",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Sub Total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Sub Total",
                              "fieldId": "09132A63-07BC-4F95-B002-219B03B1D891",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "subTotal",
                              "columnWidth": 0.5,
                              "bind": "{subTotal}"
                         }, {
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "User",
                              "margin": "5 5 5 5",
                              "fieldLabel": "User",
                              "fieldId": "1C9E86C6-6EDB-4D45-87FD-DDD51574DA90",
                              "restURL": "User",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.aaaboundedcontext.authentication.UserModel"
                              },
                              "bindable": "userId",
                              "columnWidth": 0.5,
                              "bind": "{userId}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "8CB6EEBB-F27B-4C7C-907D-E86BF1925C92",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "CartViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});