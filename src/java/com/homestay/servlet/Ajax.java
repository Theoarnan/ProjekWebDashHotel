/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.servlet;

import com.homestay.model.Kamar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Software Institute
 */
@WebServlet(name = "Ajax", urlPatterns = {"/Ajax"})
public class Ajax extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Ajax</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Ajax at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        String keyword = request.getParameter("q");
        response.addHeader("Content-Type", "text/plain");
        ArrayList<Kamar> kamars = Kamar.getSearch(keyword);
        JSONObject jsonObject = new JSONObject();
        JSONArray json = new JSONArray();
        for(Kamar b : kamars){
            JSONObject j = new JSONObject();
            String text = b.getTypeKamar()+" / "+b.getFasilitasKamar();
            j.put("id", b.getIdKamar());
            j.put("type_kamar",b.getTypeKamar());
            j.put("harga",b.getHargaKamar());
            j.put("fasilitas",b.getFasilitasKamar());
            j.put("stock",b.getStock());
            j.put("text",text);            
            json.add(j);
        }
//        jsonObject.put("result", json);
        out.println(json.toString());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
