package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
   String enc;
   Map<String, Controller> mappings;
   
   
   @Override
   public void init(ServletConfig config) throws ServletException {
      enc = config.getInitParameter("charset");
      
      mappings = new HashMap<>();
      mappings.put("/main.do", new MainController());
      mappings.put("/second.do", new SecondController());
      mappings.put("/charts.do", new ChartController());
      mappings.put("/register.do", new RegisterController());
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding(enc);

      String uri = req.getRequestURI();
      String contextPath = req.getContextPath();
      String path = uri.substring(contextPath.length());
      
      Controller cntr = mappings.get(path);
      cntr.execute(req,  resp);
   
   }
}