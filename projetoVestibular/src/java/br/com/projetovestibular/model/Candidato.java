/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.model;

import java.util.Date;

/**
 *
 * @author Felippe
 */
public class Candidato extends Pessoa{
    private Integer idCandidato;
    private String statusCandidato;
    private String motivoCandidato;

    public Candidato() {
    }

    public Candidato(Integer idCandidato, String statusCandidato, String motivoCandidato) {
        this.idCandidato = idCandidato;
        this.statusCandidato = statusCandidato;
        this.motivoCandidato = motivoCandidato;
    }

    public Candidato(Integer idCandidato, String statusCandidato, String motivoCandidato, Integer idPessoa, String nomePessoa, String cpfPessoa, String rgPessoa, String enderecoPessoa, String numeroEnderecoPessoa, String bairroEnderecoPessoa, String motivoPessoa, Date dataFimPessoa, String observacaoPessoa, Cidade cidade) {
        super(idPessoa, nomePessoa, cpfPessoa, rgPessoa, enderecoPessoa, numeroEnderecoPessoa, bairroEnderecoPessoa, motivoPessoa, dataFimPessoa, observacaoPessoa, cidade);
        this.idCandidato = idCandidato;
        this.statusCandidato = statusCandidato;
        this.motivoCandidato = motivoCandidato;
    }
   

    /**
     * @return the idCandidato
     */
    public Integer getIdCandidato() {
        return idCandidato;
    }

    /**
     * @param idCandidato the idCandidato to set
     */
    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    /**
     * @return the statusCandidato
     */
    public String getStatusCandidato() {
        return statusCandidato;
    }

    /**
     * @param statusCandidato the statusCandidato to set
     */
    public void setStatusCandidato(String statusCandidato) {
        this.statusCandidato = statusCandidato;
    }

    /**
     * @return the motivoCandidato
     */
    public String getMotivoCandidato() {
        return motivoCandidato;
    }

    /**
     * @param motivoCandidato the motivoCandidato to set
     */
    public void setMotivoCandidato(String motivoCandidato) {
        this.motivoCandidato = motivoCandidato;
    }
    
    
}
