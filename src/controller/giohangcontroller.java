package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.giohangbo;
import bo.khachhangbo;

/**
 * Servlet implementation class giohangcontroller
 */
@WebServlet("/giohangcontroller")
public class giohangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public giohangcontroller() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		khachhangbo t = new khachhangbo();
		giohangbo gh = new giohangbo();
		String tendn = request.getParameter("tendn");
		String act = request.getParameter("act");
		if (act != null) {
			if (act.equals("add")) {
				Long sl = Long.parseLong(request.getParameter("txtsl"));
				String size = request.getParameter("size");
				Long gia = Long.parseLong(request.getParameter("gia"));
				String msp = request.getParameter("msp");
				gh.Them(t.getmakh(tendn), msp, sl, gia, size);
			}
			if (act.equals("edit")) {
				String magh = request.getParameter("magh");
				Long sl = Long.parseLong(request.getParameter("txtsl"));
				String size = request.getParameter("size");
				Long gia = Long.parseLong(request.getParameter("gia"));
				String msp = request.getParameter("msp");
				gh.sua(t.getmakh(tendn), msp, sl, gia, size, magh);
			}
			if(act.equals("xoa")) {
				String magh = request.getParameter("magh");
				gh.xoa(t.getmakh(tendn),magh);
			}
			if(act.equals("deleteall")) {
				gh.Tratatca(t.getmakh(tendn));
			}
		}
		
		if(tendn==null||tendn.equals("")) {
			RequestDispatcher rd = request.getRequestDispatcher("logincontroller");
			rd.forward(request, response);
		}else {
			request.setAttribute("gh",gh.getgh(t.getmakh(tendn)));
			 RequestDispatcher rd = request.getRequestDispatcher("giohang.jsp");
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
