/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import dominio.Campeonato;
import java.beans.*;
import java.io.*;

/**
 *
 * @author Burner
 */
public class DAOCampeonato {
    private static final String BASE_DADOS = "BRASILEIRO.xml";
    private Campeonato campeonato = new Campeonato();
    private File arquivoXML;
    
    public DAOCampeonato() {
        arquivoXML = new File(BASE_DADOS);
        if (arquivoXML.exists())
            lerArquivoXML();
    }
    
    private void gerarArquivoXML() {
        XMLEncoder writer = null;
        try {
            try {
                writer = new XMLEncoder(
                    new FileOutputStream(BASE_DADOS));
                    writer.writeObject(this.campeonato); //Aqui escreveremos a estrutura de dados toda
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso ao arquivo." + e.getMessage());
        }
    }
    
    public boolean fileExists() {
        return arquivoXML.exists();
    }

    public void salvarAlteracoes() {
        gerarArquivoXML();
    } 
    
    private void lerArquivoXML() {
        XMLDecoder reader = null;
        try {
            try {
                reader = new XMLDecoder(
                    new FileInputStream(BASE_DADOS));
                    campeonato = (Campeonato) reader.readObject(); //Aqui a estrutura será importada ao iniciar            
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro no acesso ao arquivo." + e.getMessage());
        }
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }
    
    
}
