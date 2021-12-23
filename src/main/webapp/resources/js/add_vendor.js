$(document).ready(() => {
    $('#add-vendor-button').click(() => {
        let name = $('#vendor-name').val();
        let phone = "8" + $('#vendor-phone').val();
        if (name === "" || phone === "8" || phone.length !== 11 || phone.includes(" ") || !phone.match(/[0-9]{10}/)) {
            alert("Введены не все значения");
        } else {
            let result = {
                action: "ADD",
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

