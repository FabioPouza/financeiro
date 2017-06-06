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

  function Conta(nome, banco, agencia, numero, data, tipo, status) {
    this.nome = nome;
    this.banco = banco;
    this.agencia = agencia;
    this.numero = numero;
    this.data = data;
    this.tipo = tipo;
    this.status = status

    this.getJson = function () {
      var conta = this;
      return JSON.stringify(conta);
    }
  };

  $('#btnEnviar').click(function (e) {
    var nome = $('#txtNome').val();
    var banco = $('#txtBanco').val();
    var agencia = $('#txtAgencia').val();
    var numero = $('#txtNumero').val();
    var data = $('#txtData').val();
    var tipo = $('#txtTipo option:selected').text().toUpperCase();
    tipo = tipo.replace("POUPANÇA", "POUPANCA");
    console.log(tipo);
    var status = $('#chkStatus').is(":checked");
    console.log(data);
    var erros = [nomeValidator.isValid(nome), bancoValidator.isValid(banco)];
    console.log(erros);
    if (erros[0].length == 0 && erros[1] == 0) {
      var conta = new Conta(nome, banco, agencia, numero, data, tipo, status);
      var mydata = conta.getJson();
      e.preventDefault();
      $.ajax({
        url: '/financeiro/cadastrar',
        type: "POST",
        dataType: 'text',
        contentType: 'application/json',
        data: mydata,
        success: function () {
          Materialize.toast('Cadastrado com sucesso!', 3000, 'rounded');
          apagar();
        }
      });
    }
    else {
      Materialize.toast('Preencha os campos corretamente', 3000, 'rounded erros');
    }
  });
  $('#btnApagar').click(function () {
    apagar();
  });
});
