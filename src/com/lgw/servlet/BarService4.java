package com.lgw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.lgw.dao.BarDao4;

public class BarService4 extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		BarDao4 barDao4=new BarDao4();
		String barArr4=barDao4.query();
		resp.setContentType("text/html;charset=utf-8");
		JSONArray json4=JSONArray.fromObject(barArr4);
		System.out.println(json4.toString());
		PrintWriter writer=resp.getWriter();
		writer.println(json4);
		writer.flush();
		writer.close();
	}
	
}
