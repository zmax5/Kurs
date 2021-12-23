$(document).ready(() => {

    ID = getUrlParameter("id");

    $.get('./vendorget?id=' + ID, (data) => {
        let res = data;
        let ven = res.vendor;

        let name = ven.name;
        let phone = ven.phone;

        $('#vendor-name').val(name);
        $('#vendor-phone').val(phone.slice(1,phone.length));
    });

    $('#add-vendor-button').click(() => {

        let name = $('#vendor-name').val();
        let phone = "8" + $('#vendor-phone').val();

        if (name === "" || phone === "8" || phone.length !== 11 || phone.includes(" ") || !phone.match(/[0-9]{10}/)) {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "UPDATE",
                id: ID,
                name: name,
                phone: phone
            };
            $.post('./vendors', result, function (data) {
                location.href = "./VendorsList";
            });
        }
    });

    $('#cancel-add').click(() => {
        let phone = "8" + $('#vendor-phone').val();
        console.log(phone.length);
        let isCancel = confirm("Вернуться назад?");
        if (isCancel) {
            location.href = "./VendorsList";
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