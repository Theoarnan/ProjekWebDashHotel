package com.homestay.model ;

import connection.Koneksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Pembayaran {
private int idPembayaran;
private String lamaSewa;
private String tanggalKeluar;
private int totalBiaya;
private int id_bayarPesan;
private TransaksiPesan transaksiPesan;

//public void insertData() {
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        String sql = "insert into Pembayaran"
//                + "lama_sewa,total_biaya,id_bayarpesan"
//                + "values (?,?,?)";
//        
//        PreparedStatement ps = null;
//        try {
//            ps = c.prepareStatement(sql);
//            ps.setString(1, this.lamaSewa);
//            ps.setInt(2, this.totalBiaya);
//            ps.setInt(3, this.id_bayarPesan);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//    }
public void simpanData() {
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        ResultSet r = null;
        String query = "insert into Pembayaran(lama_sewa,tanggal_keluar,total_biaya,id_bayarpesan) "
                + "values (?,?,?,?)";
//        Pengaturan p = Pengaturan.getPengaturan();
        
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, this.lamaSewa );
            ps.setString(2, this.tanggalKeluar);
            ps.setInt(2, this.totalBiaya);
            ps.setInt(3, this.id_bayarPesan);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Pembayaran getByTransaksiPesanId(int id_bayarPesan) {
        Koneksi k = new Koneksi();
        Connection c = k.getKoneksi();
        PreparedStatement ps = null;
        ResultSet r = null;
        Pembayaran trx = null;
        String query = "select * from Pembayaran where id_bayarpesan=?";
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id_bayarPesan);
            r = ps.executeQuery();
            if (r.next()) {
                trx = new Pembayaran();
                trx.idPembayaran = r.getInt("id_pembayaran");
                trx.lamaSewa = r.getString("lama_sewa");
                trx.tanggalKeluar = r.getString("tanggal_keluar");
                trx.totalBiaya = r.getInt("total_biaya");
                trx.id_bayarPesan = r.getInt("id_bayarpesan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trx;
    }

//    public static ArrayList<Pembayaran> getAll() {
//        ArrayList<Pembayaran> hasil = new ArrayList();
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        String sql = "select * from Pembayaran";
//        PreparedStatement ps = null;
//        ResultSet r = null;
//        try {
//            ps = c.prepareStatement(sql);
//            r = ps.executeQuery();
//            while (r.next()) {
//                Pembayaran pk = new Pembayaran();
//                pk.idPembayaran = r.getInt("id_pembayaran");
//                pk.lamaSewa= r.getString("lama_sewa");
//                pk.totalBiaya= r.getInt("total_biaya");
//                pk.id_bayarPesan = r.getInt("id_bayarpesan");
//                pk.tp = TransaksiPesan.getById(pk.id_bayarPesan);
//                hasil.add(pk);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return hasil;
//    }
//
//    public static Pembayaran getByPK(int id) {
//        Pembayaran pk = null;
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        String sql = "select * from Pembayaran where id_pembayaran=?";
//        PreparedStatement ps = null;
//        ResultSet r = null;
//        try {
//            ps = c.prepareStatement(sql);
//            ps.setInt(1, id);
//            r = ps.executeQuery();
//            if (r.next()) {
//                pk = new Pembayaran();
//                pk.idPembayaran = r.getInt("id_pembayaran");
//                pk.lamaSewa = r.getString("lama_sewa");
//                pk.totalBiaya= r.getInt("total_biaya");
//                pk.id_bayarPesan = r.getInt("id_pesanbayar");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pk;
//    }
//
//    public void updateData() {
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        String sql = "update Pembayaran set lama_sewa=?,total_biaya=?,id_bayarpesan=? where id_pembayaran=?";
//        PreparedStatement ps = null;
//        try {
//            ps = c.prepareStatement(sql);
//            ps.setString(1, this.lamaSewa);
//            ps.setInt(2, this.totalBiaya);
//            ps.setInt(3, this.id_bayarPesan);
//            ps.setInt(4, this.idPembayaran);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void deleteData() {
//        Koneksi k = new Koneksi();
//        Connection c = k.getKoneksi();
//        String sql = "delete from Pembayaran where id_pembayaran=?";
//        PreparedStatement ps = null;
//        try {
//            ps = c.prepareStatement(sql);
//            ps.setInt(1, this.idPembayaran);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    
    
    public int getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(int idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    

    public int getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(int totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public int getId_bayarPesan() {
        return id_bayarPesan;
    }

    public void setId_bayarPesan(int id_bayarPesan) {
        this.id_bayarPesan = id_bayarPesan;
    }

    public String getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(String lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public String getTanggalKeluar() {
        return tanggalKeluar;
    }

    public void setTanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }

    public TransaksiPesan getTransaksiPesan() {
        return transaksiPesan;
    }

    public void setTransaksiPesan(TransaksiPesan transaksiPesan) {
        this.transaksiPesan = transaksiPesan;
    }

}
