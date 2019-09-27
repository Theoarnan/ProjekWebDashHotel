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
public class Tamu {
    private int idTamu =0;
    private String namaTamu ="";
    private String kartuIdentitas ="";
    private String noTelpon="";

    public int getIdTamu() {
        return idTamu;
    }
    public void setIdTamu(int idTamu) {
        this.idTamu = idTamu;
    }
    public String getNamaTamu() {
        return namaTamu;
    }
    public void setNamaTamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }
    public String getKartuIdentitas() {
        return kartuIdentitas;
    }
    public void setKartuIdentitas(String kartuIdentitas) {
        this.kartuIdentitas = kartuIdentitas;
    }
    public String getNoTelpon() {
        return noTelpon;
    }
    public void setNoTelpon(String noTelpon) {
        this.noTelpon = noTelpon;
    }

    public static ArrayList<Tamu> getAll() {
	ArrayList<Tamu> hasil = new ArrayList<>();
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Tamu";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    r = ps.executeQuery();
	    while (r.next()) {
		//1.Ciptakan objek Anggota
		Tamu kr = new Tamu();
		kr.idTamu = r.getInt("id_tamu");
		kr.namaTamu = r.getString("nama_tamu");
		kr.kartuIdentitas = r.getString("kartu_identitas");
		kr.noTelpon = r.getString("no_telp");
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
    public static Tamu getByPK(int id) {
	Tamu kr = null;
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Tamu where id_tamu=?";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, id);
	    r = ps.executeQuery();
	    if (r.next()) {
                kr = new Tamu();
		kr.idTamu = r.getInt("id_tamu");
		kr.namaTamu = r.getString("nama_tamu");
		kr.kartuIdentitas = r.getString("kartu_identitas");
		kr.noTelpon = r.getString("no_telp");
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
	String sql = "insert into Tamu(nama_tamu,kartu_identitas,no_telp) "
		+ "values (?,?,?)";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.namaTamu);
	    ps.setString(2, this.kartuIdentitas);
	    ps.setString(3, this.noTelpon);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {

	}
    }

    public void deleteData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "delete from Tamu where id_tamu=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, this.idTamu);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void updateData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "update Tamu set nama_tamu=?,kartu_identitas=?,no_telp=? where id_tamu=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.namaTamu);
	    ps.setString(2, this.kartuIdentitas);
	    ps.setString(3, this.noTelpon);
	    ps.setInt(4, this.idTamu);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
