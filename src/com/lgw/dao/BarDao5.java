package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Bar5;

public class BarDao5 {
	public String query(){
		ArrayList<Bar5> barArr5=new ArrayList<Bar5>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8","root","1234");
			PreparedStatement stmt=conn.prepareStatement(
					"select distinct(user_address) as name, sum(token_balance) as value_ " +
							"from idm_token_user_profile " +
							"where token_address=\"0x05435983b4736d18d3c56e860d607f2825dc5d64\" and token_balance>0 " +
							"group by user_address;"
					);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Bar5 bar5=new Bar5();
				bar5.setName(rs.getString("name"));
				bar5.setValue(rs.getDouble("value_"));
				barArr5.add(bar5);
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Gson gson=new Gson();
		String str=gson.toJson(barArr5);
		System.out.println(barArr5);
		return str;
	}

}
