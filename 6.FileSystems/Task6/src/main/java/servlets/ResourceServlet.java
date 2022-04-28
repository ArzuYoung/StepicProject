package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import resourceServer.Controller.ResourceServerControllerMBean;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResourceServlet extends HttpServlet {
    public static final String PAGE_URL = "/resources";
    private ResourceServerControllerMBean resourceServerControllerMBean;
    private final Logger logger = LogManager.getLogger(ResourceServlet.class.getSimpleName());

    public ResourceServlet(ResourceServerControllerMBean resourceServerControllerMBean) {
        this.resourceServerControllerMBean = resourceServerControllerMBean;
    }

//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response) throws ServletException, IOException {
//
//    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");

        response.setContentType("text/html;charset=utf-8");

        if (path == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            logger.info("Path is null");
        } else {
//            logger.info("DoPost with path " + path);
            TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(path);
            resourceServerControllerMBean.setTestResource(testResource);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
