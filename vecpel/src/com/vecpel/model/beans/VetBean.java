package com.vecpel.model.beans;

import java.io.File;

public class VetBean {

	private String vetId;	
	private String vetProfID;	
	private File vetPhoto;	
	private int vetScore;
	private ProfileBean vetProfileBean;
	private String vetQualification;
	private String vetSpecialization;
	/**
	 * @return the vetId
	 */
	public String getVetId() {
		return vetId;
	}
	/**
	 * @param vetId the vetId to set
	 */
	public void setVetId(String vetId) {
		this.vetId = vetId;
	}
	/**
	 * @return the vetProfID
	 */
	public String getVetProfID() {
		return vetProfID;
	}
	/**
	 * @param vetProfID the vetProfID to set
	 */
	public void setVetProfID(String vetProfID) {
		this.vetProfID = vetProfID;
	}
	/**
	 * @return the vetPhoto
	 */
	public File getVetPhoto() {
		return vetPhoto;
	}
	/**
	 * @param vetPhoto the vetPhoto to set
	 */
	public void setVetPhoto(File vetPhoto) {
		this.vetPhoto = vetPhoto;
	}
	/**
	 * @return the vetScore
	 */
	public int getVetScore() {
		return vetScore;
	}
	/**
	 * @param vetScore the vetScore to set
	 */
	public void setVetScore(int vetScore) {
		this.vetScore = vetScore;
	}
	/**
	 * @return the vetProfileBean
	 */
	public ProfileBean getVetProfileBean() {
		return vetProfileBean;
	}
	/**
	 * @param vetProfileBean the vetProfileBean to set
	 */
	public void setVetProfileBean(ProfileBean vetProfileBean) {
		this.vetProfileBean = vetProfileBean;
	}
	/**
	 * @return the vetQualification
	 */
	public String getVetQualification() {
		return vetQualification;
	}
	/**
	 * @param vetQualification the vetQualification to set
	 */
	public void setVetQualification(String vetQualification) {
		this.vetQualification = vetQualification;
	}
	/**
	 * @return the vetSpecialization
	 */
	public String getVetSpecialization() {
		return vetSpecialization;
	}
	/**
	 * @param vetSpecialization the vetSpecialization to set
	 */
	public void setVetSpecialization(String vetSpecialization) {
		this.vetSpecialization = vetSpecialization;
	}
	
	@Override
	public String toString() {
		
		return this.getVetId() + " :: " + getVetProfileBean().getFirstName() + " " + getVetProfileBean().getFirstName();
	}
	
}
