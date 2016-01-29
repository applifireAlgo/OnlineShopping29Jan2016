Ext.define('Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesStore', {
    extend: 'Ext.data.Store',
   // requires:['Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel'],
    autoSync: false,
    model: 'Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.QueryEntitiesModel',
    data:[]
});
