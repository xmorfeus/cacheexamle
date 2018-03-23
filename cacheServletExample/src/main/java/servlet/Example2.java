package servlet;

import fakeDB.FakeDB;
import fakeDB.FakeDBObject;
import org.jboss.cache.CacheException;
import org.jboss.cache.Fqn;
import org.jboss.cache.TreeCache;
import treeCache.Treecache;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation with tree cache
 */
public class Example2  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FakeDBObject cacheObject = null;
    public Example2() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        TreeCache treecache = Treecache.getInstance();
        try {
            cacheObject = (FakeDBObject)treecache.get(new Fqn(), "object");

            if (cacheObject == null) {
                cacheObject = FakeDB.getStaticObject();
                treecache.put(new Fqn(), "object", cacheObject);; // create a cache entry.
            }

        } catch (CacheException e) {
            e.printStackTrace();
        }

        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
    }
}
