package br.com.financeiro.validators;

import br.com.financeiro.model.Conta;

public class CategoriaValid {

	public boolean verifica(Conta conta) {

		boolean valida;

		if (conta.getNome() == "") {
			valida = false;

		} else {

			valida = true;
		}

		return valida;
	}

}
