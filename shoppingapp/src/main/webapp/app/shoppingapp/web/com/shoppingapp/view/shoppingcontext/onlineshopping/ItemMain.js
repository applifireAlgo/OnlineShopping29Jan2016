Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.shoppingcontext.onlineshopping.ItemMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ItemMainController",
     "restURL": "/Item",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ItemModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.shoppingcontext.onlineshopping.ItemMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.ProductModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.CategoryModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.BrandModel", "Shoppingapp.view.fw.component.FileUploadComponent", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.shoppingcontext.onlineshopping.ItemViewModel"],
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
               "displayName": "Item",
               "name": "ItemTreeContainer",
               "itemId": "ItemTreeContainer",
               "restURL": "/Item",
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
                    "itemId": "ItemTree",
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
                         "fieldId": "BDB62B42-9AF7-4799-BFF7-EB5F2B7AD845",
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
                         "fieldId": "7AE44EA0-2653-400D-B271-FF01D795FF70",
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
                         "name": "brandId",
                         "itemId": "brandId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand",
                         "fieldId": "9BE26FF9-9759-4371-B72C-3498E733A94F",
                         "restURL": "Brand",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.BrandModel"
                         }
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item",
                         "fieldId": "571EF0C8-5F6A-453B-AFAF-77884620938F",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price",
                         "fieldId": "F4F72FF6-05E4-4DDA-94C4-4D855B10B348",
                         "minValue": "0",
                         "maxValue": "10000000"
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock",
                         "fieldId": "3D3F50FF-BF5E-47D3-BD0F-20171A951FEF",
                         "minValue": "0",
                         "maxValue": "1000000000"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "D9025ACF-3B74-4C8C-B05C-679E289123F2"
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
                    "viewModel": "ItemViewModel",
                    "xtype": "form",
                    "displayName": "Item",
                    "title": "Item",
                    "name": "Item",
                    "itemId": "Item",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "itemId",
                         "itemId": "itemId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item Id<font color='red'> *<\/font>",
                         "fieldId": "FB906AAF-F8A5-4059-941F-5A658CAFF637",
                         "hidden": true,
                         "value": "",
                         "bindable": "itemId",
                         "bind": "{itemId}"
                    }, {
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BDB62B42-9AF7-4799-BFF7-EB5F2B7AD845",
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
                         "fieldId": "7AE44EA0-2653-400D-B271-FF01D795FF70",
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
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCategoryIdChange"
                         }
                    }, {
                         "name": "brandId",
                         "itemId": "brandId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Brand",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Brand<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9BE26FF9-9759-4371-B72C-3498E733A94F",
                         "restURL": "Brand",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.BrandModel"
                         },
                         "bindable": "brandId",
                         "bind": "{brandId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemName",
                         "itemId": "itemName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Item",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Item<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "571EF0C8-5F6A-453B-AFAF-77884620938F",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "itemName",
                         "bind": "{itemName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemPrice",
                         "itemId": "itemPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Price<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F4F72FF6-05E4-4DDA-94C4-4D855B10B348",
                         "minValue": "0",
                         "maxValue": "10000000",
                         "bindable": "itemPrice",
                         "bind": "{itemPrice}",
                         "columnWidth": 0.5
                    }, {
                         "name": "itemStock",
                         "itemId": "itemStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Stock<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "3D3F50FF-BF5E-47D3-BD0F-20171A951FEF",
                         "minValue": "0",
                         "maxValue": "1000000000",
                         "bindable": "itemStock",
                         "bind": "{itemStock}",
                         "columnWidth": 0.5
                    }, {
                         "items": [{
                              "name": "filePathHidden",
                              "xtype": "hidden",
                              "itemId": "filePathHidden",
                              "bind": "{itemIcon}"
                         }, {
                              "name": "itemIcon",
                              "itemId": "itemIcon",
                              "xtype": "fileupload",
                              "customWidgetType": "vdFileUpload",
                              "displayName": "Icon",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Icon<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "D9025ACF-3B74-4C8C-B05C-679E289123F2",
                              "bindable": "itemIcon",
                              "columnWidth": 0.5
                         }]
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "7467C666-C96B-4134-AE85-A2950B798041",
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
                         "customId": 805,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 805,
                              "customId": 592
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 805,
                              "customId": 593,
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
                              "parentId": 805,
                              "customId": 594,
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
                    "displayName": "Item",
                    "title": "Details Grid",
                    "name": "ItemGrid",
                    "itemId": "ItemGrid",
                    "restURL": "/Item",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Item Id",
                         "dataIndex": "itemId",
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
                         "dataIndex": "brandId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Item",
                         "dataIndex": "itemName",
                         "flex": 1
                    }, {
                         "header": "Price",
                         "dataIndex": "itemPrice",
                         "flex": 1
                    }, {
                         "header": "Stock",
                         "dataIndex": "itemStock",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "itemIcon",
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
               "viewModel": "ItemViewModel",
               "xtype": "form",
               "displayName": "Item",
               "title": "Item",
               "name": "Item",
               "itemId": "Item",
               "bodyPadding": 10,
               "items": [{
                    "name": "itemId",
                    "itemId": "itemId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item Id<font color='red'> *<\/font>",
                    "fieldId": "FB906AAF-F8A5-4059-941F-5A658CAFF637",
                    "hidden": true,
                    "value": "",
                    "bindable": "itemId",
                    "bind": "{itemId}"
               }, {
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BDB62B42-9AF7-4799-BFF7-EB5F2B7AD845",
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
                    "fieldId": "7AE44EA0-2653-400D-B271-FF01D795FF70",
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
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCategoryIdChange"
                    }
               }, {
                    "name": "brandId",
                    "itemId": "brandId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Brand",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Brand<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9BE26FF9-9759-4371-B72C-3498E733A94F",
                    "restURL": "Brand",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.shoppingcontext.onlineshopping.BrandModel"
                    },
                    "bindable": "brandId",
                    "bind": "{brandId}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemName",
                    "itemId": "itemName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Item",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Item<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "571EF0C8-5F6A-453B-AFAF-77884620938F",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "itemName",
                    "bind": "{itemName}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemPrice",
                    "itemId": "itemPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Price<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F4F72FF6-05E4-4DDA-94C4-4D855B10B348",
                    "minValue": "0",
                    "maxValue": "10000000",
                    "bindable": "itemPrice",
                    "bind": "{itemPrice}",
                    "columnWidth": 0.5
               }, {
                    "name": "itemStock",
                    "itemId": "itemStock",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Stock",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Stock<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "3D3F50FF-BF5E-47D3-BD0F-20171A951FEF",
                    "minValue": "0",
                    "maxValue": "1000000000",
                    "bindable": "itemStock",
                    "bind": "{itemStock}",
                    "columnWidth": 0.5
               }, {
                    "items": [{
                         "name": "filePathHidden",
                         "xtype": "hidden",
                         "itemId": "filePathHidden",
                         "bind": "{itemIcon}"
                    }, {
                         "name": "itemIcon",
                         "itemId": "itemIcon",
                         "xtype": "fileupload",
                         "customWidgetType": "vdFileUpload",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D9025ACF-3B74-4C8C-B05C-679E289123F2",
                         "bindable": "itemIcon",
                         "columnWidth": 0.5
                    }]
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "7467C666-C96B-4134-AE85-A2950B798041",
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
                    "customId": 805,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 805,
                         "customId": 592
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 805,
                         "customId": 593,
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
                         "parentId": 805,
                         "customId": 594,
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