package edu.unlv.mis768.ims.conn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.unlv.mis768.ims.beans.Employer;
import edu.unlv.mis768.ims.beans.Internship;
import edu.unlv.mis768.ims.beans.InternshipApplication;
import edu.unlv.mis768.ims.beans.Professor;
import edu.unlv.mis768.ims.beans.Staff;
import edu.unlv.mis768.ims.beans.Student;
import edu.unlv.mis768.ims.beans.User;

public class DBAccess{
		
	 /**
     * Create user account with ACCOUNT_TYPE as a student
     * 
     * @param user
     * @throws SQLException
     */
    public static void createUserAccount(Student student) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD) "
        		+ "VALUES (?,?,?,?,?,?,?,?,?)";

        //set the values of parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, student.getAccountType());
        pstm.setString(2, student.getName());
        pstm.setString(3, student.getAddress());
        pstm.setString(4, student.getEmail());
        pstm.setString(5, student.getPhoneNumber());
        pstm.setString(6, student.getMajor());
        pstm.setString(7, student.getDepartment());
        pstm.setString(8, student.getUsername());
        pstm.setString(9, student.getPassword());

        //execute update query to create the account
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }

    /**
     * Create user account with ACCOUNT_TYPE as a staff
     * 
     * @param user
     * @throws SQLException
     */
    public static void createUserAccount(Staff staff) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD) "
        		+ "VALUES (?,?,?,?,?,?,?,?,?)";

        //set the values of parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, staff.getAccountType());
        pstm.setString(2, staff.getName());
        pstm.setString(3, staff.getAddress());
        pstm.setString(4, staff.getEmail());
        pstm.setString(5, staff.getPhoneNumber());
        pstm.setString(6, null);
        pstm.setString(7, staff.getDepartment());
        pstm.setString(8, staff.getUsername());
        pstm.setString(9, staff.getPassword());

        //execute update query to create the account
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    
    /**
     * Create user account with ACCOUNT_TYPE as a professor
     * 
     * @param user
     * @throws SQLException
     */
    public static void createUserAccount(Professor professor) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD) "
        		+ "VALUES (?,?,?,?,?,?,?,?,?)";

        //set the values of parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, professor.getAccountType());
        pstm.setString(2, professor.getName());
        pstm.setString(3, professor.getAddress());
        pstm.setString(4, professor.getEmail());
        pstm.setString(5, professor.getPhoneNumber());
        pstm.setString(6, null);
        pstm.setString(7, professor.getDepartment());
        pstm.setString(8, professor.getUsername());
        pstm.setString(9, professor.getPassword());

        //execute update query to create the account
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    
    /**
     * Create user account with ACCOUNT_TYPE as an employer
     * 
     * @param user
     * @throws SQLException
     */
    public static void createUserAccount(Employer employer) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD) "
        		+ "VALUES (?,?,?,?,?,?,?,?,?)";

        //set the values of parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, employer.getAccountType());
        pstm.setString(2, employer.getName());
        pstm.setString(3, employer.getAddress());
        pstm.setString(4, employer.getEmail());
        pstm.setString(5, employer.getPhoneNumber());
        pstm.setString(6, null);
        pstm.setString(7, null);
        pstm.setString(8, employer.getUsername());
        pstm.setString(9, employer.getPassword());

        //execute update query to create the account
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    
    /**
     * Update user account details with Name , address, phone number, major and department for account type Student
     * 
     * @param user
     * @throws SQLException
     */
    public static void updateUserAccount(Student student) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE USER_ACCOUNT Set NAME = ?, ADDRESS =?, EMAIL =?, PHONE_NUMBER =?,  MAJOR =? , DEPARTMENT=? WHERE USERNAME = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, student.getName());
        pstm.setString(2, student.getAddress());
        pstm.setString(3, student.getEmail());
        pstm.setString(4, student.getPhoneNumber());
        pstm.setString(5, student.getMajor());
        pstm.setString(6, student.getDepartment());
        pstm.setString(7, student.getUsername());

        //execute the query
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }

    /**
     * Update user account details with Name , address, phone number, major and department for account type staff
     * 
     * @param user
     * @throws SQLException
     */
    public static void updateUserAccount(Staff staff) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE USER_ACCOUNT Set NAME = ?, ADDRESS =?, EMAIL =?, PHONE_NUMBER =?, DEPARTMENT=? WHERE USERNAME = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, staff.getName());
        pstm.setString(2, staff.getAddress());
        pstm.setString(3, staff.getEmail());
        pstm.setString(4, staff.getPhoneNumber());
        pstm.setString(5, staff.getDepartment());
        pstm.setString(6, staff.getUsername());

        //execute the query
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    
    /**
     * Update user account details with Name , address, phone number, major and department for account type professor
     * 
     * @param user
     * @throws SQLException
     */
    public static void updateUserAccount(Professor professor) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE USER_ACCOUNT Set NAME = ?, ADDRESS =?, EMAIL =?, PHONE_NUMBER =?, DEPARTMENT=? WHERE USERNAME = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, professor.getName());
        pstm.setString(2, professor.getAddress());
        pstm.setString(3, professor.getEmail());
        pstm.setString(4, professor.getPhoneNumber());
        pstm.setString(5, professor.getDepartment());
        pstm.setString(6, professor.getUsername());

        //execute the query
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    
    /**
     * Update user account details with Name , address, phone number, major and department for account type Employer
     * 
     * @param user
     * @throws SQLException
     */
    public static void updateUserAccount(Employer employer) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE USER_ACCOUNT Set NAME = ?, ADDRESS =?, EMAIL =?, PHONE_NUMBER =? WHERE USERNAME = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, employer.getName());
        pstm.setString(2, employer.getAddress());
        pstm.setString(3, employer.getEmail());
        pstm.setString(4, employer.getPhoneNumber());
        pstm.setString(5, employer.getUsername());

        //execute the query
        pstm.executeUpdate();
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
    }
    /**
     * This method finds the user by id to return the matching user account 
     * 
     * @param id
     * @return user
     * @throws SQLException
     */
    public static Student findUser(int id) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare db query statement
        String sql = "Select MAJOR, DEPARTMENT from USER_ACCOUNT "//
                + " where id = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        
        //execute the query and store the result set
        ResultSet rs = pstm.executeQuery();

        //store result set into the user object
        if (rs.next()) {
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            Student student = new Student();
            student.setMajor(major);
            student.setDepartment(department);
            return student;
        }
        
        pstm.close();
        //close the db connection
        DBUtils.closeDBConnection(conn);
        return null;
    }

    /**
     * This method finds the user by username to return the matching user account
     * 
     * @param username
     * @return user
     * @throws SQLException
     */
    public static User findUser(String username) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "Select ACCOUNT_TYPE, NAME, ADDRESS, PHONE_NUMBER, EMAIL, MAJOR, DEPARTMENT from USER_ACCOUNT "//
                + " where username = ?";

        //set the values of parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        
       //execute the query and store the results
        ResultSet rs = pstm.executeQuery();
        
        //store result set into the user object
        if (rs.next()) {
        	String accountType = rs.getString("ACCOUNT_TYPE");
        	String name = rs.getString("NAME");
        	String address = rs.getString("ADDRESS");
        	String phoneNumber = rs.getString("PHONE_NUMBER");
        	String email = rs.getString("EMAIL");
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            
            //store result set into the user object based on account type
            if(accountType.equalsIgnoreCase("student")) {
            	Student student = new Student();
	            student.setName(name);
	            student.setAddress(address);
	            student.setPhoneNumber(phoneNumber);
	            student.setEmail(email);
	            student.setMajor(major);
	            student.setDepartment(department);
	            return student;
            }
            
            if(accountType.equalsIgnoreCase("staff")) {
            	Staff staff = new Staff();
	            staff.setName(name);
	            staff.setAddress(address);
	            staff.setPhoneNumber(phoneNumber);
	            staff.setEmail(email);
	            staff.setDepartment(department);
	            return staff;
            }
            
            if(accountType.equalsIgnoreCase("professor")) {
            	Professor professor = new Professor();
	            professor.setName(name);
	            professor.setAddress(address);
	            professor.setPhoneNumber(phoneNumber);
	            professor.setEmail(email);
	            professor.setDepartment(department);
	            return professor;
            }
            
            if(accountType.equalsIgnoreCase("employer")) {
            	Employer employer = new Employer();
	            employer.setName(name);
	            employer.setAddress(address);
	            employer.setPhoneNumber(phoneNumber);
	            employer.setEmail(email);
	            return employer;
            }
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        return null;
    }
    /**
     * This method finds the user by username and password to return the matching user account
     *  
     * @param username
     * @param password
     * @return user
     * @throws SQLException
     */
    public static User findUser(String username, String password) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	
    	//prepare query statement
        String sql = "Select USERNAME, PASSWORD, ACCOUNT_TYPE from USER_ACCOUNT "//
                + " where USERNAME = ? and PASSWORD = ?";

        //set the values of parameter in query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        
        //execute the query and store result into the result set
        ResultSet rs = pstm.executeQuery();

        //store result set into the user object
        if (rs.next()) {
            String accountType = rs.getString("ACCOUNT_TYPE");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setAccountType(accountType);
            return user;
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        return null;
    }
    
    /**
     * Add internship record to the internship table
     * 
     * @param internship
     * @param username
     * @throws SQLException
     */
    public static void addInternship(Internship internship, String username) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	
    	//prepare query statement
        String sql = "INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,"
                + "POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,REFERENCE,IS_VIEWABLE,"
                + "TOTAL_NUM_OF_POSITIONS, TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_DATE_TIME,CREATED_BY_USERID,"
                + "LAST_UPDATED_DATE_TIME,LAST_UPDATED_BY_USERID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),(Select id from USER_ACCOUNT where USERNAME = ?),NOW(),(Select id from USER_ACCOUNT where USERNAME = ?))";

        //set values of parameter in query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, internship.getJobTitle());
        pstm.setString(2, internship.getPositionType());
        pstm.setString(3, internship.getEmployer());
        pstm.setDate(4, (Date) internship.getPositionStartDate());
        pstm.setDate(5, (Date) internship.getPositionEndDate());
        pstm.setString(6, internship.getGeolocation());
        pstm.setString(7, internship.getMajor());
        pstm.setString(8, internship.getDepartment());
        pstm.setDouble(9, internship.getPay());
        pstm.setString(10, internship.getSemester());
        pstm.setString(11, internship.getReference());
        pstm.setString(12, "N");
        pstm.setInt(13, internship.getTotalNumOfPositions());
        pstm.setInt(14, 0);
        pstm.setString(15, username);
        pstm.setString(16, username);
        
        //execute the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
    }
    
