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

import bo.loaibo;

/**
 * Servlet implementation class sualoai
 */
@WebServlet("/sualoai")
public class sualoai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sualoai() {
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
			String maloai = null;
			String maloaicu = null;
			String tenloai = null;
			loaibo lbo = new loaibo();
			String anhcu = null;
			try {
				List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
				// duyệt qua các đối tượng gửi lên từ client gồm file và các control
				for (FileItem fileItem : fileItems) {
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtfilecu"))
						anhcu = (fileItem.getString());
					if (fileItem.isFormField()) {
						if (tentk.equals("txtml"))
							maloai = (fileItem.getString());
						if (tentk.equals("txtmlc"))
							maloaicu = (fileItem.getString());
						if (tentk.equals("txttl"))
							tenloai = (fileItem.getString());
					} else {
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "img-loai";
						String fileanhcu = dirUrl + File.separator + anhcu;
						nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
							// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String fileImg = dirUrl + File.separator + nameimg;
							File file = new File(fileImg);// tạo file
							try {
								fileItem.write(file);// lưu file
								Files.delete(Paths.get(fileanhcu));
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else {
							nameimg = anhcu;
						}
					}
				}

			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			if (maloaicu.equals(maloai)) {
				lbo.sual(maloaicu, maloai, tenloai, nameimg);
			} else if (lbo.kiemtraloai(maloai) == 0)
				lbo.sual(maloaicu, maloai, tenloai, nameimg);
			RequestDispatcher rd = request.getRequestDispatcher("loaiadmincontroller");
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
