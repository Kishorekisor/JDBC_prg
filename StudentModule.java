package PrjLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentModule {
	private Connection con;
	public StudentModule() {
		String dburl = "jdbc:mysql://localhost:3308/prjlogin";
		String dbuser = "root";
		String dbpass = "";	
		try {
			this.con = DriverManager.getConnection(dburl, dbuser, dbpass);
		}catch(SQLException e) {
			System.out.println("cannot be connected");
		}}
	
	// StudentSigin 
	public int stuentSigin(String user, String pass) {
		int c=0;
		try {
		String query = "insert into studentLogin values (?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,user);
		pst.setString(2, pass);
		c = pst.executeUpdate();
	}catch(SQLException e) {
		System.out.println("Cannot proceed "+e);
	}
		
		return c;
	}
	
	// userlogin code
	public boolean userLogin(String user, String pass) {
		boolean res = true;
		
		try {
			Statement smt =con.createStatement();
		String query = "select* from studentlogin where userName='"+user+"' and password='"+pass+"'";
		ResultSet rs = smt.executeQuery(query);
		
		if(rs.next()) {
			res	=true;
		}else {
			res=false;
		}
		
		}catch(SQLException e) {
			System.out.println("cannot proceed "+e);
		}
		
		return res;
	}

	public void studentSelect(String user) {
		
		try {
			String query = "select* from students where userName='"+user+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6)+" "+rs.getString(7)+" "+rs.getString(8));
			}
			}catch(SQLException e) {
				System.out.println("cannot proceed "+e);
			}
			}
	
	
	//student update
	public int studentUpdate(String usr ,int mark1,int mark2,String email) {
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

	//delete code
	public int studentDelete( String user) {
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


