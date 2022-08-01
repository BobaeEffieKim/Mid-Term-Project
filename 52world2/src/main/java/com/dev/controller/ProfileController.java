package com.dev.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ProfileController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String realPath = req.getSession().getServletContext().getRealPath("/");
		realPath = realPath.substring(0, realPath.length() - 30);
		realPath += "\\src\\main\\webapp\\52world\\asset";
		System.out.println(realPath);
		File DirPath = new File(realPath);
		String fileName = "";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(DirPath);
		// 파일크기 5메가
		factory.setSizeThreshold(5 * 1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString("utf-8"));
					req.setAttribute("introduce", fileItem.getString("utf-8"));
				} else {
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						// 로그인세션 아이디 가져와서 아이디_profile로 변경해야함
						fileName = "user1_profile.jpg";
						File uploadFile = new File(DirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// db에 insert하는 코드필요

		
		// 이미지 src 넘겨주기
		String src = realPath.substring(realPath.length() - 14);
		src.replace('\\', '/');
		src = "/52world"+src+"/"+fileName;
		
		System.out.println(src);
		req.setAttribute("src", src);
		RequestDispatcher rd = req.getRequestDispatcher("main/profile.tiles");
		rd.forward(req, resp);
	}

}
