Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.organizationboundedcontext.location.VillageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "VillageMainController",
     "restURL": "/Village",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.VillageModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.organizationboundedcontext.location.VillageMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.CountryModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.StateModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.RegionModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.DistrictModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.TalukaModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.organizationboundedcontext.location.VillageViewModel"],
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
               "displayName": "Village",
               "name": "VillageTreeContainer",
               "itemId": "VillageTreeContainer",
               "restURL": "/Village",
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
                    "itemId": "VillageTree",
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
                    "items": []
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
                    "viewModel": "VillageViewModel",
                    "xtype": "form",
                    "displayName": "Village",
                    "title": "Village",
                    "name": "Village",
                    "itemId": "Village",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "villageId",
                         "itemId": "villageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Id<font color='red'> *<\/font>",
                         "fieldId": "B1BB421E-E2AC-4F2D-B2E3-7A8295FAC2A4",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "villageId",
                         "bind": "{villageId}"
                    }, {
                         "name": "villageName",
                         "itemId": "villageName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2C9B251D-4F4B-49A0-B2FD-C3547A7B2287",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "villageName",
                         "bind": "{villageName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageDescription",
                         "itemId": "villageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Village Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Description",
                         "fieldId": "80480DF6-2636-45B9-BFD2-FC4804DA8AC0",
                         "bindable": "villageDescription",
                         "bind": "{villageDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageFlag",
                         "itemId": "villageFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village taluka",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village taluka",
                         "fieldId": "BF0FF993-3E8B-47D7-B099-60D71B7FEF02",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "villageFlag",
                         "bind": "{villageFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "85858988-48C4-45D2-A71F-24ED57287924",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CDEC7352-5D75-48F9-BA98-E34A3DE0B93E",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D156B768-5E91-4169-B616-189988F53B60",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.RegionModel"
                         },
                         "bindable": "regionId",
                         "bind": "{regionId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onRegionIdChange"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "323C2543-966D-4018-94FE-67ECE9BAF0AF",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.DistrictModel"
                         },
                         "bindable": "districtId",
                         "bind": "{districtId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onDistrictIdChange"
                         }
                    }, {
                         "name": "talukaaId",
                         "itemId": "talukaaId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "talukaa",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaa<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8C351AB2-65EE-47B3-BB66-121D7032E1AC",
                         "restURL": "Taluka",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.TalukaModel"
                         },
                         "bindable": "talukaaId",
                         "bind": "{talukaaId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageCode",
                         "itemId": "villageCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Village Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6D2399CC-EC3F-439D-A986-DFB76D443BD3",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "villageCode",
                         "bind": "{villageCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLatitude",
                         "itemId": "villageLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Latitude",
                         "fieldId": "B3270088-9D07-4CF4-AAFF-A8BE6E7B2180",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLatitude",
                         "bind": "{villageLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "villageLongtitude",
                         "itemId": "villageLongtitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Village Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Village Longitude",
                         "fieldId": "1AAA258B-7F58-46A1-B10A-D8182C3A7EE7",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "villageLongtitude",
                         "bind": "{villageLongtitude}",
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
                         "fieldId": "83BE2027-976A-4EF7-B07A-B2161B918C95",
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
                         "customId": 263,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 263,
                              "customId": 735
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 263,
                              "customId": 736,
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
                              "parentId": 263,
                              "customId": 737,
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
                    "displayName": "Village",
                    "title": "Details Grid",
                    "name": "VillageGrid",
                    "itemId": "VillageGrid",
                    "restURL": "/Village",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Village Id",
                         "dataIndex": "villageId",
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
                         "header": "Village Name",
                         "dataIndex": "villageName",
                         "flex": 1
                    }, {
                         "header": "Village Description",
                         "dataIndex": "villageDescription",
                         "flex": 1
                    }, {
                         "header": "Village taluka",
                         "dataIndex": "villageFlag",
                         "flex": 1
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District",
                         "dataIndex": "districtId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "talukaa",
                         "dataIndex": "talukaaId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Village Code",
                         "dataIndex": "villageCode",
                         "flex": 1
                    }, {
                         "header": "Village Latitude",
                         "dataIndex": "villageLatitude",
                         "flex": 1
                    }, {
                         "header": "Village Longitude",
                         "dataIndex": "villageLongtitude",
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
               "viewModel": "VillageViewModel",
               "xtype": "form",
               "displayName": "Village",
               "title": "Village",
               "name": "Village",
               "itemId": "Village",
               "bodyPadding": 10,
               "items": [{
                    "name": "villageId",
                    "itemId": "villageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Id<font color='red'> *<\/font>",
                    "fieldId": "B1BB421E-E2AC-4F2D-B2E3-7A8295FAC2A4",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "villageId",
                    "bind": "{villageId}"
               }, {
                    "name": "villageName",
                    "itemId": "villageName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2C9B251D-4F4B-49A0-B2FD-C3547A7B2287",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "villageName",
                    "bind": "{villageName}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageDescription",
                    "itemId": "villageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Village Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Description",
                    "fieldId": "80480DF6-2636-45B9-BFD2-FC4804DA8AC0",
                    "bindable": "villageDescription",
                    "bind": "{villageDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageFlag",
                    "itemId": "villageFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village taluka",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village taluka",
                    "fieldId": "BF0FF993-3E8B-47D7-B099-60D71B7FEF02",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "villageFlag",
                    "bind": "{villageFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "85858988-48C4-45D2-A71F-24ED57287924",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CDEC7352-5D75-48F9-BA98-E34A3DE0B93E",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D156B768-5E91-4169-B616-189988F53B60",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.RegionModel"
                    },
                    "bindable": "regionId",
                    "bind": "{regionId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onRegionIdChange"
                    }
               }, {
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "District",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "323C2543-966D-4018-94FE-67ECE9BAF0AF",
                    "restURL": "District",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.DistrictModel"
                    },
                    "bindable": "districtId",
                    "bind": "{districtId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onDistrictIdChange"
                    }
               }, {
                    "name": "talukaaId",
                    "itemId": "talukaaId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "talukaa",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaa<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8C351AB2-65EE-47B3-BB66-121D7032E1AC",
                    "restURL": "Taluka",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.TalukaModel"
                    },
                    "bindable": "talukaaId",
                    "bind": "{talukaaId}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageCode",
                    "itemId": "villageCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Village Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6D2399CC-EC3F-439D-A986-DFB76D443BD3",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "villageCode",
                    "bind": "{villageCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLatitude",
                    "itemId": "villageLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Latitude",
                    "fieldId": "B3270088-9D07-4CF4-AAFF-A8BE6E7B2180",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLatitude",
                    "bind": "{villageLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "villageLongtitude",
                    "itemId": "villageLongtitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Village Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Village Longitude",
                    "fieldId": "1AAA258B-7F58-46A1-B10A-D8182C3A7EE7",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "villageLongtitude",
                    "bind": "{villageLongtitude}",
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
                    "fieldId": "83BE2027-976A-4EF7-B07A-B2161B918C95",
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
                    "customId": 263,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 263,
                         "customId": 735
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 263,
                         "customId": 736,
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
                         "parentId": 263,
                         "customId": 737,
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