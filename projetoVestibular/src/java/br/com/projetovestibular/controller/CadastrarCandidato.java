/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.projetovestibular.controller;

import br.com.projetovestibular.DAO.CandidatoDAOImpl;
import br.com.projetovestibular.DAO.GenericDAO;
import br.com.projetovestibular.model.Candidato;
import br.com.projetovestibular.model.Cep;
import br.com.projetovestibular.model.Cidade;
import br.com.projetovestibular.model.Email;
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
public class CadastrarCandidato extends HttpServlet {

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
        Candidato candidato = new Candidato();
        Email email = new Email();
        Cep cep = new Cep();
        Cidade cidade = new Cidade();
        Telefone telefone = new Telefone();
        
        candidato.setNomePessoa(request.getParameter("nomecandidato"));
        candidato.setRgPessoa(request.getParameter("rgcandidato"));
        candidato.setCpfPessoa(request.getParameter("cpfcandidato"));
        candidato.setEnderecoPessoa(request.getParameter("enderecocandidato"));
        candidato.setNumeroEnderecoPessoa(request.getParameter("numeroenderecocandidato"));
        candidato.setBairroEnderecoPessoa(request.getParameter("bairroenderecocandidato"));
        candidato.setMotivoPessoa(request.getParameter("motivopessoa"));
        candidato.setDataFimPessoa(converterData(request.getParameter("datafimcandidato").replace("-", "/")));
        candidato.setObservacaoPessoa(request.getParameter("observacaocandidato"));
        email.setNomeEmail(request.getParameter("emailcandidato"));
        cep.setNomeCep(request.getParameter("cepcandidato"));
        cidade.setIdCidade(Integer.parseInt(request.getParameter("cidadecandidato")));
        candidato.setCidade(cidade);
        telefone.setNumeroTelefone(request.getParameter("telefonecandidato"));
        candidato.setMotivoCandidato(request.getParameter("motivocandidato"));
        candidato.setStatusCandidato(request.getParameter("statuscandidato"));
        
        
        try{
            GenericDAO dao = new CandidatoDAOImpl();
            if(dao.cadastrar(candidato)){
                mensagem = "Candidato cadastrado com sucesso!";
            }else{
                mensagem = "Problemas ao cadastrar o Candidato";
            }
            request.setAttribute("mensagem",mensagem);
            request.getRequestDispatcher("DadosCandidato").forward(request,response);
        }catch(Exception ex){
            System.out.println("Problemas na controller ao cadastrar Candidato! Erro: "+ex.getMessage());
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
            Logger.getLogger(CadastrarCandidato.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarCandidato.class.getName()).log(Level.SEVERE, null, ex);
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
