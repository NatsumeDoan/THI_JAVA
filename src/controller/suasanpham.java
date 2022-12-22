package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.sanphambo;

/**
 * Servlet implementation class suasanpham
 */
@WebServlet("/suasanpham")
public class suasanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public suasanpham() {
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
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String nameimg = null;
			String masp = null;
			String maspcu = null;
			String tensp = null;
			String mota = null;
			Long gia = null;
			String maloai = null;
			sanphambo sbo = new sanphambo();
			String anhcu = null;
			try {
				List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtfilecu"))
						anhcu = (fileItem.getString());
					if (fileItem.isFormField()) {
						if (tentk.equals("txtmsp"))
							masp = (fileItem.getString());
						if (tentk.equals("txtmspc"))
							maspcu = (fileItem.getString());
						if (tentk.equals("txttsp"))
							tensp = (fileItem.getString());
						if (tentk.equals("txtmt"))
							mota = (fileItem.getString());
						if (tentk.equals("txtg"))
							gia = Long.parseLong(((fileItem.getString())));
						if (tentk.equals("txtml"))
							maloai = (fileItem.getString());

					} else {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "img-sp";
						String fileanhcu = dirUrl + File.separator + anhcu;
						nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								Files.delete(Paths.get(fileanhcu));
								fileItem.write(file);// lưu file
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							break;
						}
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			if (maspcu.equals(masp)) {
				if(nameimg.equals("")) {
					sbo.suaspcungma(maspcu, tensp, anhcu, mota, maloai, gia);
				}
				else
					sbo.suaspcungma(maspcu, tensp, nameimg, mota, maloai, gia);
			} else if (sbo.getkiemtra(masp) == 0)
				if(nameimg.equals("")) {
					sbo.suasp(maspcu, masp, tensp, anhcu, mota, maloai, gia);
				}
				else
					sbo.suasp(maspcu, masp, tensp, nameimg, mota, maloai, gia);
			RequestDispatcher rd = request.getRequestDispatcher("sanphamadmincontroller");
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
