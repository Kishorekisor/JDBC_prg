package PrjLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminLog {
	
	private Connection con;
	
	// DB Connection code
	public AdminLog() {
		String dburl = "jdbc:mysql://localhost:3308/prjlogin";
		String dbuser = "root";
		String dbpass = "";	
		try {
			this.con = DriverManager.getConnection(dburl, dbuser, dbpass);
		}catch(SQLException e) {
			System.out.println("cannot be connected");
		}}
		
	//Admin login code
	public boolean adminLogin(String user, String pass) {
		boolean res = true;
		try {
			Statement smt = con.createStatement();
		String query = "select* from adminlogin where userName='"+user+"' and password='"+pass+"'";
		ResultSet rs = smt.executeQuery(query);
		
		}catch(SQLException e) {
			System.out.println("cannot proceed "+e);
		}
		return res;
	}

		// Insert code
	public int adminInsert(String userName,String name,String dateOfBirth,int mark1, int mark2,String dept,String email) {
		int c=0;
		try {
			String query = "insert into students (userName,sname,DOB,10thmark,12thmark,department,Email) values(?,?,?,?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(query);
			pst.setString(1,userName);
			pst.setString(2, name);
			pst.setString(3, dateOfBirth);
			pst.setInt(4,mark1);
			pst.setInt(5, mark2);
			pst.setString(6, dept);
			pst.setString(7, email);
			c = pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("cannot be proceed "+e);
		}
		return c;
	}
	
	// select code
	public void adminselect() {
		try {
		String query ="select* from students";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getString(8));
		}
		}catch(SQLException e) {
			System.out.println("cannot proceed "+e);
		}
	}
	
	
	//Update code
	public int adminupdate(String usr ,int mark1,int mark2,String email) {
		int c=0;
		try {
		String query = "update students set 10thmark=?,12thmark=?,email=?  where userName=?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,mark1);
		pst.setInt(2, mark2);
		pst.setString(3, email);
		pst.setString(4,usr);
		c=pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("cannot proceed "+e);
		}
		return c;
	}

	//Delete code
	public int admindelete( String user) {
		int c=0;
		try {
			String query = "delete *from students where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user);
			c=pst.executeUpdate();
		}catch(SQLException e) {
			System.out.println("cannot procee "+e);
		}
		return c;
	}	
	



}


