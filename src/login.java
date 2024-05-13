import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")  
public class login extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String user=request.getParameter("username");  
        String pw=request.getParameter("password");  
                  
        String role=UserDao.loginUser(user,pw);  
        
        if(role.equals("user"))
            request.getRequestDispatcher("UserDash.html").forward(request, response);
        else if(role.equals("admin"))
            request.getRequestDispatcher("AdminDash.html").forward(request, response);
        else{
            out.print("<center><h1>Incorrect Details<br>Retry!</h1></center>"); 
            out.print("<center><a href='index.html'><div class='btn' style='width: 10%;'>Okay</div></a></center>"); 
            request.getRequestDispatcher("message.html").include(request, response);  
        }  
    }  
  
}  