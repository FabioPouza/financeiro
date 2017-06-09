$(document).ready(function () {

    //Inicialização do modal a partir do select
    $('.modal').modal({

        ready: function (modal, trigger) { // Callback for Modal open. Modal and trigger parameters available.
            alert("Ready");
            console.log(modal, trigger);
        },

        complete: function() { alert('Closed'); }
    });

    $("#txtCategoria").on("change", function () {
        if ($(this).val() === 'cadastrar') {
            $('.modal').modal('open');
        }
    });

    //Inicialização do auto-size para o campo observação
    $('#txtDescricao').trigger('autoresize');

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year
        format: 'yyyy-mm-dd'
    });

    //Inicialização dos selects
    $(document).ready(function () {
        $('select').material_select();
    });

    //Carregando a função apagar
    $('#btnApagar').click(function () {
        apagar();
    });


});