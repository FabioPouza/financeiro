$(document).ready(function () {
    consulta();
});

function consulta() {

    var options = "";

//Gatilho para re-renderização do componente select da pagina
    var NOME_EVENTO_APPEND_SELECT = 'append';

    $('#txtCategoria').on(NOME_EVENTO_APPEND_SELECT, function () {
        // re-initialize (update)
        $(this).material_select();
    });

//Retorno do json pela rota consultada e incrementando no select

    $.getJSON('/financeiro/ConsultaCategoria', function (dados) {
        $('#txtCategoria option[value!="cadastrar"]').remove();
        $('#txtCategoria').prepend('<option value="" selected="selected">Escolha o tipo</option>')
            .trigger(NOME_EVENTO_APPEND_SELECT);

        $.each(dados, function (i, obj) {
            options += '<li>' + obj + '</li>';
            $('#txtCategoria')
                .append($("<option></option>")
                    .attr("value", i)
                    .text(obj)).trigger(NOME_EVENTO_APPEND_SELECT);
        });
    });
}