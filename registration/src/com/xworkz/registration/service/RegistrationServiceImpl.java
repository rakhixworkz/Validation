package com.xworkz.registration.service;

import com.xworkz.registration.dao.RegistrationDAO;
import com.xworkz.registration.entity.RegistrationEntity;

public class RegistrationServiceImpl implements RegistrationService{
	private RegistrationDAO dao;
	public RegistrationServiceImpl(RegistrationDAO dao) {
		this.dao=dao;
	}
	@Override
	public boolean validateAndSave(RegistrationEntity entity) {
		boolean valid=true;
		if(entity.getUserName().length()>=6 &&
				entity.getUserName().length()<=25 && 
				entity.getUserName()!=null) {
			valid=true;
		}else {
			System.out.println("Invalid UserName");
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
		if(String.valueOf(entity.getMobileNumber()).length()==10) {
			valid=true;
		}else {
			System.out.println("Invalid Mobile Number");
			valid=false;
			return valid;
		}
		if(entity.getCity().length()>=3 &&
				entity.getCity().length()<=56 &&
				entity.getCity()!=null) {
			valid=true;
		}else {
			System.out.println("Invalid City");
			valid=false;
			return valid;
		}
		if(entity.getCountry().length()>=3 && 
				entity.getCountry().length()<=56 && 
				entity.getCountry()!=null) {
			valid=true;
		}else {
			System.out.println("Invalid Country");
			valid=false;
			return valid;
		}
		if(valid)dao.save(entity);
		return valid;
	}

}
