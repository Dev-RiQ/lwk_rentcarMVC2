package kr.rentcar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
	maxFileSize = 1024 * 1024 * 1,  //1MB
	maxRequestSize = 1024 * 1024 * 10  //10MB
)
public class FileUtil {
	public static String uploadFile(Part part, String sDirectory) throws ServletException, IOException {
		String originalFileName = getOriginalFileName(part);
		createDirectoryIfNotExists(sDirectory);
		if (!originalFileName.isEmpty()) {
			String saveFileName = setAndGetSaveFileName(originalFileName);
			Path targetPath = Paths.get(sDirectory, saveFileName);
			Files.copy(part.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
			return saveFileName;
		}
		return originalFileName;
	}
	
	public static void deleteFile(HttpServletRequest req, String filename) {
		String sDirectory = req.getServletContext().getRealPath("/img");
		Path filePath = Paths.get(sDirectory, filename);
		try {
			Files.deleteIfExists(filePath);
		} catch (IOException e) {
			System.out.println("deleteFile Fail");
		}
	}

	private static void createDirectoryIfNotExists(String directory) {
		Path dirPath = Paths.get(directory);
		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				System.out.println("createDirectoryIfNotExists Fail");
			}
		}
	}
	
	private static String getOriginalFileName(Part part) {
		String partHeader = part.getHeader("content-disposition");
		String originalFileName = partHeader.split("filename=")[1].trim().replace("\"", "");
		return originalFileName;
	}
	
	private static String setAndGetSaveFileName(String fileName) {
		return System.currentTimeMillis() + "_" + fileName;
	}
	
	public static String[] getPartsValue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sDirectory = request.getServletContext().getRealPath("/img");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Collection<Part> parts = request.getParts();
		String[] values = new String[parts.size()];
		int idx = 0;
		for(Part part : parts) {
			if(part.getHeader("Content-Disposition").contains("filename="))
				values[idx++] = FileUtil.uploadFile(part, sDirectory);
			else
				values[idx++] = request.getParameter(part.getName());
		}
		return values;
	}
}
