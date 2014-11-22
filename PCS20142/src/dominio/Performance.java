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
        this.pg = (this.v*3) + (this.e*1);
    }
    
    public void calculaAproveitamento() {
        double pg = (double)this.pg;
        double j = (double)this.j;
        this.aproveitamento = ((pg / (j * 3))*100);
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
        calculaPG();
        calculaAproveitamento();
    }

    public int getPg() {
        return pg;
    }

    public void setPg(int pg) {
        this.pg = pg;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getGp() {
        return gp;
    }

    public void setGp(int gp) {
        this.gp = gp;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getSg() {
        return sg;
    }

    public void setSg(int sg) {
        this.sg = sg;
    }

    public double getAproveitamento() {
        return aproveitamento;
    }

    public void setAproveitamento(double aproveitamento) {
        this.aproveitamento = aproveitamento;
    }
    
    
    
    
}
