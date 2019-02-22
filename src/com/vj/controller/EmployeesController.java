package com.vj.controller;

import java.sql.ResultSet;

import com.vj.dao.DbHelper;
import com.vj.model.Employees;

public class EmployeesController {
	public static Employees checkLogin(int eid,String password){
		try{
			String query = "select * from employees where employeeid="+eid+" and password='"+password+"'";
			ResultSet rs = DbHelper.executeQuery(query);
			if(rs.next()){
				Employees E = new Employees();
				E.setEmployeeid(rs.getInt(1));
				E.setEmployeename(rs.getString(2));
				E.setPassword(rs.getString(13));
				E.setPicture(rs.getString(12));
				return E;
			}
			return null;
		}catch(Exception e){
			System.out.println("Error:checkLogin()"+e);
		}
		return null;
	}
	public static boolean addNewRecord(Employees E)
	{try{
	 String query="insert into employees(employeename,gender,dob,address,state,city,designation,salary,email,mobileno,picture,password) values('"+E.getEmployeename()+"','"+E.getGender()+"','"+E.getDob()+"','"+E.getAddress()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getDesignation()+"','"+E.getSalary()+"','"+E.getEmail()+"','"+E.getMobileno()+"','"+E.getPicture()+"','"+E.getPassword()+"')";
	 boolean status=DbHelper.executeUpdate(query);
	 return(status);
		
	}catch(Exception e)
	{ System.out.println("Error:addNewRecord()"+e);
		}
	return(false);	
	}
	public static ResultSet displayAll(){
		try{
			String query = "select E.employeeid,E.employeename,E.gender,E.dob,E.address,E.state,E.city,E.designation,E.salary,E.email,E.mobileno,E.picture,(select statename from states S where S.stateid=E.state),(select cityname from cities C where C.cityid=E.city) from employees E";
            ResultSet rs = DbHelper.executeQuery(query);
            return rs;
		}catch(Exception e){
			System.out.println("Error:displayAll()"+e);
		}
		return null;
	}
	public static Employees displayById(int eid){
		try{
			String query = "select E.employeeid,E.employeename,E.gender,E.dob,E.address,E.state,E.city,E.designation,E.salary,E.email,E.mobileno,E.picture,(select statename from states S where S.stateid=E.state),(select cityname from cities C where C.cityid=E.city),E.password from employees E where E.employeeid="+eid;
			ResultSet rs = DbHelper.executeQuery(query);
			if(rs.next()){
				Employees E = new Employees();
				E.setEmployeeid(rs.getInt(1));
				E.setEmployeename(rs.getString(2));
				E.setGender(rs.getString(3));
				E.setDob(rs.getString(4));
				E.setAddress(rs.getString(5));
				E.setState(rs.getString(6)+","+rs.getString(13));
				E.setCity(rs.getString(7)+","+rs.getString(14));
				E.setDesignation(rs.getString(8));
				E.setSalary(rs.getString(9));
				E.setEmail(rs.getString(10));
				E.setMobileno(rs.getString(11));
				E.setPicture(rs.getString(12));
				E.setPassword(rs.getString(15));
				return E;
			}
			return null;
		}catch(Exception e){
			System.out.println("Error:displayById()"+e);
		}
		return null;
	}
	public static boolean editRecord(Employees E){
		try{
			String query="update employees set employeename='"+E.getEmployeename()+"',gender='"+E.getGender()+"',dob='"+E.getDob()+"',address='"+E.getAddress()+"',state='"+E.getState()+"',city='"+E.getCity()+"',designation='"+E.getDesignation()+"',salary="+E.getSalary()+",email='"+E.getEmail()+"',mobileno='"+E.getMobileno()+"',password='"+E.getPassword()+"' where employeeid="+E.getEmployeeid();
		    boolean st = DbHelper.executeUpdate(query);
		    return st;
		}catch(Exception e){
			System.out.println("Error:editPicture()"+e);
		}
		return false;
	}
	public static boolean editPicture(int eid,String filename){
		try{
			String query = "update employees set picture='"+filename+"' where employeeid="+eid;
			boolean st = DbHelper.executeUpdate(query);
			return st;
		}catch(Exception e){
			System.out.println("Error:editPicture()"+e);
		}
		return false;
	}
	public static boolean deleteRecord(int eid){
		try{
			String query = "delete from employees where employeeid="+eid;
			boolean st = DbHelper.executeUpdate(query);
			return st;
		}catch(Exception e){
			System.out.println("Error:deleteRecord()"+e);
		}
		return false;
	}
	public static ResultSet displayId(int employeeid){
		try{
			String query = "select * from employees where employeeid="+employeeid;
		}catch(Exception e){
			System.out.println("Error:displayId()");
		}
		return null;
	}
	public static boolean displayPicture(){
		try{
			String query = "select * from employees";
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
}
