/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.controller;

import com.homestay.model.Pengaturan;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Software Institute
 */
public class PengaturanController extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        return null;
//       PrintWriter out = response.getWriter();
//       String submit = request.getParameter("submit");
//        if (submit != null) {
////            String namaAplikasi = request.getParameter("nama");
//            String strJumlahHariPesan = request.getParameter("lama_sewa");
////            String strHarga = request.getParameter("harga");
////            String strHitung = request.getParameter("hitung_jumlah_kamar");
//            int jumlahHariPesan = 1;
////            int harga = 0;
////            int hitung = 0;
//            try {
//                jumlahHariPesan = Integer.parseInt(strJumlahHariPesan);
////                harga = Integer.parseInt(strHarga);
////                hitung = Integer.parseInt(strHitung);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Pengaturan p = Pengaturan.getPengaturan();
////            p.setNama(namaAplikasi);
//            p.setJumlahHariPesan(jumlahHariPesan);
////            p.setHarga(harga);
////            p.setHitungJumlahKamar(hitung);
//            p.updatePengaturan();
//            response.sendRedirect("Pengaturan.do");
//        }
        Pengaturan p = Pengaturan.getPengaturan();
       request.setAttribute("pengaturan", p);
        return mapping.findForward(SUCCESS);
   }

}