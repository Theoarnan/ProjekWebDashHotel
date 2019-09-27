/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.controller;

import com.homestay.model.Kamar;
import com.homestay.model.Pegawai;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author THEO
 */
public class KamarController extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String INDEX = "index";
    private static final String ADD = "add";
    private static final String UPDATE = "update";

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
        
        String action = request.getParameter("action");
        if(action != null){
            if(action.equals("add")){
                String submit = request.getParameter("submit");
                if(submit != null){
                    //proses tambah
                    String typeKamar = request.getParameter("type_kamar");
                    String harga = request.getParameter("harga");
                    String fasilitas = request.getParameter("fasilitas");
                    String stock = request.getParameter("stock");
                    Kamar b = new Kamar();
                    b.setTypeKamar(typeKamar);
                    b.setHargaKamar(harga);
                    b.setFasilitasKamar(fasilitas);
                    b.setStock(Integer.parseInt(stock));
                    b.insertData();
                    response.sendRedirect("Kamar.do");
                }
                return mapping.findForward(ADD);
            }
            if(action.equals("delete")){
                String id = request.getParameter("id_kamar");
                Kamar b = Kamar.getByPK(Integer.parseInt(id));
                b.deleteData();
                response.sendRedirect("Kamar.do");
            }
            if(action.equals("update")){
                String id = request.getParameter("id_kamar");
                String submit = request.getParameter("submit");
                Kamar b = Kamar.getByPK(Integer.parseInt(id));
                if(b == null){
                    response.sendRedirect("Kamar.do");
                }
                if(submit != null){
                    //proses tambah
                    String typeKamar = request.getParameter("type_kamar");
                    String harga = request.getParameter("harga");
                    String fasilitas = request.getParameter("fasilitas");
                    String stock = request.getParameter("stock");
                    b.setTypeKamar(typeKamar);
                    b.setHargaKamar(harga);
                    b.setFasilitasKamar(fasilitas);
                    b.setStock(Integer.parseInt(stock));
                    b.updateData();
                    response.sendRedirect("Kamar.do");
                }
                request.setAttribute("kamar", b);
                return mapping.findForward(UPDATE);
            }
        }
        ArrayList<Kamar> kamars = Kamar.getAll();
        request.setAttribute("kamars", kamars);
        return mapping.findForward(INDEX);
    }
}

