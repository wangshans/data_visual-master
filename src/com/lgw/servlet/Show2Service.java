package com.lgw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.lgw.dao.Show2Dao;

public class Show2Service extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Show2Dao show2Dao=new Show2Dao();
		String barArr_show2=show2Dao.query();
		resp.setContentType("text/html;charset=utf-8");
		JSONArray json=JSONArray.fromObject(barArr_show2);
		System.out.println(json.toString());
		PrintWriter writer=resp.getWriter();
		writer.println(json);
		writer.flush();
		writer.close();
	}

}