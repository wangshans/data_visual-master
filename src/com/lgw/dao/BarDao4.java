package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Bar4;

public class BarDao4 {
	public String query(){
		ArrayList<Bar4> barArr4=new ArrayList<Bar4>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8","root","1234");
			PreparedStatement stmt=conn.prepareStatement(
					"SELECT rank,token_address,user_address,out_sum_value,out_tx_cnt,in_sum_value,in_tx_cnt,token_balance,stat_dt FROM idm_token_user_profile ORDER BY rank asc limit 1000;"
					);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Bar4 bar4=new Bar4();
				bar4.setRank(rs.getInt("rank"));
				bar4.setToken_address(rs.getString("token_address"));
				bar4.setUser_address(rs.getString("user_address"));
				bar4.setOut_sum_value(rs.getString("out_sum_value"+""));
		
				bar4.setOut_tx_cnt(rs.getString("out_tx_cnt"+""));
				bar4.setIn_sum_value(rs.getString("in_sum_value"+""));
				bar4.setIn_tx_cnt(rs.getString("in_tx_cnt"+""));
				bar4.setToken_balance(rs.getString("token_balance"));
				bar4.setStat_dt(rs.getString("stat_dt"));
				barArr4.add(bar4);
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Gson gson=new Gson();
		String str=gson.toJson(barArr4);
		return str;
	}

}
