import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Register")  
public class SaveUser extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String email=request.getParameter("email");  
        String name=request.getParameter("name");  
        String mobile=request.getParameter("number");       
        String role=request.getParameter("role");  
        String pw=request.getParameter("password");  
        String cpw=request.getParameter("cpassword");  
                  
       Users u=new Users();  
    //    Users x = request.toObject(Users.class);

        u.setEmail(email); 
        u.setName(name);  
        u.setMobile(mobile);
        u.setRole(role); 
        u.setPw(pw); 
        u.setCpw(cpw); 
               
        int status=UserDao.save(u);  
        if(status>0){  
            out.print("<center><h1>User Added successfully!</h1><h2>Login to continue</h2></center>");  
            out.print("<center><a href='index.html'><div class='btn' style='width: 10%;'>Okay</div></a></center>");
            request.getRequestDispatcher("message.html").include(request, response);  
        }else{  
            out.print("<center><h1>User could not be added!<br>Try Again!</h1></center>"); 
            out.print("<center><a href='index.html'><div class='btn' style='width: 10%;'>Okay</div></a></center>"); 
            request.getRequestDispatcher("message.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  