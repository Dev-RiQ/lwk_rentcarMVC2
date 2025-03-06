package kr.rentcar.utils;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ScriptAlert  {
	private ScriptAlert() {}
	private static ScriptAlert instance;
	public static ScriptAlert getInstance() {
		if(instance == null) instance = new ScriptAlert();
		return instance;
	}
	private void go(HttpServletResponse response, String msg) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println(msg);
		writer.close();
	}
	public void goHomeWithMsg(HttpServletResponse response, HttpServletRequest request, String msg) throws IOException {
		String ctx = request.getContextPath();
		String alertMsg = "<script>alert('%s'); location.href='%s/%s'</script>";
		go(response, String.format(alertMsg, msg, ctx, "index.jsp"));
	}
	public void goBackWithMsg(HttpServletResponse response, String msg) throws IOException {
		String alertMsg = "<script>alert('%s'); history.back() </script>";
		go(response, String.format(alertMsg, msg));
	}
	public void goUrlWithMsg(HttpServletResponse response, HttpServletRequest request, String msg, String url) throws IOException {
		String ctx = request.getContextPath();
		String alertMsg = "<script>alert('%s'); location.href='%s/%s'</script>";
		go(response, String.format(alertMsg, msg, ctx, url));
	}
}
