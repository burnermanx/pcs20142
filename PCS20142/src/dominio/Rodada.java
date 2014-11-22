/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.*;
/**
 *
 * @author Burner
 */
public class Rodada {
    private int numero;
    private List<Jogo> jogos = new ArrayList<Jogo>();

    public Rodada() {
        
    }
    
    public Rodada(int numRodada) {
        this.numero = numRodada;
    }
    
    public void insereJogo(int scrMandante, int scrVisitante, Equipe eqpMandante, Equipe eqpVisitante) {
        Jogo jogo = new Jogo(scrMandante, scrVisitante, eqpMandante, eqpVisitante);
        jogos.add(jogo);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    
    
    
}
