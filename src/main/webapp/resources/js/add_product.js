var name;
var vendor;
var descr;
var categories = [];

$(document).ready(() => {
    initTables();
    initDialogAdder();
    $('#add-product-button').click(() => {
        name = $('#product-name').val();
        vendor = $('#product-info>.panel-body>#vendor-select>.panel-body>.vendor-select').val();
        descr = $('#descr-text').val();
        if (name === "" || vendor === "") {
            alert("Введены не все значения");
        } else {
            var result = {
                action: "ADD",
                name: name,
                vendor: vendor,
                descr: descr,
                categories: JSON.stringify(categories)
            };
            $.post('./productget', result, function (data) {
                location.href = "./product_info?id=" + data;
            });
        }
    });
    $('#cancel-add').click(() => {
        let isCancel = confirm("Вернуться назад?");
        if (isCancel) {
            location.href = "./ProductsList";
        }
    })
});

function initTables() {
    getAllCategories();
    getAllVendors();
}

function getAllCategories() {
    $.get("./categories", (data) => {
        let categories = data.categories;
        let $table = $('#categories>tbody');
        $table.empty();
        categories.forEach((category) => {
            let template = `<tr>
            <th scope="row">
                <input type="checkbox" attr-id="${category.idCategory}" name="checkbox-categories" style="margin-left:auto; margin-right:auto;">
            </th>
                <td class="category-name-${category.idCategory}">${category.name}</td>
            </tr>`;
            $table.append(template);
        });
    })
}

function getAllVendors() {
    $.get("./vendors", (data) => {
        let vendors = data.vendors;
        let $list = $('#product-info>.panel-body>#vendor-select>.panel-body>.vendor-select');
        $list.empty();
        let template = ``;
        vendors.forEach((vendor) => {
            template += `<option value="${vendor.idVendor}"> ${vendor.name} </option>`;
        });
        $list.append(template);
    })
}

function initDialogAdder() {
    $('#add-categories-dialog-btn').click(() => {
        categories = [];
        let checked = $("input[name=checkbox-categories]:checked");
        let $categoriesList = $("#categories-list");
        $categoriesList.empty();
        for (let i = 0; i < checked.length; i++) {
            let ID = $(checked[i]).attr("attr-id");
            let name = $(".category-name-" + ID).text();
            let template = `<span class="label label-default" style="margin-top: 5px;margin-bottom:5px;margin-right: 5px">${name}</span>`;
            categories.push(ID);
            $categoriesList.append(template);
            $("#modal-categories").modal('hide');
        }
    });
}