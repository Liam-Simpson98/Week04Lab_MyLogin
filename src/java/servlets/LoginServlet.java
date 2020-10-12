package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
        HttpSession session = request.getSession();
        
        
        if (request.getParameter("logout") != null) {
            
            session.invalidate();
            request.setAttribute("logoutMessage", "User Logged Out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        }
        
        else if (session.getAttribute("username") != null) {
        
            response.sendRedirect("home");
        }
        
        else {
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username, password;
        username = request.getParameter("username");
        password = request.getParameter("password");
        
        AccountService as = new AccountService();
        
        if (as.login(username, password) == null) {
        
            request.setAttribute("invalidMessage", "Invalid Login!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        
        } else {
            
           session.setAttribute("username", username);
           
           response.sendRedirect("home");
            
        } 
    }
}
