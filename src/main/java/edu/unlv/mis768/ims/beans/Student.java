package edu.unlv.mis768.ims.beans;

public class Student extends User{

	//declare variables	
	private String major, department;
	 
	 
	//no-parameter constructor	 
	public Student() {
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
    public Student(String name, String address, String email, String phoneNumber, String accountType, String username,
			String password, String major, String department) {
		super(name,address,email,phoneNumber,accountType,username,password);
		this.major = major;
		this.department= department;
	}

    /**
     * get major for user 
     * @return major
     */
    public String getMajor() {
        return major;
    }

    /**
     * set major for user
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
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
