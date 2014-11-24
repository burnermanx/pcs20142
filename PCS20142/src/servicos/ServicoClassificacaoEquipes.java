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
import javax.swing.JDialog;
import javax.swing.JFrame;

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

    public ServicoClassificacaoEquipes(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    

    public List<String[]> obterClassificacaoGeral() {
        List<String[]> classificacaoGeral = new ArrayList<>();
        List<Equipe> equipes;
        List<Linha> linhas = new ArrayList<>();
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
            linhas.add(new Linha (posicao, indicador, nomeEquipe, Integer.parseInt(pg), Integer.parseInt(j), Integer.parseInt(v), Integer.parseInt(e), Integer.parseInt(d), Integer.parseInt(gp), Integer.parseInt(gc), Integer.parseInt(sg), aproveitamento));
        }
        Collections.sort(linhas);
        for (Linha linha : linhas) {
            classificacaoGeral.add(linha.obterLinha());
        }
        indicarClassificacao(classificacaoGeral);
        return classificacaoGeral;
    }

    public ArrayList<Performance> obterClassificacaoMandante() {
        return null;
    }

    public ArrayList<Performance> obterClassificacaoVisitante() {
        return null;
    }

    public List<String[]> indicarClassificacao(List<String[]> classificacao) {
        List<String[]> indicados = new ArrayList<>();
        int i=0;
        for (String[] linha : classificacao) {
            i++;
            if (i >= 1 && i <= 4) {
                linha[1] = "L";
            }
            if (i >= 17 && i <= 20) {
                linha[1] = "R";
            }
            if (i >= 5 && i <= 16) {
                linha[1] = "";
            }
            linha[0] = String.valueOf(i);
            indicados.add(linha);
        }
        return indicados;
    }
    
    class Linha implements Comparable<Linha> {
        private String posicao;
        private String indicador;
        private String nomeEquipe;
        private int pg;
        private int j;
        private int v;
        private int e;
        private int d;
        private int gp;
        private int gc;
        private int sg;
        private String aproveitamento;

        public Linha(String posicao, String indicador, String nomeEquipe, int pg, int j, int v, int e, int d, int gp, int gc, int sg, String aproveitamento) {
            this.posicao = posicao;
            this.indicador = indicador;
            this.nomeEquipe = nomeEquipe;
            this.pg = pg;
            this.j = j;
            this.v = v;
            this.e = e;
            this.d = d;
            this.gp = gp;
            this.gc = gc;
            this.sg = sg;
            this.aproveitamento = aproveitamento;
        }
        
        public String[] obterLinha() {
            String pg = String.valueOf(this.pg);
            String j = String.valueOf(this.j);
            String v = String.valueOf(this.v);
            String e = String.valueOf(this.e);
            String d = String.valueOf(this.d);
            String gp = String.valueOf(this.gp);
            String gc = String.valueOf(this.gc);
            String sg = String.valueOf(this.sg);
            String[] resultado = {posicao, indicador, nomeEquipe, pg, j, v, e, d ,gp, gc, sg, aproveitamento };
            return resultado;
        }
        
        
        @Override
        public int compareTo(Linha o) {
            if (this.pg > o.pg) {
                return -1;
            } else if (this.pg == o.pg) {
                if (this.v > o.v) {
                    return -1;
                } else if (this.v == o.v) {
                    if (this.sg > o.sg) {
                        return -1;
                    } else if (this.sg == o.sg) {
                        if (this.gp > o.gp) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
            return 1;      
        }
        
    }
}
