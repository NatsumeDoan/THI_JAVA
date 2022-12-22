package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.adminbean;
import bo.adminbo;

/**
 * Servlet implementation class loginadmincontroller
 */
@WebServlet("/loginadmincontroller")
public class loginadmincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginadmincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		adminbo dnbo = new adminbo();
		adminbean dn = null;
		RequestDispatcher rd;
		if(un!=null&&pass!=null)
		{
			// Tao doi tuong session
			HttpSession session = request.getSession();
			// Neu chua tao session
			if (session.getAttribute("admin") == null) {
				dn = new adminbean();
				// session.setAttribute("kh", kh);//Tao bien session dn
			}
			dn = dnbo.ktdn(un,adminbo.ecrypt(pass));
			if (dn == null) {
				request.setAttribute("status", "failed");
				rd = request.getRequestDispatcher("loginadmin.jsp?kt=1");
			}
				
			else {
				session.setAttribute("admin", dn);
				rd = request.getRequestDispatcher("adminController");
			}
		}else {
			
			rd=request.getRequestDispatcher("loginadmin.jsp");
		}

		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
