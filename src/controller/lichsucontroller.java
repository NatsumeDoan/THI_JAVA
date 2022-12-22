package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.giohangbean;
import bo.giohangbo;
import bo.khachhangbo;
import bo.lsubo;

/**
 * Servlet implementation class lichsucontroller
 */
@WebServlet("/lichsucontroller")
public class lichsucontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lichsucontroller() {
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
		long millis = System.currentTimeMillis();
		Date ngaymua = new Date(millis);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		khachhangbo t = new khachhangbo();
		lsubo ls = new lsubo();
		giohangbo gh = new giohangbo();
		String tendn = request.getParameter("tendn");
		String act = request.getParameter("act");
		String diachi = request.getParameter("diachi");
		if (tendn == null || tendn.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("logincontroller");
			rd.forward(request, response);
		} else {
			if (act != null) {
				if (act.equals("Thành tiền")) {
					ls.themhd(t.getmakh(tendn), ngaymua, diachi);
					for (giohangbean g : gh.getgh(t.getmakh(tendn))) {
						String ms = g.getMasp();
						long sl = g.getSoluong();
						for (int i : ls.getmahoadon(t.getmakh(tendn))) {
							ls.themchitiet(ms, sl, i, g.getSize());
						}
					}
					gh.Tratatca(t.getmakh(tendn));
				}
			}
			request.setAttribute("lsu", ls.getlistlsu(t.getmakh(tendn)));
			RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
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
