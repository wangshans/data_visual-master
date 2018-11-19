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

import com.lgw.dao.BarDao5;

public class BarService5 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		BarDao5 barDao5=new BarDao5();
		String barArr5=barDao5.query();
		resp.setContentType("text/html;charset=utf-8");
		JSONArray json=JSONArray.fromObject(barArr5);
		//HashMap<String, Object> res_map = new HashMap<String, Object>();
		//ArrayList<ArrayList<HashMap<String, Object>>> al=new ArrayList<ArrayList<HashMap<String, Object>>>();
		ArrayList<HashMap<String, Object>> res_list = new ArrayList<HashMap<String, Object>>();
		//ArrayList<String> col_list = new ArrayList<String>();
		for (int i = 0; i < json.size(); i++) {
			HashMap<String, Object> child_map = new HashMap<String, Object>();
			child_map.put("name", "\'"+json.getJSONObject(i).getString("name")+"\'");
			child_map.put("value", Double.parseDouble(json.getJSONObject(i).getString("value")));
			res_list.add(child_map);
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
