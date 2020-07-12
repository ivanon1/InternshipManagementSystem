package edu.unlv.mis768.ims.beans;

public class InternshipApplication {

	//declare variables
	private int internshipId, applicantId;
	private String internshipApplicationStatus;
	
	/**
	 * non-parameterized constructor
	 */
	public InternshipApplication() {
		//do nothing
	}	
	
	/**
	 * get internship id
	 * @return internship id
	 */
	public int getInternshipId() {
		return internshipId;
	}

	/**
	 * set internship id
	 * @param internshipId
	 */
	public void setInternshipId(int internshipId) {
		this.internshipId = internshipId;
	}

	/**
	 * get applicant id 
	 * @return applicant id
	 */
	public int getApplicantId() {
		return applicantId;
	}

	/**
	 * set applicant id
	 * @param applicantId
	 */
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	/**
	 * get intenrship application status
	 * @return internship application status
	 */
	public String getInternshipApplicationStatus() {
		return internshipApplicationStatus;
	}

	/**
	 * set internship application status
	 * @param internshipApplicationStatus
	 */
	public void setInternshipApplicationStatus(String internshipApplicationStatus) {
		this.internshipApplicationStatus = internshipApplicationStatus;
	}
}