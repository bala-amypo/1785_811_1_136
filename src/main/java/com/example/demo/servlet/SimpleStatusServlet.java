package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.*;

public class SimpleStatusServlet extends HttpServlet
{
    @Override
    public public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.write("SimpleStatusServlet is running");
        out.flush();
    }
}
