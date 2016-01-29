Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.OrderMainMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "OrderMainMainController",
     "restURL": "/OrderMain",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.OrderMainModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.OrderMainMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.aaaboundedcontext.authentication.UserModel", "Shoppingapp.view.fw.component.Grids", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.OrderMainViewModel"],
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
               "displayName": "OrderMain",
               "name": "OrderMainTreeContainer",
               "itemId": "OrderMainTreeContainer",
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
                    "itemId": "OrderMainTree",
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
                         "name": "orderDate",
                         "itemId": "orderDate",
                         "xtype": "datefield",
                         "customWidgetType": "vdDatefield",
                         "displayName": "Date",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Date",
                         "fieldId": "8A59A41F-4DA4-467B-B163-C3A01FF4FA95"
                    }, {
                         "name": "grandTotal",
                         "itemId": "grandTotal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Grand Total",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Grand Total",
                         "fieldId": "10671880-EA47-46DD-979C-7BA4EB17AFE9",
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
                         "fieldId": "36B50954-5C7E-4C93-A7CC-2C8D38149D99",
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
                    "displayName": "OrderMain",
                    "name": "OrderMain",
                    "itemId": "OrderMainForm",
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
                                   "name": "orderId",
                                   "itemId": "orderId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Order Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Order Id<font color='red'> *<\/font>",
                                   "fieldId": "3A327542-5F23-4706-9563-AE7A97A837D0",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "orderId",
                                   "bind": "{orderId}"
                              }, {
                                   "name": "orderDate",
                                   "itemId": "orderDate",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Date",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Date",
                                   "fieldId": "8A59A41F-4DA4-467B-B163-C3A01FF4FA95",
                                   "bindable": "orderDate",
                                   "columnWidth": 0.5,
                                   "bind": "{orderDate}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "grandTotal",
                                   "itemId": "grandTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Grand Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Grand Total",
                                   "fieldId": "10671880-EA47-46DD-979C-7BA4EB17AFE9",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "grandTotal",
                                   "columnWidth": 0.5,
                                   "bind": "{grandTotal}"
                              }, {
                                   "name": "userId",
                                   "itemId": "userId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "User",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "User",
                                   "fieldId": "36B50954-5C7E-4C93-A7CC-2C8D38149D99",
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
                                   "fieldId": "49A0AA25-82FE-456D-9873-0E6E60DBBA8A",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "OrderDetails",
                         "title": "OrderDetails",
                         "name": "OrderDetails",
                         "itemId": "OrderDetailsForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
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
                                        "name": "itemId",
                                        "itemId": "itemId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Item Id",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Item Id<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "5C144192-F93D-4289-AEDA-D30580AADE42",
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
                                        "bindable": "orderDetails.itemId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "itemPrice",
                                        "itemId": "itemPrice",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Price",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Price",
                                        "fieldId": "2E51F82D-89AB-452B-9032-A733B77CE902",
                                        "minValue": "0",
                                        "maxValue": "10000000",
                                        "bindable": "orderDetails.itemPrice",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "itemQuantity",
                                        "itemId": "itemQuantity",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Quantity",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "72108682-3256-46D5-BE58-3385E4B80FE5",
                                        "minValue": "0",
                                        "maxValue": "1000000000",
                                        "bindable": "orderDetails.itemQuantity",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "subTotal",
                                        "itemId": "subTotal",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "Sub Total",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "2470CE87-A03A-4D4C-9D4B-9FA9698AA71C",
                                        "minValue": "0",
                                        "maxValue": "10000000",
                                        "bindable": "orderDetails.subTotal",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 187,
                              "text": "Add OrderDetails",
                              "handler": "addOrderDetails"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "OrderDetails",
                              "columnWidth": 1,
                              "itemId": "OrderDetailsGrid",
                              "fieldLabel": "List",
                              "bindLevel": "orderDetails",
                              "bindable": "orderDetails",
                              "listeners": {
                                   "select": "onOrderDetailsGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "OrderItem Id",
                                   "text": "OrderItem Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "orderItemId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Item Id",
                                   "text": "Item Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Price",
                                   "text": "Price",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemPrice",
                                   "flex": 1
                              }, {
                                   "header": "Quantity",
                                   "text": "Quantity",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "itemQuantity",
                                   "flex": 1
                              }, {
                                   "header": "Sub Total",
                                   "text": "Sub Total",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "subTotal",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
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
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "viewModel": "OrderMainViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "OrderMain",
                    "title": "Details Grid",
                    "name": "OrderMainGrid",
                    "itemId": "OrderMainGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Order Id",
                         "dataIndex": "orderId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Date",
                         "dataIndex": "orderDate",
                         "flex": 1
                    }, {
                         "header": "Grand Total",
                         "dataIndex": "grandTotal",
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
               "displayName": "OrderMain",
               "name": "OrderMain",
               "itemId": "OrderMainForm",
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
                              "name": "orderId",
                              "itemId": "orderId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Order Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Order Id<font color='red'> *<\/font>",
                              "fieldId": "3A327542-5F23-4706-9563-AE7A97A837D0",
                              "hidden": true,
                              "value": "",
                              "bindable": "orderId",
                              "bind": "{orderId}"
                         }, {
                              "name": "orderDate",
                              "itemId": "orderDate",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Date",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Date",
                              "fieldId": "8A59A41F-4DA4-467B-B163-C3A01FF4FA95",
                              "bindable": "orderDate",
                              "columnWidth": 0.5,
                              "bind": "{orderDate}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "grandTotal",
                              "itemId": "grandTotal",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Grand Total",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Grand Total",
                              "fieldId": "10671880-EA47-46DD-979C-7BA4EB17AFE9",
                              "minValue": "0",
                              "maxValue": "10000000",
                              "bindable": "grandTotal",
                              "columnWidth": 0.5,
                              "bind": "{grandTotal}"
                         }, {
                              "name": "userId",
                              "itemId": "userId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "User",
                              "margin": "5 5 5 5",
                              "fieldLabel": "User",
                              "fieldId": "36B50954-5C7E-4C93-A7CC-2C8D38149D99",
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
                              "fieldId": "49A0AA25-82FE-456D-9873-0E6E60DBBA8A",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "OrderDetails",
                    "title": "OrderDetails",
                    "name": "OrderDetails",
                    "itemId": "OrderDetailsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
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
                                   "name": "itemId",
                                   "itemId": "itemId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Item Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Item Id<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5C144192-F93D-4289-AEDA-D30580AADE42",
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
                                   "bindable": "orderDetails.itemId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "itemPrice",
                                   "itemId": "itemPrice",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Price",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Price",
                                   "fieldId": "2E51F82D-89AB-452B-9032-A733B77CE902",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "orderDetails.itemPrice",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "itemQuantity",
                                   "itemId": "itemQuantity",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Quantity",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Quantity<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "72108682-3256-46D5-BE58-3385E4B80FE5",
                                   "minValue": "0",
                                   "maxValue": "1000000000",
                                   "bindable": "orderDetails.itemQuantity",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "subTotal",
                                   "itemId": "subTotal",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Sub Total",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Sub Total<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2470CE87-A03A-4D4C-9D4B-9FA9698AA71C",
                                   "minValue": "0",
                                   "maxValue": "10000000",
                                   "bindable": "orderDetails.subTotal",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 187,
                         "text": "Add OrderDetails",
                         "handler": "addOrderDetails"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "OrderDetails",
                         "columnWidth": 1,
                         "itemId": "OrderDetailsGrid",
                         "fieldLabel": "List",
                         "bindLevel": "orderDetails",
                         "bindable": "orderDetails",
                         "listeners": {
                              "select": "onOrderDetailsGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "OrderItem Id",
                              "text": "OrderItem Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "orderItemId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Item Id",
                              "text": "Item Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Price",
                              "text": "Price",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemPrice",
                              "flex": 1
                         }, {
                              "header": "Quantity",
                              "text": "Quantity",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "itemQuantity",
                              "flex": 1
                         }, {
                              "header": "Sub Total",
                              "text": "Sub Total",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "subTotal",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
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
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "viewModel": "OrderMainViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});