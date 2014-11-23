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
public class Jogo {

    private int scoreMandante;
    private int scoreVisitante;
    private Equipe equipeMandante;
    private Equipe equipeVisitante;

    public Jogo(int scoreMandante, int scoreVisitante, Equipe equipeMandante, Equipe equipeVisitante) {
        this.scoreMandante = scoreMandante;
        this.scoreVisitante = scoreVisitante;
        this.equipeMandante = equipeMandante;
        this.equipeVisitante = equipeVisitante;
    }
    
    public Jogo(Equipe equipeMandante, Equipe equipeVisitante) {
        this.equipeMandante = equipeMandante;
        this.equipeVisitante = equipeVisitante;
    }

    public Jogo() {

    }

    public int getScoreMandante() {
        return scoreMandante;
    }

    public void setScoreMandante(int scoreMandante) {
        this.scoreMandante = scoreMandante;
    }

    public int getScoreVisitante() {
        return scoreVisitante;
    }

    public void setScoreVisitante(int scoreVisitante) {
        this.scoreVisitante = scoreVisitante;
    }

    public Equipe getEquipeMandante() {
        return equipeMandante;
    }

    public void setEquipeMandante(Equipe equipeMandante) {
        this.equipeMandante = equipeMandante;
    }

    public Equipe getEquipeVisitante() {
        return equipeVisitante;
    }

    public void setEquipeVisitante(Equipe equipeVisitante) {
        this.equipeVisitante = equipeVisitante;
    }
    
    

    public void inserirResultado() {
        if (scoreMandante > scoreVisitante) {
            equipeMandante.inserirResultado("v", scoreMandante, scoreVisitante);
            equipeVisitante.inserirResultado("d", scoreVisitante, scoreMandante);
        } else if (scoreMandante == scoreVisitante) {
            equipeMandante.inserirResultado("e", scoreMandante, scoreVisitante);
            equipeVisitante.inserirResultado("e", scoreVisitante, scoreMandante);
        } else if (scoreVisitante > scoreMandante) {
            equipeMandante.inserirResultado("d", scoreMandante, scoreVisitante);
            equipeVisitante.inserirResultado("v", scoreVisitante, scoreMandante);
        }
    }

}
