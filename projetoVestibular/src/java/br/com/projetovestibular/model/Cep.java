/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.model;

/**
 *
 * @author Felippe
 */
public class Cep {
    private Integer idCep;
    private String nomeCep;
    private Integer idPessoa;

    public Cep() {
    }

    public Cep(Integer idCep, String nomeCep, Integer idPessoa) {
        this.idCep = idCep;
        this.nomeCep = nomeCep;
        this.idPessoa = idPessoa;
    }

    /**
     * @return the idCep
     */
    public Integer getIdCep() {
        return idCep;
    }

    /**
     * @param idCep the idCep to set
     */
    public void setIdCep(Integer idCep) {
        this.idCep = idCep;
    }

    /**
     * @return the nomeCep
     */
    public String getNomeCep() {
        return nomeCep;
    }

    /**
     * @param nomeCep the nomeCep to set
     */
    public void setNomeCep(String nomeCep) {
        this.nomeCep = nomeCep;
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

   
    
    
}
