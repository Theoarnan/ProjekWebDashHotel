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

/**
 *
 * @author Software Institute
 */
public class Pengaturan {

    private int id;
//    private String nama;
    private int jumlahHariPesan;
//    private int harga;
//    private int hitungJumlahKamar;
//
    public static Pengaturan getPengaturan() {
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        Pengaturan p = null;
        PreparedStatement ps = null;
        ResultSet r = null;
        String sql = "select * from pengaturan where id=0";
        try {
            ps = c.prepareStatement(sql);
            r = ps.executeQuery();
            if (r.next()) {
               p = new Pengaturan();
                p.id = r.getInt("id");
//                p.nama = r.getString("nama_aplikasi");
                p.jumlahHariPesan = r.getInt("jumlah_hari_pesan");
//                p.harga = r.getInt("total_biaya");
//                p.hitungJumlahKamar = r.getInt("hitung_jumlah_kamar");
           }
      } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
//
    public void updatePengaturan() {
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        Pengaturan p = null;
        PreparedStatement ps = null;
        String sql = "update pengaturan set jumlah_hari_pesan=? where id=0";
        try {
            ps = c.prepareStatement(sql);
//            ps.setString(1, this.nama);
            ps.setInt(1, this.jumlahHariPesan);
//            ps.setInt(3, this.harga);
//            ps.setInt(4, this.hitungJumlahKamar);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
//
    public int getId() {
        return id;
    }
//
    public void setId(int id) {
        this.id = id;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//

//
//    public int getHarga() {
//        return harga;
//    }
//
//    public void setHarga(int harga) {
//        this.harga = harga;
//    }
//
//    public int getHitungJumlahKamar() {
//        return hitungJumlahKamar;
//    }
//
//    public void setHitungJumlahKamar(int hitungJumlahKamar) {
//        this.hitungJumlahKamar = hitungJumlahKamar;
//    }

   

}

    public int getJumlahHariPesan() {
        return jumlahHariPesan;
    }

    public void setJumlahHariPesan(int jumlahHariPesan) {
        this.jumlahHariPesan = jumlahHariPesan;
    }
}