package main;

import accounts.AccService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SessionServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import servlets.UsersServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccService accService = new AccService();

        accService.addNewUser(new UserProfile("admin"));
        accService.addNewUser(new UserProfile("test"));

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new SessionServlet(accService)), "/api/v1/sessions");
        contextHandler.addServlet(new ServletHolder(new UsersServlet(accService)), "/api/v1/users");
        contextHandler.addServlet(new ServletHolder(new SignInServlet(accService)), "/signin");
        contextHandler.addServlet(new ServletHolder(new SignUpServlet(accService)), "/signup");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("pub_html_page");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[]{resourceHandler, contextHandler});

        Server server = new Server(8080);
        server.setHandler(handlerList);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}