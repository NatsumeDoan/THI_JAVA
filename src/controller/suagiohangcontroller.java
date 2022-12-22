package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.sanphambo;

/**
 * Servlet implementation class suagiohangcontroller
 */
@WebServlet("/suagiohangcontroller")
public class suagiohangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suagiohangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sanphambo spbo = new sanphambo();
		HttpSession session = request.getSession();
		if (session.getAttribute("DangNhap") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("logincontroller");
			rd.forward(request, response);
		} else {
			String tendn = request.getParameter("tendn");
			String magh= request.getParameter("magh");
			String masp = request.getParameter("masp");
			String gia = request.getParameter("gia");
			String soluong = request.getParameter("soluong");
			String size = request.getParameter("size");
			if (magh != null) {
				request.setAttribute("anhsp", spbo.getAnhsp(masp));
				request.setAttribute("tensp", spbo.getTensp(masp));
				request.setAttribute("tendn", tendn);
				request.setAttribute("masp", masp);
				request.setAttribute("magh", magh);
				request.setAttribute("soluong", soluong);
				request.setAttribute("gia", gia);
				request.setAttribute("size", size);
				RequestDispatcher rd = request.getRequestDispatcher("suagiohang.jsp");
				rd.forward(request, response);
			}
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
