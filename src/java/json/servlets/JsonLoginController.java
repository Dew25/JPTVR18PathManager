/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.servlets;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import json.builders.UserJsonBuilder;
import session.UserFacade;
import session.UserRolesFacade;
import utils.MakeHash;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "JsonLoginController", urlPatterns = {
    "/loginUserJson",
    "/logoutUserJson"
    
    
})
public class JsonLoginController extends HttpServlet {
@EJB private UserFacade userFacade;
@EJB private UserRolesFacade userRolesFacade;

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
        String json = "";
        String path = request.getServletPath();
        switch (path) {
            case "/loginUserJson":
                JsonObject jsonObject = jsonReader.readObject();
                String login = jsonObject.getString("login");
                String password = jsonObject.getString("password");
                if(login == null || login.isEmpty()
                       || password == null || password.isEmpty()
                                ){
                    job.add("info", "Заполните все поля");
                    json = job.build().toString();
                    //json = "{\"info\":\"Заполните все поля\"}";
                    break;
                }
                User user = userFacade.findByLogin(login);
                if(user == null){
                    job.add("info", "Нет такого пользователя или неправильный пароль");
                    json = job.build().toString();
                    break;
                }
                MakeHash mh = new MakeHash();
                password = mh.createHash(password, user.getSalts());
                if(!password.equals(user.getPassword())){
                    job.add("info", "Нет такого пользователя или неправильный пароль");
                    json = job.build().toString();
                    break;
                }
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("user", user);
                String JSESSIONID = httpSession.getId();
                String roleUser = userRolesFacade.getTopRoleName(user);
                UserJsonBuilder ujb = new UserJsonBuilder();
                job.add("data", ujb.createJsonUser(user, JSESSIONID, roleUser));
                json = job.build().toString();
                break;
            case "/logoutUserJson":
                httpSession = request.getSession(false);
                if(httpSession != null){
                    httpSession.invalidate();
                    job.add("info", "Вы вышли");
                    json = job.build().toString();
                }
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
