package controller_sesion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet_2
 */
@WebServlet("/loginsession")
public class LoginServlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	   resp.setContentType("text/html;charset=UTF-8");
       PrintWriter out = resp.getWriter();

       String username = req.getParameter("username");
       String password = req.getParameter("password");

       if ("bao".equals(username) && "123".equals(password)) {
           // Tạo session
           HttpSession session = req.getSession();
           session.setAttribute("name", username);

           resp.sendRedirect("profile");
       } else {
           out.println("<h3>Tài khoản hoặc mật khẩu không chính xác!</h3>");
           req.getRequestDispatcher("Login_session.html").include(req, resp);
       }
}

}
