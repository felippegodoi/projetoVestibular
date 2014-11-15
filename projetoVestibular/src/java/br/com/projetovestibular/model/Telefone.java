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
public class Telefone {
    private Integer idTelefone;
    private String numeroTelefone;
    private Date dataFimTelefone;
    private String motivoTelefone;

    public Telefone() {
    }

    public Telefone(Integer idTelefone, String numeroTelefone, Date dataFimTelefone, String motivoTelefone) {
        this.idTelefone = idTelefone;
        this.numeroTelefone = numeroTelefone;
        this.dataFimTelefone = dataFimTelefone;
        this.motivoTelefone = motivoTelefone;
    }

    /**
     * @return the idTelefone
     */
    public Integer getIdTelefone() {
        return idTelefone;
    }

    /**
     * @param idTelefone the idTelefone to set
     */
    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    /**
     * @return the numeroTelefone
     */
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    /**
     * @param numeroTelefone the numeroTelefone to set
     */
    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    /**
     * @return the dataFimTelefone
     */
    public Date getDataFimTelefone() {
        return dataFimTelefone;
    }

    /**
     * @param dataFimTelefone the dataFimTelefone to set
     */
    public void setDataFimTelefone(Date dataFimTelefone) {
        this.dataFimTelefone = dataFimTelefone;
    }

    /**
     * @return the motivoTelefone
     */
    public String getMotivoTelefone() {
        return motivoTelefone;
    }

    /**
     * @param motivoTelefone the motivoTelefone to set
     */
    public void setMotivoTelefone(String motivoTelefone) {
        this.motivoTelefone = motivoTelefone;
    }
    
    
}
