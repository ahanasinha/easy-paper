import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/paper")  
public class SavePaper extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String title=request.getParameter("title");
        String category=request.getParameter("category");
        String name=request.getParameter("author");  
        String address=request.getParameter("address");  
        String mobile=request.getParameter("number");   
        String email=request.getParameter("email");   
        String paper=request.getParameter("paper");  
                  
       Papers p=new Papers();

        p.setTitle(title);
        p.setCategory(category);
        p.setName(name);
        p.setAddress(address);
        p.setMobile(mobile);
        p.setEmail(email);
        p.setPaper(paper);
               
        int status=PaperDao.save(p);  
        if(status>0){  
            out.print("<center><h1>Paper Uploaded successfully!</h1></center>");  
            out.print("<center><a href='user.html'><div class='btn' style='width: 10%;'>Okay</div></a></center>");
            request.getRequestDispatcher("message.html").include(request, response);  
        }else{  
            out.print("<center><h1>Paper could not be uploaded!</h1></center>"); 
            out.print("<center><a href='user.html'><div class='btn' style='width: 10%;'>Okay</div></a></center>"); 
            request.getRequestDispatcher("message.html").include(request, response);  
        }  
          
        out.close();  
    }  
}  