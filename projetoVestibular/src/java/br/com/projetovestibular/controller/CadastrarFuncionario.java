/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.controller;

import br.com.projetovestibular.DAO.CandidatoDAOImpl;
import br.com.projetovestibular.DAO.FuncionarioDAOImpl;
import br.com.projetovestibular.DAO.GenericDAO;
import br.com.projetovestibular.model.Candidato;
import br.com.projetovestibular.model.Cargo;
import br.com.projetovestibular.model.Cep;
import br.com.projetovestibular.model.Cidade;
import br.com.projetovestibular.model.Email;
import br.com.projetovestibular.model.Funcionario;
import br.com.projetovestibular.model.Telefone;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Felippe
 */
public class CadastrarFuncionario extends HttpServlet {

    public Date converterData(String data) throws ParseException{
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        if(data != null || !data.trim().equals("")){
            Date date = fmt.parse(data);
            return date;
        }else{
            return null;
        }
    }    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String mensagem = null;   
        Funcionario funcionario = new Funcionario();
        Email email = new Email();
        Cep cep = new Cep();
        Cidade cidade = new Cidade();
        Telefone telefone = new Telefone();
        Cargo cargo = new Cargo();
        
        funcionario.setNomePessoa(request.getParameter("nomefuncionario"));
        funcionario.setRgPessoa(request.getParameter("rgfuncionario"));
        funcionario.setCpfPessoa(request.getParameter("cpffuncionario"));
        funcionario.setEnderecoPessoa(request.getParameter("enderecofuncionario"));
        funcionario.setNumeroEnderecoPessoa(request.getParameter("numeroenderecofuncionario"));
        funcionario.setBairroEnderecoPessoa(request.getParameter("bairroenderecofuncionario"));
        funcionario.setMotivoPessoa(request.getParameter("motivopessoa"));
        funcionario.setDataFimPessoa(converterData(request.getParameter("datafimfuncionario").replace("-", "/")));
        funcionario.setObservacaoPessoa(request.getParameter("observacaofuncionario"));
        email.setNomeEmail(request.getParameter("emailfuncionario"));
        cep.setNomeCep(request.getParameter("cepfuncionario"));
        cidade.setIdCidade(Integer.parseInt(request.getParameter("cidadefuncionario")));
        funcionario.setCidade(cidade);
        telefone.setNumeroTelefone(request.getParameter("telefonefuncionario"));
        funcionario.setMatriculaFuncionario(request.getParameter("matriculafuncionario"));
        funcionario.setLoginFuncionario(request.getParameter("loginfuncionario"));
        funcionario.setSenhaFuncionario(request.getParameter("senhafuncionario"));
        cargo.setNomeCargo(request.getParameter("cargofuncionario"));
        funcionario.setCargo(cargo);
        
        
        try{
            GenericDAO dao = new FuncionarioDAOImpl();
            if(dao.cadastrar(funcionario)){
                mensagem = "Funcionario cadastrado com sucesso!";
            }else{
                mensagem = "Problemas ao cadastrar o Funcionario";
            }
            request.setAttribute("mensagem",mensagem);
            request.getRequestDispatcher("DadosFuncionario").forward(request,response);
        }catch(Exception ex){
            System.out.println("Problemas na controller ao cadastrar Funcionario! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
