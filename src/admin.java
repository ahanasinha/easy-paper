import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class admin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<link rel='stylesheet' href='style.css'>");
        out.println("<body><center><h1>Papers List</h1>");

        List<Papers> list = PaperDao.getAllPapers();
        int i=1;
        out.print("<table id='TABLE' width='70%");
        out.print("<tr><th>Paper id</th><th>Title</th><th>Category</th><th>Name</th><th>Address</th><th>Mobile</th>"
                + "<th>Email</th><th>Paper</th><th>Edit</th><th>Delete</th></tr>");
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