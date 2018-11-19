package com.lgw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.JsonObject;
import com.lgw.dao.BarDao3;

public class BarService3 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		BarDao3 barDao3=new BarDao3();
		String barArr3=barDao3.query();
		resp.setContentType("text/html;charset=utf-8");
		JSONArray json=JSONArray.fromObject(barArr3);
		//HashMap<String, Object> res_map = new HashMap<String, Object>();
		//ArrayList<ArrayList<HashMap<String, Object>>> al=new ArrayList<ArrayList<HashMap<String, Object>>>();
		ArrayList<HashMap<String, Object>> res_list = new ArrayList<HashMap<String, Object>>();
		//ArrayList<String> col_list = new ArrayList<String>();
		for (int i = 0; i < json.size(); i++) {
			ArrayList<Double> child_list = new ArrayList<Double>();
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("user_address_cnt")));
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("out_tx_cnt")));
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("sum_value_1d")));
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("in_address_cnt_1d")));
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("tx_cnt_1d")));
			child_list.add(Double.parseDouble(json.getJSONObject(i).getString("out_sum_value")));
			
		
			HashMap<String, Object> child_map = new HashMap<String, Object>();
			child_map.put("value", child_list);
			res_list.add(child_map);
			System.out.println(i);
		}
		
		//res_map.put("data", res_list);
		//al.add(res_list);
		PrintWriter writer=resp.getWriter();
		
		JSONArray res_json=JSONArray.fromObject(res_list);
		System.out.println(res_json.toString());
		writer.println(res_json);
		writer.flush();
		writer.close();
	}
	

}
