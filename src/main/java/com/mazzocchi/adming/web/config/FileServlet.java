package com.mazzocchi.adming.web.config;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.*;
import java.net.*;
import java.nio.file.*;

@WebServlet("/images/*")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        String filename = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8");
        File file = new File("D:\\gadmin-images", filename);
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        Files.copy(file.toPath(), response.getOutputStream());
    }
}