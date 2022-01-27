package com.xworkz.vendor.service;

import com.xworkz.vendor.dao.VendorDAO;
import com.xworkz.vendor.entity.VendorEntity;

public class VendorServiceImpl implements VendorService{
	private VendorDAO dao;
	public VendorServiceImpl(VendorDAO dao) {
		this.dao=dao;
	}
	@Override
	public boolean validateAndSave(VendorEntity entity) {
		boolean valid=true;
		if(entity.getName()!=null &&
				entity.getName().length()>=5 &&
				entity.getName().length()<=30) {
			valid=true;
		}else {
			System.out.println("Invalid User Name");
			valid=false;
			return valid;
		}
		if(entity.getCreatedBy()!=null &&
				entity.getCreatedBy().length()>=5 &&
				entity.getCreatedBy().length()<=30) {
			valid=true;
		}else {
			System.out.println("Invalid createdBy");
			valid=false;
			return valid;
		}
		if(entity.getEmail()!=null && 
				entity.getEmail().contains("@")&& 
				entity.getEmail().contains(".com")||
				entity.getEmail().contains(".in")||
				entity.getEmail().contains(".org")) {
			valid=true;
		}else {
			System.out.println("Invalid Email");
			valid=false;
			return valid;
		}
		if(entity.getLoginName()!=null && 
				entity.getLoginName().length()>=8 &&
				entity.getLoginName().length()<=12) {
			valid=true;
		}else {
			System.out.println("Invalid Login Name");
			valid=false;
			return valid;
		}
		if(entity.getAddress()!=null &&
				entity.getAddress().length()>=30 &&
				entity.getAddress().length()<=100) {
			valid=true;
		}else {
			System.out.println("Invalid Address");
			valid=false;
			return valid;
		}
		if(entity.getGstNo()!=null &&
				entity.getGstNo().length()>=12 &&
				entity.getGstNo().length()<=15) {
			valid=true;
		}else {
			System.out.println("Invalid GST Number");
			valid=false;
			return valid;
		}
		if(entity.getPassword().length()>=8 &&
				entity.getPassword().length()<=36 && 
				entity.getPassword()!=null) {
			valid=true;
		}else {
			System.out.println("Invalid Password");
			valid=false;
			return valid;
		}
		
		if(valid)dao.save(entity);
		return valid;
	}

}
