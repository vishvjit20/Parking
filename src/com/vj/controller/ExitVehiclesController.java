package com.vj.controller;

import com.vj.dao.DbHelper;
import com.vj.model.ExitVehicles;

public class ExitVehiclesController {
public static boolean addNewRecord(ExitVehicles V){
	try{
		String query = "insert into exitvehicles(transactionid,vehicleid,exitdate,exittime,employeeid) values("+V.getTransactionid()+","+V.getVehicleid()+",'"+V.getExitdate()+"','"+V.getExittime()+"',"+V.getEmployeeid()+")";
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:addNewRecord()"+e);
	}
	return false;
}
}
