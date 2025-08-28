package controller_sesion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   resp.setContentType("text/html;charset=UTF-8");
       PrintWriter out = resp.getWriter();

       HttpSession session = req.getSession(false);
       if (session != null && session.getAttribute("name") != null) {
           String name = (String) session.getAttribute("name");
           out.println("<h2>Chào bạn, " + name + " đến với trang quản lý tài khoản</h2>");
           out.println("<a href='logout'>Đăng xuất</a>");
       } else {
           out.println("<h3>Xin vui lòng đăng nhập</h3>");
           resp.sendRedirect("Login_session.html");
       }
	}

}
