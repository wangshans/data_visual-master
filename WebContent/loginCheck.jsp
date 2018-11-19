<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
      <%  
              if(session.getAttribute("username") == null) {    
    %>  
           <script type="text/javascript">      
             alert("您还没有登录，请登录..."); 
            top.location.href="login.html";
            </script> 
    <%  
        }  
    %>  	
