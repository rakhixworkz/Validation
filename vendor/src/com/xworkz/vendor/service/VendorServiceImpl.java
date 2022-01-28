package com.xworkz.vendor.service;

import com.xworkz.vendor.dao.VendorDAO;
import com.xworkz.vendor.entity.VendorEntity;

public class VendorServiceImpl implements VendorService {
	private VendorDAO dao;

	public VendorServiceImpl(VendorDAO dao) {
		this.dao = dao;
	}

	@Override
	public boolean validateAndSave(VendorEntity entity) {
		boolean valid = true;
		if (entity.getName() != null && entity.getName().length() >= 5 && entity.getName().length() <= 30) {
			valid = true;
		} else {
			System.out.println("Invalid User Name");
			valid = false;
			return valid;
		}
		if (entity.getCreatedBy() != null && entity.getCreatedBy().length() >= 5
				&& entity.getCreatedBy().length() <= 30) {
			valid = true;
		} else {
			System.out.println("Invalid createdBy");
			valid = false;
			return valid;
		}
		if (entity.getEmail() != null && entity.getEmail().contains("@") || entity.getEmail().contains(".com")
				|| entity.getEmail().contains(".in") || entity.getEmail().contains(".org")) {
			valid = true;
		} else {
			System.out.println("Invalid Email");
			valid = false;
			return valid;
		}
		if (entity.getLoginName() != null && entity.getLoginName().length() >= 8
				&& entity.getLoginName().length() <= 12) {
			valid = true;
		} else {
			System.out.println("Invalid Login Name");
			valid = false;
			return valid;
		}
		if (entity.getAddress() != null && entity.getAddress().length() >= 30 && entity.getAddress().length() <= 100) {
			valid = true;
		} else {
			System.out.println("Invalid Address");
			valid = false;
			return valid;
		}
		if (entity.getGstNo() != null && entity.getGstNo().length() >= 12 && entity.getGstNo().length() <= 15) {
			valid = true;
		} else {
			System.out.println("Invalid GST Number");
			valid = false;
			return valid;
		}
		if (entity.getPassword().length() >= 8 && entity.getPassword().length() <= 36 && entity.getPassword() != null) {
			valid = true;
		} else {
			System.out.println("Invalid Password");
			valid = false;
			return valid;
		}

		if (valid)
			dao.save(entity);
		return valid;
	}

	@Override
	public boolean validateAndLogin(String loginName, String password) {
		boolean find = true;
		if (loginName != null && loginName.length() >= 8 && loginName.length() <= 12) {
			find = true;

		} else {
			System.out.println("Invalid login name");
			find = false;
			return find;
		}
		if (password != null && password.length() >= 8 && password.length() <= 36) {
			find = true;
		} else {
			System.out.println("invalid password");
			find = false;
			return find;
		}
		if (find) {
			boolean value = dao.findLogin(loginName, password);
			System.out.println("login name is matching:" + value);
			return value;
		}

		return find;
	}

	@Override
	public void validateAndChangePassword(String email, String newPassword) {
		boolean valid = true;
		if (newPassword != null && newPassword.length() >= 8 && newPassword.length() <= 36 && email != null
				&& email.length() >= 8 && email.length() <= 56) {
			valid = true;
		} else {
			System.out.println("Invalid email");
			valid = false;
		}
		if (valid) {
			boolean val = dao.findByEmail(email);
			if (val) {
				System.out.println("valid email");
				dao.updatePasswordByEmail(email, newPassword);
			}
			System.out.println("upadted password:" + val);
		} else {
			System.out.println("invalid email"+email);
		}
//		if(valid) {
//			dao.updatePasswordByEmail(email, newPassword);
//			System.out.println("Updated");
//		}

	}

}
