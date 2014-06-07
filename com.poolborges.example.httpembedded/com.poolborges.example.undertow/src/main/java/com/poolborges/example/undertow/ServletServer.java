package com.poolborges.example.undertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Borges
 */
public class ServletServer {

    public static final String MYAPP = "/gateway";
    public static final int PORT = 6060;

    public static void main(final String[] args) {
        try {

            DeploymentInfo servletBuilder = deployment()
                    .setClassLoader(ServletServer.class.getClassLoader())
                    .setContextPath(MYAPP)
                    .setDeploymentName("gateway.war")
                    .addServlets(
                            //Default Servlet
                            servlet("DefaultServlet", MessageServlet.class)
                            .addInitParam("message", "Hello World to DefaultServlet/Home")
                            .addMapping("/*"),
                            //servlet root
                            servlet("MessageServlet", MessageServlet.class)
                            .addInitParam("message", "Hello World")
                            .addMapping("/messageServlet"),
                            //servlet confoguration
                            servlet("configServlet", ConfigServlet.class)
                            .addInitParam("message", "Config Servlet")
                            .addMapping("/config"));

            DeploymentManager manager = defaultContainer()
                    .addDeployment(servletBuilder);
            
            manager.deploy();

            HttpHandler servletHandler = manager.start();
            PathHandler path = Handlers.path(Handlers.redirect(MYAPP))
                    .addPrefixPath(MYAPP, servletHandler);
            Undertow server = Undertow.builder()
                    .addHttpListener(PORT, "localhost")
                    .setHandler(path)
                    .build();
            server.start();
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
