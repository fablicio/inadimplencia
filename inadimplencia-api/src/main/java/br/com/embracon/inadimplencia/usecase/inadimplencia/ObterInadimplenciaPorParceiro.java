package br.com.embracon.inadimplencia.usecase.inadimplencia;

import br.com.embracon.inadimplencia.gateway.model.Inadimplencia;

import java.util.List;

public interface ObterInadimplenciaPorParceiro {

    List<Inadimplencia> execute(String idParceiro);

}
