$(document).ready(function () {
    var itens = "";
    var options = "";
    var NOME_EVENTO_APPEND_SELECT = 'append';

    $('#txtCategoria').on(NOME_EVENTO_APPEND_SELECT, function () {
        // re-initialize (update)
        $(this).material_select();
    });

    $.getJSON('/financeiro/ConsultaCategoria', function (dados) {
        //var options = '<option value="">teste</option>';
        console.log(dados[0]);
        $.each(dados, function (i, obj) {
            console.log(obj);
            options += '<li>' + obj + '</li>';
            $('#txtCategoria')
                .append($("<option></option>")
                    .attr("value", i)
                    .text(obj)).trigger(NOME_EVENTO_APPEND_SELECT);
        });
    });
});