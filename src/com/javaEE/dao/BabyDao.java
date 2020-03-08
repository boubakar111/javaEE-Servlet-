package com.javaEE.dao;
import java.sql.*;
import java.util.*;

import com.javaEE.bean.Baby;


public class BabyDao {

	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/baby","root","");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static int save(Baby b){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("insert into babyname(name,prenom,sex,region) values(?,?,?,?)");
			ps.setString(1,b.getName());
			ps.setString(2,b.getPrenom());
			ps.setString(3,b.getSex());
			ps.setString(4,b.getRegion());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("delete from babyname where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static List<Baby> getAllRecords(){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrenom(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setRegion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static List<Baby> getRecordsByStart(String start){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname where name like '"+start+"%' ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrenom(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setRegion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public static List<Baby> getRecordsByRegion(String region){
		List<Baby> list=new ArrayList<Baby>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from babyname where region=? ");
			ps.setString(1,region);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Baby b=new Baby();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPrenom(rs.getString(3));
				b.setSex(rs.getString(4));
				b.setRegion(rs.getString(5));
				list.add(b);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
}
