/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Burner
 */
public class Campeonato {
    private int ano = 2014;
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
    
    
}
