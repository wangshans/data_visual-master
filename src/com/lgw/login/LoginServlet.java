package com.lgw.login;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
 

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://10.60.244.14:3306/blockchain?characterEncoding=utf8";
		
		String user = "root";
		
		String password = "1234";
		
		
		String username = request.getParameter("username");
		
		String psw = request.getParameter("psw");
		
		
		Connection conn = null;
		
		ResultSet rs = null;
		try{
			
			Class.forName(driver);
			
			conn = (Connection) DriverManager.getConnection(url, user, password);
		
			String sql = "select * from eth_userAndpsw where username=? and psw=?";
			//使用PreparedStatement，可以防止sql注入
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, psw);
			
			rs = ps.executeQuery();
			
			
			if (rs.next()){
				System.out.println("login ok!!");
				request.getSession().setAttribute("username", username);
				response.sendRedirect("index.jsp");
			}else{
				System.out.println("login fail!!");
				PrintWriter out = response.getWriter();
				out.flush();
				out.println("<script>");
				out.println("alert('很遗憾，用户名或密码错误');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			}
			
			ps.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		}
		doGet(request, response);
	}
 
}
