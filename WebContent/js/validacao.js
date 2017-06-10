var nomeValidator = new StringValidator({
  required: true, minValue: 3, maxValue: 45,
  verbose: true, errorMessages: { isPreenchido: 'Preencha o campo!' }
});

var bancoValidator = new StringValidator({
  required: true, minValue: 5, maxValue: 45,
  verbose: true, errorMessages: { isPreenchido: 'Preencha o campo!' }
});

var agenciaValidator = new StringValidator({
  required: true, minValue: 5, maxValue: 45,
  verbose: true, errorMessages: { isPreenchido: 'Preencha o campo!' }
});

var descricaoValidator = new StringValidator({
  required: true, minValue: 3, maxValue: 25,
  verbose: true, errorMessages: { isPreenchido: 'Preencha o campo!' }
});