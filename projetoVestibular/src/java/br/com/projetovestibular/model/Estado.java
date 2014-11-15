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
public class Estado {
    private Integer idEstado;
    private String nomeEstado;
    private String nomeUf;

    public Estado() {
    }

    public Estado(Integer idEstado, String nomeEstado, String nomeUf) {
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.nomeUf = nomeUf;
    }

    /**
     * @return the idEstado
     */
    public Integer getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the nomeEstado
     */
    public String getNomeEstado() {
        return nomeEstado;
    }

    /**
     * @param nomeEstado the nomeEstado to set
     */
    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    /**
     * @return the nomeUf
     */
    public String getNomeUf() {
        return nomeUf;
    }

    /**
     * @param nomeUf the nomeUf to set
     */
    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }
    
    
}
