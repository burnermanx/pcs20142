/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author Burner
 */
public class Campeonato {
    private int ano;
    private List<Turno> turnos = new ArrayList<Turno>();
    private List<Equipe> equipes = new ArrayList<Equipe>();
    
    public Campeonato() {
        
    }
    
    public void inserirEquipe(String nome) {
        Equipe equipe = new Equipe(nome);
        equipes.add(equipe);
    }
    
    public void inserirEquipe(String nome, String identificador) {
        Equipe equipe = new Equipe(nome, identificador);
        equipes.add(equipe);
    }
    
    public void inserirTurno(int numTurno) {
        Turno turno = new Turno(numTurno);
        turnos.add(turno);
    }
    
    public boolean verificarTurno(int numTurno) {
        if (turnos.size() >= numTurno)
            return true;
        return false;
    }
    
    public Turno obterTurno(int numTurno) {
        return turnos.get(numTurno-1);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
    
    
    
    public Equipe buscaEquipe(String nome) {
        for (Equipe busca : equipes) {
            if (nome.equals(busca.getNome()))
                return busca;
        }
        return null;
    }
    
    public void recalcularPerfomance() {
        for (Turno turno : turnos) {
            Map<Integer, Rodada> rodadas = turno.getRodadas();
            for (Entry<Integer, Rodada> entry : rodadas.entrySet()) {
                Integer key = entry.getKey();
                Rodada rodada = entry.getValue();
                for (Jogo jogo : rodada.getJogos()) {
                    jogo.inserirResultado();
                }
            }
        }
    }
    
}
