$(document).ready(() => {

    getAllProducts();

    $('#add-property-button').click(() => {
        let name = $('#property-name').val();
        let value = $('#property-value').val();
        let ID = $('#product-select>.panel-body>.product-select').val();
        if (name === "" || value === "" || ID === "") {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "ADD",
                id: ID,
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
    })
}