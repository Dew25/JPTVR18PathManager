/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.UserFacade;
import session.UserRolesFacade;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "AdminController", urlPatterns = {
    "/showListUsers",
    
})
public class AdminController extends HttpServlet {
 @EJB
    private UserRolesFacade userRolesFacade;
 @EJB
    private UserFacade userFacade;
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
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет прав для этого ресурса. Авторизуйтесь");
            request.getRequestDispatcher("/showFormLogin")
                .forward(request, response);
        }
        User user = (User) session.getAttribute("user");
        //UserManager userManager = new UserManager();
        if(!userRolesFacade.checkRole(user,"ADMIN")){
            request.setAttribute("info", "У вас нет прав для этого ресурса. Авторизуйтесь");
            request.getRequestDispatcher("/showFormLogin")
                .forward(request, response);
        }
        
        String path = request.getServletPath();
        switch (path) {
            case "/showListUsers":
                Map<User,String> usersMap = new HashMap<>();
                List<User> listUsers = userFacade.findAll();
                for (int i = 0; i < listUsers.size(); i++) {
                    User userForMap = listUsers.get(i);
                    String topRoleUserForMap = userRolesFacade.getTopRoleName(userForMap);
                    usersMap.put(userForMap, topRoleUserForMap);
                }
                request.setAttribute("usersMap", usersMap);
                
                request.getRequestDispatcher("/admin/showListUsers.jsp")
                        .forward(request, response);
                break;
            
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
