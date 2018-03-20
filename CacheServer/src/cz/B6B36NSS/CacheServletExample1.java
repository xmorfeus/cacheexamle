package cz.B6B36NSS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation with simple cache
 */
@WebServlet("/CacheServletExample1")
public class CacheServletExample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FakeDBObject cacheObject = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CacheServletExample1() {

        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (cacheObject == null) {
			cacheObject = FakeDB.getStaticObject();
		}
		
		
		response.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
	}

}

