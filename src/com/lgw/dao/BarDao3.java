package com.lgw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.lgw.bean.Bar3;


public class BarDao3 {
	public String query(){
		ArrayList<Bar3> barArr3=new ArrayList<Bar3>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8","root","1234"
					);
			PreparedStatement stmt=conn.prepareStatement(
					"select user_address_cnt,out_tx_cnt,sum_value_1d,in_address_cnt_1d,tx_cnt_1d,out_sum_value " +
							"from idm_token_profile order by user_address_cnt desc limit 1;");
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				Bar3 bar3=new Bar3();
				//bar3.setToken_address(rs.getString("token_address"));
				bar3.setUser_address_cnt(rs.getDouble("user_address_cnt"));
				//bar3.setOut_sum_value(rs.getDouble("out_sum_value"));
				//bar3.setIn_sum_value(rs.getDouble("in_sum_value"));
				//bar3.setIn_tx_cnt(rs.getDouble("in_tx_cnt"));
				bar3.setOut_sum_value(rs.getDouble("out_sum_value"));
				bar3.setOut_tx_cnt(rs.getDouble("out_tx_cnt"));
				//bar3.setOut_address_cnt_1d(rs.getDouble("out_address_cnt_1d"));
				bar3.setIn_address_cnt_1d(rs.getDouble("in_address_cnt_1d"));
				//bar3.setToken_balance(rs.getDouble("token_balance"));
				bar3.setSum_value_1d(rs.getDouble("sum_value_1d"));
				bar3.setTx_cnt_1d(rs.getDouble("tx_cnt_1d"));
				barArr3.add(bar3);
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		Gson gson=new Gson();
		String str=gson.toJson(barArr3);
		return str;
	}

}
