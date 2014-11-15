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
public class Cargo {
    private Integer idCargo;
    private String nomeCargo;

    public Cargo() {
    }

    public Cargo(Integer idCargo, String nomeCargo) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
    }

    /**
     * @return the idCargo
     */
    public Integer getIdCargo() {
        return idCargo;
    }

    /**
     * @param idCargo the idCargo to set
     */
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    /**
     * @return the nomeCargo
     */
    public String getNomeCargo() {
        return nomeCargo;
    }

    /**
     * @param nomeCargo the nomeCargo to set
     */
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

 
}
