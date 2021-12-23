$(document).ready(function () {
    ID = getUrlParameter("id");
    $.get('./productget?id=' + ID, (data) => {
        let res = data;
        let prod = res.prod;

        // Name and description
        name = prod.name;
        $('#name>#nameHere').html(`<h1 style="margin-top: 20px;">${name}</h1>`);
        $('#name>#vendor').html(`<span class="label label-danger" style="font-size: 12px">Производитель: ${res.vendor.name}</span>`)
        $('#description>.panel-body').html(res.prod.descr);

        // Properties
        let properties = res.properties;
        let $properties = $('#properties>.panel-body');
        let template = ``;
        for (let i = 0; i < properties.length; i++) {
            template = `<span class="label label-default" style="marginbottom:5px; margin-left: 5px;">
                ${properties[i].name + " : " + properties[i].value}</span>`;
            $properties.append(template);
        }
        /*
        template = `<span class="label label-default" style="marginbottom:5px; margin-left: 5px;">+</span>`;
        $properties.append(template);*/

        // Categories
        let $categories = $('#categories>.panel-body');
        template = ``;
        for (let i = 0; i < res.categories.length; i++) {
            template = `<span class="label label-primary" style="marginbottom:5px; margin-left: 5px;">
                ${res.categories[i].name}</span>`;
            $categories.append(template);
        }

        // Comments
        let $comments = $('#comments>.panel-body');
        template = ``;
        for (let i = 0; i < res.comments.length; i++) {
            template = `<div class="panel" style="background-color: seashell">
                <span class="text-uppercase" style="marginbottom:20px; margin-left: 5px ; margin-top: 20px; font-weight: 700">
                    ${res.comments[i].nick}: </span>
                <span class="text-area" style="marginbottom:20px; margin-left: 10px; margin-top: 20px">
                    ${res.comments[i].text}</span><br>
            </div>`;
            $comments.append(template);
        }
    });

    // Delete product
    $('#delete-button').click(() => {
        let isDelete = confirm("Вы действительно хотите удалить товар'" + name + "' ? ");
        if (isDelete) {
            $.post('./productget', {id: ID, action: "DELETE"}, () => {
                location.href = "./ProductsList";
            });
        }
    });

    // Edit product
    $('#dialog-button').click(() => {
        location.href = "./update_product?id=" + ID;
    });

    // Add comment
    $('#comments>#commnets-add>.panel-body>#add-coment').click(() => {
        let $nick = $('#comments>#commnets-add>.panel-body>#comments-nick');
        let $text = $('#comments>#commnets-add>.panel-body>#comments-text');
        let nick = $nick.val();
        let text = $text.val();
        let isAgree = confirm("Вы действительно хотите добавить комментарий \n'" + text + "'\nот имени \n'" + nick + "'");
        let result = {
            action: "ADD",
            nick: nick,
            text: text,
            id: ID,
        };
        if (isAgree) {
            $.post('./comment', result, function (data) {
                location.href = "./product_info?id=" + ID;
            });
        }
    })
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////