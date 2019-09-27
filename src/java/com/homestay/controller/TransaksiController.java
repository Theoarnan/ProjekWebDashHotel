/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.controller;

import com.homestay.model.ItemTransaksi;
import com.homestay.model.Kamar;
import com.homestay.model.Pegawai;
import com.homestay.model.Pembayaran;
import com.homestay.model.Pengaturan;
import com.homestay.model.Tamu;
import com.homestay.model.TransaksiPesan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Software Institute
 */
public class TransaksiController extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String INDEX = "index";
    private static final String TRX_LIST = "trxList";

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
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                String tamuId = request.getParameter("tamu-id");
                String pegawaiId = request.getParameter("pegawai-id");
                String tglCheckin = request.getParameter("tgl-checkin");
                String tglCheckout = request.getParameter("tgl-checkout");
                String[] arKamarId = request.getParameterValues("kamar-id");
                
                TransaksiPesan trx = new TransaksiPesan();
                trx.setTanggalMasuk(tglCheckin);
                trx.setTanggalHarusKeluar(tglCheckout);
                trx.setTamuId(Integer.parseInt(tamuId));
                trx.setPegawaiId(Integer.parseInt(pegawaiId));
                
                
                
                int transaksiId = trx.addTransaksi();
                for (int i = 0; i < arKamarId.length; i++) {
                    int kamarId = Integer.parseInt(arKamarId[i]);
                    ItemTransaksi it = new ItemTransaksi();
                    it.setKamarId(kamarId);
                    it.setTransaksiPesanId(transaksiId);
                    it.addItemTransaksi();
                    
                    Kamar b = Kamar.getByPK(kamarId);
                    b.setStock(b.getStock() - 1);
                    b.updateData();
                }
                
                response.sendRedirect("Transaksi.do");
            }
            
            if (action.equalsIgnoreCase("list")) {
                ArrayList<TransaksiPesan> trxList = TransaksiPesan.getAll();
                request.setAttribute("trxList", trxList);
                return mapping.findForward(TRX_LIST);
            }
//            if (action.equalsIgnoreCase("pembayaran")) {
//                String strTrxId = request.getParameter("id_pesan");
////                String strTrxIdS = request.getParameter("id_kamar");
//                String sewa = request.getParameter("lama_sewa");
//                String harga = request.getParameter("harga");
//                int trxIds = Integer.parseInt(strTrxId);
//                int trxId = Integer.parseInt(strTrxId);
////                int sewas = Integer.parseInt(sewa);
////                int hargas = Integer.parseInt(harga);
//                Kamar k = Kamar.getByPK(trxIds);
//                TransaksiPesan trx = TransaksiPesan.getById(trxId);
//                //cek dulu berapa hari menginap
//                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                Date tanggalKeluar = format.parse(trx.getTanggalHarusKeluar());
////                Date hariIni = new Date();
////                long selisihWaktu = hariIni.getTime() - tanggalKeluar.getTime();
////                int selisihHari = (int) selisihWaktu / (1000 * 60 * 60 * 24);
//                
//                //proses pembayaran
////                int jlhKamar = ItemTransaksi.getJumlah(trxId);
////                System.out.println("Jlh Kamar = " + jlhKamar);
//                Pengaturan p = Pengaturan.getPengaturan();
//                int totalBiaya = (Integer.parseInt(k.getHargaKamar())* p.getJumlahHariPesan());
//                Pembayaran trxBayar = new Pembayaran();
//                trxBayar.setTotalBiaya(totalBiaya);
//                
//                trxBayar.setLamaSewa(Integer.toString(p.getJumlahHariPesan()));
//                trxBayar.setId_bayarPesan(trxId);
//                trxBayar.simpanData();
//                response.sendRedirect("Transaksi.do?action=list");
//
//            }
            
        }

        ArrayList<Tamu> tamus = Tamu.getAll();
        ArrayList<Pegawai> pegawais = Pegawai.getAll();
        ArrayList<Kamar> kamars = Kamar.getAll();
        request.setAttribute("tamus", tamus);
        request.setAttribute("pegawais", pegawais);
        request.setAttribute("kamars", kamars);
        return mapping.findForward(INDEX);
    }
}
