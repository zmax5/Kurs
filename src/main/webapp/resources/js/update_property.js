var idProduct;

$(document).ready(() => {
    ID = getUrlParameter("id");

    $.get('./propertyget?id=' + ID, (data) => {
        let res = data;
        let prop = res.property;
        let name = prop.name;
        let value = prop.value;
        idProduct = prop.idProduct;

        getAllProducts();

        $('#property-name').val(name);
        $('#property-value').val(value);
        $('#product-select>.panel-body>.product-select').val(idProduct);

    });

    $('#add-property-button').click(() => {
        let name = $('#property-name').val();
        let value = $('#property-value').val();
        let idProduct = $('#product-select>.panel-body>.product-select').val();
        if (name === "" || value === "" || ID === "") {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "UPDATE",
                id: ID,
                idProduct: idProduct,
                name: name,
                value: value
            };
            $.post('./properties', result, function (data) {
                location.href = "./PropertiesList";
            });
        }
    });

    $('#cancel-add').click(() => {
        let isCancel = confirm("Вернуться назад?");
        if (isCancel) {
            location.href = "./PropertiesList";
        }
    })
});

function getAllProducts() {
    $.get("./products", (data) => {
        let res = data;
        let $list = $('#product-select>.panel-body>.product-select');
        let template = ``;
        res.forEach(product => {
            let produ = product.prod;
            template += `<option value="${produ.idProduct}"> ${produ.name} </option>`;
        });
        $list.append(template);
        $list.val(idProduct);
    })
}

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