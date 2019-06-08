import connection.ConnectionException;
import connection.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import com.mysql.jdbc.Driver;

@WebServlet(value = "/login")
public class AuthorizeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        try {
            UserDao userDao = new UserDao();
            if (userDao.checkFor(login, password)) {
                writer.println("<fieldset>\n" +
                        "    <form method=\"POST\" action=\"index.jsp\">\n" +
                        "        <input type=\"submit\" value=\"Exit\"/>\n" +
                        "    </form>\n" +
                        "</fieldset>");
                writer.println("Hello, " + login);
                writer.println("Set to cookies");
                writer.println("Last login: " + userDao.getLoginTimestamp(login)+1);
                writer.println("Login number: " + userDao.getLoginNumber(login)+1);
                writer.println("<table>\n" +
                        "<tr><th>Name</th><th>Tel</th><th>email</th></tr> \n" +
                        "<tr><td>Anna</td><td>80251234567</td><td>anna@mail.ru</td></tr>\n" +
                        "<tr><td>Max</td><td>80253344635</td><td>Max@mail.ru</td></tr>" +
                        "<tr><td>Goga</td><td>80254546563</td><td>Goga@mail.ru</td></tr>" +
                        "<tr><td>Pasha</td><td>80297654321</td><td>Pasha@mail.ru</td></tr>" +
                        "</table>");
                resp.addCookie(new Cookie("last_login", userDao.getLoginTimestamp(login).toString()));
                resp.addCookie(new Cookie("login_number", Integer.toString(userDao.getLoginNumber(login))));
            } else {
                writer.println("Access denied");
            }
        } catch (SQLException | ClassNotFoundException | ConnectionException ex) {
            ex.printStackTrace();
        }
    }
}
