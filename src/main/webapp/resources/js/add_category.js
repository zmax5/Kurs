$(document).ready(() => {
    $('#add-category-button').click(() => {
        name = $('#category-name').val();
        if (name === "") {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "ADD",
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

