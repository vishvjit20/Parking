 package com.vj.controller;

import java.sql.ResultSet;

import com.vj.dao.DbHelper;
import com.vj.model.Vehicles;

public class VehiclesController {
public static boolean addNewVehicles(Vehicles V){
	try{
		String query = "insert into vehicles(employeeid,rfid_no,reg_no,entrydate,entrytime,amount,time,status,floorno,mobileno) values('"+V.getEmployeeid()+"','"+V.getRfid_no()+"','"+V.getReg_no()+"','"+V.getEntrydate()+"','"+V.getEntrytime()+"','"+V.getAmount()+"','"+V.getTime()+"','"+V.getStatus()+"','"+V.getFloorno()+"','"+V.getMobileno()+"')";
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:addNewVehicles()"+e);
	}
	return false;
}
public static ResultSet displayAllVehicles(){
	try{
		String query = "select v.vehicleid,v.employeeid,v.rfid_no,v.reg_no,v.entrydate,v.entrytime,v.amount,v.time,v.status,v.floorno,v.mobileno,(select f.floorname from floors f where f.floorno=v.floorno) from vehicles v";
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:displayAllVehicles()"+e);
	}
	return null;
}
public static Vehicles dislayVehicleById(int vid){
	try{
		String query = "select v.vehicleid,v.employeeid,v.rfid_no,v.reg_no,v.entrydate,v.entrytime,v.amount,v.time,v.status,v.floorno,v.mobileno from vehicles v where v.vehicleid="+vid;
		ResultSet rs = DbHelper.executeQuery(query);
		if(rs.next()){
			Vehicles v = new Vehicles();
			v.setVehicleid(rs.getInt(1));
			v.setEmployeeid(rs.getString(2));
			v.setRfid_no(rs.getString(3));
			v.setReg_no(rs.getString(4));
			
			v.setAmount(rs.getString(7));
			v.setTime(rs.getString(8));
			v.setStatus(rs.getString(9));
			v.setFloorno(rs.getString(10));
			v.setMobileno(rs.getString(11));
			return v;
		}
		return null;
	}catch(Exception e){
		System.out.println("Error:displayVehicleById()"+e);
	}
	return null;
}
public static boolean editRecord(Vehicles V){
	try{
		String query = "update vehicles set vehicleid="+V.getVehicleid()+",employeeid='"+V.getEmployeeid()+"',rfid_no='"+V.getRfid_no()+"',reg_no='"+V.getReg_no()+"',amount='"+V.getAmount()+"',time='"+V.getTime()+"',status='"+V.getStatus()+"',floorno='"+V.getFloorno()+"',mobileno='"+V.getMobileno()+"' where vehicleid="+V.getVehicleid();
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:editRecord()"+e);
	}
	return false;
}
public static boolean deleteRecord(int vid){
	try{
		String query = "delete from vehicles where vehicleid="+vid;
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:deleteRecord()"+e);
	}
	return false;
}
public static ResultSet displayByRfid(String rfid){
	try{
		String query = "select * from vehicles where rfid_no='"+rfid+"' and status='IN'";
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:displayByRfid()"+e);
	}
	return null;
}
public static boolean updateStatus(int vid){
	try{
		String query = "update vehicles set status='OUT' where vehicleid="+vid;
		boolean st = DbHelper.executeUpdate(query);
		return st;
	}catch(Exception e){
		System.out.println("Error:updateStatus()"+e);
	}
	return false;
}
/**
public static ResultSet displayByDate(String entrydate){
	try{
		String query = "select * from vehicles where entrydate="+entrydate;
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:displayByDate()"+e);
	}
	return null;
}*/
public static ResultSet SearchBetweenTwoDates(String datefrom,String dateto){
	try{
		String query = "select * from vehicles where entrydate between '"+datefrom+"' and '"+dateto+"'";
		ResultSet rs = DbHelper.executeQuery(query);
		return rs;
	}catch(Exception e){
		System.out.println("Error:SearchBetweenTwoDates()"+e);
	}
	return null;
}
/*public static String ReadRFID(){
	try{
		String query = "select * from rfid";
		ResultSet rs = DbHelper.executeQuery(query);
		if(rs.next()){
			return(rs.getString(1));
		}else{
			return("");
		}
	}catch(Exception e){
		System.out.println(e);
	}
	return null;
}
public static boolean removeRFID(){
	try{
		String query = "delete from rfid";
		boolean status = DbHelper.executeUpdate(query);
		return status;
	}catch(Exception e){
		System.out.println(e);
	}
	return false;
}*/
}
