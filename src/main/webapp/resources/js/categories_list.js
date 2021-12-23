$(document).ready(function () {
    $.get('./categories', (data) => {
        let res = data.categories;
        let $categories = $('#categories-list>.panel-body');
        console.log(res);
        let template = `<div class="panel panel-default">
                        <div class="panel-body" style="margin-left: 20px; margin-bottom: 10px; margin-top: 10px">
                        <table class="table table-responsive" style="text-align: center">
                        <tr class="row" style="font-weight: bold">
                        <td>№</td><td>Название</td><td>Изменить</td><td>Удалить</td></tr>`;
        res.forEach(category => {
            template += `
                        <tr class="row">
                        <td style="width: 10%"><h5 class=""> #${category.idCategory}</h5></td>
                        <td><h5 class="">${category.name}</h5></td>
                        <td class="table-edit-button" 
                        onclick="location.href = './update_category?id=${category.idCategory}'">
                            <div class="" style="">
                                <i class="glyphicon glyphicon-pencil" title="Добавить" style="top: 10px"></i>
                            </div>
                        </td>
                        <td class="table-delete-button" 
                        onclick="deleteCategory(${category.idCategory})">
                            <div class="delete-button" style="">
                                <i class="glyphicon glyphicon-remove" title="Удалить" style="top: 10px"></i>
                            </div>
                        </td>
                        </tr>`;

        })
        template += `</table>    
                     </div>
                     </div>`;
        $categories.append(template);
    });

    // ADD PRODUCT
    $('#dialog-button').click(() => {
        location.href = "./add_category";
    });


});

function deleteCategory(idCategory) {
    let isDelete = confirm("Вы действительно хотите удалить категорию №'" + idCategory + "' ? ");
    if (isDelete) {
        $.post('./categories', {id: idCategory, action: "DELETE"}, () => {
            location.href = "./CategoriesList";
        });
    }
}