/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Felippe
 */
public class Contato {
    private Integer idContato;
    private Date dataContato;
    private Time horaContato;
    private String assuntoContato;
    private Funcionario funcionario;
    private Candidato candidato;

    public Contato() {
    }

    public Contato(Integer idContato, Date dataContato, Time horaContato, String assuntoContato, Funcionario funcionario, Candidato candidato) {
        this.idContato = idContato;
        this.dataContato = dataContato;
        this.horaContato = horaContato;
        this.assuntoContato = assuntoContato;
        this.funcionario = funcionario;
        this.candidato = candidato;
    }

    /**
     * @return the idContato
     */
    public Integer getIdContato() {
        return idContato;
    }

    /**
     * @param idContato the idContato to set
     */
    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    /**
     * @return the dataContato
     */
    public Date getDataContato() {
        return dataContato;
    }

    /**
     * @param dataContato the dataContato to set
     */
    public void setDataContato(Date dataContato) {
        this.dataContato = dataContato;
    }

    /**
     * @return the horaContato
     */
    public Time getHoraContato() {
        return horaContato;
    }

    /**
     * @param horaContato the horaContato to set
     */
    public void setHoraContato(Time horaContato) {
        this.horaContato = horaContato;
    }

    /**
     * @return the assuntoContato
     */
    public String getAssuntoContato() {
        return assuntoContato;
    }

    /**
     * @param assuntoContato the assuntoContato to set
     */
    public void setAssuntoContato(String assuntoContato) {
        this.assuntoContato = assuntoContato;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the candidato
     */
    public Candidato getCandidato() {
        return candidato;
    }

    /**
     * @param candidato the candidato to set
     */
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    
}
