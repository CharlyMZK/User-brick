/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.User;
import forms.CreationUserForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;

/**
 *
 * @author MZK
 */
public class CreationUser extends HttpServlet{
    public static final String ATT_USER     = "user";
    public static final String ATT_FORM     = "form"; 
    public static final String VIEW_SUCCESS = "/WEB-INF/showProfil.jsp";
    public static final String VIEW_FORM    = "/WEB-INF/createUser.jsp";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        this.getServletContext().getRequestDispatcher(VIEW_FORM).forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        CreationUserForm form = new CreationUserForm();
        User user = form.createUser(request);
        request.setAttribute(ATT_USER, user);
        request.setAttribute(ATT_FORM, form);
        if(form.getErrors().isEmpty()){
            HttpSession session = request.getSession();
            session.setAttribute(ATT_USER, user);
            this.getServletContext().getRequestDispatcher(VIEW_SUCCESS).forward(request, response);
        }else{
            this.getServletContext().getRequestDispatcher(VIEW_FORM).forward(request, response);
        }
    }
}
 