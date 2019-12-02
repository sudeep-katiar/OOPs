package com.blblz.clinique.model;

public class DoctorDetails {
	private String doctorName;
	private String doctorId;
	private String specialization;
	private String availability;
	private long numberOfPatients;

	public long getNumberOfPatients() {
		return numberOfPatients;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public void setNumberOfPatients(long numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}

}
