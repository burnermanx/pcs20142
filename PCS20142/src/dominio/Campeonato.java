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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
