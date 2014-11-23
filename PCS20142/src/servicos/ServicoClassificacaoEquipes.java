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
            if (equipe.getIdentificador() != null)
                this.indicador = String.valueOf(equipe.getIdentificador());
            String[] linha = { posicao, indicador, nomeEquipe, pg, j, v, e, d, gp, gc, sg, aproveitamento };
            classificacaoGeral.add(linha);
            i = i + 1;
        }
            return classificacaoGeral;
    }
    
    public ArrayList<Performance> obterClassificacaoMandante() {
        return null;
    }
    
    public ArrayList<Performance> obterClassificacaoVisitante() {
        return null;
    }   
}
