package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.registerbo;

/**
 * Servlet implementation class registercontroller
 */
@WebServlet("/registercontroller")
public class registercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registercontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		registerbo rbo = new registerbo();
		String name = request.getParameter("name");
        String diachi = request.getParameter("address");
        String sodt = request.getParameter("phone");
        String email = request.getParameter("email");
        String tendn = request.getParameter("tendn");
        String pass = request.getParameter("pass");

       if(tendn!=null && pass!=null && sodt!=null && email!=null && name!=null && diachi !=null) {
        if(rbo.checkKhachHang(tendn)==0) {
        	
        	rbo.addKhachHang(name, diachi, sodt, email, tendn,registerbo.ecrypt(pass));
        	response.sendRedirect("logincontroller");
        }
        else {
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);}
		}
        else {
        	 RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
     		rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
