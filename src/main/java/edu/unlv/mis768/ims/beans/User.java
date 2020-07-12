package edu.unlv.mis768.ims.beans;

public class User {

    // initialize fields
    private String name, address, email, phoneNumber, accountType, username, password;

    // non-parameterized constructor
    public User() {
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
     */
    public User(String name, String address, String email, String phoneNumber, String accountType, String username,
			String password) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
		this.username = username;
		this.password = password;
	}
	
    /**
     * get name for the user
     * @return name
     */
    public String getName() {
        return name;
    }
    
	/**
	 * set name for the user
	 * @param name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get address for the user
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address for the user
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * get email for the user
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * set email for the user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get phone number for the user
     * @return phonenumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * set the phone number for the user
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * get account type for the user
     * @return account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * set account type for the user
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * get user name for the user
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username for the user name
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * get password for the user
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set password for the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}