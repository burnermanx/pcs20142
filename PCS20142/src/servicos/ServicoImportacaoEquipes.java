/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.DAOCampeonato;
import dominio.Campeonato;
import java.io.*;

/**
 *
 * @author Burner
 */
public class ServicoImportacaoEquipes extends ServicoImportacaoDados {

    Campeonato campeonato;

    public ServicoImportacaoEquipes(DAOCampeonato daoCampeonato) {
        super(daoCampeonato);
        campeonato = daoCampeonato.getCampeonato();
    }

    public void importarEquipes(String file) {
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "Cp1252"));
                int ano = Integer.parseInt(reader.readLine());
                campeonato.setAno(ano);
                while (reader.ready()) {
                    String linha = reader.readLine();
                    //System.out.println(linha);
                    String[] times = new String[2];
                    times = linha.split("[(]");
                    //System.out.println("Time: " + times[0]);
                    if (times.length >= 2) {
                        campeonato.inserirEquipe(times[0], "L");
                    } else {
                        campeonato.inserirEquipe(times[0]);
                    }
                }
                daoCampeonato.salvarAlteracoes();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso do arquivo de equipes." + e.getMessage());
        }
    }

}
