package br.com.embracon.inadimplencia.usecase.inadimplencia;

import br.com.embracon.inadimplencia.gateway.model.Inadimplencia;
import br.com.embracon.inadimplencia.gateway.repositories.InadimplenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObterInadimplenciaPorParceiroImpl implements  ObterInadimplenciaPorParceiro {

    private InadimplenciaRepository inadimplenciaRepository;

    @Autowired
    public ObterInadimplenciaPorParceiroImpl(InadimplenciaRepository inadimplenciaRepository) {
        this.inadimplenciaRepository = inadimplenciaRepository;
    }

    @Override
    public  List<Inadimplencia> execute(String idParceiro) {
        return inadimplenciaRepository.execute(idParceiro);
    }
}
