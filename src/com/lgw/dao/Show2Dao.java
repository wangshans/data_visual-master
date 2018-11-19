package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Show2;

public class Show2Dao {
	public String query() {
		ArrayList<Show2> barArr_show2 = new ArrayList<Show2>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement("SELECT address_tx_all,tx_all,type,title FROM top_user_tx_all;"
					);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Show2 show2 = new Show2();
				show2.setAddress_tx_all(rs.getString("address_tx_all"));
				show2.setTx_all(rs.getLong("tx_all"));
				show2.setType(rs.getString("type"));
				show2.setTitle(rs.getString("title"));
			
				barArr_show2.add(show2);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson =new Gson();
		String str=gson.toJson(barArr_show2);
		
		return str;
}}
