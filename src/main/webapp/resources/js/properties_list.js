$(document).ready(function () {

    $.get('./properties', (data) => {
        let res = data.properties;
        let $property = $('#properties-list>.panel-body');
        console.log(res);
        let template = `<div class="panel panel-default">
                        <div class="panel-body" style="margin-left: 20px; margin-bottom: 10px; margin-top: 10px">
                        <table class="table table-responsive" style="text-align: center">
                        <tr class="row" style="font-weight: bold">
                        <td>№</td><td>№ Продукта</td><td>Имя</td><td>Значение</td><td>Изменить</td><td>Удалить</td></tr>`;
        res.forEach(property => {
            template += `
                        <tr class="row">
                        <td style="width: 10%"><h5 class="">#${property.idProperty}</h5></td>
                        <td><h5 class="">#${property.idProduct} </h5></td>
                        <td><h5 class="">${property.name}</h5></td>
                        <td><h5 class="">${property.value}</h5></td>
                        <td class="table-edit-button"
                        onclick="location.href = './update_property?id=${property.idProperty}'">
                            <div class="" style="">
                                <i class="glyphicon glyphicon-pencil" title="Добавить" style="top: 10px"></i>
                            </div>
                        </td>
                        <td class="table-delete-button" 
                        onclick="deleteProp(${property.idProperty})">
                            <div class="delete-button" style="">
                                <i class="glyphicon glyphicon-remove" title="Удалить" style="top: 10px"></i>
                            </div>
                        </td>
                        </tr>`;

        })
        template += `</table>    
                     </div>
                     </div>`;
        $property.append(template);
    });

    // ADD PRODUCT
    $('#dialog-button').click(() => {
        location.href = "./add_property";
    });


});

function deleteProp(idProperty) {
    let isDelete = confirm("Вы действительно хотите удалить характеристику №'" + idProperty + "' ? ");
    if (isDelete) {
        $.post('./properties', {id: idProperty, action: "DELETE"}, () => {
            location.href = "./PropertiesList";
        });
    }
}