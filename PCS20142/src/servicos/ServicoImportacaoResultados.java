/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.DAOCampeonato;
import dominio.Campeonato;
import dominio.Equipe;
import dominio.Jogo;
import dominio.Rodada;
import dominio.Turno;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Burner
 */
public class ServicoImportacaoResultados extends ServicoImportacaoDados {
    Campeonato campeonato;
    
    public ServicoImportacaoResultados(DAOCampeonato daoCampeonato) {
        super(daoCampeonato);
        campeonato = daoCampeonato.getCampeonato();
    }
    
    
    public void importarResultados(String file) {
        BufferedReader reader = null;
        Rodada rodada = null;
        Turno turno;
        Jogo jogo;
        Equipe mandante;
        Equipe visitante; 
        
        try {
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"Cp1252"));
                String readRodada = reader.readLine();
                String[] numeroRodada = readRodada.split(" ");
                int numRodada = Integer.parseInt(numeroRodada[1]);
                
                //Inserindo turnos e rodadas
                if (numRodada < 20) {
                    if (!campeonato.verificarTurno(1))
                        campeonato.inserirTurno(1);
                    turno = campeonato.obterTurno(1);
                    rodada = turno.obterRodada(numRodada);
                } else if (numRodada >= 20) {
                    if (!campeonato.verificarTurno(2))
                        campeonato.inserirTurno(2);
                    turno = campeonato.obterTurno(2);
                    rodada = turno.obterRodada(numRodada);
                }
                //Inserindo resultado
                while (reader.ready()) {
                    String linha = reader.readLine();
                    System.out.println(linha);
                    String[] times = linha.split("\\s\\d+[x]\\d+\\s");
                    Pattern pat = Pattern.compile("(\\d+)[x](\\d+)");
                    Matcher mat = pat.matcher(linha);
                    String placar="";
                    while (mat.find()) 
                        placar = mat.group();
                    String[] placarSplit = placar.split("[x]");
                    String strMandante = times[0];
                    String strVisitante = times[1];
                    int scrMandante = Integer.parseInt(placarSplit[0]);
                    int scrVisitante = Integer.parseInt(placarSplit[1]);
                    mandante = campeonato.buscaEquipe(strMandante);
                    visitante = campeonato.buscaEquipe(strVisitante);
                    mandante.apagaPerformance();
                    visitante.apagaPerformance();
                    rodada.insereJogo(scrMandante, scrVisitante, mandante, visitante);
                }
                campeonato.recalcularPerfomance();
                daoCampeonato.salvarAlteracoes();
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso no arquivo de resultados." + e.getMessage());
        }
    }
}
