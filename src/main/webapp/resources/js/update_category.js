$(document).ready(() => {
    ID = getUrlParameter("id");

    $.get('./categoryget?id=' + ID, (data) => {
        let res = data;
        let cat = res.category;

        let name = cat.name;
        $('#category-name').val(name);
    });

    $('#add-category-button').click(() => {
        let name = $('#category-name').val();
        if (name === "") {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "UPDATE",
                id: ID,
                name: name
            };
            $.post('./categories', result, function (data) {
                location.href = "./CategoriesList";
            });
        }
    });

    $('#cancel-add').click(() => {
        let isCancel = confirm("Вернуться назад?");
        if (isCancel) {
            location.href = "./CategoriesList";
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
