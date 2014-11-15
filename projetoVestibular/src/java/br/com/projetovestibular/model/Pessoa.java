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
public class Pessoa {
    private Integer idPessoa;
    private String nomePessoa;
    private String cpfPessoa;
    private String rgPessoa;
    private String enderecoPessoa;
    private String numeroEnderecoPessoa;
    private String bairroEnderecoPessoa;
    private String motivoPessoa;
    private Date dataFimPessoa;
    private String observacaoPessoa;
    private Email email;
    private Cep cep;
    private Cidade cidade;
    private Telefone telefone;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nomePessoa, String cpfPessoa, String rgPessoa, String enderecoPessoa, String numeroEnderecoPessoa, String bairroEnderecoPessoa, String motivoPessoa, Date dataFimPessoa, String observacaoPessoa, Email email, Cep cep, Cidade cidade, Telefone telefone) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.rgPessoa = rgPessoa;
        this.enderecoPessoa = enderecoPessoa;
        this.numeroEnderecoPessoa = numeroEnderecoPessoa;
        this.bairroEnderecoPessoa = bairroEnderecoPessoa;
        this.motivoPessoa = motivoPessoa;
        this.dataFimPessoa = dataFimPessoa;
        this.observacaoPessoa = observacaoPessoa;
        this.email = email;
        this.cep = cep;
        this.cidade = cidade;
        this.telefone = telefone;
    }

    /**
     * @return the idPessoa
     */
    public Integer getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the nomePessoa
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     * @param nomePessoa the nomePessoa to set
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     * @return the cpfPessoa
     */
    public String getCpfPessoa() {
        return cpfPessoa;
    }

    /**
     * @param cpfPessoa the cpfPessoa to set
     */
    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    /**
     * @return the rgPessoa
     */
    public String getRgPessoa() {
        return rgPessoa;
    }

    /**
     * @param rgPessoa the rgPessoa to set
     */
    public void setRgPessoa(String rgPessoa) {
        this.rgPessoa = rgPessoa;
    }

    /**
     * @return the enderecoPessoa
     */
    public String getEnderecoPessoa() {
        return enderecoPessoa;
    }

    /**
     * @param enderecoPessoa the enderecoPessoa to set
     */
    public void setEnderecoPessoa(String enderecoPessoa) {
        this.enderecoPessoa = enderecoPessoa;
    }

    /**
     * @return the numeroEnderecoPessoa
     */
    public String getNumeroEnderecoPessoa() {
        return numeroEnderecoPessoa;
    }

    /**
     * @param numeroEnderecoPessoa the numeroEnderecoPessoa to set
     */
    public void setNumeroEnderecoPessoa(String numeroEnderecoPessoa) {
        this.numeroEnderecoPessoa = numeroEnderecoPessoa;
    }

    /**
     * @return the bairroEnderecoPessoa
     */
    public String getBairroEnderecoPessoa() {
        return bairroEnderecoPessoa;
    }

    /**
     * @param bairroEnderecoPessoa the bairroEnderecoPessoa to set
     */
    public void setBairroEnderecoPessoa(String bairroEnderecoPessoa) {
        this.bairroEnderecoPessoa = bairroEnderecoPessoa;
    }

    /**
     * @return the motivoPessoa
     */
    public String getMotivoPessoa() {
        return motivoPessoa;
    }

    /**
     * @param motivoPessoa the motivoPessoa to set
     */
    public void setMotivoPessoa(String motivoPessoa) {
        this.motivoPessoa = motivoPessoa;
    }

    /**
     * @return the dataFimPessoa
     */
    public Date getDataFimPessoa() {
        return dataFimPessoa;
    }

    /**
     * @param dataFimPessoa the dataFimPessoa to set
     */
    public void setDataFimPessoa(Date dataFimPessoa) {
        this.dataFimPessoa = dataFimPessoa;
    }

    /**
     * @return the observacaoPessoa
     */
    public String getObservacaoPessoa() {
        return observacaoPessoa;
    }

    /**
     * @param observacaoPessoa the observacaoPessoa to set
     */
    public void setObservacaoPessoa(String observacaoPessoa) {
        this.observacaoPessoa = observacaoPessoa;
    }

    /**
     * @return the email
     */
    public Email getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * @return the cep
     */
    public Cep getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(Cep cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the telefone
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    
}
