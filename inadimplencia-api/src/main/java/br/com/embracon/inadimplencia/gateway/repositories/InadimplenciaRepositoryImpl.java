package br.com.embracon.inadimplencia.gateway.repositories;

import br.com.embracon.inadimplencia.gateway.model.Inadimplencia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InadimplenciaRepositoryImpl implements InadimplenciaRepository {


    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Inadimplencia> execute(String idParceiro) {
        List resultList = this.entityManager.createNativeQuery(this.query())
                                .setParameter("idPontoDeVenda", idParceiro)
                                .getResultList();
        List<Inadimplencia> inadimplencias = new ArrayList<>();
        for (Object teste : resultList) {
            inadimplencias.add(this.buildInadimplencia(teste));
        }
        return inadimplencias;
    }

    private Inadimplencia buildInadimplencia(Object r) {
        Object[] teste = (Object[]) r;
        return new Inadimplencia(String.valueOf(teste[2]), String.valueOf(teste[3]), String.valueOf(teste[4]),
                String.valueOf(teste[5]), String.valueOf(teste[6]), String.valueOf(teste[7]), null,
                null, String.valueOf(teste[8]), String.valueOf(teste[11]), String.valueOf(teste[10]),
                String.valueOf(teste[11]), String.valueOf(teste[13]) + String.valueOf(teste[14]),
                String.valueOf(teste[15]), null, String.valueOf(teste[17]),null, null,
                String.valueOf(teste[21]),String.valueOf(teste[22]));
    }


    public String query() {
        return "SELECT DISTINCT\n" +
               "\t Re_Cotas.ID_Pessoa, \t\t\n" +
                "\t Re_Cotas.ID_Cota, \n" +
                "\t Propostas_Alocadas.ID_Documento AS Proposta,\n" +
                "\t Re_Cotas.CD_Grupo AS Grupo,\n" +
                "\t Re_Cotas.CD_Cota AS Cota, \n" +
                "\t Re_Cotas.NM_Consorciado COLLATE sql_latin1_general_cp1251_ci_as AS Consorciado,\n" +
                "\t Re_Cotas.ST_Definicao_Situacao,\n" +
                "\t Re_Cotas.DT_Venda,\n" +
                "\t Filial.CD_Filial,\n" +
                "\t Filial.NM_Fantasia AS NM_Filial,\n" +
                "\t Ponto_Venda.CD_Ponto_Venda,\n" +
                "\t Ponto_Venda.NM_Fantasia as NM_Ponto_Venda,\n" +
                "\t Pessoa_E_Mail.E_Mail AS Email_Ponto_Venda,\n" +
                "\t Cidade.DDD AS DDD_Ponto_Venda,\n" +
                "\t Pessoa_Telefone.Telefone AS Telefone_Ponto_Venda,\t \n" +
                "\t Re_Cotas.CD_Bem,\n" +
                "\t Re_Cotas.NM_Bem,\n" +
                "\t Re_Cotas.VL_Bem_Atual,\n" +
                "\t Comissionado.CD_Comissionado,\n" +
                "\t Comissionado.NM_Fantasia,\t\n" +
                "\t Pessoa_E_Mail.E_Mail AS E_Mail_Ponto_Venda, \n" +
                "\t COUNT(Pcl_Atraso_Cota.ROWID) AS Nro_Pcl_Atraso,\n" +
                "\t SUM(Pcl_Atraso_Cota.VL_Parcela) AS VL_Parcela_Sem_M_J\n" +
                "FROM \n" +
                "\t\tCONBI801ATMP AS Pcl_Atraso_Cota WITH (NOLOCK)\n" +
                "\t\tINNER JOIN concc036 AS Propostas_Alocadas WITH (NOLOCK) ON \n" +
                "\t\t\tPcl_Atraso_Cota.ID_Cota = Propostas_Alocadas.ID_Cota\n" +
                "\t\tINNER JOIN conve002 AS Cotas WITH (NOLOCK) ON \n" +
                "\t\t\tPropostas_Alocadas.ID_Cota = Cotas.ID_Cota\n" +
                "\t\tINNER JOIN Conve002d AS Dados_Opc_Cota WITH (NOLOCK) ON\n" +
                "\t\t\tPcl_Atraso_Cota.ID_Cota = Dados_Opc_Cota.ID_Cota\n" +
                "\t\tINNER JOIN congr001 AS Grupos WITH (NOLOCK) ON\n" +
                "\t\t\tCotas.ID_Grupo = Grupos.ID_Grupo\n" +
                "\t\tINNER JOIN congr001f AS Sit_Grupos WITH (NOLOCK) ON\n" +
                "\t\t\tGrupos.ID_CONGR001F = Sit_Grupos.ID_CONGR001F\n" +
                "\t\tINNER JOIN vw_ReCotasRD AS Re_Cotas WITH (NOLOCK) ON\n" +
                "\t\t\tCotas.ID_Cota = Re_Cotas.ID_Cota \t\n" +
                "\t\tINNER JOIN Conve014 AS Comissionado WITH (NOLOCK) ON\n" +
                "\t\t\tCotas.ID_Comissionado = Comissionado.ID_Comissionado\n" +
                "\t\tINNER JOIN Concc002 AS Filial WITH (NOLOCK) ON\n" +
                "\t\t\tRe_Cotas.ID_Filial_Venda = Filial.ID_Filial\n" +
                "\t\tINNER JOIN Conve001 AS Ponto_Venda WITH (NOLOCK) ON \n" +
                "\t\t\tRe_Cotas.ID_Ponto_Venda = Ponto_Venda.ID_Ponto_Venda\n" +
                "\t\tINNER JOIN VW_CONVE002D WITH (NOLOCK) ON \n" +
                "\t\t\tPropostas_Alocadas.ID_Cota = VW_CONVE002D.ID_Cota\n" +
                "\t\tLEFT OUTER JOIN Corcc030 AS Pessoa_E_Mail WITH (NOLOCK) ON\n" +
                "\t\t\tPonto_Venda.ID_E_Mail = Pessoa_E_Mail.ID_E_Mail \n" +
                "\t\tLEFT OUTER JOIN Corcc027 AS Pessoa_Telefone WITH (NOLOCK) ON  \n" +
                "\t\t\tPonto_Venda.ID_Pessoa = Pessoa_Telefone.ID_Pessoa\t\t\n" +
                "\t\tINNER JOIN Corcc015 AS Cidade WITH (NOLOCK) ON \n" +
                "\t\t\tPessoa_Telefone.ID_Cidade = Cidade.ID_Cidade\n" +
                "WHERE \n" +
                "\tSit_Grupos.ST_Situacao = 'A'\n" +
                "\tAND Re_Cotas.ST_Definicao_Situacao = 'N' \n" +
                "\tAND Pcl_Atraso_Cota.ID_CD_Movto_Fin = 10 \n" +
                "\tAND VW_CONVE002D.DT_Contemplacao IS NULL \n" +
                "\tAND DATEDIFF(DAY,Pcl_Atraso_Cota.DT_VENCIMENTO,SYSDATETIME()) <= 32\n" +
                "\tAND Pessoa_Telefone.ID_Tipo_Telefone = 3\n" +
                "\tAND Ponto_Venda.CD_Ponto_Venda = :idPontoDeVenda\n" +
                "GROUP BY\n" +
                "\tRe_Cotas.ID_Pessoa, \n" +
                "\tRe_Cotas.ID_Cota,\n" +
                "\tPropostas_Alocadas.ID_Documento,\n" +
                "\tRe_Cotas.CD_Grupo, \n" +
                "\tRe_Cotas.CD_Cota,\n" +
                "\tRe_Cotas.NM_Consorciado,\n" +
                "\tRe_Cotas.ST_Definicao_Situacao, \n" +
                "\tRe_Cotas.ST_Definicao_Situacao, \n" +
                "\tRe_Cotas.DT_Venda, \n" +
                "\tFilial.CD_Filial, \n" +
                "\tFilial.NM_Fantasia, \n" +
                "\tPonto_Venda.CD_Ponto_Venda, \n" +
                "\tPonto_Venda.NM_Fantasia, \n" +
                "\tPessoa_E_Mail.E_Mail,\n" +
                "\tCidade.DDD,\n" +
                "\tPessoa_Telefone.Telefone,\t \n" +
                "\tRe_Cotas.CD_Bem, \n" +
                "\tRe_Cotas.NM_Bem, \n" +
                "\tRe_Cotas.VL_Bem_Atual, \n" +
                "\tComissionado.CD_Comissionado, \n" +
                "\tComissionado.NM_Fantasia,\n" +
                "--\tPcl_Atraso_Cota.DT_Vencimento,\n" +
                "\tPessoa_E_Mail.E_Mail\n" +
                "HAVING \n" +
                "\t COUNT(Pcl_Atraso_Cota.ROWID) = 1";
    }


}
