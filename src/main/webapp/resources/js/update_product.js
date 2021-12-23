var name;
var vendor;
var descr;
var categories = [];

$(document).ready(() => {
    ID = getUrlParameter("id");

    $.get('./productget?id=' + ID, (data) => {
        let res = data;
        let prod = res.prod;

        // Name and description
        name = prod.name;
        descr = prod.descr;
        vendor = res.vendor.idVendor;
        res.categories.forEach((cat) =>{
            categories.push(cat.idCategory);
        })
        initTables();
        initDialogAdder();

        $('#product-name').val(name);
        $('#descr-text').val(descr);
        $('#list-vendors').val(vendor);

        // Categories
        let $categoriesList = $('#categories-list');
        let template = ``;
        for (let i = 0; i < res.categories.length; i++) {
            template = `<span class="label label-default" style="margin-top: 5px;margin-bottom:5px;margin-right: 5px">
                ${res.categories[i].name}</span>`;
            $categoriesList.append(template);
        }
    });

    $('#add-product-button').click(() => {
        name = $('#product-name').val();
        descr = $('#descr-text').val();
        vendor = $('#list-vendors').val();
        if (name === "" || vendor === "") {
            alert("Введены не все значения");
        } else {
            var result = {
                action: "UPDATE",
                id: ID,
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
        console.log(categories);
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
        let categoriesList = data.categories;
        let $table = $('#categories>tbody');
        $table.empty();
        categoriesList.forEach((category) => {
            let template = `<tr>
            <th scope="row">
                <input type="checkbox" attr-id="${category.idCategory}" name="checkbox-categories" 
                style="margin-left:auto; margin-right:auto;" `
                categories.forEach((cat) => {
                    if(cat === category.idCategory) {
                        template += `checked`
                    }
                })
            template += `>
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