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
public class Email {
    private Integer idEmail;
    private String nomeEmail;
    private Date dataFimEmail;
    private String motivoEmail;
    private Pessoa pessoa;
   

    public Email() {
    }

    public Email(Integer idEmail, String nomeEmail, Date dataFimEmail, String motivoEmail, Pessoa pessoa) {
        this.idEmail = idEmail;
        this.nomeEmail = nomeEmail;
        this.dataFimEmail = dataFimEmail;
        this.motivoEmail = motivoEmail;
        this.pessoa = pessoa;
    }

    /**
     * @return the idEmail
     */
    public Integer getIdEmail() {
        return idEmail;
    }

    /**
     * @param idEmail the idEmail to set
     */
    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    /**
     * @return the nomeEmail
     */
    public String getNomeEmail() {
        return nomeEmail;
    }

    /**
     * @param nomeEmail the nomeEmail to set
     */
    public void setNomeEmail(String nomeEmail) {
        this.nomeEmail = nomeEmail;
    }

    /**
     * @return the dataFimEmail
     */
    public Date getDataFimEmail() {
        return dataFimEmail;
    }

    /**
     * @param dataFimEmail the dataFimEmail to set
     */
    public void setDataFimEmail(Date dataFimEmail) {
        this.dataFimEmail = dataFimEmail;
    }

    /**
     * @return the motivoEmail
     */
    public String getMotivoEmail() {
        return motivoEmail;
    }

    /**
     * @param motivoEmail the motivoEmail to set
     */
    public void setMotivoEmail(String motivoEmail) {
        this.motivoEmail = motivoEmail;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
