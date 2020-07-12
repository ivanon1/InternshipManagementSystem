package edu.unlv.mis768.ims.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection extends DBUtils{

	/**
	 * Close existing DB Connection and create DB with the required tables
	 * @param args
	 */
    public static void main(String[] args) {

        try {
            // Create a connection to the database.
            Connection conn = 	DBUtils.getBaseDBConnection();
            
            // Create the database. If the database already exists, drop it.
            createDataBase(conn);
            conn.close();

            // Create a connection to the database and to the IMS database
            Connection conn2 = DBUtils.getDBConnection();

            // Build the IMS user account table.
            buildUserAccountTable(conn2);

            // Build the Internship table.
            buildInternshipTable(conn2);

            // Build the Internship History table.
            buildInternshipApplicationHistoryTable(conn2);

            // Close the connection.
            conn2.close();
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The createDatabase method creates the DB. If the DB is already existed, drop the DB first.
     */

    public static void createDataBase(Connection conn) {
        System.out.println("Checking for existing database.");

        try {
            Statement stmt = conn.createStatement();

            // Drop the existing database
            try {
                stmt.executeUpdate("Drop DATABASE InternshipManagementSystem");
            } catch (SQLException ex) {
                // No need to report an error.
                // The database did not exist.
            }
            // Create a new database
            try {
                stmt.execute("Create DATABASE InternshipManagementSystem");
                System.out.println("Database InternshipManagementSystem created.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The database did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildUserAccountTable method creates the
     * USER_ACCOUNT table and adds some rows to it.
     */
    public static void buildUserAccountTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE USER_ACCOUNT (" +
                    "ID INT NOT NULL AUTO_INCREMENT," +
                    "ACCOUNT_TYPE varchar(9) NOT NULL," +
                    "NAME varchar(255) NOT NULL," +
                    "ADDRESS varchar(255)," +
                    "EMAIL varchar(40)," +
                    "PHONE_NUMBER varchar(15)," +
                    "MAJOR varchar(20)," +
                    "DEPARTMENT varchar(20)," +
                    "USERNAME varchar(20)," +
                    "PASSWORD varchar(20)," +
                    "PRIMARY KEY(ID));");

             // Insert row #1.
             stmt.execute("INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD) VALUES ('Student','Jay Shah','225 S Stephanie St.','shahj1@unlv.nevada.edu', '7025243827','MIS', 'MIS-UNLV','jay', 'jay')");
            
             // Insert row #2.
             stmt.execute("INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD)  VALUES ('Employer','Foram Shah','225 S Stephanie St.','shahf1@unlv.nevada.edu', '7025203827','MIS', 'MIS-UNLV','foram', 'foram')");

             // Insert row #3.
             stmt.execute("INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD)  VALUES ('Professor','Sulata Shah','225 S Stephanie St.','shahs1@unlv.nevada.edu', '7025213827','MIS', 'MIS-UNLV','sulata', 'sulata')");
             
             // Insert row #4.
             stmt.execute("INSERT INTO USER_ACCOUNT(ACCOUNT_TYPE,NAME,ADDRESS,EMAIL,PHONE_NUMBER,MAJOR,DEPARTMENT,USERNAME,PASSWORD)  VALUES ('Staff','Asit Shah','225 S Stephanie St.','shaha1@unlv.nevada.edu', '7025223827','MIS', 'MIS-UNLV','asit', 'asit')");
          
            System.out.println("User Account table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildInternshipTable method creates
     * the INTERNSHIP table.
     */

    public static void buildInternshipTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

           
            // Create the table.
            stmt.execute("CREATE TABLE INTERNSHIP " +
                    "( ID INT NOT NULL AUTO_INCREMENT," +
                    "JOB_TITLE varchar(20)," +
                    "POSITION_TYPE varchar(20)," +
                    "EMPLOYER varchar(40)," +
                    "POSITION_START_DATE DATE," +
                    "POSITION_END_DATE DATE," +
                    "GEOLOCATION varchar(20)," +
                    "MAJOR varchar(20)," +
                    "DEPARTMENT varchar(20)," +
                    "PAY FLOAT," +
                    "SEMESTER varchar(10)," +
                    "REFERENCE varchar(20)," +
                    "IS_VIEWABLE char(1)," +
                    "TOTAL_NUM_OF_POSITIONS INT," +
                    "TOTAL_NUM_OF_FILLED_POSITIONS INT," +
                    "CREATED_DATE_TIME DATETIME," +
                    "CREATED_BY_USERID INT NOT NULL," +
                    "LAST_UPDATED_DATE_TIME DATETIME," +
                    "LAST_UPDATED_BY_USERID INT NOT NULL," +
                    "PRIMARY KEY(ID)," +
                    "FOREIGN KEY (LAST_UPDATED_BY_USERID) REFERENCES USER_ACCOUNT(ID));");

//            // Insert row #1.
//            stmt.execute("INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,"
//            		+ "REFERENCE,IS_VIEWABLE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_BY_USERID,LAST_UPDATED_BY_USERID,CREATED_DATE_TIME,LAST_UPDATED_DATE_TIME) "
//            		+ "VALUES ('JOB1','POS1','EMP1','2019-05-07', '2019-05-30','INDIA', 'MS','MIS', '18','SEM1','REF1','Y',10,0,(SELECT id FROM user_account  WHERE username='jay'),(SELECT id FROM user_account  WHERE username='jay'),DATETIME,DATETIME)");
//           
//            // Insert row #2.
//            stmt.execute("INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,"
//            		+ "REFERENCE,IS_VIEWABLE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_BY_USERID,LAST_UPDATED_BY_USERID,CREATED_DATE_TIME,LAST_UPDATED_DATE_TIME) "
//            		+ "VALUES ('JOB1','POS1','EMP1','2019-05-07', '2019-05-30','INDIA', 'MS','MIS', '18','SEM1','REF1','Y',10,0,(SELECT id FROM user_account  WHERE username='jay'),(SELECT id FROM user_account  WHERE username='jay'),DATETIME,DATETIME)");
//           
//            // Insert row #3.
//            stmt.execute("INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,"
//            		+ "REFERENCE,IS_VIEWABLE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_BY_USERID,LAST_UPDATED_BY_USERID,CREATED_DATE_TIME,LAST_UPDATED_DATE_TIME) "
//            		+ "VALUES ('JOB1','POS1','EMP1','2019-05-07', '2019-05-30','INDIA', 'MS','MIS', '18','SEM1','REF1','Y',10,0,(SELECT id FROM user_account  WHERE username='jay'),(SELECT id FROM user_account  WHERE username='jay'),DATETIME,DATETIME)");
//           
//            // Insert row #4.
//            stmt.execute("INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,"
//            		+ "REFERENCE,IS_VIEWABLE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_BY_USERID,LAST_UPDATED_BY_USERID,CREATED_DATE_TIME,LAST_UPDATED_DATE_TIME) "
//            		+ "VALUES ('JOB1','POS1','EMP1','2019-05-07', '2019-05-30','INDIA', 'MS','MIS', '18','SEM1','REF1','Y',10,0,(SELECT id FROM user_account  WHERE username='jay'),(SELECT id FROM user_account  WHERE username='jay'),DATETIME,DATETIME)");
//           
//            // Insert row #5.
//            stmt.execute("INSERT INTO INTERNSHIP(JOB_TITLE,POSITION_TYPE,EMPLOYER,POSITION_START_DATE,POSITION_END_DATE,GEOLOCATION,MAJOR,DEPARTMENT,PAY,SEMESTER,"
//            		+ "REFERENCE,IS_VIEWABLE,TOTAL_NUM_OF_POSITIONS,TOTAL_NUM_OF_FILLED_POSITIONS,CREATED_BY_USERID,LAST_UPDATED_BY_USERID,CREATED_DATE_TIME,LAST_UPDATED_DATE_TIME) "
//            		+ "VALUES ('JOB1','POS1','EMP1','2019-05-07', '2019-05-30','INDIA', 'MS','MIS', '18','SEM1','REF1','Y',10,0,(SELECT id FROM user_account  WHERE username='jay'),(SELECT id FROM user_account  WHERE username='jay'),DATETIME,DATETIME)");
//           
            
            System.out.println("Internship table created.");
        } catch (

        SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildInternshipApplicationHistoryTable method creates
     * the INERNSHIP_APPLICATION_HISTORY table.
     */

    public static void buildInternshipApplicationHistoryTable(Connection conn) {
        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE INTERNSHIP_APPLICATION_HISTORY " +
                    "( ID INT NOT NULL AUTO_INCREMENT," +
                    "INTERNSHIP_ID INT NOT NULL," +
                    "APPLICANT_ID INT NOT NULL," +
                    "INTERNSHIP_APPLICATION_STATUS varchar(10)," +
                    "PRIMARY KEY(ID)," +
                    "FOREIGN KEY (INTERNSHIP_ID) REFERENCES USER_ACCOUNT(ID)," +
                    "FOREIGN KEY (APPLICANT_ID) REFERENCES USER_ACCOUNT(ID));");

            System.out.println("Internship application history table created.");
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}