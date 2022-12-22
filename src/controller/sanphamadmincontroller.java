package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.sanphambo;

/**
 * Servlet implementation class sanphamadmincontroller
 */
@WebServlet("/sanphamadmincontroller")
public class sanphamadmincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sanphamadmincontroller() {
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
		sanphambo spbo = new sanphambo();
		String xoa = request.getParameter("xoa");
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("loginadmincontroller");
			rd.forward(request, response);
		} else {
			if (xoa != null) {
				String image = spbo.getAnh(xoa);
				String dirUrl1 = request.getServletContext().getRealPath("") + File.separator + "img-sp";
				String fileImg = dirUrl1 + File.separator + image;
				try {
					Files.delete(Paths.get(fileImg));
				} catch (Exception e) {
					e.printStackTrace();
				}
				spbo.deletesp(xoa);
			}
			request.setAttribute("sp", spbo.getsp());
			RequestDispatcher rd = request.getRequestDispatcher("sanphamadmin.jsp");
			rd.forward(request, response);
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
