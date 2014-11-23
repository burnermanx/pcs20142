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
public class Turno {
    private int numero;
    private Map<Integer, Rodada>rodadas = new HashMap<Integer, Rodada>();

    public Turno() {
    }
    
    public Turno(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    
    public void inserirRodada(int numRodada) {
        Rodada rodada = new Rodada(numRodada);
        rodadas.put(numRodada, rodada);
    }
    
    public boolean verificarRodada(int numRodada) {
        if (rodadas.get(numRodada).equals(null))
            return false;
        return true;
    }
    
    public Rodada obterRodada(int numRodada) {
        if (rodadas.get(numRodada) == null)
            inserirRodada(numRodada);
        return rodadas.get(numRodada);
    }

    public Map<Integer, Rodada> getRodadas() {
        return rodadas;
    }

    public void setRodadas(Map<Integer, Rodada> rodadas) {
        this.rodadas = rodadas;
    }
    
    
}
