Ext.define('Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
