/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.poolborges.example.undertow;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PauloBorges
 */
public class ConfigServlet extends HttpServlet {

        public static final String MESSAGE = "message";
        private String message;

        @Override
        public void init(final ServletConfig config) throws ServletException {
            super.init(config);
            message = config.getInitParameter(MESSAGE);
        }

        @Override
        protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) 
                throws ServletException, IOException {
            
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("lock.waitTime=500");
            out.println("gateway.name=KrioOS");
            out.println("gateway.id=KrioOS");
            out.println(message);
            out.close();
            
        }

        @Override
        protected void doPost(final HttpServletRequest req,
                final HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }
    }