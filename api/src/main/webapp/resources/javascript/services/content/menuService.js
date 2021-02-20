/**
 * Created by joy on 17/10/2020.
 */

app.service('MenuService', function ($resource) {
    return {
        getMenuByParam : $resource('/rest/menu/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        createMenu : $resource('/rest/menu/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateMenu : $resource('/rest/menu/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteMenu: $resource('/rest/menu/delete/:menuID', {}, {
            'remove': {
                method: 'DELETE',
                isArray: false,
                params: {menuID: '@menuID'}
            }
        }),
        getByCategory: $resource('/rest/menu/getByCategory/:categoryID', {}, {
            'query': {
                method: 'GET',
                isArray: true,
                params: {categoryID: '@categoryID'}
            }
        }),
        getMenuSetupByParam : $resource('/rest/menuSetting/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        createMenuSetup : $resource('/rest/menuSetting/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateMenuSetup : $resource('/rest/menuSetting/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteMenuSetup: $resource('/rest/menuSetting/delete/:menuSettingID', {}, {
            'remove': {
                method: 'DELETE',
                isArray: false,
                params: {menuSettingID: '@menuSettingID'}
            }
        })
    };
});