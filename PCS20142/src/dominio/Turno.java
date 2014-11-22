/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.HashMap;
import java.util.Map;

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
    
    public void inserirRodada(int numRodada) {
        Rodada rodada = new Rodada(numRodada);
        rodadas.put(numRodada, rodada);
    }
    
}
