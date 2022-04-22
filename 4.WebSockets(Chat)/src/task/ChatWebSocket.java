package task;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

@SuppressWarnings("UnusedDeclaration")
@WebSocket
public class ChatWebSocket {
    private Session session;

//    public ChatWebSocket() {}

    @OnWebSocketConnect
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String mess) {
        sendMessage(mess);
    }

    public void sendMessage(String mess) {
        try {
            session.getRemote().sendString(mess);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
