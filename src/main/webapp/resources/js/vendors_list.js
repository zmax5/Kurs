$(document).ready(function () {

    $.get('./vendors', (data) => {
        let res = data.vendors;
        let $vendor = $('#vendor-list>.panel-body');
        console.log(res);
        let template = `<div class="panel panel-default">
                        <div class="panel-body" style="margin-left: 20px; margin-bottom: 10px; margin-top: 10px">
                        <table class="table table-responsive" style="text-align: center">
                        <tr class="row" style="font-weight: bold">
                        <td>№</td><td>Название</td><td>Телефон</td><td>Изменить</td><td>Удалить</td></tr>`;
        res.forEach(vendor => {
            template += `
                        <tr class="row">
                        <td style="width: 10%"><h5 class="">#${vendor.idVendor}</h5></td>
                        <td><h5 class="">${vendor.name} </h5></td>
                        <td><h5 class="">${vendor.phone}</h5></td>
                        <td class="table-edit-button"
                        onclick="location.href = './update_vendor?id=${vendor.idVendor}'">
                            <div class="" style="">
                                <i class="glyphicon glyphicon-pencil" title="Добавить" style="top: 10px"></i>
                            </div>
                        </td>
                        <td class="table-delete-button"  
                        onclick="deleteVendor(${vendor.idVendor})">
                            <div class="delete-button" style="">
                                <i class="glyphicon glyphicon-remove" title="Удалить" style="top: 10px"></i>
                            </div>
                        </td>
                        </tr>`;

        })
        template += `</table>    
                     </div>
                     </div>`;
        $vendor.append(template);
    });

    // ADD PRODUCT
    $('#dialog-button').click(() => {
        location.href = "./add_vendor";
    });
});

function deleteVendor(idVendor) {
    let isDelete = confirm("Вы действительно хотите удалить производителя №'" + idVendor + "' ? ");
    if (isDelete) {
        $.post('./vendors', {id: idVendor, action: "DELETE"}, () => {
            location.href = "./VendorsList";
        });
    }
}