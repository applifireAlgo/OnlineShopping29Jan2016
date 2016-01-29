Ext.define('Shoppingapp.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingapp.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Shoppingapp.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
