$(document).ready(function () {
    consultaConta();
});

function consultaConta() {

    var options = "";

    //Gatilho para re-renderização do componente select da pagina
    var NOME_EVENTO_APPEND_SELECT = 'append';

    $('#txtConta').on(NOME_EVENTO_APPEND_SELECT, function () {
        // re-initialize (update)
        $(this).material_select();
    });

    //Retorno do json pela rota consultada e incrementando no select
    $.getJSON('/ConsultaConta', function (dados) {
        $('#txtConta option[value!="conta"]').remove();

        $.each(dados, function (i, obj) {
            options += '<li>' + obj['NOME'] + '</li>';
            $('#txtConta')
                .append($("<option></option>")
                    .attr("value", obj['ID'])
                    .text(obj['NOME'])).trigger(NOME_EVENTO_APPEND_SELECT);

        });

    });
}