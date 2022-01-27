package com.xworkz.vendor;

import java.time.LocalDateTime;


import com.xworkz.vendor.dao.VendorDAO;
import com.xworkz.vendor.dao.VendorDAOImpl;
import com.xworkz.vendor.entity.VendorEntity;
import com.xworkz.vendor.service.VendorService;
import com.xworkz.vendor.service.VendorServiceImpl;

public class VendorScanner {
	public static void main(String[] args) {
	VendorEntity vendorEntity=new VendorEntity("rakhikum","rakhi@gmail.com","9852kumari","234567abhjkhg","#211/AB munger line colony jamalpur Bihar","1345267888","xworkz",LocalDateTime.now(),"rakhi",LocalDateTime.now());
	VendorEntity vendorEntity1=new VendorEntity("rakhi","rakhi@gmail","kumari","234567","Bangalore","1345267888","xworkz",LocalDateTime.now(),"rakhi",LocalDateTime.now());
	VendorEntity vendorEntity2=new VendorEntity("rakhi","rakhi@gmail.com","kumari","234567","Bangalore","1345267888","xworkz",LocalDateTime.now(),"rakhi",LocalDateTime.now());
	VendorEntity vendorEntity3=new VendorEntity("rakhi","rakhi@gmail.com","Rakumari","234567","Bangalore","1345267888","xworkz",LocalDateTime.now(),"rakhi",LocalDateTime.now());
	VendorEntity vendorEntity4=new VendorEntity("rakhi","rakhi@gmail.com","Rakumari","234567","Bangalore","1345267888","xworkz",LocalDateTime.now(),"rakhi",LocalDateTime.now());
	VendorDAO dao=new VendorDAOImpl();
	VendorService vendorService=new VendorServiceImpl(dao);
	vendorService.validateAndSave(vendorEntity);
	vendorService.validateAndSave(vendorEntity1);
	vendorService.validateAndSave(vendorEntity2);
	vendorService.validateAndSave(vendorEntity3);
	vendorService.validateAndSave(vendorEntity4);
	
	}
}
