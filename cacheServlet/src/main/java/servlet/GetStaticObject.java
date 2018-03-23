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
public class GetStaticObject extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FakeDBObject cacheObject = null;
    public GetStaticObject() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        cacheObject = FakeDB.getStaticObject();

        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
    }

}
