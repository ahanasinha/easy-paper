import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewu")
public class ViewUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("AdminDash.html").include(request, response);
        out.println("<body><center>");

        List<Users> list = UserDao.getAllUsers();
        int i=1;
        out.print("<h2>List of Users</h2><table id='TABLE'");
        out.print("<tr><th>Email id</th><th>Name</th><th>Mobile No</th><th>Role</th></tr>");
        for (Users u : list) {
            out.print("<tr><td>" + u.getEmail() + "</td><td>" + u.getName() + "</td><td>" + u.getMobile() + "</td><td>"
                    + u.getRole() + "</td> </tr>");
                    i++;

        }
        out.print("</table></center></body>");
        out.close();
    }
}