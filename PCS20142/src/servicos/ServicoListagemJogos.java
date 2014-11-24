/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import dominio.Campeonato;
import dominio.Jogo;
import dominio.Rodada;
import dominio.Turno;
import java.util.List;

/**
 *
 * @author Burner
 */
public class ServicoListagemJogos {
    Campeonato campeonato;

    public ServicoListagemJogos(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    public List<Jogo> obterJogos(int numRodada) {
        Turno turno;
        Rodada rodada;
        if (numRodada <= 19)
            turno = campeonato.obterTurno(1);
        else
            turno = campeonato.obterTurno(2);
        rodada = turno.obterRodada(numRodada);
        if (rodada == null)
            return null;
        return rodada.getJogos();
    } 
    
    
}
