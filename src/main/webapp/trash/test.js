$(document).ready(function () {
    ID = getUrlParameter("id");
    $.get('./restest?id=1', (data) => {
        let res = data;
        $('#name').html(`<h1 style="margin-top: 268px;">${res.prod.idProduct}</h1>`);
        /*
        // Name and description
        name = res.name;
        $('#name').html(`<h1 style="margin-top: 268px;">${name}</h1>`);
        $('#description>.panel-body').html(res.descr);

        // Properties
        let properties = res.properties;
        let $properties = $('#properties>.panel-body');
        for (let i = 0; i < actors.length; i++) {
            let template = `<span class="label label-default" style="marginbottom:5px; margin-left: 5px;">
                ${properties[i].name + " : " + properties[i].value}</span>`;
            $properties.append(template);
        }

        // Categories
        let $categories = $('#categories>.panel-body');
        for (let i = 0; i < res.categories.length; i++) {
            let template = `<span class="label label-primary" style="marginbottom:5px; margin-left: 5px;">
                ${res.categories[i].name}</span>`;
            $categories.append(template);
        }

        // Comments
        var $countries = $('#countries>.panel-body');
        for (var i = 0; i < res.countries.length; i++) {
            var template = `<span class="label label-success" style="marginbottom:5px; margin-left: 5px;">
                ${res.countries[i].countryName}</span>`;
            $countries.append(template);
        }*/
    });

    // Delete product
    $('#cancel-add-button').click(() => {
        var isDelete = confirm("Вы действительно хотите удалить товар'" + name + "' ? ")
        if (isDelete) {
            $.post('/products', {id: ID, action: "DELETE"}, () => {
                location.href = "index.jsp";
            });
        }
    });

    // Edit product
    $('#add-dialog-button').click(() => {
        location.href = "update_product.jsp?id=" + ID;
    });
});


function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)), sURLVariables = sPageURL.split('&'),
        sParameterName, i;
    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}