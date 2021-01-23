/**
 * Created by joy on 17/10/2020.
 */

app.service('MenuService', function ($resource) {
    return {
        getMenuByParam : $resource('/api/rest/menu/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        createMenu : $resource('/api/rest/menu/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateMenu : $resource('/api/rest/menu/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteMenu: $resource('/api/rest/menu/delete/:menuID', {}, {
            'remove': {
                method: 'DELETE',
                isArray: false,
                params: {menuID: '@menuID'}
            }
        }),
        getByCategory: $resource('/api/rest/menu/getByCategory/:categoryID', {}, {
            'query': {
                method: 'GET',
                isArray: true,
                params: {categoryID: '@categoryID'}
            }
        }),
        getMenuSetupByParam : $resource('/api/rest/menuSetting/getByParam', {}, {
            'query':  {
                method:'GET',
                isArray:true
            }
        }),
        createMenuSetup : $resource('/api/rest/menuSetting/save', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        updateMenuSetup : $resource('/api/rest/menuSetting/update', {}, {
            'query':  {
                method:'POST',
                isArray:false
            }
        }),
        deleteMenuSetup: $resource('/api/rest/menuSetting/delete/:menuSettingID', {}, {
            'remove': {
                method: 'DELETE',
                isArray: false,
                params: {menuSettingID: '@menuSettingID'}
            }
        })
    };
});