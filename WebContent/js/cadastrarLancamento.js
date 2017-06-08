$(document).ready(function () {
    $('#txtDescricao').trigger('autoresize');

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year
        format: 'yyyy-mm-dd'
    });

    $(document).ready(function () {
        $('select').material_select();
    });

    $('#btnApagar').click(function () {
        apagar();
    });
});