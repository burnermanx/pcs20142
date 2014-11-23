/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.DAOCampeonato;

/**
 *
 * @author Burner
 */
abstract class ServicoImportacaoDados {
    DAOCampeonato daoCampeonato;

    public ServicoImportacaoDados(DAOCampeonato daoCampeonato) {
        this.daoCampeonato = daoCampeonato;
    }
    
}
