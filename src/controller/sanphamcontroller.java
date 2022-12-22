package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class sanphamcontroller
 */
@WebServlet("/sanphamcontroller")
public class sanphamcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sanphamcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		loaibo loai = new loaibo();
		sanphambo spbo = new sanphambo();
		String maloai= request.getParameter("maloai");
		String timkiem = request.getParameter("timkiem");
		if (loai.getloai() != null) {
			request.setAttribute("loai", loai.getloai());
		}
		if(maloai==null || maloai=="")
		{
			if(spbo.sploai("cp")!=null) {
				request.setAttribute("sp", spbo.sploai("cp"));
			}
		}
		else {
			if(spbo.sploai(maloai)!=null) {
				request.setAttribute("sp", spbo.sploai(maloai));
			}
		}
		if(timkiem!=null) {
			if(spbo.kiemtra(timkiem)==0) {
				request.setAttribute("sp1", "f");
			}
			request.setAttribute("sp", spbo.timkiem(timkiem));
		}
		RequestDispatcher rd = request.getRequestDispatcher("product-listing.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
	