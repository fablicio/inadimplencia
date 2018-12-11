package br.com.embracon.inadimplencia.gateway.repositories;

import br.com.embracon.inadimplencia.gateway.model.Inadimplencia;

import java.util.List;

public interface InadimplenciaRepository {

    List<Inadimplencia> execute(String idParceiro);

}
