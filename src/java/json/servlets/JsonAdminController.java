/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.servlets;

import entity.Role;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import json.builders.RoleJsonBuilder;
import json.builders.UserJsonBuilder;
import session.ResourceFacade;
import session.RoleFacade;
import session.UserFacade;
import session.UserResourcesFacade;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "JsonAdminController", urlPatterns = {
    "/getListUsersJson"
    
})
public class JsonAdminController extends HttpServlet {
@EJB private ResourceFacade resourceFacade;
@EJB private UserFacade userFacade;
@EJB private RoleFacade roleFacade;
@EJB private UserResourcesFacade userResourcesFacade;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        JsonReader jsonReader = Json.createReader(request.getReader());
        JsonObjectBuilder job = Json.createObjectBuilder();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        String json = "";
        String path = request.getServletPath();
        switch (path) {
            case "/getListUsersJson":
                List<User> listUsers = userFacade.findAll();
                for(User user : listUsers){
                    UserJsonBuilder ujb = new UserJsonBuilder();
                    jab.add(ujb.createJsonUser(user));
                }
                job.add("listUsers", jab.build());
                List<Role>listRoles = roleFacade.findAll();
                for(Role role : listRoles){
                    RoleJsonBuilder rjb = new RoleJsonBuilder();
                    jab.add(rjb.createJsonRole(role));
                }
                job.add("listRoles", jab.build());
                json = job.build().toString();
                break;
        }
        if(!"".equals(json)){
            try(PrintWriter out = response.getWriter()){
                out.println(json);
                out.flush();
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
