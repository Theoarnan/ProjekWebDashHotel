/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.servlet;

import com.homestay.model.ItemTransaksi;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.homestay.model.Pembayaran;
import com.homestay.model.Pengaturan;
import com.homestay.model.Tamu;
import com.homestay.model.TransaksiPesan;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Position;

/**
 *
 * @author Software Institute
 */
@WebServlet(name = "Print", urlPatterns = {"/Print"})
public class Print extends HttpServlet {

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
//            out.println("<title>Servlet Print</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Print at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
//        PrintWriter out = response.getWriter();
//        out.println(id);
        Document document = new Document(PageSize.LETTER);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        TransaksiPesan tp = TransaksiPesan.getById(id);
        ArrayList<ItemTransaksi> itList = ItemTransaksi.getByTransaksiId(tp.getIdPesan());
        System.out.println(tp);
        try {

            PdfWriter.getInstance(document, baos);
            document.open();
            //set Font
            Font font10 = new Font(Font.HELVETICA, 10, Font.NORMAL);
            
            //isi dari document yang akan di ciptakan
            Paragraph homestay = new Paragraph("HOME STAY");
            homestay.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph alamat = new Paragraph("KALASAN");
            alamat.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph garis = new Paragraph("- - - - - - - - - - - - - - - - - - - - - - - -");
            garis.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(homestay);            
            document.add(alamat);
            document.add(garis);
            Paragraph pJudul = new Paragraph("Item Transaksi (ID : " + tp.getIdPesan()+ ")");
            document.add(pJudul);
            Paragraph pNewLine = new Paragraph(" ");
            Paragraph pNama = new Paragraph("Nama Tamu : " + tp.getTamu().getNamaTamu(), font10);
            Paragraph pTlp = new Paragraph("No Telp : " + tp.getTamu().getNoTelpon(), font10);
            Paragraph pTglPinjam = new Paragraph("Tanggal Transaksi : " + tp.getTanggalMasuk(), font10);

            document.add(pNewLine);
            document.add(pNama);
            document.add(pTlp);
            document.add(pTglPinjam);

            document.add(pNewLine);
            PdfPTable tITRX = new PdfPTable(3);
            tITRX.setWidthPercentage(100);
            tITRX.setSpacingBefore(5f);
            float[] lebarKolom = {0.5f, 5f, 5f};
            tITRX.setWidths(lebarKolom);

            PdfPCell cell = new PdfPCell();

            //TH - table header
            //TH NO
            cell = new PdfPCell(new Paragraph("NO", font10));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tITRX.addCell(cell);
            //TH Nama Tamu
            cell = new PdfPCell(new Paragraph("Nama Tamu", font10));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tITRX.addCell(cell);
            //TH Nama Kamar
            cell = new PdfPCell(new Paragraph("Nama Kamar", font10));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tITRX.addCell(cell);
            //Fasilitas
            cell = new PdfPCell(new Paragraph("Fasilitas", font10));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tITRX.addCell(cell);
            //Harga
            cell = new PdfPCell(new Paragraph("Harga", font10));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tITRX.addCell(cell);
            
            int i = 1;
            for (ItemTransaksi it : itList) {
                cell = new PdfPCell(new Paragraph("" + i++, font10));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tITRX.addCell(cell);
                //TD Nama
                cell = new PdfPCell(new Paragraph(it.getTamu().getNamaTamu(), font10));
                tITRX.addCell(cell);
                
                cell = new PdfPCell(new Paragraph(it.getKamar().getTypeKamar(), font10));
                tITRX.addCell(cell);
                
                cell = new PdfPCell(new Paragraph(it.getKamar().getFasilitasKamar(), font10));
                tITRX.addCell(cell);
                //TD Penulis
                String harga = Integer.toString(it.getPembayaran().getTotalBiaya());
                
                cell = new PdfPCell(new Paragraph(harga+",00",font10));
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                tITRX.addCell(cell);

            }
            String jumlah = Integer.toString(ItemTransaksi.getJumlah(id));
            cell = new PdfPCell(new Paragraph("", font10));
            tITRX.addCell(cell);
            cell = new PdfPCell(new Paragraph("JUMLAH", font10));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tITRX.addCell(cell);
            cell = new PdfPCell(new Paragraph(jumlah+",00", font10));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tITRX.addCell(cell);

            
            document.add(tITRX);
            //menutup dokumen
            
            document.close();

            //header agar file dikenali sebagai pdf oleh browser
//            String namaFile = "laporan.pdf";
//            response.setHeader("Content-Disposition", "attachment;filename=\"" +namaFile+ "\"");
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            ServletOutputStream out = response.getOutputStream();

            baos.writeTo(out);

            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
