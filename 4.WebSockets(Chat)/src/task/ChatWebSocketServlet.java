package task;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ChatWebSocketServlet", urlPatterns = {"/chat"})
public class ChatWebSocketServlet extends WebSocketServlet {
    private final static int LOGOUT_TIME = 10 * 60 * 1000;

    public ChatWebSocketServlet() {}

    @Override
    public void configure(WebSocketServletFactory webSocketServletFactory) {
        webSocketServletFactory.getPolicy().setIdleTimeout(LOGOUT_TIME);
        webSocketServletFactory.setCreator(((servletUpgradeRequest, servletUpgradeResponse) -> new ChatWebSocket()));
    }
}
