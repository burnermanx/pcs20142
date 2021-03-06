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
public class Equipe {
    private String nome;
    private Performance performance;
    private String identificador;

    public Equipe() {
        
    }
    
    public Equipe(String nome) {
        this.nome = nome;
        this.performance = new Performance();
    }
    
    public Equipe(String nome, String identificador) {
        this.nome = nome;
        this.performance = new Performance();
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public void inserirResultado(String resultado, int gp, int gc) {
        performance.adicionaJogo(resultado, gp, gc);
    }
    
    public void apagaPerformance() {
        performance.apagaPerformance();
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    
}
