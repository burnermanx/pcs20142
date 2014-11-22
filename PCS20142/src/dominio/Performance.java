/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Burner
 */
public class Performance {
    private int pg;
    private int j;
    private int v;
    private int e;
    private int d;
    private int gp;
    private int gc;
    private int sg;
    private double aproveitamento;

    public Performance() {
        pg = j = v = e = d = gp = gc = sg = 0;
        aproveitamento = 0;
    }
    
    public void calculaPG() {
        this.pg = (v*3) + (e*1);
    }
    
    public void calculaAproveitamento() {
        this.aproveitamento = (pg / j * 3);
    }
    
    public void adicionaGolsPros(int gols) {
        this.gp += gols;
    }
    
    public void adicionaGolsContras(int gols) {
        this.gc += gols;
    }
    
    public void calculaSaldoGols() {
        this.sg = gp - gc;
    }
    
    public void adicionaResultado(String resultado) {
        switch(resultado) {
            case "v":
                this.v += 1;
                break;
            case "e":
                this.e += 1;
                break;
            case "d":
                this.d += 1;
                break;
        }
    }
    
    /* Em suma, o adicionaJogo faz tudo */
    public void adicionaJogo(String resultado, int gp, int gc) {
        this.j += 1;
        adicionaResultado(resultado);
        adicionaGolsPros(gp);
        adicionaGolsContras(gc);
        calculaSaldoGols();
        calculaAproveitamento();
        calculaPG();
    }
    
    
    
    
}
