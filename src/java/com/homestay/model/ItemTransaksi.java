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
import java.util.ArrayList;

/**
 *
 * @author THEO
 */
public class ItemTransaksi {
    private int idTransaksi;
    private int transaksiPesanId;
    private int kamarId;
    private Kamar kamar;
    private Tamu tamu;
    private Pembayaran pembayaran;
    
    public void addItemTransaksi(){
    Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        String query = "insert into item_transaksi_pesan(transaksi_pesan_id, kamar_id)"
                + "values (?,?)";
            try {
                ps = c.prepareStatement(query);
                ps.setInt(1, transaksiPesanId);
                ps.setInt(2, kamarId);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
   
    public static int getTotalTransaksi(int idTransaksi) {
//        select SUM(harga) as total from item_transaksi_pesan inner join kamar on item_transaksi_pesan.kamar_id = kamar.id_kamar where item_transaksi_pesan.id_transaksi = ?;
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        int jlh = 0;
        ResultSet r = null;
        String query = "select SUM(harga) as total from item_transaksi_pesan inner join kamar on item_transaksi_pesan.kamar_id = kamar.id_kamar where item_transaksi_pesan.transaksi_pesan_id = ?";
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, idTransaksi);
            r = ps.executeQuery();
            if (r.next()) {
                jlh = r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jlh;
    }
    
    public static int getJumlah(int idtransaksipesan) {
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        int jlh = 0;
        ResultSet r = null;
        String query = "SELECT COUNT(*) AS jumlah FROM `item_transaksi_pesan` WHERE `transaksi_pesan_id` = ?";
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, idtransaksipesan);
            r = ps.executeQuery();
            if (r.next()) {
                jlh = r.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("JlH model " + jlh);
        return jlh;
    }
//    public static int getHarga(int idtransaksipesan) {
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        PreparedStatement ps = null;
//        int harga = 0;
//        ResultSet r = null;
//        String query = "SELECT COUNT(*) AS jumlah FROM `item_transaksi_pesan` WHERE `transaksi_pesan_id` = ?";
//        try {
//            ps = c.prepareStatement(query);
//            ps.setInt(1, idtransaksipesan);
//            r = ps.executeQuery();
//            if (r.next()) {
//                harga = r.getInt(1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("JlH model " + harga);
//        return harga;
//    }


    public static ArrayList<ItemTransaksi> getByTransaksiId(int idtransaksipesan) {
        ArrayList<ItemTransaksi> hasil = new ArrayList<>();
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        ResultSet r = null;
        String query = "SELECT * FROM item_transaksi_pesan WHERE transaksi_pesan_id = ?";
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, idtransaksipesan);
            r = ps.executeQuery();
            while (r.next()) {
                ItemTransaksi it = new ItemTransaksi();
                it.idTransaksi = r.getInt("id_transaksi");
                it.kamarId = r.getInt("kamar_id");
                it.transaksiPesanId = idtransaksipesan;
                it.kamar = Kamar.getByPK(it.kamarId);
                hasil.add(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasil;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getTransaksiPesanId() {
        return transaksiPesanId;
    }

    public void setTransaksiPesanId(int transaksiPesanId) {
        this.transaksiPesanId = transaksiPesanId;
    }

    public int getKamarId() {
        return kamarId;
    }

    public void setKamarId(int kamarId) {
        this.kamarId = kamarId;
        
    
    }
    

    public Kamar getKamar() {
        return kamar;
    }

    public void setKamar(Kamar kamar) {
        this.kamar = kamar;
    }

    public Tamu getTamu() {
        return tamu;
    }

    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }
}
