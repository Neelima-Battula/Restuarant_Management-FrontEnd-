import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException*/
public class LoginServlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
String username=req.getParameter("username");
String password=req.getParameter("password");
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","Neelima@518");
Statement stm=con.createStatement();
ResultSet rs=stm.executeQuery("select * from user where username='"+username+"' and password='"+password+"'");
if (rs.next()){
res.sendRedirect("home.html");
}else{
res.sendRedirect("wrong.html");
}
con.close();
}
catch(Exception e){
System.out.println(e.getMessage());
}
}
}  