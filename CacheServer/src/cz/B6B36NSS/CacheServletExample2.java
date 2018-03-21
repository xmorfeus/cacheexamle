package cz.B6B36NSS;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.cache.CacheException;
import org.jboss.cache.Fqn;
import org.jboss.cache.TreeCache;

import cz.B6B36NSS.treecache.JBossCache;

/**
 * Servlet implementation with tree cache
 */
@WebServlet("/CacheServletExample2")
public class CacheServletExample2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TreeCache cache;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CacheServletExample2() {
    	
        super();
        
        cache = JBossCache.getInstance().getCache();
        try {
			cache.startService();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		FakeDBObject cacheObject = null;
				
		try {
			cacheObject = (FakeDBObject)cache.get(new Fqn(), "object");
		} catch (CacheException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (cacheObject == null) {
			cacheObject = FakeDB.getStaticObject();
			try {

				cache.put(new Fqn(), "object", cacheObject);
				
			} catch (CacheException e) {
//				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
	}
}