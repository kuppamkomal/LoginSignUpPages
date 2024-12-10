import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Model {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String path = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/kodapp";
	String user = "root";
	String pwd = "Kkn@123454";
	String sql1 = "insert into koduser values(?,?,?,?,?,?)";
	String sql2 = "select * from koduser where id=? and password=?";
	PrintWriter pw = null;
	
	public Model() {
		try {
			Class.forName(path);
			con = DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean performLogin(String id,String password) {
		try {
			ps = con.prepareStatement(sql2);
			ps.setString(1,id);
			ps.setString(2,password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean performSignup(String id,String password,String name,String email,String gender,int phone) {
		try {
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, email);
			ps.setString(5, gender);
			ps.setInt(6, phone);
			
			int nora = ps.executeUpdate();
			
			if(nora==1) {
				return true;
			}			
		}
		catch(Exception e) {
			
		}
		return false;
	}
}
