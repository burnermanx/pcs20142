/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dominio.Campeonato;
import dominio.Equipe;
import dominio.Performance;
import java.util.*;

/**
 *
 * @author Burner
 */
public class ServicoClassificacaoEquipes {

    private Campeonato campeonato;
    private String posicao;
    private String indicador = "";
    private String nomeEquipe;
    private String pg;
    private String j;
    private String v;
    private String e;
    private String d;
    private String gp;
    private String gc;
    private String sg;
    private String aproveitamento;
    //String[] linha = { posicao, indicador, equipes, pg, j, v, d, gp, gc, sg, aproveitamento };

    public ServicoClassificacaoEquipes(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public List<String[]> obterClassificacaoGeral() {
        List<String[]> classificacaoGeral = new ArrayList<>();
        List<Equipe> equipes;
        int i = 1;
        equipes = campeonato.getEquipes();
        for (Equipe equipe : equipes) {
            Performance performanceEquipe = equipe.getPerformance();
            this.posicao = Integer.toString(i);
            this.nomeEquipe = equipe.getNome();
            this.j = String.valueOf(performanceEquipe.getJ());
            this.pg = String.valueOf(performanceEquipe.getPg());
            this.v = String.valueOf(performanceEquipe.getV());
            this.e = String.valueOf(performanceEquipe.getE());
            this.d = String.valueOf(performanceEquipe.getD());
            this.gp = String.valueOf(performanceEquipe.getGp());
            this.gc = String.valueOf(performanceEquipe.getGc());
            this.sg = String.valueOf(performanceEquipe.getSg());
            this.aproveitamento = String.valueOf(String.format("%.1f", performanceEquipe.getAproveitamento()));
            if (equipe.getIdentificador() != null) {
                this.indicador = String.valueOf(equipe.getIdentificador());
            }
            String[] linha = {posicao, indicador, nomeEquipe, pg, j, v, e, d, gp, gc, sg, aproveitamento};
            classificacaoGeral.add(linha);
            classificacaoGeral = ordenarClassificacao(classificacaoGeral);
            classificacaoGeral = indicarClassificacao(classificacaoGeral);

        }
        return classificacaoGeral;
    }

    public ArrayList<Performance> obterClassificacaoMandante() {
        return null;
    }

    public ArrayList<Performance> obterClassificacaoVisitante() {
        return null;
    }

    public List<String[]> ordenarClassificacao(List<String[]> classificacao) {
        List<String[]> ordenado = new ArrayList<>();
        int i = 0;
        while (!classificacao.isEmpty()) {
            i++;
            String[] aux = {"0", "0", "", "0", "0", "0", "0", "0", "0", "0", "0", "0.0"};
            for (String[] s : classificacao) {
                if (Integer.parseInt(s[3]) >= Integer.parseInt(aux[3])) {
                    aux = s;
                }

            }
            aux[0] = String.valueOf(i);
            ordenado.add(aux);
            classificacao.remove(classificacao.indexOf(aux));
        }
        return ordenado;
    }

    public List<String[]> indicarClassificacao(List<String[]> classificacao) {
        List<String[]> indicados = new ArrayList<>();
        for (String[] linha : classificacao) {
            if (Integer.valueOf(linha[0]) >= 1 && Integer.valueOf(linha[0]) <= 4) {
                linha[1] = "L";
            }
            if (Integer.valueOf(linha[0]) >= 17 && Integer.valueOf(linha[0]) <= 20) {
                linha[1] = "R";
            }
            if (Integer.valueOf(linha[0]) >= 5 && Integer.valueOf(linha[0]) <= 16) {
                linha[1] = "";
            }
            indicados.add(linha);
        }
        return indicados;
    }
}
