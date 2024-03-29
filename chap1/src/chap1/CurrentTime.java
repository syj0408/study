package chap1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url 정보가 /CurrentTime 로 요청시 호출되는 서블릿임.
@WebServlet("/CurrentTime") // @ -> 어노테이션. @WebServlet
public class CurrentTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Get 방식으로 요청시 호출되는 메서드
    //request : 요청 객체, 브라우저의 요청 정보 저장하고 있는 객체
    //response : 응답 객체, 브라우저로 전달되는 응답정보를 저장하고 있는 객체
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setContentType("text/html; charset=EUC-KR");
       Calendar c = Calendar.getInstance();
       int h = c.get(Calendar.HOUR_OF_DAY);
       int m = c.get(Calendar.MINUTE);
       int s = c.get(Calendar.SECOND);
       // 문자형출력스트림
       PrintWriter out = response.getWriter();
       out.println("<html><head><title>현재시간</title></head>");
       out.println("<body>");
       out.println("<h1>현재시간은" + h + "시" + m + "분" + s + "초입니다.</h1></body></html>");
//       response.getWriter().append("Served at: ").append(request.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  //Post 방식으로 요청시 호출되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
