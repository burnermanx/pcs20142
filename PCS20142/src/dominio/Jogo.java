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
        inserirResultado();
    }

    public Jogo() {

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
