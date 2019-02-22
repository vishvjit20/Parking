package com.vj.controller;

import java.sql.ResultSet;
import java.util.Calendar;

import com.vj.dao.DbHelper;
import com.vj.model.Floors;

public class FloorController {
public static boolean addNewFloor(Floors F){
	try{
		String query = "insert into floors(floorno,floorname,totalspace) values("+F.getFloorno()+",'"+F.getFloorname()+"','"+F.getTotalspace()+"')";
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:addNewFloor()"+e);
	}
	return false;
}
public static ResultSet fetchAllFloors(){
	try{
		String query = "select * from floors";
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:fetchAllFloors()"+e);
	}
	return null;
}
public static ResultSet fetchTotalSpace(int flno){
	try{
		Calendar C = Calendar.getInstance();
		String cd = C.get(Calendar.YEAR)+"/"+(C.get(Calendar.MONTH)+1)+"/"+C.get(Calendar.DATE);
		String query = "select f.totalspace,count(v.floorno) as totalvehicle,(f.totalspace-count(v.floorno)) as avl_space from floors f,vehicles v where v.floorno=f.floorno and v.floorno = "+flno+" and v.entrydate='"+cd+"' group by v.floorno";
		System.out.println(query);
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:fetchTotalSpace()"+e);
	}
	return null;
}
}
