package servlets;

import accounts.AccService;
import accounts.UserProfile;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    private final AccService accService;

    public SessionServlet(AccService accService) {
        this.accService = accService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        String sessionId = request.getSession().getId();
        UserProfile profile = accService.getUserBySessionId(sessionId);

        if (profile == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(profile);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(json);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        if (login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile = accService.getUserByLogin(login);
        if (profile == null || !profile.getPassword().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accService.addSession(request.getSession().getId(), profile);
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(json);
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String sessionId = request.getSession().getId();
        UserProfile profile = accService.getUserBySessionId(sessionId);

        if (profile == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            accService.deleteSession(sessionId);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Hope we meet again!");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}