package cz.B6B36NSS;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CacheServlet
 */
@WebServlet("/CacheServlet")
public class CacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CacheServlet() {

        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		FakeDBObject resp = FakeDB.getStaticObject();
		FakeDBObject resp = FakeDB.getChangingObject();
		
		response.getWriter().append(Integer.toString(resp.getId())).append(": ").append(resp.getText());
	}

}
