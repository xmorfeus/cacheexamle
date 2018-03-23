package servlet;

import clusterCache.ClusterCache;
import com.hazelcast.core.HazelcastInstance;
import fakeDB.FakeDB;
import fakeDB.FakeDBObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation with cluster cache
 */
public class Example3  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Example3() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        HazelcastInstance clusterCache = ClusterCache.getInstance();
        Map<String, FakeDBObject> cacheMap = clusterCache.getMap("objects");
//        Map<String, String> cacheMap = clusterCache.getMap("objects");

        FakeDBObject cacheObject = cacheMap.get("object");
//        String cacheObject = cacheMap.get("object");

        if (cacheObject == null) {
            cacheObject = FakeDB.getStaticObject();
//            cacheObject = "testtesttest";

            cacheMap.put("object", cacheObject);
        }


        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
//        res.getWriter().append(cacheObject);
    }
}
