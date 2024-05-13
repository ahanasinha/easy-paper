import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userd")
public class UserDash extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("UserDash.html").include(request, response);
        out.println("<body><center>");

        List<Papers> list = PaperDao.getAllPapers();
        int i=1;
        out.print("<h2>List of Papers</h2><table id='TABLE' width='85%'");
        out.print("<tr><th>Paper id</th><th>Title</th><th>Category</th><th>Name</th><th>Address</th><th>Mobile</th>"
                + "<th>Email</th><th>Paper</th><th>Status</th></tr>");
        for (Papers p : list) {
            out.print("<tr><td>" + p.getId() + "</td><td>" + p.getTitle() + "</td><td>" + p.getCategory() + "</td><td>"
                    + p.getName() + "</td><td>" + p.getAddress() + "</td><td>" + p.getMobile() + "</td><td>"
                    + p.getEmail() + "</td> <td>" + p.getPaper() + "</td> </tr>");
                    i++;

        }
        out.print("</table></center></body>");
        out.close();
    }
}