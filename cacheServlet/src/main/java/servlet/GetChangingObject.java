package servlet;

import fakeDB.FakeDB;
import fakeDB.FakeDBObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetChangingObject extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FakeDBObject cacheObject = null;
    public GetChangingObject() {

        super();
    }

    public void service(HttpServletRequest req,
                        HttpServletResponse res) throws IOException {

        cacheObject = FakeDB.getChangingObject();

        res.getWriter().append(Integer.toString(cacheObject.getId())).append(": ").append(cacheObject.getText());
    }

}