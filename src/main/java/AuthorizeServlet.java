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
                resp.addCookie(new Cookie("last_login", userDao.getLoginTimestamp(login).toString()));
                resp.addCookie(new Cookie("login_number", Integer.toString(userDao.getLoginNumber(login))));
                req.setAttribute("login", login);
                req.setAttribute("last", userDao.getLoginTimestamp(login));
                req.setAttribute("loginNumber", userDao.getLoginNumber(login)+1);
                getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
            } else {
                writer.println("Access denied");
            }
        } catch (SQLException | ClassNotFoundException | ConnectionException ex) {
            ex.printStackTrace();
        }
    }
}
