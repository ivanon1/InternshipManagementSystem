package edu.unlv.mis768.ims.beans;

public class Professor extends User{

	//declare variables
	
	private String  department;
	
	//no-parameter constructor	 
	public Professor() {
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
	 * @param department
	 */
    public Professor(String name, String address, String email, String phoneNumber, String accountType, String username,
			String password, String department) {
		super(name,address,email,phoneNumber,accountType,username,password);
		this.department= department;
	}

    /**
     * get department for user
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * set department for the user
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

}
