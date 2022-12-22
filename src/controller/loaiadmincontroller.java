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

/**
 * Servlet implementation class loaiadmincontroller
 */
@WebServlet("/loaiadmincontroller")
public class loaiadmincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loaiadmincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		loaibo lbo = new loaibo();
		String act = request.getParameter("act");
		if (session.getAttribute("admin") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("loginadmincontroller");
			rd.forward(request, response);
		} else {
			if (act != null) {
				if(act.equals("xoa")) {
					String maloai = request.getParameter("ml");
					lbo.deletel(maloai);
				}
			}
			request.setAttribute("loai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("loaiadmin.jsp");
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
