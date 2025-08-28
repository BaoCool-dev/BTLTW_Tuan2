package controller;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String SESSION_ACCOUNT = "account";
    public static final String COOKIE_REMEMBER = "COOKIE_REMEMBER";
    public static final String LOGIN = "/views/Login.jsp";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        boolean isRememberMe = "on".equalsIgnoreCase(remember);

        String alertMsg = "";


        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được để trống!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/Login.jsp").forward(req, resp);
            return;
        }


        UserService service = new UserServiceImpl();
        User user = service.login(username, password);

        if (user != null) {
   
            HttpSession session = req.getSession(true);
            session.setAttribute(SESSION_ACCOUNT, user);
            if (isRememberMe) {
                saveRememberMe(resp, user.getUserName());
            }
            //resp.sendRedirect(req.getContextPath() + "/waiting");
            resp.sendRedirect(req.getContextPath() + "/views/main.jsp");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("views/Login.jsp").forward(req, resp);
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("successMsg") != null) {
            req.setAttribute("successMsg", session.getAttribute("successMsg"));
            session.removeAttribute("successMsg");
        }

        req.getRequestDispatcher(LOGIN).forward(req, resp);
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60); 
        cookie.setPath("/");       
        response.addCookie(cookie);
    }
}
