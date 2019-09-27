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
 * @author Software Institute
 */
public class Kamar {
    private int idKamar =0;
    private String typeKamar ="";
    private String hargaKamar ="";
    private String fasilitasKamar ="";
    private int stock=0;

    public static ArrayList<Kamar> getSearch(String keyword) {
	ArrayList<Kamar> hasil = new ArrayList<>();
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Kamar where type_kamar like concat('%',?,'%') OR fasilitas like concat('%',?,'%') ";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
            ps.setString(1, keyword);
            ps.setString(2, keyword);
	    r = ps.executeQuery();
	    while (r.next()) {
		//1.Ciptakan objek Buku
		Kamar kr = new Kamar();
		kr.idKamar = r.getInt("id_kamar");
		kr.typeKamar = r.getString("type_kamar");
		kr.hargaKamar = r.getString("harga");
		kr.fasilitasKamar = r.getString("fasilitas");
		kr.stock = r.getInt("stock");
		hasil.add(kr);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    k.tutupKoneksi(ps, r, c);
	}
	return hasil;
    }
    
    public static ArrayList<Kamar> getAll() {
	ArrayList<Kamar> hasil = new ArrayList<>();
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Kamar";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    r = ps.executeQuery();
	    while (r.next()) {
		//1.Ciptakan objek Buku
		Kamar kr = new Kamar();
		kr.idKamar = r.getInt("id_kamar");
		kr.typeKamar = r.getString("type_kamar");
		kr.hargaKamar = r.getString("harga");
		kr.fasilitasKamar = r.getString("fasilitas");
		kr.stock = r.getInt("stock");
		hasil.add(kr);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    k.tutupKoneksi(ps, r, c);
	}
	return hasil;
    }

    //get By Primary key
    public static Kamar getByPK(int id) {
	Kamar kr = null;
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Kamar where id_kamar=?";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, id);
	    r = ps.executeQuery();
	    if (r.next()) {
		kr = new Kamar();
		kr.idKamar = r.getInt("id_kamar");
		kr.typeKamar = r.getString("type_kamar");
		kr.hargaKamar = r.getString("harga");
		kr.fasilitasKamar = r.getString("fasilitas");
		kr.stock = r.getInt("stock");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    k.tutupKoneksi(ps, r, c);
	}
	return kr;
    }

    public void insertData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "insert into Kamar(type_kamar,harga,fasilitas,stock) "
		+ "values (?,?,?,?)";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.typeKamar);
	    ps.setString(2, this.hargaKamar);
	    ps.setString(3, this.fasilitasKamar);
	    ps.setInt(4, this.stock);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {

	}
    }

    public void deleteData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "delete from Kamar where id_kamar=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, this.idKamar);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void updateData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "update Kamar set type_kamar=?,harga=?,fasilitas=?,stock=? where id_kamar=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.typeKamar);
	    ps.setString(2, this.hargaKamar);
	    ps.setString(3, this.fasilitasKamar);
	    ps.setInt(4, this.stock);
	    ps.setInt(5, this.idKamar);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public int getIdKamar() {
        return idKamar;
    }

    public void setIdKamar(int idKamar) {
        this.idKamar = idKamar;
    }

    public String getTypeKamar() {
        return typeKamar;
    }

    public void setTypeKamar(String typeKamar) {
        this.typeKamar = typeKamar;
    }

    public String getHargaKamar() {
        return hargaKamar;
    }

    public void setHargaKamar(String hargaKamar) {
        this.hargaKamar = hargaKamar;
    }

    public String getFasilitasKamar() {
        return fasilitasKamar;
    }

    public void setFasilitasKamar(String fasilitasKamar) {
        this.fasilitasKamar = fasilitasKamar;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
