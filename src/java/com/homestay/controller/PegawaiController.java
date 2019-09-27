/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.controller;

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
public class PegawaiController extends org.apache.struts.action.Action {

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
                    String namaPegawai = request.getParameter("nama_pegawai");
                    Pegawai b = new Pegawai();
                    b.setNamaPegawai(namaPegawai);
                    b.insertData();
                    response.sendRedirect("Pegawai.do");
                }
                return mapping.findForward(ADD);
            }
            if(action.equals("delete")){
                String id = request.getParameter("id_pegawai");
                Pegawai b = Pegawai.getByPK(Integer.parseInt(id));
                b.deleteData();
                response.sendRedirect("Pegawai.do");
            }
            if(action.equals("update")){
                String id = request.getParameter("id_pegawai");
                String submit = request.getParameter("submit");
                Pegawai b = Pegawai.getByPK(Integer.parseInt(id));
                if(b == null){
                    response.sendRedirect("Pegawai.do");
                }
                if(submit != null){
                    //proses tambah
                    String namaPegawai = request.getParameter("nama_pegawai");
                    b.setNamaPegawai(namaPegawai);
                    b.updateData();
                    response.sendRedirect("Pegawai.do");
                }
                request.setAttribute("pegawai", b);
                return mapping.findForward(UPDATE);
            }
        }
        ArrayList<Pegawai> pegawais = Pegawai.getAll();
        request.setAttribute("pegawais", pegawais);
        return mapping.findForward(INDEX);
    }
}
