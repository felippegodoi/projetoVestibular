<%-- 
    Document   : cadastrarcargo
    Created on : 11/12/2014, 22:04:35
    Author     : Felippe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>JSP Page</title>
    </head>
    <body>
        <form name="frmCadastrarCargo" action="CadastrarCargo" method="POST">
            <label>Cargo: </label>
                <input type="text" name="nomecargo" value="" /><br/>
            
                <input type="submit" title="Cadastrar"/>
                <input type="reset" title="Limpar"/>    
                
                ${mensagem}
        </form>
    </body>
</html>
