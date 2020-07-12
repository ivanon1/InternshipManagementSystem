package edu.unlv.mis768.ims.beans;

import java.util.Date;

public class Internship {

	//declare variables
	private int id, totalNumOfPositions,totalNumOfFilledPositions;
	private String jobTitle, positionType, employer,semester, reference,isViewable,geolocation, major, department;
    private Date positionStartDate, positionEndDate;
    private Double pay;

    /**
     * non-parameterized constructor
     */
    public Internship() {
    	//do nothing
    }

    /**
     * get internship id
     * @return internship id
     */
    public int getId() {
		return id;
	}

    /**
     * set internship id
     * @param id
     */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * get job title for internship
	 * @return job title for internship
	 */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * set job title for internship
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * get position type for internship
     * @return position type for internship
     */
    public String getPositionType() {
        return positionType;
    }

    /**
     * set position type for internship
     * @param positionType
     */
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    /**
     * get employer for internship
     * @return employer name for internship
     */
    public String getEmployer() {
        return employer;
    }

    /**
     * set employer for internship
     * @param employer
     */
    public void setEmployer(String employer) {
        this.employer = employer;
    }

    /**
     * get position start date for internship
     * @return position start date
     */
    public Date getPositionStartDate() {
        return positionStartDate;
    }

    /**
     * set position start date for internship
     * @param positionStartDate
     */
    public void setPositionStartDate(Date positionStartDate) {
        this.positionStartDate = positionStartDate;
    }

    /**
     * get position end date for internship
     * @return position end date
     */
    public Date getPositionEndDate() {
        return positionEndDate;
    }

    /**
     * set position end date for intenrship
     * @param positionEndDate
     */
    public void setPositionEndDate(Date positionEndDate) {
        this.positionEndDate = positionEndDate;
    }

    /**
     * get geo-location for internship
     * @return geo-location
     */
    public String getGeolocation() {
        return geolocation;
    }

    /**
     * set geo-location for internship
     * @param geolocation
     */
    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    /**
     * get major for internship
     * @return get major
     */
    public String getMajor() {
        return major;
    }

    /**
     * set major for internship
     * @param major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * get department for internship
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * set department from internship
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * get pay($) for internship
     * @return pay($)
     */
    public Double getPay() {
        return pay;
    }

    /**
     * set pay($) for internship
     * @param pay
     */
    public void setPay(Double pay) {
        this.pay = pay;
    }

    /**
     * get semester for internship
     * @return semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * set semester for internship
     * @param semester
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * get reference for internship
     * @return reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * set reference for internship
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
    * get isViewable flag for internship
    * @return isViewable
    */
    public String getIsViewable() {
		return isViewable;
	}

    /**
     * set isViewable flag for internship
     * @param isViewable
     */
	public void setIsViewable(String isViewable) {
		this.isViewable = isViewable;
	}

	/**
	 * get total number of positions for internship
	 * @return total number of positions
	 */
	public int getTotalNumOfPositions() {
        return totalNumOfPositions;
    }

	/**
	 * set total number of positions for internship
	 * @param totalNumOfPositions
	 */
    public void setTotalNumOfPositions(int totalNumOfPositions) {
        this.totalNumOfPositions = totalNumOfPositions;
    }

    /**
     * get total number of filled positions for intenrship
     * @return number of filled positions
     */
    public int getTotalNumOfFilledPositions() {
        return totalNumOfFilledPositions;
    }

    /**
     * set total number of filled positions for internship
     * @param totalNumOfFilledPositions
     */
    public void setTotalNumOfFilledPositions(int totalNumOfFilledPositions) {
        this.totalNumOfFilledPositions = totalNumOfFilledPositions;
    }

    /**
	 * The methods returns a string of the summary information about the object
	 */
	public String toString() {
		return jobTitle + "," + positionType + "," + employer + ","
				+ positionStartDate + "," + positionEndDate + "," + geolocation + ","
				+ major + "," + department + "," + pay + ","+ semester + ","
				+ reference + ","+ totalNumOfPositions + ","+totalNumOfFilledPositions;
	}
}