package edu.unlv.mis768.ims.beans;

public class Employer extends User{
	
	//no-parameter constructor	 
	public Employer() {
		//do nothing
	}
		 
	/**
	 * parameterized constructor
	 * @param name
	 * @param address
	 * @param email
	 * @param phoneNumber
	 * @param accountType
	 * @param username
	 * @param password
	 * @param major
	 * @param department
	 */
    public Employer(String name, String address, String email, String phoneNumber, String accountType, String username,
			String password, String major, String department) {
		super(name,address,email,phoneNumber,accountType,username,password);		
	}

}
