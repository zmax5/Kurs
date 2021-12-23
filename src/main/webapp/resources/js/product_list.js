$(document).ready(function () {
    $.get('./products', (data) => {
        let res = data;
        let $productslist = $('#products-list>.panel-body')
        res.forEach(product => {
            let produ = product.prod;
            let template = `
                    <div class="panel panel-default">
                        <div class="panel-heading"><a class="btn-link" style="color: black" 
                        href="./product_info?id=${produ.idProduct}">
                        <h3>${produ.name}</h3></a></div>
                        <div class="panel-info" style="margin-left: 20px; margin-bottom: 10px; margin-top: 10px">
                            ${produ.descr}
                        </div>
                        <div class="panel-footer">`;
            let cat = product.categories;
            for (let i = 0; i < cat.length; i++){
                template += `<span class="label label-primary" style="marginbottom:5px; margin-left: 5px;">
                ${cat[i].name}</span>`;
            }
            template += `</div></div>`;

            $productslist.append(template);
        })
    });

    // ADD PRODUCT
    $('#dialog-button').click(() => {
        location.href = "./add_product";
    });

});