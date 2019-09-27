/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Software Institute
 */
public class Koneksi {
    
    private Connection c = null;

    public Connection getKoneksi() {
	if (c == null) {
	    try {
		String url = "jdbc:mysql://localhost/homestay";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		c = DriverManager.getConnection(url, username, password);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return c;
    }

    public void tutupKoneksi(PreparedStatement ps, ResultSet r, Connection c) {
	try {
	    ps.close();
	    r.close();
	    c.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void tutupKoneksi(ResultSet r, Connection c) {
	try {
	    r.close();
	    c.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	Koneksi k = new Koneksi();
	Connection conn = k.getKoneksi();
	if (conn == null) {
	    System.out.println("Koneksi Gagal");
	} else {
	    System.out.println("Koneksi Berhasil");
	}
    }
}
