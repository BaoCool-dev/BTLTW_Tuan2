package controller_cookie;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SESSION_USERNAME = "SESSION_USERNAME";
	public static final String COOKIE_REMEMBER = "COOKIE_REMEMBER";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		boolean isRememberMe = "on".equals(remember);

		String alertMsg = "";

		// Kiểm tra input
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {

			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}

		// Gọi service để xử lý login
		UserService service = new UserServiceImpl();
		User user = service.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute(SESSION_USERNAME, user.getUserName());

			if (isRememberMe) {
				saveRememberMe(resp, user.getUserName());
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60); // 30 phút
		response.addCookie(cookie);
	}
}
