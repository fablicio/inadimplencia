package br.com.embracon.inadimplencia.entrypoint;

import br.com.embracon.inadimplencia.usecase.inadimplencia.ObterInadimplenciaPorParceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inadimplencia")
public class Inadimplencia {

    private ObterInadimplenciaPorParceiro obterInadimplenciaPorParceiro;

    @Autowired
    public Inadimplencia(ObterInadimplenciaPorParceiro obterInadimplenciaPorParceiro) {
        this.obterInadimplenciaPorParceiro = obterInadimplenciaPorParceiro;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> obterInadimplenciaPorParceiro(@PathVariable(value = "id") String idParceiro) {
        return new ResponseEntity(this.obterInadimplenciaPorParceiro.execute(idParceiro), HttpStatus.OK);
    }



}
