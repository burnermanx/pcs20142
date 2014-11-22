/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dominio.Campeonato;
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
                reader.readLine();
                while (reader.ready()) {
                    String linha = reader.readLine();
                    System.out.println(linha);
                    String[] times = linha.split("(");
                    System.out.println("Time: " + times[0]);
                    if (times.length >= 2)
                        System.out.println("Está na Libertadores");
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
        try {
            try {
                reader = new BufferedReader(new FileReader("teste.txt"));
                String rodada = reader.readLine();
                String[] numeroRodada = rodada.split(" ");
                System.out.println("O número da rodada é: " + numeroRodada[1]);
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
