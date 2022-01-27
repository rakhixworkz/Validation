package com.xworkz.registration;

import com.xworkz.registration.dao.RegistrationDAO;
import com.xworkz.registration.dao.RegistrationDAOImpl;
import com.xworkz.registration.entity.RegistrationEntity;
import com.xworkz.registration.service.RegistrationService;
import com.xworkz.registration.service.RegistrationServiceImpl;

public class RegistrationScanner {

	public static void main(String[] args) {
		RegistrationEntity registrationEntity=new RegistrationEntity("rakhik","rakhixworkz@gmail.com","45678867","Munger","India",9123455670l,true);
		RegistrationDAO dao=new RegistrationDAOImpl();
		RegistrationService service=new RegistrationServiceImpl(dao);
		service.validateAndSave(registrationEntity);
	}

}
