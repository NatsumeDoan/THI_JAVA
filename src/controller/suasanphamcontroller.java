package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class suasanphamcontroller
 */
@WebServlet("/suasanphamcontroller")
public class suasanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suasanphamcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("loginadmincontroller");
			rd.forward(request, response);
		} else {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			sanphambo sbo = new sanphambo();
			String masp = request.getParameter("msp");
			String tensp = request.getParameter("tsp");
			String mota = request.getParameter("mota");
			String gia = (request.getParameter("gia"));
			String maloai = request.getParameter("ml");
			String anhsp = request.getParameter("anhsp");
			loaibo lbo = new loaibo();
			anhsp = sbo.getAnh(masp);
			if (masp != null) {
				request.setAttribute("masp", masp);
				request.setAttribute("tensp", tensp);
				request.setAttribute("mota", mota);
				request.setAttribute("gia", gia);
				request.setAttribute("maloai", maloai);
				request.setAttribute("anhsp", anhsp);
				request.setAttribute("lstLoai", lbo.getloai());
				RequestDispatcher rd = request.getRequestDispatcher("suasanpham.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
