//Criação da classe para captura dos dados e serialização em Json

$(document).ready(function () {
    $(".button-collapse").sideNav();

    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15, // Creates a dropdown of 15 years to control year
        format: 'yyyy-mm-dd'
    });

    $(document).ready(function () {
        $('select').material_select();
    });

    //Classe Lançamento
    function Lancamento(tipo, valor, data, descricao, conta, categoria, formaPagamento, obs) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
        this.conta = conta;
        this.categoria = categoria;
        this.formaPagamento = formaPagamento;
        this.obs = obs;

        this.getJson = function () {
            var lancamento = this;
            return JSON.stringify(lancamento);
        }
    };

//Classe Categoria
    function Categoria(id, descricao) {
        this.id = id;
        this.descricao = descricao;


        this.getJson = function () {
            var categoria = this;
            return JSON.stringify(categoria);
        }
    };

    //Disparo da função para cadastrar a conta no banco
    $('#btnEnviar').click(function (e) {
        var tipo = $('#txtTipoLancamento option:selected').text().toUpperCase();
        var valor = $('#txtValor').val();
        var data = $('#txtData').val();
        var desc = $('#txtDescricao').val();
        var conta = $('#txtConta option:selected').val();
        var categoria = $('#txtCategoria option:selected').val();
        var pagamento = $('#txtPagamento option:selected').text().toUpperCase();
        var obs = $('#txtObservacao').val();

        //var erros = [nomeValidator.isValid(nome), bancoValidator.isValid(banco)];
        //if (erros[0].length == 0 && erros[1] == 0) {
        var lancamento = new Lancamento(tipo, valor, data, desc, conta, categoria, pagamento, obs);
        var mydata = lancamento.getJson();
        e.preventDefault();
        $.ajax({
            url: '/CadastroLancamento',
            type: "POST",
            dataType: 'text',
            contentType: 'application/json',
            data: mydata,
            success: function () {
                Materialize.toast('Cadastrado com sucesso!', 3000, 'rounded');
                apagar();
            }
        });
        //}
        //else {
        //  Materialize.toast('Preencha os campos corretamente', 3000, 'rounded erros');
        //}
    });
    $('#btnApagar').click(function () {
        apagar();
    });
});
