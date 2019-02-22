package com.vj.controller;

import java.sql.ResultSet;

import com.vj.dao.DbHelper;
import com.vj.model.Admin;

public class AdminController {
public static Admin checkAdminLogin(int id,String password){
	try{
		String query="select * from admin where adminid="+id+" and password='"+password+"'";
		ResultSet rs = DbHelper.executeQuery(query);
		if(rs.next()){
			Admin A = new Admin();
			A.setAdminid(rs.getInt(1));
			A.setAdminname(rs.getString(2));
			A.setPassword(rs.getString(3));
			A.setPicture(rs.getString(4));
			return A;
		}
		return null;
	}catch(Exception e){
		System.out.println("Error:checkAdminLogin()"+e);
	}
	return null;
}
}
