/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.controller;

import com.homestay.model.Tamu;
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
public class TamuController extends org.apache.struts.action.Action {

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
                    String namaTamu = request.getParameter("nama_tamu");
                    String kartuIdentitas = request.getParameter("kartu_identitas");
                    String noTelp = request.getParameter("no_telp");
                    Tamu b = new Tamu();
                    b.setNamaTamu(namaTamu);
                    b.setKartuIdentitas(kartuIdentitas);
                    b.setNoTelpon(noTelp);
                    b.insertData();
                    response.sendRedirect("Tamu.do");
                }
                return mapping.findForward(ADD);
            }
            if(action.equals("delete")){
                String id = request.getParameter("id_tamu");
                Tamu b = Tamu.getByPK(Integer.parseInt(id));
                b.deleteData();
                response.sendRedirect("Tamu.do");
            }
            if(action.equals("update")){
                String id = request.getParameter("id_tamu");
                String submit = request.getParameter("submit");
                Tamu b = Tamu.getByPK(Integer.parseInt(id));
                if(b == null){
                    response.sendRedirect("Tamu.do");
                }
                if(submit != null){
                    //proses tambah
                    String namaTamu = request.getParameter("nama_tamu");
                    String kartuIdentitas = request.getParameter("kartu_identitas");
                    String noTelp = request.getParameter("no_telp");
                    b.setNamaTamu(namaTamu);
                    b.setKartuIdentitas(kartuIdentitas);
                    b.setNoTelpon(noTelp);
                    b.updateData();
                    response.sendRedirect("Tamu.do");
                }
                request.setAttribute("tamu", b);
                return mapping.findForward(UPDATE);
            }
        }
        ArrayList<Tamu> tamus = Tamu.getAll();
        request.setAttribute("tamus", tamus);
        return mapping.findForward(INDEX);
    }
}
