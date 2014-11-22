/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dominio.Campeonato;
import dominio.Equipe;
import dominio.Jogo;
import dominio.Rodada;
import dominio.Turno;
import java.beans.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Burner
 */
public class DAOCampeonato {
    private static final String BASE_DADOS = "BRASILEIRO.xml";
    private Campeonato campeonato = new Campeonato();

    public DAOCampeonato() {
        File arquivoXML = new File(BASE_DADOS);
        if (arquivoXML.exists()){
            lerArquivoXML();
        } else {
            carregarEquipes();
        }
    }
    
    private void carregarEquipes(){
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new FileReader("Equipes.txt"));
                String ano = reader.readLine();
                
                while (reader.ready()) {
                    String linha = reader.readLine();
                    System.out.println(linha);
                    String[] times = linha.split("[(]");
                    System.out.println("Time: " + times[0]);
                    if (times.length >= 2)
                        campeonato.inserirEquipe(times[0], "L");
                    else
                        campeonato.inserirEquipe(times[0]);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso." + e.getMessage());
        }
    }
    
    public void carregarRodada() {
        BufferedReader reader = null;
        Rodada rodada = null;
        Turno turno;
        Jogo jogo;
        Equipe mandante;
        Equipe visitante; 
        
        try {
            try {
                reader = new BufferedReader(new FileReader("teste.txt"));
                String readRodada = reader.readLine();
                String[] numeroRodada = readRodada.split(" ");
                int numRodada = Integer.parseInt(numeroRodada[1]);
                
                //Inserindo turnos e rodadas
                if (Integer.getInteger(numeroRodada[1]) < 20) {
                    if (!campeonato.verificarTurno(1))
                        campeonato.inserirTurno(1);
                    turno = campeonato.obterTurno(1);
                    if (!turno.verificarRodada(numRodada))
                        turno.inserirRodada(numRodada);
                    rodada = turno.obterRodada(numRodada);
                } else if (Integer.getInteger(numeroRodada[1]) >= 20) {
                    if (!campeonato.verificarTurno(2))
                        campeonato.inserirTurno(2);
                    turno = campeonato.obterTurno(2);
                    if (!turno.verificarRodada(numRodada))
                        turno.inserirRodada(numRodada);
                    rodada = turno.obterRodada(numRodada);
                }
                
                while (reader.ready()) {
                    String linha = reader.readLine();
                    System.out.println(linha);
                    String[] times = linha.split("\\s\\d+[X]\\d+\\s");
                    String[] valores = linha.split("\\D+");
                    int tamanho = valores.length;
                    System.out.println("Mandante: " + times[0]);
                    System.out.println("Visitante: " + times[1]);
                    System.out.println("Gols do mandante: " + valores[tamanho - 2]);
                    System.out.println("Gols do visitante: " + valores[tamanho - 1]);
                    String strMandante = times[0];
                    String strVisitante = times[1];
                    int scrMandante = Integer.parseInt(valores[tamanho - 2]);
                    int scrVisitante = Integer.parseInt(valores[tamanho - 1]);
                    mandante = campeonato.buscaEquipe(strMandante);
                    visitante = campeonato.buscaEquipe(strVisitante);
                    rodada.insereJogo(scrMandante, scrVisitante, mandante, visitante);
                }
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso." + e.getMessage());
        }
    }
    

    private void gerarArquivoXML() {
        XMLEncoder writer = null;
        try {
            try {
                writer = new XMLEncoder(
                    new FileOutputStream(BASE_DADOS));
                    //writer.writeObject(contas); Aqui escreveremos a estrutura de dados toda
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso ao arquivo." + e.getMessage());
        }
    }

    private void lerArquivoXML() {
        XMLDecoder reader = null;
        try {
            try {
                reader = new XMLDecoder(
                    new FileInputStream(BASE_DADOS));
                    //contas = (Map<String, Conta>) reader.readObject(); Aqui a estrutura será importada ao iniciar            
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso ao arquivo." + e.getMessage());
        }
    }   
}
