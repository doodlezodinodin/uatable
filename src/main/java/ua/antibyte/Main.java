package ua.antibyte;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ua.antibyte.servlets.IndexServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Run");

        IndexServlet indexServlet = new IndexServlet();

        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servletContextHandler.addServlet(new ServletHolder(indexServlet), "/authform");

        server.setHandler(servletContextHandler);

        server.start();
        server.join();
        System.out.println("test join");
    }
}
