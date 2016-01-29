Ext.define('Shoppingapp.shoppingapp.web.com.shoppingapp.view.organizationboundedcontext.location.TalukaMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TalukaMainController",
     "restURL": "/Taluka",
     "defaults": {
          "split": true
     },
     "requires": ["Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.TalukaModel", "Shoppingapp.shoppingapp.web.com.shoppingapp.controller.organizationboundedcontext.location.TalukaMainController", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.CountryModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.StateModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.RegionModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.DistrictModel", "Shoppingapp.shoppingapp.shared.com.shoppingapp.viewmodel.organizationboundedcontext.location.TalukaViewModel"],
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
               "displayName": "Taluka",
               "name": "TalukaTreeContainer",
               "itemId": "TalukaTreeContainer",
               "restURL": "/Taluka",
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
                    "itemId": "TalukaTree",
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
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "D2945A2C-29F5-40D1-B040-AD499369F5BB",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "DC1DC919-40D0-4ABD-9BB9-5030E3033F72",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.StateModel"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region",
                         "fieldId": "2937E1FB-A5F3-43BF-9C1E-5A1EA410EF09",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.RegionModel"
                         }
                    }, {
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "District",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District",
                         "fieldId": "0E403DE3-1855-44F0-8A95-AB470FEA8D76",
                         "restURL": "District",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Shoppingapp.shoppingapp.shared.com.shoppingapp.model.organizationboundedcontext.location.DistrictModel"
                         }
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name",
                         "fieldId": "FF494D40-833D-411C-813F-FEAEF6E10A6E",
                         "minLength": "0",
                         "maxLength": "256"
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code",
                         "fieldId": "43A94852-E55E-4166-8209-D86B8B4E2ABC",
                         "minLength": "0",
                         "maxLength": "32"
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
                    "viewModel": "TalukaViewModel",
                    "xtype": "form",
                    "displayName": "Taluka",
                    "title": "Taluka",
                    "name": "Taluka",
                    "itemId": "Taluka",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "talukaId",
                         "itemId": "talukaId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                         "fieldId": "7DB1DAEE-EF0A-43C9-8DD5-BF314C28D3AB",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "talukaId",
                         "bind": "{talukaId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D2945A2C-29F5-40D1-B040-AD499369F5BB",
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
                         "fieldId": "DC1DC919-40D0-4ABD-9BB9-5030E3033F72",
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
                         "fieldId": "2937E1FB-A5F3-43BF-9C1E-5A1EA410EF09",
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
                         "fieldId": "0E403DE3-1855-44F0-8A95-AB470FEA8D76",
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
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaName",
                         "itemId": "talukaName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FF494D40-833D-411C-813F-FEAEF6E10A6E",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "talukaName",
                         "bind": "{talukaName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaCode",
                         "itemId": "talukaCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "taluka Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "43A94852-E55E-4166-8209-D86B8B4E2ABC",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "talukaCode",
                         "bind": "{talukaCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaDescription",
                         "itemId": "talukaDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "taluka Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "taluka Description",
                         "fieldId": "36921718-82F1-44B3-9E60-B81AFBE618D9",
                         "bindable": "talukaDescription",
                         "bind": "{talukaDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaFlag",
                         "itemId": "talukaFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "ED340F4A-CED1-4C80-A92A-3A0FC44FFA2A",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "talukaFlag",
                         "bind": "{talukaFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLatitude",
                         "itemId": "talukaLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "talukaaLatitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "talukaaLatitude",
                         "fieldId": "D2F662C8-184A-4600-A952-261F734A4CA6",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLatitude",
                         "bind": "{talukaLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "talukaLongitude",
                         "itemId": "talukaLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Citry Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Citry Longitude",
                         "fieldId": "2844CCE2-2F48-4CED-9B0A-12BC224EA604",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "talukaLongitude",
                         "bind": "{talukaLongitude}",
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
                         "fieldId": "7ACF5777-D8E3-46B6-B2CD-4B4D7C2FB9A0",
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
                         "customId": 966,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 966,
                              "customId": 789
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 966,
                              "customId": 790,
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
                              "parentId": 966,
                              "customId": 791,
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
                    "displayName": "Taluka",
                    "title": "Details Grid",
                    "name": "TalukaGrid",
                    "itemId": "TalukaGrid",
                    "restURL": "/Taluka",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "taluka Id",
                         "dataIndex": "talukaId",
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
                         "header": "taluka Name",
                         "dataIndex": "talukaName",
                         "flex": 1
                    }, {
                         "header": "taluka Code",
                         "dataIndex": "talukaCode",
                         "flex": 1
                    }, {
                         "header": "taluka Description",
                         "dataIndex": "talukaDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "talukaFlag",
                         "flex": 1
                    }, {
                         "header": "talukaaLatitude",
                         "dataIndex": "talukaLatitude",
                         "flex": 1
                    }, {
                         "header": "Citry Longitude",
                         "dataIndex": "talukaLongitude",
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
               "viewModel": "TalukaViewModel",
               "xtype": "form",
               "displayName": "Taluka",
               "title": "Taluka",
               "name": "Taluka",
               "itemId": "Taluka",
               "bodyPadding": 10,
               "items": [{
                    "name": "talukaId",
                    "itemId": "talukaId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Id<font color='red'> *<\/font>",
                    "fieldId": "7DB1DAEE-EF0A-43C9-8DD5-BF314C28D3AB",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "talukaId",
                    "bind": "{talukaId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D2945A2C-29F5-40D1-B040-AD499369F5BB",
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
                    "fieldId": "DC1DC919-40D0-4ABD-9BB9-5030E3033F72",
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
                    "fieldId": "2937E1FB-A5F3-43BF-9C1E-5A1EA410EF09",
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
                    "fieldId": "0E403DE3-1855-44F0-8A95-AB470FEA8D76",
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
                    "columnWidth": 0.5
               }, {
                    "name": "talukaName",
                    "itemId": "talukaName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FF494D40-833D-411C-813F-FEAEF6E10A6E",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "talukaName",
                    "bind": "{talukaName}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaCode",
                    "itemId": "talukaCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "taluka Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "43A94852-E55E-4166-8209-D86B8B4E2ABC",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "talukaCode",
                    "bind": "{talukaCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaDescription",
                    "itemId": "talukaDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "taluka Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "taluka Description",
                    "fieldId": "36921718-82F1-44B3-9E60-B81AFBE618D9",
                    "bindable": "talukaDescription",
                    "bind": "{talukaDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaFlag",
                    "itemId": "talukaFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "ED340F4A-CED1-4C80-A92A-3A0FC44FFA2A",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "talukaFlag",
                    "bind": "{talukaFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLatitude",
                    "itemId": "talukaLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "talukaaLatitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "talukaaLatitude",
                    "fieldId": "D2F662C8-184A-4600-A952-261F734A4CA6",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLatitude",
                    "bind": "{talukaLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "talukaLongitude",
                    "itemId": "talukaLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Citry Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Citry Longitude",
                    "fieldId": "2844CCE2-2F48-4CED-9B0A-12BC224EA604",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "talukaLongitude",
                    "bind": "{talukaLongitude}",
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
                    "fieldId": "7ACF5777-D8E3-46B6-B2CD-4B4D7C2FB9A0",
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
                    "customId": 966,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 966,
                         "customId": 789
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 966,
                         "customId": 790,
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
                         "parentId": 966,
                         "customId": 791,
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