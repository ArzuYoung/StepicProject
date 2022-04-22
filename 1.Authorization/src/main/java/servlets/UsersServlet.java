package servlets;

import accounts.AccService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {
    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) //todo: надо будет убрать после выполнения дз
    private final AccService accService;

    public UsersServlet(AccService accService) {
        this.accService = accService;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo
    }

    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo
    }

    public void doDelete(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        //todo
    }
}