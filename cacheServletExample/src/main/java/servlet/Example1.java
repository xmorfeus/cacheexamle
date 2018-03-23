package servlet;

import fakeDB.FakeDB;
import fakeDB.FakeDBObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation with simple cache
 */
public class Example1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FakeDBObject cacheObject = null;
    public Example1() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        if (cacheObject == null) {
            cacheObject = FakeDB.getStaticObject();
        }


        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
    }

}
