/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.homestay.model;

import connection.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THEO
 */
public class TransaksiPesan {
    int idPesan;
    private String tanggalMasuk;
    private String tanggalHarusKeluar;
    private int jumlahHariSewa= 1;
    int tamuId;
    int pegawaiId;
    private Tamu tamu;
    private Pegawai pegawai;
    
    
    
    public int getIdPesan() {
        return idPesan;
    }
    public void setIdPesan(int idPesan) {
        this.idPesan = idPesan;
    }
    public String getTanggalMasuk() {
        return tanggalMasuk;
    }
    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }
    
    
    public int getTamuId() {
        return tamuId;
    }
    public void setTamuId(int tamuId) {
        this.tamuId = tamuId;
    }
//    public int getKamarId() {
//        return kamarId;
//    }
//    public void setKamarId(int kamarId) {
//        this.kamarId = kamarId;
//    }
    public int getPegawaiId() {
        return pegawaiId;
    }
    public void setPegawaiId(int pegawaiId) {
        this.pegawaiId = pegawaiId;
    }
    public Tamu getTamu() {
        return tamu;
    }
    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }
    
    public Pegawai getPegawai() {
        return pegawai;
    }
    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }
    
    public static ArrayList<TransaksiPesan>getAll(){
        ArrayList<TransaksiPesan> hasil = new ArrayList<>();
        String sql = "select * from transaksi_pesan_kamar";
        PreparedStatement ps = null;
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        ResultSet r = null;
        try {
            ps = c.prepareStatement(sql);
            r = ps.executeQuery();
            while(r.next()){
                TransaksiPesan tp = new TransaksiPesan();
                tp.idPesan = r.getInt("id_pesan");
                tp.tanggalMasuk = r.getString("tgl_masuk");
                tp.tanggalHarusKeluar = r.getString("tgl_keluar");
                tp.tamuId = r.getInt("tamu_id");
                tp.tamu =Tamu.getByPK(tp.tamuId);
                tp.pegawaiId = r.getInt("pegawai_id");
                tp.pegawai =Pegawai.getByPK(tp.pegawaiId);
                hasil.add(tp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            k.tutupKoneksi(ps, r, c);
        }
        return hasil;
    }
    public static TransaksiPesan getById(int id){
        TransaksiPesan hasil = null;
        String sql = "select * from transaksi_pesan_kamar where id_pesan = ?";
        PreparedStatement ps = null;
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        ResultSet r = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            r = ps.executeQuery();
            if(r.next()){
                hasil = new TransaksiPesan();
                hasil.idPesan = r.getInt("id_pesan");
                hasil.tanggalMasuk = r.getString("tgl_masuk");
                hasil.tanggalHarusKeluar = r.getString("tgl_keluar");
                hasil.tamuId = r.getInt("tamu_id");
                hasil.tamu =Tamu.getByPK(hasil.tamuId);
                hasil.pegawaiId = r.getInt("pegawai_id");
                hasil.pegawai =Pegawai.getByPK(hasil.pegawaiId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            k.tutupKoneksi(ps, r, c);
        }
        return hasil;
    }
    
    public int addTransaksi(){
        int idPesan = 0;
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        ResultSet r = null;
        String query = "insert into transaksi_pesan_kamar(tgl_masuk,tgl_keluar, tamu_id,pegawai_id ) "
                + "values (NOW(),DATE_ADD(NOW(), INTERVAL ? DAY),?,?)";
        try {
            ps = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, this.jumlahHariSewa);
            ps.setInt(2, this.tamuId);
            ps.setInt(3, this.pegawaiId);
            ps.executeUpdate();
            r = ps.getGeneratedKeys();
            if(r.next())
            {
                idPesan = r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        k.tutupKoneksi(ps, r, c);
        
        return idPesan;       
    }  
    
    public int getLamaSewa() {
        try{
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(this.tanggalMasuk);  
            Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(this.tanggalHarusKeluar);  

            long diff = date2.getTime() - date1.getTime();
            String result = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            return Integer.parseInt(result);       
        } catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getTotalTransaksi() {
        return ItemTransaksi.getTotalTransaksi(this.idPesan);
    }

    public String getTanggalHarusKeluar() {
        return tanggalHarusKeluar;
    }

    public void setTanggalHarusKeluar(String tanggalHarusKeluar) {
        this.tanggalHarusKeluar = tanggalHarusKeluar;
    }

}
