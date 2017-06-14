//Criação da classe para captura dos dados e serialização em Json

$(document).ready(function () {
    function Categoria(descricao) {
        this.descricao = descricao;

        this.getJson = function () {
            var categoria = this;
            return JSON.stringify(categoria);
        }
    };

//Disparo da função de cadastrar a categoria no banco

    $('#btnModEnviar').click(function (e) {
        var descricao = $('#txtModCategoria').val();
        var erros = [descricaoValidator.isValid(descricao)];
        if (erros[0].length === 0) {
            var categoria = new Categoria(descricao);
            var mydata = categoria.getJson();
            e.preventDefault();
            $.ajax({
                url: '/financeiro/CadastroCategoria',
                type: "POST",
                dataType: 'text',
                contentType: 'application/json',
                data: mydata,
                success: function () {
                    Materialize.toast('Categoria cadastrada com sucesso!', 3000, 'rounded');
                    modApagar();
                    $('.modal').modal('close');
                    consulta();
                }
            });
        }
        else {
            Materialize.toast('Preencha o campo corretamente!', 3000, 'rounded erros');
        }
    });
});