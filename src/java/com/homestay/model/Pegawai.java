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
public class Pegawai {
    private int idPegawai =0;
    private String namaPegawai ="";

    public int getIdPegawai() {
        return idPegawai;
    }
    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }
    public String getNamaPegawai() {
        return namaPegawai;
    }
    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public static ArrayList<Pegawai> getAll() {
	ArrayList<Pegawai> hasil = new ArrayList<>();
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Pegawai";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    r = ps.executeQuery();
	    while (r.next()) {
		//1.Ciptakan objek Anggota
		Pegawai kr = new Pegawai();
		kr.idPegawai = r.getInt("id_pegawai");
		kr.namaPegawai = r.getString("nama_pegawai");
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
    public static Pegawai getByPK(int id) {
	Pegawai kr = null;
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "select * from Pegawai where id_pegawai=?";
	PreparedStatement ps = null;
	ResultSet r = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, id);
	    r = ps.executeQuery();
	    if (r.next()) {
                kr = new Pegawai();
                kr.idPegawai = r.getInt("id_pegawai");
		kr.namaPegawai = r.getString("nama_pegawai");
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
	String sql = "insert into Pegawai(nama_pegawai) "
		+ "values (?)";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.namaPegawai);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {

	}
    }

    public void deleteData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "delete from Pegawai where id_pegawai=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setInt(1, this.idPegawai);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void updateData() {
	Koneksi k = new Koneksi();
	Connection c = k.getKoneksi();
	String sql = "update Pegawai set nama_pegawai=? where id_pegawai=?";
	PreparedStatement ps = null;
	try {
	    ps = c.prepareStatement(sql);
	    ps.setString(1, this.namaPegawai);
	    ps.setInt(2, this.idPegawai);
	    ps.executeUpdate();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
