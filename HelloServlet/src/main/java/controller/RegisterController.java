package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import service.*;
import service.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String REGISTER = "/views/register.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userName") != null) {
            resp.sendRedirect(req.getContextPath() + "/admin");
            return;
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {   // đồng bộ lại userName
                    session = req.getSession(true);
                    session.setAttribute("userName", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/admin");
                    return;
                }
            }
        }
        req.getRequestDispatcher(REGISTER).forward(req, resp);
    }
    @SuppressWarnings("static-access")

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String userName = req.getParameter("userName");
        String _password = req.getParameter("_password");
        String confirmPassword = req.getParameter("confirmPassword");
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullName");
        String phone = req.getParameter("phone");

        UserService service = new UserServiceImpl();
        String alertMsg = "";

        // kiểm tra mật khẩu xác nhận
        if (!_password.equals(confirmPassword)) {
            alertMsg = "Mật khẩu xác nhận không khớp!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        if (service.checkExistEmail(email)) {
            alertMsg = "Email đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        if (service.checkExistUsername(userName)) {
            alertMsg = "Tài khoản đã tồn tại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
            return;
        }

        boolean isSuccess = service.register(userName, _password, email, fullName, phone);
        if (isSuccess) {
            HttpSession session = req.getSession();
            session.setAttribute("successMsg", "Đăng ký thành công, vui lòng đăng nhập!");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "System error!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher(REGISTER).forward(req, resp);
        }
    }
}