/**
 * update existing internship record in internship table
 * 
 * @param internship
 * @param username
 * @throws SQLException
 */
    public static void updateInternship(Internship internship, String username) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE INTERNSHIP SET JOB_TITLE = ?,POSITION_TYPE = ?,EMPLOYER = ?,POSITION_START_DATE = ?,"
                + "POSITION_END_DATE = ?,GEOLOCATION = ?,MAJOR = ?,DEPARTMENT = ?,PAY = ?,SEMESTER= ?,REFERENCE = ?,"
                + "TOTAL_NUM_OF_POSITIONS = ?,"
                + "LAST_UPDATED_DATE_TIME = NOW(),LAST_UPDATED_BY_USERID = (Select id from USER_ACCOUNT where USERNAME = ?) WHERE ID = ?";

        //set values of parameter in query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, internship.getJobTitle());
        pstm.setString(2, internship.getPositionType());
        pstm.setString(3, internship.getEmployer());
        pstm.setDate(4, (Date) internship.getPositionStartDate());
        pstm.setDate(5, (Date) internship.getPositionEndDate());
        pstm.setString(6, internship.getGeolocation());
        pstm.setString(7, internship.getMajor());
        pstm.setString(8, internship.getDepartment());
        pstm.setDouble(9, internship.getPay());
        pstm.setString(10, internship.getSemester());
        pstm.setString(11, internship.getReference());
        pstm.setInt(12, internship.getTotalNumOfPositions());
        pstm.setString(13, username);
        pstm.setInt(14, internship.getId());
        
        //execute the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
    }    
    /**
     * fetch intenrship record by id and update it for number of filled positions
     * @param internshipId
     * @param username
     * @throws SQLException
     */
    public static void updateInternshipFilledPositions(int internshipId, String username) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();

    	//prepare the query
        String sql = "UPDATE INTERNSHIP SET TOTAL_NUM_OF_FILLED_POSITIONS = TOTAL_NUM_OF_FILLED_POSITIONS+1,"
                + "LAST_UPDATED_DATE_TIME = NOW(),LAST_UPDATED_BY_USERID = (Select id from USER_ACCOUNT where USERNAME = ?) WHERE ID = ?";

        //set values in parameter for query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setInt(2, internshipId);
        
        //execute the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);

    }


    /**
     * Filter existing internship record by id and Update it to make it viewable
     * 
     * @param isViewable
     * @param id
     * @param username
     * @throws SQLException
     */
    public static void makeInternshipViewable(String isViewable, int id, String username) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare query statement
        String sql = "UPDATE INTERNSHIP SET IS_VIEWABLE = ?,"                
                + "LAST_UPDATED_DATE_TIME = NOW(),LAST_UPDATED_BY_USERID = (Select id from USER_ACCOUNT where USERNAME = ?) WHERE ID = ?";

        //set values in parameter for the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, isViewable);
        pstm.setString(2, username);
        pstm.setInt(3, id);

        //run the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);

    }
  
    /**
     * Search all available internship records which are marked as viewable and position start date is greater than today's date. Search will filter the data based on entered filter criteria
     * 
     * @param pJobTitle
     * @param pPositionType
     * @param pEmployer
     * @param pGeolocation
     * @param pMajor
     * @param pDepartment
     * @param pSemester
     * @return list of internship records which are marked as viewable and position start date is greater than today's date
     * @throws SQLException
     */
    public static List<Internship> searchInternship(Internship internship) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	
    	//prepare the query statement
        String sql = "SELECT ID,JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,"
        		+ "GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,REFERENCE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS"
        		+ " FROM internship WHERE JOB_TITLE LIKE ? AND POSITION_TYPE LIKE ? AND EMPLOYER LIKE ? AND POSITION_START_DATE>=CURRENT_DATE()"
        		+ " and GEOLOCATION LIKE ? AND MAJOR LIKE ? AND DEPARTMENT LIKE ? and SEMESTER LIKE ? AND IS_VIEWABLE ='Y'";

        //get the values from the page for filters
        String pJobTitle = internship.getJobTitle();
        String pPositionType = internship.getPositionType();
        String pEmployer = internship.getEmployer();
        String pGeolocation = internship.getGeolocation();
        String pMajor = internship.getMajor();
        String pDepartment = internship.getDepartment();
        String pSemester = internship.getSemester();
        
        //set the values in parameter for the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, pJobTitle+"%");  
        pstm.setString(2, pPositionType+"%");
        pstm.setString(3, pEmployer+"%");
        pstm.setString(4, pGeolocation+"%");
        pstm.setString(5, pMajor+"%");
        pstm.setString(6, pDepartment+"%");
        pstm.setString(7, pSemester+"%");

        //execute the query 
        ResultSet rs = pstm.executeQuery();
        List<Internship> list = new ArrayList<Internship>();
        
        //store the query results into the result set
        while (rs.next()) {
        	int id = rs.getInt("ID");
            String jobTitle = rs.getString("JOB_TITLE");
            String positionType = rs.getString("POSITION_TYPE");
            String employer = rs.getString("EMPLOYER");
            Date positionStartDate = rs.getDate("POSITION_START_DATE");
            Date positionEndDate = rs.getDate("POSITION_END_DATE");
            String geolocation = rs.getString("GEOLOCATION");
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            Double pay = rs.getDouble("PAY");
            String semester = rs.getString("SEMESTER");
            String reference = rs.getString("REFERENCE");
            int totalNumOfPositions = rs.getInt("TOTAL_NUM_OF_POSITIONS");
            int totalNumOfFilledPositions = rs.getInt("TOTAL_NUM_OF_FILLED_POSITIONS");
            
            Internship internship2 = new Internship();
            internship2.setId(id);
            internship2.setJobTitle(jobTitle);
            internship2.setPositionType(positionType);
            internship2.setEmployer(employer);
            internship2.setPositionStartDate(positionStartDate);
            internship2.setPositionEndDate(positionEndDate);
            internship2.setGeolocation(geolocation);
            internship2.setMajor(major);
            internship2.setDepartment(department);
            internship2.setPay(pay);
            internship2.setSemester(semester);
            internship2.setReference(reference);
            internship2.setTotalNumOfPositions(totalNumOfPositions);
            internship2.setTotalNumOfFilledPositions(totalNumOfFilledPositions);

            list.add(internship2);
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        //return internship list matching with the filtered criteria
        return list;
    }

  /**
   * Get internship records which are created by logged in user
   * 
   * @param username
   * @return list of internship records created by logged in user
   * @throws SQLException
   */
    public static List<Internship> getInternshipByLoggedInUser(String username) throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare the query statement
        String sql = "SELECT ID,JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,"
                + "POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,REFERENCE,"
                + "TOTAL_NUM_OF_POSITIONS, TOTAL_NUM_OF_FILLED_POSITIONS FROM INTERNSHIP WHERE CREATED_BY_USERID = (Select id from USER_ACCOUNT where USERNAME = ?)";

        //set the values for parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);

        //execute the query and store the results into the resultset
        ResultSet rs = pstm.executeQuery();
        List<Internship> list = new ArrayList<Internship>();
        while (rs.next()) {
        	int id = rs.getInt("ID");
            String jobTitle = rs.getString("JOB_TITLE");
            String positionType = rs.getString("POSITION_TYPE");
            String employer = rs.getString("EMPLOYER");
            Date positionStartDate = rs.getDate("POSITION_START_DATE");
            Date positionEndDate = rs.getDate("POSITION_END_DATE");
            String geolocation = rs.getString("GEOLOCATION");
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            Double pay = rs.getDouble("PAY");
            String semester = rs.getString("SEMESTER");
            String reference = rs.getString("REFERENCE");
            int totalNumOfPositions = rs.getInt("TOTAL_NUM_OF_POSITIONS");
            int totalNumOfFilledPositions = rs.getInt("TOTAL_NUM_OF_FILLED_POSITIONS");

            Internship internship = new Internship();
            internship.setId(id);
            internship.setJobTitle(jobTitle);
            internship.setPositionType(positionType);
            internship.setEmployer(employer);
            internship.setPositionStartDate(positionStartDate);
            internship.setPositionEndDate(positionEndDate);
            internship.setGeolocation(geolocation);
            internship.setMajor(major);
            internship.setDepartment(department);
            internship.setPay(pay);
            internship.setSemester(semester);
            internship.setReference(reference);
            internship.setTotalNumOfPositions(totalNumOfPositions);
            internship.setTotalNumOfFilledPositions(totalNumOfFilledPositions);

            list.add(internship);
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        //return the list of internship records created by logged in user
        return list;
    }
    
   /**
    * Get internship record by id 
    * 
    * @param idValue
    * @return internship record matching with the provided internshipId
    * @throws SQLException
    */
    public static Internship getInternshipById(int idValue) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare the query statement
        String sql = "SELECT ID,JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,"
                + "POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,REFERENCE,"
                + "TOTAL_NUM_OF_POSITIONS, TOTAL_NUM_OF_FILLED_POSITIONS,IS_VIEWABLE  FROM INTERNSHIP WHERE ID = ?";

        //get values for parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idValue);

        //execute the query and store the results into result set
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
        	int id = rs.getInt("ID");
            String jobTitle = rs.getString("JOB_TITLE");
            String positionType = rs.getString("POSITION_TYPE");
            String employer = rs.getString("EMPLOYER");
            Date positionStartDate = rs.getDate("POSITION_START_DATE");
            Date positionEndDate = rs.getDate("POSITION_END_DATE");
            String geolocation = rs.getString("GEOLOCATION");
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            Double pay = rs.getDouble("PAY");
            String semester = rs.getString("SEMESTER");
            String reference = rs.getString("REFERENCE");
            int totalNumOfPositions = rs.getInt("TOTAL_NUM_OF_POSITIONS");
            int totalNumOfFilledPositions = rs.getInt("TOTAL_NUM_OF_FILLED_POSITIONS");
            String isViewable = rs.getString("IS_VIEWABLE");
            
            Internship internship = new Internship();
            internship.setId(id);
            internship.setJobTitle(jobTitle);
            internship.setPositionType(positionType);
            internship.setEmployer(employer);
            internship.setPositionStartDate(positionStartDate);
            internship.setPositionEndDate(positionEndDate);
            internship.setGeolocation(geolocation);
            internship.setMajor(major);
            internship.setDepartment(department);
            internship.setPay(pay);
            internship.setSemester(semester);
            internship.setReference(reference);
            internship.setTotalNumOfPositions(totalNumOfPositions);
            internship.setTotalNumOfFilledPositions(totalNumOfFilledPositions);
            internship.setIsViewable(isViewable);
            
            //return internship record matching with the provided internshipId
            return internship;
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        //return null if not internship records are found
        return null;
    }
   
    /**
     * Get all the internship records
     * @return list of internship records
     * @throws SQLException
     */
    public static List<Internship> getAllInternship() throws SQLException {
    	
    	//get db connection
    	Connection conn = DBUtils.getDBConnection();

    	//prepare the query statement
        String sql = "SELECT ID,JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,"
                + "POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,REFERENCE,"
                + "TOTAL_NUM_OF_POSITIONS, TOTAL_NUM_OF_FILLED_POSITIONS,IS_VIEWABLE FROM INTERNSHIP";

        //run the query and store the values in result list
        PreparedStatement pstm = conn.prepareStatement(sql);        
        ResultSet rs = pstm.executeQuery();
        List<Internship> list = new ArrayList<Internship>();
        while (rs.next()) {
        	int id = rs.getInt("ID");
            String jobTitle = rs.getString("JOB_TITLE");
            String positionType = rs.getString("POSITION_TYPE");
            String employer = rs.getString("EMPLOYER");
            Date positionStartDate = rs.getDate("POSITION_START_DATE");
            Date positionEndDate = rs.getDate("POSITION_END_DATE");
            String geolocation = rs.getString("GEOLOCATION");
            String major = rs.getString("MAJOR");
            String department = rs.getString("DEPARTMENT");
            Double pay = rs.getDouble("PAY");
            String semester = rs.getString("SEMESTER");
            String reference = rs.getString("REFERENCE");
            int totalNumOfPositions = rs.getInt("TOTAL_NUM_OF_POSITIONS");
            int totalNumOfFilledPositions = rs.getInt("TOTAL_NUM_OF_FILLED_POSITIONS");
            String isViewable = rs.getString("IS_VIEWABLE");

            Internship internship = new Internship();
            
            internship.setId(id);
            internship.setJobTitle(jobTitle);
            internship.setPositionType(positionType);
            internship.setEmployer(employer);
            internship.setPositionStartDate(positionStartDate);
            internship.setPositionEndDate(positionEndDate);
            internship.setGeolocation(geolocation);
            internship.setMajor(major);
            internship.setDepartment(department);
            internship.setPay(pay);
            internship.setSemester(semester);
            internship.setReference(reference);
            internship.setTotalNumOfPositions(totalNumOfPositions);
            internship.setTotalNumOfFilledPositions(totalNumOfFilledPositions);
            internship.setIsViewable(isViewable);

            list.add(internship);
        }
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
        //return the list of internship records
        return list;
    }
    
   /**
    * Insert record for internship application history. This method will be called when student applies for an internship
    * 
    * @param internshipId
    * @param applicationStatus
    * @param username
    * @throws SQLException
    */
    public static void insertInternshipApplicationHistory(int internshipId, String applicationStatus, String username) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	//prepare the query statement
        String sql = "INSERT INTO INTERNSHIP_APPLICATION_HISTORY (INTERNSHIP_ID,APPLICANT_ID,INTERNSHIP_APPLICATION_STATUS) VALUES (?,(Select id from USER_ACCOUNT where USERNAME = ?),?)";

        //get values for parameters in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, internshipId);
        pstm.setString(2, username);
        pstm.setString(3, applicationStatus);

        //execute the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
    }

   /**
    * Update internship application status for selected internshipId and applicantId
    * 
    * @param applicationStatus
    * @param internshipId
    * @param applicantId
    * @throws SQLException
    */
    public static void updateInternshipApplicationHistory(String applicationStatus, int internshipId, int applicantId) throws SQLException {

    	//get db connection
    	Connection conn = DBUtils.getDBConnection();
    	
    	//prepare the query statement
        String sql = "UPDATE INTERNSHIP_APPLICATION_HISTORY Set INTERNSHIP_APPLICATION_STATUS = ? WHERE INTERNSHIP_ID= ? AND APPLICANT_ID = ?";

        //set the values for parameter in the query
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, applicationStatus);
        pstm.setInt(2, internshipId);
        pstm.setInt(3, applicantId);
        
        //execute the query
        pstm.executeUpdate();
        pstm.close();
        //close db connection
        DBUtils.closeDBConnection(conn);
    }

    
 /**
  * Get all internship application records by status 'Applied'
  * 
  * @return list of internship applicaiton records for which status is 'applied'
  * @throws SQLException
  */
     public static List<InternshipApplication> getInternshipApplicationHistoryByStatus() throws SQLException {

    	 //get db connection
    	 Connection conn = DBUtils.getDBConnection();
    	 //prepare the query statement
         String sql = "SELECT * FROM INTERNSHIP_APPLICATION_HISTORY WHERE INTERNSHIP_APPLICATION_STATUS = 'APPLIED'";

         //set values for parameters in the query
         PreparedStatement pstm = conn.prepareStatement(sql);
         
         //run the query and store the values in result set
         ResultSet rs = pstm.executeQuery();
         List<InternshipApplication> list = new ArrayList<InternshipApplication>();
         while (rs.next()) {
         	 int internshipId = rs.getInt("INTERNSHIP_ID");
         	 int applicantId = rs.getInt("APPLICANT_ID");
             String applicationStatus = rs.getString("INTERNSHIP_APPLICATION_STATUS");

             InternshipApplication internshipApplication = new InternshipApplication();
             
             internshipApplication.setInternshipId(internshipId);
             internshipApplication.setApplicantId(applicantId);            
             internshipApplication.setInternshipApplicationStatus(applicationStatus);

             list.add(internshipApplication);
         }
         pstm.close();
         //close db connection
         DBUtils.closeDBConnection(conn);
         //get list of internship application history by status 'applied'
         return list;

     }
     
   /**
    * Get all internship application history by username
    * 
    * @return list of internship applications
    * @throws SQLException
    */
       public static List<InternshipApplication> getInternshipApplicationHistory(String username) throws SQLException {

    	   //get db connection
    	   Connection conn = DBUtils.getDBConnection();
    	   //prepare the query statement
           String sql = "SELECT * FROM INTERNSHIP_APPLICATION_HISTORY WHERE APPLICANT_ID = (Select id from USER_ACCOUNT where USERNAME = ?)";

           //execute the query and store results into the result set
           PreparedStatement pstm = conn.prepareStatement(sql);
           pstm.setString(1, username);
           
           ResultSet rs = pstm.executeQuery();
           List<InternshipApplication> list = new ArrayList<InternshipApplication>();
           while (rs.next()) {
           	 int internshipId = rs.getInt("INTERNSHIP_ID");
           	 int applicantId = rs.getInt("APPLICANT_ID");
               String applicationStatus = rs.getString("INTERNSHIP_APPLICATION_STATUS");

               InternshipApplication internshipApplication = new InternshipApplication();
               
               internshipApplication.setInternshipId(internshipId);
               internshipApplication.setApplicantId(applicantId);            
               internshipApplication.setInternshipApplicationStatus(applicationStatus);

               list.add(internshipApplication);
           }
           pstm.close();
           //close db connection
           DBUtils.closeDBConnection(conn);
           //return list of internship applications
           return list;

       }
}