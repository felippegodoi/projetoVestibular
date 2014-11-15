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
public class Funcionario extends Pessoa{
    private Integer idFuncionario;
    private String matriculaFuncionario;
    private String loginFuncionario;
    private String senhaFuncionario;
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario, String matriculaFuncionario, String loginFuncionario, String senhaFuncionario, Cargo cargo) {
        this.idFuncionario = idFuncionario;
        this.matriculaFuncionario = matriculaFuncionario;
        this.loginFuncionario = loginFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.cargo = cargo;
    }

    public Funcionario(Integer idFuncionario, String matriculaFuncionario, String loginFuncionario, String senhaFuncionario, Cargo cargo, Integer idPessoa, String nomePessoa, String cpfPessoa, String rgPessoa, String enderecoPessoa, String numeroEnderecoPessoa, String bairroEnderecoPessoa, String motivoPessoa, Date dataFimPessoa, String observacaoPessoa, Email email, Cep cep, Cidade cidade, Telefone telefone) {
        super(idPessoa, nomePessoa, cpfPessoa, rgPessoa, enderecoPessoa, numeroEnderecoPessoa, bairroEnderecoPessoa, motivoPessoa, dataFimPessoa, observacaoPessoa, email, cep, cidade, telefone);
        this.idFuncionario = idFuncionario;
        this.matriculaFuncionario = matriculaFuncionario;
        this.loginFuncionario = loginFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.cargo = cargo;
    }

    /**
     * @return the idFuncionario
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the matriculaFuncionario
     */
    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    /**
     * @param matriculaFuncionario the matriculaFuncionario to set
     */
    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    /**
     * @return the loginFuncionario
     */
    public String getLoginFuncionario() {
        return loginFuncionario;
    }

    /**
     * @param loginFuncionario the loginFuncionario to set
     */
    public void setLoginFuncionario(String loginFuncionario) {
        this.loginFuncionario = loginFuncionario;
    }

    /**
     * @return the senhaFuncionario
     */
    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    /**
     * @param senhaFuncionario the senhaFuncionario to set
     */
    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    /**
     * @return the cargo
     */
    public Cargo getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
    
}
