/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.servlet;

import com.homestay.model.Pembayaran;
import com.homestay.model.TransaksiPesan;
import com.homestay.model.ItemTransaksi;
//import com.perpustakaan.model.TransaksiKembali;
//import com.perpustakaan.model.TransaksiPinjam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Excel", urlPatterns = {"/Excel"})
public class Excel extends HttpServlet {

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
       /* response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Excel</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Excel at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
        int id = Integer.parseInt(request.getParameter("id"));
        
        TransaksiPesan tp = TransaksiPesan.getById(id);
        Pembayaran tk = Pembayaran.getByTransaksiPesanId(id);
        ArrayList<ItemTransaksi> itList = ItemTransaksi.getByTransaksiId(id);
        
        String filename = "Transaksi ("+tp.getIdPesan()+").xls";
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = null;
        HSSFRow row = null;
        
        sheet = workbook.createSheet("Data Transaksi");
        int jlhBaris = 0;
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("DATA TAMU");
//        row.createCell(1).setCellValue(tp.getTamu().getNamaTamu());
        
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Nama");
        row.createCell(1).setCellValue(tp.getTamu().getNamaTamu());
        
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Telfon");
        row.createCell(1).setCellValue(tp.getTamu().getNoTelpon());
        
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Kartu Identitas");
        row.createCell(1).setCellValue(tp.getTamu().getKartuIdentitas());
        
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Tanggal Check In");
        row.createCell(1).setCellValue(tp.getTanggalMasuk());
        
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Tanggal Check Out");
        row.createCell(1).setCellValue(tp.getTanggalHarusKeluar());
        row = sheet.createRow(jlhBaris++);
        
//        row = sheet.createRow(jlhBaris++);
//        row.createCell(0).setCellValue("Lama Sewa");
//        row.createCell(1).setCellValue(tp.getLamaSewa());
//        row = sheet.createRow(jlhBaris++);
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("DETAIL TRANSAKSI");
//        row.createCell(1).setCellValue(tp.getTamu().getNamaTamu());
        
        if(tk == null){
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Status");
        row.createCell(1).setCellValue("Belum Bayar");
        }else{
            row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("Status");
        row.createCell(1).setCellValue("Sudah Bayar");
//        
//        row = sheet.createRow(jlhBaris++);
//        row.createCell(0).setCellValue("Total Biaya");
//        row.createCell(1).setCellValue(tk.getTotalTransaksi());
        }
        
        row = sheet.createRow(jlhBaris++);
        row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue("No");
        row.createCell(1).setCellValue("Type Kamar");
        row.createCell(2).setCellValue("Fasilitas");
        row.createCell(3).setCellValue("Harga Kamar");
        row.createCell(4).setCellValue("Lama Sewa");
        row.createCell(5).setCellValue("Total Biaya");
        int no = 0;
        for(ItemTransaksi it : itList){
            row = sheet.createRow(jlhBaris++);
        row.createCell(0).setCellValue(++no);
        row.createCell(1).setCellValue(it.getKamar().getTypeKamar());
        row.createCell(2).setCellValue(it.getKamar().getFasilitasKamar());
        row.createCell(3).setCellValue("Rp."+it.getKamar().getHargaKamar());
        row.createCell(4).setCellValue(""+tp.getLamaSewa()+"Hari");
        row.createCell(5).setCellValue("Rp."+tk.getTotalTransaksi());
        
        }
        workbook.write(response.getOutputStream());
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
