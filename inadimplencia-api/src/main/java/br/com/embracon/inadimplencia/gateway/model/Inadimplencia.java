package br.com.embracon.inadimplencia.gateway.model;

public class Inadimplencia  {

    private String proposta;
    private String grupo;
    private String cota;
    private String consorciado;
    private String sitCobr;
    private String dtVenda;
    private String cdComissionado;
    private String comissionado;
    private String cdFilial;
    private String nmFilial;
    private String cdPontoVenda;
    private String nmPontoVenda;
    private String telefones;
    private String cdBem;
    private String descrBem;
    private String vlBem;
    private String dtVencimento;
    private String diasDeAtraso;
    private String nroPclAtrasoAte32Dias;
    private String vlParcelaSemMJ;

    public Inadimplencia(String consorciado) {
        this.consorciado = consorciado;
    }

    public Inadimplencia(String proposta, String grupo, String cota, String consorciado, String sitCobr, String dtVenda,
                         String cdComissionado, String comissionado, String cdFilial, String nmFilial, String cdPontoVenda,
                         String nmPontoVenda, String telefones, String cdBem, String descrBem, String vlBem, String dtVencimento,
                         String diasDeAtraso, String nroPclAtrasoAte32Dias, String vlParcelaSemMJ) {
        this.proposta = proposta;
        this.grupo = grupo;
        this.cota = cota;
        this.consorciado = consorciado;
        this.sitCobr = sitCobr;
        this.dtVenda = dtVenda;
        this.cdComissionado = cdComissionado;
        this.comissionado = comissionado;
        this.cdFilial = cdFilial;
        this.nmFilial = nmFilial;
        this.cdPontoVenda = cdPontoVenda;
        this.nmPontoVenda = nmPontoVenda;
        this.telefones = telefones;
        this.cdBem = cdBem;
        this.descrBem = descrBem;
        this.vlBem = vlBem;
        this.dtVencimento = dtVencimento;
        this.diasDeAtraso = diasDeAtraso;
        this.nroPclAtrasoAte32Dias = nroPclAtrasoAte32Dias;
        this.vlParcelaSemMJ = vlParcelaSemMJ;
    }

    public String getProposta() {
        return proposta;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getCota() {
        return cota;
    }

    public String getConsorciado() {
        return consorciado;
    }

    public String getSitCobr() {
        return sitCobr;
    }

    public String getDtVenda() {
        return dtVenda;
    }

    public String getCdComissionado() {
        return cdComissionado;
    }

    public String getComissionado() {
        return comissionado;
    }

    public String getCdFilial() {
        return cdFilial;
    }

    public String getNmFilial() {
        return nmFilial;
    }

    public String getCdPontoVenda() {
        return cdPontoVenda;
    }

    public String getNmPontoVenda() {
        return nmPontoVenda;
    }

    public String getTelefones() {
        return telefones;
    }

    public String getCdBem() {
        return cdBem;
    }

    public String getDescrBem() {
        return descrBem;
    }

    public String getVlBem() {
        return vlBem;
    }

    public String getDtVencimento() {
        return dtVencimento;
    }

    public String getDiasDeAtraso() {
        return diasDeAtraso;
    }

    public String getNroPclAtrasoAte32Dias() {
        return nroPclAtrasoAte32Dias;
    }

    public String getVlParcelaSemMJ() {
        return vlParcelaSemMJ;
    }
}
