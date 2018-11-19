package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.Gson;
import com.lgw.bean.Bar;

public class BarDao {

	public String query() {
		ArrayList<Bar> barArr = new ArrayList<Bar>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8", "root", "1234");
			PreparedStatement stmt = conn.prepareStatement(
//					"SELECT DATE(datelist) AS NAME,COUNT(*)-1 AS num " +
//				" FROM( SELECT datelist FROM ht_calendar_"+
//			            " WHERE DATE(datelist)<=DATE(CURDATE())"+
//			        " UNION ALL"+
//			        " SELECT active_time_ FROM tdx_sale_ticket) a"+
//			" GROUP BY name"
					"select txdate as name, COUNT(txdate) AS num from eth_contracts group by txdate"
			        );
			ResultSet rs = stmt.executeQuery();
			
			
			
			while(rs.next()) {
				Bar bar = new Bar();
				bar.setName(rs.getString("name"));
				bar.setNum(rs.getInt("num"));
				barArr.add(bar);
			}
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Gson gson =new Gson();
		String str=gson.toJson(barArr);
		
		return str;
	}

}
