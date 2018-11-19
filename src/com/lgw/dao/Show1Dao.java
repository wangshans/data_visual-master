package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Show1;

public class Show1Dao {
	public String query() {
		ArrayList<Show1> barArr_show1 = new ArrayList<Show1>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement("SELECT address,tx_1d,type,title FROM top_user_tx_lastday;"
					);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Show1 show1 = new Show1();
				show1.setAddress(rs.getString("address"));
				show1.setTx_1d(rs.getLong("tx_1d"));
				show1.setType(rs.getString("type"));
				show1.setTitle(rs.getString("title"));
			
				barArr_show1.add(show1);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson =new Gson();
		String str=gson.toJson(barArr_show1);
		
		return str;
}}
