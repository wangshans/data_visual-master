package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Bar2;

public class BarDao2 {
	public String query() {
		ArrayList<Bar2> barArr2 = new ArrayList<Bar2>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement("SELECT address,txdate FROM eth_contracts ORDER BY txdate DESC LIMIT 1000;"
					);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Bar2 bar2 = new Bar2();
				bar2.setId(rs.getString("address"));
				bar2.setDate(rs.getString("txdate"));
			
				barArr2.add(bar2);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson =new Gson();
		String str=gson.toJson(barArr2);
		
		return str;
	}

}
