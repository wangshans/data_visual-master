package com.lgw.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lgw.dao.BarDao2;

import net.sf.json.JSONArray;

public class BarService2 extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		BarDao2 barDao2 = new BarDao2();
		String barArr2 = barDao2.query();
		resp.setContentType("text/html; charset=utf-8");
		JSONArray json2 = JSONArray.fromObject(barArr2);
		System.out.println(json2.toString());
		PrintWriter writer = resp.getWriter();
		writer.println(json2);
		writer.flush();
		writer.close();
	}
}
