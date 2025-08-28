package controller_cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/hello","/xin-chao"})
public class HelloServlet extends HttpServlet {


		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Override
		public void init() throws ServletException {
			System.out.println("Bat dau Servlet");
		}
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.service(req, resp);
			System.out.println("Phuong thuc su dung la: " +req.getMethod());
			
		}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			String name = "";
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {   // kiểm tra null
			    for (Cookie c : cookies) {
			        if (c.getName().equals("username")) {
			            name = c.getValue();
			        }
			    }
			}
			if (name.equals("")) {
			    resp.sendRedirect("/HelloServlet/login");
			} else {
			    printWriter.println("Xin Chào " + name);
			}

			
		}
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			System.out.println("Ket thuc Servlet");
		}
		

	

}
