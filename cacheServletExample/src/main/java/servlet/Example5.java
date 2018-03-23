package servlet;

import fakeDB.FakeDB;
import fakeDB.FakeDBObject;
import org.jboss.cache.CacheException;
import org.jboss.cache.Fqn;
import org.jboss.cache.TreeCache;
import treeCacheTtl.Treecache;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Example5 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FakeDBObject cacheObject = null;
    public Example5() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        TreeCache treecache = Treecache.getInstance();
        try {
            cacheObject = (FakeDBObject)treecache.get("aa", "object");

            if (cacheObject == null) {
                cacheObject = FakeDB.getChangingObject();
                treecache.put("aa", "object", cacheObject); // create a cache entry.
            }

        } catch (CacheException e) {
            e.printStackTrace();
        }

        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
    }

}