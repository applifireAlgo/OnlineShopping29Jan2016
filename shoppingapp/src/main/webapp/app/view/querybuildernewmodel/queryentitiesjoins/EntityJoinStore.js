Ext.define('Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Shoppingapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
